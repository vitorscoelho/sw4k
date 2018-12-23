package vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.loadpatterns.*

class AutoSeismic internal constructor(programName: String) : AutoSeismicV15 {
    override val activeXComponentName: String = "$programName.cAutoSeismic"
}

class AutoWind internal constructor(programName: String) : AutoWindV15 {
    override val activeXComponentName: String = "$programName.cAutoWind"
}