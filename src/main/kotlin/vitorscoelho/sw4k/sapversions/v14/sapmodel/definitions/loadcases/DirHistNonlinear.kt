package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ProportionalModalDampingType
import vitorscoelho.sw4k.sapenums.TimeIntegrationType
import vitorscoelho.sw4k.sapenums.NLGeomType
import vitorscoelho.sw4k.sapenums.LoadType

interface DirHistNonlinearV14 : SapComponent {
    /**
     * This function retrieves the proportional modal damping data assigned to the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case that has proportional damping.
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
     * This function retrieves the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param nLGeomType This is 0, 1 or 2, indicating the geometric nonlinearity option selected for the load case ([NLGeomType] enumeration).
     * * 0 = None
     * * 1 = P-delta
     * * 2 = P-delta plus large displacements
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getGeometricNonlinearity(name: String, nLGeomType: AIntByRef): Int =
            callFunctionInt("GetGeometricNonlinearity", name, nLGeomType)

    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else then zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: AStringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case ([LoadType] enumeration).
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
    fun getLoads(name: String, numberLoads: AIntByRef, loadType: AStringArrayByRef, loadName: AStringArrayByRef, func: AStringArrayByRef, sF: ADoubleArrayByRef, tF: ADoubleArrayByRef, aT: ADoubleArrayByRef, cSys: AStringArrayByRef, ang: ADoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function retrieves the solution control parameters for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param dTMax The maximum substep size.
     * @param dTMin The minimum substep size.
     * @param maxIterCS The maximum constant-stiffness iterations per step.
     * @param maxIterNR The maximum Newton_Raphson iterations per step.
     * @param tolConvD The relative iteration convergence tolerance.
     * @param useEventStepping This item is True if event-to-event stepping is used.
     * @param tolEventD The relative event lumping tolerance.
     * @param maxLineSearchPerIter The maximum number of line searches per iteration.
     * @param tolLineSearch The relative line-search acceptance tolerance.
     * @param lineSearchStepFact The line-search step factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolControlParameters(name: String, dTMax: ADoubleByRef, dTMin: ADoubleByRef, maxIterCS: AIntByRef, maxIterNR: AIntByRef, tolConvD: ADoubleByRef, useEventStepping: ABooleanByRef, tolEventD: ADoubleByRef, maxLineSearchPerIter: AIntByRef, tolLineSearch: ADoubleByRef, lineSearchStepFact: ADoubleByRef): Int =
            callFunctionInt("GetSolControlParameters", name, dTMax, dTMin, maxIterCS, maxIterNR, tolConvD, useEventStepping, tolEventD, maxLineSearchPerIter, tolLineSearch, lineSearchStepFact)

    /**
     * This function retrieves the time integration data assigned to the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param integrationType This is 1, 2, 3, 4 or 5; indicating the time integration type ([TimeIntegrationType] enumeration).
     * * 1 = Newmark
     * * 2 = Wilson
     * * 3 = Collocation
     * * 4 = Hilber-Hughes-Taylor
     * * 5 = Chung and Hulbert
     * @param alpha The alpha factor (-1/3 <= Alpha <= 0).
     * This item applies only when IntegrationType = 4 or 5.
     * @param beta The beta factor (Beta >= 0).
     * This item applies only when IntegrationType = 1, 3 or 5. It is returned for informational purposes when IntegrationType = 4.
     * @param gamma The gamma factor (Gamma >= 0.5).
     * This item applies only when IntegrationType = 1, 3 or 5. It is returned for informational purposes when IntegrationType = 4.
     * @param theta The theta factor (Theta > 0).
     * This item applies only when IntegrationType = 2 or 3.
     * @param m The alpha-m factor.
     * This item applies only when IntegrationType = 5.
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTimeIntegration(name: String, integrationType: AIntByRef, alpha: ADoubleByRef, beta: ADoubleByRef, gamma: ADoubleByRef, theta: ADoubleByRef, m: ADoubleByRef): Int =
            callFunctionInt("GetTimeIntegration", name, integrationType, alpha, beta, gamma, theta, m)

    /**
     * This function retrieves the time step data for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTimeStep(name: String, nstep: AIntByRef, DT: ADoubleByRef): Int =
            callFunctionInt("GetTimeStep", name, nstep, DT)

    /**
     * This function initializes a nonlinear direct integration time history load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets proportional modal damping data for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
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
     * This function sets the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param nLGeomType This is 0, 1 or 2, indicating the geometric nonlinearity option selected for the load case ([NLGeomType] enumeration).
     * * 0 = None
     * * 1 = P-delta
     * * 2 = P-delta plus large displacements
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setGeometricNonlinearity(name: String, nLGeomType: Int): Int =
            callFunctionInt("SetGeometricNonlinearity", name, nLGeomType)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load or Accel, indicating the type of each load assigned to the load case ([LoadType] enumeration).
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
    fun setLoads(name: String, numberLoads: Int, loadType: AStringArrayByRef, loadName: AStringArrayByRef, func: AStringArrayByRef, sF: ADoubleArrayByRef, tF: ADoubleArrayByRef, aT: ADoubleArrayByRef, cSys: AStringArrayByRef, ang: ADoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, func, sF, tF, aT, cSys, ang)

    /**
     * This function sets the solution control parameters for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param dTMax The maximum substep size.
     * @param dTMin The minimum substep size.
     * @param maxIterCS The maximum constant-stiffness iterations per step.
     * @param maxIterNR The maximum Newton_Raphson iterations per step.
     * @param tolConvD The relative iteration convergence tolerance.
     * @param useEventStepping This item is True if event-to-event stepping is used.
     * @param tolEventD The relative event lumping tolerance.
     * @param maxLineSearchPerIter The maximum number of line searches per iteration.
     * @param tolLineSearch The relative line-search acceptance tolerance.
     * @param lineSearchStepFact The line-search step factor.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setSolControlParameters(name: String, dTMax: Double, dTMin: Double, maxIterCS: Int, maxIterNR: Int, tolConvD: Double, useEventStepping: Boolean, tolEventD: Double, maxLineSearchPerIter: Int, tolLineSearch: Double, lineSearchStepFact: Double): Int =
            callFunctionInt("SetSolControlParameters", name, dTMax, dTMin, maxIterCS, maxIterNR, tolConvD, useEventStepping, tolEventD, maxLineSearchPerIter, tolLineSearch, lineSearchStepFact)

    /**
     * This function sets time integration data for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param integrationType This is 1, 2, 3, 4 or 5, indicating the time integration type ([TimeIntegrationType] enumeration).
     * * 1 = Newmark
     * * 2 = Wilson
     * * 3 = Collocation
     * * 4 = Hilber-Hughes-Taylor
     * * 5 = Chung and Hulbert
     * @param alpha The alpha factor (-1/3 <= Alpha <= 0).
     * This item applies only when IntegrationType = 4 or 5.
     * @param beta The beta factor (Beta >= 0).
     * This item applies only when IntegrationType = 1, 3 or 5.
     * @param gamma The gamma factor (Gamma >= 0.5).
     * This item applies only when IntegrationType = 1, 3 or 5.
     * @param theta The theta factor (Theta > 0).
     * This item applies only when IntegrationType = 2 or 3.
     * @param m The alpha-m factor.
     * This item applies only when IntegrationType = 5.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setTimeIntegration(name: String, integrationType: Int, alpha: Double, beta: Double, gamma: Double, theta: Double, m: Double = 0.0): Int =
            callFunctionInt("SetTimeIntegration", name, integrationType, alpha, beta, gamma, theta, m)

    /**
     * This function sets the time step data for the specified load case.
     * @param name The name of an existing nonlinear direct integration time history load case.
     * @param nstep The number of output time steps.
     * @param DT The output time step size.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setTimeStep(name: String, nstep: Int, DT: Double): Int =
            callFunctionInt("SetTimeStep", name, nstep, DT)
}