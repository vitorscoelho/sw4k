package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.enums.CType
import vitorscoelho.sw4k.sap14.enums.ComboType

class RespCombo internal constructor(programName: String) : RespComboV14 {
    override val activeXComponentName: String = "$programName.cCombo"
}

interface RespComboV14 : SapComponent {
    /**
     * This function adds a new load combination.
     * The new load combination must have a different name from all other load combinations and all load cases. If the name is not unique, an error will be returned.
     * @param name The name of a new load combination.
     * @param comboType This is 0, 1, 2, 3 or 4 indicating the load combination type ([ComboType] enumeration).
     * * 0 = Linear Additive
     * * 1 = Envelope
     * * 2 = Absolute Additive
     * * 3 = SRSS
     * * 4 = Range Additive
     * @return zero if the load combination is successfully added, otherwise it returns a nonzero value.
     */
    fun add(name: String, comboType: Int): Int = callFunctionInt("Add", name, comboType)

    /**
     * This function adds or modifies one load case or response combination in the list of cases included in the load combination specified by the Name item.
     * @param name The name of an existing load combination.
     * @param cType This is one of the following items in the [CType] enumeration:
     * * LoadCase = 0
     * * LoadCombo = 1
     * This item indicates if the CName item is an load case (LoadCase) or a load combination (LoadCombo).
     * @param cName The name of the load case or load combination to be added to or modified in the combination specified by the Name item. If the load case or combination already exists in the combination specified by the Name item, the scale factor is modified as indicated by the SF item for that load case or combination. If the analysis case or combination does not exist in the combination specified by the Name item, it is added.
     * @param sF The scale factor multiplying the case or combination indicated by the CName item.
     * @return zero if the item is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setCaseList(name: String, cType: Int, cName: String, sF: Double): Int =
            callFunctionInt("SetCaseList", name, cType, cName, sF)

    /**
     * This function sets the combination type for specified load combination.
     * @param name The name of an existing load combination.
     * @param comboType This is 0, 1, 2, 3 or 4 indicating the load combination type ([ComboType] enumeration).
     * * 0 = Linear Additive
     * * 1 = Envelope
     * * 2 = Absolute Additive
     * * 3 = SRSS
     * * 4 = Range Additive
     * @return zero if the type is successfully set, otherwise it returns a nonzero value.
     */
    fun setType(name: String, comboType: Int): Int = callFunctionInt("SetType", name, comboType)
}