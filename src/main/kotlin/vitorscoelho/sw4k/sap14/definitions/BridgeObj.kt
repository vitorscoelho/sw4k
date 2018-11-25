package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent

class BridgeObj(programName: String) : BridgeObjV14 {
    override val activeXComponentName: String = "$programName.cBridgeObj"
}

interface BridgeObjV14 : SapComponent {
    /**
     * When this flag is True, the program automatically updates bridge objects before running an analysis if it detects anything has been changed that might affect the bridge analysis.
     * This flag is by default set to True for each new Sap2000 Object.
     */
    fun getBridgeUpdateForAnalysisFlag(): Boolean =
            callFunctionBoolean("GetBridgeUpdateForAnalysisFlag")

    /**
     * This flag is by default set to True for each new Sap2000 Object.
     * @param value A boolean (True or False) value. When this item is True the program automatically updates bridge objects before running an analysis if it detects anything has been changed that might affect the bridge analysis.
     * @return zero if the flag is successfully set, otherwise it returns a nonzero value.
     */
    fun getBridgeUpdateForAnalysisFlag(value: Boolean): Int =
            callFunctionInt("GetBridgeUpdateForAnalysisFlag", value)
}