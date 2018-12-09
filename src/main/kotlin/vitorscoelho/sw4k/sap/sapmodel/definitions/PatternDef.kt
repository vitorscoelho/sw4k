package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.PatternDefV14

class PatternDef internal constructor(programName: String) : PatternDefV14 {
    override val activeXComponentName: String = "$programName.cPattern"
}