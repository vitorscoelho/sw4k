package vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propmaterial

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.propmaterial.*

class TimeDep internal constructor(programName: String) : TimeDepV15 {
    override val activeXComponentName: String = "$programName.cPropMaterialTD"
}