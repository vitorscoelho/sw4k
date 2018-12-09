package vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierFrameV14

class ModifierFrame internal constructor(programName: String) : ModifierFrameV14 {
    override val activeXComponentName: String = "$programName.cModifierFrame"
}