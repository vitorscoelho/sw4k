package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.AISC_ASD01V14

class AISC_ASD01 internal constructor(programName: String) : AISC_ASD01V14 {
    override val activeXComponentName: String = "$programName.cDStAISC_ASD01"
}