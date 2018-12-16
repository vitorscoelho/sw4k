package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm
import vitorscoelho.sw4k.sapenums.DistributedLoadType
import vitorscoelho.sw4k.sapenums.Dir
import vitorscoelho.sw4k.sapenums.PointLoadType
import vitorscoelho.sw4k.sapenums.LineDOF
import vitorscoelho.sw4k.sapenums.LineTemperatureLoadType
import vitorscoelho.sw4k.sapenums.LineType
import vitorscoelho.sw4k.sapenums.PDeltaDirection

interface LineElmV14 : SapComponent {
    /**
     * @return the total number of line elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function retrieves the line element end offsets along the 1-axis of the element.
     * @param name The name of an existing line element.
     * @param length1 The offset length along the 1-axis of the line element at the I-End of the line element. (L)
     * @param length2 The offset along the 1-axis of the line element at the J-End of the line element. (L)
     * @param rz The rigid zone factor. This is the fraction of the end offset length assumed to be rigid for bending and shear deformations.
     * @return zero if the offsets are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getEndLengthOffset(name: String, length1: ADoubleByRef = DoubleByRef.UNNECESSARY, length2: ADoubleByRef = DoubleByRef.UNNECESSARY, rz: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetEndLengthOffset", name, length1, length2, rz)

    /**
     * This function retrieves line element insertion point assignments. The assignments are reported as end joint offsets.
     * @param name The name of an existing line element.
     * @param offset1 This is an array of three joint offset distances, in the Global coordinate system, at the I-End of the line element. (L)
     * * Offset1(0) = I-End offset in the global X-axis direction
     * * Offset1(1) = I-End offset in the global Y-axis direction
     * * Offset1(2) = I-End offset in the global Z-axis direction
     * @param offset2 This is an array of three joint offset distances, in the Global coordinate system, at the J-End of the line element. (L)
     * * Offset2(0) = J-End offset in the global X-axis direction
     * * Offset2(1) = J-End offset in the global Y-axis direction
     * * Offset2(2) = J-End offset in the global Z-axis direction
     * @return zero if the insertion point data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getInsertionPoint(name: String, offset1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, offset2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetInsertionPoint", name, offset1, offset2)

    /**
     * This function retrieves the deformation load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of deformation loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each deformation load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each deformation load.
     * @param dof1 array of boolean values indicating if the considered degree of freedom has a deformation load. dof1 = U1
     * @param dof2 array of boolean values indicating if the considered degree of freedom has a deformation load. dof2 = U2
     * @param dof3 array of boolean values indicating if the considered degree of freedom has a deformation load. dof3 = U3
     * @param dof4 array of boolean values indicating if the considered degree of freedom has a deformation load. dof4 = R1
     * @param dof5 array of boolean values indicating if the considered degree of freedom has a deformation load. dof5 = R2
     * @param dof6 array of boolean values indicating if the considered degree of freedom has a deformation load. dof6 = R3
     * @param u1 array of deformation load values. Applicable only if [dof1] = True. U1 = U1 deformation (L)
     * @param u2 array of deformation load values. Applicable only if [dof2] = True. U2 = U2 deformation (L)
     * @param u3 array of deformation load values. Applicable only if [dof3] = True. U3 = U3 deformation (L)
     * @param r1 array of deformation load values. Applicable only if [dof4] = True. R1 = R1 deformation (rad)
     * @param r2 array of deformation load values. Applicable only if [dof5] = True. R2 = R2 deformation (rad)
     * @param r3 array of deformation load values. Applicable only if [dof6] = True. R3 = R3 deformation (rad)
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dof1: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof2: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof3: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof4: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof5: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof6: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, lineName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, u1, u2, u3, r1, r2, r3, itemTypeElm)

    /**
     * This function retrieves the distributed load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of distributed loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each distributed load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the distributed loads are specified.
     * @param myType This is an array that includes either 1 or 2, indicating the type of distributed load ([DistributedLoadType] enumeration).
     * * 1 = Force
     * * 2 = Moment
     * @param cSys This is an array that includes the name of the coordinate system in which each distributed load is defined. It may be Local or the name of a defined coordinate system.
     * @param dir This is an array that includes an integer between 1 and 11, indicating the direction of the load ([Dir] enumeration).
     * * 1 = Local 1 axis (only applies when CSys is Local)
     * * 2 = Local 2 axis (only applies when CSys is Local)
     * * 3 = Local 3 axis (only applies when CSys is Local)
     * * 4 = X direction (does not apply when CSys is Local)
     * * 5 = Y direction (does not apply when CSys is Local)
     * * 6 = Z direction (does not apply when CSys is Local)
     * * 7 = Projected X direction (does not apply when CSys is Local)
     * * 8 = Projected Y direction (does not apply when CSys is Local)
     * * 9 = Projected Z direction (does not apply when CSys is Local)
     * * 10 = Gravity direction (only applies when CSys is Global)
     * * 11 = Projected Gravity direction (only applies when CSys is Global)
     * The positive gravity direction (see Dir = 10 and 11) is in the negative Global Z direction.
     * @param rD1 This is an array that includes the relative distance from the I-End of the line element to the start of the distributed load.
     * @param rD2 This is an array that includes the relative distance from the I-End of the line element to the end of the distributed load.
     * @param dist1 This is an array that includes the actual distance from the I-End of the line element to the start of the distributed load. (L)
     * @param dist2 This is an array that includes the actual distance from the I-End of the line element to the end of the distributed load. (L)
     * @param val1 This is an array that includes the load value at the start of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param val2 This is an array that includes the load value at the end of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDistributed(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, myType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dir: AIntArrayByRef = IntArrayByRef.UNNECESSARY, rD1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rD2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dist1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dist2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, val1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, val2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadDistributed", name, numberItems, lineName, loadPat, myType, cSys, dir, rD1, rD2, dist1, dist2, val1, val2, itemTypeElm)

    /**
     * This function retrieves the gravity load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of gravity loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x array of gravity load multipliers in the x direction of the specified coordinate system.
     * @param y array of gravity load multipliers in the y direction of the specified coordinate system.
     * @param z array of gravity load multipliers in the z direction of the specified coordinate system.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, x: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, y: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, z: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, lineName, loadPat, cSys, x, y, z, itemTypeElm)

    /**
     * This function retrieves the point load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of point loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each point load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the point loads are specified.
     * @param myType This is an array that includes either 1 or 2, indicating the type of point load ([PointLoadType] enumeration).
     * * 1 = Force
     * * 2 = Moment
     * @param cSys This is an array that includes the name of the coordinate system in which each point load is defined. It may be Local or the name of a defined coordinate system.
     * @param dir This is an array that includes an integer between 1 and 11, indicating the direction of the load ([Dir] enumeration).
     * * 1 = Local 1 axis (only applies when CSys is Local)
     * * 2 = Local 2 axis (only applies when CSys is Local)
     * * 3 = Local 3 axis (only applies when CSys is Local)
     * * 4 = X direction (does not apply when CSys is Local)
     * * 5 = Y direction (does not apply when CSys is Local)
     * * 6 = Z direction (does not apply when CSys is Local)
     * * 7 = Projected X direction (does not apply when CSys is Local)
     * * 8 = Projected Y direction (does not apply when CSys is Local)
     * * 9 = Projected Z direction (does not apply when CSys is Local)
     * * 10 = Gravity direction (only applies when CSys is Global)
     * * 11 = Projected Gravity direction (only applies when CSys is Global)
     * The positive gravity direction (see Dir = 10 and 11) is in the negative Global Z direction.
     * @param relDist This is an array that includes the relative distance from the I-End of the line element to the location where the point load is applied.
     * @param dist This is an array that includes the actual distance from the I-End of the line element to the location where the point load is applied. (L)
     * @param values This is an array that includes the value of the point load. (F) when MyType is 1 and (FL) when MyType is 2
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadPoint(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, myType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dir: AIntArrayByRef = IntArrayByRef.UNNECESSARY, relDist: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dist: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, values: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadPoint", name, numberItems, lineName, loadPat, myType, cSys, dir, relDist, dist, values, itemTypeElm)

    /**
     * This function retrieves the strain load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of strain loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param DOF This is an array that includes 1, 2, 3, 4, 5 or 6, indicating the degree of freedom associated with each strain load ([LineDOF] enumeration).
     * * 1 = Strain11
     * * 2 = Strain12
     * * 3 = Strain13
     * * 4 = Curvature1
     * * 5 = Curvature2
     * * 6 = Curvature3
     * @param values This is an array that includes the strain value. (L/L) for DOF = 1, 2 and 3 and (1/L) for DOF = 4, 5 and 6
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, DOF: AIntArrayByRef = IntArrayByRef.UNNECESSARY, values: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, lineName, loadPat, DOF, values, patternName, itemTypeElm)

    /**
     * This function retrieves the target force assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of deformation loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each target force.
     * @param loadPat This is an array that includes the name of the load pattern associated with each target force.
     * @param dof1 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof1 = P
     * @param dof2 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof2 = V2
     * @param dof3 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof3 = V3
     * @param dof4 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof4 = T
     * @param dof5 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof5 = M2
     * @param dof6 array of boolean values indicating if the considered degree of freedom has a target force assignment. dof6 = M3
     * @param p array of target force values. Only applicable if [dof1] = True.
     * @param v2 array of target force values. Only applicable if [dof2] = True.
     * @param v3 array of target force values. Only applicable if [dof3] = True.
     * @param t array of target force values. Only applicable if [dof4] = True.
     * @param m2 array of target force values. Only applicable if [dof5] = True.
     * @param m3 array of target force values. Only applicable if [dof6] = True.
     * @param t1 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof1] = True. T1 = relative location for P target force.
     * @param t2 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof2] = True. T2 = relative location for V2 target force.
     * @param t3 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof3] = True. T3 = relative location for V3 target force.
     * @param t4 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof4] = True. T4 = relative location for T target force.
     * @param t5 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof5] = True. T5 = relative location for M2 target force.
     * @param t6 array of the relative distances along the line elements where the target force values apply. Only applicable if [dof6] = True. T6 = relative location for M3 target force.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTargetForce(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dof1: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof2: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof3: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof4: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof5: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof6: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t4: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t5: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t6: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadTargetForce", name, numberItems, lineName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, p, v2, v3, t, m2, m3, t1, t2, t3, t4, t5, t6, itemTypeElm)

    /**
     * This function retrieves the temperature load assignments to line elements.
     * @param name The name of an existing line object, line element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of temperature loads retrieved for the specified line elements.
     * @param lineName This is an array that includes the name of the line element associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param myType This is an array that includes 1, 2 or 3, indicating the type of temperature load ([LineTemperatureLoadType] enumeration).
     * * 1 = Temperature
     * * 2 = Temperature gradient along local 2 axis
     * * 3 = Temperature gradient along local 3 axis
     * @param values This is an array that includes the temperature load value. (T) for MyType= 1 and (T/L) for MyType= 2 and 3
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the line elements corresponding to the line object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the line element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the line elements corresponding to all line objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for line elements corresponding to all selected line objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, lineName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, myType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, values: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, lineName, loadPat, myType, values, patternName, itemTypeElm)

    /**
     * This function retrieves the local axis angle assignment for line elements.
     * @param name The name of an existing line element.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation. The rotation for a positive angle appears counterclockwise when the local +1 axis is pointing toward you. (deg)
     * @return zero if the assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetLocalAxes", name, ang)

    /**
     * This function retrieves the material overwrite assigned to a line element, if any. It returns None if there is no material overwrite assignment.
     * @param name The name of a defined line element.
     * @param propName This is None, indicating that no material overwrite exists for the specified line element, or it is the name of an existing material property.
     * @return zero if the material overwrite assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMaterialOverwrite(name: String, propName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMaterialOverwrite", name, propName)

    /**
     * This function retrieves the material temperature assignments to line elements.
     * @param name The name of an existing line element.
     * @param temp This is the material temperature value assigned to the line element. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the line element is uniform along the element at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the line element may vary from one end to the other. The material temperature at each end of the element is equal to the specified temperature multiplied by the pattern value at the joint at the end of the line element.
     * @return zero if the material temperature assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: ADoubleByRef = DoubleByRef.UNNECESSARY, patternName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the section modifier assignment for line elements. The default value for all modifiers is one.
     * @param name The name of an existing line element.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined line elements.
     * @param numberNames The number of line element names retrieved by the program.
     * @param myName This is a one-dimensional array of line element names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves information about the object from which a line element was created.
     * @param name The name of an existing line element.
     * @param obj The name of the frame, cable or tendon object from which the line element was created.
     * @param objType This is 0, 1, 2 or 3, indicating the type of object from which the line element was created ([LineType] enumeration).
     * * 0 = Straight frame object
     * * 1 = Curved frame object
     * * 2 = Cable object
     * * 3 = Tendon object
     * @param RDI The relative distance from the I-End of the object identified by the Obj item to the I-End of the considered line element. The relative distance is calculated as the distance from the I-End of the object to the I-End of the line element divided by the length of the object.
     * @param RDJ The relative distance from the I-End of the object identified by the Obj item to the J-End of the considered line element. The relative distance is calculated as the distance from the I-End of the object to the J-End of the line element divided by the length of the object.
     * @return zero if the information is successfully retrieved, otherwise it returns nonzero.
     */
    fun getObj(name: String, obj: AStringByRef = StringByRef.UNNECESSARY, objType: AIntByRef = IntByRef.UNNECESSARY, RDI: ADoubleByRef = DoubleByRef.UNNECESSARY, RDJ: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetObj", name, obj, objType, RDI, RDJ)

    /**
     * This function retrieves the P-Delta force assignments to line elements.
     * @param name The name of an existing line element.
     * @param numberForces The number of P-Delta forces assigned to the line element.
     * @param pDeltaForce This is an array of the P-Delta force values assigned to the line element. (F)
     * @param dir This is an array that contains 0, 1, 2 or 3, indicating the direction of each P-Delta force assignment ([PDeltaDirection] enumeration).
     * * 0 = Frame object local 1-axis direction
     * * 1 = Projected X direction in CSys coordinate system
     * * 2 = Projected Y direction in CSys coordinate system
     * * 3 = Projected Z direction in CSys coordinate system
     * @param cSys This is an array that contains the name of the coordinate system in which each projected P-Delta force is defined. This item is blank when the Dir item is zero, that is, when the P-Delta force is defined in the line element local 1-axis direction.
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPDeltaForce(name: String, numberForces: AIntByRef = IntByRef.UNNECESSARY, pDeltaForce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dir: AIntArrayByRef = IntArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetPDeltaForce", name, numberForces, pDeltaForce, dir, cSys)

    /**
     * This function retrieves the names of the point elements at each end of a specified line element.
     * @param name The name of a defined line element.
     * @param point1 The name of the point element at the I-End of the specified line element.
     * @param point2 The name of the point element at the J-End of the specified line element.
     * @return zero if the point names are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: AStringByRef = StringByRef.UNNECESSARY, point2: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the property assignment to a line element.
     * The sVarTotalLength and sVarRelStartLoc items apply only when the Var item is True.
     * @param name The name of an existing line element.
     * @param propName The name of the frame section, cable or tendon property assigned to the line element.
     * @param objType This is 0, 1, 2 or 3, indicating the type of object from which the line element was created ([LineType] enumeration).
     * * 0 = Straight frame object
     * * 1 = Curved frame object
     * * 2 = Cable object
     * * 3 = Tendon object
     * @param var This item is True if the specified property is a nonprismatic (variable) frame section property.
     * @param sVarTotalLength This is the total assumed length of the nonprismatic section. A zero value for this item means that the section length is the same as the line element length.
     * @param sVarRelStartLoc This is the relative distance along the nonprismatic section to the I-End (start) of the line element. This item is ignored when the [sVarTotalLength] is 0.
     * @return zero if the property data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: AStringByRef = StringByRef.UNNECESSARY, objType: AIntByRef = IntByRef.UNNECESSARY, `var`: ABooleanByRef, sVarRelStartLoc: ADoubleByRef = DoubleByRef.UNNECESSARY, sVarTotalLength: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetProperty", name, propName, objType, `var`, sVarRelStartLoc, sVarTotalLength)

    /**
     * This function retrieves the line element end release and partial fixity assignments.
     * @param name The name of an existing line element.
     * @param ii Array of six booleans indicating the I-End releases for the line element.
     * * ii(0) = U1 release
     * * ii(1) = U2 release
     * * ii(2) = U3 release
     * * ii(3) = R1 release
     * * ii(4) = R2 release
     * * ii(5) = R3 release
     * @param jj Array of six booleans indicating the J-End releases for the line element.
     * * jj(0) = U1 release
     * * jj(1) = U2 release
     * * jj(2) = U3 release
     * * jj(3) = R1 release
     * * jj(4) = R2 release
     * * jj(5) = R3 release
     * @param startValue Arrays of six values indicating the I-End partial fixity springs for the line element.
     * * StartValue(0) = U1 partial fixity (F/L)
     * * StartValue(1) = U2 partial fixity (F/L)
     * * StartValue(2) = U3 partial fixity (F/L)
     * * StartValue(3) = R1 partial fixity (FL/rad)
     * * StartValue(4) = R2 partial fixity (FL/rad)
     * * StartValue(5) = R3 partial fixity (FL/rad)
     * @param endValue Array of six values indicating the J-End partial fixity springs for the line element.
     * * EndValue(0) = U1 partial fixity (F/L)
     * * EndValue(1) = U2 partial fixity (F/L)
     * * EndValue(2) = U3 partial fixity (F/L)
     * * EndValue(3) = R1 partial fixity (FL/rad)
     * * EndValue(4) = R2 partial fixity (FL/rad)
     * * EndValue(5) = R3 partial fixity (FL/rad)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getReleases(name: String, ii: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, jj: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, startValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, endValue: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetReleases", name, ii, jj, startValue, endValue)

    /**
     * This function retrieves the tension/compression force limit assignments to line elements.
     * Note that the tension and compression limits are only used in nonlinear analyses.
     * @param name The name of an existing line element.
     * @param limitCompressionExists This item is True if a compression force limit exists for the line element.
     * @param limitCompression The compression force limit for the line element. (F)
     * @param limitTensionExists This item is True if a tension force limit exists for the line element.
     * @param limitTension The tension force limit for the line element. (F)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTCLimits(name: String, limitCompressionExists: ABooleanByRef, limitCompression: ADoubleByRef = DoubleByRef.UNNECESSARY, limitTensionExists: ABooleanByRef, limitTension: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetTCLimits", name, limitCompressionExists, limitCompression, limitTensionExists, limitTension)

    /**
     * @param name The name of an existing line element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the line element local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the element local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetTransformationMatrix", name, value)
}