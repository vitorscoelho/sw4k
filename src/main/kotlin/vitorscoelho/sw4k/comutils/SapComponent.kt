package vitorscoelho.sw4k.comutils

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.ComThread
import com.jacob.com.Dispatch
import com.jacob.com.Variant
import java.lang.Exception

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
            if (attribute is ByRefType<*>) {
                attribute.attributeToCall()
            } else {
                attribute
            }
        }
    }

    private fun populateByRefAttributes(attributes: Array<out Any>, attributesToCall: Array<Any>) {
        attributes.forEachIndexed { index, attribute ->
            if (attribute is ByRefType<*>) {
                attribute.populate(variant = attributesToCall[index])
            }
        }
    }

    fun callFunctionInt(name: String, vararg attributes: Any): Int {
        var value: Int? = null
        callFunction(name, { variant -> value = variant.int }, *attributes)
        return value!!
    }

    fun callFunctionDouble(name: String, vararg attributes: Any): Double {
        var value: Double? = null
        callFunction(name, { variant -> value = variant.double }, *attributes)
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