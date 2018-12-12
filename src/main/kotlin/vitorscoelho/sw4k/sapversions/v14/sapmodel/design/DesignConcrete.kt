package vitorscoelho.sw4k.sapversions.v14.sapmodel.design

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.*

interface DesignConcreteV14 : SapComponent {
    val ACI_318_02: ACI_318_02V14
    val ACI_318_05_IBC_2003: ACI_318_05_IBC_2003V14
    val ACI_318_99: ACI_318_99V14
    val Australian_AS_3600_01: Australian_AS_3600_01V14
    val BS8110_89: BS8110_89V14
    val BS8110_97: BS8110_97V14
    val Chinese: ChineseV14
    val CSA_A23304: CSA_A23304V14
    val CSA_A23394: CSA_A23394V14
    val Eurocode_2_1992: Eurocode_2_1992V14
    val Eurocode_2_2004: Eurocode_2_2004V14
    val Hong_Kong_CP_2004: Hong_Kong_CP_2004V14
    val Indian_IS_456_2000: Indian_IS_456_2000V14
    val Italian_Dm_14_292: Italian_Dm_14_292V14
    val KCI_1999: KCI_1999V14
    val Mexican_RCDF_2001: Mexican_RCDF_2001V14
    val NZS_3101_95: NZS_3101_95V14
    val Singapore_CP_6599: Singapore_CP_6599V14
    val UBC_97: UBC_97V14

