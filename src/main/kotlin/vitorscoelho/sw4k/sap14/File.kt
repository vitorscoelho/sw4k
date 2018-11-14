package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.SapComponent

class File internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cFile"), FileV14 {
    override fun newBlank(): Int = callFunctionInt("NewBlank")
    override fun openFile(fileName: String): Int = callFunctionInt("OpenFile", fileName)
    override fun save(fileName: String): Int = callFunctionInt("Save", fileName)
}

interface FileV14 {
    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @return zero if the new blank model is successfully created, otherwise it returns a nonzero value.
     */
    fun newBlank(): Int

    /**
     * This function opens an existing Sap2000 file. The file name must have an sdb, $2k, s2k, xls, or mdb extension. Files with sdb extensions are opened as standard Sap2000 files. Files with $2k and s2k extensions are imported as text files. Files with xls extensions are imported as Microsoft Excel files. Files with mdb extensions are imported as Microsoft Access files.
     * The function is only applicable when you are accessing the Sap2000 API from an external application. It will return an error if you call it from VBA inside Sap2000.
     * @param fileName The full path of a model file to be opened in the Sap2000 application.
     * @return zero if the file is successfully opened and nonzero if it is not opened.
     */
    fun openFile(fileName: String): Int

    /**
     * If a file name is specified, it should have an .sdb extension. If no file name is specified, the file is saved using its current name.
     * If there is no current name for the file (the file has not been saved previously) and this function is called with no file name specified, an error will be returned.
     * @param fileName The full path to which the model file is saved.
     * @return zero if the file is successfully saved and nonzero if it is not saved.
     */
    fun save(fileName: String = ""): Int
}