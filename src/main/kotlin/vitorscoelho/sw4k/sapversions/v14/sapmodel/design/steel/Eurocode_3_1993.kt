package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface Eurocode_3_1993V14 : SapComponent {
/**
* This function retrieves the value of a steel design overwrite item.
* @param name The name of a frame object with a steel frame design procedure.
* @param item This is an integer between 1 and 36, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Consider deflection
* * 3 = Deflection check type
* * 4 = DL deflection limit, L/Value
* * 5 = SDL + LL deflection limit, L/Value
* * 6 = LL deflection limit, L/Value
* * 7 = Total load deflection limit, L/Value
* * 8 = Total camber limit, L/Value
* * 9 = DL deflection limit, absolute
* * 10 = SDL + LL deflection limit, absolute
* * 11 = LL deflection limit, absolute
* * 12 = Total load deflection limit, absolute
* * 13 = Total camber limit, absolute
* * 14 = Specified camber
* * 15 = Net area to total area ratio
* * 16 = Live load reduction factor
* * 17 = Unbraced length ratio, Major
* * 18 = Unbraced length ratio, Minor Lateral Torsional Buckling
* * 19 = Effective length factor, K Major
* * 20 = Effective length factor, K Minor
* * 21 = Moment coefficient, k Major
* * 22 = Moment coefficient, k Minor
* * 23 = Bending coefficient, C1
* * 24 = Moment coefficient, k Lateral Torsional Buckling
* * 25 = Non-sway moment factor
* * 26 = Sway moment factor, Psi Major
* * 27 = Sway moment factor, Psi Minor
* * 28 = Yield stress, Fy
* * 29 = Compressive capacity, Nc.Rd
* * 30 = Tensile capacity, Nt.Rd
* * 31 = Major bending capacity, Mc3.Rd
* * 32 = Minor bending capacity, Mc2.Rd
* * 33 = Buckling resistance moment, Mb.Rd
* * 34 = Major shear capacity, V2.Rd
* * 35 = Minor shear capacity, V3.RD
* * 36 = Demand/capacity ratio limit
* @param value The value of the considered overwrite item.
* * 1 = Framing type
* * 0 = Program Default
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Consider deflection
* * 0 = Program Determined
* * 1 = No
* * 2 = Yes
* * 3 = Deflection check type
* * 0 = Program default
* * 1 = Ratio
* * 2 = Absolute
* * 3 = Both
* * 4 = DL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 5 = SDL + LL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 6 = LL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 7 = Total load deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 8 = Total camber limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 9 = DL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 10 = SDL + LL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 11 = LL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 12 = Total load deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 13 = Total camber limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 14 = Specified camber
* * Value >= 0. (L)
* * 15 = Net area to total area ratio
* * Value >= 0; 0 means use program default value.
* * 16 = Live load reduction factor
* * Value >= 0; 0 means use program determined value.
* * 17 = Unbraced length ratio, Major
* * Value >= 0; 0 means use program determined value.
* * 18 = Unbraced length ratio, Minor Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 19 = Effective length factor, K Major
* * Value >= 0; 0 means use program determined value.
* * 20 = Effective length factor, K Minor
* * Value >= 0; 0 means use program determined value.
* * 21 = Moment coefficient, k Major
* * Value >= 0; 0 means use program determined value.
* * 22 = Moment coefficient, k Minor
* * Value >= 0; 0 means use program determined value.
* * 23 = Bending coefficient, C1
* * Value >= 0; 0 means use program determined value.
* * 24 = Moment coefficient, k Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 25 = Non-sway moment factor
* * Value >= 0; 0 means use program determined value.
* * 26 = Sway moment factor, Psi Major
* * Value >= 0; 0 means use program determined value.
* * 27 = Sway moment factor, Psi Minor
* * Value >= 0; 0 means use program determined value.
* * 28 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 29 = Compressive capacity, Nc.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 30 = Tensile capacity, Nt.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 31 = Major bending capacity, Mc3.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 32 = Minor bending capacity, Mc2.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 33 = Buckling resistance moment, Mb.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 34 = Major shear capacity, Vn2.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 35 = Minor shear capacity, Vn3.RD
* * Value >= 0; 0 means use program determined value. (F)
* * 36 = Demand/capacity ratio limit
* * Value >= 0; 0 means use program determined value.
* @param progDet If this item is True, the specified value is program determined.
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getOverwrite (name:String,item:Int,value:DoubleByRef,progDet:BooleanByRef):Int=
callFunctionInt("GetOverwrite",name,item,value,progDet)
/**
* This function retrieves the value of a steel design preference item.
* @param item This is an integer between 1 and 12, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = GammaM0
* * 3 = GammeM1
* * 4 = Consider deflection
* * 5 = DL deflection limit, L/Value
* * 6 = SDL + LL deflection limit, L/Value
* * 7 = LL deflection limit, L/Value
* * 8 = Total deflection limit, L/Value
* * 9 = Total camber limit, L/Value
* * 10 = Pattern live load factor
* * 11 = Demand/capacity ratio limit
* * 12 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = GammaM0
* * Value > 0
* * 3 = GammeM1
* * Value > 0
* * 4 = Consider deflection
* * 0 = No
* * Any other value = Yes
* * 5 = DL deflection limit, L/Value
* * Value > 0
* * 6 = SDL + LL deflection limit, L/Value
* * Value > 0
* * 7 = LL deflection limit, L/Value
* * Value > 0
* * 8 = Total deflection limit, L/Value
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
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getPreference (item:Int,value:DoubleByRef):Int=
callFunctionInt("GetPreference",item,value)
/**
* This function sets the value of a steel design overwrite item.
* @param name The name of an existing frame object or group depending on the value of the ItemType item.
* @param item This is an integer between 1 and 36, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Consider deflection
* * 3 = Deflection check type
* * 4 = DL deflection limit, L/Value
* * 5 = SDL + LL deflection limit, L/Value
* * 6 = LL deflection limit, L/Value
* * 7 = Total load deflection limit, L/Value
* * 8 = Total camber limit, L/Value
* * 9 = DL deflection limit, absolute
* * 10 = SDL + LL deflection limit, absolute
* * 11 = LL deflection limit, absolute
* * 12 = Total load deflection limit, absolute
* * 13 = Total camber limit, absolute
* * 14 = Specified camber
* * 15 = Net area to total area ratio
* * 16 = Live load reduction factor
* * 17 = Unbraced length ratio, Major
* * 18 = Unbraced length ratio, Minor Lateral Torsional Buckling
* * 19 = Effective length factor, K Major
* * 20 = Effective length factor, K Minor
* * 21 = Moment coefficient, k Major
* * 22 = Moment coefficient, k Minor
* * 23 = Bending coefficient, C1
* * 24 = Moment coefficient, k Lateral Torsional Buckling
* * 25 = Non-sway moment factor
* * 26 = Sway moment factor, Psi Major
* * 27 = Sway moment factor, Psi Minor
* * 28 = Yield stress, Fy
* * 29 = Compressive capacity, Nc.Rd
* * 30 = Tensile capacity, Nt.Rd
* * 31 = Major bending capacity, Mc3.Rd
* * 32 = Minor bending capacity, Mc2.Rd
* * 33 = Buckling resistance moment, Mb.Rd
* * 34 = Major shear capacity, V2.Rd
* * 35 = Minor shear capacity, V3.RD
* * 36 = Demand/capacity ratio limit
* @param value The value of the considered overwrite item.
* * 1 = Framing type
* * 0 = Program Default
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Consider deflection
* * 0 = Program Determined
* * 1 = No
* * 2 = Yes
* * 3 = Deflection check type
* * 0 = Program default
* * 1 = Ratio
* * 2 = Absolute
* * 3 = Both
* * 4 = DL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 5 = SDL + LL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 6 = LL deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 7 = Total load deflection limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 8 = Total camber limit, L/Value
* * Value >= 0; 0 means no check for this item.
* * 9 = DL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 10 = SDL + LL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 11 = LL deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 12 = Total load deflection limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 13 = Total camber limit, absolute
* * Value >= 0; 0 means no check for this item. (L)
* * 14 = Specified camber
* * Value >= 0. (L)
* * 15 = Net area to total area ratio
* * Value >= 0; 0 means use program default value.
* * 16 = Live load reduction factor
* * Value >= 0; 0 means use program determined value.
* * 17 = Unbraced length ratio, Major
* * Value >= 0; 0 means use program determined value.
* * 18 = Unbraced length ratio, Minor Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 19 = Effective length factor, K Major
* * Value >= 0; 0 means use program determined value.
* * 20 = Effective length factor, K Minor
* * Value >= 0; 0 means use program determined value.
* * 21 = Moment coefficient, k Major
* * Value >= 0; 0 means use program determined value.
* * 22 = Moment coefficient, k Minor
* * Value >= 0; 0 means use program determined value.
* * 23 = Bending coefficient, C1
* * Value >= 0; 0 means use program determined value.
* * 24 = Moment coefficient, k Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 25 = Non-sway moment factor
* * Value >= 0; 0 means use program determined value.
* * 26 = Sway moment factor, Psi Major
* * Value >= 0; 0 means use program determined value.
* * 27 = Sway moment factor, Psi Minor
* * Value >= 0; 0 means use program determined value.
* * 28 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 29 = Compressive capacity, Nc.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 30 = Tensile capacity, Nt.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 31 = Major bending capacity, Mc3.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 32 = Minor bending capacity, Mc2.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 33 = Buckling resistance moment, Mb.Rd
* * Value >= 0; 0 means use program determined value. (FL)
* * 34 = Major shear capacity, Vn2.Rd
* * Value >= 0; 0 means use program determined value. (F)
* * 35 = Minor shear capacity, Vn3.RD
* * Value >= 0; 0 means use program determined value. (F)
* * 36 = Demand/capacity ratio limit
* * Value >= 0; 0 means use program determined value.
* @param itemType This is one of the following items in the eItemType enumeration:
* * Object = 0
* * Group = 1
* * SelectedObjects= 2
* If this item is Object, the assignment is made to the frame object specified by the Name item.
* If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
* If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
* @return zero if the item is successfully set; otherwise it returns a nonzero value.
*/
fun setOverwrite (name:String,item:Int,value:Double,itemType:Int=ItemType.OBJECT.sapId):Int=
callFunctionInt("SetOverwrite",name,item,value,itemType)
/**
* This function sets the value of a steel design preference item.
* @param item This is an integer between 1 and 12, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = GammaM0
* * 3 = GammeM1
* * 4 = Consider deflection
* * 5 = DL deflection limit, L/Value
* * 6 = SDL + LL deflection limit, L/Value
* * 7 = LL deflection limit, L/Value
* * 8 = Total deflection limit, L/Value
* * 9 = Total camber limit, L/Value
* * 10 = Pattern live load factor
* * 11 = Demand/capacity ratio limit
* * 12 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = GammaM0
* * Value > 0
* * 3 = GammeM1
* * Value > 0
* * 4 = Consider deflection
* * 0 = No
* * Any other value = Yes
* * 5 = DL deflection limit, L/Value
* * Value > 0
* * 6 = SDL + LL deflection limit, L/Value
* * Value > 0
* * 7 = LL deflection limit, L/Value
* * Value > 0
* * 8 = Total deflection limit, L/Value
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
fun setPreference (item:Int,value:Double):Int=
callFunctionInt("SetPreference",item,value)

}