    /**
     * This function deletes all concrete frame design results.
     * None
     * @return zero if the results are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteResults(): Int =
            callFunctionInt("DeleteResults")

    /**
     * This function retrieves the concrete design code.
     * @param codeName This is one of the following concrete design code names.
     * * AASHTO Concrete 97
     * * ACI 318-05/IBC2003
     * * ACI 318-02
     * * ACI 318-99
     * * AS 3600-01
     * * BS8110 89
     * * BS8110 97
     * * Chinese 2002
     * * CSA A23.3-04
     * * CSA-A23.3-94
     * * EUROCODE 2-1992
     * * EUROCODE 2-2004
     * * Hong Kong CP 2004
     * * Indian IS 456-2000
     * * Italian DM 14-2-92
     * * KCI-1999
     * * Mexican RCDF 2001
     * * NZS 3101-95
     * * Singapore CP 65:99
     * * UBC97
     * @return zero if the code is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCode(codeName: StringByRef): Int =
            callFunctionInt("GetCode", codeName)

    /**
     * This function retrieves the names of all load combinations selected as design combinations for concrete strength design.
     * @param numberItems The number of load combinations selected as design combinations for concrete strength design.
     * @param myName This is an array that includes the name of each response combination selected as a design combination for concrete strength design.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getComboStrength(numberItems: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetComboStrength", numberItems, myName)

    /**
     * This function retrieves the design section for a specified concrete frame object.
     * @param name The name of a frame object with a concrete frame design procedure.
     * @param propName The name of the design section for the specified frame object.
     * @return zero if the section is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDesignSection(name: String, propName: StringByRef): Int =
            callFunctionInt("GetDesignSection", name, propName)

    /**
     * This function retrieves summary results for concrete design.
     * Note that torsional design is only included for some codes.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The number of frame objects for which results are obtained.
     * @param frameName This is an array that includes each frame object name for which results are obtained.
     * @param location This is an array that includes the distance from the I-end of the frame object to the location where the results are reported. (L)
     * @param topCombo This is an array that includes the name of the design combination for which the controlling top longitudinal rebar area for flexure occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param topArea This is an array that includes the total top longitudinal rebar area required for the flexure at the specified location. It does not include the area of steel required for torsion. (L2)
     * @param botCombo This is an array that includes the name of the design combination for which the controlling bottom longitudinal rebar area for flexure occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific, multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param botArea This is an array that includes the total bottom longitudinal rebar area required for the flexure at the specified location. It does not include the area of steel required for torsion. (L2)
     * @param vmajorCombo This is an array that includes the name of the design combination for which the controlling shear occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific, multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param vmajorArea This is an array that includes the required area of transverse shear reinforcing per unit length along the frame object for shear at the specified location. (L2/L)
     * @param tLCombo This is an array that includes the name of the design combination for which the controlling longitudinal rebar area for torsion occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific, multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param tLArea This is an array that includes the total longitudinal rebar area required for torsion. (L2)
     * @param tTCombo This is an array that includes the name of the design combination for which the controlling transverse reinforcing for torsion occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific, multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param tTArea This is an array that includes the required area of transverse torsional shear reinforcing per unit length along the frame object for torsion at the specified location. (L2/L)
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
    fun getSummaryResultsBeam(name: String, numberItems: IntByRef, frameName: StringArrayByRef, location: DoubleArrayByRef, topCombo: StringArrayByRef, topArea: DoubleArrayByRef, botCombo: StringArrayByRef, botArea: DoubleArrayByRef, vmajorCombo: StringArrayByRef, vmajorArea: DoubleArrayByRef, tLCombo: StringArrayByRef, tLArea: DoubleArrayByRef, tTCombo: StringArrayByRef, tTArea: DoubleArrayByRef, errorSummary: StringArrayByRef, warningSummary: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetSummaryResultsBeam", name, numberItems, frameName, location, topCombo, topArea, botCombo, botArea, vmajorCombo, vmajorArea, tLCombo, tLArea, tTCombo, tTArea, errorSummary, warningSummary, itemType)

    /**
     * This function retrieves summary results for concrete design.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The number of frame objects for which results are obtained.
     * @param frameName This is an array that includes each frame object name for which results are obtained.
     * @param myOption This is an array that includes 1 or 2, indicating the design option for each frame object.
     * * 1 = Check
     * * 2 = Design
     * @param location This is an array that includes the distance from the I-end of the frame object to the location where the results are reported. (L)
     * @param pMMCombo This is an array that includes the name of the design combination for which the controlling PMM ratio or rebar area occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param pMMArea This is an array that includes the total longitudinal rebar area required for the axial force plus biaxial moment (PMM) design at the specified location. (L2)
     * This item applies only when MyOption = 2 (design).
     * @param pMMRatio This is an array that includes the axial force plus biaxial moment (PMM) stress ratio at the specified location.
     * VmajorComboitem applies only when MyOption = 1 (check).
     * @param vmajorCombo This is an array that includes the name of the design combination for which the controlling major shear occurs.
     * @param aVmajor This is an array that includes the required area of transverse shear reinforcing per unit length along the frame object for major shear at the specified location. (L2/L)
     * @param vminorCombo This is an array that includes the name of the design combination for which the controlling minor shear occurs.
     * @param aVminor This is an array that includes the required area of transverse shear reinforcing per unit length along the frame object for minor shear at the specified location. (L2/L)
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
    fun getSummaryResultsColumn(name: String, numberItems: IntByRef, frameName: StringArrayByRef, myOption: IntArrayByRef, location: DoubleArrayByRef, pMMCombo: StringArrayByRef, pMMArea: DoubleArrayByRef, pMMRatio: DoubleArrayByRef, vmajorCombo: StringArrayByRef, aVmajor: DoubleArrayByRef, vminorCombo: StringArrayByRef, aVminor: DoubleArrayByRef, errorSummary: StringArrayByRef, warningSummary: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetSummaryResultsColumn", name, numberItems, frameName, myOption, location, pMMCombo, pMMArea, pMMRatio, vmajorCombo, aVmajor, vminorCombo, aVminor, errorSummary, warningSummary, itemType)

    /**
     * This function retrieves summary results for concrete design.
     * Note that joint design is only included for some codes.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The number of frame objects for which results are obtained.
     * @param frameName This is an array that includes each frame object name for which results are obtained.
     * @param lCJSRatioMajor This is an array that includes the name of the design combination for which the controlling joint shear ratio associated with the column major axis occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param jSRatioMajor This is an array that includes the joint shear ratio associated with the column major axis. This is the joint shear divided by the joint shear capacity.
     * @param lCJSRatioMinor This is an array that includes the name of the design combination for which the controlling joint shear ratio associated with the column minor axis occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param jSRatioMinor This is an array that includes the joint shear ratio associated with the column minor axis. This is the joint shear divided by the joint shear capacity.
     * @param lCBCCRatioMajor This is an array that includes the name of the design combination for which the controlling beam/column capacity ratio associated with the column major axis occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param bCCRatioMajor This is an array that includes the beam/column capacity ratio associated with the column major axis. This is the sum of the column capacities divided by the sum of the beam capacities at the top of the specified column.
     * @param lCBCCRatioMinor This is an array that includes the name of the design combination for which the controlling beam/column capacity ratio associated with the column minor axis occurs. A combination name followed by (Sp) indicates that the design loads were obtained by applying special, code-specific multipliers to all or part of the specified design load combination, or that the design was based on the capacity of other objects (or other design locations for the same object).
     * @param bCCRatioMinor This is an array that includes the beam/column capacity ratio associated with the column minor axis. This is the sum of the column capacities divided by the sum of the beam capacities at the top of the specified column.
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
    fun getSummaryResultsJoint(name: String, numberItems: IntByRef, frameName: StringArrayByRef, lCJSRatioMajor: StringArrayByRef, jSRatioMajor: DoubleArrayByRef, lCJSRatioMinor: StringArrayByRef, jSRatioMinor: DoubleArrayByRef, lCBCCRatioMajor: StringArrayByRef, bCCRatioMajor: DoubleArrayByRef, lCBCCRatioMinor: StringArrayByRef, bCCRatioMinor: DoubleArrayByRef, errorSummary: StringArrayByRef, warningSummary: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetSummaryResultsJoint", name, numberItems, frameName, lCJSRatioMajor, jSRatioMajor, lCJSRatioMinor, jSRatioMinor, lCBCCRatioMajor, bCCRatioMajor, lCBCCRatioMinor, bCCRatioMinor, errorSummary, warningSummary, itemType)

    /**
     * This function resets all concrete frame design overwrites to default values.
     * The function will fail if no concrete frame objects are present.
     * None
     * @return zero if the overwrites are successfully reset; otherwise it returns a nonzero value.
     */
    fun resetOverwrites(): Int =
            callFunctionInt("ResetOverwrites")

