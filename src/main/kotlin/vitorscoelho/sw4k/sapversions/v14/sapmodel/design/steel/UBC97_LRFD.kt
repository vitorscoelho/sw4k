package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface UBC97_LRFDV14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 36, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Omega0
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
     * * 20 = Effective length factor, K Major
     * * 21 = Effective length factor, K Minor
     * * 22 = Moment coefficient, Cm Major
     * * 23 = Moment coefficient, Cm Minor
     * * 24 = Bending coefficient, Cb
     * * 25 = Non-sway moment factor, B1 Major
     * * 26 = Non-sway moment factor, B1 Minor
     * * 27 = Sway moment factor, B2 Major
     * * 28 = Sway moment factor, B2 Minor
     * * 29 = Yield stress, Fy
     * * 30 = Compressive capacity, phi*Pnc
     * * 31 = Tensile capacity, phi*Pnt
     * * 32 = Major bending capacity, phi*Mn3
     * * 33 = Minor bending capacity, phi*Mn2
     * * 34 = Major shear capacity, phi*Vn2
     * * 35 = Minor shear capacity, phi*Vn3
     * * 36 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Omega0
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
     * * 20 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 24 = Bending coefficient, Cb
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Nonsway moment factor, B1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Nonsway moment factor, B1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Sway moment factor, B2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Sway moment factor, B2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 30 = Compressive capacity, phi*Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 31 = Tensile capacity, phi*Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 32 = Major bending capacity, phi*Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 33 = Minor bending capacity, phi*Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 34 = Major shear capacity, phi*Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 35 = Minor shear capacity, phi*Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 36 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 12, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Importance factor
     * * 3 = Seismic zone
     * * 4 = Phi bending
     * * 5 = Phi compression
     * * 6 = Phi tension
     * * 7 = Phi shear
     * * 8 = Phi compression angle
     * * 9 = Consider deflection
     * * 15 = Pattern live load factor
     * * 16 = Demand/capacity ratio limit
     * * 17 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Importance factor
     * * Value > 0
     * * 3 = Seismic zone
     * * 1 = Zone 0
     * * 2 = Zone 1
     * * 3 = Zone 2
     * * 4 = Zone 3
     * * 5 = Zone 4
     * * 3 = Lateral factor
     * * Value > 0
     * * 4 = Phi bending
     * * Value > 0
     * * 5 = Phi compression
     * * Value > 0
     * * 6 = Phi tension
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Phi compression angle
     * * Value > 0
     * * 9 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 14 = Total camber limit, L/Value
     * * Value > 0
     * * 15 = Pattern live load factor
     * * Value >= 0
     * * 16 = Demand/capacity ratio limit
     * * Value > 0
     * * 17 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 36, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Omega0
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
     * * 20 = Effective length factor, K Major
     * * 21 = Effective length factor, K Minor
     * * 22 = Moment coefficient, Cm Major
     * * 23 = Moment coefficient, Cm Minor
     * * 24 = Bending coefficient, Cb
     * * 25 = Non-sway moment factor, B1 Major
     * * 26 = Non-sway moment factor, B1 Minor
     * * 27 = Sway moment factor, B2 Major
     * * 28 = Sway moment factor, B2 Minor
     * * 29 = Yield stress, Fy
     * * 30 = Compressive capacity, phi*Pnc
     * * 31 = Tensile capacity, phi*Pnt
     * * 32 = Major bending capacity, phi*Mn3
     * * 33 = Minor bending capacity, phi*Mn2
     * * 34 = Major shear capacity, phi*Vn2
     * * 35 = Minor shear capacity, phi*Vn3
     * * 36 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Omega0
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
     * * 20 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 24 = Bending coefficient, Cb
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Nonsway moment factor, B1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Nonsway moment factor, B1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Sway moment factor, B2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Sway moment factor, B2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 30 = Compressive capacity, phi*Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 31 = Tensile capacity, phi*Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 32 = Major bending capacity, phi*Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 33 = Minor bending capacity, phi*Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 34 = Major shear capacity, phi*Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 35 = Minor shear capacity, phi*Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 36 = Demand/capacity ratio limit
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
     * This function sets the value of a steel design preference item.
     * @param item This is an integer between 1 and 17, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Importance factor
     * * 3 = Seismic zone
     * * 4 = Phi bending
     * * 5 = Phi compression
     * * 6 = Phi tension
     * * 7 = Phi shear
     * * 8 = Phi compression angle
     * * 9 = Consider deflection
     * * 10 = DL deflection limit, L/Value
     * * 11 = SDL + LL limit, L/Value
     * * 12 = Live load limit, L/Value
     * * 13 = Total limit, L/Value
     * * 14 = Total camber limit, L/Value
     * * 15 = Pattern live load factor
     * * 16 = Demand/capacity ratio limit
     * * 17 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Importance factor
     * * Value > 0
     * * 3 = Seismic zone
     * * 1 = Zone 0
     * * 2 = Zone 1
     * * 3 = Zone 2
     * * 4 = Zone 3
     * * 5 = Zone 4
     * * 3 = Lateral factor
     * * Value > 0
     * * 4 = Phi bending
     * * Value > 0
     * * 5 = Phi compression
     * * Value > 0
     * * 6 = Phi tension
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Phi compression angle
     * * Value > 0
     * * 9 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 10 = DL limit, L/Value
     * * Value > 0
     * * 11 = Super DL + LL limit, L/Value
     * * Value > 0
     * * 12 = Live load limit, L/Value
     * * Value > 0
     * * 13 = Total limit, L/Value
     * * Value > 0
     * * 14 = Total camber limit, L/Value
     * * Value > 0
     * * 15 = Pattern live load factor
     * * Value >= 0
     * * 16 = Demand/capacity ratio limit
     * * Value > 0
     * * 17 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}