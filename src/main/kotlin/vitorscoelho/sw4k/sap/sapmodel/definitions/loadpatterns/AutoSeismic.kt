package vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns.AutoSeismicV14

class AutoSeismic internal constructor(programName: String) : AutoSeismicV14 {
    override val activeXComponentName: String = "$programName.cAutoSeismic"
}