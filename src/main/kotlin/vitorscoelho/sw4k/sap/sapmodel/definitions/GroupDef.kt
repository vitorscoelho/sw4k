package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.GroupDefV14

class GroupDef internal constructor(programName: String) : GroupDefV14 {
    override val activeXComponentName: String = "$programName.cGroup"
}