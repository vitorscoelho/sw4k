package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.LoadPatternType
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns.AutoSeismicV14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns.AutoWindV14

interface LoadPatternsV14 : SapComponent {
    val autoSeismic: AutoSeismicV14
    val autoWind: AutoWindV14
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
    fun add(name: String, myType: Int, selfWTMultiplier: Double = 0.0, addLoadCase: Boolean = true): Int =
            callFunctionInt("Add", name, myType, selfWTMultiplier, addLoadCase)

    /**
     * This function applies a new name to a load pattern.
     * @param name The name of a defined load pattern.
     * @param newName The new name for the load pattern.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the number of defined load patterns.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes the specified load pattern.
     * @param name The name of an existing load pattern.
     * @return zero if the load pattern is successfully deleted, otherwise it returns a nonzero value. Return an error if the load pattern is assigned to an load case or if it is the only defined load pattern.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the code name used for auto seismic parameters in Quake-type load patterns.
     * @param name The name of an existing Quake-type load pattern.
     * @param codeName This is either blank or the name code used for the auto seismic parameters. Blank means no auto seismic load is specified for the Quake-type load pattern.
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value. An error is returned if the specified load pattern is not a Quake-type load pattern.
     */
    fun getAutoSeismicCode(name: String, codeName: AStringByRef): Int =
            callFunctionInt("GetAutoSeismicCode", name, codeName)

    /**
     * This function retrieves the code name used for auto wave parameters in Wave-type load patterns.
     * @param name The name of an existing Wave-type load pattern.
     * @param codeName This is either blank or the name code used for the auto wave parameters. Blank means no auto wave load is specified for the Wave-type load pattern.
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value. An error is returned if the specified load pattern is not a Wave-type load pattern.
     */
    fun getAutoWaveCode(name: String, codeName: AStringByRef): Int =
            callFunctionInt("GetAutoWaveCode", name, codeName)

    /**
     * This function retrieves the code name used for auto wind parameters in Wind-type load patterns.
     * @param name The name of an existing Wind-type load pattern.
     * @param codeName This is either blank or the name code used for the auto wind parameters. Blank means no auto wind load is specified for the Wind-type load pattern.
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value. An error is returned if the specified load pattern is not a Wind-type load pattern.
     */
    fun getAutoWindCode(name: String, codeName: AStringByRef): Int =
            callFunctionInt("GetAutoWindCode", name, codeName)

    /**
     * This function retrieves the load type for a specified load pattern.
     * @param name The name of an existing load pattern.
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
     * @return zero if the load type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadType(name: String, myType: AIntByRef): Int =
            callFunctionInt("GetLoadType", name, myType)

    /**
     * This function retrieves the names of all defined load cases.
     * @param numberNames The number of load pattern names retrieved by the program.
     * @param myName This is a one-dimensional array of load pattern names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the self weight multiplier for a specified load pattern.
     * @param name The name of an existing load pattern.
     * @param selfWTMultiplier The self weight multiplier for the specified load pattern.
     * @return zero if the multiplier is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSelfWtMultiplier(name: String, selfWTMultiplier: ADoubleByRef): Int =
            callFunctionInt("GetSelfWtMultiplier", name, selfWTMultiplier)

    /**
     * This function assigns a load type to a load pattern.
     * @param name The name of an existing load pattern.
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
     * @return zero if the load type is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadType(name: String, myType: Int): Int =
            callFunctionInt("SetLoadType", name, myType)

    /**
     * This function assigns a self weight multiplier to a load case.
     * @param name The name of an existing load pattern.
     * @param selfWTMultiplier The self weight multiplier for the specified load pattern.
     * @return zero if the multiplier is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setSelfWtMultiplier(name: String, selfWTMultiplier: Double): Int =
            callFunctionInt("SetSelfWtMultiplier", name, selfWTMultiplier)
}