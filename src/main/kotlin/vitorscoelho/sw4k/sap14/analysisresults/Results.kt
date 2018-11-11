package vitorscoelho.sw4k.sap14.analysisresults

import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.ItemTypeElm

class Results(val sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cAnalysisResults") {
    val setup = Setup(this.sapModel)

    /**
     * This function reports the frame forces for the specified line elements.
     * See Analysis Results Remarks for additional information.
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
     * @param p These are one dimensional arrays that include the axial force for each result. [F]
     * @param v2 These are one dimensional arrays that include the shear force in the local 2 direction for each result. [F]
     * @param v3 These are one dimensional arrays that include the shear force in the local 3 direction  for each result. [F]
     * @param t These are one dimensional arrays that include the torsion for each result. [FL]
     * @param m2 These are one dimensional arrays that include the moment about the local 2axis for each result. [FL]
     * @param m3 These are one dimensional arrays that include the moment about the local 3-axis for each result. [FL]
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun frameForce(name: String, itemTypeElm: Int, numberResults: IntByRef, obj: StringArrayByRef, objSta: DoubleArrayByRef, elm: StringArrayByRef, elmSta: DoubleArrayByRef, loadCase: StringArrayByRef, stepType: StringArrayByRef, stepNum: DoubleArrayByRef, p: DoubleArrayByRef, v2: DoubleArrayByRef, v3: DoubleArrayByRef, t: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef): Int =
            callFunctionInt("FrameForce", name, itemTypeElm, numberResults, obj, objSta, elm, elmSta, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)
}