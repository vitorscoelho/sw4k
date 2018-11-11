package vitorscoelho.sw4k.sap14.analysisresults

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel

class Setup internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cAnalysisResultsSetup") {
    /**
     * The function deselects all load cases and response combinations for output.
     * @return zero if the cases and combos are successfully deselected, otherwise it returns a nonzero value.
     */
    fun deselectAllCasesAndCombosForOutput(): Int =
            callFunctionInt("DeselectAllCasesAndCombosForOutput")

    /**
     * This function sets an load case selected for output flag.
     * @param name The name of an existing load case.
     * @param selected This item is True if the specified load case is to be selected for output, otherwise it is False.
     * @return 0 if the selected flag is successfully set, otherwise it returns nonzero.
     */
    fun setCaseSelectedForOutput(name: String, selected: Boolean = true): Int =
            callFunctionInt("SetCaseSelectedForOutput", name, selected)

    /**
     * This function sets a load combination selected for output flag.
     * @param name The name of an existing load combination.
     * @param selected This item is True if the specified load combination is to be selected for output, otherwise it is False.
     * @return 0 if the selected flag is successfully set, otherwise it returns nonzero.
     */
    fun setComboSelectedForOutput(name: String, selected: Boolean = true): Int =
            callFunctionInt("SetComboSelectedForOutput", name, selected)
}