    /**
     * This function sets the concrete design code.
     * @param codeName This is one of the following concrete design code names.
     * * AASHTO Concrete 97
     * * ACI 318-05/IBC2003
     * * ACI 318-02
     * * ACI 318-99
     * * AS 3600-01
     * * BS8110 89
     * * BS8110 97
     * * Chinese 2002
     * * CSA A23.3-04
     * * CSA-A23.3-94
     * * EUROCODE 2-1992
     * * EUROCODE 2-2004
     * * Hong Kong CP 2004
     * * Indian IS 456-2000
     * * Italian DM 14-2-92
     * * KCI-1999
     * * Mexican RCDF 2001
     * * NZS 3101-95
     * * Singapore CP 65:99
     * * UBC97
     * @return zero if the code is successfully set; otherwise it returns a nonzero value.
     */
    fun setCode(codeName: String): Int =
            callFunctionInt("SetCode", codeName)

    /**
     * This function selects or deselects a load combination for concrete strength design.
     * @param name The name of an existing load combination.
     * @param selected If this item is True, the specified load combination is selected as a design combination for concrete strength design. If it is False, the combination is not selected for concrete strength design.
     * @return zero if the selection status is successfully set; otherwise it returns a nonzero value.
     */
    fun setComboStrength(name: String, selected: Boolean): Int =
            callFunctionInt("SetComboStrength", name, selected)

    /**
     * This function modifies the design section for all specified frame objects that have a concrete frame design procedure.
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
     * This function starts the concrete frame design.
     * The function will fail if no concrete frame objects are present. It also will fail if analysis results are not available.
     * @return zero if the concrete frame design is successfully started; otherwise it returns a nonzero value.
     */
    fun startDesign(): Int =
            callFunctionInt("StartDesign")

    /**
     * This function retrieves the names of the frame objects that did not pass the design check or have not yet been checked, if any.
     * @param numberItems The number of concrete frame objects that did not pass the design check or have not yet been checked.
     * @param n1 The number of concrete frame objects that did not pass the design check.
     * @param n2 The number of concrete frame objects that have not yet been checked.
     * @param myName This is an array that includes the name of each frame object that did not pass the design check or has not yet been checked.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifyPassed(numberItems: IntByRef, n1: IntByRef, n2: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("VerifyPassed", numberItems, n1, n2, myName)

    /**
     * This function retrieves the names of the frame objects that have different analysis and design sections, if any.
     * @param numberItems The number of frame objects that have different analysis and design sections.
     * @param myName This is an array that includes the name of each frame object that has different analysis and design sections.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun verifySections(numberItems: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("VerifySections", numberItems, myName)
}