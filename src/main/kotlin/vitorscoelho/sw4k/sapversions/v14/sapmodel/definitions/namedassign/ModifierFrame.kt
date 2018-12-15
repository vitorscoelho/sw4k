package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.comutils.*

interface ModifierFrameV14 : SapComponent {
    /**
     * This function changes the name of an existing frame property modifier.
     * @param name The existing name of a defined frame property modifier.
     * @param newName The new name for the frame property modifier.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined frame property modifiers in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified frame property modifier.
     * @param name The name of an existing frame property modifier.
     * @return zero if the modifier is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified modifier can not be deleted; for example, if it is currently used by a staged construction load case.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the modifier assignments for a frame property modifier. The default value for all modifier values is one.
     * @param name The name of an existing frame property modifier.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: ADoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined frame property modifiers.
     * @param numberNames The number of frame property modifier names retrieved by the program.
     * @param myName This is a one-dimensional array of frame property modifier names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function defines a named frame property modifier. The default value for all modifier values is one.
     * @param name The name of a new or existing frame property modifier.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @return zero if the modifier is successfully defined; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: ADoubleArrayByRef): Int =
            callFunctionInt("SetModifiers", name, value)
}