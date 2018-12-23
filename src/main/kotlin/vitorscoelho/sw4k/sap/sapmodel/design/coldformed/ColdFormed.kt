package vitorscoelho.sw4k.sap.sapmodel.design.coldformed

import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.coldformed.*

class AISI_ASD96 internal constructor(programName: String) : AISI_ASD96V15 {
    override val activeXComponentName: String = "$programName.cDCdAISI_ASD96"
}

class AISI_LRFD96 internal constructor(programName: String) : AISI_LRFD96V15 {
    override val activeXComponentName: String = "$programName.cDCdAISI_LRFD96"
}