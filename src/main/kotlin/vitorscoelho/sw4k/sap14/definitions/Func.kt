package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef
import vitorscoelho.sw4k.sap14.definitions.functions.*

class Func(programName: String) : FuncV14 {
    override val activeXComponentName: String = "$programName.cFunction"
    override val funcPSD = FuncPSD(programName)
    override val funcRS = FuncRS(programName)
    override val funcSS = FuncSS(programName)
    override val funcTH = FuncTH(programName)
}

interface FuncV14 : SapComponent {
    val funcPSD: FuncPSDV14
    val funcRS: FuncRSV14
    val funcSS: FuncSSV14
    val funcTH: FuncTHV14
    /**
     * This function changes the name of an existing function.
     * @param name The existing name of a defined function.
     * @param newName The new name for the function.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * This function converts an existing function to a user defined function.
     * @param name The name of an existing function that is not a user defined function.
     * @return zero if the function definition is successfully converted; otherwise it returns a nonzero value. An error is returned if the specified function is already a user defined function.
     */
    fun convertToUser(name: String): Int =
            callFunctionInt("ConvertToUser", name)

    /**
     * @param funcType This optional value is one of the following numbers, indicating the type of function for which the count is desired.
     * * 0 = All function types
     * * 1 = Response spectrum
     * * 2 = Time history
     * * 3 = Power spectral density
     * * 4 = Steady state
     * @return the total number of defined functions in the model of the specified type.
     */
    fun count(funcType: Int = 0): Int =
            callFunctionInt("Count", funcType)

    /**
     * The function deletes a specified function.
     * @param name The name of an existing function.
     * @return zero if the function is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified function can not be deleted if, for example, it is being used in an load case.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined functions of the specified type.
     * @param numberNames The number of function names retrieved by the program.
     * @param myName This is a one-dimensional array of function names.
     * @param funcType This is one of the following numbers, indicating the type of function for which the name list is desired.
     * * 0 = All function types
     * * 1 = Response spectrum
     * * 2 = Time history
     * * 3 = Power spectral density
     * * 4 = Steady state
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef, funcType: Int = 0): Int =
            callFunctionInt("GetNameList", numberNames, myName, funcType)

    /**
     * This function retrieves the function type for the specified function.
     * @param name The name of an existing function.
     * @param funcType This is one of the following numbers, indicating the type of function.
     * * 1 = Response spectrum
     * * 2 = Time history
     * * 3 = Power spectral density
     * * 4 = Steady state
     * @param addType The is one of the following items, indicating the function subtype.
     * * 0 = From file
     * * 1 = User
     * * 2 = UBC 94
     * * 3 = UBC 97
     * * 4 = BOCA 96
     * * 5 = NBCC 95
     * * 6 = IBC 2003
     * * 7 = NEHRP 97
     * * 8 = EuroCode 8
     * * 9 = NZS4203 1992
     * * 10 = Chinese 2002
     * * 11 = Italian Ordinanza 3274
     * * 12 = IS1893:2002
     * * 13 = AASHTO LRFD 2006
     * * 14 = NCHRP Project 20-07
     * * 15 = IBC 2006
     * * 0 = From file
     * * 1 = User
     * * 2 = Sine
     * * 3 = Cosine
     * * 4 = Ramp
     * * 5 = Sawtooth
     * * 6 = Triangular
     * * 7 = User periodic
     * * 0 = From file
     * * 1 = User
     * * 0 = From file
     * * 1 = User
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType(name: String, funcType: IntByRef, addType: IntByRef): Int =
            callFunctionInt("GetType", name, funcType, addType)

    /**
     * This function retrieves the time and function values for any defined function.
     * @param name The name of an existing function.
     * @param numberItems The number of time and function value pairs retrieved.
     * @param myTime This is an array that includes the time value for each data point. (s) for response spectrum and time history functions, [cyc/s] for power spectral density and steady state functions
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getValues(name: String, numberItems: IntByRef, myTime: DoubleArrayByRef, value: DoubleArrayByRef): Int =
            callFunctionInt("GetValues", name, numberItems, myTime, value)
}