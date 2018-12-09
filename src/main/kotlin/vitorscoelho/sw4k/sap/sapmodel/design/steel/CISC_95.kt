package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.CISC_95V14

class CISC_95 internal constructor(programName: String) : CISC_95V14 {
    override val activeXComponentName: String = "$programName.cDStCISC_95"
}