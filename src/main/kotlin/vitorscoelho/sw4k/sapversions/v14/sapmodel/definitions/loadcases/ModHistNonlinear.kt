package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ProportionalModalDampingType
import vitorscoelho.sw4k.sapenums.DampingType
import vitorscoelho.sw4k.sapenums.LoadType

interface ModHistNonlinearV14 : SapComponent {
    /**
     * This function retrieves the constant modal damping for all modes assigned to the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case that has constant damping.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampConstant(name: String, damp: ADoubleByRef): Int =
            callFunctionInt("GetDampConstant", name, damp)

    /**
     * This function retrieves the interpolated modal damping data assigned to the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case that has interpolated damping.
     * @param dampType This is 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency, depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, dampType: AIntByRef, numberItems: AIntByRef, time: ADoubleArrayByRef, damp: ADoubleArrayByRef): Int =
            callFunctionInt("GetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function retrieves the modal damping overrides assigned to the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, numberItems: AIntByRef, mode: AIntArrayByRef, damp: ADoubleArrayByRef): Int =
            callFunctionInt("GetDampInterpolated", name, numberItems, mode, damp)

    /**
     * This function retrieves the proportional modal damping data assigned to the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case that has proportional damping.
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
    fun getDampProportional(name: String, dampType: AIntByRef, dampa: ADoubleByRef, dampb: ADoubleByRef, dampf1: ADoubleByRef, dampf2: ADoubleByRef, dampd1: ADoubleByRef, dampd2: ADoubleByRef): Int =
            callFunctionInt("GetDampProportional", name, dampType, dampa, dampb, dampf1, dampf2, dampd1, dampd2)

    /**
     * This function retrieves the modal damping type for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param dampType This is 1, 2, 3, 4, 5 or 6, indicating the modal damping type for the load case ([DampingType] enumeration).
     * * 1 = Mass and stiffness proportional damping by direct specification
     * * 2 = Mass and stiffness proportional damping by period
     * * 3 = Mass and stiffness proportional damping by frequency
     * * 4 = Constant damping for all modes
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @return zero if the type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampType(name: String, dampType: AIntByRef): Int =
            callFunctionInt("GetDampType", name, dampType)

    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it continues from the end of another nonlinear modal time history load case.
     * If the specified initial case is not a nonlinear modal time history load case, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: AStringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case ([LoadType] enumeration).
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the time history function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for U1 U2 and U3; otherwise unitless
     * @param tF This is an array that includes the time scale factor of each load assigned to the load case.
     * @param aT This is an array that includes the arrival time of each load assigned to the load case.
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: AIntByRef, loadType: AStringArrayByRef, loadName: AStringArrayByRef, func: AStringArrayByRef, sF: ADoubleArrayByRef, tF: ADoubleArrayByRef, aT: ADoubleArrayByRef, cSys: AStringArrayByRef, ang: ADoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function retrieves the modal case assigned to the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param modalCase This is None or the name of an existing modal analysis case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModalCase(name: String, modalCase: AStringByRef): Int =
            callFunctionInt("GetModalCase", name, modalCase)

    /**
     * This function retrieves the solution control parameters for the specified load case.
     * @param name The name of an existing nonlinear modal time history analysis case.
     * @param tstat The static period.
     * @param dtmax The maximum substep size.
     * @param dtmin The minimum substep size.
     * @param ftol The relative force convergence tolerance.
     * @param etol The relative energy convergence tolerance.
     * @param itmax The maximum iteration limit.
     * @param itmin The minimum iteration limit.
     * @param cf The convergence factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolControlParameters(name: String, tstat: ADoubleByRef, dtmax: ADoubleByRef, dtmin: ADoubleByRef, ftol: ADoubleByRef, etol: ADoubleByRef, itmax: AIntByRef, itmin: AIntByRef, cf: ADoubleByRef): Int =
            callFunctionInt("GetSolControlParameters", name, tstat, dtmax, dtmin, ftol, etol, itmax, itmin, cf)

    /**
     * This function retrieves the time step data for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTimeStep(name: String, nstep: AIntByRef, DT: ADoubleByRef): Int =
            callFunctionInt("GetTimeStep", name, nstep, DT)

    /**
     * This function initializes a nonlinear modal history analysis case. If this function is called for an existing load case, all items for the case are reset to their default values.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets constant modal damping for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param damp The constant damping for all modes (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampConstant(name: String, damp: Double): Int =
            callFunctionInt("SetDampConstant", name, damp)

    /**
     * This function sets interpolated modal damping data for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param dampType This is 5 or 6, indicating the interpolated modal damping type.
     * * 5 = Interpolated damping by period
     * * 6 = Interpolated damping by frequency
     * @param numberItems The number of Time and Damp pairs.
     * @param time This is an array that includes the period or the frequency, depending on the value of the DampType item. (s) for DampType = 5 and (cyc/s) for DampType = 6
     * @param damp This is an array that includes the damping for the specified period of frequency (0 <= Damp < 1).
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampInterpolated(name: String, dampType: Int, numberItems: Int, time: ADoubleArrayByRef, damp: ADoubleArrayByRef): Int =
            callFunctionInt("SetDampInterpolated", name, dampType, numberItems, time, damp)

    /**
     * This function sets the modal damping overrides for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param numberItems The number of Mode and Damp pairs.
     * @param mode This is an array that includes a mode number.
     * @param damp This is an array that includes the damping for the specified mode (0 <= Damp < 1).
     * @return zero if the overrides are successfully set; otherwise it returns a nonzero value.
     */
    fun setDampOverrides(name: String, numberItems: Int, mode: AIntArrayByRef, damp: ADoubleArrayByRef): Int =
            callFunctionInt("SetDampOverrides", name, numberItems, mode, damp)

