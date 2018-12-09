package vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propframe

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propframe.SDShapeV14

class SDShape internal constructor(programName: String) : SDShapeV14 {
    override val activeXComponentName: String = "$programName.cPropFrameSDShape"
}