package vitorscoelho.sw4k.sap.sapmodel.design.aluminum

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.aluminum.AA_LRFD_2000V14

class AA_LRFD_2000 internal constructor(programName: String) : AA_LRFD_2000V14 {
    override val activeXComponentName: String = "$programName.cDAlAA_AA_LRFD_2000"
}