package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface Italian_UNI_10011V14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 26, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Axial load amplification(Omega)
     * * 3 = Consider deflection
     * * 4 = Deflection check type
     * * 5 = DL deflection limit, L/Value
     * * 6 = SDL + LL deflection limit, L/Value
     * * 7 = LL deflection limit, L/Value
     * * 8 = Total load deflection limit, L/Value
     * * 9 = Total camber limit, L/Value
     * * 10 = DL deflection limit, absolute
     * * 11 = SDL + LL deflection limit, absolute
     * * 12 = LL deflection limit, absolute
     * * 13 = Total load deflection limit, absolute
     * * 14 = Total camber limit, absolute
     * * 15 = Specified camber
     * * 16 = Net area to total area ratio
     * * 17 = Live load reduction factor
     * * 18 = Unbraced length ratio, Major
     * * 19 = Unbraced length ratio, Minor Lateral Torsional Buckling
     * * 20 = Effective length factor, Beta Major
     * * 21 = Effective length factor, Beta Minor
     * * 22 = Moment coefficient, Meq/Mmax Major
     * * 23 = Moment coefficient, Meq/Mmax Minor
     * * 24 = LTB moment coefficient (Omega1)
     * * 25 = Yield stress, Fy
     * * 26 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway Frame
     * * 2 = NonSway Frame
     * * 2 = Axial load amplification(Omega)
     * * Value >= 0; 0 means use a program determined value.
     * * 3 = Consider deflection
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 4 = Deflection check type
     * * 0 = Program default
     * * 1 = Ratio
     * * 2 = Absolute
     * * 3 = Both
     * * 5 = DL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 6 = SDL + LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 7 = LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 8 = Total load deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 9 = Total camber limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 10 = DL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 11 = SDL + LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 12 = LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 13 = Total load deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 14 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 15 = Specified camber
     * * Value >= 0. (L)
     * * 16 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 17 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 18 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 19 = Unbraced length ratio, Minor Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 20 = Effective length factor, Beta Major
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, Beta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Moment coefficient, Meq/Mmax Major
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Moment coefficient, Meq/Mmax Minor
     * * Value >= 0; 0 means use program determined value.
     * * 24 = LTB moment coefficient (Omega1)
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 26 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY, progDet: ABooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Consider deflection
     * * 3 = DL deflection limit, L/Value
     * * 4 = SDL + LL deflectionlimit, L/Value
     * * 5 = LL deflection limit, L/Value
     * * 6 = Total deflectionlimit, L/Value
     * * 7 = Total camber limit, L/Value
     * * 8 = Pattern live load factor
     * * 9 = Demand/capacity ratio limit
     * * 10 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Sway Frame
     * * 2 = NonSway Frame
     * * 2 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 3 = DL deflection limit, L/Value
     * * Value > 0
     * * 4 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 5 = LL deflection limit, L/Value
     * * Value > 0
     * * 6 = Total deflection limit, L/Value
     * * Value > 0
     * * 7 = Total camber limit, L/Value
     * * Value > 0
     * * 8 = Pattern live load factor
     * * Value >= 0
     * * 9 = Demand/capacity ratio limit
     * * Value > 0
     * * 10 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 26, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Axial load amplification(Omega)
     * * 3 = Consider deflection
     * * 4 = Deflection check type
     * * 5 = DL deflection limit, L/Value
     * * 6 = SDL + LL deflection limit, L/Value
     * * 7 = LL deflection limit, L/Value
     * * 8 = Total load deflection limit, L/Value
     * * 9 = Total camber limit, L/Value
     * * 10 = DL deflection limit, absolute
     * * 11 = SDL + LL deflection limit, absolute
     * * 12 = LL deflection limit, absolute
     * * 13 = Total load deflection limit, absolute
     * * 14 = Total camber limit, absolute
     * * 15 = Specified camber
     * * 16 = Net area to total area ratio
     * * 17 = Live load reduction factor
     * * 18 = Unbraced length ratio, Major
     * * 19 = Unbraced length ratio, Minor Lateral TorsionalBuckling
     * * 20 = Effective length factor, Beta Major
     * * 21 = Effective length factor, Beta Minor
     * * 22 = Moment coefficient, Meq/Mmax Major
     * * 23 = Moment coefficient, Meq/Mmax Minor
     * * 24 = LTB moment coefficient (Omega1)
     * * 25 = Yield stress, Fy
     * * 26 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway Frame
     * * 2 = NonSway Frame
     * * 2 = Axial load amplification(Omega)
     * * Value >= 0; 0 means use a program determined value.
     * * 3 = Consider deflection
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 4 = Deflection check type
     * * 0 = Program default
     * * 1 = Ratio
     * * 2 = Absolute
     * * 3 = Both
     * * 5 = DL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 6 = SDL + LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 7 = LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 8 = Total load deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 9 = Total camber limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 10 = DL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 11 = SDL + LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 12 = LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 13 = Total load deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 14 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 15 = Specified camber
     * * Value >= 0. (L)
     * * 16 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 17 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 18 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 19 = Unbraced length ratio, Minor Lateral TorsionalBuckling
     * * Value >= 0; 0 means use program determined value.
     * * 20 = Effective length factor, Beta Major
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, Beta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Moment coefficient, Meq/Mmax Major
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Moment coefficient, Meq/Mmax Minor
     * * Value >= 0; 0 means use program determined value.
     * * 24 = LTB moment coefficient (Omega1)
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 26 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjectst, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a steel design preference item.
     * @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Consider deflection
     * * 3 = DL deflection limit, L/Value
     * * 4 = SDL + LL deflectionlimit, L/Value
     * * 5 = LL deflection limit, L/Value
     * * 6 = Total deflectionlimit, L/Value
     * * 7 = Total camber limit, L/Value
     * * 8 = Pattern live load factor
     * * 9 = Demand/capacity ratio limit
     * * 10 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Sway Frame
     * * 2 = NonSway Frame
     * * 2 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 3 = DL deflection limit, L/Value
     * * Value > 0
     * * 4 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 5 = LL deflection limit, L/Value
     * * Value > 0
     * * 6 = Total deflection limit, L/Value
     * * Value > 0
     * * 7 = Total camber limit, L/Value
     * * Value > 0
     * * 8 = Pattern live load factor
     * * Value >= 0
     * * 9 = Demand/capacity ratio limit
     * * Value > 0
     * * 10 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}