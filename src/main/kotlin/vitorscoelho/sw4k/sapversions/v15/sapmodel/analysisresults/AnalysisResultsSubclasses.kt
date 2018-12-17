package vitorscoelho.sw4k.sapversions.v15.sapmodel.analysisresults

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults.ResultsV14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults.SetupV14

interface ResultsV15 : ResultsV14 {
    override val setup: SetupV15
}

interface SetupV15 : SetupV14