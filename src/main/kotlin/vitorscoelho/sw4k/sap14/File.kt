package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.SapComponent

class File internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cFile") {

    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @return zero if the new blank model is successfully created, otherwise it returns a nonzero value.
     */
    fun newBlank(): Int = callFunctionInt("NewBlank")
}