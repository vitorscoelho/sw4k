package vitorscoelho.sw4k.comutils

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.ComThread
import com.jacob.com.Dispatch
import com.jacob.com.SafeArray
import com.jacob.com.Variant

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

abstract class SapComponent internal constructor(private val activeXComponentName: String) {
    fun callFunctionInt(name: String, vararg attributes: Any): Int {
        ComThread.InitMTA()
        val attributesToCall = Array(size = attributes.size) { index ->
            val attribute = attributes[index]
            when (attribute) {
                is ByRefArray1D<*, *> -> VariantSafeArray.fromCallAttribute(attribute = attribute)
                is ByRefType<*> -> Variant(attribute.value, true)
                else -> attribute
            }
        }
        val activeXComponent = ActiveXComponent(activeXComponentName)
        val callReturn = Dispatch.call(activeXComponent, name, *attributesToCall)
        attributes.forEachIndexed { index, attribute ->
            if (attribute is ByRefArray1D<*, *>) {
                VariantSafeArray.populateArrayWithReturn(attribute = attribute, variant = attributesToCall[index] as VariantSafeArray)
            } else if (attribute is ByRefType<*>) {
                val variant = attributesToCall[index] as Variant
                when (attribute) {
                    is IntByRef -> attribute.value = variant.intRef
                    is StringByRef -> attribute.value = variant.stringRef
                    else -> throw IllegalArgumentException("|ByRefType| ${attribute.javaClass} not supported.")
                }
            }
        }
        val intReturn = callReturn.int
        activeXComponent.safeRelease()
        ComThread.Release()
        return intReturn
    }
}