package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface Chinese_2002V14 : SapComponent {
    /**
     * This function retrieves the value of a steel design overwrite item.
     * @param name The name of a frame object with a steel frame design procedure.
     * @param item This is an integer between 1 and 51, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Element type
     * * 3 = Is transfer column
     * * 4 = Seismic magnification factor
     * * 5 = Is rolled section
     * * 6 = Is flange edge cut by gas
     * * 7 = Is both end pinned
     * * 8 = Ignore b/t check
     * * 9 = Classify beam as flexo-compression member
     * * 10 = Is beam top loaded
     * * 11 = Consider deflection
     * * 12 = Deflection check type
     * * 13 = DL deflection limit, L/Value
     * * 14 = SDL + LL deflection limit, L/Value
     * * 15 = LL deflection limit, L/Value
     * * 16 = Total load deflection limit, L/Value
     * * 17 = Total camber limit, L/Value
     * * 18 = DL deflection limit, absolute
     * * 19 = SDL + LL deflection limit, absolute
     * * 20 = LL deflection limit, absolute
     * * 21 = Total load deflection limit, absolute
     * * 22 = Total camber limit, absolute
     * * 23 = Specified camber
     * * 24 = Net area to total area ratio
     * * 25 = Live load reduction factor
     * * 26 = Unbraced length ratio, Major
     * * 27 = Unbraced length ratio, Minor Lateral Torsional Buckling
     * * 28 = Effective length factor, Mue Major
     * * 29 = Effective length factor, Mue Minor
     * * 30 = Moment coefficient, Beta_m Major
     * * 31 = Moment coefficient, Beta_m Minor
     * * 32 = Moment coefficient, Beta_t Major
     * * 33 = Moment coefficient, Beta_t Minor
     * * 34 = Axial stability coefficient, Phi Major
     * * 35 = Axial stability coefficient, Phi Minor
     * * 36 = Flexural stability coeff, Phi_bMajor
     * * 37 = Flexural stability coeff, Phi_bMinor
     * * 38 = Plasticity factor, Gamma Major
     * * 39 = Plasticity factor, Gamma Minor
     * * 40 = Section influence coefficient, Eta
     * * 41 = B/C capacity factor, Eta
     * * 42 = Euler moment factor, Delta Major
     * * 43 = Euler moment factor, Delta Minor
     * * 44 = Yield stress, Fy
     * * 45 = Allowable normal stress, f
     * * 46 = Allowable shear stress, fv
     * * 47 = Consider fictitious shear
     * * 48 = Demand/capacity ratio limit
     * * 49 = Dual system magnification factor
     * * 50 = Lo/r limit in compression
     * * 51 = L/r limit in tension
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = As specified in preferences
     * * 1 = Moment Frame
     * * 2 = Braced Frame, CBF
     * * 3 = Braced Frame, EBF
     * * 2 = Element type
     * * 0 = Program Determined
     * * 1 = Column
     * * 2 = Beam
     * * 3 = Brace
     * * 3 = Is transfer column
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 4 = Seismic magnification factor
     * * Value >= 0; 0 means no check for this item.
     * * 5 = Is rolled section
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 6 = Is flange edge cut by gas
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 7 = Is both end pinned
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 8 = Ignore b/t check
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 9 = Classify beam as flexo-compression member
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 10 = Is beam top loaded
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 11 = Consider deflection
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 12 = Deflection check type
     * * 0 = Program default
     * * 1 = Ratio
     * * 2 = Absolute
     * * 3 = Both
     * * 13 = DL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 14 = SDL + LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 15 = LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 16 = Total load deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 17 = Total camber limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 18 = DL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 19 = SDL + LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 20 = LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 21 = Total load deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 22 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 23 = Specified camber
     * * Value >= 0. (L)
     * * 24 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 25 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Unbraced length ratio, Minor Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Effective length factor, Mue Major
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Effective length factor, Mue Minor
     * * Value >= 0; 0 means use program determined value.
     * * 30 = Moment coefficient, Beta_m Major
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Moment coefficient, Beta_m Minor
     * * Value >= 0; 0 means use program determined value.
     * * 32 = Moment coefficient, Beta_t Major
     * * Value >= 0; 0 means use program determined value.
     * * 33 = Moment coefficient, Beta_t Minor
     * * Value >= 0; 0 means use program determined value.
     * * 34 = Axial stability coefficient, Phi Major
     * * Value >= 0; 0 means use program determined value.
     * * 35 = Axial stability coefficient, Phi Minor
     * * Value >= 0; 0 means use program determined value.
     * * 36 = Flexural stability coefficient, Phi_b Major
     * * Value >= 0; 0 means use program determined value.
     * * 37 = Flexural stability coefficient, Phi_b Minor
     * * Value >= 0; 0 means use program determined value.
     * * 38 = Plasticity factor, Gamma Major
     * * Value >= 0; 0 means use program determined value.
     * * 39 = Plasticity factor, Gamma Minor
     * * Value >= 0; 0 means use program determined value.
     * * 40 = Section influence coefficient, Eta
     * * Value >= 0; 0 means use program determined value.
     * * 41 = B/C capacity factor, Eta
     * * Value >= 0; 0 means use program determined value.
     * * 42 = Euler moment factor, Delta Major
     * * Value >= 0; 0 means use program determined value.
     * * 43 = Euler moment factor, Delta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 44 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 45 = Allowable normal stress, f
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 46 = Allowable shear stress, fv
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 47 = Consider fictitious shear
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 48 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 14, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Gamma0
     * * 3 = Ignore b/t check
     * * 4 = Classify beam as flexo compression member
     * * 5 = Consider deflection
     * * 6 = DL deflection limit, L/Value
     * * 7 = SDL + LL deflection limit, L/Value
     * * 8 = LL deflection limit, L/Value
     * * 9 = Total load deflection limit, L/Value
     * * 10 = Total camber limit, L/Value
     * * 11 = Pattern live load factor
     * * 12 = Demand/capacity ratio limit
     * * 13 = Time history design
     * * 14 = Is tall building?
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Moment Frame
     * * 2 = Brace Frame
     * * 2 = Gamma0
     * * Value > 0
     * * 3 = Ignore b/t check
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Classify beam as flexo compression member
     * * 0 = No
     * * Any other value = Yes
     * * 5 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 6 = DL deflection limit, L/Value
     * * Value > 0
     * * 7 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 8 = LL deflection limit, L/Value
     * * Value > 0
     * * 9 = Total load deflection limit, L/Value
     * * Value > 0
     * * 10 = Total camber limit, L/Value
     * * Value > 0
     * * 11 = Pattern live load factor
     * * Value >= 0
     * * 12 = Demand/capacity ratio limit
     * * Value > 0
     * * 13 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a steel design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 51, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Element type
     * * 3 = Is transfer column
     * * 4 = Seismic magnification factor
     * * 5 = Is rolled section
     * * 6 = Is flange edge cut by gas
     * * 7 = Is both end pinned
     * * 8 = Ignore b/t check
     * * 9 = Classify beam as flexo-compression member
     * * 10 = Is beam top loaded
     * * 11 = Consider deflection
     * * 12 = Deflection check type
     * * 13 = DL deflection limit, L/Value
     * * 14 = SDL + LL deflection limit, L/Value
     * * 15 = LL deflection limit, L/Value
     * * 16 = Total load deflection limit, L/Value
     * * 17 = Total camber limit, L/Value
     * * 18 = DL deflection limit, absolute
     * * 19 = SDL + LL deflection limit, absolute
     * * 20 = LL deflection limit, absolute
     * * 21 = Total load deflection limit, absolute
     * * 22 = Total camber limit, absolute
     * * 23 = Specified camber
     * * 24 = Net area to total area ratio
     * * 25 = Live load reduction factor
     * * 26 = Unbraced length ratio, Major
     * * 27 = Unbraced length ratio, Minor Lateral TorsionalBuckling
     * * 28 = Effective length factor, Mue Major
     * * 29 = Effective length factor, Mue Minor
     * * 30 = Moment coefficient, Beta_m Major
     * * 31 = Moment coefficient, Beta_m Minor
     * * 32 = Moment coefficient, Beta_t Major
     * * 33 = Moment coefficient, Beta_t Minor
     * * 34 = Axial stability coefficient, Phi Major
     * * 35 = Axial stability coefficient, Phi Minor
     * * 36 = Flexural stability coeff, Phi_bMajor
     * * 37 = Flexural stability coeff, Phi_bMinor
     * * 38 = Plasticity factor, Gamma Major
     * * 39 = Plasticity factor, Gamma Minor
     * * 40 = Section influence coefficient, Eta
     * * 41 = B/C capacity factor, Eta
     * * 42 = Euler moment factor, Delta Major
     * * 43 = Euler moment factor, Delta Minor
     * * 44 = Yield stress, Fy
     * * 45 = Allowable normal stress, f
     * * 46 = Allowable shear stress, fv
     * * 47 = Consider fictitious shear
     * * 48 = Demand/capacity ratio limit
     * * 49 = Dual system magnification factor
     * * 50 = Lo/r limit in compression
     * * 51 = L/r limit in tension
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = As specified in preferences
     * * 1 = Moment Frame
     * * 2 = Braced Frame, CBF
     * * 3 = Braced Frame, EBF
     * * 2 = Element type
     * * 0 = Program Determined
     * * 1 = Column
     * * 2 = Beam
     * * 3 = Brace
     * * 3 = Is transfer column
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 4 = Seismic magnification factor
     * * Value >= 0; 0 means no check for this item.
     * * 5 = Is rolled section
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 6 = Is flange edge cut by gas
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 7 = Is both end pinned
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 8 = Ignore b/t check
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 9 = Classify beam as flexo-compression member
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 10 = Is beam top loaded
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 11 = Consider deflection
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 12 = Deflection check type
     * * 0 = Program default
     * * 1 = Ratio
     * * 2 = Absolute
     * * 3 = Both
     * * 13 = DL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 14 = SDL + LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 15 = LL deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 16 = Total load deflection limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 17 = Total camber limit, L/Value
     * * Value >= 0; 0 means no check for this item.
     * * 18 = DL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 19 = SDL + LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 20 = LL deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 21 = Total load deflection limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 22 = Total camber limit, absolute
     * * Value >= 0; 0 means no check for this item. (L)
     * * 23 = Specified camber
     * * Value >= 0. (L)
     * * 24 = Net area to total area ratio
     * * Value >= 0; 0 means use program default value.
     * * 25 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 26 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 27 = Unbraced length ratio, Minor Lateral Torsional Buckling
     * * Value >= 0; 0 means use program determined value.
     * * 28 = Effective length factor, Mue Major
     * * Value >= 0; 0 means use program determined value.
     * * 29 = Effective length factor, Mue Minor
     * * Value >= 0; 0 means use program determined value.
     * * 30 = Moment coefficient, Beta_m Major
     * * Value >= 0; 0 means use program determined value.
     * * 31 = Moment coefficient, Beta_m Minor
     * * Value >= 0; 0 means use program determined value.
     * * 32 = Moment coefficient, Beta_t Major
     * * Value >= 0; 0 means use program determined value.
     * * 33 = Moment coefficient, Beta_t Minor
     * * Value >= 0; 0 means use program determined value.
     * * 34 = Axial stability coefficient, Phi Major
     * * Value >= 0; 0 means use program determined value.
     * * 35 = Axial stability coefficient, Phi Minor
     * * Value >= 0; 0 means use program determined value.
     * * 36 = Flexural stability coefficient, Phi_b Major
     * * Value >= 0; 0 means use program determined value.
     * * 37 = Flexural stability coefficient, Phi_b Minor
     * * Value >= 0; 0 means use program determined value.
     * * 38 = Plasticity factor, Gamma Major
     * * Value >= 0; 0 means use program determined value.
     * * 39 = Plasticity factor, Gamma Minor
     * * Value >= 0; 0 means use program determined value.
     * * 40 = Section influence coefficient, Eta
     * * Value >= 0; 0 means use program determined value.
     * * 41 = B/C capacity factor, Eta
     * * Value >= 0; 0 means use program determined value.
     * * 42 = Euler moment factor, Delta Major
     * * Value >= 0; 0 means use program determined value.
     * * 43 = Euler moment factor, Delta Minor
     * * Value >= 0; 0 means use program determined value.
     * * 44 = Yield stress, Fy
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 45 = Allowable normal stress, f
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 46 = Allowable shear stress, fv
     * * Value >= 0; 0 means use program determined value. (F/L2)
     * * 47 = Consider fictitious shear
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 48 = Demand/capacity ratio limit
     * * Value >= 0; 0 means use program determined value
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects= 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a steel design preference item.
     * @param item This is an integer between 1 and 14, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Gamma0
     * * 3 = Ignore b/t check
     * * 4 = Classify beam as flexo compression member
     * * 5 = Consider deflection
     * * 6 = DL deflection limit, L/Value
     * * 7 = SDL + LL deflection limit, L/Value
     * * 8 = LL deflection limit, L/Value
     * * 9 = Total load deflection limit, L/Value
     * * 10 = Total camber limit, L/Value
     * * 11 = Pattern live load factor
     * * 12 = Demand/capacity ratio limit
     * * 13 = Time history design
     * * 14 = Is tall building?
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 1 = Moment Frame
     * * 2 = Brace Frame
     * * 2 = Gamma0
     * * Value > 0
     * * 3 = Ignore b/t check
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Classify beam as flexo compression member
     * * 0 = No
     * * Any other value = Yes
     * * 5 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 6 = DL deflection limit, L/Value
     * * Value > 0
     * * 7 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 8 = LL deflection limit, L/Value
     * * Value > 0
     * * 9 = Total load deflection limit, L/Value
     * * Value > 0
     * * 10 = Total camber limit, L/Value
     * * Value > 0
     * * 11 = Pattern live load factor
     * * Value >= 0
     * * 12 = Demand/capacity ratio limit
     * * Value > 0
     * * 13 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}