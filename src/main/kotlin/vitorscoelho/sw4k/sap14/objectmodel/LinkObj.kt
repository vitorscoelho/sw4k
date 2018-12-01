package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class LinkObj internal constructor(programName: String) : LinkObjV14 {
    override val activeXComponentName: String = "$programName.cLinkObj"
}

interface LinkObjV14 : SapComponent {
    /**
     * This function adds a new link object whose end points are at the specified coordinates.
     * @param xi, yi, zi The coordinates of the I-End of the added link object. The coordinates are in the coordinate system defined by the CSys item.
     * @param xj, yj, zj The coordinates of the J-End of the added link object. The coordinates are in the coordinate system defined by the CSys item.
     * These coordinates are ignored if the IsSingleJoint item is True.
     * @param name This is the name that the program ultimately assigns for the link object. If no UserName is specified, the program assigns a default name to the link object. If a UserName is specified and that name is not used for another link object, the UserName is assigned to the link object; otherwise a default name is assigned to the link object.
     * @param isSingleJoint This item is True if a one-joint link is added and False if a two-joint link is added.
     * @param propName This is either Default or the name of a defined link property.
     * If it is Default the program assigns a default link property to the link object. If it is the name of a defined link property, that property is assigned to the link object.
     * @param userName This is an optional user specified name for the link object. If a UserName is specified and that name is already used for another link object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the link object end point coordinates are defined.
     * @return zero if the link object is successfully added; otherwise it returns a nonzero value.
     */
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: StringByRef= StringByRef(), isSingleJoint: Boolean = false, propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", xi, yi, zi, xj, yj, zj, name, isSingleJoint, propName, userName, cSys)

    /**
     * This function adds a new link object whose end points are specified by name.
     * @param point1 The name of a defined point object at the I-End of the added link object.
     * @param point2 The name of a defined point object at the J-End of the added link object.
     * This item is ignored if the IsSingleJoint item is True.
     * @param name This is the name that the program ultimately assigns for the link object. If no UserName is specified, the program assigns a default name to the link object. If a UserName is specified and that name is not used for another link object, the UserName is assigned to the link object; otherwise a default name is assigned to the link object.
     * @param isSingleJoint This item is True if a one-joint link is added and False if a two-joint link is added.
     * @param propName This is either Default or the name of a defined link property.
     * If it is Default the program assigns a default link property to the link object. If it is the name of a defined link property, that property is assigned to the link object.
     * @param userName This is an optional user specified name for the link object. If a UserName is specified and that name is already used for another link object, the program ignores the UserName.
     * @return zero if the link object is successfully added; otherwise it returns a nonzero value.
     */
    fun addByPoint(point1: String, point2: String, name: StringByRef=StringByRef(), isSingleJoint: Boolean = false, propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point1, point2, name, isSingleJoint, propName, userName)

    /**
     * This function applies a new name to an link object.
     * @param name The existing name of a defined link object.
     * @param newName The new name for the link object.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return a count of the link objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes the deformation load assignments to the specified link objects for the specified load pattern.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the link object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadDeformation(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDeformation", name, loadPat, itemType)

    /**
     * This function deletes the gravity load assignments to the specified link objects for the specified load pattern.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the link object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the target force assignments to the specified link objects for the specified load pattern.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the link object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected link objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadTargetForce(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTargetForce", name, loadPat, itemType)

    /**
     * The function deletes link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the link object specified by the Name item is deleted.
     * If this item is Group, the all link objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all selected link objects are deleted, and the Name item is ignored.
     * @return zero if the link objects are successfully deleted; otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves the name of the link element (analysis model link) associated with a specified link object in the object-based model.
     * @param name The name of an existing link object.
     * @param elm The name of the link element created from the specified link object.
     * @return zero if the link element name is successfully retrieved; otherwise it returns nonzero. An error occurs if the analysis model does not exist.
     */
    fun getElm(name: String, elm: StringByRef): Int =
            callFunctionInt("GetElm", name, elm)

