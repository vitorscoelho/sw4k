package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.sap14.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.LoadPatternType

class LoadPatterns internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cLoadPatterns") {
    /**
     * This function adds a new load pattern.
     * @param name The name for the new load pattern.
     * @param myType [LoadPatternType]
     * @param selfWTMultiplier The self weight multiplier for the new load pattern.
     * @param addLoadCase If this item is True, a linear static load case corresponding to the new load pattern is added.
     * @return 0 if the load pattern is successfully added; otherwise it returns nonzero. An error is returned if the Name item is already used for an existing load pattern.
     */
    fun add(name: String, myType: LoadPatternType, selfWTMultiplier: Double = 0.0, addLoadCase: Boolean = true): Int =
            callFunction("Add", name, myType.value, selfWTMultiplier, addLoadCase).int
}