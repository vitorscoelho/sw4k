package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropSolidV14

class PropSolid internal constructor(programName: String) : PropSolidV14 {
    override val activeXComponentName: String = "$programName.cPropSolid"
}