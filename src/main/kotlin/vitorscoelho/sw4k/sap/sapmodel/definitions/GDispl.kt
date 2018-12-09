package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.GDisplV14

class GDispl internal constructor(programName: String) : GDisplV14 {
    override val activeXComponentName: String = "$programName.cGenDispl"
}