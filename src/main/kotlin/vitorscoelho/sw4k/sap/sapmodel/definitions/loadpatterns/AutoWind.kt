package vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns.AutoWindV14

class AutoWind internal constructor(programName: String) : AutoWindV14 {
    override val activeXComponentName: String = "$programName.cAutoWind"
}