package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions

import vitorscoelho.sw4k.comutils.*

interface FuncTHV14 : SapComponent {
    /**
     * This function retrieves the definition of a cosine-type time history function.
     * @param name The name of a cosine-type time history function.
     * @param cosineP The period of the cosine function. (s)
     * @param cosineSteps The number of steps in the cosine function. This item can not be less than 8.
     * @param cosineCycles The number of cycles in the cosine function.
     * @param cosineAmp The amplitude of the cosine function.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCosine(name: String, cosineP: ADoubleByRef = DoubleByRef.UNNECESSARY, cosineSteps: AIntByRef = IntByRef.UNNECESSARY, cosineCycles: AIntByRef = IntByRef.UNNECESSARY, cosineAmp: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetCosine", name, cosineP, cosineSteps, cosineCycles, cosineAmp)

    /**
     * This function retrieves the definition of a time history function from file.
     * @param name The name of a defined time history function specified to be from a text file.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is either 1 or 2, indicating value type.
     * * 1 = Values at equal time intervals
     * * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item applies only when the FreeFormat item is False. It is the number of characters per item.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "The function is obsolete and has been superceded by GetFromFile_1 as of version 14.12. This function is maintained for backward compatibility. New function added.",
            replaceWith = ReplaceWith(
                    expression = "getFromFile_1(name,fileName,headLines,preChars,pointsPerLine,valueType,freeFormat,numberFixed,DT)",
                    imports = arrayOf("vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncTH")
            ),
            level = DeprecationLevel.WARNING
    )
    fun getFromFile(name: String, fileName: AStringByRef = StringByRef.UNNECESSARY, headLines: AIntByRef = IntByRef.UNNECESSARY, preChars: AIntByRef = IntByRef.UNNECESSARY, pointsPerLine: AIntByRef = IntByRef.UNNECESSARY, valueType: AIntByRef = IntByRef.UNNECESSARY, freeFormat: ABooleanByRef = BooleanByRef.UNNECESSARY, numberFixed: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetFromFile", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed)

    /**
     * This function retrieves the definition of a time history function from file.
     * @param name The name of a defined time history function specified to be from a text file.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is 1 or 2, indicating value type.
     * 1 = Values at equal time intervals
     * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item applies only when the FreeFormat item is False. It is the number of characters per item.
     * @param DT This item applies only when the ValueType item is 1 (equal time intervals). It is the time interval between function points.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getFromFile_1(name: String, fileName: AStringByRef = StringByRef.UNNECESSARY, headLines: AIntByRef = IntByRef.UNNECESSARY, preChars: AIntByRef = IntByRef.UNNECESSARY, pointsPerLine: AIntByRef = IntByRef.UNNECESSARY, valueType: AIntByRef = IntByRef.UNNECESSARY, freeFormat: ABooleanByRef = BooleanByRef.UNNECESSARY, numberFixed: AIntByRef = IntByRef.UNNECESSARY, DT: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetFromFile_1", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed, DT)

    /**
     * This function retrieves the definition of a ramp-type time history function.
     * @param name The name of a ramp-type time history function.
     * @param rampTime The time it takes for the ramp function to initially reach its maximum value. (s)
     * @param rampAmp The maximum amplitude of the ramp function.
     * @param rampMaxTime The time at the end of the ramp function. This time must be greater than the RampTime. (s)
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRamp(name: String, rampTime: ADoubleByRef = DoubleByRef.UNNECESSARY, rampAmp: ADoubleByRef = DoubleByRef.UNNECESSARY, rampMaxTime: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetRamp", name, rampTime, rampAmp, rampMaxTime)

    /**
     * This function retrieves the definition of a sawtooth-type time history function.
     * @param name The name of a sawtooth-type time history function.
     * @param sawP The period of the sawtooth function. (s)
     * @param sawTime The time it takes for the sawtooth function to ramp up from a function value of zero to its maximum amplitude. (s)
     * @param sawCycles The number of cycles in the function.
     * @param sawAmp The maximum amplitude of the sawtooth function.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSawtooth(name: String, sawP: ADoubleByRef = DoubleByRef.UNNECESSARY, sawTime: ADoubleByRef = DoubleByRef.UNNECESSARY, sawCycles: AIntByRef = IntByRef.UNNECESSARY, sawAmp: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetSawtooth", name, sawP, sawTime, sawCycles, sawAmp)

    /**
     * This function retrieves the definition of a sine-type time history function.
     * @param name The name of a sine-type time history function.
     * @param sineP The period of the sine function. (s)
     * @param sineSteps The number of steps in the sine function. This item can not be less than 8.
     * @param sineCycles The number of cycles in the sine function.
     * @param sineAmp The amplitude of the sine function.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSine(name: String, sineP: ADoubleByRef = DoubleByRef.UNNECESSARY, sineSteps: AIntByRef = IntByRef.UNNECESSARY, sineCycles: AIntByRef = IntByRef.UNNECESSARY, sineAmp: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetSine", name, sineP, sineSteps, sineCycles, sineAmp)

    /**
     * This function retrieves the definition of a triangular-type time history function.
     * @param name The name of a triangular-type time history function.
     * @param triP The period of the triangular function. (s)
     * @param triCycles The number of cycles in the function.
     * @param triAmp The maximum amplitude of the triangular function.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTriangular(name: String, triP: ADoubleByRef = DoubleByRef.UNNECESSARY, triCycles: AIntByRef = IntByRef.UNNECESSARY, triAmp: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetTriangular", name, triP, triCycles, triAmp)

    /**
     * This function retrieves the definition of a user periodic time history function.
     * @param name The name of a user periodic time history function.
     * @param uPCycles The number of cycles in the function.
     * @param numberItems The number of frequency and value pairs defined.
     * @param myTime This is an array that includes the time for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUserPeriodic(name: String, uPCycles: AIntByRef = IntByRef.UNNECESSARY, numberItems: AIntByRef = IntByRef.UNNECESSARY, myTime: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetUserPeriodic", name, uPCycles, numberItems, myTime, value)

    /**
     * This function retrieves the definition of a user defined time history function.
     * @param name The name of a user defined time history function.
     * @param numberItems The number of frequency and value pairs defined.
     * @param myTime This is an array that includes the time for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUser(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, myTime: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetUser", name, numberItems, myTime, value)

    /**
     * This function defines a cosine-type time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param cosineP The period of the cosine function. (s)
     * @param cosineSteps The number of steps in the cosine function. This item can not be less than 8.
     * @param cosineCycles The number of cycles in the cosine function.
     * @param cosineAmp The amplitude of the cosine function.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setCosine(name: String, cosineP: Double, cosineSteps: Int, cosineCycles: Int, cosineAmp: Double): Int =
            callFunctionInt("SetCosine", name, cosineP, cosineSteps, cosineCycles, cosineAmp)

    /**
     * This function defines a time history function from file.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is either 1 or 2, indicating value type.
     * * 1 = Values at equal time intervals
     * * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item applies only when the FreeFormat item is False. It is the number of characters per item.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "The function is obsolete and has been superceded by SetFromFile_1 as of version 14.12. This function is maintained for backward compatibility. New function added. ",
            replaceWith = ReplaceWith(
                    expression = "setFromFile_1(name,fileName,headLines,preChars,pointsPerLine,valueType,freeFormat,numberFixed,DT)",
                    imports = arrayOf("vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncTH")
            ),
            level = DeprecationLevel.WARNING
    )
    fun setFromFile(name: String, fileName: String, headLines: Int, preChars: Int, pointsPerLine: Int, valueType: Int, freeFormat: Boolean, numberFixed: Int = 10): Int =
            callFunctionInt("SetFromFile", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed)

    /**
     * This function defines a time history function from file.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param preChars The number of prefix characters to be skipped on each line in the text file.
     * @param pointsPerLine The number of function points included on each text file line.
     * @param valueType This is 1 or 2, indicating value type.
     * 1 = Values at equal time intervals
     * 2 = Time and function values
     * @param freeFormat This item is True if the data is provided in a free format. It is False if it is in a fixed format.
     * @param numberFixed This item applies only when the FreeFormat item is False. It is the number of characters per item.
     * @param DT This item applies only when the ValueType item is 1 (equal time intervals). It is the time interval between function points.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setFromFile_1(name: String, fileName: String, headLines: Int, preChars: Int, pointsPerLine: Int, valueType: Int, freeFormat: Boolean, numberFixed: Int = 10, DT: Double = 0.02): Int =
            callFunctionInt("SetFromFile_1", name, fileName, headLines, preChars, pointsPerLine, valueType, freeFormat, numberFixed, DT)

    /**
     * This function defines a ramp-type time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param rampTime The time it takes for the ramp function to initially reach its maximum value. (s)
     * @param rampAmp The maximum amplitude of the ramp function.
     * @param rampMaxTime The time at the end of the ramp function. This time must be greater than the RampTime. (s)
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setRamp(name: String, rampTime: Double, rampAmp: Double, rampMaxTime: Double): Int =
            callFunctionInt("SetRamp", name, rampTime, rampAmp, rampMaxTime)

    /**
     * This function defines a sawtooth-type time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param sawP The period of the sawtooth function. (s)
     * @param sawTime The time it takes for the sawtooth function to ramp up from a function value of zero to its maximum amplitude. (s)
     * @param sawCycles The number of cycles in the function.
     * @param sawAmp The maximum amplitude of the sawtooth function.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setSawtooth(name: String, sawP: Double, sawTime: Double, sawCycles: Int, sawAmp: Double): Int =
            callFunctionInt("SetSawtooth", name, sawP, sawTime, sawCycles, sawAmp)

    /**
     * This function defines a sine-type time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param sineP The period of the sine function. (s)
     * @param sineSteps The number of steps in the sine function. This item can not be less than 8.
     * @param sineCycles The number of cycles in the sine function.
     * @param sineAmp The amplitude of the sine function.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setSine(name: String, sineP: Double, sineSteps: Int, sineCycles: Int, sineAmp: Double): Int =
            callFunctionInt("SetSine", name, sineP, sineSteps, sineCycles, sineAmp)

    /**
     * This function defines a triangular-type time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param triP The period of the triangular function. (s)
     * @param triCycles The number of cycles in the function.
     * @param triAmp The maximum amplitude of the triangular function.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setTriangular(name: String, triP: Double, triCycles: Int, triAmp: Double): Int =
            callFunctionInt("SetTriangular", name, triP, triCycles, triAmp)

    /**
     * This function defines a user periodic time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param uPCycles The number of cycles in the function.
     * @param numberItems The number of time and value pairs defined.
     * @param myTime This is an array that includes the time for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUserPeriodic(name: String, uPCycles: Int, numberItems: Int, myTime: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetUserPeriodic", name, uPCycles, numberItems, myTime, value)

    /**
     * This function defines a user time history function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param numberItems The number of time and value pairs defined.
     * @param myTime This is an array that includes the time for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUser(name: String, numberItems: Int, myTime: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetUser", name, numberItems, myTime, value)
}