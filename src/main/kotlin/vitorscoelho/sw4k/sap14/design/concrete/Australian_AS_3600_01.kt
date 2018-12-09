import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class Australian_AS_3600_01 internal constructor(programName: String) : Australian_AS_3600_01V14 {
    override val activeXComponentName: String = "$programName.cDCoAustralian_AS_3600-01"
}

interface Australian_AS_3600_01V14 : SapComponent {
    /**
     * This function retrieves the value of a concrete design overwrite item.
     * @param name The name of a frame object with a concrete frame design procedure.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, K Major
     * * 6 = Effective length factor, K Minor
     * * 7 = Moment coefficient, km Major
     * * 8 = Moment coefficient, km Minor
     * * 9 = Nonsway moment factor, Db Major
     * * 10 = Nonsway moment factor, Db Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway special
     * * 2 = Sway intermediate
     * * 3 = Sway ordinary
     * * 4 = Nonsway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, km Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, km Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Nonsway moment factor, Db Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Nonsway moment factor, Db Minor
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Sway moment factor, Ds Major
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Sway moment factor, Ds Minor
     * * Value >= 0; 0 means use program determined value.
     * @param progDet If this item is True, the specified value is program determined.
     * @return zero if the item is successfully retrieved; otherwise, it returns a nonzero value.
     */
    fun getOverwrite(name: String, item: Int, value: DoubleByRef, progDet: BooleanByRef): Int =
            callFunctionInt("GetOverwrite", name, item, value, progDet)

