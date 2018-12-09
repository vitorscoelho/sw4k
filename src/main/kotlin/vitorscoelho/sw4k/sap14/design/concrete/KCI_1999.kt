import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class KCI_1999 internal constructor(programName: String) : KCI_1999V14 {
    override val activeXComponentName: String = "$programName.cDCoKCI_1999"
}

interface KCI_1999V14 : SapComponent {
    /**
     * This function retrieves the value of a concrete design overwrite item.
     * @param name The name of a frame object with a concrete frame design procedure.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, K Major
     * * 6 = Effective length factor, K Minor
     * * 7 = Moment coefficient, Cm Major
     * * 8 = Moment coefficient, Cm Minor
     * * 9 = Non-sway moment factor, Dns Major
     * * 10 = Non-sway moment factor, Dns Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway special
     * * 2 = Sway intermediate
     * * 3 = Sway ordinary
     * * 4 = Non-sway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Non-sway moment factor, Dns Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Non-sway moment factor, Dns Minor
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Sway moment factor, Ds Major
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Sway moment factor, Ds Minor
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a concrete design preference item.
     * @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Consider minimum eccentricity
     * * 4 = Phi bending tension
     * * 5 = Phi compression controlled tied
     * * 6 = Phi compression controlled spiral
     * * 7 = Phi shear
     * * 8 = Pattern live load factor
     * * 9 = Utilization factor limit
     * * 10 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Phi bending tension
     * * Value > 0
     * * 5 = Phi compression controlled tied
     * * Value > 0
     * * 6 = Phi compression controlled spiral
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Pattern live load factor
     * * Value >= 0
     * * 9 = Utilization factor limit
     * * Value > 0
     * * 10 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a concrete design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, K Major
     * * 6 = Effective length factor, K Minor
     * * 7 = Moment coefficient, Cm Major
     * * 8 = Moment coefficient, Cm Minor
     * * 9 = Non-sway moment factor, Dns Major
     * * 10 = Non-sway moment factor, Dns Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway special
     * * 2 = Sway intermediate
     * * 3 = Sway ordinary
     * * 4 = Non-sway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Non-sway moment factor, Dns Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Non-sway moment factor, Dns Minor
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Sway moment factor, Ds Major
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Sway moment factor, Ds Minor
     * * Value >= 0; 0 means use program determined value.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a concrete design preference item.
     * @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Consider minimum eccentricity
     * * 4 = Phi bending tension
     * * 5 = Phi compression controlled tied
     * * 6 = Phi compression controlled spiral
     * * 7 = Phi shear
     * * 8 = Pattern live load factor
     * * 9 = Utilization factor limit
     * * 10 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Phi bending tension
     * * Value > 0
     * * 5 = Phi compression controlled tied
     * * Value > 0
     * * 6 = Phi compression controlled spiral
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Pattern live load factor
     * * Value >= 0
     * * 9 = Utilization factor limit
     * * Value > 0
     * * 10 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}