package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign.ModifierArea
import vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign.ModifierCable
import vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign.ModifierFrame
import vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign.ReleaseFrame
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.NamedAssignV14

class NamedAssign internal constructor(programName: String) : NamedAssignV14 {
    override val activeXComponentName: String = "$programName.CNamedAssign"

    override val modifierArea = ModifierArea(programName)
    override val modifierCable = ModifierCable(programName)
    override val modifierFrame = ModifierFrame(programName)
    override val releaseFrame = ReleaseFrame(programName)
}