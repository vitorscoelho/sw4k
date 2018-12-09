package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propframe.SDShape
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropFrameV14

class PropFrame internal constructor(programName: String) : PropFrameV14 {
    override val activeXComponentName: String = "$programName.cPropFrame"

    override val sdShape = SDShape(programName)
}