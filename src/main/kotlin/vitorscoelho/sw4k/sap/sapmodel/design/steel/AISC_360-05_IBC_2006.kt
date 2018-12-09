package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.AISC_360_05_IBC_2006V14

class AISC_360_05_IBC_2006 internal constructor(programName: String) : AISC_360_05_IBC_2006V14 {
    override val activeXComponentName: String = "$programName.cDStAISC_360-05_IBC_2006"
}