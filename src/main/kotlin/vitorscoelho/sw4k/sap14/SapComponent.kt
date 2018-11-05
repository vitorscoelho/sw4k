package vitorscoelho.sw4k.sap14

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.Dispatch
import com.jacob.com.Variant

abstract class SapComponent internal constructor(activeXComponentName: String) {
    private val activeXComponent = ActiveXComponent(activeXComponentName)
    fun callFunction(name: String, vararg attributes: Any): Variant = Dispatch.call(activeXComponent, name, *attributes)
}