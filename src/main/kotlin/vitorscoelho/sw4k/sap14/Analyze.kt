package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.comutils.BooleanArrayByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.enums.SolverType

class Analyze internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cAnalyze"), AnalyzeV14 {
    override fun runAnalysis(): Int = callFunctionInt("RunAnalysis")
    override fun setActiveDOF(DOF: BooleanArrayByRef): Int = callFunctionInt("SetActiveDOF", DOF)

    override fun setRunCaseFlag(name: String, run: Boolean, all: Boolean): Int =
            callFunctionInt("SetRunCaseFlag", name, run, all)

    override fun setSolverOption(solverType: Int, force32BitSolver: Boolean, stiffCase: String): Int =
            callFunctionInt("SetSolverOption", solverType, force32BitSolver, stiffCase)
}

interface AnalyzeV14 {
    /**
     * This function runs the analysis. The analysis model is automatically created as part of this function.
     * IMPORTANT NOTE: Your model must have a file path defined before running the analysis. If the model is opened from an existing file, a file path is defined. If the model is created from scratch, the File.Save function must be called with a file name before running the analysis. Saving the file creates the file path.
     * @return zero if the analysis model is successfully run, otherwise it returns a nonzero value.
     */
    fun runAnalysis(): Int

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
    fun setActiveDOF(DOF: BooleanArrayByRef): Int

    /**
     * This function sets the run flag for load cases.
     * @param name The name of an existing load case that is to have its run flag set.
     * This item is ignored when the All item is True.
     * @param run If this item is True, the specified load case is to be run.
     * @param all If this item is True, the run flag is set as specified by the Run item for all load cases, and the Name item is ignored.
     * @return zero if the flag is successfully set; otherwise it returns a nonzero value.
     */
    fun setRunCaseFlag(name: String, run: Boolean, all: Boolean = false): Int

    /**
     * This function sets the model solver options.
     * @param solverType This is 0 or 1 ([SolverType] enumeration), indicating the solver type.
     * * 0 = Standard solver
     * * 1 = Advanced solver
     * @param force32BitSolver This is True if the analysis is always run using 32-bit, even on 64-bit computers.
     * @param stiffCase The name of the load case used when outputting the mass and stiffness matrices to text files If this item is blank, no matrices are output.
     * @return zero if the options are successfully set; otherwise it returns a nonzero value.
     */
    fun setSolverOption(solverType: Int, force32BitSolver: Boolean, stiffCase: String = ""): Int
}