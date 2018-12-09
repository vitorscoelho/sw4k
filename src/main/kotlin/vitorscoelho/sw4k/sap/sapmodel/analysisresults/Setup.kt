package vitorscoelho.sw4k.sap.sapmodel.analysisresults

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults.SetupV14

class Setup internal constructor(programName: String) : SetupV14 {
    override val activeXComponentName: String = "$programName.cAnalysisResultsSetup"
}