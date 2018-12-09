package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.ConstraintDefV14

class ConstraintDef internal constructor(programName: String) : ConstraintDefV14 {
    override val activeXComponentName: String = "$programName.cConstraint"
}