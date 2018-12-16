package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.comutils.*

interface ReleaseFrameV14 : SapComponent {
    /**
     * This function changes the name of an existing frame end release.
     * @param name The existing name of a defined frame end release.
     * @param newName The new name for the frame end release.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined frame end releases in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes a specified frame end release.
     * @param name The name of an existing frame end release.
     * @return zero if the end release is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified end release can not be deleted; for example, if it is currently used by a staged construction load case.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined frame end releases.
     * @param numberNames The number of frame end release names retrieved by the program.
     * @param myName This is a one-dimensional array of frame end release names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero values.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the release assignments for a frame end release.
     * @param name The name of an existing frame end release.
     * @param ii These are arrays of six booleans indicating the I-End releases.
     * * ii(0) = U1 release
     * * ii(1) = U2 release
     * * ii(2) = U3 release
     * * ii(3) = R1 release
     * * ii(4) = R2 release
     * * ii(5) = R3 release
     * @param jj These are arrays of six booleans indicating the J-End releases.
     * * jj(0) = U1 release
     * * jj(1) = U2 release
     * * jj(2) = U3 release
     * * jj(3) = R1 release
     * * jj(4) = R2 release
     * * jj(5) = R3 release
     * @param startValue These are arrays of six values indicating the I-End partial fixity springs.
     * * StartValue(0) = U1 partial fixity (F/L)
     * * StartValue(1) = U2 partial fixity (F/L)
     * * StartValue(2) = U3 partial fixity (F/L)
     * * StartValue(3) = R1 partial fixity (FL/rad)
     * * StartValue(4) = R2 partial fixity (FL/rad)
     * * StartValue(5) = R3 partial fixity (FL/rad)
     * @param endValue These are arrays of six values indicating the J-End partial fixity springs.
     * * EndValue(0) = U1 partial fixity (F/L)
     * * EndValue(1) = U2 partial fixity (F/L)
     * * EndValue(2) = U3 partial fixity (F/L)
     * * EndValue(3) = R1 partial fixity (FL/rad)
     * * EndValue(4) = R2 partial fixity (FL/rad)
     * * EndValue(5) = R3 partial fixity (FL/rad)
     * @return zero if the release assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReleases(name: String, ii: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, jj: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, startValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, endValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetReleases", name, ii, jj, startValue, endValue)

    /**
     * This function defines a named frame end release.
     * @param name The name of a new or existing frame end release.
     * @param ii These are arrays of six booleans indicating the I-End releases.
     * * ii(0) = U1 release
     * * ii(1) = U2 release
     * * ii(2) = U3 release
     * * ii(3) = R1 release
     * * ii(4) = R2 release
     * * ii(5) = R3 release
     * @param jj These are arrays of six booleans indicating the J-End releases.
     * * jj(0) = U1 release
     * * jj(1) = U2 release
     * * jj(2) = U3 release
     * * jj(3) = R1 release
     * * jj(4) = R2 release
     * * jj(5) = R3 release
     * @param startValue These are arrays of six values indicating the I-End partial fixity springs.
     * * StartValue(0) = U1 partial fixity (F/L)
     * * StartValue(1) = U2 partial fixity (F/L)
     * * StartValue(2) = U3 partial fixity (F/L)
     * * StartValue(3) = R1 partial fixity (FL/rad)
     * * StartValue(4) = R2 partial fixity (FL/rad)
     * * StartValue(5) = R3 partial fixity (FL/rad)
     * @param endValue These are arrays of six values indicating the J-End partial fixity springs.
     * * EndValue(0) = U1 partial fixity (F/L)
     * * EndValue(1) = U2 partial fixity (F/L)
     * * EndValue(2) = U3 partial fixity (F/L)
     * * EndValue(3) = R1 partial fixity (FL/rad)
     * * EndValue(4) = R2 partial fixity (FL/rad)
     * * EndValue(5) = R3 partial fixity (FL/rad)
     * @return zero if the release is successfully defined; otherwise it returns a nonzero value.
     */
    fun setReleases(name: String, ii: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, jj: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, startValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, endValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetReleases", name, ii, jj, startValue, endValue)
}