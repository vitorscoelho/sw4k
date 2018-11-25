package vitorscoelho.sw4k.sap14.definitions.functions

import vitorscoelho.sw4k.comutils.*

class FuncPSD(programName: String) : FuncPSDV14 {
    override val activeXComponentName: String = "$programName.cFunctionPSD"
}

interface FuncPSDV14 : SapComponent {
    /**
     * This function retrieves the definition of a power spectral density function from file.
     * @param name The name of a defined power spectral density function specified to be from a text file.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is either 1 or 2, indicating value type.
     * * 1 = Values at equal time intervals
     * * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item applies only when the FreeFormat item is False. It is the number of characters per item.
     * @param freqTypeInFile This is either 1 or 2, indicating frequency type.
     * * 1 = Hz
     * * 2 = RPM
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getFromFile(name: String, fileName: StringByRef, headLines: IntByRef, preChars: IntByRef, pointsPerLine: IntByRef, valueType: IntByRef, freeFormat: BooleanByRef, numberFixed: IntByRef, freqTypeInFile: IntByRef): Int =
            callFunctionInt("GetFromFile", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed, freqTypeInFile)

    /**
     * This function retrieves the definition of a user defined power spectral density function.
     * @param name The name of a user defined power spectral density function.
     * @param numberItems The number of frequency and value pairs defined.
     * @param frequency This is an array that includes the frequency in Hz for each data point. (cyc/s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUser(name: String, numberItems: IntByRef, frequency: DoubleArrayByRef, value: DoubleArrayByRef): Int =
            callFunctionInt("GetUser", name, numberItems, frequency, value)

    /**
     * This function defines a power spectral density function from file.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is either 1 or 2, indicating value type.
     * * 1 = Values at equal time intervals
     * * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item only applies when the FreeFormat item is False. It is the number of characters per item.
     * @param freqTypeInFile This is either 1 or 2, indicating frequency type.
     * * 1 = Hz
     * * 2 = RPM
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setFromFile(name: String, fileName: String, headLines: Int, preChars: Int, pointsPerLine: Int, valueType: Int, freeFormat: Boolean, numberFixed: Int = 10, freqTypeInFile: Int = 1): Int =
            callFunctionInt("SetFromFile", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed, freqTypeInFile)

    /**
     * This function defines a user power spectral density function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param numberItems The number of frequency and value pairs defined.
     * @param frequency This is an array that includes the frequency in Hz for each data point. (cyc/s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUser(name: String, numberItems: Int, frequency: DoubleArrayByRef, value: DoubleArrayByRef): Int =
            callFunctionInt("SetUser", name, numberItems, frequency, value)
}