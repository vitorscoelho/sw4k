package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*

interface PropCableV14 : SapComponent {
    /**
     * This function changes the name of an existing cable property.
     * @param name The existing name of a defined cable property.
     * @param newName The new name for the cable property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName (name:String,newName:String):Int=
            callFunctionInt("ChangeName",name,newName)
    /**
     * @return the total number of defined cable properties in the model.
     */
    fun count ():Int=
    callFunctionInt("Count")
    /**
     * The function deletes a specified cable property.
     * @param name The name of an existing cable property.
     * @return zero if the property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified property can not be deleted, for example, if it is assigned to an existing object.
     */
    fun delete (name:String):Int=
            callFunctionInt("Delete",name)
    /**
     * This function retrieves the modifier assignments for a cable property. The default value for all modifiers is one.
     * @param name The name of an existing cable property.
     * @param value This is an array of three unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers (name:String,value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY):Int=
            callFunctionInt("GetModifiers",name,value)
    /**
     * This function retrieves the names of all defined cable properties in the model.
     * @param numberNames The number of cable property names retrieved by the program.
     * @param myName This is a one-dimensional array of cable property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList (numberNames: AIntByRef = IntByRef.UNNECESSARY,myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY):Int=
            callFunctionInt("GetNameList",numberNames,myName)
    /**
     * This function retrieves cable property definition data.
     * @param name The name of an existing cable property.
     * @param matProp The name of the material property assigned to the cable property.
     * @param area The cross-sectional area of the cable. (L2)
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProp (name:String,matProp: AStringByRef = StringByRef.UNNECESSARY,area: ADoubleByRef = DoubleByRef.UNNECESSARY,color: AIntByRef = IntByRef.UNNECESSARY,notes: AStringByRef = StringByRef.UNNECESSARY,GUID: AStringByRef = StringByRef.UNNECESSARY):Int=
            callFunctionInt("GetProp",name,matProp,area,color,notes,GUID)
    /**
     * This function assigns property modifiers to a cable property. The default value for all modifiers is one.
     * @param name The name of an existing cable property.
     * @param value This is an array of 3 unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @return zero if the modifiers are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setModifiers (name:String,value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY):Int=
            callFunctionInt("SetModifiers",name,value)
    /**
     * This function defines a cable property.
     * @param name The name of an existing or new cable property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property assigned to the cable property.
     * @param area The cross-sectional area of the cable. (L2)
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully defined; otherwise it returns a nonzero value.
     */
    fun setProp (name:String,matProp:String,area:Double,color:Int=-1,notes:String="",GUID:String=""):Int=
            callFunctionInt("SetProp",name,matProp,area,color,notes,GUID)
}