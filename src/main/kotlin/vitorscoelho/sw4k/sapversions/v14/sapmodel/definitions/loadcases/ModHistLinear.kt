package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ProportionalModalDampingType
import vitorscoelho.sw4k.sapenums.DampingType
import vitorscoelho.sw4k.sapenums.TimeHistoryMotionType

interface ModHistLinearV14 : SapComponent {
    /**
     * This function retrieves the constant modal damping for all modes assigned to the specified load case.
     * @param name The name of an existing linear modal history analysis case that has constant damping.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampConstant(name: String, damp: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetDampConstant", name, damp)

    /**
     * This function retrieves the interpolated modal damping data assigned to the specified load case.
     * @param name The name of an existing linear modal history analysis case that has interpolated damping.
     * @param dampType This is 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency, depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, dampType: AIntByRef = IntByRef.UNNECESSARY, numberItems: AIntByRef = IntByRef.UNNECESSARY, time: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, damp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function retrieves the modal damping overrides assigned to the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, mode: AIntArrayByRef = IntArrayByRef.UNNECESSARY, damp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetDampInterpolated", name, numberItems, mode, damp)

    /**
     * This function retrieves the proportional modal damping data assigned to the specified load case.
     * @param name The name of an existing linear modal history analysis case that has proportional damping.
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
    fun getDampProportional(name: String, dampType: AIntByRef = IntByRef.UNNECESSARY, dampa: ADoubleByRef = DoubleByRef.UNNECESSARY, dampb: ADoubleByRef = DoubleByRef.UNNECESSARY, dampf1: ADoubleByRef = DoubleByRef.UNNECESSARY, dampf2: ADoubleByRef = DoubleByRef.UNNECESSARY, dampd1: ADoubleByRef = DoubleByRef.UNNECESSARY, dampd2: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetDampProportional", name, dampType, dampa, dampb, dampf1, dampf2, dampd1, dampd2)

    /**
     * This function retrieves the modal damping type for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param dampType This is 1, 2, 3, 4, 5 or 6, indicating the modal damping type for the load case ([DampingType] enumeration).
     * * 1 = Mass and stiffness proportional damping by direct specification
     * * 2 = Mass and stiffness proportional damping by period
     * * 3 = Mass and stiffness proportional damping by frequency
     * * 4 = Constant damping for all modes
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @return zero if the type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampType(name: String, dampType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetDampType", name, dampType)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the time history function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. [L/s2] for U1 U2 and U3; otherwise unitless
     * @param tF This is an array that includes the time scale factor of each load assigned to the load case.
     * @param aT This is an array that includes the arrival time of each load assigned to the load case.
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: AIntByRef = IntByRef.UNNECESSARY, loadType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, func: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, tF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, aT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, ang: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function retrieves the modal case assigned to the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param modalCase This is None or the name of an existing modal analysis case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModalCase(name: String, modalCase: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetModalCase", name, modalCase)

    /**
     * This function retrieves the motion type for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param motionType This is 1 or 2, indicating the time history motion type ([TimeHistoryMotionType] enumeration).
     * * 1 = Transient
     * * 2 = Periodic
     * @return zero if the motion type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMotionType(name: String, motionType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetMotionType", name, motionType)

    /**
     * This function retrieves the time step data for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTimeStep(name: String, nstep: AIntByRef = IntByRef.UNNECESSARY, DT: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetTimeStep", name, nstep, DT)

    /**
     * This function initializes a linear modal history analysis case. If this function is called for an existing load case then all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets constant modal damping for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampConstant(name: String, damp: Double): Int =
            callFunctionInt("SetDampConstant", name, damp)

    /**
     * This function sets interpolated modal damping data for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param dampType This is 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency, depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampInterpolated(name: String, dampType: Int, numberItems: Int, time: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, damp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function sets the modal damping overrides for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully set; otherwise it returns a nonzero value.
     */
    fun setDampOverrides(name: String, numberItems: Int, mode: AIntArrayByRef = IntArrayByRef.UNNECESSARY, damp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetDampOverrides", name, numberItems, mode, damp)

    /**
     * This function sets proportional modal damping data for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
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
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing linear modal history analysis case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the time history function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. [L/s2] for U1 U2 and U3; otherwise unitless
     * @param tF This is an array that includes the time scale factor of each load assigned to the load case.
     * @param aT This is an array that includes the arrival time of each load assigned to the load case.
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, func: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, tF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, aT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, ang: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function sets the modal case for the specified analysis case.
     * If the specified modal case is not actually a modal case, the program automatically replaces it with the first modal case it can find. If no modal load cases exist, an error is returned.
     * @param name The name of an existing linear modal history analysis case.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully set; otherwise it returns a nonzero value.
     */
    fun setModalCase(name: String, modalCase: String): Int =
            callFunctionInt("SetModalCase", name, modalCase)

    /**
     * This function sets the motion type for the specified analysis case.
     * @param name The name of an existing linear modal history analysis case.
     * @param motionType This is 1 or 2, indicating the time history motion type ([TimeHistoryMotionType] enumeration).
     * * 1 = Transient
     * * 2 = Periodic
     * @return zero if the motion type is successfully set; otherwise it returns a nonzero value.
     */
    fun setMotionType(name: String, motionType: Int): Int =
            callFunctionInt("SetMotionType", name, motionType)

    /**
     * This function sets the time step data for the specified load case.
     * @param name The name of an existing linear modal history analysis case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setTimeStep(name: String, nstep: Int, DT: Double): Int =
            callFunctionInt("SetTimeStep", name, nstep, DT)
}