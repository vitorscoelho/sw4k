package vitorscoelho.sw4k.sap.sapmodel.design.aluminum

import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.aluminum.*

class AA_ASD_2000 internal constructor(programName: String) : AA_ASD_2000V15 {
    override val activeXComponentName: String = "$programName.cDAlAA_AA_ASD_2000"
}

class AA_LRFD_2000 internal constructor(programName: String) : AA_LRFD_2000V15 {
    override val activeXComponentName: String = "$programName.cDAlAA_AA_LRFD_2000"
}