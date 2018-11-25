package vitorscoelho.sw4k.sap14.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.LoadType
import vitorscoelho.sw4k.sap14.enums.NLGeomType
import vitorscoelho.sw4k.sap14.enums.HingeUnloadType
import vitorscoelho.sw4k.sap14.enums.LoadControlMethod
import vitorscoelho.sw4k.sap14.enums.ControlDisplacementType
import vitorscoelho.sw4k.sap14.enums.MonitoredDisplacementType

class StaticNonlinear(programName: String) : StaticNonlinearV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonLinear"
}

interface StaticNonlinearV14 : SapComponent {
    /**
     * This function retrieves the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param nLGeomType This is 0, 1 or 2, indicating the geometric nonlinearity option selected for the load case ([NLGeomType] enumeration).
     * * 0 = None
     * * 1 = P-delta
     * * 2 = P-delta plus large displacements
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getGeometricNonlinearity(name: String, nLGeomType: IntByRef): Int =
            callFunctionInt("GetGeometricNonlinearity", name, nLGeomType)

    /**
     * This function retrieves the hinge unloading option for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param unloadType This is 1, 2 or 3, indicating the hinge unloading option selected for the load case ([HingeUnloadType] enumeration).
     * * 1 = Unload entire structure
     * * 2 = Apply local redistribution
     * * 3 = Restart using secant stiffness
     * @return zero if the option is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getHingeUnloading(name: String, unloadType: IntByRef): Int =
            callFunctionInt("GetHingeUnloading", name, unloadType)

    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: StringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load application control parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param loadControl This is either 1 or 2, indicating the load application control method ([LoadControlMethod] enumeration).
     * * 1 = Full load
     * * 2 = Displacement control
     * @param dispType This is either 1 or 2, indicating the control displacement type ([ControlDisplacementType] enumeration).
     * * 1 = Conjugate displacement
     * * 2 = Monitored displacement
     * This item applies only when displacement control is used, that is, LoadControl = 2.
     * @param displ This item applies only when displacement control is used, that is, LoadControl = 2. The structure is loaded to a monitored displacement of this magnitude. (L) when DOF = 1, 2 or 3 and (rad) when DOF = 4, 5 or 6
     * @param monitor This is either 1 or 2, indicating the monitored displacement ([MonitoredDisplacementType] enumeration).
     * * 1 = Displacement at a specified point object
     * * 2 = Generalized displacement
     * @param DOF This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom for which the displacement at a point object is monitored.
     * * 1 = U1
     * * 2 = U2
     * * 3 = U3
     * * 4 = R1
     * * 5 = R2
     * * 6 = R3
     * This item applies only when Monitor = 1.
     * @param pointName The name of the point object at which the displacement is monitored. This item applies only when Monitor = 1.
     * @param gDispl The name of the generalized displacement for which the displacement is monitored. This item applies only when Monitor = 2.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadApplication(name: String, loadControl: IntByRef, dispType: IntByRef, displ: DoubleByRef, monitor: IntByRef, DOF: IntByRef, pointName: StringByRef, gDispl: StringByRef): Int =
            callFunctionInt("GetLoadApplication", name, loadControl, dispType, displ, monitor, DOF, pointName, gDispl)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for Accel UX UY and UZ; otherwise unitless
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: IntByRef, loadType: StringArrayByRef, loadName: StringArrayByRef, sF: DoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, sF)

    /**
     * This function retrieves the modal case assigned to the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param modalCase This is either None or the name of an existing modal analysis case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the modal case is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModalCase(name: String, modalCase: StringByRef): Int =
            callFunctionInt("GetModalCase", name, modalCase)

    /**
     * This function retrieves the results saved parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param saveMultipleSteps This item is True if multiple states are saved for the nonlinear analysis. It is False only if the final state is saved.
     * @param minSavedStates This item applies only when SaveMultipleSteps = True. It is the minimum number of saved steps.
     * @param maxSavedStates This item applies only when SaveMultipleSteps = True. It is the maximum number of saved steps.
     * @param positiveOnly If this item is True, only positive displacement increments are saved. If it is False, all displacement increments are saved.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getResultsSaved(name: String, saveMultipleSteps: BooleanByRef, minSavedStates: IntByRef, maxSavedStates: IntByRef, positiveOnly: BooleanByRef): Int =
            callFunctionInt("GetResultsSaved", name, saveMultipleSteps, minSavedStates, maxSavedStates, positiveOnly)

    /**
     * This function retrieves the solution control parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param maxTotalSteps The maximum total steps per stage.
     * @param maxFailedSubSteps The maximum null (zero) steps per stage.
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
    fun getSolControlParameters(name: String, maxTotalSteps: IntByRef, maxFailedSubSteps: IntByRef, maxIterCS: IntByRef, maxIterNR: IntByRef, tolConvD: DoubleByRef, useEventStepping: BooleanByRef, tolEventD: DoubleByRef, maxLineSearchPerIter: IntByRef, tolLineSearch: DoubleByRef, lineSearchStepFact: DoubleByRef): Int =
            callFunctionInt("GetSolControlParameters", name, maxTotalSteps, maxFailedSubSteps, maxIterCS, maxIterNR, tolConvD, useEventStepping, tolEventD, maxLineSearchPerIter, tolLineSearch, lineSearchStepFact)

    /**
     * This function retrieves the target force iteration parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param tolConvF The relative convergence tolerance for target force iteration.
     * @param maxIter The maximum iterations per stage for target force iteration.
     * @param accelFact The acceleration factor.
     * @param noStop If this item is True, the analysis is continued when there is no convergence in the target force iteration.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTargetForceParameters(name: String, tolConvF: DoubleByRef, maxIter: IntByRef, accelFact: DoubleByRef, noStop: BooleanByRef): Int =
            callFunctionInt("GetTargetForceParameters", name, tolConvF, maxIter, accelFact, noStop)

    /**
     * This function initializes a static nonlinear analysis case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param nLGeomType This is 0, 1 or 2, indicating the geometric nonlinearity option selected for the load case ([NLGeomType] enumeration).
     * * 0 = None
     * * 1 = P-delta
     * * 2 = P-delta plus large displacements
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setGeometricNonlinearity(name: String, nLGeomType: Int): Int =
            callFunctionInt("SetGeometricNonlinearity", name, nLGeomType)

    /**
     * This function sets the hinge unloading option for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param unloadType This is 1, 2 or 3, indicating the hinge unloading option selected for the load case ([HingeUnloadType] enumeration).
     * * 1 = Unload entire structure
     * * 2 = Apply local redistribution
     * * 3 = Restart using secant stiffness
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setHingeUnloading(name: String, unloadType: Int): Int =
            callFunctionInt("SetHingeUnloading", name, unloadType)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load application control parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param loadControl This is either 1 or 2, indicating the load application control method ([LoadControlMethod] enumeration).
     * * 1 = Full load
     * * 2 = Displacement control
     * @param dispType This is either 1 or 2 indicating the control displacement type ([ControlDisplacementType] enumeration).
     * * 1 = Conjugate displacement
     * * 2 = Monitored displacement
     * This item applies only when displacement control is used, that is, LoadControl = 2.
     * @param displ This item applies only when displacement control is used, that is, LoadControl = 2. The structure is loaded to a monitored displacement of this magnitude. (L) when DOF = 1, 2 or 3 and (rad) when DOF = 4, 5 or 6
     * @param monitor This is either 1 or 2, indicating the monitored displacement ([MonitoredDisplacementType] enumeration).
     * * 1 = Displacement at a specified point object
     * * 2 = Generalized displacement
     * @param DOF This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom for which the displacement at a point object is monitored.
     * * 1 = U1
     * * 2 = U2
     * * 3 = U3
     * * 4 = R1
     * * 5 = R2
     * * 6 = R3
     * This item applies only when Monitor = 1.
     * @param pointName The name of the point object at which the displacement is monitored. This item applies only when Monitor = 1.
     * @param gDispl The name of the generalized displacement for which the displacement is monitored. This item applies only when Monitor = 2.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setLoadApplication(name: String, loadControl: Int, dispType: Int, displ: Double, monitor: Int, DOF: Int, pointName: String, gDispl: String): Int =
            callFunctionInt("SetLoadApplication", name, loadControl, dispType, displ, monitor, DOF, pointName, gDispl)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing static nonlinear load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ indicating the direction of the load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for Accel UX UY and UZ; otherwise unitless
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: StringArrayByRef, loadName: StringArrayByRef, sF: DoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, sF)

    /**
     * This function sets the modal case for the specified analysis case.
     * @param name The name of an existing static nonlinear load case.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which any mode-type load assignments to the specified load case are based.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value. If the specified modal case is not actually a modal case, the program automatically replaces it with the first modal case it can find. If no modal load cases exist, an error is returned.
     */
    fun setModalCase(name: String, modalCase: String): Int =
            callFunctionInt("SetModalCase", name, modalCase)

