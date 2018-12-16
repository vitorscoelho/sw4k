package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface AISC_LRFD99V14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 37, inclusive, indicating the overwrite item considered.
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
     * * 30 = Expected to specified Fy ratio, Ry
     * * 31 = Compressive capacity, phi*Pnc
     * * 32 = Tensile capacity, phi*Pnt
     * * 33 = Major bending capacity, phi*Mn3
     * * 34 = Minor bending capacity, phi*Mn2
     * * 35 = Major shear capacity, phi*Vn2
     * * 36 = Minor shear capacity, phi*Vn3
     * * 37 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = OMF
     * * 2 = IMF
     * * 3 = SMF
     * * 4 = OCBF
     * * 5 = SCBF
     * * 6 = EBF
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
     * * 25 = Non-sway moment factor, B1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Non-sway moment factor, B1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Sway moment factor, B2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Sway moment factor, B2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 30 = Expected to specified Fy ratio, Ry
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Compressive capacity, phi*Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 32 = Tensile capacity, phi*Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 33 = Major bending capacity, phi*Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 34 = Minor bending capacity, phi*Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 35 = Major shear capacity, phi*Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 36 = Minor shear capacity, phi*Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 37 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY, progDet: ABooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 21, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic design capacity
     * * 3 = Phi bending
     * * 4 = Phi compression
     * * 5 = Phi tension - yielding
     * * 6 = Phi tension - fracture
     * * 7 = Phi shear
     * * 8 = Phi shear - torsion
     * * 9 = Phi compression, angle
     * * 10 = Ignore seismic code
     * * 11 = Ignore special seismic code
     * * 12 = Is doubler plate plug-welded
     * * 13 = Consider deflection
     * * 14 = DL deflection limit, L/Value
     * * 15 = SDL + LL deflection limit, L/Value
     * * 16 = LL deflection limit, L/Value
     * * 17 = Total deflection limit, L/Value
     * * 18 = Total camber limit, L/Value
     * * 19 = Pattern live load factor
     * * 20 = Demand capacity ratio limit
     * * 21 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = OMF
     * * 2 = IMF
     * * 3 = SMF
     * * 4 = OCBF
     * * 5 = SCBF
     * * 6 = EBF
     * * 2 = Seismic design capacity
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * * 3 = Phi bending
     * * Value > 0
     * * 4 = Phi compression
     * * Value > 0
     * * 5 = Phi tension � yielding
     * * Value > 0
     * * 6 = Phi tension - fracture
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Phi shear - torsion
     * * Value > 0
     * * 9 = Phi compression, angle
     * * Value > 0
     * * 10 = Ignore seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 11 = Ignore special seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 12 = Is doubler plate plug-welded
     * * 0 = No
     * * Any other value = Yes
     * * 13 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 14 = DL deflection limit, L/Value
     * * Value > 0
     * * 15 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 16 = LL deflection limit, L/Value
     * * Value > 0
     * * 17 = Total deflection limit, L/Value
     * * Value > 0
     * * 18 = Total camber limit, L/Value
     * * Value > 0
     * * 19 = Pattern live load factor
     * * Value >= 0
     * * 20 = Demand capacity ratio limit
     * * Value > 0
     * * 21 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 37, inclusive, indicating the overwrite item considered.
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
     * * 30 = Expected to specified Fy ratio, Ry
     * * 31 = Compressive capacity, phi*Pnc
     * * 32 = Tensile capacity, phi*Pnt
     * * 33 = Major bending capacity, phi*Mn3
     * * 34 = Minor bending capacity, phi*Mn2
     * * 35 = Major shear capacity, phi*Vn2
     * * 36 = Minor shear capacity, phi*Vn3
     * * 37 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = OMF
     * * 2 = IMF
     * * 3 = SMF
     * * 4 = OCBF
     * * 5 = SCBF
     * * 6 = EBF
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
     * * 30 = Expected to specified Fy ratio, Ry
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Compressive capacity, phi*Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 32 = Tensile capacity, phi*Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 33 = Major bending capacity, phi*Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 34 = Minor bending capacity, phi*Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 35 = Major shear capacity, phi*Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 36 = Minor shear capacity, phi*Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 37 = Demand/capacity ratio limit
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
     * @param item This is an integer between 1 and 21, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic design capacity
     * * 3 = Phi bending
     * * 4 = Phi compression
     * * 5 = Phi tension - yielding
     * * 6 = Phi tension - fracture
     * * 7 = Phi shear
     * * 8 = Phi shear - torsion
     * * 9 = Phi compression, angle
     * * 10 = Ignore seismic code
     * * 11 = Ignore special seismic code
     * * 12 = Is doubler plate plug-welded
     * * 13 = Consider deflection
     * * 14 = DL deflection limit, L/Value
     * * 15 = SDL + LL deflection limit, L/Value
     * * 16 = LL deflection limit, L/Value
     * * 17 = Total deflection limit, L/Value
     * * 18 = Total camber limit, L/Value
     * * 19 = Pattern live load factor
     * * 20 = Demand capacity ratio limit
     * * 21 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = OMF
     * * 2 = IMF
     * * 3 = SMF
     * * 4 = OCBF
     * * 5 = SCBF
     * * 6 = EBF
     * * 2 = Seismic design capacity
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * * 3 = Phi bending
     * * Value > 0
     * * 4 = Phi compression
     * * Value > 0
     * * 5 = Phi tension � yielding
     * * Value > 0
     * * 6 = Phi tension - fracture
     * * Value > 0
     * * 7 = Phi shear
     * * Value > 0
     * * 8 = Phi shear - torsion
     * * Value > 0
     * * 9 = Phi compression, angle
     * * Value > 0
     * * 10 = Ignore seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 11 = Ignore special seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 12 = Is doubler plate plug-welded
     * * 0 = No
     * * Any other value = Yes
     * * 13 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 14 = DL deflection limit, L/Value
     * * Value > 0
     * * 15 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 16 = LL deflection limit, L/Value
     * * Value > 0
     * * 17 = Total deflection limit, L/Value
     * * Value > 0
     * * 18 = Total camber limit, L/Value
     * * Value > 0
     * * 19 = Pattern live load factor
     * * Value >= 0
     * * 20 = Demand capacity ratio limit
     * * Value > 0
     * * 21 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by-Step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("GetPreference", item, value)

}