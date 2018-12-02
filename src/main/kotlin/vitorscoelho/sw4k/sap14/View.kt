package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.*

class View internal constructor(programName: String) : ViewV14 {
    override val activeXComponentName: String = "$programName.cView"
}

interface ViewV14 : SapComponent {
    /**
     * This function refreshes the view for the specified window(s).
     * The [refreshWindow] and [refreshView] functions are similar. [refreshWindow] simply updates the display. [refreshView] rebuilds all object arrays used for display and then updates the display. A [refreshView] takes longer to complete than a [refreshWindow].
     * The [refreshView] function should be called after operations that add, delete or move objects. The [refreshWindow] function is adequate for other types of changes. For example, after adding a new point object to the model, the  [refreshView] function should be called. After modifying a joint restraint, the [refreshWindow] function should be called.
     * @param window This is 0 meaning all windows or an existing window number. It indicates the window(s) to have its view refreshed.
     * @param zoom If this item is True, the window zoom is maintained when the view is refreshed. If it is False, the zoom returns to a default zoom.
     * @return zero if the window views are successfully refreshed, otherwise it returns a nonzero value.
     */
    fun refreshView(window: Int = 0, zoom: Boolean = true): Int =
            callFunctionInt("RefreshView", window, zoom)

    /**
     * This function refreshes the specified window(s).
     * The [refreshWindow] and [refreshView] functions are similar. [refreshWindow] simply updates the display. [refreshView] rebuilds all object arrays used for display and then updates the display. A [refreshView] takes longer to complete than a [refreshWindow].
     * The [refreshView] function should be called after operations that add, delete or move objects. The [refreshWindow] function is adequate for other types of changes. For example, after adding a new point object to the model, the  [refreshView] function should be called. After modifying a joint restraint, the [refreshWindow] function should be called.
     * @param window This is 0 meaning all windows or an existing window number. It indicates the window(s) to be refreshed.
     * @return zero if the windows are successfully refreshed, otherwise it returns a nonzero value.
     */
    fun refreshWindow(window: Int = 0): Int =
            callFunctionInt("RefreshWindow", window)
}