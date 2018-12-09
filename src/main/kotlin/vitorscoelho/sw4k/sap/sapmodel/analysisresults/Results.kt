package vitorscoelho.sw4k.sap.sapmodel.analysisresults

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults.ResultsV14


class Results(programName: String) : ResultsV14 {
    override val activeXComponentName: String = "$programName.cAnalysisResults"
    override val setup = Setup(programName)
}