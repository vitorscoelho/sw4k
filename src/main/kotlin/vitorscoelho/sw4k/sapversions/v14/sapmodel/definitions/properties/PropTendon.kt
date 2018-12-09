package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*

interface PropTendonV14 : SapComponent {
    /**
     * This function changes the name of an existing tendon property.
     * @param name The existing name of a defined tendon property.
     * @param newName The new name for the tendon property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined tendon properties in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified tendon property.
     * @param name The name of an existing tendon property.
     * @return zero if the property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified property can not be deleted, for example, if it is assigned to an existing object.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined tendon properties in the model.
     * @param numberNames The number of tendon property names retrieved by the program.
     * @param myName This is a one-dimensional array of tendon property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves tendon property definition data.
     * @param name The name of an existing tendon property.
     * @param matProp The name of the material property assigned to the tendon property.
     * @param modelingOption This is either 1 or 2, indicating the tendon modeling option.
     * * 1 = Model tendon as loads
     * * 2 = Model tendon as elements
     * @param area The cross-sectional area of the tendon. (L2)
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProp(name: String, matProp: StringByRef, modelingOption: IntByRef, area: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetProp", name, matProp, modelingOption, area, color, notes, GUID)

    /**
     * This function defines a tendon property.
     * @param name The name of an existing or new tendon property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property assigned to the tendon property.
     * @param modelingOption This is either 1 or 2, indicating the tendon modeling option.
     * * 1 = Model tendon as loads
     * * 2 = Model tendon as elements
     * @param area The cross-sectional area of the tendon. (L2)
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully defined; otherwise it returns a nonzero value.
     */
    fun setProp(name: String, matProp: String, modelingOption: Int, area: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetProp", name, matProp, modelingOption, area, color, notes, GUID)
}