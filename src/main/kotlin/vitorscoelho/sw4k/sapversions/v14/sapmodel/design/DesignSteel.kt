package vitorscoelho.sw4k.sapversions.v14.sapmodel.design

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.*

interface DesignSteelV14 : SapComponent {
    val AISC_360_05_IBC_2006: AISC_360_05_IBC_2006V14
    val AISC_ASD01: AISC_ASD01V14
    val AISC_ASD89: AISC_ASD89V14
    val AISC_LRFD93: AISC_LRFD93V14
    val AISC_LRFD99: AISC_LRFD99V14
    val API_RP2A_LRFD97: API_RP2A_LRFD97V14
    val API_RP2A_WSD2000: API_RP2A_WSD2000V14
    val ASCE_10_97: ASCE_10_97V14
    val BS5950_2000: BS5950_2000V14
    val BS5950_90: BS5950_90V14
    val Chinese_2002: Chinese_2002V14
    val CISC_95: CISC_95V14
    val Eurocode_3_1993: Eurocode_3_1993V14
    val Eurocode_3_2005: Eurocode_3_2005V14
    val Indian_IS_800_1998: Indian_IS_800_1998V14
    val Italian_UNI_10011: Italian_UNI_10011V14
    val UBC97_ASD: UBC97_ASDV14
    val UBC97_LRFD: UBC97_LRFDV14

    /**
     * This function deletes all steel frame design results.
     * @return zero if the results are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteResults(): Int =
            callFunctionInt("DeleteResults")

    /**
     * This function retrieves the steel design code.
     * @param codeName This is one of the following steel design code names.
     * * AASHTO Steel 04
     * * AISC-ASD01
     * * AISC-ASD89
     * * AISC360-05/IBC2006
     * * AISC-LRFD99
     * * AISC-LRFD93
     * * API RP2A-LRFD 97
     * * API RP2A-WSD2000
     * * ASCE 10-97
     * * BS5950 90
     * * BS5950 2000
     * * Chinese 2002
     * * CISC 95
     * * EUROCODE 3-1993
     * * EUROCODE 3-2005
     * * Indian IS:800-1998
     * * Italian UNI 10011
     * * UBC97-ASD
     * * UBC97-LRFD
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCode(codeName: AStringByRef): Int =
            callFunctionInt("GetCode", codeName)

    /**
     * This function retrieves the names of all load combinations selected as design combinations for steel deflection design.
     * @param numberItems The number of load combinations selected as design combinations for steel deflection design.
     * @param myName This is an array that includes the name of each response combination selected as a design combination for steel deflection design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getComboDeflection(numberItems: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetComboDeflection", numberItems, myName)

    /**
     * This function retrieves the names of all load combinations selected as design combinations for steel strength design.
     * @param numberItems The number of load combinations selected as design combinations for steel strength design.
     * @param myName This is an array that includes the name of each response combination selected as a design combination for steel strength design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getComboStrength(numberItems: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetComboStrength", numberItems, myName)

    /**
     * This function retrieves the design section for a specified steel frame object.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param propName The name of the design section for the specified frame object.
     * @return zero if the section is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDesignSection(name: String, propName: AStringByRef): Int =
            callFunctionInt("GetDesignSection", name, propName)

    /**
     * This function retrieves the names of all groups selected for steel design.
     * @param numberItems The number of groups selected for steel design.
     * @param myName This is an array that includes the name of each group selected for steel design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getGroup(numberItems: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetGroup", numberItems, myName)

    /**
     * This function retrieves summary results for steel design.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The number of frame objects for which results are obtained.
     * @param frameName This is an array that includes each frame object name for which results are obtained.
     * @param ratio This is an array that includes the controlling stress or capacity ratio for each frame object.
     * @param ratioType This is an array that includes 1, 2, 3, 4, 5 or 6, indicating the controlling stress or capacity ratio type for each frame object.
     * * 1 = PMM
     * * 2 = Major shear
     * * 3 = Minor shear
     * * 4 = Major beam-column capacity ratio
     * * 5 = Minor beam-column capacity ratio
     * * 6 = Other
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
    fun getSummaryResults(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, ratio: ADoubleArrayByRef, ratioType: AIntArrayByRef, location: ADoubleArrayByRef, comboName: AStringArrayByRef, errorSummary: AStringArrayByRef, warningSummary: AStringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetSummaryResults", name, numberItems, frameName, ratio, ratioType, location, comboName, errorSummary, warningSummary, itemType)

    /**
     * This function retrieves lateral displacement targets for steel design.
     * @param numberItems The number of lateral displacement targets specified.
     * @param loadCase This is an array that includes the name of the static linear load case associated with each lateral displacement target.
     * @param point This is an array that includes the name of the point object associated to which the lateral displacement target applies.
     * @param displ This is an array that includes the lateral displacement target. (L)
     * @param active If this item is True, all specified lateral displacement targets are active. If it is False, they are inactive.
     * @return zero if the targets are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTargetDispl(numberItems: AIntByRef, loadCase: AStringArrayByRef, point: AStringArrayByRef, displ: ADoubleArrayByRef, active: ABooleanByRef): Int =
            callFunctionInt("GetTargetDispl", numberItems, loadCase, point, displ, active)

    /**
     * This function retrieves time period targets for steel design.
     * @param numberItems The number of lateral displacement targets specified.
     * @param modalCase The name of the modal load case for which the target periods apply.
     * @param mode This is an array that includes the mode number associated with each target period.
     * @param period This is an array that includes the target periods. (s)
     * @param active If this item is True, all specified target periods are active. If it is False, they are inactive.
     * @return zero if the targets are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTargetPeriod(numberItems: AIntByRef, modalCase: AStringByRef, mode: AIntArrayByRef, period: ADoubleArrayByRef, active: ABooleanByRef): Int =
            callFunctionInt("GetTargetPeriod", numberItems, modalCase, mode, period, active)

    /**
     * This function resets all steel frame design overwrites to default values.
     * The function will fail if no steel frame objects are present.
     * @return zero if the overwrites are successfully reset; otherwise it returns a nonzero value.
     */
    fun resetOverwrites(): Int =
            callFunctionInt("ResetOverwrites")

