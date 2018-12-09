package vitorscoelho.sw4k.sap

import vitorscoelho.sw4k.sapversions.v14.SapObjectV14

class SapObject private constructor(override val activeXComponentName: String, val programName: String) : SapObjectV14 {
    override val sapModel = SapModel(programName)

    companion object {
        @JvmStatic
        fun v14(): SapObjectV14 = SapObject(activeXComponentName = "Sap2000.SapObject", programName = "Sap2000")
//        fun v15(): SapObjectV15 = SapObject(activeXComponentName = "Sap2000v15.SapObject", programName = "Sap2000v15")
    }
}