package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.CType
import vitorscoelho.sw4k.sapenums.ComboType

interface RespComboV14 : SapComponent {
    /**
     * This function adds a new default design load combinations to the model.
     * @param designSteel If this item is True, default steel design combinations are to be added to the model.
     * @param designConcrete If this item is True, default concrete design combinations are to be added to the model.
     * @param designAluminum If this item is True, default aluminum design combinations are to be added to the model.
     * @param designColdFormed If this item is True, default cold formed design combinations are to be added to the model.
     * @return zero if the load combinations are successfully added, otherwise it returns a nonzero value.
     */
    fun addDesignDefaultCombos(designSteel: Boolean, designConcrete: Boolean, designAluminum: Boolean, designColdFormed: Boolean): Int =
            callFunctionInt("AddDesignDefaultCombos", designSteel, designConcrete, designAluminum, designColdFormed)

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
    fun add(name: String, comboType: Int): Int =
            callFunctionInt("Add", name, comboType)

    /**
     * The new load combination name must be different from all other load combinations and all load cases. If the name is not unique, an error will be returned.
     * @param name The existing name of a defined load combination.
     * @param newName The new name for the combination.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * This function retrieves the total number of load case and/or combinations included in a specified load combination.
     * @param name The name of an existing load combination.
     * @param count The number of load case and/or combinations included in the specified combination.
     * @return zero if the count is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun countCase(name: String, count: AIntByRef): Int =
            callFunctionInt("CountCase", name, count)

    /**
     * @return the total number of load combinations defined in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes one load case or load combination from the list of cases included in the specified load combination.
     * @param name The name of an existing load combination.
     * @param cType This is one of the following items in the [CType] enumeration:
     * * LoadCase = 0
     * * LoadCombo = 1
     * This item indicates whether the CName item is an analysis case (LoadCase) or a load combination (LoadCombo).
     * @param cName The name of the load case or load combination to be deleted from the specified combination.
     * @return zero if the item is successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteCase(name: String, cType: Int, cName: String): Int =
            callFunctionInt("DeleteCase", name, cType, cName)

    /**
     * This function deletes the specified load combination.
     * @param name The name of an existing load combination.
     * @return zero if the combination is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function returns all load cases and response combinations included in the load combination specified by the Name item.
     * @param name The name of an existing load combination.
     * @param numberItems The total number of load cases and load combinations included in the load combination specified by the Name item.
     * @param cType This is an array of one of the following items in the [CType] enumeration:
     * * LoadCase = 0
     * * LoadCombo = 1
     * This item indicates if the associated CName item is an load case (LoadCase) or a load combination (LoadCombo).
     * @param cName This is an array of the names of the load cases or load combinations included in the load combination specified by the Name item.
     * @param sF The scale factor multiplying the case or combination indicated by the CName item.
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getCaseList(name: String, numberItems: AIntByRef, cType: AIntArrayByRef, cName: AStringArrayByRef, sF: ADoubleArrayByRef): Int =
            callFunctionInt("GetCaseList", name, numberItems, cType, cName, sF)

    /**
     * This function retrieves the names of all defined response combinations.
     * @param numberNames The number of load combination names retrieved by the program.
     * @param myName This is a one-dimensional array of load combination names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the user note for specified response combination. The note may be blank.
     * @param name The name of an existing load combination.
     * @param note The user note, if any, included with the specified combination.
     * @return zero if the note is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getNote(name: String, note: AStringByRef): Int =
            callFunctionInt("GetNote", name, note)

    /**
     * This function retrieves the combination type for specified load combination.
     * @param name The name of an existing load combination.
     * @param comboType This is 0, 1, 2, 3 or 4 indicating the load combination type ([ComboType] enumeration).
     * * 0 = Linear Additive
     * * 1 = Envelope
     * * 2 = Absolute Additive
     * * 3 = SRSS
     * * 4 = Range Additive
     * @return zero if the type is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getType(name: String, comboType: AIntByRef): Int =
            callFunctionInt("GetType", name, comboType)

    /**
     * This function adds or modifies one load case or response combination in the list of cases included in the load combination specified by the Name item.
     * @param name The name of an existing load combination.
     * @param cType This is one of the following items in the [CType] enumeration:
     * * LoadCase = 0
     * * LoadCombo = 1
     * This item indicates if the CName item is an load case (LoadCase) or a load combination (LoadCombo).
     * @param cName The name of the load case or load combination to be added to or modified in the combination specified by the Name item. If the load case or combination already exists in the combination specified by the Name item, the scale factor is modified as indicated by the SF item for that load case or combination. If the analysis case or combination does not exist in the combination specified by the Name item, it is added.
     * @param SF The scale factor multiplying the case or combination indicated by the CName item.
     * @return zero if the item is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setCaseList(name: String, cType: Int, cName: String, SF: Double): Int =
            callFunctionInt("SetCaseList", name, cType, cName, SF)

    /**
     * This function sets the user note for specified response combination. The note may be blank.
     * @param name The name of an existing load combination.
     * @param note The user note included with the specified combination. It may be a blank string.
     * @return zero if the note is successfully set, otherwise it returns a nonzero value.
     */
    fun setNote(name: String, note: String): Int =
            callFunctionInt("SetNote", name, note)

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
    fun setType(name: String, comboType: Int): Int =
            callFunctionInt("SetType", name, comboType)
}