package vitorscoelho.sw4k.sapversions.v14.sapmodel

import vitorscoelho.sw4k.comutils.*

interface OptionsV14 : SapComponent {
    /**
     * This function retrieves the program dimension and tolerance items.
     * @param cuttingPlaneTol The tolerance for 2D view cutting planes. (L)
     * @param worldSpacing The plan fine grid spacing. (L)
     * @param nudgeValue The plan nudge value. (L)
     * @param pixelClickSize The screen selection tolerance in pixels.
     * @param pixelSnapSize The screen snap tolerance in pixels.
     * @param scrLinThk The screen line thickness in pixels.
     * @param prtLinThk The printer line thickness in pixels.
     * @param maxFont The maximum graphic font size in points.
     * @param minFont The minimum graphic font size in points.
     * @param zoomStep The auto zoom step size in percent (0 < ZoomStep < = 100).
     * @param shrinkFact The shrink factor in percent (0 < ShrinkFact < = 100).
     * @param textFileMaxChar The maximum line length in the text file (ShrinkFact > = 80).
     * @return zero if the items are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDimensions(cuttingPlaneTol: DoubleByRef, worldSpacing: DoubleByRef, nudgeValue: DoubleByRef, pixelClickSize: IntByRef, pixelSnapSize: IntByRef, scrLinThk: IntByRef, prtLinThk: IntByRef, maxFont: IntByRef, minFont: IntByRef, zoomStep: IntByRef, shrinkFact: IntByRef, textFileMaxChar: IntByRef): Int =
            callFunctionInt("GetDimensions", cuttingPlaneTol, worldSpacing, nudgeValue, pixelClickSize, pixelSnapSize, scrLinThk, prtLinThk, maxFont, minFont, zoomStep, shrinkFact, textFileMaxChar)

    /**
     * This function sets program dimension and tolerance items. Inputting 0 for any item means that the item will be ignored by the program; that is, its current value will not be changed.
     * @param cuttingPlaneTol The tolerance for 2D view cutting planes. (L)
     * @param worldSpacing The plan fine grid spacing. (L)
     * @param nudgeValue The plan nudge value. (L)
     * @param pixelClickSize The screen selection tolerance in pixels.
     * @param pixelSnapSize The screen snap tolerance in pixels.
     * @param scrLinThk The screen line thickness in pixels.
     * @param prtLinThk The printer line thickness in pixels.
     * @param maxFont The maximum graphic font size in points.
     * @param minFont The minimum graphic font size in points.
     * @param zoomStep The auto zoom step size in percent (0 < ZoomStep <= 100).
     * @param shrinkFact The shrink factor in percent (0 < ShrinkFact <= 100).
     * @param textFileMaxChar The maximum line length in the text file (ShrinkFact >= 80).
     * @return zero if the items are successfully set; otherwise it returns a nonzero value.
     */
    fun setDimensions(cuttingPlaneTol: Double = 0.0, worldSpacing: Double = 0.0, nudgeValue: Double = 0.0, pixelClickSize: Int = 0, pixelSnapSize: Int = 0, scrLinThk: Int = 0, prtLinThk: Int = 0, maxFont: Int = 0, minFont: Int = 0, zoomStep: Int = 0, shrinkFact: Int = 0, textFileMaxChar: Int = 0): Int =
            callFunctionInt("SetDimensions", cuttingPlaneTol, worldSpacing, nudgeValue, pixelClickSize, pixelSnapSize, scrLinThk, prtLinThk, maxFont, minFont, zoomStep, shrinkFact, textFileMaxChar)
}