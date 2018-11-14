package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.LoadPatternType

class LoadPatterns internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cLoadPatterns"), LoadPatternsV14 {
    override fun add(name: String, myType: Int, selfWTMultiplier: Double, addLoadCase: Boolean): Int =
            callFunctionInt("Add", name, myType, selfWTMultiplier, addLoadCase)
}

interface LoadPatternsV14 {
    /**
     * This function adds a new load pattern.
     * @param name The name for the new load pattern.
     * @param myType This is one of the following items in the [LoadPatternType] enumeration:
     * * LTYPE_DEAD = 1
     * * LTYPE_SUPERDEAD = 2
     * * LTYPE_LIVE = 3
     * * LTYPE_REDUCELIVE = 4
     * * LTYPE_QUAKE = 5
     * * LTYPE_WIND= 6
     * * LTYPE_SNOW = 7
     * * LTYPE_OTHER = 8
     * * LTYPE_MOVE = 9
     * * LTYPE_TEMPERATURE = 10
     * * LTYPE_ROOFLIVE = 11
     * * LTYPE_NOTIONAL = 12
     * * LTYPE_PATTERNLIVE = 13
     * * LTYPE_WAVE= 14
     * * LTYPE_BRAKING = 15
     * * LTYPE_CENTRIFUGAL = 16
     * * LTYPE_FRICTION = 17
     * * LTYPE_ICE = 18
     * * LTYPE_WINDONLIVELOAD = 19
     * * LTYPE_HORIZONTALEARTHPRESSURE = 20
     * * LTYPE_VERTICALEARTHPRESSURE = 21
     * * LTYPE_EARTHSURCHARGE = 22
     * * LTYPE_DOWNDRAG = 23
     * * LTYPE_VEHICLECOLLISION = 24
     * * LTYPE_VESSELCOLLISION = 25
     * * LTYPE_TEMPERATUREGRADIENT = 26
     * * LTYPE_SETTLEMENT = 27
     * * LTYPE_SHRINKAGE = 28
     * * LTYPE_CREEP = 29
     * * LTYPE_WATERLOADPRESSURE = 30
     * * LTYPE_LIVELOADSURCHARGE = 31
     * * LTYPE_LOCKEDINFORCES = 32
     * * LTYPE_PEDESTRIANLL = 33
     * * LTYPE_PRESTRESS = 34
     * * LTYPE_HYPERSTATIC = 35
     * * LTYPE_BOUYANCY = 36
     * * LTYPE_STREAMFLOW = 37
     * * LTYPE_IMPACT = 38
     * * LTYPE_CONSTRUCTION = 39
     * @param selfWTMultiplier The self weight multiplier for the new load pattern.
     * @param addLoadCase If this item is True, a linear static load case corresponding to the new load pattern is added.
     * @return 0 if the load pattern is successfully added; otherwise it returns nonzero. An error is returned if the Name item is already used for an existing load pattern.
     */
    fun add(name: String, myType: Int, selfWTMultiplier: Double = 0.0, addLoadCase: Boolean = true): Int
}