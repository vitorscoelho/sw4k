package vitorscoelho.sw4k.sap.sapmodel.analysisresults

import vitorscoelho.sw4k.sapversions.v15.sapmodel.analysisresults.*

class Results(programName: String) : ResultsV15 {
    override val activeXComponentName: String = "$programName.cAnalysisResults"
    override val setup = Setup(programName)
}

class Setup internal constructor(programName: String) : SetupV15 {
    override val activeXComponentName: String = "$programName.cAnalysisResultsSetup"
}