    /**
     * This function sets the results saved parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param saveMultipleSteps This item is True if multiple states are saved for the nonlinear analysis. It is False only if the final state is saved.
     * @param minSavedStates This item only applies when SaveMultipleSteps = True. It is the minimum number of saved steps.
     * @param maxSavedStates This item only applies when SaveMultipleSteps = True. It is the maximum number of saved steps.
     * @param positiveOnly If this item is True, only positive displacement increments are saved. If it is False, all displacement increments are saved.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setResultsSaved(name: String, saveMultipleSteps: Boolean, minSavedStates: Int = 10, maxSavedStates: Int = 100, positiveOnly: Boolean = true): Int =
            callFunctionInt("SetResultsSaved", name, saveMultipleSteps, minSavedStates, maxSavedStates, positiveOnly)

    /**
     * This function sets the solution control parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param maxTotalSteps The maximum total steps per stage.
     * @param maxFailedSubSteps The maximum null (zero) steps per stage.
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
    fun setSolControlParameters(name: String, maxTotalSteps: Int, maxFailedSubSteps: Int, maxIterCS: Int, maxIterNR: Int, tolConvD: Double, useEventStepping: Boolean, tolEventD: Double, maxLineSearchPerIter: Int, tolLineSearch: Double, lineSearchStepFact: Double): Int =
            callFunctionInt("SetSolControlParameters", name, maxTotalSteps, maxFailedSubSteps, maxIterCS, maxIterNR, tolConvD, useEventStepping, tolEventD, maxLineSearchPerIter, tolLineSearch, lineSearchStepFact)

    /**
     * This function sets the target force iteration parameters for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param tolConvF The relative convergence tolerance for target force iteration.
     * @param maxIter The maximum iterations per stage for target force iteration.
     * @param accelFact The acceleration factor.
     * @param noStop If this item is True, the analysis is continued when there is no convergence in the target force iteration.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setTargetForceParameters(name: String, tolConvF: Double, maxIter: Int, accelFact: Double, noStop: Boolean): Int =
            callFunctionInt("SetTargetForceParameters", name, tolConvF, maxIter, accelFact, noStop)
}