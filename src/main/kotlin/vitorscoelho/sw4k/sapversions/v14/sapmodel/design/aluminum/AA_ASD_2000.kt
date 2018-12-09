package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.aluminum

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.ItemType

interface AA_ASD_2000V14 : SapComponent {
/**
* This function retrieves the value of an aluminum design overwrite item.
* @param name The name of a frame object with a aluminum frame design procedure.
* @param item This is an integer between 1 and 23, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Live load reduction factor
* * 3 = Unbraced length ratio, Major
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * 5 = Effective length factor, K Major
* * 6 = Effective length factor, K Minor
* * 7 = Moment coefficient, Cm Major
* * 8 = Moment coefficient, Cm Minor
* * 9 = Bending coefficient, Cb
* * 10 = Buckling constant for compression, k1
* * 11 = Buckling constant for compression, k2
* * 12 = Buckling constant for bending, k1
* * 13 = Buckling constant for bending, k2
* * 14 = Safety coefficient, kt
* * 15 = Bending coefficient, C1
* * 16 = Bending coefficient, C2
* * 17 = Yield stress, Fy
* * 18 = Compressive stress, Fa
* * 19 = Tensile stress, Ft
* * 20 = Major bending stress, Fb3
* * 21 = Minor bending stress, Fb2
* * 22 = Major shear stress, Fs2
* * 23 = Minor shear stress, Fs3
* @param value The value of the considered overwrite item.
* * 1 = Framing type
* * 0 = Program Default
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Live load reduction factor
* * Value >= 0; 0 means use a program determined value.
* * 3 = Unbraced length ratio, Major
* * Value >= 0; 0 means use program determined value.
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 5 = Effective length factor, K Major
* * Value >= 0; 0 means use program determined value.
* * 6 = Effective length factor, K Minor
* * Value >= 0; 0 means use program determined value.
* * 7 = Moment coefficient, Cm Major
* * Value >= 0; 0 means use program determined value.
* * 8 = Moment coefficient, Cm Minor
* * Value >= 0; 0 means use program determined value.
* * 9 = Bending coefficient, Cb
* * Value >= 0; 0 means use program determined value.
* * 10 = Buckling constant for compression, k1
* * Value >= 0; 0 means use program determined value.
* * 11 = Buckling constant for compression, k2
* * Value >= 0; 0 means use program determined value.
* * 12 = Buckling constant for bending, k1
* * Value >= 0; 0 means use program determined value.
* * 13 = Buckling constant for bending, k2
* * Value >= 0; 0 means use program determined value.
* * 14 = Safety coefficient, kt
* * Value >= 0; 0 means use program determined value.
* * 15 = Bending coefficient, C1
* * Value >= 0; 0 means use program determined value.
* * 16 = Bending coefficient, C2
* * Value >= 0; 0 means use program determined value.
* * 17 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 18 = Compressive stress, Fa
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 19 = Tensile stress, Ft
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 20 = Major bending stress, Fb3
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 21 = Minor bending stress, Fb2
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 22 = Major shear stress, Fs2
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 23 = Minor shear stress, Fs3
* * Value >= 0; 0 means use program determined value. (F/L2)
* @param progDet If this item is True, the specified value is program determined.
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getOverwrite (name:String,item:Int,value:DoubleByRef,progDet:BooleanByRef):Int=
callFunctionInt("GetOverwrite",name,item,value,progDet)
/**
* This function retrieves the value of an aluminum design preference item.
* @param item This is an integer between 1 and 6, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = Demand/capacity ratio limit
* * 3 = Lateral factor
* * 4 = Use lateral factor
* * 5 = Bridge type structure
* * 6 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Demand/capacity ratio limit
* * Value > 0
* * 3 = Lateral factor
* * Value > 0
* * 4 = Use lateral factor
* * 0 = No
* * Any other value = Yes
* * 5 = Bridge type structure
* * 0 = No
* * Any other value = Yes
* * 6 = Time history design
* * 1 = Envelopes
* * 2 = Step-by step
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getPreference (item:Int,value:DoubleByRef):Int=
callFunctionInt("GetPreference",item,value)
/**
* This function sets the value of an aluminum design overwrite item.
* @param name The name of an existing frame object or group, depending on the value of the ItemType item.
* @param item This is an integer between 1 and 23, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Live load reduction factor
* * 3 = Unbraced length ratio, Major
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * 5 = Effective length factor, K Major
* * 6 = Effective length factor, K Minor
* * 7 = Moment coefficient, Cm Major
* * 8 = Moment coefficient, Cm Minor
* * 9 = Bending coefficient, Cb
* * 10 = Buckling constant for compression, k1
* * 11 = Buckling constant for compression, k2
* * 12 = Buckling constant for bending, k1
* * 13 = Buckling constant for bending, k2
* * 14 = Safety coefficient, kt
* * 15 = Bending coefficient, C1
* * 16 = Bending coefficient, C2
* * 17 = Yield stress, Fy
* * 18 = Compressive stress, Fa
* * 19 = Tensile stress, Ft
* * 20 = Major bending stress, Fb3
* * 21 = Minor bending stress, Fb2
* * 22 = Major shear stress, Fs2
* * 23 = Minor shear stress, Fs3
* @param value The value of the considered overwrite item.
* * 1 = Framing type
* * 0 = Program Default
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Live load reduction factor
* * Value >= 0; 0 means use a program determined value.
* * 3 = Unbraced length ratio, Major
* * Value >= 0; 0 means use program determined value.
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * Value >= 0; 0 means use program determined value.
* * 5 = Effective length factor, K Major
* * Value >= 0; 0 means use program determined value.
* * 6 = Effective length factor, K Minor
* * Value >= 0; 0 means use program determined value.
* * 7 = Moment coefficient, Cm Major
* * Value >= 0; 0 means use program determined value.
* * 8 = Moment coefficient, Cm Minor
* * Value >= 0; 0 means use program determined value.
* * 9 = Bending coefficient, Cb
* * Value >= 0; 0 means use program determined value.
* * 10 = Buckling constant for compression, k1
* * Value >= 0; 0 means use program determined value.
* * 11 = Buckling constant for compression, k2
* * Value >= 0; 0 means use program determined value.
* * 12 = Buckling constant for bending, k1
* * Value >= 0; 0 means use program determined value.
* * 13 = Buckling constant for bending, k2
* * Value >= 0; 0 means use program determined value.
* * 14 = Safety coefficient, kt
* * Value >= 0; 0 means use program determined value.
* * 15 = Bending coefficient, C1
* * Value >= 0; 0 means use program determined value.
* * 16 = Bending coefficient, C2
* * Value >= 0; 0 means use program determined value.
* * 17 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 18 = Compressive stress, Fa
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 19 = Tensile stress, Ft
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 20 = Major bending stress, Fb3
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 21 = Minor bending stress, Fb2
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 22 = Major shear stress, Fs2
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 23 = Minor shear stress, Fs3
* * Value >= 0; 0 means use program determined value. (F/L2)
* @param itemType This is one of the following items in the eItemType enumeration:
* * Object = 0
* * Group = 1
* * SelectedObjects = 2
* If this item is Object, the assignment is made to the frame object specified by the Name item.
* If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
* If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
* @return zero if the item is successfully set; otherwise it returns a nonzero value.
*/
fun setOverwrite (name:String,item:Int,value:Double,itemType:Int=ItemType.OBJECT.sapId):Int=
callFunctionInt("SetOverwrite",name,item,value,itemType)
/**
* This function sets the value of an aluminum design preference item.
* @param item This is an integer between 1 and 6, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = Demand/capacity ratio limit
* * 3 = Lateral factor
* * 4 = Use lateral factor
* * 5 = Bridge type structure
* * 6 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Demand/capacity ratio limit
* * Value > 0
* * 3 = Lateral factor
* * Value > 0
* * 4 = Use lateral factor
* * 0 = No
* * Any other value = Yes
* * 5 = Bridge type structure
* * 0 = No
* * Any other value = Yes
* * 6 = Time history design
* * 1 = Envelopes
* * 2 = Step-by step
* @return zero if the item is successfully set; otherwise it returns a nonzero value.
*/
fun setPreference (item:Int,value:Double):Int=
callFunctionInt("SetPreference",item,value)

}