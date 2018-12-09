package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sap.sapmodel.bridgeadvanced.BASConcBox
import vitorscoelho.sw4k.sapversions.v14.sapmodel.BridgeAdvancedSuperV14

class BridgeAdvancedSuper internal constructor(programName: String) : BridgeAdvancedSuperV14 {
    override val activeXComponentName: String = "$programName.cBridgeAdvancedSuper"
    override val basConcBox = BASConcBox(programName)
}