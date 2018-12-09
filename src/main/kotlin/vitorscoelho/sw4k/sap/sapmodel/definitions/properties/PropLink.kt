package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropLinkV14

class PropLink internal constructor(programName: String) : PropLinkV14 {
    override val activeXComponentName: String = "$programName.cPropLink"
}