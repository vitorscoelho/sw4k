package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.coldformed

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface AISI_LRFD96V14 : SapComponent {
/**
* This function retrieves the value of a cold formed design overwrite item.
* @param name The name of a frame object with a cold formed frame design procedure.
* @param item This is an integer between 1 and 27, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Live load reduction factor
* * 3 = Unbraced length ratio, Major
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * 5 = Effective length factor, K Major
* * 6 = Effective length factor, K Minor
* * 7 = Moment coefficient, Cm Major
* * 8 = Moment coefficient, Cm Minor
* * 9 = Moment coefficient, Ctf Major
* * 10 = Moment coefficient, Ctf Minor
* * 11 = Bending coefficient, Cb
* * 12 = Moment factor, Alpha Major
* * 13 = Moment factor, Alpha Minor
* * 14 = Through fastened to deck
* * 15 = Fastener eccentricity, a/b
* * 16 = Hole diameter at top flange
* * 17 = Hole diameter at bottom flange
* * 18 = Hole diameter on web
* * 19 = Yield stress, Fy
* * 20 = Nominal compressive capacity, Pnc
* * 21 = Nominal tensile capacity, Pnt
* * 22 = Nominal bending capacity for yielding, Mn33
* * 23 = Nominal bending capacity for yielding, Mn22
* * 24 = Nominal bending capacity for lateral torsional buckling, Mn33
* * 25 = Nominal bending capacity for lateral torsional buckling, Mn22
* * 26 = Nominal shear capacity, Vn2
* * 27 = Nominal shear capacity, Vn3
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
* * 9 = Moment coefficient, Ctf Major
* * Value >= 0; 0 means use program determined value.
* * 10 = Moment coefficient, Ctf Minor
* * Value >= 0; 0 means use program determined value.
* * 11 = Bending coefficient, Cb
* * Value >= 0; 0 means use program determined value.
* * 12 = Moment factor, Alpha Major
* * Value >= 0; 0 means use program determined value.
* * 13 = Moment factor, Alpha Minor
* * Value >= 0; 0 means use program determined value.
* * 14 = Through fastened to deck
* * 0 = No.
* * Any other value = Yes.
* * 15 = Fastener eccentricity, a/b
* * Value >= 0; 0 means use program determined value. (L)
* * 16 = Hole diameter at top flange
* * Value >= 0; 0 means use program determined value. (L)
* * 17 = Hole diameter at bottom flange
* * Value >= 0; 0 means use program determined value. (L)
* * 18 = Hole diameter on web
* * Value >= 0; 0 means use program determined value. (L)
* * 19 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 20 = Nominal compressive capacity, Pnc
* * Value >= 0; 0 means use program determined value. (F)
* * 21 = Nominal tensile capacity, Pnt
* * Value >= 0; 0 means use program determined value. (F)
* * 22 = Nominal bending capacity for yielding, Mn33
* * Value >= 0; 0 means use program determined value. (FL)
* * 23 = Nominal bending capacity for yielding, Mn22
* * Value >= 0; 0 means use program determined value. (FL)
* * 24 = Nominal bending capacity for lateral torsional buckling, Mn33
* * Value >= 0; 0 means use program determined value. (FL)
* * 25 = Nominal bending capacity for lateral torsional buckling, Mn22
* * Value >= 0; 0 means use program determined value. (FL)
* * 26 = Nominal shear capacity, Vn2
* * Value >= 0; 0 means use program determined value. (F)
* * 27 = Nominal shear capacity, Vn3
* * Value >= 0; 0 means use program determined value. (F)
* @param progDet If this item is True, the specified value is program determined.
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getOverwrite (name:String,item:Int,value:ADoubleByRef,progDet:ABooleanByRef):Int=
callFunctionInt("GetOverwrite",name,item,value,progDet)
/**
* This function retrieves the value of a cold formed design preference item.
* @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = Demand/capacity ratio limit
* * 3 = Phi bending stiffened
* * 4 = Phi bending unstiffened
* * 5 = Phi bending lateral torsional buckling
* * 6 = Phi shear slender
* * 7 = Phi shear nonslender
* * 8 = Phi axial tension
* * 9 = Phi axial compression
* * 10 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Demand/capacity ratio limit
* * Value > 0
* * 3 = Phi bending stiffened
* * Value > 0
* * 4 = Phi bending unstiffened
* * Value > 0
* * 5 = Phi bending lateral torsional buckling
* * Value > 0
* * 6 = Phi shear slender
* * Value > 0
* * 7 = Phi shear nonslender
* * Value > 0
* * 8 = Phi axial tension
* * Value > 0
* * 9 = Phi axial compression
* * Value > 0
* * 10 = Time history design
* * 1 = Envelopes
* * 2 = Step-by step
* @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
*/
fun getPreference (item:Int,value:ADoubleByRef):Int=
callFunctionInt("GetPreference",item,value)
/**
* This function sets the value of a cold formed design overwrite item.
* @param name The name of an existing frame object or group depending on the value of the ItemType item.
* @param item This is an integer between 1 and 27, inclusive, indicating the overwrite item considered.
* * 1 = Framing type
* * 2 = Live load reduction factor
* * 3 = Unbraced length ratio, Major
* * 4 = Unbraced length ratio, Minor and Lateral Torsional Buckling
* * 5 = Effective length factor, K Major
* * 6 = Effective length factor, K Minor
* * 7 = Moment coefficient, Cm Major
* * 8 = Moment coefficient, Cm Minor
* * 9 = Moment coefficient, Ctf Major
* * 10 = Moment coefficient, Ctf Minor
* * 11 = Bending coefficient, Cb
* * 12 = Moment factor, Alpha Major
* * 13 = Moment factor, Alpha Minor
* * 14 = Through fastened to deck
* * 15 = Fastener eccentricity, a/b
* * 16 = Hole diameter at top flange
* * 17 = Hole diameter at bottom flange
* * 18 = Hole diameter on web
* * 19 = Yield stress, Fy
* * 20 = Nominal compressive capacity, Pnc
* * 21 = Nominal tensile capacity, Pnt
* * 22 = Nominal bending capacity for yielding, Mn33
* * 23 = Nominal bending capacity for yielding, Mn22
* * 24 = Nominal bending capacity for lateral torsional buckling, Mn33
* * 25 = Nominal bending capacity for lateral torsional buckling, Mn22
* * 26 = Nominal shear capacity, Vn2
* * 27 = Nominal shear capacity, Vn3
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
* * 9 = Moment coefficient, Ctf Major
* * Value >= 0; 0 means use program determined value.
* * 10 = Moment coefficient, Ctf Minor
* * Value >= 0; 0 means use program determined value.
* * 11 = Bending coefficient, Cb
* * Value >= 0; 0 means use program determined value.
* * 12 = Moment factor, Alpha Major
* * Value >= 0; 0 means use program determined value.
* * 13 = Moment factor, Alpha Minor
* * Value >= 0; 0 means use program determined value.
* * 14 = Through fastened to deck
* * 0 = No.
* * Any other value = Yes.
* * 15 = Fastener eccentricity, a/b
* * Value >= 0; 0 means use program determined value. (L)
* * 16 = Hole diameter at top flange
* * Value >= 0; 0 means use program determined value. (L)
* * 17 = Hole diameter at bottom flange
* * Value >= 0; 0 means use program determined value. (L)
* * 18 = Hole diameter on web
* * Value >= 0; 0 means use program determined value. (L)
* * 19 = Yield stress, Fy
* * Value >= 0; 0 means use program determined value. (F/L2)
* * 20 = Nominal compressive capacity, Pnc
* * Value >= 0; 0 means use program determined value. (F)
* * 21 = Nominal tensile capacity, Pnt
* * Value >= 0; 0 means use program determined value. (F)
* * 22 = Nominal bending capacity for yielding, Mn33
* * Value >= 0; 0 means use program determined value. (FL)
* * 23 = Nominal bending capacity for yielding, Mn22
* * Value >= 0; 0 means use program determined value. (FL)
* * 24 = Nominal bending capacity for lateral torsional buckling, Mn33
* * Value >= 0; 0 means use program determined value. (FL)
* * 25 = Nominal bending capacity for lateral torsional buckling, Mn22
* * Value >= 0; 0 means use program determined value. (FL)
* * 26 = Nominal shear capacity, Vn2
* * Value >= 0; 0 means use program determined value. (F)
* * 27 = Nominal shear capacity, Vn3
* * Value >= 0; 0 means use program determined value. (F)
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
* This function sets the value of a cold formed design preference item.
* @param item This is an integer between 1 and 10, inclusive, indicating the preference item considered.
* * 1 = Framing type
* * 2 = Demand/capacity ratio limit
* * 3 = Phi bending stiffened
* * 4 = Phi bending unstiffened
* * 5 = Phi bending lateral torsional buckling
* * 6 = Phi shear slender
* * 7 = Phi shear nonslender
* * 8 = Phi axial tension
* * 9 = Phi axial compression
* * 10 = Time history design
* @param value The value of the considered preference item.
* * 1 = Framing type
* * 1 = Moment Frame
* * 2 = Braced Frame
* * 2 = Demand/capacity ratio limit
* * Value > 0
* * 3 = Phi bending stiffened
* * Value > 0
* * 4 = Phi bending unstiffened
* * Value > 0
* * 5 = Phi bending lateral torsional buckling
* * Value > 0
* * 6 = Phi shear slender
* * Value > 0
* * 7 = Phi shear nonslender
* * Value > 0
* * 8 = Phi axial tension
* * Value > 0
* * 9 = Phi axial compression
* * Value > 0
* * 10 = Time history design
* * 1 = Envelopes
* * 2 = Step-by step
* @return zero if the item is successfully set; otherwise it returns a nonzero value.
*/
fun setPreference (item:Int,value:Double):Int=
callFunctionInt("SetPreference",item,value)

}