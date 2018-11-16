package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.enums.Units

class SapObject private constructor(override val activeXComponentName: String, val programName: String) : SapObjectV14 {
    override val sapModel = SapModel(programName)

    companion object {
        @JvmStatic
        fun v14(): SapObjectV14 = SapObject(activeXComponentName = "Sap2000.SapObject", programName = "Sap2000")
//        fun v15(): SapObjectV15 = SapObject(activeXComponentName = "Sap2000v15.SapObject", programName = "Sap2000v15")
    }
}

interface SapObjectV14 : SapComponent {
    val sapModel: SapModelV14

    /**
     * If the model file is saved then it is saved with its current name. You should set the Sap2000 object variable to nothing after calling this function.
     * @param fileSave If this item is True the existing model file is saved prior to closing Sap2000.
     * @return zero if the function succeeds and nonzero if it fails.
     */
    fun applicationExit(fileSave: Boolean): Int =
            callFunctionInt("ApplicationExit", fileSave)

    /**
     * This function starts the Sap2000 application.
     * When the model is not visible it does not appear on screen and it does not appear in the Windows task bar.
     * If no filename is specified, you can later open a model or create a model through the API.
     * The file name must have an .sdb, .$2k, .s2k, .xls, or .mdb extension. Files with .sdb extensions are opened as standard SAP2000 files. Files with .$2k and .s2k extensions are imported as text files. Files with .xls extensions are imported as Microsoft Excel files. Files with .mdb extensions are imported as Microsoft Access files.
     * @param units The database units ([Units] enumeration) used when a new model is created. Data is internally stored in the program in the database units.
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
     * @param visible If this item is True then the application is visible when started.  If it is False then the application is hidden when started.
     * @param fileName The full path of a model file to be opened when the Sap2000 application is started. If no file name is specified, the application starts without loading an existing model.
     * @return zero if the application successfully starts and nonzero if it fails.
     */
    fun applicationStart(units: Int = Units.kip_in_F.sapId, visible: Boolean = true, fileName: String = ""): Int =
            callFunctionInt("ApplicationStart", units, visible, fileName)

    /**
     * This function hides the Sap2000 application. When the application is hidden it is not visible on the screen or on the Windows task bar.
     * @return zero if the Sap2000 application is successfully hidden and nonzero if the function fails. If the application is already hidden calling this function returns an error.
     */
    fun hide(): Int =
            callFunctionInt("Hide")

    /**
     * This function unhides the Sap2000 application, that is, it makes it visible. When the application is hidden, it is not visible on the screen or on the Windows task bar.
     * @return zero if the Sap2000 application is successfully unhidden (set visible) and nonzero if the function fails. If the application is already visible (not hidden) calling this function returns an error.
     */
    fun unhide(): Int =
            callFunctionInt("Unhide")

    /**
     * @return True if the Sap2000 application is visible on the screen, otherwise it returns False.
     */
    fun visible(): Boolean =
            callFunctionBoolean("Visible")
}