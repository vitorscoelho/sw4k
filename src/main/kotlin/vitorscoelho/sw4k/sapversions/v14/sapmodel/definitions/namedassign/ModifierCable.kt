package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.comutils.*

interface ModifierCableV14 : SapComponent {
    /**
     * This function changes the name of an existing cable property modifier.
     * @param name The existing name of a defined cable property modifier.
     * @param newName The new name for the cable property modifier.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined cable property modifiers in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified cable property modifier.
     * @param name The name of an existing cable property modifier.
     * @return zero if the modifier is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified modifier can not be deleted, for example, if it is currently used by a staged construction load case.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the modifier assignments for a cable property modifier. The default value for all modifier values is one.
     * @param name The name of an existing cable property modifier.
     * @param value This is an array of three unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined cable property modifiers.
     * @param numberNames The number of cable property modifier names retrieved by the program.
     * @param myName This is a one-dimensional array of cable property modifier names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function defines a named cable property modifier. The default value for all modifier values is one.
     * @param name The name of a new or existing cable property modifier.
     * @param value This is an array of three unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @return zero if the modifier is successfully defined; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetModifiers", name, value)
}