    /**
     * This function retrieves the GUID for the specified link object.
     * @param name The name of an existing link object.
     * @param GUID The GUID (Global Unique ID) for the specified link object.
     * @return zero if the link object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: StringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves the deformation load assignments to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified link objects.
     * @param linkName This is an array that includes the name of the link object associated with each deformation load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each deformation load.
     * @param dof1, dof2, dof3, dof4, dof5, dof6 These are arrays of boolean values, indicating if the considered degree of freedom has a deformation load.
     * * dof1 = U1
     * * dof2 = U2
     * * dof3 = U3
     * * dof4 = R1
     * * dof5 = R2
     * * dof6 = R3
     * @param u1, U2, U3, R1, R2, R3 These are arrays of deformation load values. The deformations specified for a given degree of freedom are applicable only if the corresponding dof item for that degree of freedom is True.
     * * U1 = U1 deformation (L)
     * * U2 = U2 deformation (L)
     * * U3 = U3 deformation (L)
     * * R1 = R1 deformation (rad)
     * * R2 = R2 deformation (rad)
     * * R3 = R3 deformation (rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the link object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: IntByRef, linkName: StringArrayByRef, loadPat: StringArrayByRef, dof1: BooleanArrayByRef, dof2: BooleanArrayByRef, dof3: BooleanArrayByRef, dof4: BooleanArrayByRef, dof5: BooleanArrayByRef, dof6: BooleanArrayByRef, u1: DoubleArrayByRef, u2: DoubleArrayByRef, u3: DoubleArrayByRef, r1: DoubleArrayByRef, r2: DoubleArrayByRef, r3: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, linkName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, u1, u2, u3, r1, r2, r3, itemType)

    /**
     * This function retrieves the gravity load assignments to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified link objects.
     * @param linkName This is an array that includes the name of the link object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the link object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected link objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, linkName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, linkName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the target force assignments to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified link objects.
     * @param linkName This is an array that includes the name of the link object associated with each target force.
     * @param loadPat This is an array that includes the name of the load pattern associated with each target force.
     * @param dof1, dof2, dof3, dof4, dof5, dof6 These are arrays of boolean values indicating if the considered degree of freedom has a target force assignment.
     * * dof1 = P
     * * dof2 = V2
     * * dof3 = V3
     * * dof4 = T
     * * dof5 = M2
     * * dof6 = M3
     * @param p, V2, V3, T, M2, M3 These are arrays of target force values. The target forces specified for a given degree of freedom are applicable only if the corresponding dof item for that degree of freedom is True.
     * * U1 = U1 deformation (L)
     * * U2 = U2 deformation (L)
     * * U3 = U3 deformation (L)
     * * R1 = R1 deformation (rad)
     * * R2 = R2 deformation (rad)
     * * R3 = R3 deformation (rad)
     * @param t1, T2, T3, T4, T5, T6 * These are arrays of the relative distances along the link objects where the target force values apply. The relative distances specified for a given degree of freedom are applicable only if the corresponding dofn item for that degree of freedom is True.
     * * T1 = relative location for P target force
     * * T2 = relative location for V2 target force
     * * T3 = relative location for V3 target force
     * * T4 = relative location for T target force
     * * T5 = relative location for M2 target force
     * * T6 = relative location for M3 target force
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the link object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected link objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTargetForce(name: String, numberItems: IntByRef, linkName: StringArrayByRef, loadPat: StringArrayByRef, dof1: BooleanArrayByRef, dof2: BooleanArrayByRef, dof3: BooleanArrayByRef, dof4: BooleanArrayByRef, dof5: BooleanArrayByRef, dof6: BooleanArrayByRef, p: DoubleArrayByRef, v2: DoubleArrayByRef, v3: DoubleArrayByRef, t: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef, t1: DoubleArrayByRef, t2: DoubleArrayByRef, t3: DoubleArrayByRef, t4: DoubleArrayByRef, t5: DoubleArrayByRef, t6: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTargetForce", name, numberItems, linkName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, p, v2, v3, t, m2, m3, t1, t2, t3, t4, t5, t6, itemType)

    /**
     * This function assigns advanced local axes to link objects.
     * @param name The name of an existing link object.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2, or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 1 (2 integers), indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param axPt, PlPt This is an array dimensioned to 1 (2 strings), indicating the labels of two joints that define the axis/plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 2.
     * @param axVect, PlVect This is an array dimensioned to 2 (3 doubles) that defines the axis/plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 3.
     * @param plane2 This is 12 or 13, indicating that the local plane determined by the plane reference vector is the 1-2 or 1-3 plane. This item applies only when the Active item is True.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun getLocalAxesAdvanced(name: String, active: BooleanByRef, axVectOpt: IntByRef, axCSys: StringByRef, axDir: IntArrayByRef, axPt: StringArrayByRef, axVect: DoubleArrayByRef, plane2: IntByRef, plVectOpt: IntByRef, plCSys: StringByRef, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef): Int =
            callFunctionInt("GetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect)

    /**
     * This function retrieves the local axis angle assignment for link objects.
     * @param name The name of an existing link object.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation or, if the Advanced item is True, from the orientation determined by the plane reference vector. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @param advanced This item is True if the link object local axes orientation was obtained using advanced local axes parameters.
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: DoubleByRef, advanced: BooleanByRef): Int =
            callFunctionInt("GetLocalAxes", name, ang, advanced)

    /**
     * This function retrieves the names of all defined link objects.
     * @param numberNames The number of link object names retrieved by the program.
     * @param myName This is a one-dimensional array of link object names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of the point objects at each end of a specified link object. If names of the two point objects are the same, the specified link object is a one-joint link object.
     * @param name The name of a defined link object.
     * @param point1 The name of the point object at the I-End of the specified link object.
     * @param point2 The name of the point object at the J-End of the specified link object.
     * @return zero if the point names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: StringByRef, point2: StringByRef): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the frequency dependent link property assigned to a link object.
     * @param name The name of a defined link object.
     * @param propName The name of the frequency dependent link property assigned to the link object. This item is None if there is no frequency dependent link property assigned to the link object.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the link property assigned to a link object.
     * @param name The name of a defined link object.
     * @param propName The name of the link property assigned to the link object.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPropertyFD(name: String, propName: StringByRef): Int =
            callFunctionInt("GetPropertyFD", name, propName)

    /**
     * This function retrieves the selected status for a link object.
     * @param name The name of an existing link object.
     * @param selected This item is True if the specified link object is selected; otherwise it is False.
     * @return zero if the selected status is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * @param name The name of an existing link object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the link object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the link object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system, and the link object local coordinate system.
     * @return zero if the link object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function adds or removes link objects from a specified group.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified link objects are added to the group specified by the GroupName item. If it is True, the link objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the link object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all link objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected link objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful; otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified link object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing link object.
     * @param GUID The GUID (Global Unique ID) for the specified link object.
     * @return zero if the link object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns deformation loads to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param dof This is a array of boolean values indicating if the considered degree of freedom has a deformation load.
     * * dof(1) = U1
     * * dof(2) = U2
     * * dof(3) = U3
     * * dof(4) = R1
     * * dof(5) = R2
     * * dof(6) = R3
     * @param d This is a array of deformation load values. The deformations specified for a given degree of freedom are applied only if the corresponding dof item for that degree of freedom is True.
     * * d(1) = U1 deformation (L)
     * * d(2) = U2 deformation (L)
     * * d(3) = U3 deformation (L)
     * * d(4) = R1 deformation (rad)
     * * d(5) = R2 deformation (rad)
     * * d(6) = R3 deformation (rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadDeformation(name: String, loadPat: String, dof: BooleanArrayByRef, d: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDeformation", name, loadPat, dof, d, itemType)

    /**
     * This function assigns gravity load multipliers to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified link object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns target forces to frame objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param dof This is a array of boolean values indicating if the considered degree of freedom has a target force.
     * * dof(1) = P
     * * dof(2) = V2
     * * dof(3) = V3
     * * dof(4) = T
     * * dof(5) = M2
     * * dof(6) = M3
     * @param f This is a array of target force values. The target forces specified for a given degree of freedom are applied only if the corresponding dof item for that degree of freedom is True.
     * * f(1) = P (F)
     * * f(2) = V2 (F)
     * * f(3) = V3 (F)
     * * f(4) = T (FL)
     * * f(5) = M2 (FL)
     * * f(6) = M3 (FL)
     * @param rd This is a array of relative distances along the link objects where the target force values apply. The relative distances specified for a given degree of freedom are applicable only if the corresponding dof item for that degree of freedom is True. The relative distance must be between 0 and 1, 0 <= RD <=1.
     * * RD(1) = relative location for P target force
     * * RD(2) = relative location for V2 target force
     * * RD(3) = relative location for V3 target force
     * * RD(4) = relative location for T target force
     * * RD(5) = relative location for M2 target force
     * * RD(6) = relative location for M3 target force
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the target forces are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadTargetForce(name: String, loadPat: String, dof: BooleanArrayByRef, f: DoubleArrayByRef, rd: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTargetForce", name, loadPat, dof, f, rd, itemType)

    /**
     * This function assigns advanced local axes to link objects.
     * @param name The name of an existing link object or group depending on the value of the ItemType item.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2, or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 1 (2 integers), indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param axPt, PlPt This is an array dimensioned to 1 (2 strings), indicating the labels of two joints that define the axis/plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 2.
     * @param axVect, PlVect This is an array dimensioned to 2 (3 doubles) that defines the axis/plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 3.
     * @param plane2 This is 12 or 13, indicating that the local plane determined by the plane reference vector is the 1-2 or 1-3 plane. This item applies only when the Active item is True.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected link objects and the Name item is ignored.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise, it returns a nonzero value.
     */
    fun setLocalAxesAdvanced(name: String, active: Boolean, axVectOpt: Int, axCSys: String, axDir: IntArrayByRef, axPt: StringArrayByRef, axVect: DoubleArrayByRef, plane2: Int, plVectOpt: Int, plCSys: String, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect, itemType)

    /**
     * This function assigns a local axis angle to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation or, if the Advanced item is True, from the orientation determined by the plane reference vector. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the local axis angle is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, ang: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, ang, itemType)

    /**
     * This function assigns a frequency dependent link property to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param propName This is either None or the name of a frequency dependent link property to be assigned to the specified link object(s). None means that no frequency dependent link property is assigned to the link object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the property is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setPropertyFD(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetPropertyFD", name, propName, itemType)

    /**
     * This function assigns a link property to link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param propName This is the name of a link property to be assigned to the specified link object(s).
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the link object specified by the Name item.
     * If this item is Group, the assignment is made to all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected link objects, and the Name item is ignored.
     * @return zero if the property is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setProperty(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetProperty", name, propName, itemType)

    /**
     * This function sets the selected status for link objects.
     * @param name The name of an existing link object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified link object is selected; otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the link object specified by the Name item.
     * If this item is Group, the selected status is set for all link objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected link objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set; otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)
}