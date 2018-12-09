package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns.AutoSeismic
import vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns.AutoWind
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.LoadPatternsV14


class LoadPatterns internal constructor(programName: String) : LoadPatternsV14 {
    override val activeXComponentName: String = "$programName.cLoadPatterns"

    override val autoSeismic = AutoSeismic(programName)
    override val autoWind = AutoWind(programName)
}