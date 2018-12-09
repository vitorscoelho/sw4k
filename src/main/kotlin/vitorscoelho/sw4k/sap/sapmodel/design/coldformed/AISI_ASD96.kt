package vitorscoelho.sw4k.sap.sapmodel.design.coldformed

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.coldformed.AISI_ASD96V14

class AISI_ASD96 internal constructor(programName: String) : AISI_ASD96V14 {
    override val activeXComponentName: String = "$programName.cDCdAISI_ASD96"
}