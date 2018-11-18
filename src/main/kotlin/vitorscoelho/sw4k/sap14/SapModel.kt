package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.analysismodel.*
import vitorscoelho.sw4k.sap14.analysisresults.Results
import vitorscoelho.sw4k.sap14.analysisresults.ResultsV14
import vitorscoelho.sw4k.sap14.definitions.*
import vitorscoelho.sw4k.sap14.definitions.properties.PropFrame
import vitorscoelho.sw4k.sap14.definitions.properties.PropFrameV14
import vitorscoelho.sw4k.sap14.definitions.properties.PropMaterial
import vitorscoelho.sw4k.sap14.definitions.properties.PropMaterialV14
import vitorscoelho.sw4k.sap14.enums.Units
import vitorscoelho.sw4k.sap14.objectmodel.FrameObj
import vitorscoelho.sw4k.sap14.objectmodel.FrameObjV14
import vitorscoelho.sw4k.sap14.objectmodel.PointObj
import vitorscoelho.sw4k.sap14.objectmodel.PointObjV14

class SapModel internal constructor(programName: String) : SapModelV14 {
    override val activeXComponentName: String = "$programName.cSapModel"
    override val areaElm = AreaElm(programName)
    override val lineElm = LineElm(programName)
    override val linkElm = LinkElm(programName)
    override val planeElm = PlaneElm(programName)
    override val pointElm = PointElm(programName)
    override val solidElm = SolidElm(programName)
    override val file = File(programName)
    override val propMaterial = PropMaterial(programName)
    override val propFrame = PropFrame(programName)
    override val pointObj = PointObj(programName)
    override val frameObj = FrameObj(programName)
    override val loadPatterns = LoadPatterns(programName)
    override val loadCases = LoadCases(programName)
    override val respCombo = RespCombo(programName)
    override val analyze = Analyze(programName)
    override val results = Results(programName)
}

interface SapModelV14 : SapComponent {
    val areaElm: AreaElmV14
    val lineElm: LineElmV14
    val linkElm: LinkElmV14
    val planeElm: PlaneElmV14
    val pointElm: PointElmV14
    val solidElm: SolidElmV14
    val file: FileV14
    val propMaterial: PropMaterialV14
    val propFrame: PropFrameV14
    val pointObj: PointObjV14
    val frameObj: FrameObjV14
    val loadPatterns: LoadPatternsV14
    val loadCases: LoadCasesV14
    val respCombo: RespComboV14
    val analyze: AnalyzeV14
    val results: ResultsV14

    /**
     * This function returns one of the following items from the [Units] enumeration indicating the database units for the model. All data is internally stored in the model in these units and converted to the present units as needed.
     * * lb_in_F = 1
     * * lb_ft_F = 2
     * * kip_in_F = 3
     * * kip_ft_F = 4
     * * kN_mm_C = 5
     * * kN_m_C = 6
     * * kgf_mm_C = 7
     * * kgf_m_C = 8
     * * N_mm_C = 9
     * * N_m_C = 10
     * * Ton_mm_C = 11
     * * Ton_m_C = 12
     * * kN_cm_C = 13
     * * kgf_cm_C = 14
     * * N_cm_C = 15
     * * Ton_cm_C = 16
     */
    fun getDatabaseUnits(): Int =
            callFunctionInt("GetDatabaseUnits")

    /**
     * This function retrieves the value of the program auto merge tolerance.
     * @param mergeTol The program auto merge tolerance. (L)
     * @return zero if the tolerance is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMergeTol(mergeTol: DoubleByRef): Int =
            callFunctionInt("GetMergeTol", mergeTol)

    /**
     * The function returns True if the model is locked and False if it is unlocked.
     * With some exceptions, definitions and assignments can not be changed in a model while the model is locked. If an attempt is made to change a definition or assignment while the model is locked and that change is not allowed in a locked model, an error will be returned.
     */
    fun getModelIsLocked(): Boolean =
            callFunctionBoolean("GetModelIsLocked")

    /**
     * @return the name of the present coordinate system.
     */
    fun getPresentCoordSystem(): String =
            callFunctionString("GetPresentCoordSystem")

    /**
     * This function returns one of the following items from the [Units] enumeration indicating the units presently specified for the model:
     * * lb_in_F = 1
     * * lb_ft_F = 2
     * * kip_in_F = 3
     * * kip_ft_F = 4
     * * kN_mm_C = 5
     * * kN_m_C = 6
     * * kgf_mm_C = 7
     * * kgf_m_C = 8
     * * N_mm_C = 9
     * * N_m_C = 10
     * * Ton_mm_C = 11
     * * Ton_m_C = 12
     * * kN_cm_C = 13
     * * kgf_cm_C = 14
     * * N_cm_C = 15
     * * Ton_cm_C = 16
     */
    fun getPresentUnits(): Int =
            callFunctionInt("GetPresentUnits")

