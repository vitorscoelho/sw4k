package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysisresults

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm

interface ResultsV14 : SapComponent {
    val setup: SetupV14

    /**
     * This function reports the area forces for the specified area elements that are assigned shell section properties (not plane or asolid properties). Note that the forces reported are per unit of in-plane length.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the area element specified by the Name item.
     * If this item is GroupElm, the result request is for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the area element name associated with each result.
     * @param pointElm This is an array that includes the name of the point element where the results are reported.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f11 The area element internal F22 membrane direct force per length reported in the area element local coordinate system. (F/L)
     * @param f22 The area element internal F22 membrane direct force per length reported in the area element local coordinate system. (F/L)
     * @param f12 The area element internal F12 membrane shear force per length reported in the area element local coordinate system. (F/L)
     * @param fMax The maximum principal membrane force per length. (F/L)
     * @param fMin The minimum principal membrane force per length. (F/L)
     * @param fAngle The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of the maximum principal membrane force. (deg)
     * @param fvm The area element internal Von Mises membrane force per length. (F/L)
     * @param m11 The area element internal M11 plate bending moment per length reported in the area element local coordinate system. This item is only reported for area elements with properties that allow plate bending behavior.
     * @param m22 The area element internal M22 plate bending moment per length reported in the area element local coordinate system. This item is only reported for area elements with properties that allow plate bending behavior. (FL/L)
     * @param m12 The area element internal M12 plate twisting moment per length reported in the area element local coordinate system. This item is only reported for area elements with properties that allow plate bending behavior. (FL/L)
     * @param mMax The maximum principal plate moment per length. This item is only reported for area elements with properties that allow plate bending behavior. (FL/L)
     * @param mMin The minimum principal plate moment per length. This item is only reported for area elements with properties that allow plate bending behavior. (FL/L)
     * @param mAngle The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of the maximum principal plate moment. This item is only reported for area elements with properties that allow plate bending behavior. (deg)
     * @param v13 The area element internal V13 plate transverse shear force per length reported in the area element local coordinate system. This item is only reported for area elements with properties that allow plate bending behavior. (F/L)
     * @param v23 The area element internal V23 plate transverse shear force per length reported in the area element local coordinate system. This item is only reported for area elements with properties that allow plate bending behavior. (F/L)
     * @param vMax The maximum plate transverse shear force. It is equal to the square root of the sum of the squares of V13 and V23. This item is only reported for area elements with properties that allow plate bending behavior. (F/L)
     * @param vAngle The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of Vmax. This item is only reported for area elements with properties that allow plate bending behavior. (deg)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaForceShell(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f11: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f22: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f12: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , fMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , fMin: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , fAngle: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , fvm: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m11: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m22: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m12: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , mMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , mMin: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , mAngle: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , v13: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , v23: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , vMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , vAngle: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY ): Int =
            callFunctionInt("AreaForceShell", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f11, f22, f12, fMax, fMin, fAngle, fvm, m11, m22, m12, mMax, mMin, mAngle, v13, v23, vMax, vAngle)

    /**
     * This function reports the area joint forces for the point elements at each corner of the specified plane elements that have plane-type or asolid-type properties (not shell).
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the plane element specified by the Name item.
     * If this item is GroupElm, the result request is for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for plane elements corresponding to all selected area objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the plane element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the joint force components in the point element local axes directions. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the joint moment components about the point element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaJointForcePlane(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY ): Int =
            callFunctionInt("AreaJointForcePlane", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the area joint forces for the point elements at each corner of the specified area elements that have shell-type properties (not plane or asolid).
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the area element specified by the Name item.
     * If this item is GroupElm, the result request is for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for area elements corresponding to all selected area objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the area element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the joint force components in the point element local axes directions. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the joint moment components about the point element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaJointForceShell(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("AreaJointForceShell", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the stresses for the specified plane elements that are assigned plane or asolid section properties (not shell properties).
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the plane element specified by the Name item.
     * If this item is GroupElm, the result request is for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the plane element name associated with each result.
     * @param pointElm This is an array that includes the name of the point element where the results are reported.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param s11, S22, S33, S12 The plane element internal S11, S22, S33 and S12 stresses, at the specified point element location, reported in the area element local coordinate system. (F/L2)
     * @param sMax, SMin The plane element maximum and minimum principal stresses at the specified point element location. (F/L2)
     * @param sAngle The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the plane element local 1 axis to the direction of the maximum principal stress. (deg)
     * @param svm The plane element internal Von Mises stress at the specified point element. (F/L2)
     * @return zero if the stresses are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaStressPlane(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s22: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s33: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s12: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMin: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngle: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, svm: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("AreaStressPlane", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, s11, s22, s33, s12, sMax, sMin, sAngle, svm)

    /**
     * This function reports the area stresses for the specified area elements that are assigned shell section properties (not plane or asolid properties). Stresses are reported at each point element associated with the area element.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the area element specified by the Name item.
     * If this item is GroupElm, the result request is for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for area elements corresponding to all selected area objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the area element name associated with each result.
     * @param pointElm This is an array that includes the name of the point element where the results are reported.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param s11Top, S22Top, S12Top, S11Bot, S22Bot, S12Bot The area element internal S11, S22 and S12 stresses, at the top or bottom of the specified area element, at the specified point element location, reported in the area element local coordinate system. (F/L2)
     * @param sMaxTop, SMinTop, SMaxBot, SMinBot The area element maximum and minimum principal stresses, at the top or bottom of the specified area element, at the specified point element location. (F/L2)
     * @param sAngleTop, SAngleBot The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of the maximum principal stress, at the top or bottom of the specified area element. (deg)
     * @param sVMTop, SVMBot The area element internal top or bottom Von Mises stress at the specified point element. (F/L2)
     * @param s13Avg, S23Avg The area element average S13 or S23 out-of-plane shear stress at the specified point element. These items are only reported for area elements with properties that allow plate bending behavior. (F/L2)
     * @param sMaxAvg The area element maximum average out-of-plane shear stress. It is equal to the square root of the sum of the squares of S13Avg and S23Avg. This item is only reported for area elements with properties that allow plate bending behavior. (F/L2)
     * @param sAngleAvg The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of SMaxAvg. This item is only reported for area elements with properties that allow plate bending behavior. (deg)
     * @return zero if the stresses are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaStressShell(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11Top: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s22Top: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s12Top: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMaxTop: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMinTop: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngleTop: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sVMTop: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11Bot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s22Bot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s12Bot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMaxBot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMinBot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngleBot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sVMBot: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s13Avg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s23Avg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMaxAvg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngleAvg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("AreaStressShell", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, s11Top, s22Top, s12Top, sMaxTop, sMinTop, sAngleTop, sVMTop, s11Bot, s22Bot, s12Bot, sMaxBot, sMinBot, sAngleBot, sVMBot, s13Avg, s23Avg, sMaxAvg, sAngleAvg)

    /**
     * This function reports the area stresses for the specified area elements that are assigned layered shell section properties.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing area object, area element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the result request is for the area element specified by the Name item.
     * If this item is GroupElm, the result request is for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for area elements corresponding to all selected area objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the area object name associated with each result, if any.
     * @param elm This is an array that includes the area element name associated with each result.
     * @param layer This is an array that includes the layer name associated with each result.
     * @param intPtNum This is an array that includes the integration point number within the specified layer of the area element.
     * @param intPtLoc This is an array that includes the integration point relative location within the specified layer of the area element. The location is between -1 (bottom of layer) and +1 (top of layer), inclusive. The midheight of the layer is at a value of 0.
     * @param pointElm This is an array that includes the name of the point element where the results are reported.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param s11, S22, S12 The area element internal S11, S22 and S12 stresses, at the specified point element location, for the specified layer and layer integration point, reported in the area element local coordinate system. (F/L2)
     * @param sMax, SMin The area element maximum and minimum principal stresses, at the specified point element location, for the specified layer and layer integration point. (F/L2)
     * @param sAngle The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of the maximum principal stress. (deg)
     * @param svm The area element internal Von Mises stress at the specified point element location, for the specified layer and layer integration point. (F/L2)
     * @param s13Avg, S23Avg The area element average S13 or S23 out-of-plane shear stress at the specified point element location, for the specified layer and layer integration point. (F/L2)
     * @param sMaxAvg The area element maximum average out-of-plane shear stress for the specified layer and layer integration point. It is equal to the square root of the sum of the squares of S13Avg and S23Avg. (F/L2)
     * @param sAngleAvg The angle measured counter clockwise (when the local 3 axis is pointing toward you) from the area local 1 axis to the direction of SMaxAvg. (deg)
     * @return zero if the stresses are successfully recovered, otherwise it returns a nonzero value.
     */
    fun areaStressShellLayered(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, layer: AStringArrayByRef = StringArrayByRef.UNNECESSARY, intPtNum: AIntArrayByRef = IntArrayByRef.UNNECESSARY, intPtLoc: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s22: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s12: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMin: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngle: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, svm: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s13Avg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s23Avg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMaxAvg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sAngleAvg: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("AreaStressShellLayered", name, itemTypeElm, numberResults, obj, elm, layer, intPtNum, intPtLoc, pointElm, loadCase, stepType, stepNum, s11, s22, s12, sMax, sMin, sAngle, svm, s13Avg, s23Avg, sMaxAvg, sAngleAvg)

    /**
     * This function reports the assembled joint masses for the specified point elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param u1, U2, U3 These are one dimensional arrays that include the translational mass in the point element local 1, 2 and 3 axes directions, respectively, for each result. (M)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotational mass moment of inertia about the point element local 1, 2 and 3 axes, respectively, for each result. (ML2)
     * @return zero if the masses are successfully recovered, otherwise it returns a nonzero value.
     */
    fun assembledJointMass(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("AssembledJointMass", name, itemTypeElm, numberResults, pointElm, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the structure total base reactions.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param fx, Fy, Fz These are one dimensional arrays that include the base reaction forces in the global X, Y and Z directions, respectively, for each result. (F)
     * @param mx, My, Mz These are one dimensional arrays that include the base reaction moments about the global X, Y and Z axes, respectively, for each result. (FL)
     * @param gx, gy, gz These are the global X, Y and Z coordinates of the point at which the base reactions are reported. (L)
     * @return zero if the reactions are successfully recovered, otherwise it returns a nonzero value.
     */
    fun baseReact(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, mx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, my: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, mz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, gx: ADoubleByRef = DoubleByRef.UNNECESSARY , gy: ADoubleByRef = DoubleByRef.UNNECESSARY , gz: ADoubleByRef = DoubleByRef.UNNECESSARY ): Int =
            callFunctionInt("BaseReact", numberResults, loadCase, stepType, stepNum, fx, fy, fz, mx, my, mz, gx, gy, gz)

    /**
     * This function reports the structure total base reactions and includes information on the centroid of the translational reaction forces.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * Note that the reported base reaction centroids are not the same as the centroid of the applied loads.
     * All base reaction data is considered in and reported in the global coordinate system. For clarity and to reduce wordiness, where the following description refers to a coordinate direction as X, Y or Z, it actually means global X, global Y or global Z.
     * Important Note: The base reaction centroids are calculated from translational reaction forces only. Reaction moments are not considered when calculating these centroids. Thus the reported base reaction centroids are not the same as the centroidn of the applied loads.
     * Three centroidlocations are reported: one for the X direction translational reactions, one for the Y direction translational reactions, and one for the Z direction translational reactions.
     * The centroid for the X direction translational reactions is (XCentroidForFx, YCentroidForFx, ZCentroidForFx).
     * The centroid for the Y direction translational reactions is (XCentroidForFy, YCentroidForFy, ZCentroidForFy).
     * The centroid for the Z direction translational reactions is (XCentroidForFz, YCentroidForFz, ZCentroidForFz).
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param fx, Fy, Fz These are one dimensional arrays that include the base reaction forces in the global X, Y and Z directions, respectively, for each result. (F)
     * @param mx, My, Mz These are one dimensional arrays that include the base reaction moments about the global X, Y and Z axes, respectively, for each result. (FL)
     * @param gx, gy, gz These are the global X, Y and Z coordinates of the point at which the base reactions are reported. (L)
     * @param xCentroidForFX This is an array of the X coordinates of the centroid of all X-direction translational reaction forces for each result (L). This item is reported as zero if the sum of all translational reaction forces in the X- direction is zero.
     * @param yCentroidForFX This is an array of the Y coordinates of the centroid of all X-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the Y coordinate about which the Mz moment caused by the X-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the X-direction is zero.
     * @param zCentroidForFX This is an array of the Z coordinates of the centroid of all X-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the Z coordinate about which the My moment caused by the X-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the X-direction is zero.
     * @param xCentroidForFY This is an array of the X coordinates of the centroid of all Y-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the X coordinate about which the Mz moment caused by the Y-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the Y-direction is zero.
     * @param yCentroidForFY This is an array of the Y coordinates of the centroid of all Y-direction translational reaction forces for each result (L). This item is reported as zero if the sum of all translational reaction forces in the Y-direction is zero.
     * @param zCentroidForFY This is an array of the Z coordinates of the centroid of all Y-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the Z coordinate about which the Mx moment caused by the Y-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the Y-direction is zero.
     * @param xCentroidForFZ This is an array of the X coordinates of the centroid of all Z-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the X coordinate about which the My moment caused by the Z-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the Z-direction is zero.
     * @param yCentroidForFZ This is an array of the Y coordinates of the centroid of all Z-direction translational reaction forces for each result (L). Said another way, the coordinate in this array is the Y coordinate about which the Mx moment caused by the Z-direction translational reaction forces is zero. This item is reported as zero if the sum of all translational reaction forces in the Z-direction is zero.
     * @param zCentroidForFZ This is an array of the Z coordinates of the centroid of all Z-direction translational reaction forces for each result (L). This item is reported as zero if the sum of all translational reaction forces in the Z-direction is zero.
     * @return zero if the reactions are successfully recovered, otherwise it returns a nonzero value.
     */
    fun baseReactWithCentroid(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, mx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, my: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, mz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, gx: ADoubleByRef = DoubleByRef.UNNECESSARY , gy: ADoubleByRef = DoubleByRef.UNNECESSARY , gz: ADoubleByRef = DoubleByRef.UNNECESSARY , xCentroidForFX: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, yCentroidForFX: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, zCentroidForFX: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, xCentroidForFY: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, yCentroidForFY: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, zCentroidForFY: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, xCentroidForFZ: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, yCentroidForFZ: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, zCentroidForFZ: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("BaseReactWithCentroid", numberResults, loadCase, stepType, stepNum, fx, fy, fz, mx, my, mz, gx, gy, gz, xCentroidForFX, yCentroidForFX, zCentroidForFX, xCentroidForFY, yCentroidForFY, zCentroidForFY, xCentroidForFZ, yCentroidForFZ, zCentroidForFZ)

    /**
     * This function returns the longitudinal stresses for multiple cases/combos at a single stress point in a superstructure section cut in a bridge object. Use the functions in SapModel.Results.Setup to control the loads and steps for which results are to be obtained.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function SapModel.BridgeObj.CountSuperCut.
     * @param pointIndex The index number of the stress point in this section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function SapModel.BridgeObj.CountSuperCutStressPoint.
     * @param numberResults The total number of results returned.
     * @param loadCase This is an array that includes the name of the load case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param stress This is an array that includes the longitudinal stress value for each result. (F/L2)
     * @return zero if the information is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun bridgeSuperCutLongitStress(name: String, cutIndex: Int, pointIndex: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, stress: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("BridgeSuperCutLongitStress", name, cutIndex, pointIndex, numberResults, loadCase, stepType, stepNum, stress)

    /**
     * This function reports buckling factors obtained from buckling load cases.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type for each result. For buckling factors, the step type is always Mode. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number for each result. For buckling factors, the step number is always the buckling mode number. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param factor This is an array that includes the buckling factors.
     * @return zero if the factors are successfully recovered, otherwise it returns a nonzero value.
     */
    fun bucklingFactor(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, factor: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("BucklingFactor", numberResults, loadCase, stepType, stepNum, factor)

    /**
     * This function reports the frame forces for the specified line elements.
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
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param p, V2, V3 These are one dimensional arrays that include the axial force, shear force in the local 2 direction, and shear force in the local 3 direction, respectively, for each result. (F)
     * @param t, M2, M3 These are one dimensional arrays that include the torsion, moment about the local 2axis, and moment about the local 3-axis, respectively, for each result. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun frameForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, objSta: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elmSta: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("FrameForce", name, itemTypeElm, numberResults, obj, objSta, elm, elmSta, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)

    /**
     * This function reports the frame joint forces for the point elements at each end of the specified line elements.
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
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the joint force components in the point element local axes directions. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the joint moment components about the point element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun frameJointForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("FrameJointForce", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the displacement values for the specified generalized displacements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing generalized displacement for which results are returned. If the program does not recognize this name as a defined generalized displacement, it returns results for all selected generalized displacements, if any. For example, entering a blank string (i.e., "") for the name will prompt the program to return results for all selected generalized displacements.
     * @param numberResults The total number of results returned by the program.
     * @param gd This is an array that includes the generalized displacement name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param dType This is an array that includes the generalized displacement type for each result. It is either Translation or Rotation.
     * @param value This is an array of the generalized displacement values for each result.(L) when DType is Translation , (rad) when DType is Rotation.
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun generalizedDispl(name: String, numberResults: AIntByRef = IntByRef.UNNECESSARY, gd: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GeneralizedDispl", name, numberResults, gd, loadCase, stepType, stepNum, dType, value)

    /**
     * This function reports the joint accelerations for the specified point elements. The accelerations reported by this function are relative accelerations.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the translational acceleration in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L/s2)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotational acceleration about the point element local 1, 2 and 3 axes, respectively, for each result. (rad/s2)
     * @return zero if the accelerations are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointAcc(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("JointAcc", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the joint absolute accelerations for the specified point elements. Absolute and relative accelerations are the same, except when reported for time history load cases subjected to acceleration loading.
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
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the translational acceleration in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L/s2)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotational acceleration about the point element local 1, 2 and 3 axes, respectively, for each result. (rad/s2)
     * @return zero if the accelerations are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointAccAbs(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("JointAccAbs", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the joint displacements for the specified point elements. The displacements reported by this function are relative displacements.
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
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For these cases this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the displacement in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotation about the point element local 1, 2 and 3 axes, respectively, for each result. (rad)
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointDispl(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY , r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY ): Int =
            callFunctionInt("JointDispl", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the absolute joint displacements for the specified point elements. Absolute and relative displacements are the same except when reported for time history load cases subjected to acceleration loading.
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
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the displacement in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotation about the point element local 1, 2 and 3 axes, respectively, for each result. (rad)
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointDisplAbs(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("JointDisplAbs", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the joint reactions for the specified point elements. The reactions reported are from restraints, springs and grounded (one-joint) links.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElmc = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the reaction forces in the point element local 1, 2 and 3 axes directions, respectively, for each result. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the reaction moments about the point element local 1, 2 and 3 axes, respectively, for each result. (FL)
     * @return zero if the reactions are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointReact(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("JointReact", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the joint velocities for the specified point elements. The velocities reported by this function are relative velocities.
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
     * @param numberResults The number total of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the translational velocity in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L/s)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotational velocity about the point element local 1, 2 and 3 axes, respectively, for each result. (rad/s)
     * @return zero if the velocities are successfully recovered, otherwise it returns a nonzero value.
     */
    fun gJointVel(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GJointVel", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the joint absolute velocities for the specified point elements. Absolute and relative velocities are the same, except when reported for time history load cases subjected to acceleration loading.
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
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For those cases, this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the translational velocity in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L/s)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotational velocity about the point element local 1, 2 and 3 axes, respectively, for each result. (rad/s)
     * @return zero if the velocities are successfully recovered, otherwise it returns a nonzero value.
     */
    fun jointVelAbs(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("JointVelAbs", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the link internal deformations.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing link object, link element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm= = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the link element corresponding to the link object specified by the Name item.
     * If this item is Element, the result request is for the link element specified by the Name item.
     * If this item is GroupElm, the result request is for all link elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for link elements directly or indirectly selected, and the Name item is ignored.
     * For GroupElm and SelectionElm a link element may be indirectly specified through point objects that have panel zone assignments and through line, area, and solid objects that have spring assignments.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the link object name associated with each result, if any.
     * @param elm This is an array that includes the link element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the internal translational deformation of the link in the link element local axes directions. (L)
     * @param r1, R2, R3 These are one dimensional arrays that include the internal rotational deformation of the link about the link element local axes. (rad)
     * @return zero if the deformations are successfully recovered, otherwise it returns a nonzero value.
     */
    fun linkDeformation(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("LinkDeformation", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the link forces at the point elements at the ends of the specified link elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing link object, link element, or group of objects ,depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the link element corresponding to the link object specified by the Name item.
     * If this item is Element, the result request is for the link element specified by the Name item.
     * If this item is GroupElm, the result request is for all link elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for link elements directly or indirectly selected and the Name item is ignored.
     * For GroupElm and SelectionElm a link element may be indirectly specified through point objects that have panel zone assignments and through line, area and solid objects that have spring assignments.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the link object name associated with each result, if any.
     * @param elm This is an array that includes the link element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param p This is an array that includes the link axial force (in the link local 1-axis direction) at the specified point element. (F)
     * @param v2, V3 These are one dimensional arrays that include the link shear force components in the link element local axes directions. (F)
     * @param t This is an array that includes the link torsion (about the link local 1-axis) at the specified point element. (FL)
     * @param m2, M3 These are one dimensional arrays that include the link moment components about the link element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun linkForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("LinkForce", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)

    /**
     * This function reports the joint forces for the point elements at the ends of the specified link elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing link object, link element or group of objects depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the link element corresponding to the link object specified by the Name item.
     * If this item is Element, the result request is for the link element specified by the Name item.
     * If this item is GroupElm, the result request is for all link elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for link elements directly or indirectly selected and the Name item is ignored.
     * For GroupElm and SelectionElm a link element may be indirectly specified through point objects that have panel zone assignments and through line, area and solid objects that have spring assignments.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the link object name associated with each result, if any.
     * @param elm This is an array that includes the link element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the joint force components in the point element local axes directions. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the joint moment components about the point element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun linkJointForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("LinkJointForce", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the modal load participation ratios for each selected modal analysis case.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the modal load case associated with each result.
     * @param itemType This is an array that includes Load Pattern, Acceleration, Link or Panel Zone. It specifies the type of item for which the modal load participation is reported.
     * @param item This is an array whose values depend on the ItemType. If the ItemType is Load Pattern, this is the name of the load pattern.
     * If the ItemType is Acceleration, this is UX, UY, UZ, RX, RY, or RZ, indicating the acceleration direction.
     * If the ItemType is Link, this is the name of the link followed by U1, U2, U3, R1, R2, or R3 (in parenthesis), indicating the link degree of freedom for which the output is reported.
     * If the ItemType is Panel Zone, this is the name of the joint to which the panel zone is assigned, followed by U1, U2, U3, R1, R2, or R3 (in parenthesis), indicating the degree of freedom for which the output is reported.
     * @param stat This is an array that includes the percent static load participation ratio.
     * @param dyn This is an array that includes the percent dynamic load participation ratio.
     * @return zero if the data is successfully recovered; otherwise it returns a nonzero value.
     */
    fun modalLoadParticipationRatios(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, item: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stat: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dyn: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ModalLoadParticipationRatios", numberResults, loadCase, itemType, item, stat, dyn)

    /**
     * This function reports the modal participating mass ratios for each mode of each selected modal analysis case.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the modal load case associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. For modal results, this will always be Mode. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number for each result. For modal results, this is always the mode number. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param period This is an array that includes the period for each result. (s)
     * @param ux This is an array that includes the modal participating mass ratio for the structure Ux degree of freedom. The ratio applies to the specified mode.
     * @param uy This is an array that includes the modal participating mass ratio for the structure Uy degree of freedom. The ratio applies to the specified mode.
     * @param uz This is an array that includes the modal participating mass ratio for the structure Uz degree of freedom. The ratio applies to the specified mode.
     * @param sumUx This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Ux degree of freedom.
     * @param sumUy This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Uy degree of freedom.
     * @param sumUz This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Uz degree of freedom.
     * @param rx This is an array that includes the modal participating mass ratio for the structure Rx degree of freedom. The ratio applies to the specified mode.
     * @param ry This is an array that includes the modal participating mass ratio for the structure Ry degree of freedom. The ratio applies to the specified mode.
     * @param rz This is an array that includes the modal participating mass ratio for the structure Rz degree of freedom. The ratio applies to the specified mode.
     * @param sumRx This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Rx degree of freedom.
     * @param sumRy This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Ry degree of freedom.
     * @param sumRz This is an array that includes the cumulative sum of the modal participating mass ratios for the structure Rz degree of freedom.
     * @return zero if the data is successfully recovered; otherwise it returns a nonzero value.
     */
    fun modalParticipatingMassRatios(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, period: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ux: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, uy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, uz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumUx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumUy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumUz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ry: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumRx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumRy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sumRz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ModalParticipatingMassRatios", numberResults, loadCase, stepType, stepNum, period, ux, uy, uz, sumUx, sumUy, sumUz, rx, ry, rz, sumRx, sumRy, sumRz)

    /**
     * This function reports the modal participation factors for each mode of each selected modal analysis case.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param loadCase This is an array that includes the name of the modal load case associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. For modal results, this will always be Mode. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number for each result. For modal results, this will always be the mode number. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param period This is an array that includes the period for each result. (s)
     * @param ux This is an array that includes the modal participation factor for the structure Ux degree of freedom. The factor applies to the specified mode. (Fs2)
     * @param uy This is an array that includes the modal participation factor for the structure Uy degree of freedom. The factor applies to the specified mode. (Fs2)
     * @param uz This is an array that includes the modal participation factor for the structure Uz degree of freedom. The factor applies to the specified mode. (Fs2)
     * @param rx This is an array that includes the modal participation factor for the structure Rx degree of freedom. The factor applies to the specified mode. (FLs2)
     * @param ry This is an array that includes the modal participation factor for the structure Ry degree of freedom. The factor applies to the specified mode. (FLs2)
     * @param rz This is an array that includes the modal participation factor for the structure Rz degree of freedom. The factor applies to the specified mode. (FLs2)
     * @param modalMass This is an array that includes the modal mass for the specified mode. This is a measure of the kinetic energy in the structure as it is deforming in the specified mode. (FLs2)
     * @param modalStiff This is an array that includes the modal stiffness for the specified mode. This is a measure of the strain energy in the structure as it is deforming in the specified mode. (FL)
     * @return zero if the data is successfully recovered; otherwise it returns a nonzero value.
     */
    fun modalParticipationFactors(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, period: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ux: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, uy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, uz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ry: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, modalMass: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, modalStiff: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ModalParticipationFactors", numberResults, loadCase, stepType, stepNum, period, ux, uy, uz, rx, ry, rz, modalMass, modalStiff)

    /**
     * This function reports the modal period, cyclic frequency, circular frequency and eigenvalue for each selected modal load case.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The number total of results returned by the program.
     * @param loadCase This is an array that includes the name of the modal analysis case associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. For modal results this is always be Mode. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number for each result. For modal results this is always the mode number. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param period This is an array that includes the period for each result. (s)
     * @param frequency This is an array that includes the cyclic frequency for each result. (1/s)
     * @param circFreq This is an array that includes the circular frequency for each result. (rad/s)
     * @param eigenValue This is an array that includes the eigenvalue for the specified mode for each result. (rad2/s2)
     * @return zero if the data is successfully recovered, otherwise it returns a nonzero value.
     */
    fun modalPeriod(numberResults: AIntByRef = IntByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, period: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, frequency: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, circFreq: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, eigenValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ModalPeriod", numberResults, loadCase, stepType, stepNum, period, frequency, circFreq, eigenValue)

    /**
     * This function reports the modal displacements (mode shapes) for the specified point elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point element or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the point element corresponding to the point object specified by the Name item.
     * If this item is Element, the result request is for the point element specified by the Name item.
     * If this item is GroupElm, the result request is for all point elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for all point elements directly or indirectly selected and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the point object name associated with each result, if any. Some results will have no point object associated with them. For these cases this item will be blank.
     * @param elm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the modal analysis case associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. For mode shape results, this is always be Mode. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number for each result. For mode shape results, this is always the mode number. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the displacement in the point element local 1, 2 and 3 axes directions, respectively, for each result. (L)
     * @param r1, R2, R3 These are one dimensional arrays that include the rotation about the point element local 1, 2 and 3 axes, respectively, for each result. (rad)
     * @return zero if the displacements are successfully recovered, otherwise it returns a nonzero value.
     */
    fun modeShape(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ModeShape", name, itemTypeElm, numberResults, obj, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the panel zone (link) internal deformations.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing link object, link element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the panel zone (link) element corresponding to the panel zone assignment to the point object specified by the Name item.
     * If this item is Element, the result request is for the panel zone (link) element specified by the Name item.
     * If this item is GroupElm, the result request is for all panel zone (link) elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for panel zone (link) elements directly or indirectly selected and the Name item is ignored.
     * For GroupElm and SelectionElm a panel zone (link) element may be indirectly specified through point objects that have panel zone assignments.
     * @param numberResults The total number of results returned by the program.
     * @param elm This is an array that includes the panel zone (link) element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param u1, U2, U3 These are one dimensional arrays that include the internal translational deformation of the panel zone (link) in the link element local axes directions. (L)
     * @param r1, R2, R3 These are one dimensional arrays that include the internal rotational deformation of the panel zone (link) about the link element local axes. (rad)
     * @return zero if the deformations are successfully recovered, otherwise it returns a nonzero value.
     */
    fun panelZoneDeformation(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("PanelZoneDeformation", name, itemTypeElm, numberResults, elm, loadCase, stepType, stepNum, u1, u2, u3, r1, r2, r3)

    /**
     * This function reports the panel zone (link) forces at the point elements at the ends of the specified panel zone (link) elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing point object, point element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the panel zone (link) element corresponding to the panel zone assignment to the point object specified by the Name item.
     * If this item is Element, the result request is for the panel zone (link) element specified by the Name item.
     * If this item is GroupElm, the result request is for all panel zone (link) elements directly or indirectly specified in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for panel zone (link) elements directly or indirectly selected and the Name item is ignored.
     * For GroupElm and SelectionElm a panel zone (link) element may be indirectly specified through point objects that have panel zone assignments.
     * @param numberResults The total number of results returned by the program.
     * @param elm This is an array that includes the panel zone (link) element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param p This is an array that includes the panel zone (link) axial force (in the link local 1-axis direction) at the specified point element. (F)
     * @param v2, V3 These are one dimensional arrays that include the panel zone (link) shear force components in the link element local axes directions. (F)
     * @param t This is an array that includes the panel zone (link) torsion (about the link local 1-axis) at the specified point element. (FL)
     * @param m2, M3 These are one dimensional arrays that include the panel zone (link) moment components about the link element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun panelZoneForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("PanelZoneForce", name, itemTypeElm, numberResults, elm, pointElm, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)

    /**
     * This function reports the section cut force for sections cuts that are specified to have an Analysis (F1, F2, F3, M1, M2, M3) result type.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The number total of results returned by the program.
     * @param sCut This is an array that includes the name of the section cut associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the forces in the section cut local axes directions for each result. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the moments about the section cut local axes for each result. (FL)
     * @return zero if the section cut forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun sectionCutAnalysis(numberResults: AIntByRef = IntByRef.UNNECESSARY, sCut: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SectionCutAnalysis", numberResults, sCut, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the section cut force for sections cuts that are specified to have a Design (P, V2, V3, T, M2, M3) result type.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param numberResults The total number of results returned by the program.
     * @param sCut This is an array that includes the name of the section cut associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param p, V2, V3 These are one dimensional arrays that include the axial force, shear force in the section cut local 2 direction and shear force in the section cut local 3 direction, respectively, for each result. (F)
     * @param t, M2, M3 These are one dimensional arrays that include the torsion, moment about the section cut local 2 axis and moment about the section cut local 3-axis, respectively, for each result. (FL)
     * @return zero if the section cut forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun sectionCutDesign(numberResults: AIntByRef = IntByRef.UNNECESSARY, sCut: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SectionCutDesign", numberResults, sCut, loadCase, stepType, stepNum, p, v2, v3, t, m2, m3)

    /**
     * This function reports the joint forces for the point elements at each corner of the specified solid elements.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing solid object, solid element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the result request is for the solid element specified by the Name item.
     * If this item is GroupElm, the result request is for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for solid elements corresponding to all selected solid objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the solid object name associated with each result, if any.
     * @param elm This is an array that includes the solid element name associated with each result.
     * @param pointElm This is an array that includes the point element name associated with each result.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param f1, F2, F3 These are one dimensional arrays that include the joint force components in the point element local axes directions. (F)
     * @param m1, M2, M3 These are one dimensional arrays that include the joint moment components about the point element local axes. (FL)
     * @return zero if the forces are successfully recovered, otherwise it returns a nonzero value.
     */
    fun solidJointForce(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, f3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SolidJointForce", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, f1, f2, f3, m1, m2, m3)

    /**
     * This function reports the stresses for the specified solid elements. Stresses are reported at each point element associated with the solid element.
     * Immediately before requesting results data, it is a good idea to clear the SelectedForOutput flag for all load cases and response combinations and then to set the flag True for those cases and combos for which output is to be generated. This avoids confusion as to which cases and combos are currently selected for output.
     * @param name The name of an existing solid object, solid element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the result request is for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the result request is for the solid element specified by the Name item.
     * If this item is GroupElm, the result request is for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the result request is for solid elements corresponding to all selected solid objects and the Name item is ignored.
     * @param numberResults The total number of results returned by the program.
     * @param obj This is an array that includes the solid object name associated with each result, if any.
     * @param elm This is an array that includes the solid element name associated with each result.
     * @param pointElm This is an array that includes the name of the point element where the results are reported.
     * @param loadCase This is an array that includes the name of the analysis case or load combination associated with each result.
     * @param stepType This is an array that includes the step type, if any, for each result. Instructions:
     * * The step type varies depending on the type of output case considered. For linear static and response spectrum load cases, the step type is not used.
     * * For nonlinear static load cases, the step type is Step, Max, or Min.
     * * For modal cases, the step type is Mode.
     * * For buckling cases, the step type is Mode, which refers to the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step type is Time, Max or Min.
     * * For steady state and power spectral density load cases, the step type is Real at Freq, Imag at Freq, Real Min, Real Max, ImagMin, Imag Max, Mag at Freq, Mag Min, Mag Max, or RMS. Freq is short for frequency, Imag is short for imaginary and Mag is short for magnitude.
     * * For double-valued combinations, this is either Max or Min.
     * * For moving load patterns, this is the force correspondence if it has been requested. It may be M3 Min, M3 Max, M2 Min, M2 Max, T Min, T Max, V3 Min, V3 Max, V2 Min, V2 Max, P Min, or P Max.
     * @param stepNum This is an array that includes the step number, if any, for each result. Instructions:
     * * The step number varies depending on the type of output case considered. For linear static and response spectrum load cases, this step number is not used.
     * * For nonlinear static load cases, it reports the step number when the step type is Step.
     * * For modal cases, the step number is the mode number.
     * * For buckling cases, the step number is the buckling mode number.
     * * For linear modal history, nonlinear modal history, linear direct integration history, and nonlinear direct integration history cases, the step number reports the time in seconds when the step type is Time.
     * * For steady state and power spectral density load cases, the step number is the frequency in Hz when the step type is Real at Freq, Imag at Freq, or Mag at Freq."
     * @param s11, S22, S33, S12, S13, S23 The solid element internal S11, S22, S33, S12, S13 and S23 stresses at the specified point element location, reported in the solid element local coordinate system. (F/L2)
     * @param sMax, SMid, SMin The solid element maximum, middle and minimum principal stresses at the specified point element location. (F/L2)
     * @param svm The solid element internal Von Mises stress at the specified point element location. (F/L2)
     * @param dirCosMax1, DirCosMax2, DirCosMax3 These are three direction cosines defining the orientation of the maximum principal stress with respect to the solid element local axes.
     * @param dirCosMid1, DirCosMid2, DirCosMid3 These are three direction cosines defining the orientation of the middle principal stress with respect to the solid element local axes.
     * @param dirCosMin1, DirCosMin2, DirCosMin3 These are three direction cosines defining the orientation of the minimum principal stress with respect to the solid element local axes.
     * @return zero if the stresses are successfully recovered, otherwise it returns a nonzero value.
     */
    fun solidStress(name: String, itemTypeElm: Int, numberResults: AIntByRef = IntByRef.UNNECESSARY, obj: AStringArrayByRef = StringArrayByRef.UNNECESSARY, elm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, pointElm: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadCase: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepType: AStringArrayByRef = StringArrayByRef.UNNECESSARY, stepNum: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s22: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s33: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s12: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s13: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s23: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMax: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMid: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sMin: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, svm: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMax1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMax2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMax3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMid1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMid2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMid3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMin1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMin2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dirCosMin3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SolidStress", name, itemTypeElm, numberResults, obj, elm, pointElm, loadCase, stepType, stepNum, s11, s22, s33, s12, s13, s23, sMax, sMid, sMin, svm, dirCosMax1, dirCosMax2, dirCosMax3, dirCosMid1, dirCosMid2, dirCosMid3, dirCosMin1, dirCosMin2, dirCosMin3)
}