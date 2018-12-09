package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.ProportionalModalDampingType
import vitorscoelho.sw4k.sap.sapmodel.enums.DampingType

interface ResponseSpectrumV14 : SapComponent {
    /**
     * This function retrieves the constant modal damping for all modes assigned to the specified load case.
     * @param name The name of an existing response spectrum load case that has constant damping.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampConstant(name: String, damp: DoubleByRef): Int =
            callFunctionInt("GetDampConstant", name, damp)

    /**
     * This function retrieves the interpolated modal damping data assigned to the specified load case.
     * @param name The name of an existing response spectrum load case that has interpolated damping.
     * @param dampType This is either 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, dampType: IntByRef, numberItems: IntByRef, time: DoubleArrayByRef, damp: DoubleArrayByRef): Int =
            callFunctionInt("GetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function retrieves the modal damping overrides assigned to the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, numberItems: IntByRef, mode: IntArrayByRef, damp: DoubleArrayByRef): Int =
            callFunctionInt("GetDampInterpolated", name, numberItems, mode, damp)

    /**
     * This function retrieves the proportional modal damping data assigned to the specified load case.
     * @param name The name of an existing response spectrum load case that has proportional damping.
     * @param dampType This is 1, 2 or 3, indicating the proportional modal damping type ([ProportionalModalDampingType] enumeration).
     * * 1 = Mass and stiffness proportional damping by direct specification
     * * 2 = Mass and stiffness proportional damping by period
     * * 3 = Mass and stiffness proportional damping by frequency
     * @param dampa The mass proportional damping coefficient.
     * @param dampb The stiffness proportional damping coefficient.
     * @param dampf1 This is the period or the frequency (depending on the value of the DampType item) for point 1. (s) for DampType = 2 and (cyc/s) for DampType = 3
     * This item applies only when DampType = 2 or 3.
     * @param dampf2 This is the period or the frequency (depending on the value of the DampType item) for point 2. (s) for DampType = 2 and (cyc/s) for DampType = 3
     * This item applies only when DampType = 2 or 3.
     * @param dampd1 This is the damping at point 1 (0 <= Dampd1 < 1).
     * This item applies only when DampType = 2 or 3.
     * @param dampd2 This is the damping at point 2 (0 <= Dampd2 < 1).
     * This item applies only when DampType = 2 or 3.
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampProportional(name: String, dampType: IntByRef, dampa: DoubleByRef, dampb: DoubleByRef, dampf1: DoubleByRef, dampf2: DoubleByRef, dampd1: DoubleByRef, dampd2: DoubleByRef): Int =
            callFunctionInt("GetDampProportional", name, dampType, dampa, dampb, dampf1, dampf2, dampd1, dampd2)

    /**
     * This function retrieves the modal damping type for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param dampType This is 1, 2, 3, 4, 5 or 6, indicating the modal damping type for the load case ([DampingType] enumeration).
     * * 1 = Mass and stiffness proportional damping by direct specification
     * * 2 = Mass and stiffness proportional damping by period
     * * 3 = Mass and stiffness proportional damping by frequency
     * * 4 = Constant damping for all modes
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @return zero if the type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampType(name: String, dampType: IntByRef): Int =
            callFunctionInt("GetDampType", name, dampType)

    /**
     * This function retrieves the diaphragm eccentricity overrides for a response spectrum load case.
     * @param name The name of an existing response spectrum load case.
     * @param num The number of diaphragm eccentricity overrides for the specified load case.
     * @param diaph This is an array that includes the names of the diaphragms that have eccentricity overrides.
     * @param eccen This is an array that includes the eccentricity applied to each diaphragm. (L)
     * @return zero if the overrides are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDiaphragmEccentricityOverride(name: String, num: IntByRef, diaph: StringArrayByRef, eccen: DoubleArrayByRef): Int =
            callFunctionInt("GetDiaphragmEccentricityOverride", name, num, diaph, eccen)

    /**
     * This function retrieves the directional combination option assigned to the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param myType This is 1or 2, indicating the directional combination option.
     * * 1 = SRSS
     * * 2 = ABS
     * @param SF This item applies only when MyType = 2. It is the ABS scale factor.
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDirComb(name: String, myType: IntByRef, SF: DoubleByRef): Int =
            callFunctionInt("GetDirComb", name, myType, SF)

    /**
     * This function retrieves the eccentricity ratio that applies to all diaphragms for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @return zero if the ratio is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEccentricity(name: String, eccen: DoubleByRef): Int =
            callFunctionInt("GetEccentricity", name, eccen)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadName This is an array that includes U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the response spectrum function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. [L/s2] for U1 U2 and U3; otherwise unitless
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: IntByRef, loadName: StringArrayByRef, func: StringArrayByRef, sF: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadName, func, sF, cSys, ang)

    /**
     * This function retrieves the modal case assigned to the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param modalCase This is None or the name of an existing modal analysis case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModalCase(name: String, modalCase: StringByRef): Int =
            callFunctionInt("GetModalCase", name, modalCase)

    /**
     * This function retrieves the modal combination option assigned to the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param myType This is 1, 2, 3, 4, 5 or 6, indicating the modal combination option.
     * @param f1 The GMC f1 factor. This item does not apply when MyType = 3. (cyc/s)
     * @param f2 The GMC f2 factor. This item does not apply when MyType = 3. (cyc/s)
     * @param periodicRigidCombType This is 1 or 2, indicating the periodic plus rigid modal combination option.
     * @param td This item applies only when MyType = 6. It is the factor td. (s)
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModalComb_1(name: String, myType: IntByRef, f1: DoubleByRef, f2: DoubleByRef, periodicRigidCombType: IntByRef, td: DoubleByRef): Int =
            callFunctionInt("GetModalComb_1", name, myType, f1, f2, periodicRigidCombType, td)

    /**
     * This function initializes a response spectrum analysis case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets constant modal damping for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampConstant(name: String, damp: Double): Int =
            callFunctionInt("SetDampConstant", name, damp)

    /**
     * This function sets interpolated modal damping data for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param dampType This is either 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampInterpolated(name: String, dampType: Int, numberItems: Int, time: DoubleArrayByRef, damp: DoubleArrayByRef): Int =
            callFunctionInt("SetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function sets the modal damping overrides for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully set; otherwise it returns a nonzero value.
     */
    fun setDampOverrides(name: String, numberItems: Int, mode: IntArrayByRef, damp: DoubleArrayByRef): Int =
            callFunctionInt("SetDampOverrides", name, numberItems, mode, damp)

