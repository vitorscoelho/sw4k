package vitorscoelho.sw4k.sap14.analysisresults

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.ItemTypeElm

class Results(val sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cAnalysisResults") {
    val setup = Setup(this.sapModel)

    /**
     * This function reports the structure total base reactions.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param fx These are one dimensional arrays that include the base reaction forces in the global X direction for each result. (F)
     * @param fy These are one dimensional arrays that include the base reaction forces in the global Y direction for each result. (F)
     * @param fz These are one dimensional arrays that include the base reaction forces in the global Z direction for each result. (F)
     * @param mx These are one dimensional arrays that include the base reaction moments about the global X axis for each result. (FL)
     * @param my These are one dimensional arrays that include the base reaction moments about the global Y axis for each result. (FL)
     * @param mz These are one dimensional arrays that include the base reaction moments about the global Z axis for each result. (FL)
     * @param gx This is the global X coordinate of the point at which the base reactions are reported. (L)
     * @param gy This is the global Y coordinate of the point at which the base reactions are reported. (L)
     * @param gz This is the global Z coordinate of the point at which the base reactions are reported. (L)
     * @return zero if the reactions are successfully recovered, otherwise it returns a nonzero value.
     */
    fun baseReact(numberResults: IntByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, fx: DoubleArrayByRef, fy: DoubleArrayByRef, fz: DoubleArrayByRef, mx: DoubleArrayByRef, my: DoubleArrayByRef, mz: DoubleArrayByRef, gx: DoubleByRef, gy: DoubleByRef, gz: DoubleByRef): Int =
            callFunctionInt("BaseReact", numberResults, loadCase, stepType, stepNum, fx, fy, fz, mx, my, mz, gx, gy, gz)

    /**
     * This function reports the frame forces for the specified line elements.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing line object, line element or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the result request is for the line element specified by the Name item.
     * If this item is GroupElm, the result request is for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for line elements corresponding to all selected line objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the line object name associated with each result, if any.
     * @param objSta This is an array that includes the distance measured from the I-end of the line object to the result location.
     * @param elm This is an array that includes the line element name associated with each result.
     * @param elmSta This is an array that includes the distance measured from the I-end of the line element to the result location.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param p These are one dimensional arrays that include the axial force for each result. (F)
     * @param v2 These are one dimensional arrays that include the shear force in the local 2 direction for each result. (F)
     * @param v3 These are one dimensional arrays that include the shear force in the local 3 direction  for each result. (F)
     * @param t These are one dimensional arrays that include the torsion for each result. (FL)
     * @param m2 These are one dimensional arrays that include the moment about the local 2axis for each result. (FL)
     * @param m3 These are one dimensional arrays that include the moment about the local 3-axis for each result. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun frameForce(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, objSta: DoubleArrayByRef, elm: StringArrayByRef, elmSta: DoubleArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, p: DoubleArrayByRef, v2: DoubleArrayByRef, v3: DoubleArrayByRef, t: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef): Int =
            callFunctionInt("FrameForce", name, itemTypeElm, numberResults, obj, objSta, elm, elmSta, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)

    /**
     * This function reports the frame joint forces for the point elements at each end of the specified line elements.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing line object, line element or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the result request is for the line element specified by the Name item.
     * If this item is GroupElm, the result request is for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for line elements corresponding to all selected line objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the line object name associated with each result, if any.
     * @param elm This is an array that includes the line element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param f1 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param f2 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param f3 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param m1 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @param m2 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @param m3 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun frameJointForce(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, elm: StringArrayByRef, pointElm: StringArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, f1: DoubleArrayByRef, f2: DoubleArrayByRef, f3: DoubleArrayByRef, m1: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef): Int =
            callFunctionInt("FrameJointForce", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the joint displacements for the specified point elements. The displacements reported by this function are relative displacements.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * See Item Type for Elements for more information.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For these cases this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param u1 These are one dimensional arrays that include the displacement in the point element local 1 axis direction for each result. (L)
     * @param u2 These are one dimensional arrays that include the displacement in the point element local 2 axis direction for each result. (L)
     * @param u3 These are one dimensional arrays that include the displacement in the point element local 3 axis direction for each result. (L)
     * @param r1 These are one dimensional arrays that include the rotation about the point element local 1 axis for each result. (rad)
     * @param r2 These are one dimensional arrays that include the rotation about the point element local 2 axis for each result. (rad)
     * @param r3 These are one dimensional arrays that include the rotation about the point element local 3 axis for each result. (rad)
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointDispl(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, elm: StringArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, u1: DoubleArrayByRef, u2: DoubleArrayByRef, u3: DoubleArrayByRef, r1: DoubleArrayByRef, r2: DoubleArrayByRef, r3: DoubleArrayByRef): Int =
            callFunctionInt("JointDispl", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the absolute joint displacements for the specified point elements. Absolute and relative displacements are the same except when reported for time history load cases subjected to acceleration loading.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * See Item Type for Elements for more information.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param u1 These are one dimensional arrays that include the displacement in the point element local 1 axis direction for each result. (L)
     * @param u2 These are one dimensional arrays that include the displacement in the point element local 2 axis direction for each result. (L)
     * @param u3 These are one dimensional arrays that include the displacement in the point element local 3 axis direction for each result. (L)
     * @param r1 These are one dimensional arrays that include the rotation about the point element local 1 axis for each result. (rad)
     * @param r2 These are one dimensional arrays that include the rotation about the point element local 2 axis for each result. (rad)
     * @param r3 These are one dimensional arrays that include the rotation about the point element local 3 axis for each result. (rad)
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointDisplAbs(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, elm: StringArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, u1: DoubleArrayByRef, u2: DoubleArrayByRef, u3: DoubleArrayByRef, r1: DoubleArrayByRef, r2: DoubleArrayByRef, r3: DoubleArrayByRef): Int =
            callFunctionInt("JointDisplAbs", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the joint reactions for the specified point elements. The reactions reported are from restraints, springs and grounded (one-joint) links.
     * The analysis results are returned in a collection of one-dimensional result arrays.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * See Item Type for Elements for more information.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result.
     * @param stepNum This is an array that includes the step number, if any, for each result.
     * @param f1 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param f2 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param f3 These are one dimensional arrays that include the joint force components in the point element local axis direction. (F)
     * @param m1 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @param m2 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @param m3 These are one dimensional arrays that include the joint moment components about the point element local axis. (FL)
     * @return zero if the reactions are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointReact(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, elm: StringArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, f1: DoubleArrayByRef, f2: DoubleArrayByRef, f3: DoubleArrayByRef, m1: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef): Int =
            callFunctionInt("JointReact", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)
}