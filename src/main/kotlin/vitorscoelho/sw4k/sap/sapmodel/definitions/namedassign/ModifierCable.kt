package vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierCableV14

class ModifierCable internal constructor(programName: String) : ModifierCableV14 {
    override val activeXComponentName: String = "$programName.cModifierCable"
}