    /**
     * This function retrieves the project information data.
     * @param numberItems The number of project info items returned.
     * @param item This is an array that includes the name of the project information item.
     * @param data This is an array that includes the data for the specified project information item.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProjectInfo(numberItems: IntByRef, item: StringArrayByRef, data: StringArrayByRef): Int =
            callFunctionInt("GetProjectInfo", numberItems, item, data)

    /**
     * This function retrieves the data in the user comments and log.
     * @param comment The data in the user comments and log.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUserComment(comment: StringByRef): Int =
            callFunctionInt("GetUserComment", comment)

    /**
     * SAP2000 program version.
     * @param version The program version name that is externally displayed to the user.
     * @param myVersionNumber The program version number that is used internally by the program and not displayed to the user.
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getVersion(version: StringByRef, myVersionNumber: DoubleByRef): Int =
            callFunctionInt("GetVersion", version, myVersionNumber)

    /**
     * This function clears the previous model and initializes the program for a new model. If it is later needed, you should save your previous model prior to calling this function.
     * After calling the InitializeNewModel function, it is not necessary to also call the ApplicationStart function because the functionality of the ApplicationStart function is included in the InitializeNewModel function.
     * @param units This is the database units ([Units] enumeration) for the new model. All data is internally stored in the model in these units. The units are one of the following items in the [Units] enumeration:
     * * lb_in_F = 1
     * * lb_ft_F = 2
     * * kip_in_F = 3
     * * kip_ft_F = 4
     * * kN_mm_C = 5
     * * kN_m_C = 6
     * * kgf_mm_C = 7
     * * kgf_m_C = 8
     * * N_mm_C = 9
     * * N_m_C = 10
     * * Ton_mm_C = 11
     * * Ton_m_C = 12
     * * kN_cm_C = 13
     * * kgf_cm_C = 14
     * * N_cm_C = 15
     * * Ton_cm_C = 16
     * @return zero if a new model is successfully initialized, otherwise it returns a nonzero value.
     */
    fun initializeNewModel(units: Int = Units.kip_in_F.sapId): Int =
            callFunctionInt("InitializeNewModel", units)

    /**
     * This function sets the program auto merge tolerance.
     * @param mergeTol The program auto merge tolerance. (L)
     * @return zero if the tolerance is successfully set; otherwise it returns a nonzero value.
     */
    fun setMergeTol(mergeTol: Double): Int =
            callFunctionInt("SetMergeTol", mergeTol)

    /**
     * With some exceptions, definitions and assignments can not be changed in a model while the model is locked. If an attempt is made to change a definition or assignment while the model is locked and that change is not allowed in a locked model, an error will be returned.
     * @param lockIt The item is True if the model is to be locked and False if it is to be unlocked.
     * @return zero if the locked status of the model is successfully set. Otherwise it returns a nonzero value.
     */
    fun setModelIsLocked(lockIt: Boolean): Int =
            callFunctionInt("SetModelIsLocked", lockIt)

    /**
     * This function sets the present coordinate system.
     * @param cSys The name of a defined coordinate system.
     * @return The function returns zero if the present coordinate system is successfully set. Otherwise it returns a nonzero value.
     */
    fun setPresentCoordSystem(cSys: String): Int =
            callFunctionInt("SetPresentCoordSystem", cSys)

    /**
     * @param units One of the following items in the [Units] enumeration:
     * * lb_in_F = 1
     * * lb_ft_F = 2
     * * kip_in_F = 3
     * * kip_ft_F = 4
     * * kN_mm_C = 5
     * * kN_m_C = 6
     * * kgf_mm_C = 7
     * * kgf_m_C = 8
     * * N_mm_C = 9
     * * N_m_C = 10
     * * Ton_mm_C = 11
     * * Ton_m_C = 12
     * * kN_cm_C = 13
     * * kgf_cm_C = 14
     * * N_cm_C = 15
     * * Ton_cm_C = 16
     * @return zero if the units are successfully set and nonzero if they are not set.
     */
    fun setPresentUnits(units: Int): Int =
            callFunctionInt("SetPresentUnits", units)

    /**
     * This function sets the data for an item in the project information.
     * @param item The name of the project information item to be set.
     * @param data The data for the specified project information item.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setProjectInfo(item: String, data: String): Int =
            callFunctionInt("SetProjectInfo", item, data)

    /**
     * This function sets the user comments and log data.
     * @param comment The data to be added to the user comments and log.
     * @param numLines The number of carriage return and line feeds to be included before the specified comment. This item is ignored if Replace = True. It is also ignored if there are no existing comments.
     * @param replace If this item is True, all existing comments are replaced with the specified comment.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setUserComment(comment: String, numLines: Int = 1, replace: Boolean = false): Int =
            callFunctionInt("SetUserComment", comment, numLines, replace)
}