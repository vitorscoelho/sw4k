package vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propframe

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.propframe.*

class SDShape internal constructor(programName: String) : SDShapeV15 {
    override val activeXComponentName: String = "$programName.cPropFrameSDShape"
}