package vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.namedassign.*

class ModifierArea internal constructor(programName: String) : ModifierAreaV15 {
    override val activeXComponentName: String = "$programName.cModifierArea"
}

class ModifierCable internal constructor(programName: String) : ModifierCableV15 {
    override val activeXComponentName: String = "$programName.cModifierCable"
}

class ModifierFrame internal constructor(programName: String) : ModifierFrameV15 {
    override val activeXComponentName: String = "$programName.cModifierFrame"
}

class ReleaseFrame internal constructor(programName: String) : ReleaseFrameV15 {
    override val activeXComponentName: String = "$programName.cReleaseFrame"
}