package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropAreaV14

class PropArea internal constructor(programName: String) : PropAreaV14 {
    override val activeXComponentName: String = "$programName.cPropArea"
}