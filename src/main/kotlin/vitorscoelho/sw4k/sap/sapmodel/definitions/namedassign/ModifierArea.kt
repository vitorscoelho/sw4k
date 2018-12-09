package vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ModifierAreaV14

class ModifierArea internal constructor(programName: String) : ModifierAreaV14 {
    override val activeXComponentName: String = "$programName.cModifierArea"
}