package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ObjectType

class GroupDef(programName: String) : GroupDefV14 {
    override val activeXComponentName: String = "$programName.cGroup"
}

interface GroupDefV14 : SapComponent {
    /**
     * Changing the name of group ALL will fail and return an error.
     * @param name The existing name of a defined group.
     * @param newName The new name for the group.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * This function clears (removes) all assignments from the specified group.
     * @param name The name of an existing group.
     * @return zero if the group assignment is successfully cleared, otherwise it returns a nonzero value.
     */
    fun clear(name: String): Int =
            callFunctionInt("Clear", name)

    /**
     * @return the number of defined groups.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes the specified group. It will return an error if an attempt is made to delete the Group named ALL.
     * @param name The name of an existing group.
     * @return zero if the group is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the assignments to a specified group.
     * @param name The name of an existing group.
     * @param numberItems The number of assignments made to the specified group.
     * @param objectType This is an array that includes the object type of each item in the group ([ObjectType] enumeration).
     * * 1 = Point object
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * * 7 = Link object
     * @param objectName This is an array that includes the name of each item in the group.
     * @return zero if the group assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getAssignments(name: String, numberItems: IntByRef, objectType: IntArrayByRef, objectName: StringArrayByRef): Int =
            callFunctionInt("GetAssignments", name, numberItems, objectType, objectName)

    /**
     * @param name The name of an existing group.
     * @param color The display color for the group specified as a Long.
     * @param specifiedForSelection This item is True if the group is specified to be used for selection; otherwise it is False.
     * @param specifiedForSectionCutDefinition This item is True if the group is specified to be used for defining section cuts; otherwise it is False.
     * @param specifiedForSteelDesign This item is True if the group is specified to be used for defining steel frame design groups; otherwise it is False.
     * @param specifiedForConcreteDesign This item is True if the group is specified to be used for defining concrete frame design groups; otherwise it is False.
     * @param specifiedForAluminumDesign This item is True if the group is specified to be used for defining aluminum frame design groups; otherwise it is False.
     * @param specifiedForColdFormedDesign This item is True if the group is specified to be used for defining cold formed frame design groups; otherwise it is False.
     * @param specifiedForStaticNLActiveStage This item is True if the group is specified to be used for defining stages for nonlinear static analysis; otherwise it is False.
     * @param specifiedForBridgeResponseOutput This item is True if the group is specified to be used for reporting bridge response output; otherwise it is False.
     * @param specifiedForAutoSeismicOutput This item is True if the group is specified to be used for reporting auto seismic loads; otherwise it is False.
     * @param specifiedForAutoWindOutput This item is True if the group is specified to be used for reporting auto wind loads; otherwise it is False.
     * @param specifiedForMassAndWeight This item is True if the group is specified to be used for reporting group masses and weight; otherwise it is False.
     * @return zero if the group data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getGroup(name: String, color: IntByRef, specifiedForSelection: BooleanByRef, specifiedForSectionCutDefinition: BooleanByRef, specifiedForSteelDesign: BooleanByRef, specifiedForConcreteDesign: BooleanByRef, specifiedForAluminumDesign: BooleanByRef, specifiedForColdFormedDesign: BooleanByRef, specifiedForStaticNLActiveStage: BooleanByRef, specifiedForBridgeResponseOutput: BooleanByRef, specifiedForAutoSeismicOutput: BooleanByRef, specifiedForAutoWindOutput: BooleanByRef, specifiedForMassAndWeight: BooleanByRef): Int =
            callFunctionInt("GetGroup", name, color, specifiedForSelection, specifiedForSectionCutDefinition, specifiedForSteelDesign, specifiedForConcreteDesign, specifiedForAluminumDesign, specifiedForColdFormedDesign, specifiedForStaticNLActiveStage, specifiedForBridgeResponseOutput, specifiedForAutoSeismicOutput, specifiedForAutoWindOutput, specifiedForMassAndWeight)

    /**
     * This function retrieves the names of all defined groups.
     * @param numberNames The number of group names retrieved by the program.
     * @param myName This is a one-dimensional array of group names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * @param name This is the name of a group. If this is the name of an existing group, that group is modified, otherwise a new group is added.
     * @param color The display color for the group specified as a Long. If this value is input as �1, the program automatically selects a display color for the group.
     * @param specifiedForSelection This item is True if the group is specified to be used for selection; otherwise it is False.
     * @param specifiedForSectionCutDefinition This item is True if the group is specified to be used for defining section cuts; otherwise it is False.
     * @param specifiedForSteelDesign This item is True if the group is specified to be used for defining steel frame design groups; otherwise it is False.
     * @param specifiedForConcreteDesign This item is True if the group is specified to be used for defining concrete frame design groups; otherwise it is False.
     * @param specifiedForAluminumDesign This item is True if the group is specified to be used for defining aluminum frame design groups; otherwise it is False.
     * @param specifiedForColdFormedDesign This item is True if the group is specified to be used for defining cold formed frame design groups; otherwise it is False.
     * @param specifiedForStaticNLActiveStage This item is True if the group is specified to be used for defining stages for nonlinear static analysis; otherwise it is False.
     * @param specifiedForBridgeResponseOutput This item is True if the group is specified to be used for reporting bridge response output; otherwise it is False.
     * @param specifiedForAutoSeismicOutput This item is True if the group is specified to be used for reporting auto seismic loads; otherwise it is False.
     * @param specifiedForAutoWindOutput This item is True if the group is specified to be used for reporting auto wind loads; otherwise it is False.
     * @param specifiedForMassAndWeight This item is True if the group is specified to be used for reporting group masses and weight; otherwise it is False.
     * @return zero if the group data is successfully set, otherwise it returns a nonzero value.
     */
    fun setGroup(name: String, color: Int = -1, specifiedForSelection: Boolean = true, specifiedForSectionCutDefinition: Boolean = true, specifiedForSteelDesign: Boolean = true, specifiedForConcreteDesign: Boolean = true, specifiedForAluminumDesign: Boolean = true, specifiedForColdFormedDesign: Boolean = true, specifiedForStaticNLActiveStage: Boolean = true, specifiedForBridgeResponseOutput: Boolean = true, specifiedForAutoSeismicOutput: Boolean = false, specifiedForAutoWindOutput: Boolean = false, specifiedForMassAndWeight: Boolean = true): Int =
            callFunctionInt("SetGroup", name, color, specifiedForSelection, specifiedForSectionCutDefinition, specifiedForSteelDesign, specifiedForConcreteDesign, specifiedForAluminumDesign, specifiedForColdFormedDesign, specifiedForStaticNLActiveStage, specifiedForBridgeResponseOutput, specifiedForAutoSeismicOutput, specifiedForAutoWindOutput, specifiedForMassAndWeight)
}