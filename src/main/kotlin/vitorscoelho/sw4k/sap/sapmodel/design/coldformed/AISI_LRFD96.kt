package vitorscoelho.sw4k.sap.sapmodel.design.coldformed

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.coldformed.AISI_LRFD96V14

class AISI_LRFD96 internal constructor(programName: String) : AISI_LRFD96V14 {
    override val activeXComponentName: String = "$programName.cDCdAISI_LRFD96"
}