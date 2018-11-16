package vitorscoelho.sw4k.comutils

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.ComThread
import com.jacob.com.Dispatch
import com.jacob.com.SafeArray
import com.jacob.com.Variant
import java.lang.Exception

private class VariantSafeArray(val safeArray: SafeArray) : Variant() {
    init {
        this.putSafeArrayRef(safeArray)
    }

    companion object {
        private val VARIANT_DOUBLE_CODE: Int by lazy { Variant.VariantDouble.toInt() }
        private val VARIANT_INT_CODE: Int by lazy { Variant.VariantInt.toInt() }
        private val VARIANT_BOOLEAN_CODE: Int by lazy { Variant.VariantBoolean.toInt() }
        private val VARIANT_STRING_CODE: Int by lazy { Variant.VariantString.toInt() }

        fun fromCallAttribute(attribute: ByRefArray1D<*, *>): VariantSafeArray {
            val safeArray = when (attribute) {
                is DoubleArrayByRef -> SafeArray(VARIANT_DOUBLE_CODE, attribute.size()).apply {
                    attribute.forEachIndexed { index, value -> this.setDouble(index, value) }
                }
                is IntArrayByRef -> SafeArray(VARIANT_INT_CODE, attribute.size()).apply {
                    attribute.forEachIndexed { index, value -> this.setInt(index, value) }
                }
                is BooleanArrayByRef -> SafeArray(VARIANT_BOOLEAN_CODE, attribute.size()).apply {
                    attribute.forEachIndexed { index, value -> this.setBoolean(index, value) }
                }
                is StringArrayByRef -> SafeArray(VARIANT_STRING_CODE, attribute.size()).apply {
                    attribute.forEachIndexed { index, value -> this.setString(index, value) }
                }
                else -> throw IllegalArgumentException("Array Type ${attribute.javaClass} not supported.")
            }
            return VariantSafeArray(safeArray = safeArray)
        }

        fun populateArrayWithReturn(attribute: ByRefArray1D<*, *>, variant: VariantSafeArray) {
            when (attribute) {
                is DoubleArrayByRef -> attribute.value = variant.safeArray.toDoubleArray()
                is IntArrayByRef -> attribute.value = variant.safeArray.toIntArray()
                is BooleanArrayByRef -> attribute.value = variant.safeArray.toBooleanArray()
                is StringArrayByRef -> attribute.value = variant.safeArray.toStringArray()
                else -> throw IllegalArgumentException("Array Type ${attribute.javaClass} not supported.")
            }
        }
    }
}

interface SapComponent {
    val activeXComponentName: String

    private fun callFunction(name: String, callReturnFunction: (Variant) -> Unit, vararg attributes: Any) {
        ComThread.InitMTA()
        val activeXComponent = ActiveXComponent(activeXComponentName)
        return try {
            val attributesToCall = createAttributesToCall(attributes)
            val callReturn = Dispatch.call(activeXComponent, name, *attributesToCall)
            populateByRefAttributes(attributes, attributesToCall)
            callReturnFunction(callReturn)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        } finally {
            activeXComponent.safeRelease()
            ComThread.Release()
        }
    }

    private fun createAttributesToCall(attributes: Array<out Any>): Array<Any> {
        return Array(size = attributes.size) { index ->
            val attribute = attributes[index]
            when (attribute) {
                is ByRefArray1D<*, *> -> VariantSafeArray.fromCallAttribute(attribute = attribute)
                is ByRefType<*> -> Variant(attribute.value, true)
                else -> attribute
            }
        }
    }

    private fun populateByRefAttributes(attributes: Array<out Any>, attributesToCall: Array<Any>) {
        attributes.forEachIndexed { index, attribute ->
            if (attribute is ByRefArray1D<*, *>) {
                VariantSafeArray.populateArrayWithReturn(attribute = attribute, variant = attributesToCall[index] as VariantSafeArray)
            } else if (attribute is ByRefType<*>) {
                val variant = attributesToCall[index] as Variant
                when (attribute) {
                    is IntByRef -> attribute.value = variant.intRef
                    is StringByRef -> attribute.value = variant.stringRef
                    is DoubleByRef -> attribute.value = variant.doubleRef
                    is BooleanByRef -> attribute.value = variant.booleanRef
                    else -> throw IllegalArgumentException("|ByRefType| ${attribute.javaClass} not supported.")
                }
            }
        }
    }

    fun callFunctionInt(name: String, vararg attributes: Any): Int {
        var value: Int? = null
        callFunction(name, { variant -> value = variant.int }, *attributes)
        return value!!
    }

    fun callFunctionBoolean(name: String, vararg attributes: Any): Boolean {
        var value: Boolean? = null
        callFunction(name, { variant -> value = variant.boolean }, *attributes)
        return value!!
    }

    fun callFunctionString(name: String, vararg attributes: Any): String {
        var value: String? = null
        callFunction(name, { variant -> value = variant.string }, *attributes)
        return value!!
    }
}