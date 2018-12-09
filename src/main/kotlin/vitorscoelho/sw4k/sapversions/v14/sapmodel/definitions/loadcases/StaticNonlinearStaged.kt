package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.NLGeomType
import vitorscoelho.sw4k.sap.sapmodel.enums.HingeUnloadType
import vitorscoelho.sw4k.sap.sapmodel.enums.StagedSaveType

interface StaticNonlinearStagedV14 : SapComponent {
    /**
     * This function retrieves the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
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
     * @param name The name of an existing static nonlinear staged analysis case.
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
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: StringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the material nonlinearity options for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param timeDepMatProp When this is True, any specified time dependent material properties are considered in the analysis.
     * @return zero if the options are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterialNonlinearity(name: String, timeDepMatProp: BooleanByRef): Int =
            callFunctionInt("GetMaterialNonlinearity", name, timeDepMatProp)

    /**
     * This function retrieves the results saved parameters for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param stagedSaveOption This is 0, 1, 2 or 3, indicating the results saved option for the load case ([StagedSaveType] enumeration).
     * * 0 = End of final stage
     * * 1 = End of each stage
     * * 2 = Start and end of each stage
     * * 3 = Two or more times in each stage
     * @param stagedMinSteps The minimum number of steps for application of instantaneous load. This item applies only when StagedSaveOption = 3.
     * @param stagedMinStepsTD The minimum number of steps for analysis of time dependent items. This item applies only when StagedSaveOption = 3.
     * @return zero if the parameters are retrieved successfully; otherwise it returns a nonzero value.
     */
    fun getResultsSaved(name: String, stagedSaveOption: IntByRef, stagedMinSteps: IntByRef, stagedMinStepsTD: IntByRef): Int =
            callFunctionInt("GetResultsSaved", name, stagedSaveOption, stagedMinSteps, stagedMinStepsTD)

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
     * This function retrieves stage data for the specified stage in the specified load case.
     * @param name The name of an existing static nonlinear staged load case.
     * @param stage The stage in the specified load case for which data is requested. Stages are numbered sequentially starting from 1.
     * @param numberOperations The number of operations in the specified stage.
     * @param operation This is an array that includes 1, 2, 3, 4, 5, 6 or 7, indicating an operation type.
     * * 1 = Add structure
     * * 2 = Remove structure
     * * 3 = Load objects if new
     * * 4 = Load objects
     * * 5 = Change section properties
     * * 6 = Change section property modifiers
     * * 7 = Change releases
     * @param objectType This is an array that includes the object type associated with the specified operation. The object type may be one of the following:
     * * Group
     * * Frame
     * * Cable
     * * Tendon
     * * Area
     * * Solid
     * * Link
     * * Point
     * The following list shows which object types are applicable to each operation type:
     * * Operation = 1 (Add structure): All object types
     * * Operation = 2 (Remove structure): All object types
     * * Operation = 3 (Load objects if new): All object types
     * * Operation = 4 (Load objects): All object types
     * * Operation = 5 (Change section properties): All object types except Point
     * * Operation = 6 (Change section property modifiers): Group, Frame, Cable, Area
     * * Operation = 7 (Change releases): Group, Frame
     * @param objectName This is an array that includes the name of the object associated with the specified operation. This is the name of a Group, Frame object, Cable object, Tendon object, Area object, Solid object, Link object or Point object, depending on the ObjectType item.
     * @param age This is an array that includes the age of the added structure, at the time it is added, in days. This item applies only to operations with Operation = 1.
     * @param myType This is an array that includes a load type or an object type, depending on what is specified for the Operation item. This item applies only to operations with Operation = 3, 4, 5, 6 or 7.
     * When Operation = 3 or 4, this is an array that includes Load or Accel, indicating the load type of an added load.
     * When Operation = 5 and the ObjectType item is Group, this is an array that includes Frame, Cable, Tendon, Area, Solid or Link, indicating the object type for which the section property is changed.
     * When Operation = 6 and the ObjectType item is Group, this is an array that includes Frame, Cable or Area, indicating the object type for which the section property modifiers are changed.
     * When Operation = 7 and the ObjectType item is Group, this is an array that includes Frame, indicating the object type for which the releases are changed.
     * When Operation = 5, 6 or 7 and the ObjectType item is not Group and not Point, this item is ignored and the type is picked up from the ObjectType item.
     * @param myName This is an array that includes a load assignment or an object name, depending on what is specified for the Operation item. This item applies only to operations with Operation = 3, 4, 5, 6 or 7.
     * When Operation = 3 or 4, this is an array that includes the name of the load assigned to the operation. If the associated LoadType item is Load, this item is the name of a defined load pattern. If the associated LoadType item is Accel , this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * When Operation = 5, this is the name of a Frame, Cable, Tendon, Area, Solid or Link object, depending on the object type specified.
     * When Operation = 6, this is the name of a Frame, Cable or Area object, depending on the object type specified.
     * When Operation = 7, this is the name of a Frame object.
     * @param SF This is an array that includes the scale factor for the load assigned to the operation, if any. [L/s2] for Accel UX UY and UZ; otherwise unitless
     * This item applies only to operations with Operation = 3 or 4.
     * @return zero if the data is successfully retrieved; otherwise, it returns a nonzero value.
     */
    fun getStageData_1(name: String, stage: Int, numberOperations: IntByRef, operation: IntArrayByRef, objectType: StringArrayByRef, objectName: StringArrayByRef, age: IntArrayByRef, myType: StringArrayByRef, myName: StringArrayByRef, sF: DoubleArrayByRef): Int =
            callFunctionInt("GetStageData_1", name, stage, numberOperations, operation, objectType, objectName, age, myType, myName, sF)