    /**
     * This function retrieves the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Consider minimum eccentricity
     * * 4 = Phi tension controlled
     * * 5 = Phi compression controlled
     * * 6 = Phi shear and/or torsion
     * * 7 = Phi shear seismic
     * * 8 = Phi joint shear
     * * 9 = Pattern live load factor
     * * 10 = Utilization factor limit
     * * 11 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and divisible by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Phi tension controlled
     * * Value > 0
     * * 5 = Phi compression controlled
     * * Value > 0
     * * 6 = Phi shear and/or torsion
     * * Value > 0
     * * 7 = Phi shear seismic
     * * Value > 0
     * * 8 = Phi joint shear
     * * Value > 0
     * * 9 = Pattern live load factor
     * * Value >= 0
     * * 10 = Utilization factor limit
     * * Value > 0
     * * 11 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully retrieved; otherwise, it returns a nonzero value.
     */
    fun getPreference(item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetPreference", item, value)

    /**
     * SapObject.SapModel.DesignConcrete.AS_3600_01.SetOverwrite
     * Function SetOverwrite(ByVal Name As String, ByVal Item As Long, ByVal Value As Double, Optional ByVal ItemType As eItemType = Object) As Long
     * Name
     * The name of an existing frame object or group, depending on the value of the ItemType item.
     * Item
     * This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * 1 = Framing type
     * 2 = Live load reduction factor
     * 3 = Unbraced length ratio, Major
     * 4 = Unbraced length ratio, Minor
     * 5 = Effective length factor, K Major
     * 6 = Effective length factor, K Minor
     * 7 = Moment coefficient, km Major
     * 8 = Moment coefficient, km Minor
     * 9 = Nonsway moment factor, Db Major
     * 10 = Nonsway moment factor, Db Minor
     * 11 = Sway moment factor, Ds Major
     * 12 = Sway moment factor, Ds Minor
     * Value
     * The value of the considered overwrite item.
     * 1 = Framing type
     * 0 = Program Default
     * 1 = Sway special
     * 2 = Sway intermediate
     * 3 = Sway ordinary
     * 4 = Nonsway
     *
     * 2 = Live load reduction factor
     * Value >= 0; 0 means use program determined value.
     *
     * 3 = Unbraced length ratio, Major
     * Value >= 0; 0 means use program determined value.
     *
     * 4 = Unbraced length ratio, Minor
     * Value >= 0; 0 means use program determined value.
     *
     * 5 = Effective length factor, K Major
     * Value >= 0; 0 means use program determined value.
     *
     * 6 = Effective length factor, K Minor
     * Value >= 0; 0 means use program determined value.
     *
     * 7 = Moment coefficient, km Major
     * Value >= 0; 0 means use program determined value.
     *
     * 8 = Moment coefficient, km Minor
     * Value >= 0; 0 means use program determined value.
     *
     * 9 = Nonsway moment factor, Db Major
     * Value >= 0; 0 means use program determined value.
     *
     * 10 = Nonsway moment factor, Db Minor
     * Value >= 0; 0 means use program determined value.
     *
     * 11 = Sway moment factor, Ds Major
     * Value >= 0; 0 means use program determined value.
     *
     * 12 = Sway moment factor, Ds Minor
     * Value >= 0; 0 means use program determined value
     *
     * ItemType
     * This is one of the following items in the eItemType enumeration:
     * Object = 0
     * Group = 1
     * SelectedObjects = 2
     *
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * This function sets the value of a concrete design overwrite item.
     * The function returns zero if the item is successfully set; otherwise, it returns a nonzero value.
     * Sub SetConcreteDesignOverwriteItemAS_3600_01() 'dimension variables Dim SapObject As Sap2000.SapObject Dim SapModel As cSapModel Dim ret As Long 'create Sap2000 object Set SapObject = New SAP2000.SapObject 'start Sap2000 application SapObject.ApplicationStart 'create SapModel object Set SapModel = SapObject.SapModel 'initialize model ret = SapModel.InitializeNewModel 'create new concrete frame section property ret = SapModel.PropFrame.SetRectangle("R1", "4000Psi", 20, 12) 'create model from template ret = SapModel.File.New2DFrame(PortalFrame, 2, 144, 2, 288, True, "R1", "R1") 'set concrete design code ret = SapModel.DesignConcrete.SetCode("AS 3600-01") 'set overwrite item ret = SapModel.DesignConcrete.AS_3600_01.SetOverwrite("8", 1, 2) 'close Sap2000 SapObject.ApplicationExit False Set SapModel = Nothing Set SapObject = Nothing End Sub
     * Initial release in version 14.0.0.
     * GetOverwrite
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param item This is an integer between 1 and 12, inclusive, indicating the overwrite item considered.
     * * 1 = Framing type
     * * 2 = Live load reduction factor
     * * 3 = Unbraced length ratio, Major
     * * 4 = Unbraced length ratio, Minor
     * * 5 = Effective length factor, K Major
     * * 6 = Effective length factor, K Minor
     * * 7 = Moment coefficient, km Major
     * * 8 = Moment coefficient, km Minor
     * * 9 = Nonsway moment factor, Db Major
     * * 10 = Nonsway moment factor, Db Minor
     * * 11 = Sway moment factor, Ds Major
     * * 12 = Sway moment factor, Ds Minor
     * @param value The value of the considered overwrite item.
     * * 1 = Framing type
     * * 0 = Program Default
     * * 1 = Sway special
     * * 2 = Sway intermediate
     * * 3 = Sway ordinary
     * * 4 = Nonsway
     * * 2 = Live load reduction factor
     * * Value >= 0; 0 means use program determined value.
     * * 3 = Unbraced length ratio, Major
     * * Value >= 0; 0 means use program determined value.
     * * 4 = Unbraced length ratio, Minor
     * * Value >= 0; 0 means use program determined value.
     * * 5 = Effective length factor, K Major
     * * Value >= 0; 0 means use program determined value.
     * * 6 = Effective length factor, K Minor
     * * Value >= 0; 0 means use program determined value.
     * * 7 = Moment coefficient, km Major
     * * Value >= 0; 0 means use program determined value.
     * * 8 = Moment coefficient, km Minor
     * * Value >= 0; 0 means use program determined value.
     * * 9 = Nonsway moment factor, Db Major
     * * Value >= 0; 0 means use program determined value.
     * * 10 = Nonsway moment factor, Db Minor
     * * Value >= 0; 0 means use program determined value.
     * * 11 = Sway moment factor, Ds Major
     * * Value >= 0; 0 means use program determined value.
     * * 12 = Sway moment factor, Ds Minor
     * * Value >= 0; 0 means use program determined value
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * This function sets the value of a concrete design overwrite item.
     * The function returns zero if the item is successfully set; otherwise, it returns a nonzero value.
     * Initial release in version 14.0.0.
     * @return AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */
    fun setOverwrite(name: String, item: Int, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOverwrite", name, item, value, itemType)

    /**
     * This function sets the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Consider minimum eccentricity
     * * 4 = Phi tension controlled
     * * 5 = Phi compression controlled
     * * 6 = Phi shear and/or torsion
     * * 7 = Phi shear seismic
     * * 8 = Phi joint shear
     * * 9 = Pattern live load factor
     * * 10 = Utilization factor limit
     * * 11 = Time history design
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and divisible by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Consider minimum eccentricity
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Phi tension controlled
     * * Value > 0
     * * 5 = Phi compression controlled
     * * Value > 0
     * * 6 = Phi shear and/or torsion
     * * Value > 0
     * * 7 = Phi shear seismic
     * * Value > 0
     * * 8 = Phi joint shear
     * * Value > 0
     * * 9 = Pattern live load factor
     * * Value >= 0
     * * 10 = Utilization factor limit
     * * Value > 0
     * * 11 = Time history design
     * * 1 = Envelopes
     * * 2 = Step-by step
     * @return zero if the item is successfully set; otherwise, it returns a nonzero value.
     */
    fun setPreference(item: Int, value: Double): Int =
            callFunctionInt("SetPreference", item, value)

}