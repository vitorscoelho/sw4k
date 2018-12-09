package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.AISC_LRFD93V14

class AISC_LRFD93 internal constructor(programName: String) : AISC_LRFD93V14 {
    override val activeXComponentName: String = "$programName.cDStAISC_LRFD93"
}