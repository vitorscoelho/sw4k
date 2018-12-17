package vitorscoelho.sw4k.sap

import vitorscoelho.sw4k.comutils.dlls.LoaderJacobDll
import vitorscoelho.sw4k.sapversions.v14.SapObjectV14
import vitorscoelho.sw4k.sapversions.v15.SapObjectV15

class SapObject private constructor(override val activeXComponentName: String, val programName: String) : SapObjectV14, SapObjectV15 {
    override val sapModel = SapModel(programName)

    companion object {
        @JvmStatic
        fun v14(): SapObjectV14 {
            LoaderJacobDll.load()
            return SapObject(activeXComponentName = "Sap2000.SapObject", programName = "Sap2000")
        }

        @JvmStatic
        fun v15(): SapObjectV15 {
            LoaderJacobDll.load()
            return SapObject(activeXComponentName = "Sap2000v15.SapObject", programName = "Sap2000v15")
        }
    }
}