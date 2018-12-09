package vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propmaterial

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propmaterial.TimeDepV14

class TimeDep internal constructor(programName: String) : TimeDepV14 {
    override val activeXComponentName: String = "$programName.cPropMaterialTD"
}