    /**
     * This function removes the auto select section assignments from all specified frame objects that have a steel frame design procedure.
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
     * This function sets the steel design code.
     * @param codeName This is one of the following steel design code names.
     * * AASHTO Steel 04
     * * AISC-ASD01
     * * AISC-ASD89
     * * AISC360-05/IBC2006
     * * AISC-LRFD99
     * * AISC-LRFD93
     * * API RP2A-LRFD 97
     * * API RP2A-WSD2000
     * * ASCE 10-97
     * * BS5950 90
     * * BS5950 2000
     * * Chinese 2002
     * * CISC 95
     * * EUROCODE 3-1993
     * * EUROCODE 3-2005
     * * Indian IS:800-1998
     * * Italian UNI 10011
     * * UBC97-ASD
     * * UBC97-LRFD
     * @return zero if the code is successfully set; otherwise it returns a nonzero value.
     */
    fun setCode(codeName: String): Int =
            callFunctionInt("SetCode", codeName)

    /**
     * This function selects or deselects a load combination for steel deflection design.
     * @param name The name of an existing load combination.
     * @param selected If this item is True, the specified load combination is selected as a design combination for steel deflection design. If it is False, the combination is not selected for steel deflection design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setComboDeflection(name: String, selected: Boolean): Int =
            callFunctionInt("SetComboDeflection", name, selected)

    /**
     * This function selects or deselects a load combination for steel strength design.
     * @param name The name of an existing load combination.
     * @param selected If this item is True, the specified load combination is selected as a design combination for steel strength design. If it is False, the combination is not selected for steel strength design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setComboStrength(name: String, selected: Boolean): Int =
            callFunctionInt("SetComboStrength", name, selected)

    /**
     * This function modifies the design section for all specified frame objects that have a steel frame design procedure.
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
     * This function selects or deselects a group for steel design.
     * @param name The name of an existing group.
     * @param selected If this item is True, the specified group is selected as a design group for steel design. If it is False, the group is not selected for steel design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setGroup(name: String, selected: Boolean): Int =
            callFunctionInt("SetGroup", name, selected)

    /**
     * This function sets lateral displacement targets for steel design.
     * @param numberItems The number of lateral displacement targets specified.
     * @param loadCase This is an array that includes the name of the static linear load case associated with each lateral displacement target.
     * @param point This is an array that includes the name of the point object associated to which the lateral displacement target applies.
     * @param displ This is an array that includes the lateral displacement target. (L)
     * @param active If this item is True, all specified lateral displacement targets are active. If it is False, they are inactive.
     * @return zero if the targets are successfully set; otherwise it returns a nonzero value.
     */
    fun setTargetDispl(numberItems: Int, loadCase: AStringArrayByRef, point: AStringArrayByRef, displ: ADoubleArrayByRef, active: Boolean = true): Int =
            callFunctionInt("SetTargetDispl", numberItems, loadCase, point, displ, active)

    /**
     * This function sets time period targets for steel design.
     * @param numberItems The number of lateral displacement targets specified.
     * @param modalCase The name of the modal load case for which the target periods apply.
     * @param mode This is an array that includes the mode number associated with each target period.
     * @param period This is an array that includes the target periods. (s)
     * @param active If this item is True, all specified target periods are active. If it is False, they are inactive.
     * @return zero if the targets are successfully set; otherwise it returns a nonzero value.
     */
    fun setTargetPeriod(numberItems: Int, modalCase: String, mode: AIntArrayByRef, period: ADoubleArrayByRef, active: Boolean = true): Int =
            callFunctionInt("SetTargetPeriod", numberItems, modalCase, mode, period, active)

    /**
     * This function starts the steel frame design.
     * The function will fail if no steel frame objects are present. It will also fail if analysis results are not available.
     * @return zero if the steel frame design is successfully started; otherwise it returns a nonzero value.
     */
    fun startDesign(): Int =
            callFunctionInt("StartDesign")

    /**
     * This function retrieves the names of the frame objects that did not pass the design check or have not yet been checked, if any.
     * @param numberItems The number of steel frame objects that did not pass the design check or have not yet been checked.
     * @param n1 The number of steel frame objects that did not pass the design check.
     * @param n2 The number of steel frame objects that have not yet been checked.
     * @param myName This is an array that includes the name of each frame object that did not pass the design check or has not yet been checked.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifyPassed(numberItems: AIntByRef, n1: AIntByRef, n2: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("VerifyPassed", numberItems, n1, n2, myName)

    /**
     * This function retrieves the names of the frame objects that have different analysis and design sections, if any.
     * @param numberItems The number of frame objects that have different analysis and design sections.
     * @param myName This is an array that includes the name of each frame object that has different analysis and design sections.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifySections(numberItems: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("VerifySections", numberItems, myName)
}