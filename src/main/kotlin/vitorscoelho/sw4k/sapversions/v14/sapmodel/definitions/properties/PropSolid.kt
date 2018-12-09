package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*

interface PropSolidV14 : SapComponent {
    /**
     * This function changes the name of an existing solid property.
     * @param name The existing name of a defined solid property.
     * @param newName The new name for the solid property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined solid properties in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified solid property.
     * @param name The name of an existing solid property.
     * @return zero if the property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified property can not be deleted, for example, if it is assigned to an existing object.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined solid properties in the model.
     * @param numberNames The number of solid property names retrieved by the program.
     * @param myName This is a one-dimensional array of solid property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves solid property definition data.
     * @param name The name of an existing solid property.
     * @param matProp The name of the material property assigned to the solid property.
     * @param a The material angle A. (deg)
     * @param b The material angle B. (deg)
     * @param c The material angle C. (deg)
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProp(name: String, matProp: StringByRef, a: DoubleByRef, b: DoubleByRef, c: DoubleByRef, incompatible: BooleanByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetProp", name, matProp, a, b, c, incompatible, color, notes, GUID)

    /**
     * This function defines a solid property.
     * @param name The name of an existing or new solid property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property assigned to the solid property.
     * @param a The material angle A. (deg)
     * @param b The material angle B. (deg)
     * @param c The material angle C. (deg)
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully defined; otherwise it returns a nonzero value.
     */
    fun setProp(name: String, matProp: String, a: Double, b: Double, c: Double, incompatible: Boolean, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetProp", name, matProp, a, b, c, incompatible, color, notes, GUID)
}