package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.AISC_LRFD99V14

class AISC_LRFD99 internal constructor(programName: String) : AISC_LRFD99V14 {
    override val activeXComponentName: String = "$programName.cDStAISC_LRFD99"
}