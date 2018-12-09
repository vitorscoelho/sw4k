import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class Eurocode_2_2004 internal constructor(programName: String) : Eurocode_2_2004V14 {
    override val activeXComponentName: String = "$programName.cDCoEurocode_2-2004"
}

interface Eurocode_2_2004V14 : SapComponent {
    /**
     * This function retrieves the value of a concrete design overwrite item.
     * @param name The name of a frame object with a concrete frame design procedure.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, Beta Major
     * * 6 = Effective length factor, Beta Minor
     * * 7 = Moment coefficient, Cm Major
     * * 8 = Moment coefficient, Cm Minor
     * * 9 = Nonsway moment factor, Dns Major
     * * 10 = Nonsway moment factor, Dns Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway
     * * 2 = Nonsway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, Beta Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, Beta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Nonsway moment factor, Dns Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Nonsway moment factor, Dns Minor
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Sway moment factor, Ds Major
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Sway moment factor, Ds Minor
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise, it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a concrete design preference item.
     * @param item This is an integer between 1 and 16, inclusive, indicating the preference item considered.
     * * 1 = Country
     * * 2 = Combos equation
     * * 3 = Second order method
     * * 4 = Number of interaction curves
     * * 5 = Number of interaction points
     * * 6 = Consider minimum eccentricity
     * * 7 = Theta0
     * * 8 = Gamma steel
     * * 9 = Gamma concrete
     * * 10 = AlphaCC
     * * 11 = AlphaCT
     * * 12 = AlphaLCC
     * * 13 = AlphaLCT
     * * 14 = Pattern live load factor
     * * 15 = Utilization factor limit
     * * 16 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Country
     * * 1 = CEN Default
     * * 2 = United Kingdom
     * * 3 = Slovenia
     * * 2 = Combos equation
     * * 1 = Eq. 6.10
     * * 2 = Max of Eqs. 6.10a and 6.10b
     * * 3 = Second order method
     * * 1 = Nominal stiffness
     * * 2 = Nominal curvature
     * * 3 = None
     * * 4 = Number of interaction curves
     * * Value >= 4 and divisible by 4
     * * 5 = Number of interaction points
     * * Value >= 5 and odd
     * * 6 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 7 = Theta0
     * * Value > 0
     * * 8 = Gamma steel
     * * Value > 0
     * * 9 = Gamma concrete
     * * Value > 0
     * * 10 = AlphaCC
     * * Value > 0
     * * 11 = AlphaCT
     * * Value > 0
     * * 12 = AlphaLCC
     * * Value > 0
     * * 13 = AlphaLCT
     * * Value > 0
     * * 14 = Pattern live load factor
     * * Value >= 0
     * * 15 = Utilization factor limit
     * * Value > 0
     * * 16 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise, it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a concrete design overwrite item.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, Beta Major
     * * 6 = Effective length factor, Beta Minor
     * * 7 = Moment coefficient, Cm Major
     * * 8 = Moment coefficient, Cm Minor
     * * 9 = Nonsway moment factor, Dns Major
     * * 10 = Nonsway moment factor, Dns Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway
     * * 2 = Nonsway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, Beta Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, Beta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Nonsway moment factor, Dns Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Nonsway moment factor, Dns Minor
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
     * @return zero if the item is successfully set, otherwise it returns a nonzero value.
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a concrete design preference item.
     * @param item This is an integer between 1 and 16, inclusive, indicating the preference item considered.
     * * 1 = Country
     * * 2 = Combos equation
     * * 3 = Second order method
     * * 4 = Number of interaction curves
     * * 5 = Number of interaction points
     * * 6 = Consider minimum eccentricity
     * * 7 = Theta0
     * * 8 = Gamma steel
     * * 9 = Gamma concrete
     * * 10 = AlphaCC
     * * 11 = AlphaCT
     * * 12 = AlphaLCC
     * * 13 = AlphaLCT
     * * 14 = Pattern live load factor
     * * 15 = Utilization factor limit
     * * 16 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Country
     * * 1 = CEN Default
     * * 2 = United Kingdom
     * * 3 = Slovenia
     * * 2 = Combos equation
     * * 1 = Eq. 6.10
     * * 2 = Max of Eqs. 6.10a and 6.10b
     * * 3 = Second order method
     * * 1 = Nominal stiffness
     * * 2 = Nominal curvature
     * * 3 = None
     * * 4 = Number of interaction curves
     * * Value >= 4 and divisible by 4
     * * 5 = Number of interaction points
     * * Value >= 5 and odd
     * * 6 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 7 = Theta0
     * * Value > 0
     * * 8 = Gamma steel
     * * Value > 0
     * * 9 = Gamma concrete
     * * Value > 0
     * * 10 = AlphaCC
     * * Value > 0
     * * 11 = AlphaCT
     * * Value > 0
     * * 12 = AlphaLCC
     * * Value > 0
     * * 13 = AlphaLCT
     * * Value > 0
     * * 14 = Pattern live load factor
     * * Value >= 0
     * * 15 = Utilization factor limit
     * * Value > 0
     * * 16 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise, it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}