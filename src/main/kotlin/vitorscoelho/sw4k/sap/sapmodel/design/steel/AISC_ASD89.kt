package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.AISC_ASD89V14

class AISC_ASD89 internal constructor(programName: String) : AISC_ASD89V14 {
    override val activeXComponentName: String = "$programName.cDStAISC_ASD89"
}