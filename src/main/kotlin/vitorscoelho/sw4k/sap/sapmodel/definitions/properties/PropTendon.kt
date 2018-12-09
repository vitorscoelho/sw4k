package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropTendonV14

class PropTendon internal constructor(programName: String) : PropTendonV14 {
    override val activeXComponentName: String = "$programName.cPropTendon"
}