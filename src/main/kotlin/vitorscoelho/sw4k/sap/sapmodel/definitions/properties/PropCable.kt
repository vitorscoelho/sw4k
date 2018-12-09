package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.PropCableV14

class PropCable internal constructor(programName: String) : PropCableV14 {
    override val activeXComponentName: String = "$programName.cPropCable"
}