    /**
     * This function retrieves the stage definition data for the specified load case.
     * @param name The name of an existing static nonlinear staged load case.
     * @param numberStages The number of stages defined for the specified load case.
     * @param duration This is an array that includes the duration in days for each stage.
     * @param output This is an array that includes True or False, indicating if analysis output is to be saved for each stage.
     * @param outputName This is an array that includes a user-specified output name for each stage.
     * @param comment This is an array that includes a comment for each stage. The comment may be a blank string.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getStageDefinitions_1(name: String, numberStages: IntByRef, duration: IntArrayByRef, output: BooleanArrayByRef, outputName: StringArrayByRef, comment: StringArrayByRef): Int =
            callFunctionInt("GetStageDefinitions_1", name, numberStages, duration, output, outputName, comment)

    /**
     * This function retrieves the target force iteration parameters for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param tolConvF The relative convergence tolerance for target force iteration.
     * @param maxIter The maximum iterations per stage for target force iteration.
     * @param accelFact The acceleration factor.
     * @param noStop If this item is True, the analysis is continued when there is no convergence in the target force iteration.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTargetForceParameters(name: String, tolConvF: DoubleByRef, maxIter: IntByRef, accelFact: DoubleByRef, noStop: BooleanByRef): Int =
            callFunctionInt("GetTargetForceParameters", name, tolConvF, maxIter, accelFact, noStop)

    /**
     * This function initializes a static nonlinear staged analysis case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified, otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
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
     * @param name The name of an existing static nonlinear staged analysis case.
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
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts from the state at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the state at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the material nonlinearity options for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param timeDepMatProp When this is True, any specified time dependent material properties are considered in the analysis.
     * @return zero if the options are successfully set; otherwise it returns a nonzero value.
     */
    fun setMaterialNonlinearity(name: String, timeDepMatProp: Boolean): Int =
            callFunctionInt("SetMaterialNonlinearity", name, timeDepMatProp)