    /**
     * This function sets proportional modal damping data for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param dampType This is 1, 2 or 3, indicating the proportional modal damping type ([ProportionalModalDampingType] enumeration).
     * * 1 = Mass and stiffness proportional damping by direct specification
     * * 2 = Mass and stiffness proportional damping by period
     * * 3 = Mass and stiffness proportional damping by frequency
     * @param dampa The mass proportional damping coefficient. This item applies only when DampType = 1.
     * @param dampb The stiffness proportional damping coefficient. This item applies only when DampType = 1.
     * @param dampf1 This is the period or the frequency (depending on the value of the DampType item) for point 1. (s) for DampType = 2 and (cyc/s) for DampType = 3
     * This item applies only when DampType = 2 or 3.
     * @param dampf2 This is the period or the frequency (depending on the value of the DampType item) for point 2. (s) for DampType = 2 and (cyc/s) for DampType = 3
     * This item applies only when DampType = 2 or 3.
     * @param dampd1 This is the damping at point 1 (0 <= Dampd1 < 1).
     * This item applies only when DampType = 2 or 3.
     * @param dampd2 This is the damping at point 2 (0 <= Dampd2 < 1).
     * This item applies only when DampType = 2 or 3.
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampProportional(name: String, dampType: Int, dampa: Double, dampb: Double, dampf1: Double, dampf2: Double, dampd1: Double, dampd2: Double): Int =
            callFunctionInt("SetDampProportional", name, dampType, dampa, dampb, dampf1, dampf2, dampd1, dampd2)

    /**
     * This function assigns diaphragm eccentricity overrides for response spectrum load cases.
     * @param name The name of an existing response spectrum load case.
     * @param diaph The name of an existing special rigid diaphragm constraint, that is, a diaphragm constraint with the following features:
     * * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * * 2. The constraint coordinate system is Global.
     * * 3. The constraint axis is Z.
     * @param eccen The eccentricity applied to the specified diaphragm. (L)
     * @param delete If this item is True, the eccentricity override for the specified diaphragm is deleted.
     * @return zero if the overrides are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setDiaphragmEccentricityOverride(name: String, diaph: String, eccen: Double, delete: Boolean = false): Int =
            callFunctionInt("SetDiaphragmEccentricityOverride", name, diaph, eccen, delete)

    /**
     * This function sets the directional combination option for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param myType This is 1 o 2, indicating the directional combination option.
     * * 1 = SRSS
     * * 2 = ABS
     * @param SF This item applies only when MyType = 2. It is the ABS scale factor.
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setDirComb(name: String, myType: Int, SF: Double): Int =
            callFunctionInt("SetDirComb", name, myType, SF)

    /**
     * This function sets the eccentricity ratio that applies to all diaphragms for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @return zero if the ratio is successfully set; otherwise it returns a nonzero value.
     */
    fun setEccentricity(name: String, eccen: Double): Int =
            callFunctionInt("SetEccentricity", name, eccen)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing response spectrum load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadName This is an array that includes U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the response spectrum function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. [L/s2] for U1 U2 and U3; otherwise unitless
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadName: StringArrayByRef, func: StringArrayByRef, sF: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadName, func, sF, cSys, ang)

    /**
     * This function sets the modal case for the specified analysis case.
     * @param name The name of an existing response spectrum load case.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value. If the specified modal case is not actually a modal case, the program automatically replaces it with the first modal case it can find. If no modal load cases exist, an error is returned.
     */
    fun setModalCase(name: String, modalCase: String): Int =
            callFunctionInt("SetModalCase", name, modalCase)

    /**
     * This function sets the modal combination option for the specified load case.
     * @param name The name of an existing response spectrum load case.
     * @param myType This is 1, 2, 3, 4, 5 or 6, indicating the modal combination option.
     * @param f1 The GMC f1 factor. This item does not apply when MyType = 3. (cyc/s)
     * @param f2 The GMC f2 factor. This item does not apply when MyType = 3. (cyc/s)
     * @param periodicRigidCombType This is 1 or 2, indicating the periodic plus rigid modal combination option.
     * @param td This item applies only when MyType = 6. It is the factor td. (s)
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setModalComb_1(name: String, myType: Int, f1: Double = 1.0, f2: Double = 0.0, periodicRigidCombType: Int = 1, td: Double = 60.0): Int =
            callFunctionInt("SetModalComb_1", name, myType, f1, f2, periodicRigidCombType, td)
}