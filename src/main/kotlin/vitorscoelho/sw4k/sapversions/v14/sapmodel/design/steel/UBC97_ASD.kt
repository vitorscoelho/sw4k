package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface UBC97_ASDV14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 32, inclusive, indicating the overwrite item considered.
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
     * * 25 = Yield stress, Fy
     * * 26 = Compressive stress, Fa
     * * 27 = Tensile stress, Ft
     * * 28 = Major bending stress, Fb3
     * * 29 = Minor bending stress, Fb2
     * * 30 = Major shear stress, Fv2
     * * 31 = Minor shear stress, Fv3
     * * 32 = Demand/capacity ratio limit
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
     * * 25 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 26 = Compressive stress, Fa
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 27 = Tensile stress, Ft
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 28 = Major bending stress, Fb3
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 29 = Minor bending stress, Fb2
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 30 = Major shear stress, Fv2
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 31 = Minor shear stress, Fv3
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 32 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY, progDet: ABooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 12, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic zone
     * * 3 = Lateral factor
     * * 4 = Consider deflection
     * * 10 = Pattern live load factor
     * * 11 = Demand/capacity ratio limit
     * * 12 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Seismic zone
     * * 1 = Zone 0
     * * 2 = Zone 1
     * * 3 = Zone 2
     * * 4 = Zone 3
     * * 5 = Zone 4
     * * 3 = Lateral factor
     * * Value > 0
     * * 4 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 9 = Total camber limit, L/Value
     * * Value > 0
     * * 10 = Pattern live load factor
     * * Value >= 0
     * * 11 = Demand/capacity ratio limit
     * * Value > 0
     * * 12 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemTypeitem.
     * @param item This is an integer between 1 and 32, inclusive, indicating the overwrite item considered.
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
     * * 25 = Yield stress, Fy
     * * 26 = Compressive stress, Fa
     * * 27 = Tensile stress, Ft
     * * 28 = Major bending stress, Fb3
     * * 29 = Minor bending stress, Fb2
     * * 30 = Major shear stress, Fv2
     * * 31 = Minor shear stress, Fv3
     * * 32 = Demand/capacity ratio limit
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
     * * 25 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 26 = Compressive stress, Fa
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 27 = Tensile stress, Ft
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 28 = Major bending stress, Fb3
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 29 = Minor bending stress, Fb2
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 30 = Major shear stress, Fv2
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 31 = Minor shear stress, Fv3
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 32 = Demand/capacity ratio limit
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
     * @param item This is an integer between 1 and 12, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic zone
     * * 3 = Lateral factor
     * * 4 = Consider deflection
     * * 10 = Pattern live load factor
     * * 11 = Demand/capacity ratio limit
     * * 12 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Ordinary MRF
     * * 2 = Special MRF
     * * 3 = Braced Frame
     * * 4 = Special CBF
     * * 5 = EBF
     * * 2 = Seismic zone
     * * 1 = Zone 0
     * * 2 = Zone 1
     * * 3 = Zone 2
     * * 4 = Zone 3
     * * 5 = Zone 4
     * * 3 = Lateral factor
     * * Value > 0
     * * 4 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 5 = DL limit, L/Value
     * * Value > 0
     * * 6 = Super DL + LL limit, L/Value
     * * Value > 0
     * * 7 = Live load limit, L/Value
     * * Value > 0
     * * 8 = Total limit, L/Value
     * * Value > 0
     * * 9 = Total camber limit, L/Value
     * * Value > 0
     * * 10 = Pattern live load factor
     * * Value >= 0
     * * 11 = Demand/capacity ratio limit
     * * Value > 0
     * * 12 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}