package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface AISC_360_05_IBC_2006V14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 43, inclusive, indicating the overwrite item considered.
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
     * * 19 = Unbraced length ratio, Minor
     * * 20 = Unbraced length ratio, Lateral Torsional Buckling
     * * 21 = Effective length factor, K1 Major
     * * 22 = Effective length factor, K1 Minor
     * * 23 = Effective length factor, K2 Major
     * * 24 = Effective length factor, K2 Minor
     * * 25 = Effective length factor, K Lateral Torsional Buckling
     * * 26 = Moment coefficient, Cm Major
     * * 27 = Moment coefficient, Cm Minor
     * * 28 = Bending coefficient, Cb
     * * 29 = Nonsway moment factor, B1 Major
     * * 30 = Nonsway moment factor, B1 Minor
     * * 31 = Sway moment factor, B2 Major
     * * 32 = Sway moment factor, B2 Minor
     * * 33 = Reduce HSS thickness
     * * 34 = HSS welding type
     * * 35 = Yield stress, Fy
     * * 36 = Expected to specified Fy ratio, Ry
     * * 37 = Compressive capacity, Pnc
     * * 38 = Tensile capacity, Pnt
     * * 39 = Major bending capacity, Mn3
     * * 40 = Minor bending capacity, Mn2
     * * 41 = Major shear capacity, Vn2
     * * 42 = Minor shear capacity, Vn3
     * * 43 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = SMF
     * * 2 = IMF
     * * 3 = OMF
     * * 4 = SCBF
     * * 5 = OCBF
     * * 6 = OCBFI
     * * 7 = EBF
     * * 2 = Omega0
     * * Value >= 0; 0 means use a program determined value.
     * * 3 = Consider deflection
     * * 0 = Program default
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
     * * Value >= 0; 0 means no check for this item. (L)}
     * * 14 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 15 = Specified camber
     * * Value >= 0. [L}
     * * 16 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 17 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 18 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 19 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 20 = Unbraced length ratio, Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, K1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Effective length factor, K1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Effective length factor, K2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 24 = Effective length factor, K2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Effective length factor, K Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Bending coefficient, Cb
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Nonsway moment factor, B1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 30 = Nonsway moment factor, B1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Sway moment factor, B2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 32 = Sway moment factor, B2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 33 = Reduce HSS thickness
     * * 0 = Program default
     * * 1 = No
     * * 2 = Yes
     * * 34 = HSS welding type
     * * 0 = Program default
     * * 1 = ERW
     * * 2 = SAW
     * * 35 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 36 = Expected to specified Fy ratio, Ry
     * * Value >= 0; 0 means use program determined value.
     * * 37 = Compressive capacity, Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 38 = Tensile capacity, Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 39 = Major bending capacity, Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 40 = Minor bending capacity, Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 41 = Major shear capacity, Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 42 = Minor shear capacity, Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 43 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY, progDet: ABooleanByRef = BooleanByRef.UNNECESSARY): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 26, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic design category
     * * 3 = Design provision
     * * 4 = Analysis method (Obsolete, replaced by 27, 28, and 29)
     * * 5 = Notional load coefficient
     * * 6 = Phi bending
     * * 7 = Phi compression
     * * 8 = Phi tension yielding
     * * 9 = Phi tension fracture
     * * 10 = Phi shear
     * * 11 = Phi shear sort webbed rolled I
     * * 12 = Phi torsion
     * * 13 = Ignore seismic code
     * * 14 = Ignore special seismic load
     * * 15 = Doubler plate is plug welded
     * * 16 = HSS welding type
     * * 17 = Reduce HSS thickness
     * * 18 = Consider deflection
     * * 19 = DL deflection limit, L/Value
     * * 20 = SDL + LL deflection limit, L/Value
     * * 21 = LL deflection limit, L/Value
     * * 22 = Total load deflection limit, L/Value
     * * 23 = Total camber limit, L/Value
     * * 24 = Pattern live load factor
     * * 25 = Demand/capacity ratio limit
     * * 26 = Time history design
     * * 27 = Analysis Method
     * * 28 = Second Order Method
     * * 29 = Stiffness Reduction Method
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = SMF
     * * 2 = IMF
     * * 3 = OMF
     * * 4 = SCBF
     * * 5 = OCBF
     * * 6 = OCBFI
     * * 7 = EBF
     * * 2 = Seismic design category
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * * 3 = Design provision
     * * 1 = LRFD
     * * 2 = ASD
     * * 4 = Analysis method (Obsolete, replaced by 27, 28, and 29)
     * * 1 = Gen 2nd Order Elastic
     * * 2 = 2nd Order By Amp 1st Order
     * * 3 = Limited 1st Order Elastic
     * * 4 = DAM Gen 2nd Order Taub Variable
     * * 5 = DAM Gen 2nd Order Taub Fixed
     * * 6 = DAM Amp 1st Order Taub Variable
     * * 7 = DAM Amp 1st Order Taub Fixed
     * * 5 = Notional load coefficient
     * * Value > 0
     * * 6 = Phi bending
     * * Value > 0
     * * 7 = Phi compression
     * * Value > 0
     * * 8 = Phi tension yielding
     * * Value > 0
     * * 9 = Phi tension fracture
     * * Value > 0
     * * 10 = Phi shear
     * * Value > 0
     * * 11 = Phi shear sort webbed rolled I
     * * Value > 0
     * * 12 = Phi torsion
     * * Value > 0
     * * 13 = Ignore seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 14 = Ignore special seismic load
     * * 0 = No
     * * Any other value = Yes
     * * 15 = Doubler plate is plug welded
     * * 0 = No
     * * Any other value = Yes
     * * 16 = HSS welding type
     * * 1 = ERW
     * * 2 = SAW
     * * 17 = Reduce HSS thickness
     * * 0 = No
     * * Any other value = Yes
     * * 18 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 19 = DL deflection limit, L/Value
     * * Value > 0
     * * 20 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 21 = LL deflection limit, L/Value
     * * Value > 0
     * * 22 = Total load deflection limit, L/Value
     * * Value > 0
     * * 23 = Total camber limit, L/Value
     * * Value > 0
     * * 24 = Pattern live load factor
     * * Value >= 0
     * * 25 = Demand/capacity ratio limit
     * * Value > 0
     * * 26 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * * 27 = Analysis Method
     * * 1 = Direct Analysis
     * * 2 = Effective Length
     * * 3 = Limited 1st Order
     * * 28 = Second Order Method
     * * 1 = General 2nd Order
     * * 2 = Amplified 1st Order
     * * 29 = Stiffness Reduction Method
     * * 1 = Tau-b variable
     * * 2 = Tau-b Fixed
     * * 3 = No Modification
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 43, inclusive, indicating the overwrite item considered.
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
     * * 19 = Unbraced length ratio, Minor
     * * 20 = Unbraced length ratio, Lateral Torsional Buckling
     * * 21 = Effective length factor, K1 Major
     * * 22 = Effective length factor, K1 Minor
     * * 23 = Effective length factor, K2 Major
     * * 24 = Effective length factor, K2 Minor
     * * 25 = Effective length factor, K Lateral Torsional Buckling
     * * 26 = Moment coefficient, Cm Major
     * * 27 = Moment coefficient, Cm Minor
     * * 28 = Bending coefficient, Cb
     * * 29 = Nonsway moment factor, B1 Major
     * * 30 = Nonsway moment factor, B1 Minor
     * * 31 = Sway moment factor, B2 Major
     * * 32 = Sway moment factor, B2 Minor
     * * 33 = Reduce HSS thickness
     * * 34 = HSS welding type
     * * 35 = Yield stress, Fy
     * * 36 = Expected to specified Fy ratio, Ry
     * * 37 = Compressive capacity, Pnc
     * * 38 = Tensile capacity, Pnt
     * * 39 = Major bending capacity, Mn3
     * * 40 = Minor bending capacity, Mn2
     * * 41 = Major shear capacity, Vn2
     * * 42 = Minor shear capacity, Vn3
     * * 43 = Demand/capacity ratio limit
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = SMF
     * * 2 = IMF
     * * 3 = OMF
     * * 4 = SCBF
     * * 5 = OCBF
     * * 6 = OCBFI
     * * 7 = EBF
     * * 2 = Omega0
     * * Value >= 0; 0 means use a program determined value.
     * * 3 = Consider deflection
     * * 0 = Program default
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
     * * Value >= 0; 0 means no check for this item. (L)}
     * * 14 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 15 = Specified camber
     * * Value >= 0. [L}
     * * 16 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 17 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 18 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 19 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 20 = Unbraced length ratio, Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 21 = Effective length factor, K1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 22 = Effective length factor, K1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 23 = Effective length factor, K2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 24 = Effective length factor, K2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 25 = Effective length factor, K Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Moment coefficient, Cm Major
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Moment coefficient, Cm Minor
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Bending coefficient, Cb
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Nonsway moment factor, B1 Major
     * * Value >= 0; 0 means use program determined value.
     * * 30 = Nonsway moment factor, B1 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Sway moment factor, B2 Major
     * * Value >= 0; 0 means use program determined value.
     * * 32 = Sway moment factor, B2 Minor
     * * Value >= 0; 0 means use program determined value.
     * * 33 = Reduce HSS thickness
     * * 0 = Program default
     * * 1 = No
     * * 2 = Yes
     * * 34 = HSS welding type
     * * 0 = Program default
     * * 1 = ERW
     * * 2 = SAW
     * * 35 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 36 = Expected to specified Fy ratio, Ry
     * * Value >= 0; 0 means use program determined value.
     * * 37 = Compressive capacity, Pnc
     * * Value >= 0; 0 means use program determined value. (F)
     * * 38 = Tensile capacity, Pnt
     * * Value >= 0; 0 means use program determined value. (F)
     * * 39 = Major bending capacity, Mn3
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 40 = Minor bending capacity, Mn2
     * * Value >= 0; 0 means use program determined value. (FL)
     * * 41 = Major shear capacity, Vn2
     * * Value >= 0; 0 means use program determined value. (F)
     * * 42 = Minor shear capacity, Vn3
     * * Value >= 0; 0 means use program determined value. (F)
     * * 43 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a steel design preference item.
     * @param item This is an integer between 1 and 26, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Seismic design category
     * * 3 = Design provision
     * * 4 = Analysis method (Obsolete, replaced by 27, 28, and 29)
     * * 5 = Notional load coefficient
     * * 6 = Phi bending
     * * 7 = Phi compression
     * * 8 = Phi tension yielding
     * * 9 = Phi tension fracture
     * * 10 = Phi shear
     * * 11 = Phi shear sort webbed rolled I
     * * 12 = Phi torsion
     * * 13 = Ignore seismic code
     * * 14 = Ignore special seismic load
     * * 15 = Doubler plate is plug welded
     * * 16 = HSS welding type
     * * 17 = Reduce HSS thickness
     * * 18 = Consider deflection
     * * 19 = DL deflection limit, L/Value
     * * 20 = SDL + LL deflection limit, L/Value
     * * 21 = LL deflection limit, L/Value
     * * 22 = Total load deflection limit, L/Value
     * * 23 = Total camber limit, L/Value
     * * 24 = Pattern live load factor
     * * 25 = Demand/capacity ratio limit
     * * 26 = Time history design 27 = Analysis Method 28 = Second Order Method 29 = Stiffness Reduction Method
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = SMF
     * * 2 = IMF
     * * 3 = OMF
     * * 4 = SCBF
     * * 5 = OCBF
     * * 6 = OCBFI
     * * 7 = EBF
     * * 2 = Seismic design category
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * * 3 = Design provision
     * * 1 = LRFD
     * * 2 = ASD
     * * 4 = Analysis method (Obsolete, replaced by 27, 28, and 29)
     * * 1 = Gen 2nd Order Elastic
     * * 2 = 2nd Order By Amp 1st Order
     * * 3 = Limited 1st Order Elastic
     * * 4 = DAM Gen 2nd Order Taub Variable
     * * 5 = DAM Gen 2nd Order Taub Fixed
     * * 6 = DAM Amp 1st Order Taub Variable
     * * 7 = DAM Amp 1st Order Taub Fixed
     * * 5 = Notional load coefficient
     * * Value > 0
     * * 6 = Phi bending
     * * Value > 0
     * * 7 = Phi compression
     * * Value > 0
     * * 8 = Phi tension yielding
     * * Value > 0
     * * 9 = Phi tension fracture
     * * Value > 0
     * * 10 = Phi shear
     * * Value > 0
     * * 11 = Phi shear sort webbed rolled I
     * * Value > 0
     * * 12 = Phi torsion
     * * Value > 0
     * * 13 = Ignore seismic code
     * * 0 = No
     * * Any other value = Yes
     * * 14 = Ignore special seismic load
     * * 0 = No
     * * Any other value = Yes
     * * 15 = Doubler plate is plug welded
     * * 0 = No
     * * Any other value = Yes
     * * 16 = HSS welding type
     * * 1 = ERW
     * * 2 = SAW
     * * 17 = Reduce HSS thickness
     * * 0 = No
     * * Any other value = Yes
     * * 18 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 19 = DL deflection limit, L/Value
     * * Value > 0
     * * 20 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 21 = LL deflection limit, L/Value
     * * Value > 0
     * * 22 = Total load deflection limit, L/Value
     * * Value > 0
     * * 23 = Total camber limit, L/Value
     * * Value > 0
     * * 24 = Pattern live load factor
     * * Value >= 0
     * * 25 = Demand/capacity ratio limit
     * * Value > 0
     * * 26 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * * 27 = Analysis Method
     * * 1 = Direct Analysis
     * * 2 = Effective Length
     * * 3 = Limited 1st Order
     * * 28 = Second Order Method
     * * 1 = General 2nd Order
     * * 2 = Amplified 1st Order
     * * 29 = Stiffness Reduction Method
     * * 1 = Tau-b variable
     * * 2 = Tau-b Fixed
     * * 3 = No Modification
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}