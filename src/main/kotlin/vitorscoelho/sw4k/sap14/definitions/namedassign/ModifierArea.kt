package vitorscoelho.sw4k.sap14.definitions.namedassign

import vitorscoelho.sw4k.comutils.*

class ModifierArea(programName: String) : ModifierAreaV14 {
    override val activeXComponentName: String = "$programName.cModifierArea"
}

interface ModifierAreaV14 : SapComponent {
    /**
     * This function changes the name of an existing area stiffness modifier.
     * @param name The existing name of a defined area stiffness modifier.
     * @param newName The new name for the area stiffness modifier.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined area stiffness modifiers in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified area stiffness modifier.
     * @param name The name of an existing area stiffness modifier.
     * @return zero if the modifier is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified modifier can not be deleted; for example, if it is currently used by a staged construction load case.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the modifier assignments for an area stiffness modifier. The default value for all modifier values is one.
     * @param name The name of an existing area stiffness modifier.
     * @param value This is an array of ten unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined area stiffness modifiers.
     * @param numberNames The number of area stiffness modifier names retrieved by the program.
     * @param myName This is a one-dimensional array of area stiffness modifier names. The MyName array is created as a dynamic, zero-based array by the API user:
     * The array is dimensioned to (NumberNames - 1) inside the SAP2000 program, filled with the names, and returned to the API user.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero values.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function defines a named area stiffness modifier. The default value for all modifier values is one.
     * @param name The name of a new or existing area stiffness modifier.
     * @param value This is an array of ten unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @return zero if the modifier is successfully defined; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("SetModifiers", name, value)
}