package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.enums.Units

class SapObject : SapComponent("Sap2000.SapObject") {
    val sapObjectString = "Sap2000"
    val sapModel = SapModel(this)

    /**
     * This function starts the Sap2000 application.
     * When the model is not visible it does not appear on screen and it does not appear in the Windows task bar.
     * If no filename is specified, you can later open a model or create a model through the API.
     * The file name must have an .sdb, .$2k, .s2k, .xls, or .mdb extension. Files with .sdb extensions are opened as standard SAP2000 files. Files with .$2k and .s2k extensions are imported as text files. Files with .xls extensions are imported as Microsoft Excel files. Files with .mdb extensions are imported as Microsoft Access files.
     * @param units The database units used when a new model is created. Data is internally stored in the program in the database units.
     * @param visible If this item is True then the application is visible when started.  If it is False then the application is hidden when started.
     * @param fileName The full path of a model file to be opened when the Sap2000 application is started. If no file name is specified, the application starts without loading an existing model.
     * @return zero if the application successfully starts and nonzero if it fails.
     */
    fun applicationStart(units: Units = Units.kip_in_F, visible: Boolean = true, fileName: String = ""): Int =
            callFunctionInt("ApplicationStart", units, visible, fileName)

    /*val sapModel: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cSapModel") }
    val file: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cFile") }
    val propMaterial: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cPropMaterial") }
    val propFrame: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cPropFrame") }
    val pointObj: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cPointObj") }
    val frameObj: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cFrameObj") }
    val propLink: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cPropLink") }
    val linkObj: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cLinkObj") }
    val loadPatterns: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cLoadPatterns") }
    val loadCases: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cLoadCases") }
    val caseStaticNonlinear: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cCaseStaticNonlinear") }
    val respCombo: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cCombo") }
    val analyze: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cAnalyze") }
    val results: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cAnalysisResults") }
    val setup: ActiveXComponent by lazy { ActiveXComponent("$sapObjectString.cAnalysisResultsSetup") }*/
}