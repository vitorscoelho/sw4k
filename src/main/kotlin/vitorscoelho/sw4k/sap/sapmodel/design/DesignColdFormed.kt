package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignColdFormedV14
import vitorscoelho.sw4k.sap.sapmodel.design.coldformed.*

class DesignColdFormed internal constructor(programName: String) : DesignColdFormedV14 {
    override val activeXComponentName: String = "$programName.cDesignColdFormed"

    override val AISI_ASD96 = AISI_ASD96(programName)
    override val AISI_LRFD96 = AISI_LRFD96(programName)
}