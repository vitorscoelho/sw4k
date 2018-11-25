package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef
import vitorscoelho.sw4k.sap14.definitions.loadcases.*
import vitorscoelho.sw4k.sap14.enums.LoadPatternType
import vitorscoelho.sw4k.sap14.enums.LoadCaseType

class LoadCases(programName: String) : LoadCasesV14 {
    override val activeXComponentName: String = "$programName.cLoadCases"
    override val buckling = Buckling(programName)
    override val dirHistLinear = DirHistLinear(programName)
    override val dirHistNonlinear = DirHistNonlinear(programName)
    override val hyperStatic = HyperStatic(programName)
    override val modalEigen = ModalEigen(programName)
    override val modalRitz = ModalRitz(programName)
    override val modHistLinear = ModHistLinear(programName)
    override val modHistNonlinear = ModHistNonlinear(programName)
    override val moving = Moving(programName)
    override val psd = PSD(programName)
    override val responseSpectrum = ResponseSpectrum(programName)
    override val staticLinear = StaticLinear(programName)
    override val staticLinearMultistep = StaticLinearMultistep(programName)
    override val staticNonlinear = StaticNonlinear(programName)
    override val staticNonlinearStaged = StaticNonlinearStaged(programName)
    override val steadyState = SteadyState(programName)
}

interface LoadCasesV14 : SapComponent {
    val buckling: BucklingV14
    val dirHistLinear: DirHistLinearV14
    val dirHistNonlinear: DirHistNonlinearV14
    val hyperStatic: HyperStaticV14
    val modalEigen: ModalEigenV14
    val modalRitz: ModalRitzV14
    val modHistLinear: ModHistLinearV14
    val modHistNonlinear: ModHistNonlinearV14
    val moving: MovingV14
    val psd: PSDV14
    val responseSpectrum: ResponseSpectrumV14
    val staticLinear: StaticLinearV14
    val staticLinearMultistep: StaticLinearMultistepV14
    val staticNonlinear: StaticNonlinearV14
    val staticNonlinearStaged: StaticNonlinearStagedV14
    val steadyState: SteadyStateV14

    /**
     * This function changes the name of an existing load case.
     * @param name The existing name of a defined load case.
     * @param newName The new name for the load case.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of load cases in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * @param caseType This is one of the following items in the [LoadCaseType] enumeration.
     * * CASE_LINEAR_STATIC = 1
     * * CASE_NONLINEAR_STATIC = 2
     * * CASE_MODAL = 3
     * * CASE_RESPONSE_SPECTRUM = 4
     * * CASE_LINEAR_HISTORY = 5  (Modal Time History)
     * * CASE_NONLINEAR_HISTORY = 6  (Modal Time History)
     * * CASE_LINEAR_DYNAMIC = 7  (Direct Integration Time History)
     * * CASE_NONLINEAR_DYNAMIC = 8  (Direct Integration Time History)
     * * CASE_MOVING_LOAD = 9
     * * CASE_BUCKLING = 10
     * * CASE_STEADY_STATE = 11
     * * CASE_POWER_SPECTRAL_DENSITY = 12
     * * CASE_LINEAR_STATIC_MULTISTEP = 13
     * * CASE_HYPERSTATIC = 14
     * @return the total number of defined load cases in the model.
     */
    fun count(caseType: Int): Int =
            callFunctionInt("Count", caseType)

    /**
     * The function deletes the specified load case.
     * @param name The name of an existing load case.
     * @return zero if the load case is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined load cases.
     * @param numberNames The number of load case names retrieved by the program.
     * @param myName Array filled with the names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of all defined load cases of the specified type.
     * @param numberNames The number of load case names retrieved by the program.
     * @param myName Array filled with the names.
     * @param caseType This optional value is one of the following items in the [LoadCaseType] enumeration.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef, caseType: Int): Int =
            callFunctionInt("GetNameList", numberNames, myName, caseType)

    /**
     * This function retrieves the case type, design type, and auto flag for the specified load case.
     * This function supercedes .GetType (LoadCases).
     * @param name The name of an existing load case.
     * @param caseType This is one of the following items in the [LoadCaseType] enumeration.
     * * CASE_LINEAR_STATIC = 1
     * * CASE_NONLINEAR_STATIC = 2
     * * CASE_MODAL = 3
     * * CASE_RESPONSE_SPECTRUM = 4
     * * CASE_LINEAR_HISTORY = 5 (Modal Time History)
     * * CASE_NONLINEAR_HISTORY = 6 (Modal Time History)
     * * CASE_LINEAR_DYNAMIC = 7 (Direct Integration Time History)
     * * CASE_NONLINEAR_DYNAMIC = 8 (Direct Integration Time History)
     * * CASE_MOVING_LOAD = 9
     * * CASE_BUCKLING = 10
     * * CASE_STEADY_STATE = 11
     * * CASE_POWER_SPECTRAL_DENSITY = 12
     * * CASE_LINEAR_STATIC_MULTISTEP = 13
     * * CASE_HYPERSTATIC = 14
     * @param subType This is an integer representing the load case sub type. This item applies only for certain case types.
     * For CASE_NONLINEAR_STATIC:
     * * 1 = Nonlinear
     * * 2 = Nonlinear staged construction
     * For CASE_MODAL:
     * * 1 = Eigen
     * * 2 = Ritz
     * For CASE_LINEAR_HISTORY:
     * * 1 = Transient
     * * 2 = Periodic
     * @param designType This is one of the following items in the [LoadPatternType] enumeration.
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
     * @param designTypeOption This is one of the following options for the DesignType item.
     * * 0 = Program determined
     * * 1 = User specified
     * @param auto This is one of the following values indicating if the load case has been automatically created.
     * * 0 = Not automatically created
     * * 1 = Automatically created by the bridge construction scheduler
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType_1(name: String, caseType: IntByRef, subType: IntByRef, designType: IntByRef, designTypeOption: IntByRef, auto: IntByRef): Int =
            callFunctionInt("GetType_1", name, caseType, subType, designType, designTypeOption, auto)

    /**
     * This function sets the design type for the specified load case.
     * @param name The name of an existing load case.
     * @param designTypeOption This is one of the following options for the DesignType item.
     * * 0 = Program determined
     * * 1 = User specified
     * @param designType This item only applies when the DesignTypeOption is 1 (user specified). It is one of the following items in the [LoadPatternType] enumeration.
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
     * @return zero if the type is successfully set; otherwise it returns nonzero.
     */
    fun setDesignType(name: String, designTypeOption: Int, designType: Int = LoadPatternType.DEAD.sapId): Int =
            callFunctionInt("SetDesignType", name, designTypeOption, designType)
}