    /**
     * This function sets proportional modal damping data for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
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
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it continues from the end of another nonlinear modal time history load case.
     * If the specified initial case is not a nonlinear modal time history load case, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case ([LoadType] enumeration).
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the time history function associated with each load.
     * @param SF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for U1 U2 and U3; otherwise unitless
     * @param TF This is an array that includes the time scale factor of each load assigned to the load case.
     * @param AT This is an array that includes the arrival time of each load assigned to the load case.
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: AStringArrayByRef, loadName: AStringArrayByRef, func: AStringArrayByRef, sF: ADoubleArrayByRef, tF: ADoubleArrayByRef, aT: ADoubleArrayByRef, cSys: AStringArrayByRef, ang: ADoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function sets the modal case for the specified analysis case.
     * If the specified modal case is not actually a modal case, the program automatically replaces it with the first modal case it can find. If no modal load cases exist, an error is returned.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully set; otherwise it returns a nonzero value.
     */
    fun setModalCase(name: String, modalCase: String): Int =
            callFunctionInt("SetModalCase", name, modalCase)

    /**
     * This function sets the solution control parameters for the specified load case.
     * @param name The name of an existing nonlinear modal time history analysis case.
     * @param tstat The static period.
     * @param dtmax The maximum substep size.
     * @param dtmin The minimum substep size.
     * @param ftol The relative force convergence tolerance.
     * @param etol The relative energy convergence tolerance.
     * @param itmax The maximum iteration limit.
     * @param itmin The minimum iteration limit.
     * @param cf The convergence factor.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setSolControlParameters(name: String, tstat: Double, dtmax: Double, dtmin: Double, ftol: Double, etol: Double, itmax: Int, itmin: Int, cf: Double): Int =
            callFunctionInt("SetSolControlParameters", name, tstat, dtmax, dtmin, ftol, etol, itmax, itmin, cf)

    /**
     * This function sets the time step data for the specified load case.
     * @param name The name of an existing nonlinear modal history analysis case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setTimeStep(name: String, nstep: Int, DT: Double): Int =
            callFunctionInt("SetTimeStep", name, nstep, DT)
}