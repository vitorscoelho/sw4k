package vitorscoelho.sw4k.sapversions.v14.sapmodel.design

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.aluminum.AA_ASD_2000V14
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.aluminum.AA_LRFD_2000V14

interface DesignAluminumV14 : SapComponent {
    val AA_ASD_2000: AA_ASD_2000V14
    val AA_LRFD_2000: AA_LRFD_2000V14

    /**
     * This function deletes all aluminum frame design results.
     * @return zero if the results are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteResults(): Int =
            callFunctionInt("DeleteResults")

    /**
     * This function retrieves the aluminum design code.
     * @param codeName This is one of the following aluminum design code names.
     * * AA-ASD 2000
     * * AA-LRFD 2000
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCode(codeName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetCode", codeName)

    /**
     * This function retrieves the names of all load combinations selected as design combinations for aluminum deflection design.
     * @param numberItems The number of load combinations selected as design combinations for aluminum deflection design.
     * @param myName This is an array that includes the name of each response combination selected as a design combination for aluminum deflection design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getComboDeflection(numberItems: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetComboDeflection", numberItems, myName)

    /**
     * This function retrieves the names of all load combinations selected as design combinations for aluminum strength design.
     * @param numberItems The number of load combinations selected as design combinations for aluminum strength design.
     * @param myName This is an array that includes the name of each response combination selected as a design combination for aluminum strength design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getComboStrength(numberItems: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetComboStrength", numberItems, myName)

    /**
     * This function retrieves the design section for a specified aluminum frame object.
     * @param name The name of a frame object with a aluminum frame design procedure.
     * @param propName The name of the design section for the specified frame object.
     * @return zero if the section is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDesignSection(name: String, propName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetDesignSection", name, propName)

    /**
     * This function retrieves the names of all groups selected for aluminum design.
     * @param numberItems The number of groups selected for aluminum design.
     * @param myName This is an array that includes the name of each group selected for aluminum design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getGroup(numberItems: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetGroup", numberItems, myName)

    /**
     * This function retrieves summary results for aluminum design.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The number of frame objects for which results are obtained.
     * @param frameName This is an array that includes each frame object name for which results are obtained.
     * @param ratio This is an array that includes the controlling stress or capacity ratio for each frame object.
     * @param ratioType This is an array that includes 1, 3 or 4, indicating the controlling stress or capacity ratio type for each frame object.
     * * 1 = PMM
     * * 3 = Major shear
     * * 4 = Minor shear
     * @param location This is an array that includes the distance from the I-end of the frame object to the location where the controlling stress or capacity ratio occurs. (L)
     * @param comboName This is an array that includes the name of the design combination for which the controlling stress or capacity ratio occurs.
     * @param errorSummary This is an array that includes the design error messages for the frame object, if any.
     * @param warningSummary This is an array that includes the design warning messages for the frame object, if any.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the design results are retrieved for the frame object specified by the Name item.
     * If this item is Group, the design results are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the design results are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the results are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSummaryResults(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, frameName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, ratio: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ratioType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, location: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, comboName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, errorSummary: AStringArrayByRef = StringArrayByRef.UNNECESSARY, warningSummary: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetSummaryResults", name, numberItems, frameName, ratio, ratioType, location, comboName, errorSummary, warningSummary, itemType)

    /**
     * This function resets all aluminum frame design overwrites to default values.
     * The function will fail if no aluminum frame objects are present.
     * None
     * @return zero if the overwrites are successfully reset; otherwise it returns a nonzero value.
     */
    fun resetOverwrites(): Int =
            callFunctionInt("ResetOverwrites")

    /**
     * This function removes the auto select section assignments from all specified frame objects that have a aluminum frame design procedure.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the auto select section assignments are successfully removed; otherwise it returns a nonzero value.
     */
    fun setAutoSelectNull(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetAutoSelectNull", name, itemType)

    /**
     * This function sets the aluminum design code.
     * @param codeName This is one of the following aluminum design code names.
     * * AA-ASD 2000
     * * AA-LRFD 2000
     * @return zero if the code is successfully set; otherwise it returns a nonzero value.
     */
    fun setCode(codeName: String): Int =
            callFunctionInt("SetCode", codeName)

    /**
     * This function selects or deselects a load combination for aluminum deflection design.
     * @param name The name of an existing load combination.
     * @param selected If this item is True, the specified load combination is selected as a design combination for aluminum deflection design. If it is False, the combination is not selected for aluminum deflection design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setComboDeflection(name: String, selected: Boolean): Int =
            callFunctionInt("SetComboDeflection", name, selected)

    /**
     * This function selects or deselects a load combination for aluminum strength design.
     * @param name The name of an existing load combination.
     * @param selected If this item is True, the specified load combination is selected as a design combination for aluminum strength design. If it is False, the combination is not selected for aluminum strength design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setComboStrength(name: String, selected: Boolean): Int =
            callFunctionInt("SetComboStrength", name, selected)

    /**
     * This function modifies the design section for all specified frame objects that have a aluminum frame design procedure.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param propName The name of an existing frame section property to be used as the design section for the specified frame objects. This item applies only when LastAnalysis = False.
     * @param lastAnalysis If this item is True, the design section for the specified frame objects is reset to the last analysis section for the frame object. If it is False, the design section is set to that specified by PropName.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the design section is successfully modified; otherwise it returns a nonzero value.
     */
    fun setDesignSection(name: String, propName: String, lastAnalysis: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetDesignSection", name, propName, lastAnalysis, itemType)

    /**
     * This function selects or deselects a group for aluminum design.
     * @param name The name of an existing group.
     * @param selected If this item is True, the specified group is selected as a design group for aluminum design. If it is False, the group is not selected for aluminum design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setGroup(name: String, selected: Boolean): Int =
            callFunctionInt("SetGroup", name, selected)

    /**
     * This function starts the aluminum frame design.
     * The function will fail if no aluminum frame objects are present. It will also fail if analysis results are not available.
     * None
     * @return zero if the aluminum frame design is successfully started; otherwise it returns a nonzero value.
     */
    fun startDesign(): Int =
            callFunctionInt("StartDesign")

    /**
     * This function retrieves the names of the frame objects that did not pass the design check or have not yet been checked, if any.
     * @param numberItems The number of aluminum frame objects that did not pass the design check or have not yet been checked.
     * @param n1 The number of aluminum frame objects that did not pass the design check.
     * @param n2 The number of aluminum frame objects that have not yet been checked.
     * @param myName This is an array that includes the name of each frame object that did not pass the design check or has not yet been checked.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifyPassed(numberItems: AIntByRef = IntByRef.UNNECESSARY, n1: AIntByRef = IntByRef.UNNECESSARY, n2: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("VerifyPassed", numberItems, n1, n2, myName)

    /**
     * This function retrieves the names of the frame objects that have different analysis and design sections, if any.
     * @param numberItems The number of frame objects that have different analysis and design sections.
     * @param myName This is an array that includes the name of each frame object that has different analysis and design sections.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifySections(numberItems: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("VerifySections", numberItems, myName)
}