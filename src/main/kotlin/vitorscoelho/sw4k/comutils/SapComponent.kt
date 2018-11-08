package vitorscoelho.sw4k.comutils

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.Dispatch
import com.jacob.com.SafeArray
import com.jacob.com.Variant
import vitorscoelho.sw4k.sap14.enums.EnumWithSapId
import java.lang.IllegalArgumentException

private const val VARIANT_DOUBLE_CODE = Variant.VariantDouble.toInt()

private class VariantSafeArray(val safeArray: SafeArray) : Variant() {
    init {
        this.putSafeArrayRef(safeArray)
    }
}

abstract class SapComponent internal constructor(activeXComponentName: String) {
    private val activeXComponent = ActiveXComponent(activeXComponentName)
    fun callFunctionInt(name: String, vararg attributes: Any): Int = callFunction(name = name, attributes = *attributes).int
    private fun callFunction(name: String, vararg attributes: Any): Variant {
        val attributesToCall = Array(size = attributes.size) { index ->
            val attribute = attributes[index]
            when (attribute) {
                is DoubleArrayByRef -> {
                    val safeArray = SafeArray(VARIANT_DOUBLE_CODE, attribute.size).apply {
                        attribute.forEachIndexed { index, value -> this.setDouble(index, value) }
                    }
                    VariantSafeArray(safeArray)
                }
                is EnumWithSapId<*> -> attribute.sapId!!
                is SapEnumByteByRef<*> -> Variant(attribute.value.sapId, true)
                is ByRefType<*> -> Variant(attribute.value, true)
                else -> attribute
            }
        }
        val callReturn = Dispatch.call(activeXComponent, name, *attributesToCall)
        attributes.forEachIndexed { index, attribute ->
            if (attribute is ByRefArray1D<*>) {
                val safeArray1D = (attributesToCall[index] as VariantSafeArray).safeArray
                when (attribute) {
                    is DoubleArrayByRef -> {
                        (0 until attribute.size).forEach { indexAttribute -> attribute[indexAttribute] = safeArray1D.getDouble(indexAttribute) }
                    }
                    else -> throw IllegalArgumentException("|EnumArrayByRef| ${attribute.javaClass} not supported.")
                }
            } else if (attribute is ByRefType<*>) {
                val variant = attributesToCall[index] as Variant
                when (attribute) {
                    is SapEnumByteByRef<*> -> attribute.setValue(value = variant.intRef)
                    is IntByRef -> attribute.value = variant.intRef
                    is StringByRef -> attribute.value = variant.stringRef
//                    is EnumWithSapIdByteByRef<*>->attribute.value=variant//TODO O que retornar?? Tenho que arrumar uma maneira de retornar o Enum, não o sapId dele
                    else -> throw IllegalArgumentException("|ByRefType| ${attribute.javaClass} not supported.")
                }
            }
        }
        return callReturn
    }
}