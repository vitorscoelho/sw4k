package vitorscoelho.sw4k

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.Dispatch
import org.junit.Test
import vitorscoelho.sw4k.comutils.dlls.LoaderJacobDll

class TentativaV20 {
    @Test
    fun testa() {
        LoaderJacobDll.load()
        val xl = ActiveXComponent("CSI.SAP2000.API.SapObject")
//        val xl=ActiveXComponent("Sap2000.SapObject")
        val xlo: Any = xl.`object`
        Dispatch.call(xl, "ApplicationStart")
        val sapModel = xl.getProperty("SapModel").toDispatch()
        Dispatch.call(sapModel, "GetPresentUnits").int
        Dispatch.call(sapModel, "GetPresentUnits").int
        Dispatch.call(sapModel, "InitializeNewModel").int
        val file = Dispatch.get(sapModel, "File").toDispatch()
        Dispatch.call(file, "NewBlank")
        val propMaterial = Dispatch.call(sapModel, "PropMaterial").toDispatch()
        Dispatch.call(propMaterial, "SetMaterial", "Concreto do Vítor", 2)
        Dispatch.call(xl, "ApplicationExit", false)
    }
}