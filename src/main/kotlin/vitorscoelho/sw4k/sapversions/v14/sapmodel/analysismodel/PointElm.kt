package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm
import vitorscoelho.sw4k.sapenums.PointElmConnectedType

interface PointElmV14 : SapComponent {
    /**
     * @return the total number of point elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * If the [name] item is provided, the [count] item returns the total number of constraint assignments made to the specified point element. If the [name] item is not specified or is specified as an empty string, the [count] item returns the total number of constraint assignments to all point elements in the model. If the [name] item is specified but it is not recognized by the program as a valid point element, an error is returned.
     * @param count The number of counted constraints.
     * @param name This optional item is the name of an existing point element.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countConstraint(count: IntByRef, name: String = ""): Int =
            callFunctionInt("CountConstraint", count, name)

    /**
     * If neither the [name] item nor the LoadPat item is provided, the [count] item returns the total number of ground displacement load assignments to point elements in the model.
     * If the [name] item is provided but not the LoadPat item, the [count] item returns the total number of ground displacement load assignments made for the specified point element.
     * If the [name] item is not provided but the LoadPat item is specified, the [count] item returns the total number of ground displacement load assignments made to all point elements for the specified load pattern.
     * If both the [name] item and the LoadPat item are provided, the [count] item returns the total number of ground displacement load assignments made to the specified point element for the specified load pattern.
     * If the [name] item or the LoadPat item is provided but is not recognized by the program as valid, an error is returned.
     * @param count The number of counted ground displacement loads.
     * @param name This optional item is the name of an existing point element.
     * @param loadPat This optional item is the name of an existing load pattern.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countLoadDispl(count: IntByRef, name: String = "", loadPat: String = ""): Int =
            callFunctionInt("CountLoadDispl", count, name, loadPat)

    /**
     * If neither the [name] item nor the LoadPat item is provided, the [count] item returns the total number of point load assignments to point elements in the model.
     * If the [name] item is provided but not the LoadPat item, the [count] item returns the total number of point load assignments made for the specified point element.
     * If the [name] item is not provided but the LoadPat item is specified, the [count] item returns the total number of point load assignments made to all point elements for the specified load pattern.
     * If both the [name] item and the LoadPat item are provided, the [count] item returns the total number of point load assignments made to the specified point element for the specified load pattern.
     * If the [name] item or the LoadPat item is provided but is not recognized by the program as valid, an error is returned.
     * @param count The number of counted point loads.
     * @param name This optional item is the name of an existing point element.
     * @param loadPat This optional item is the name of an existing load pattern.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countLoadForce(count: IntByRef, name: String = "", loadPat: String = ""): Int =
            callFunctionInt("CountLoadForce", count, name, loadPat)

    /**
     * @return the total number of point elements in the model with restraint assignments.
     */
    fun countRestraint(): Int =
            callFunctionInt("CountRestraint")

    /**
     * @return the total number of point elements in the model with spring assignments.
     */
    fun countSpring(): Int =
            callFunctionInt("CountSpring")

    /**
     * This function returns a list of elements connected to a specified point element.
     * @param name The name of an existing point element.
     * @param numberItems This is the total number of elements connected to the specified point element.
     * @param objectType This is an array that includes the element type of each element connected to the specified point element ([PointElmConnectedType] enumeration).
     * * 2 = Frame element
     * * 3 = Cable element
     * * 4 = Tendon element
     * * 5 = Area element
     * * 6 = Solid element
     * * 7 = Link element
     * @param objectName This is an array that includes the element name of each element connected to the specified point element.
     * @param pointNumber This is an array that includes the point number within the considered element that corresponds to the specified point element.
     * @return zero if the list is successfully filled; otherwise it returns nonzero.
     */
    fun getConnectivity(name: String, numberItems: IntByRef, objectType: IntArrayByRef, objectName: StringArrayByRef, pointNumber: IntArrayByRef): Int =
            callFunctionInt("GetConnectivity", name, numberItems, objectType, objectName, pointNumber)

