package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef

class PatternDef(programName: String) : PatternDefV14 {
    override val activeXComponentName: String = "$programName.cPattern"
}

interface PatternDefV14 : SapComponent {
    /**
     * @param name The existing name of a defined joint pattern.
     * @param newName The new name for the joint pattern.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the number of defined joint patterns.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes the specified joint pattern. At least one joint pattern must be defined. The function will return an error if an attempt is made to delete the last joint pattern.
     * @param name The name of an existing joint pattern.
     * @return zero if the joint pattern is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined joint patterns.
     * @param numberNames The number of joint pattern names retrieved by the program.
     * @param myName This is a one-dimensional array of joint pattern names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * The function defines a new joint pattern. It returns an error if the specified joint pattern name is already in use.
     * @param name The name of a new joint pattern.
     * @return zero if the new joint pattern is successfully defined, otherwise it returns a nonzero value.
     */
    fun setPattern(name: String): Int =
            callFunctionInt("SetPattern", name)
}