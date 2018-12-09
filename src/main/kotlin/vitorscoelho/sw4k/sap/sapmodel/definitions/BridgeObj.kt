package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.BridgeObjV14


class BridgeObj(programName: String) : BridgeObjV14 {
    override val activeXComponentName: String = "$programName.cBridgeObj"
}