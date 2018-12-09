package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults

import vitorscoelho.sw4k.comutils.*

interface SetupV14 : SapComponent {
    /**
     * The function deselects all load cases and response combinations for output.
     * @return zero if the cases and combos are successfully deselected, otherwise it returns a nonzero value.
     */
    fun deselectAllCasesAndCombosForOutput(): Int =
            callFunctionInt("DeselectAllCasesAndCombosForOutput")

    /**
     * This function checks if an load case is selected for output.
     * @param name The name of an existing load case.
     * @param selected This item is True if the specified load case is selected for output.
     * @return 0 if the selected flag is successfully retrieved, otherwise it returns nonzero.
     */
    fun getCaseSelectedForOutput(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetCaseSelectedForOutput", name, selected)

    /**
     * This function checks if a load combination is selected for output.
     * @param name The name of an existing load combination.
     * @param selected This item is True if the specified load combination is selected for output.
     * @return 0 if the selected flag is successfully retrieved, otherwise it returns nonzero.
     */
    fun getComboSelectedForOutput(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetComboSelectedForOutput", name, selected)

    /**
     * This function retrieves the global coordinates of the location at which the base reactions are reported.
     * @param gx, gy, gz The global coordinates of the location at which the base reactions are reported.
     * @return 0 if the coordinates are successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionBaseReactLoc(gx: DoubleByRef, gy: DoubleByRef, gz: DoubleByRef): Int =
            callFunctionInt("GetOptionBaseReactLoc", gx, gy, gz)

    /**
     * This function retrieves the buckling modes for which buckling factors are reported.
     * @param buckModeStart The first buckling mode for which the buckling factor is reported when the BuckModeAll item is False.
     * @param buckModeEnd The last buckling mode for which the buckling factor is reported when the BuckModeAll item is False.
     * @param buckModeAll If this item is True, buckling factors are reported for all calculated buckling modes. If it is False, buckling factors are reported for the buckling modes indicated by the BuckModeStart and BuckModeEnd items.
     * @return 0 if the modes are successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionBucklingMode(buckModeStart: IntByRef, buckModeEnd: IntByRef, buckModeAll: BooleanByRef): Int =
            callFunctionInt("GetOptionBucklingMode", buckModeStart, buckModeEnd, buckModeAll)

    /**
     * This function retrieves the output option for direct history results.
     * @param value This item is either 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionDirectHist(value: IntByRef): Int =
            callFunctionInt("GetOptionDirectHist", value)

    /**
     * This function retrieves the output option for modal history results.
     * @param value This item is either 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionModalHist(value: IntByRef): Int =
            callFunctionInt("GetOptionModalHist", value)

    /**
     * This function retrieves the modes for which mode shape results are reported.
     * @param modeShapeStart The first mode for which results are reported when the ModeShapesAll item is False.
     * @param modeShapeEnd The last mode for which results are reported when the ModeShapesAll item is False.
     * @param modeShapesAll If this item is True, results are reported for all calculated modes. If it is False, results are reported for the modes indicated by the ModeShapeStart and ModeShapeEnd items.
     * @return 0 if the modes are successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionModeShape(modeShapeStart: IntByRef, modeShapeEnd: IntByRef, modeShapesAll: BooleanByRef): Int =
            callFunctionInt("GetOptionModeShape", modeShapeStart, modeShapeEnd, modeShapesAll)

    /**
     * This function retrieves the output option for multistep static linear results.
     * @param value This item is either 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionMultiStepStatic(value: IntByRef): Int =
            callFunctionInt("GetOptionMultiStepStatic", value)

    /**
     * This function retrieves the output option for multi-valued load combination results.
     * @param value This item is either 1 or 2
     * * 1 = Envelopes
     * * 2 = Multiple values, if possible
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionMultiValuedCombo(value: IntByRef): Int =
            callFunctionInt("GetOptionMultiValuedCombo", value)

    /**
     * This function retrieves the output option for nonlinear static results.
     * @param value This item is either 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionNLStatic(value: IntByRef): Int =
            callFunctionInt("GetOptionNLStatic", value)

    /**
     * This function retrieves the output option for power spectral density results.
     * @param value This item is either 1 or 2
     * * 1 = RMS
     * * 2 = sqrt(PSD)
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionPSD(value: IntByRef): Int =
            callFunctionInt("GetOptionPSD", value)

    /**
     * This function retrieves the output option for steady state results.
     * @param value This item is either 1 or 2
     * * 1 = Envelopes
     * * 2 = At Frequencies
     * @param steadyStateOption This item is 1, 2 or 3
     * * 1 = In and Out of Phase
     * * 2 = Magnitude
     * * 3 = All
     * @return 0 if the output option is successfully retrieved, otherwise it returns nonzero.
     */
    fun getOptionSteadyState(value: IntByRef, steadyStateOption: IntByRef): Int =
            callFunctionInt("GetOptionSteadyState", value, steadyStateOption)

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

    /**
     * This function sets the global coordinates of the location at which the base reactions are reported.
     * @param gx, gy, gz The global coordinates of the location at which the base reactions are reported.
     * @return 0 if the coordinates are successfully set, otherwise it returns nonzero.
     */
    fun setOptionBaseReactLoc(gx: Double, gy: Double, gz: Double): Int =
            callFunctionInt("SetOptionBaseReactLoc", gx, gy, gz)

    /**
     * This function sets the buckling modes for which buckling factors are reported.
     * @param buckModeStart The first buckling mode for which the buckling factor is reported when the BuckModeAll item is False.
     * @param buckModeEnd The last buckling mode for which the buckling factor is reported when the BuckModeAll item is False.
     * @param buckModeAll If this item is True, buckling factors are reported for all calculated buckling modes. If it is False, buckling factors are reported for the buckling modes indicated by the BuckModeStart and BuckModeEnd items.
     * @return 0 if the modes are successfully set, otherwise it returns nonzero.
     */
    fun setOptionBucklingMode(buckModeStart: Int, buckModeEnd: Int, buckModeAll: Boolean = false): Int =
            callFunctionInt("SetOptionBucklingMode", buckModeStart, buckModeEnd, buckModeAll)

    /**
     * This function sets the output option for direct history results.
     * @param value This item is 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionDirectHist(value: Int): Int =
            callFunctionInt("SetOptionDirectHist", value)

    /**
     * This function sets the output option for modal history results.
     * @param value This item is 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionModalHist(value: Int): Int =
            callFunctionInt("SetOptionModalHist", value)

    /**
     * This function sets the modes for which mode shape results are reported.
     * @param modeShapeStart The first mode for which results are reported when the ModeShapesAll item is False.
     * @param modeShapeEnd The last mode for which results are reported when the ModeShapesAll item is False.
     * @param modeShapesAll If this item is True, results are reported for all calculated modes. If it is False, results are reported for the modes indicated by the ModeShapeStart and ModeShapeEnd items.
     * @return 0 if the modes are successfully set, otherwise it returns nonzero.
     */
    fun setOptionModeShape(modeShapeStart: Int, modeShapeEnd: Int, modeShapesAll: Boolean = false): Int =
            callFunctionInt("SetOptionModeShape", modeShapeStart, modeShapeEnd, modeShapesAll)

    /**
     * This function sets the output option for multistep static linear results.
     * @param value This item is 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionMultiStepStatic(value: Int): Int =
            callFunctionInt("SetOptionMultiStepStatic", value)

    /**
     * This function sets the output option for multi-valued load combination results.
     * @param value This item is either 1 or 2
     * * 1 = Envelopes
     * * 2 = Multiple values, if possible
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionMultiValuedCombo(value: Int): Int =
            callFunctionInt("SetOptionMultiValuedCombo", value)

    /**
     * This function sets the output option for nonlinear static results.
     * @param value This item is 1, 2 or 3
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * * 3 = Last Step
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionNLStatic(value: Int): Int =
            callFunctionInt("SetOptionNLStatic", value)

    /**
     * This function sets the output option for power spectral density results.
     * @param value This item is either 1 or 2
     * * 1 = RMS
     * * 2 = sqrt(PSD)
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionPSD(value: Int): Int =
            callFunctionInt("SetOptionPSD", value)

    /**
     * This function sets the output option for steady state results.
     * @param value This item is either 1 or 2
     * * 1 = Envelopes
     * * 2 = At Frequencies
     * @param steadyStateOption This item is 1, 2 or 3
     * * 1 = In and Out of Phase
     * * 2 = Magnitude
     * * 3 = All
     * @return 0 if the output option is successfully set, otherwise it returns nonzero.
     */
    fun setOptionSteadyState(value: Int, steadyStateOption: Int): Int =
            callFunctionInt("SetOptionSteadyState", value, steadyStateOption)
}