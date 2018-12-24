package vitorscoelho.sw4k.sapversions.v14.sapmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.SolverType
import vitorscoelho.sw4k.sapenums.LoadCaseStatus

interface AnalyzeV14 : SapComponent {
    /**
     * This function creates the analysis model. If the analysis model is already created and current, nothing is done.
     * It is not necessary to call this function before running an analysis. The analysis model is automatically created, if necessary, when the model is run.
     * @return zero if the analysis model is successfully created or it already exists and is current, otherwise it returns a nonzero value.
     */
    fun createAnalysisModel(): Int = callFunctionInt("CreateAnalysisModel")

    /**
     * This function deletes results for load cases.
     * @param name The name of an existing load case that is to have its results deleted.
     * This item is ignored when the [all] is True.
     * @param all If this item is True, the results are deleted for all load cases, and the Name item is ignored.
     * @return zero if the results are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteResults(name: String, all: Boolean = false): Int = callFunctionInt("DeleteResults", name, all)

    /**
     * This function retrieves the model global degrees of freedom.
     * @param DOF This is an array of 6 boolean values, indicating if the specified model global degree of freedom is active.
     * * DOF(0) = UX
     * * DOF(1) = UY
     * * DOF(2) = UZ
     * * DOF(3) = RX
     * * DOF(4) = RY
     * * DOF(5) = RZ
     * @return zero if the degrees of freedom are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getActiveDOF(DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY): Int = callFunctionInt("GetActiveDOF", DOF)

    /**
     * This function retrieves the status for all load cases.
     * @param numberItems The number of load cases for which the status is reported.
     * @param caseName This is an array that includes the name of each analysis case for which the status is reported.
     * @param status This is an array of that includes 1, 2, 3 or 4, indicating the load case status ([LoadCaseStatus] enumeration)
     * * 1 = Not run
     * * 2 = Could not start
     * * 3 = Not finished
     * * 4 = Finished
     * @return zero if the status is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCaseStatus(numberItems: AIntByRef = IntByRef.UNNECESSARY, caseName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, status: AIntArrayByRef = IntArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetCaseStatus", numberItems, caseName, status)

    /**
     * This function retrieves the run flags for all analysis cases.
     * @param numberItems The number of load cases for which the run flag is reported.
     * @param caseName This is an array that includes the name of each analysis case for which the run flag is reported.
     * @param run This is an array of boolean values indicating if the specified load case is to be run.
     * @return zero if the flags are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRunCaseFlag(numberItems: AIntByRef = IntByRef.UNNECESSARY, caseName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, run: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetRunCaseFlag", numberItems, caseName, run)

    /**
     * This function retrieves the model solver options.
     * @param solverType This is 0 or 1, indicating the solver type ([SolverType] enumeration).
     * * 0 = Standard solver
     * * 1 = Advanced solver
     * @param force32BitSolver This is True if the analysis is always run using 32-bit, even on 64-bit computers.
     * @param stiffCase The name of the load case used when outputting the mass and stiffness matrices to text files If this item is blank, no matrices are output.
     * @return zero if the options are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolverOption(solverType: AIntByRef = IntByRef.UNNECESSARY, force32BitSolver: ABooleanByRef = BooleanByRef.UNNECESSARY, stiffCase: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetSolverOption", solverType, force32BitSolver, stiffCase)

    /**
     * This function modifies the undeformed geometry based on displacements obtained from a specified load case.
     * @param caseName The name of the static load case from which displacements are obtained.
     * @param SF The scale factor applied to the displacements.
     * @param stage This item applies only when the specified load case is a staged construction load case. It is the stage number from which the displacements are obtained. Specifying a -1 for this item means to use the last run stage.
     * @param original If this item is True, all other input items in this function are ignored and the original undeformed geometry data is reinstated.
     * @return zero if it is successful; otherwise it returns a nonzero value.
     */
    fun modifyUnDeformedGeometry(caseName: String, SF: Double, stage: Int = -1, original: Boolean = false): Int =
            callFunctionInt("ModifyUnDeformedGeometry", caseName, SF, stage, original)

    /**
     * This function runs the analysis. The analysis model is automatically created as part of this function.
     * IMPORTANT NOTE: Your model must have a file path defined before running the analysis. If the model is opened from an existing file, a file path is defined. If the model is created from scratch, the File.Save function must be called with a file name before running the analysis. Saving the file creates the file path.
     * @return zero if the analysis model is successfully run, otherwise it returns a nonzero value.
     */
    fun runAnalysis(): Int = callFunctionInt("RunAnalysis")

    /**
     * This function sets the model global degrees of freedom.
     * @param DOF This is an array of 6 boolean values, indicating if the specified model global degree of freedom is active.
     * * DOF(0) = UX
     * * DOF(1) = UY
     * * DOF(2) = UZ
     * * DOF(3) = RX
     * * DOF(4) = RY
     * * DOF(5) = RZ
     * @return zero if the degrees of freedom are successfully set; otherwise it returns a nonzero value.
     */
    fun setActiveDOF(DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY): Int = callFunctionInt("SetActiveDOF", DOF)

    /**
     * This function sets the run flag for load cases.
     * @param name The name of an existing load case that is to have its run flag set.
     * This item is ignored when the All item is True.
     * @param run If this item is True, the specified load case is to be run.
     * @param all If this item is True, the run flag is set as specified by the Run item for all load cases, and the Name item is ignored.
     * @return zero if the flag is successfully set; otherwise it returns a nonzero value.
     */
    fun setRunCaseFlag(name: String, run: Boolean, all: Boolean = false): Int =
            callFunctionInt("SetRunCaseFlag", name, run, all)

    /**
     * This function sets the model solver options.
     * @param solverType This is 0 or 1 ([SolverType] enumeration), indicating the solver type.
     * * 0 = Standard solver
     * * 1 = Advanced solver
     * @param force32BitSolver This is True if the analysis is always run using 32-bit, even on 64-bit computers.
     * @param stiffCase The name of the load case used when outputting the mass and stiffness matrices to text files If this item is blank, no matrices are output.
     * @return zero if the options are successfully set; otherwise it returns a nonzero value.
     */
    fun setSolverOption(solverType: Int, force32BitSolver: Boolean, stiffCase: String = ""): Int =
            callFunctionInt("SetSolverOption", solverType, force32BitSolver, stiffCase)
}