package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm
import vitorscoelho.sw4k.sapenums.LinkObjectAssociatedType

interface LinkElmV14 : SapComponent {
    /**
     * @return the total number of link elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function retrieves the deformation load assignments to link elements.
     * @param name The name of an existing link object, link element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of deformation loads retrieved for the specified link elements.
     * @param linkName This is an array that includes the name of the link element associated with each deformation load.
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
     * If this item is ObjectElm, the load assignments are retrieved for the link elements corresponding to the link object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the link element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the link elements corresponding to all link objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for link elements corresponding to all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, linkName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dof1: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof2: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof3: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof4: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof5: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof6: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, u1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, r3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, linkName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, u1, u2, u3, r1, r2, r3, itemTypeElm)

    /**
     * This function retrieves the gravity load assignments to link elements.
     * @param name The name of an existing link object, link element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of gravity loads retrieved for the specified link elements.
     * @param linkName This is an array that includes the name of the link element associated with each gravity load.
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
     * If this item is ObjectElm, the load assignments are retrieved for the link elements corresponding to the link object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the link element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the link elements corresponding to all link objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for link elements corresponding to all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, linkName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, x: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, y: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, z: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, linkName, loadPat, cSys, x, y, z, itemTypeElm)

    /**
     * This function retrieves the target force assignments to link elements.
     * @param name The name of an existing link object, link element or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems The total number of deformation loads retrieved for the specified link elements.
     * @param linkName This is an array that includes the name of the link element associated with each target force.
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
     * @param itemTypeElm This is one of the following items in the eItemTypeElm enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the link elements corresponding to the link object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the link element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the link elements corresponding to all link objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for link elements corresponding to all selected link objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTargetForce(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, linkName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dof1: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof2: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof3: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof4: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof5: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, dof6: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, p: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, v3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, m3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t1: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t2: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t3: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t4: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t5: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, t6: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.OBJECT_ELM.sapId): Int =
            callFunctionInt("GetLoadTargetForce", name, numberItems, linkName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, p, v2, v3, t, m2, m3, t1, t2, t3, t4, t5, t6, itemTypeElm)

    /**
     * This function retrieves the local axis angle assignment for link elements.
     * @param name The name of an existing link element.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetLocalAxes", name, ang)

    /**
     * This function retrieves the names of all defined link elements.
     * @param numberNames The number of link element names retrieved by the program.
     * @param myName This is a one-dimensional array of link element names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the object associated with a specified link element.
     * @param name The name of an existing link element.
     * @param obj The name of the object associated with the specified link element. The type of object or item is determined from the ObjType variable.
     * @param objType A number indicating the type of object that is associated with the point element ([LinkObjectAssociatedType] enumeration).
     * * 2: Obj is a line object that is has a line spring assignment. The springs are modeled using link elements.
     * * 3: Obj is a area object that is has an area spring assignment. The springs are modeled using link elements.
     * * 6: Obj is a solid object that is has a surface spring assignment. The springs are modeled using link elements.
     * * 9: Obj is a point object that has a panel zone assignment. The specified link element is internally added by the program at the point object (panel zone) location to model the panel zone.
     * @return zero if the object is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getObj(name: String, obj: AStringByRef = StringByRef.UNNECESSARY, objType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetObj", name, obj, objType)

    /**
     * This function retrieves the names of the point elements at each end of a specified link element. The points at each end have the same name if the link element is a one-joint element.
     * @param name The name of a defined link element.
     * @param point1 The name of the point element at the I-End of the specified link element.
     * @param point2 The name of the point element at the J-End of the specified link element.
     * @return zero if the point names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: AStringByRef = StringByRef.UNNECESSARY, point2: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the frequency dependent property assignment to a link element. If no frequency dependent property is assigned to the link, the PropName is returned as None.
     * @param name The name of an existing link element.
     * @param propName The name of the frequency dependent link property assigned to the link element.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPropertyFD(name: String, propName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetPropertyFD", name, propName)

    /**
     * This function retrieves the property assignment to a link element.
     * The sVarTotalLength and sVarRelStartLoc items apply only when the Var item is True.
     * @param name The name of an existing link element.
     * @param propName The name of the link property assigned to the link element.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * @param name The name of an existing link element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the link element local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the element local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetTransformationMatrix", name, value)
}