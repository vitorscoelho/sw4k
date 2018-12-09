package vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.ItemType

interface ChineseV14 : SapComponent {
    /**
     * This function retrieves the value of a concrete design overwrite item.
     * @param name The name of a frame object with a concrete frame design procedure.
     * @param item This is an integer between 1 and 18, inclusive, indicating the overwrite item considered.
     * * 1 = Seismic design grade
     * * 2 = Dual system SMF
     * * 3 = MMF
     * * 4 = SMF
     * * 5 = AFMF
     * * 6 = Column location
     * * 7 = Transfer beam of column
     * * 8 = Corner column seismic modification
     * * 9 = Beam gravity neg moment red factor
     * * 10 = Unbraced length ratio, Major
     * * 11 = Unbraced length ratio, Minor
     * * 12 = Effective length factor, K Major
     * * 13 = Effective length factor, K Minor
     * * 14 = Torsion modification factor
     * * 15 = Torsion design factor, Zeta
     * * 16 = Concrete cover for closed stirrup
     * * 17 = Effective length factor for gravity, K Major
     * * 18 = Effective length factor for gravity, K Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Seismic design grade
     * * 0 = As specified in preferences
     * * 1 = Seismic Super I
     * * 2 = Seismic Class I
     * * 3 = Seismic Class II
     * * 4 = Seismic Class III
     * * 5 = Seismic Class IV
     * * 6 = NonSeismic
     * * 2 = Dual system SMF
     * * Value >= 0; 0 means use program determined value.
     * * 3 = MMF
     * * Value >= 0; 0 means use program determined value.
     * * 4 = SMF
     * * Value >= 0; 0 means use program determined value.
     * * 5 = AFMF
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Column Location
     * * 1 = Center Column
     * * 2 = Side Column
     * * 3 = Corner Column
     * * 4 = End Column
     * * 5 = Individual Column
     * * 7 = Transfer beam or column
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 8 = Corner column seismic modification
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 9 = Beam gravity neg moment red factor
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 13 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 14 = Torsion modification factor
     * * Value >= 0; 0 means use program determined value.
     * * 15 = Torsion design factor, Zeta
     * * Value >= 0; 0 means use program determined value.
     * * 16 = Concrete cover for closed stirrup
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Importance factor gamma 0
     * * 4 = Column design procedure
     * * 5 = Seismic design grade
     * * 6 = Pattern live load factor
     * * 7 = Utilization factor limit
     * * 8 = Time history design
     * * 9 = Structural system
     * * 10 = Is tall building?
     * * 11 = Seismic field type
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Importance factor gamma 0
     * * Value > 0
     * * 4 = Column design procedure
     * * 1 = Appendix F
     * * 2 = Simplified
     * * 5 = Seismic design grade
     * * 1 = Super I
     * * 2 = Grade I
     * * 3 = Grade II
     * * 4 = Grade III
     * * 5 = Grade IV
     * * 6 = Nonseismic
     * * 6 = Pattern live load factor
     * * Value >= 0
     * * 7 = Utilization factor limit
     * * Value > 0
     * * 8 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * This function sets the value of a concrete design overwrite item.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 18, inclusive, indicating the overwrite item considered.
     * * 1 = Seismic design grade
     * * 2 = Dual system SMF
     * * 3 = MMF
     * * 4 = SMF
     * * 5 = AFMF
     * * 6 = Column location
     * * 7 = Transfer beam of column
     * * 8 = Corner column seismic modification
     * * 9 = Beam gravity neg moment red factor
     * * 10 = Unbraced length ratio, Major
     * * 11 = Unbraced length ratio, Minor
     * * 12 = Effective length factor, K Major
     * * 13 = Effective length factor, K Minor
     * * 14 = Torsion modification factor
     * * 15 = Torsion design factor, Zeta
     * * 16 = Concrete cover for closed stirrup
     * @param value The value of the considered overwrite item.
     * * 1 = Seismic design grade
     * * 0 = As specified in preferences
     * * 1 = Seismic Super I
     * * 2 = Seismic Class I
     * * 3 = Seismic Class II
     * * 4 = Seismic Class III
     * * 5 = Seismic Class IV
     * * 6 = NonSeismic
     * * 2 = Dual system SMF
     * * Value >= 0; 0 means use program determined value.
     * * 3 = MMF
     * * Value >= 0; 0 means use program determined value.
     * * 4 = SMF
     * * Value >= 0; 0 means use program determined value.
     * * 5 = AFMF
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Column Location
     * * 1 = Center Column
     * * 2 = Side Column
     * * 3 = Corner Column
     * * 4 = End Column
     * * 5 = Individual Column
     * * 7 = Transfer beam or column
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 8 = Corner column seismic modification
     * * 0 = Program Determined
     * * 1 = No
     * * 2 = Yes
     * * 9 = Beam gravity neg moment red factor
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 13 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 14 = Torsion modification factor
     * * Value >= 0; 0 means use program determined value.
     * * 15 = Torsion design factor, Zeta
     * * Value >= 0; 0 means use program determined value.
     * * 16 = Concrete cover for closed stirrup
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
     * This function sets the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Importance factor gamma 0
     * * 4 = Column design procedure
     * * 5 = Seismic design grade
     * * 6 = Pattern live load factor
     * * 7 = Utilization factor limit
     * * 8 = Time history design
     * * 9 = Structural system
     * * 10 = Is tall building?
     * * 11 = Seismic field type
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Importance factor gamma 0
     * * Value > 0
     * * 4 = Column design procedure
     * * 1 = Appendix F
     * * 2 = Simplified
     * * 5 = Seismic design grade
     * * 1 = Super I
     * * 2 = Grade I
     * * 3 = Grade II
     * * 4 = Grade III
     * * 5 = Grade IV
     * * 6 = Nonseismic
     * * 6 = Pattern live load factor
     * * Value >= 0
     * * 7 = Utilization factor limit
     * * Value > 0
     * * 8 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}