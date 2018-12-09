package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.AnalyzeV14

class Analyze internal constructor(programName: String) : AnalyzeV14 {
    override val activeXComponentName: String = "$programName.cAnalyze"
}