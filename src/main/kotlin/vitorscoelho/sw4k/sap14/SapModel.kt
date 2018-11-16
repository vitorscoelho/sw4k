package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.SapComponent
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
     * This function clears the previous model and initializes the program for a new model. If it is later needed, you should save your previous model prior to calling this function.
     * After calling the InitializeNewModel function, it is not necessary to also call the ApplicationStart function because the functionality of the ApplicationStart function is included in the InitializeNewModel function.
     * @param units This is the database units ([Units] enumeration) for the new model. All data is internally stored in the model in these units. The units are one of the following items in the eUnits enumeration:
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
     * With some exceptions, definitions and assignments can not be changed in a model while the model is locked. If an attempt is made to change a definition or assignment while the model is locked and that change is not allowed in a locked model, an error will be returned.
     * @param lockIt The item is True if the model is to be locked and False if it is to be unlocked.
     * @return zero if the locked status of the model is successfully set. Otherwise it returns a nonzero value.
     */
    fun setModelIsLocked(lockIt: Boolean): Int =
            callFunctionInt("SetModelIsLocked", lockIt)
}