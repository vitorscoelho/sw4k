package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propmaterial.TimeDep
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropMaterialV14

class PropMaterial internal constructor(programName: String) : PropMaterialV14 {
    override val activeXComponentName: String = "$programName.cPropMaterial"

    override val timeDep = TimeDep(programName)
}