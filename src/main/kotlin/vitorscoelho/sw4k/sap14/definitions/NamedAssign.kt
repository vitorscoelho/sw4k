package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.definitions.namedassign.*

class NamedAssign(programName: String) : NamedAssignV14 {
    override val activeXComponentName: String = "$programName.CNamedAssign"

    override val modifierArea = ModifierArea(programName)
    override val modifierCable = ModifierCable(programName)
    override val modifierFrame = ModifierFrame(programName)
    override val releaseFrame = ReleaseFrame(programName)
}

interface NamedAssignV14 : SapComponent {
    val modifierArea: ModifierAreaV14
    val modifierCable: ModifierCableV14
    val modifierFrame: ModifierFrameV14
    val releaseFrame: ReleaseFrameV14
}