    /**
     * This function sets the results saved parameters for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param stagedSaveOption This is 0, 1, 2 or 3, indicating the results saved option for the load case ([StagedSaveType] enumeration).
     * * 0 = End of final stage
     * * 1 = End of each stage
     * * 2 = Start and end of each stage
     * * 3 = Two or more times in each stage
     * @param stagedMinSteps The minimum number of steps for application of instantaneous load. This item applies only when StagedSaveOption = 3.
     * @param stagedMinStepsTD The minimum number of steps for analysis of time dependent items. This item applies only when StagedSaveOption = 3.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setResultsSaved(name: String, stagedSaveOption: Int, stagedMinSteps: Int = 1, stagedMinStepsTD: Int = 1): Int =
            callFunctionInt("SetResultsSaved", name, stagedSaveOption, stagedMinSteps, stagedMinStepsTD)

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
     * This function sets the stage data for the specified stage in the specified load case. All previous stage data for the specified stage is cleared when this function is called.
     * @param name The name of an existing static nonlinear staged load case.
     * @param stage The stage in the specified load case to which the data applies. Stages are numbered sequentially starting from 1.
     * @param numberOperations The number of operations in the specified stage.
     * @param operation This is an array that includes 1, 2, 3, 4, 5, 6 or 7, indicating an operation type.
     * * 1 = Add structure
     * * 2 = Remove structure
     * * 3 = Load objects if new
     * * 4 = Load objects
     * * 5 = Change section properties
     * * 6 = Change section property modifiers
     * * 7 = Change releases
     * @param objectType This is an array that includes the object type associated with the specified operation. The object type may be one of the following:
     * * Group
     * * Frame
     * * Cable
     * * Tendon
     * * Area
     * * Solid
     * * Link
     * * Point
     * The following list shows which object types are applicable to each operation type:
     * * Operation = 1 (Add structure): All object types
     * * Operation = 2 (Remove structure): All object types
     * * Operation = 3 (Load objects if new): All object types
     * * Operation = 4 (Load objects): All object types
     * * Operation = 5 (Change section properties): All object types except Point
     * * Operation = 6 (Change section property modifiers): Group, Frame, Cable, Area
     * * Operation = 7 (Change releases): Group, Frame
     * @param objectName This is an array that includes the name of the object associated with the specified operation. This is the name of a Group, Frame object, Cable object, Tendon object, Area object, Solid object, Link object or Point object, depending on the ObjectType item.
     * @param age This is an array that includes the age of the added structure, at the time it is added, in days. This item applies only to operations with Operation = 1.
     * @param myType This is an array that includes a load type or an object type, depending on what is specified for the Operation item. This item applies only to operations with Operation = 3, 4, 5, 6 or 7.
     * When Operation = 3 or 4, this is an array that includes Load or Accel, indicating the load type of an added load.
     * When Operation = 5 and the ObjectType item is Group, this is an array that includes Frame, Cable, Tendon, Area, Solid or Link, indicating the object type for which the section property is changed.
     * When Operation = 6 and the ObjectType item is Group, this is an array that includes Frame, Cable or Area, indicating the object type for which the section property modifiers are changed.
     * When Operation = 7 and the ObjectType item is Group, this is an array that includes Frame, indicating the object type for which the releases are changed.
     * When Operation = 5, 6 or 7 and the ObjectType item is not Group and not Point, this item is ignored and the type is picked up from the ObjectType item.
     * @param myName This is an array that includes a load assignment or an object name, depending on what is specified for the Operation item. This item applies only to operations with Operation = 3, 4, 5, 6 or 7.
     * When Operation = 3 or 4, this is an array that includes the name of the load assigned to the operation. If the associated LoadType item is Load, this item is the name of a defined load pattern. If the associated LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * When Operation = 5, this is the name of a Frame, Cable, Tendon, Area, Solid or Link object, depending on the object type specified.
     * When Operation = 6, this is the name of a Frame, Cable or Area object, depending on the object type specified.
     * When Operation = 7, this is the name of a Frame object.
     * @param SF This is an array that includes the scale factor for the load assigned to the operation, if any. [L/s2] for Accel UX UY and UZ; otherwise unitless
     * This item applies only to operations with Operation = 3 or 4.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setStageData_1(name: String, stage: Int, numberOperations: Int, operation: IntArrayByRef, objectType: StringArrayByRef, objectName: StringArrayByRef, age: IntArrayByRef, myType: StringArrayByRef, myName: StringArrayByRef, sF: DoubleArrayByRef): Int =
            callFunctionInt("SetStageData_1", name, stage, numberOperations, operation, objectType, objectName, age, myType, myName, sF)

    /**
     * This function initializes the stage definition data for the specified load case. All previous stage definition data for the case is cleared when this function is called.
     * @param name The name of an existing static nonlinear staged load case.
     * @param numberStages The number of stages defined for the specified load case.
     * @param duration This is an array that includes the duration in days for each stage.
     * @param output This is an array that includes True or False, indicating if analysis output is to be saved for each stage.
     * @param outputName This is an array that includes a user-specified output name for each stage.
     * @param comment This is an array that includes a comment for each stage. The comment may be a blank string.
     * @return zero if the data is successfully initialized; otherwise, it returns a nonzero value.
     */
    fun setStageDefinitions_1(name: String, numberStages: Int, duration: IntArrayByRef, output: BooleanArrayByRef, outputName: StringArrayByRef, comment: StringArrayByRef): Int =
            callFunctionInt("SetStageDefinitions_1", name, numberStages, duration, output, outputName, comment)

    /**
     * This function sets the target force iteration parameters for the specified load case.
     * @param name The name of an existing static nonlinear staged analysis case.
     * @param tolConvF The relative convergence tolerance for target force iteration.
     * @param maxIter The maximum iterations per stage for target force iteration.
     * @param accelFact The acceleration factor.
     * @param noStop If this item is True, the analysis is continued when there is no convergence in the target force iteration.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setTargetForceParameters(name: String, tolConvF: Double, maxIter: Int, accelFact: Double, noStop: Boolean): Int =
            callFunctionInt("SetTargetForceParameters", name, tolConvF, maxIter, accelFact, noStop)
}