    /**
     * Get a list of constraint assignments made to one or more specified point elements.
     * @param name The name of an existing point object, point element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems This is the total number of constraint assignments returned.
     * @param pointName This is an array that includes the name of the point element to which the specified constraint assignment applies.
     * @param constraintName This is an array that includes the name of the constraint that is assigned to the point element specified by the Point[name] item.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * If this item is ObjectElm, the constraint assignments are retrieved for the point element corresponding to the point object specified by the [name] item.
     * If this item is Element, the constraint assignments are retrieved for the point element specified by the [name] item.
     * If this item is GroupElm, the constraint assignments are retrieved for all point elements directly or indirectly specified in the group specified by the [name] item.
     * If this item is SelectionElm, the constraint assignments are retrieved for all point elements directly or indirectly selected, and the [name] item is ignored.
     * See Item Type for Elements for more information.
     * @return zero if the constraint name list is successfully filled, otherwise it returns nonzero.
     */
    fun getConstraint(name: String, numberItems: IntByRef, pointName: StringArrayByRef, constraintName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetConstraint", name, numberItems, pointName, constraintName, itemTypeElm)

    /**
     * @param name The name of an existing point element.
     * @param x The X-coordinate of the specified point element in the specified coordinate system. (L)
     * @param y The Y-coordinate of the specified point element in the specified coordinate system. (L)
     * @param z The Z-coordinate of the specified point element in the specified coordinate system. (L)
     * @param cSys The name of the coordinate system in which the joint coordinates are returned.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the x, y and z coordinates of the specified point element in the Present Units. The coordinates are reported in the coordinate system specified by CSys.
     */
    fun getCoordCartesian(name: String, x: DoubleByRef, y: DoubleByRef, z: DoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordCartesian", name, x, y, z, cSys)

    /**
     * @param name The name of an existing point element.
     * @param r The radius for the point element in the specified coordinate system. (L)
     * @param theta The angle for the specified point element in the specified coordinate system. The angle is measured in the XY plane from the positive X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive Theta angle is counter clockwise. (deg)
     * @param z The Z-coordinate of the specified point element in the specified coordinate system. (L)
     * @param cSys The name of the coordinate system in which the joint coordinates are returned.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the r, Theta and z coordinates of the specified point element in the Present Units. The coordinates are reported in the coordinate system specified by CSys.
     */
    fun getCoordCylindrical(name: String, r: DoubleByRef, theta: DoubleByRef, z: DoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordCylindrical", name, r, theta, z, cSys)

    /**
     * @param name The name of an existing point element.
     * @param r The radius for the point element in the specified coordinate system. (L)
     * @param a The plan angle for the point element in the specified coordinate system. This angle is measured in the XY plane from the positive global X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive a angle is counter clockwise. (deg)
     * @param b The elevation angle for the point element in the specified coordinate system. This angle is measured in an X'Z plane that is perpendicular to the XY plane with the positive X' axis oriented at angle a from the positive global X axis. Angle b is measured from the positive global Z axis. When looking in the X�Z plane with the positive Y' axis pointing toward you, a positive b angle is counter clockwise. (deg)
     * @param cSys The name of the coordinate system in which the joint coordinates are returned.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the r, a and b coordinates of the specified point element in the Present Units. The coordinates are reported in the coordinate system specified by CSys.
     */
    fun getCoordSpherical(name: String, r: DoubleByRef, a: DoubleByRef, b: DoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordSpherical", name, r, a, b, cSys)

    /**
     * This function retrieves the ground displacement load assignments to point elements.
     * @param name The name of an existing point object, point element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems This is the total number of joint ground displacement assignments returned.
     * @param pointName This is an array that includes the name of the point element to which the specified ground displacement assignment applies.
     * @param loadPat This is an array that includes the name of the load pattern for the ground displacement load.
     * @param lCStep This is an array that includes the load pattern step for the ground displacement load. In most cases, this item does not apply and will be returned as 0.
     * @param cSys This is an array that includes the name of the coordinate system for the ground displacement load. This is either Local or the name of a defined coordinate system.
     * @param u1 This is an array that includes the assigned translational ground displacement in the local 1-axis or coordinate system X-axis direction, depending on the specified CSys. (L)
     * @param u2 This is an array that includes the assigned translational ground displacement in the local 2-axis or coordinate system Y-axis direction, depending on the specified CSys. (L)
     * @param u3 This is an array that includes the assigned translational ground displacement in the local 3-axis or coordinate system Z-axis direction, depending on the specified CSys. (L)
     * @param r1 This is an array that includes the assigned rotational ground displacement about the local 1-axis or coordinate system X-axis, depending on the specified CSys. (rad)
     * @param r2 This is an array that includes the assigned rotational ground displacement about the local 2-axis or coordinate system Y-axis, depending on the specified CSys. (rad)
     * @param r3 This is an array that includes the assigned rotational ground displacement about the local 3-axis or coordinate system Z-axis, depending on the specified CSys. (rad)
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * If this item is ObjectElm, the ground displacement assignments are retrieved for the point element corresponding to the point object specified by the [name] item.
     * If this item is Element, the ground displacement assignments are retrieved for the point element specified by the [name] item.
     * If this item is GroupElm, the ground displacement assignments are retrieved for all point elements directly or indirectly specified in the group specified by the [name] item.
     * If this item is SelectionElm, the ground displacement assignments are retrieved for all point elements directly or indirectly selected, and the [name] item is ignored.
     * See Item Type for Elements for more information.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDispl(name: String, numberItems: IntByRef, pointName: StringArrayByRef, loadPat: StringArrayByRef, lCStep: IntArrayByRef, cSys: StringArrayByRef, u1: DoubleArrayByRef, u2: DoubleArrayByRef, u3: DoubleArrayByRef, r1: DoubleArrayByRef, r2: DoubleArrayByRef, r3: DoubleArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadDispl", name, numberItems, pointName, loadPat, lCStep, cSys, u1, u2, u3, r1, r2, r3, itemTypeElm)

    /**
     * This function retrieves the joint force load assignments to point elements.
     * @param name The name of an existing point object, point element, or group of objects, depending on the value of the ItemTypeElm item.
     * @param numberItems This is the total number of joint force load assignments returned.
     * @param pointName This is an array that includes the name of the point element to which the specified load assignment applies.
     * @param loadPat This is an array that includes the name of the load pattern for the load.
     * @param lCStep This is an array that includes the load pattern step for the load. In most cases this item does not apply and will be returned as 0.
     * @param cSys This is an array that includes the name of the coordinate system for the load. This is either Local or the name of a defined coordinate system.
     * @param f1 This is an array that includes the assigned translational force in the local 1-axis or coordinate system X-axis direction, depending on the specified CSys. (F)
     * @param f2 This is an array that includes the assigned translational force in the local 2-axis or coordinate system Y-axis direction, depending on the specified CSys. (F)
     * @param f3 This is an array that includes the assigned translational force in the local 3-axis or coordinate system Z-axis direction, depending on the specified CSys. (F)
     * @param m1 This is an array that includes the assigned moment about the local 1-axis or coordinate system X-axis, depending on the specified CSys. (FL)
     * @param m2 This is an array that includes the assigned moment about the local 2-axis or coordinate system Y-axis, depending on the specified CSys. (FL)
     * @param m3 This is an array that includes the assigned moment about the local 3-axis or coordinate system Z-axis, depending on the specified CSys. (FL)
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the point element corresponding to the point object specified by the [name] item.
     * If this item is Element, the load assignments are retrieved for the point element specified by the [name] item.
     * If this item is GroupElm, the load assignments are retrieved for all point elements directly or indirectly specified in the group specified by the [name] item.
     * If this item is SelectionElm, the load assignments are retrieved for all point elements directly or indirectly selected and the [name] item is ignored.
     * See Item Type for Elements for more information.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadForce(name: String, numberItems: IntByRef, pointName: StringArrayByRef, loadPat: StringArrayByRef, lCStep: IntArrayByRef, cSys: StringArrayByRef, f1: DoubleArrayByRef, f2: DoubleArrayByRef, f3: DoubleArrayByRef, m1: DoubleArrayByRef, m2: DoubleArrayByRef, m3: DoubleArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadForce", name, numberItems, pointName, loadPat, lCStep, cSys, f1, f2, f3, m1, m2, m3, itemTypeElm)

    /**
     * This function retrieves the local axes angles for a point element.
     * @param name The name of an existing point element.
     * @param a, b, c The local axes of the point are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @return zero if the local axes angles are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, a: DoubleByRef, b: DoubleByRef, c: DoubleByRef): Int =
            callFunctionInt("GetLocalAxes", name, a, b, c)

    /**
     * This function retrieves the merge number for a point element. By default the merge number for a point is zero. Points with different merge numbers are not automatically merged by the program.
     * @param name The name of an existing point element.
     * @param mergeNumber The merge number assigned to the specified point element.
     * @return zero if the merge number is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMergeNumber(name: String, mergeNumber: IntByRef): Int =
            callFunctionInt("GetMergeNumber", name, mergeNumber)

    /**
     * This function retrieves the names of all defined point elements.
     * @param numberNames The number of point element names retrieved by the program.
     * @param myName This is a one-dimensional array of point element names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the object or defined item associated with a specified point element.
     * @param name The name of an existing point element.
     * @param obj The name of the object or defined item associated with the specified point element. The type of object or item is determined from the ObjType variable.
     * @param objType A number indicating the type of object or defined item that is associated with the point element.
     * * 1: Obj is the point object corresponding to the specified point element.
     * * 2: Obj is a line object that is internally meshed by the program to create the specified point element.
     * * 3: Obj is an area object that is internally meshed by the program to create the specified point element.
     * * 6: Obj is a solid object that is internally meshed by the program to create the specified point element.
     * * 9: Obj is a point object that has a panel zone assignment. The specified point element is internally added by the program at the point object (panel zone) location to model the panel zone. The specified point element does not directly correspond to the point object returned; it is an added point at the same location as the point object.
     * * 21: Obj is a defined diaphragm constraint. The specified point element was internally added by the program for application of auto wind and auto seismic loads.
     * @return zero if the object is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getObj(name: String, obj: StringByRef, objType: IntByRef): Int =
            callFunctionInt("GetObj", name, obj, objType)

    /**
     * This function retrieves the joint pattern value for a specific point element and joint pattern.
     * Joint pattern values are unitless.
     * @param name The name of an existing point element.
     * @param patternName The name of a defined joint pattern.
     * @param value The value that the specified point element has for the specified joint pattern.
     * @return zero if the value is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPatternValue(name: String, patternName: String, value: DoubleByRef): Int =
            callFunctionInt("GetPatternValue", name, patternName, value)

    /**
     * This function retrieves the restraint assignments for a point element. The restraint assignments are always returned in the point local coordinate system.
     * @param name The name of an existing point element.
     * @param value This is an array of six restraint values.
     * * Value(0) = U1
     * * Value(1) = U2
     * * Value(2) = U3
     * * Value(3) = R1
     * * Value(4) = R2
     * * Value(5) = R3
     * @return zero if the restraint assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getRestraint(name: String, value: BooleanArrayByRef): Int =
            callFunctionInt("GetRestraint", name, value)

    /**
     * This function retrieves coupled spring stiffness assignments for a point element.
     * The spring stiffnesses reported are the sum of all springs assigned to the point element either directly or indirectly through line, area and solid spring assignments. The spring stiffness values are reported in the point local coordinate system.
     * @param name The name of an existing point element.
     * @param k This is an array of twenty one spring stiffness values.
     * * Value(0) = U1U1 (F/L)
     * * Value(1) = U1U2 (F/L)
     * * Value(2) = U2U2 (F/L)
     * * Value(3) = U1U3 (F/L)
     * * Value(4) = U2U3 (F/L)
     * * Value(5) = U3U3 (F/L)
     * * Value(6) = U1R1 [F/rad]
     * * Value(7) = U2R1 [F/rad]
     * * Value(8) = U3R1 [F/rad]
     * * Value(9) = R1R1 (FL/rad)
     * * Value(10) = U1R2 [F/rad]
     * * Value(11) = U2R2 [F/rad]
     * * Value(12) = U3R2 [F/rad]
     * * Value(13) = R1R2 (FL/rad)
     * * Value(14) = R2R2 (FL/rad)
     * * Value(15) = U1R3 [F/rad]
     * * Value(16) = U2R3 [F/rad]
     * * Value(17) = U3R3 [F/rad]
     * * Value(18) = R1R3 (FL/rad)
     * * Value(19) = R2R3 (FL/rad)
     * * Value(20) = R3R3 (FL/rad)
     * @return zero if the stiffnesses are successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point element, the function returns a nonzero value.
     */
    fun getSpringCoupled(name: String, k: DoubleArrayByRef): Int =
            callFunctionInt("GetSpringCoupled", name, k)

    /**
     * This function retrieves uncoupled spring stiffness assignments for a point element; that is, it retrieves the diagonal terms in the 6x6 spring matrix for the point element.
     * The spring stiffnesses reported are the sum of all springs assigned to the point element either directly or indirectly through line, area and solid spring assignments. The spring stiffness values are reported in the point local coordinate system.
     * @param name The name of an existing point element.
     * @param k This is an array of six spring stiffness values.
     * * Value(0) = U1 (F/L)
     * * Value(1) = U2 (F/L)
     * * Value(2) = U3 (F/L)
     * * Value(3) = R1 (FL/rad)
     * * Value(4) = R2 (FL/rad)
     * * Value(5) = R3 (FL/rad)
     * @return zero if the stiffnesses are successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point element, the function returns a nonzero value.
     */
    fun getSpring(name: String, k: DoubleArrayByRef): Int =
            callFunctionInt("GetSpring", name, k)

    /**
     * @param name The name of an existing point element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the point element local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array; (Local1, Local2, Local3) are an item (such as a point load) in the point element local coordinate system; and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetTransformationMatrix", name, value)

    /**
     * This function indicates if the spring assignments to a point element are coupled, that is, if there are off-diagonal terms in the 6x6 spring matrix for the point element.
     * @param name The name of an existing point element.
     * @param isCoupled This item is True if the spring assignment to the specified point element is coupled, otherwise it is False.
     * @return zero if the coupled status is successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point object, the function returns a nonzero value.
     */
    fun isSpringCoupled(name: String, isCoupled: Boolean): Int =
            callFunctionInt("IsSpringCoupled", name, isCoupled)
}