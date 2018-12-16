package vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface PointObjV14 : SapComponent {
    /**
     * This function adds a point object to a model. The added point object will be tagged as a Special Point except if it was merged with another point object. Special points are allowed to exist in the model with no objects connected to them.
     * @param x The X-coordinate of the added point object in the specified coordinate system. (L)
     * @param y The Y-coordinate of the added point object in the specified coordinate system. (L)
     * @param z The Z-coordinate of the added point object in the specified coordinate system. (L)
     * @param name This is the name that the program ultimately assigns for the point object. If no UserName is specified, the program assigns a default name to the point object. If a UserName is specified and that name is not used for another point, the UserName is assigned to the point; otherwise a default name is assigned to the point.
     * If a point is merged with another point, this will be the name of the point object with which it was merged.
     * @param userName This is an optional user specified name for the point object. If a UserName is specified and that name is already used for another point object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the joint coordinates are defined.
     * @param mergeOff If this item is False, a new point object that is added at the same location as an existing point object will be merged with the existing point object (assuming the two point objects have the same MergeNumber) and thus only one point object will exist at the location.
     * If this item is True, the points will not merge and two point objects will exist at the same location.
     * @param mergeNumber Two points objects in the same location will merge only if their merge number assignments are the same. By default all pointobjects have a merge number of zero.
     * @return zero if the point object is successfully added or merged, otherwise it returns a nonzero value.
     */
    fun addCartesian(x: Double, y: Double, z: Double, name: AStringByRef = StringByRef.UNNECESSARY, userName: String = "", cSys: String = "Global", mergeOff: Boolean = false, mergeNumber: Int = 0): Int =
            callFunctionInt("AddCartesian", x, y, z, name, userName, cSys, mergeOff, mergeNumber)

    /**
     * This function adds a point object to a model. The added point object will be tagged as a Special Point except if it was merged with another point object. Special points are allowed to exist in the model with no objects connected to them
     * @param r The radius for the added point object in the specified coordinate system. (L)
     * @param theta The angle for the added point object in the specified coordinate system. The angle is measured in the XY plane from the positive global X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive Theta angle is counter clockwise. (deg)
     * @param z The Z-coordinate of the added point object in the specified coordinate system. (L)
     * @param name This is the name that the program ultimately assigns for the point object. If no UserName is specified, the program assigns a default name to the point object. If a UserName is specified and that name is not used for another point, the UserName is assigned to the point; otherwise a default name is assigned to the point.
     * If a point is merged with another point, this will be the name of the point object with which it was merged.
     * @param userName This is an optional user specified name for the point object. If a UserName is specified and that name is already used for another point object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the joint coordinates are defined.
     * @param mergeOff If this item is False, a new point object that is added at the same location as an existing point object will be merged with the existing point object (assuming the two point objects have the same MergeNumber) and thus only one point object will exist at the location.
     * If this item is True, the points will not merge and two point objects will exist at the same location.
     * @param mergeNumber Two points objects in the same location will merge only if their merge number assignments are the same. By default all pointobjects have a merge number of zero.
     * @return zero if the point object is successfully added or merged, otherwise it returns a nonzero value.
     */
    fun addCylindrical(r: Double, theta: Double, z: Double, name: AStringByRef = StringByRef.UNNECESSARY, userName: String = "", cSys: String = "Global", mergeOff: Boolean = false, mergeNumber: Int = 0): Int =
            callFunctionInt("AddCylindrical", r, theta, z, name, userName, cSys, mergeOff, mergeNumber)

    /**
     * This function adds a point object to a model. The added point object will be tagged as a Special Point except if it was merged with another point object. Special points are allowed to exist in the model with no objects connected to them
     * @param r The radius for the added point object in the specified coordinate system. (L)
     * @param a The plan angle for the added point object in the specified coordinate system. This angle is measured in the XY plane from the positive global X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive a angle is counterclockwise. (deg)
     * @param b The elevation angle for the added point object in the specified coordinate system. This angle is measured in an X'Z plane that is perpendicular to the XY plane with the positive X' axis oriented at angle a from the positive global X axis. Angle b is measured from the positive global Z axis. When looking in the X�Z plane with the positive Y' axis pointing toward you, a positive b angle is counter clockwise. (deg)
     * @param name This is the name that the program ultimately assigns for the point object. If no UserName is specified, the program assigns a default name to the point object. If a UserName is specified and that name is not used for another point, the UserName is assigned to the point; otherwise a default name is assigned to the point.
     * If a point is merged with another point, this will be the name of the point object with which it was merged.
     * @param userName This is an optional user specified name for the point object. If a UserName is specified and that name is already used for another point object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the joint coordinates are defined.
     * @param mergeOff If this item is False, a new point object that is added at the same location as an existing point object will be merged with the existing point object (assuming the two point objects have the same MergeNumber) and thus only one point object will exist at the location.
     * If this item is True, the points will not merge and two point objects will exist at the same location.
     * @param mergeNumber Two points objects in the same location will merge only if their merge number assignments are the same. By default all pointobjects have a merge number of zero.
     * @return zero if the point object is successfully added or merged, otherwise it returns a nonzero value.
     */
    fun addSpherical(r: Double, a: Double, b: Double, name: AStringByRef = StringByRef.UNNECESSARY, userName: String = "", cSys: String = "Global", mergeOff: Boolean = false, mergeNumber: Int = 0): Int =
            callFunctionInt("AddSpherical", r, a, b, name, userName, cSys, mergeOff, mergeNumber)

    /**
     * @param name The existing name of a point object.
     * @param newName The new name for the point object.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * If the Name item is provided, the Count item returns the total number of constraint assignments made to the specified point object. If the Name item is not specified, or is specified as an empty string, the Count item returns the total number of constraint assignments to all point objects in the model. If the Name item is specified but it is not recognized by the program as a valid point object, an error is returned.
     * @param count The number of counted constraints.
     * @param name This optional item is the name of an existing point object.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countConstraint(count: AIntByRef, name: String = ""): Int =
            callFunctionInt("CountConstraint", count, name)

    /**
     * If neither the Name item nor the LoadPat item is provided, the Count item returns the total number of ground displacement load assignments in the model.
     * If the Name item is provided but not the LoadPat item, the Count item returns the total number of ground displacement load assignments made for the specified point object.
     * If the Name item is not provided but the LoadPat item is specified, the Count item returns the total number of ground displacement load assignments made to all point objects for the specified load pattern.
     * If both the Name item and the LoadPat item are provided, the Count item returns the total number of ground displacement load assignments made to the specified point object for the specified load pattern.
     * If the Name item or the LoadPat item is provided but is not recognized by the program as valid, an error is returned.
     * @param count The number of counted ground displacement loads.
     * @param name This optional item is the name of an existing point object.
     * @param loadPat This optional item is the name of an existing load pattern.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countLoadDispl(count: AIntByRef, name: String = "", loadPat: String = ""): Int =
            callFunctionInt("CountLoadDispl", count, name, loadPat)

    /**
     * If neither the Name item nor the LoadPat item is provided, the Count item returns the total number of point load assignments in the model.
     * If the Name item is provided but not the LoadPat item, the Count item returns the total number of point load assignments made for the specified point object.
     * If the Name item is not provided but the LoadPat item is specified, the Count item returns the total number of point load assignments made to all point objects for the specified load pattern.
     * If both the Name item and the LoadPat item are provided,n the Count item returns the total number of point load assignments made to the specified point object for the specified load pattern.
     * If the Name item or the LoadPat item is provided but is not recognized by the program as valid, an error is returned.
     * @param count The number of counted point loads.
     * @param name This optional item is the name of an existing point object.
     * @param loadPat This optional item is the name of an existing load pattern.
     * @return zero if the count is successfully completed, otherwise it returns a nonzero value.
     */
    fun countLoadForce(count: AIntByRef, name: String = "", loadPat: String = ""): Int =
            callFunctionInt("CountLoadForce", count, name, loadPat)

    /**
     * @return the total number of panel zone assignments to point objects in the model.
     */
    fun countPanelZone(): Int =
            callFunctionInt("CountPanelZone")

    /**
     * @return the total number of point objects in the model with restraint assignments.
     */
    fun countRestraint(): Int =
            callFunctionInt("CountRestraint")

    /**
     * @return the total number of point objects in the model with spring assignments.
     */
    fun countSpring(): Int =
            callFunctionInt("CountSpring")

    /**
     * @return the total number of point objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes all constraint assignments from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object and the constraint assignments to that point object are removed.
     * If Group is selected, the Name item refers to a group and the constraint assignments to all point objects in the group are removed.
     * If SelectedObjects is selected, the Name item is ignored and the constraint assignments to all selected point objects are removed.
     * @return zero if the constraint assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteConstraint(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteConstraint", name, itemType)

    /**
     * This function deletes all ground displacement load assignments, for the specified load pattern, from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The ground displacement load assignments, for the specified load case, made to that point object, are removed.
     * If Group is selected, the Name item refers to a group. The ground displacement load assignments, for the specified load pattern, made to all point objects in the group, are removed.
     * If SelectedObjects is selected, the Name item is ignored. The ground displacement load assignments, for the specified load pattern, made to all selected point objects, are removed.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDispl(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDispl", name, loadPat, itemType)

    /**
     * This function deletes all point load assignments, for the specified load pattern, from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The point load assignments, for the specified load pattern, made to that point object, are removed.
     * If Group is selected, the Name item refers to a group. The point load assignments, for the specified load pattern, made to all point objects in the group, are removed.
     * If SelectedObjects is selected, the Name item is ignored. The point load assignments, for the specified load pattern, made to all selected point objects, are removed.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadForce(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadForce", name, loadPat, itemType)

    /**
     * This function deletes all mass assignments from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The mass assignments for that point object are removed.
     * If Group is selected, the Name item refers to a group. The mass assignments for all point objects in the group are removed.
     * If SelectedObjects is selected, the Name item is ignored. The mass assignments for all selected point objects are removed.
     * @return zero if the mass assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteMass(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteMass", name, itemType)

    /**
     * This function deletes all panel zone assignments from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The panel zone assignments for that point object are removed.
     * If Group is selected, the Name item refers to a group. The panel zone assignments for all point objects in the group are removed.
     * If SelectedObjects is selected, the Name item is ignored. The panel zone assignments for all selected point objects are removed.
     * @return zero if the panel zone assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deletePanelZone(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeletePanelZone", name, itemType)

    /**
     * This function deletes all joint pattern assignments, associated with the specified joint pattern, from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param patternName The name of a defined joint pattern.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The joint pattern assignments, associated with the specified joint pattern, for that point object are removed.
     * If Group is selected, the Name item refers to a group. The joint pattern assignments, associated with the specified joint pattern, for all point objects in the group, are removed.
     * If SelectedObjects is selected, the Name item is ignored. The joint pattern assignments, associated with the specified joint pattern, for all selected point objects, are removed.
     * @return zero if the joint pattern assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deletePatternValue(name: String, patternName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeletePatternValue", name, patternName, itemType)

    /**
     * This function deletes all restraint assignments from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The restraint assignments for that point object are removed.
     * If Group is selected, the Name item refers to a group. The restraint assignments for all point objects in the group are removed.
     * If SelectedObjects is selected, the Name item is ignored. The restraint assignments for all selected point objects are removed.
     * @return zero if the restraint assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteRestraint(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteRestraint", name, itemType)

    /**
     * The function deletes special point objects that have no other objects connected to them.
     * Point objects can be deleted only if they have no other objects (e.g., frame, cable, tendon, area, solid link) connected to them. If a point object is not specified to be a Special Point, the program automatically deletes that point object when it has no other objects connected to it. If a point object is specified to be a Special Point, to delete it, first delete all other objects connected to the point and then call this function to delete the point.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the deletion applies to the point object specified by the Name item.
     * If this item is Group, the deletion applies to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the deletion applies to all selected point objects, and the Name item is ignored.
     * @return zero if the function completes successfully, otherwise it returns a nonzero value.
     */
    fun deleteSpecialPoint(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteSpecialPoint", name, itemType)

    /**
     * This function deletes all point spring assignments from the specified point object(s).
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param itemType This is one of the following items from the [ItemType] enumeration.
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If Object is selected, the Name item refers to a point object. The point spring assignments for that point object are removed.
     * If Group is selected, the Name item refers to a group. The point spring assignments for all point objects in the group are removed.
     * If SelectedObjects is selected, the Name item is ignored. The point spring assignments for all selected point objects are removed.
     * @return zero if the restraint assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteSpring(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteSpring", name, itemType)

    /**
     * This function returns the total number of objects (line, area, solid and link) that connect to the specified point object.
     * @param name The name of a point object or a group depending on the value selected for ItemType item.
     * @param commonTo The total number of objects (line, area, solid and link) that connect to the specified point object.
     * @return zero if the CommonTo is successfully calculated, otherwise it returns a nonzero value.
     */
    fun getCommonTo(name: String, commonTo: AIntByRef): Int =
            callFunctionInt("GetCommonTo", name, commonTo)

    /**
     * This function returns a list of objects connected to a specified point object.
     * @param name The name of an existing point object.
     * @param numberItems This is the total number of objects connected to the specified point object.
     * @param objectType This is an array that includes the object type of each object connected to the specified point object.
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * 7 = Link object
     * @param objectName This is an array that includes the object name of each object connected to the specified point object.
     * @param pointNumber This is an array that includes the point number within the considered object that corresponds to the specified point object.
     * @return zero if the list is successfully filled; otherwise it returns nonzero.
     */
    fun getConnectivity(name: String, numberItems: AIntByRef, objectType: AIntArrayByRef, objectName: AStringArrayByRef, pointNumber: AIntArrayByRef): Int =
            callFunctionInt("GetConnectivity", name, numberItems, objectType, objectName, pointNumber)

    /**
     * This function returns a list of constraint assignments made to one or more specified point objects.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param numberItems This is the total number of constraint assignments returned.
     * @param pointName This is an array that includes the name of the point object to which the specified constraint assignment applies.
     * @param constraintName This is an array that includes the name of the constraint that is assigned to the point object specified by the PointName item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the constraint assignments are retrieved for the point object specified by the Name item.
     * If this item is Group, the constraint assignments are retrieved for all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the constraint assignments are retrieved for all selected point objects and the Name item is ignored.
     * @return zero if the constraint name list is successfully filled, otherwise it returns nonzero.
     */
    fun getConstraint(name: String, numberItems: AIntByRef, pointName: AStringArrayByRef, constraintName: AStringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetConstraint", name, numberItems, pointName, constraintName, itemType)

    /**
     * @param name The name of a defined point object.
     * @param x The X-coordinate of the specified point object in the specified coordinate system. (L)
     * @param y The Y-coordinate of the specified point object in the specified coordinate system. (L)
     * @param z The Z-coordinate of the specified point object in the specified coordinate system. (L)
     * @param cSys The name of a defined coordinate system. If Csys is not specified, the Global coordinate system is assumed.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the x, y and z coordinates of the specified point object in the Present Units. The coordinates are reported in the coordinate system specified by Csys
     */
    fun getCoordCartesian(name: String, x: ADoubleByRef, y: ADoubleByRef, z: ADoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordCartesian", name, x, y, z, cSys)

    /**
     * @param name The name of a defined point object.
     * @param r The radius for the specified point object in the specified coordinate system. (L)
     * @param theta The angle for the specified point object in the specified coordinate system. The angle is measured in the XY plane from the positive X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive Theta angle is counter clockwise [deg]
     * @param z The Z-coordinate of the specified point object in the specified coordinate system. (L)
     * @param cSys The name of a defined coordinate system. If Csys is not specified, the Global coordinate system is assumed.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the r, theta and z coordinates of the specified point object in the Present Units. The coordinates are reported in the coordinate system specified by CSys.
     */
    fun getCoordCylindrical(name: String, r: ADoubleByRef, theta: ADoubleByRef, z: ADoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordCylindrical", name, r, theta, z, cSys)

    /**
     * @param name The name of an existing point object.
     * @param r The radius for the point object in the specified coordinate system. (L)
     * @param a The plan angle for the point object in the specified coordinate system. This angle is measured in the XY plane from the positive global X axis. When looking in the XY plane with the positive Z axis pointing toward you, a positive a angle is counter clockwise. (deg)
     * @param b The elevation angle for the point object in the specified coordinate system. This angle is measured in an X'Z plane that is perpendicular to the XY plane with the positive X' axis oriented at angle a from the positive global X axis. Angle b is measured from the positive global Z axis. When looking in the X�Z plane with the positive Y' axis pointing toward you, a positive b angle is counter clockwise. (deg)
     * @param cSys The name of the coordinate system in which the joint coordinates are returned.
     * @return zero if the coordinates are successfully returned; otherwise it returns nonzero. If successful, the function returns the r, a and b coordinates of the specified point object in the Present Units. The coordinates are reported in the coordinate system specified by CSys.
     */
    fun getCoordSpherical(name: String, r: ADoubleByRef, a: ADoubleByRef, b: ADoubleByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCoordSpherical", name, r, a, b, cSys)

    /**
     * This function retrieves the name of the point element (analysis model point) associated with a specified point object in the object-based model.
     * @param name The name of an existing point object.
     * @param elm The name of the point element associated with the specified point object.
     * @return zero if the point element name is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not currently exist.
     */
    fun getElm(name: String, elm: AStringByRef): Int =
            callFunctionInt("GetElm", name, elm)

    /**
     * This function retrieves the GUID for specified point object.
     * @param name The name of an existing point object.
     * @param GUID The GUID (Global Unique ID) for the specified point object.
     * @return zero if the point object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: AStringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves the ground displacement load assignments to point objects.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param numberItems This is the total number of joint ground displacement assignments returned.
     * @param pointName This is an array that includes the name of the point object to which the specified ground displacement assignment applies.
     * @param loadPat This is an array that includes the name of the load pattern for the ground displacement load.
     * @param lCStep This is an array that includes the load pattern step for the ground displacement load. In most cases, this item does not apply and will be returned as 0.
     * @param cSys This is an array that includes the name of the coordinate system for the ground displacement load. This is Local or the name of a defined coordinate system.
     * @param u1 This is an array that includes the assigned translational ground displacement in the local 1-axis or coordinate system X-axis direction, depending on the specified CSys. (L)
     * @param u2 This is an array that includes the assigned translational ground displacement in the local 2-axis or coordinate system Y-axis direction, depending on the specified CSys. (L)
     * @param u3 This is an array that includes the assigned translational ground displacement in the local 3-axis or coordinate system Z-axis direction, depending on the specified CSys. (L)
     * @param r1 This is an array that includes the assigned rotational ground displacement about the local 1-axis or coordinate system X-axis, depending on the specified CSys. (rad)
     * @param r2 This is an array that includes the assigned rotational ground displacement about the local 2-axis or coordinate system Y-axis, depending on the specified CSys. (rad)
     * @param r3 This is an array that includes the assigned rotational ground displacement about the local 3-axis or coordinate system Z-axis, depending on the specified CSys. (rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are retrieved for the point object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are retrieved for all selected point objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDispl(name: String, numberItems: AIntByRef, pointName: AStringArrayByRef, loadPat: AStringArrayByRef, lCStep: AIntArrayByRef, cSys: AStringArrayByRef, u1: ADoubleArrayByRef, u2: ADoubleArrayByRef, u3: ADoubleArrayByRef, r1: ADoubleArrayByRef, r2: ADoubleArrayByRef, r3: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDispl", name, numberItems, pointName, loadPat, lCStep, cSys, u1, u2, u3, r1, r2, r3, itemType)

    /**
     * This function retrieves the joint force load assignments to point objects.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param numberItems This is the total number of joint force load assignments returned.
     * @param pointName This is an array that includes the name of the point object to which the specified load assignment applies.
     * @param loadPat This is an array that includes the name of the load pattern for the load.
     * @param lCStep This is an array that includes the load pattern step for the load. In most cases, this item does not apply and will be returned as 0.
     * @param cSys This is an array that includes the name of the coordinate system for the load. This is Local or the name of a defined coordinate system.
     * @param f1 This is an array that includes the assigned translational force in the local 1-axis or coordinate system X-axis direction, depending on the specified CSys. (F)
     * @param f2 This is an array that includes the assigned translational force in the local 2-axis or coordinate system Y-axis direction, depending on the specified CSys. (F)
     * @param f3 This is an array that includes the assigned translational force in the local 3-axis or coordinate system Z-axis direction, depending on the specified CSys. (F)
     * @param m1 This is an array that includes the assigned moment about the local 1-axis or coordinate system X-axis, depending on the specified CSys. (FL)
     * @param m2 This is an array that includes the assigned moment about the local 2-axis or coordinate system Y-axis, depending on the specified CSys. (FL)
     * @param m3 This is an array that includes the assigned moment about the local 3-axis or coordinate system Z-axis, depending on the specified CSys. (FL)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are retrieved for the point object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are retrieved for all selected point objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadForce(name: String, numberItems: AIntByRef, pointName: AStringArrayByRef, loadPat: AStringArrayByRef, lCStep: AIntArrayByRef, cSys: AStringArrayByRef, f1: ADoubleArrayByRef, f2: ADoubleArrayByRef, f3: ADoubleArrayByRef, m1: ADoubleArrayByRef, m2: ADoubleArrayByRef, m3: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadForce", name, numberItems, pointName, loadPat, lCStep, cSys, f1, f2, f3, m1, m2, m3, itemType)

    /**
     * This function assigns advanced local axes to point objects.
     * @param name The name of an existing point object.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2, or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 2 (2 integers), indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param axPt, PlPt This is an array dimensioned to 2 (2 strings), indicating the labels of two joints that define the axis/plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 2.
     * @param axVect, PlVect This is an array dimensioned to 3 (3 doubles) that defines the axis/plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 3.
     * @param plane2 This is 12, 13, 21, 23, 31 or 32, indicating that the local plane determined by the plane reference vector is the 1-2, 1-3, 2-1, 2-3, 3-1, or 3-2 plane. This item applies only when the Active item is True.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun getLocalAxesAdvanced(name: String, active: ABooleanByRef, axVectOpt: AIntByRef, axCSys: AStringByRef, axDir: AIntArrayByRef, axPt: AStringArrayByRef, axVect: ADoubleArrayByRef, plane2: AIntByRef, plVectOpt: AIntByRef, plCSys: AStringByRef, plDir: AIntArrayByRef, plPt: AStringArrayByRef, plVect: ADoubleArrayByRef): Int =
            callFunctionInt("GetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect)

    /**
     * This function retrieves the local axes angles for a point object.
     * @param name The name of an existing point object.
     * @param a, b, c The local axes of the point are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @param advanced This item is True if the point object local axes orientation was obtained using advanced local axes parameters.
     * @return zero if the local axes angles are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, a: ADoubleByRef, b: ADoubleByRef, c: ADoubleByRef, advanced: ABooleanByRef): Int =
            callFunctionInt("GetLocalAxes", name, a, b, c, advanced)

    /**
     * This function retrieves the point mass assignment values for a point object. The masses are always returned in the point local coordinate system.
     * @param name The name of an existing point object.
     * @param m This is an array of six mass assignment values.
     * * Value(0) = U1 (M)
     * * Value(1) = U2 (M)
     * * Value(2) = U3 (M)
     * * Value(3) = R1 (ML2)
     * * Value(4) = R2 (ML2)
     * * Value(5) = R3 (ML2)
     * @return zero if the mass is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMass(name: String, m: ADoubleArrayByRef): Int =
            callFunctionInt("GetMass", name, m)

    /**
     * This function retrieves the merge number for a point object. By default the merge number for a point is zero. Points with different merge numbers are not automatically merged by the program.
     * @param name The name of an existing point object.
     * @param mergeNumber The merge number assigned to the specified point object.
     * @return zero if the merge number is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMergeNumber(name: String, mergeNumber: AIntByRef): Int =
            callFunctionInt("GetMergeNumber", name, mergeNumber)

    /**
     * This function retrieves the names of all defined point objects.
     * @param numberNames The number of point object names retrieved by the program.
     * @param myName This is a one-dimensional array of point object names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the panel zone assignment data for a point object.
     * @param name The name of an existing point object.
     * @param propType This is 0, 1, 2, or 3.
     * * 0 = Properties are elastic from column
     * * 1 = Properties are elastic from column and doubler plate
     * * 2 = Properties are from specified spring stiffnesses
     * * 3 = Properties are from a specified link property
     * @param thickness The thickness of the doubler plate. This item applies only when PropType = 1. (L)
     * @param k1 The spring stiffness for major axis bending (about the local 3 axis of the column and panel zone). This item applies only when PropType = 2. (FL/rad)
     * @param k2 The spring stiffness for minor axis bending (about the local 2 axis of the column and panel zone). This item applies only when PropType = 2. (FL/rad)
     * @param linkProp The name of the link property used to define the panel zone. This item applies only when PropType = 3.
     * @param connectivity This is 0 or 1.
     * * 0 = Panel zone connects beams to other objects
     * * 1 = Panel zone connects braces to other objects
     * @param localAxisFrom This is 0 or 1.
     * * 0 = Panel zone local axis angle is from column
     * * 1 = Panel zone local axis angle is user defined
     * The LocalAxisFrom item can be 1 only when the PropType item is 3.
     * @param localAxisAngle This item applies only when PropType = 3 and LocalAxisFrom = 1. It is the angle measured counter clockwise from the positive global X-axis to the local 2-axis of the panel zone. (deg)
     * @return The function returns zero if the panel zone data is successfully retrieved, otherwise it returns a nonzero value. If no panel zone assignment is made to the point object, an error is returned.
     */
    fun getPanelZone(name: String, propType: AIntByRef, thickness: ADoubleByRef, k1: ADoubleByRef, k2: ADoubleByRef, linkProp: AStringByRef, connectivity: AIntByRef, localAxisFrom: AIntByRef, localAxisAngle: ADoubleByRef): Int =
            callFunctionInt("GetPanelZone", name, propType, thickness, k1, k2, linkProp, connectivity, localAxisFrom, localAxisAngle)

    /**
     * This function retrieves the joint pattern value for a specific point object and joint pattern.
     * Joint pattern values are unitless.
     * @param name The name of an existing point object.
     * @param patternName The name of a defined joint pattern.
     * @param value The value that the specified point object has for the specified joint pattern.
     * @return zero if the value is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPatternValue(name: String, patternName: String, value: ADoubleByRef): Int =
            callFunctionInt("GetPatternValue", name, patternName, value)

    /**
     * This function retrieves the restraint assignments for a point object. The restraint assignments are always returned in the point local coordinate system.
     * @param name The name of an existing point object.
     * @param value This is an array of six restraint values.
     * * Value(0) = U1
     * * Value(1) = U2
     * * Value(2) = U3
     * * Value(3) = R1
     * * Value(4) = R2
     * * Value(5) = R3
     * @return zero if the restraint assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getRestraint(name: String, value: ABooleanArrayByRef): Int =
            callFunctionInt("GetRestraint", name, value)

    /**
     * This function retrieves the selected status for a point object.
     * @param name The name of an existing point object.
     * @param selected This item returns True if the specified point object is selected, otherwise it returns False.
     * @return zero if the selected status is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: ABooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * This function retrieves the special point status for a point object.
     * Special points are allowed to exist in the model even if no objects (line, area, solid, link) are connected to them. Points that are not special are automatically deleted if no objects connect to them.
     * @param name The name of an existing point object.
     * @param specialPoint This item is True if the point object is specified as a special point, otherwise it is False.
     * @return zero if the special point status is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSpecialPoint(name: String, specialPoint: Boolean): Int =
            callFunctionInt("GetSpecialPoint", name, specialPoint)

    /**
     * This function retrieves coupled spring stiffness assignments for a point object.
     * The spring stiffnesses reported are the sum of all springs assigned to the point object. The spring stiffness values are reported in the point local coordinate system.
     * @param name The name of an existing point object.
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
     * @return zero if the stiffnesses are successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point object, the function returns a nonzero value.
     */
    fun getSpringCoupled(name: String, k: ADoubleArrayByRef): Int =
            callFunctionInt("GetSpringCoupled", name, k)

    /**
     * This function retrieves uncoupled spring stiffness assignments for a point object, that is, it retrieves the diagonal terms in the 6x6 spring matrix for the point object.
     * The spring stiffnesses reported are the sum of all springs assigned to the point object. The spring stiffness values are reported in the point local coordinate system.
     * @param name The name of an existing point object.
     * @param k This is an array of six spring stiffness values.
     * * Value(0) = U1 (F/L)
     * * Value(1) = U2 (F/L)
     * * Value(2) = U3 (F/L)
     * * Value(3) = R1 (FL/rad)
     * * Value(4) = R2 (FL/rad)
     * * Value(5) = R3 (FL/rad)
     * @return zero if the stiffnesses are successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point object, the function returns a nonzero value.
     */
    fun getSpring(name: String, k: ADoubleArrayByRef): Int =
            callFunctionInt("GetSpring", name, k)

    /**
     * @param name The name of an existing point object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the point object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array; (Local1, Local2, Local3) are an item (such as a point load) in the point object local coordinate system; and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the point object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the point object local coordinate system.
     * @return zero if the point object transformation matrix is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function indicates if the spring assignments to a point object are coupled, that is, if they have off-diagonal terms in the 6x6 spring matrix for the point object.
     * @param name The name of an existing point object.
     * @param isCoupled This item is True if the spring assigned to the specified point object is coupled, otherwise it is False.
     * @return zero if the coupled status is successfully retrieved, otherwise it returns a nonzero value. If no springs exist at the point object,n the function returns a nonzero value.
     */
    fun isSpringCoupled(name: String, isCoupled: Boolean): Int =
            callFunctionInt("IsSpringCoupled", name, isCoupled)

    /**
     * This function makes joint constraint assignments to point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param constraintName The name of an existing joint constraint.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the constraint assignment is made to the point object specified by the Name item.
     * If this item is Group, the constraint assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the constraint assignment is made to all selected point objects and the Name item is ignored.
     * @param replace If this item is True, all previous joint constraints, if any, assigned to the specified point object(s) are deleted before making the new assignment.
     * @return 0 if the assignment is successfully made, otherwise it returns nonzero.
     */
    fun setConstraint(name: String, constraintName: String, itemType: Int = ItemType.OBJECT.sapId, replace: Boolean = true): Int =
            callFunctionInt("SetConstraint", name, constraintName, itemType, replace)

    /**
     * This function adds or removes point objects from a specified group.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified point objects are added to the group specified by the GroupName item. If it is True, the point objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the point object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all point objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected point objects are added or removed from the group specified by the GroupName item and the Name item is ignored.
     * @return zero if the group assignment is successful, otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for specified point object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing point object.
     * @param GUID The GUID (Global Unique ID) for the specified point object.
     * @return zero if the point object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function makes ground displacement load assignments to point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param loadPat The name of the load pattern for the ground displacement load.
     * @param value This is an array of six ground displacement load values.
     * * Value(0) = U1 (L)
     * * Value(1) = U2 (L)
     * * Value(2) = U3 (L)
     * * Value(3) = R1 (rad)
     * * Value(4) = R2 (rad)
     * * Value(5) = R3 (rad)
     * @param replace If this item is True, all previous ground displacement loads, if any, assigned to the specified point object(s) in the specified load pattern are deleted before making the new assignment.
     * @param cSys The name of the coordinate system for the considered ground displacement load. This is Local or the name of a defined coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignment is made to the point object specified by the Name item.
     * If this item is Group, the load assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the load assignments are successfully made, otherwise it returns a nonzero value.
     */
    fun setLoadDispl(name: String, loadPat: String, value: ADoubleArrayByRef, replace: Boolean = false, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDispl", name, loadPat, value, replace, cSys, itemType)

    /**
     * This function makes point load assignments to point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param loadPat The name of the load pattern for the point load.
     * @param value This is an array of six point load values.
     * * Value(0) = F1 (F)
     * * Value(1) = F2 (F)
     * * Value(2) = F3 (F)
     * * Value(3) = M1 (FL)
     * * Value(4) = M2 (FL)
     * * Value(5) = M3 (FL)
     * @param replace If this item is True, all previous point loads, if any, assigned to the specified point object(s) in the specified load pattern are deleted before making the new assignment.
     * @param cSys The name of the coordinate system for the considered point load. This is Local or the name of a defined coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignment is made to the point object specified by the Name item.
     * If this item is Group, the load assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the load assignments are successfully made, otherwise it returns a nonzero value.
     */
    fun setLoadForce(name: String, loadPat: String, value: ADoubleArrayByRef, replace: Boolean = false, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadForce", name, loadPat, value, replace, cSys, itemType)

    /**
     * This function assigns advanced local axes to point objects.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2 or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 2 (2 integers), indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param axPt, PlPt This is an array dimensioned to 2 (2 strings), indicating the labels of two joints that define the axis/plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 2.
     * @param axVect, PlVect This is an array dimensioned to 3 (3 doubles) that defines the axis/plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 3.
     * @param plane2 This is 12, 13, 21, 23, 31 or 32, indicating that the local plane determined by the plane reference vector is the 1-2, 1-3, 2-1, 2-3, 3-1, 0r 3-2 plane. This item applies only when the Active item is True.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the point object specified by the Name item.
     * If this item is Group, the assignment is made to all point objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun setLocalAxesAdvanced(name: String, active: Boolean, axVectOpt: Int, axCSys: String, axDir: AIntArrayByRef, axPt: AStringArrayByRef, axVect: ADoubleArrayByRef, plane2: Int, plVectOpt: Int, plCSys: String, plDir: AIntArrayByRef, plPt: AStringArrayByRef, plVect: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect, itemType)

    /**
     * This function sets the local axes angles for point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param a, b, c The local axes of the point are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the local axes assignment is made to the point object specified by the Name item.
     * If this item is Group, the local axes assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the local axes assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the local axes angles are successfully set, otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, a: Double, b: Double, c: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, a, b, c, itemType)

    /**
     * This function assigns point mass to a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param m This is an array of six mass assignment values.
     * * Value(0) = U1 (M)
     * * Value(1) = U2 (M)
     * * Value(2) = U3 (M)
     * * Value(3) = R1 (ML2)
     * * Value(4) = R2 (ML2)
     * * Value(5) = R3 (ML2)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the mass assignment is made to the point object specified by the Name item.
     * If this item is Group, the mass assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the mass assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified mass assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point mass assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the mass assignments are added to any existing assignments.
     * @return zero if the mass is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMass(name: String, m: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = true, replace: Boolean = false): Int =
            callFunctionInt("SetMass", name, m, itemType, isLocalCSys, replace)

    /**
     * This function assigns point mass to a point object. The program calculates the mass by multiplying the specified values by the mass per unit volume of the specified material property.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param matProp The name of an existing material property.
     * @param m This is an array of six mass assignment values.
     * * Value(0) = U1 (L3)
     * * Value(1) = U2 (L3)
     * * Value(2) = U3 (L3)
     * * Value(3) = R1 (L5)
     * * Value(4) = R2 (L5)
     * * Value(5) = R3 (L5)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * SelectedObjects = 2
     * If this item is Object, the mass assignment is made to the point object specified by the Name item.
     * If this item is Group, the mass assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the mass assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified mass assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point mass assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the mass assignments are added to any previously existing assignments.
     * @return zero if the mass is successfully assigned; otherwise, it returns a nonzero value.
     */
    fun setMassByVolume(name: String, matProp: String, m: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = true, replace: Boolean = false): Int =
            callFunctionInt("SetMassByVolume", name, matProp, m, itemType, isLocalCSys, replace)

    /**
     * This function assigns point mass to a point object. The program calculates the mass by dividing the specified values by the acceleration of gravity.
     * @param name The name of an existing point object or group, depending on the value of the ItemType item.
     * @param m This is an array of six mass assignment values.
     * * Value(0) = U1 (L3)
     * * Value(1) = U2 (L3)
     * * Value(2) = U3 (L3)
     * * Value(3) = R1 (L5)
     * * Value(4) = R2 (L5)
     * * Value(5) = R3 (L5)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * SelectedObjects = 2
     * If this item is Object, the mass assignment is made to the point object specified by the Name item.
     * If this item is Group, the mass assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the mass assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified mass assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point mass assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the mass assignments are added to any previously existing assignments.
     * @return zero if the mass is successfully assigned; otherwise. it returns a nonzero value.
     */
    fun setMassByWeight(name: String, m: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = true, replace: Boolean = false): Int =
            callFunctionInt("SetMassByWeight", name, m, itemType, isLocalCSys, replace)

    /**
     * This function assigns a merge number to a point object. By default the merge number for a point is zero. Points with different merge numbers are not automatically merged by the program.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param mergeNumber The merge number for the specified point object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the merge number assignment is made to the point object specified by the Name item.
     * If this item is Group, the merge number assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the merge number assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the merge number is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMergeNumber(name: String, mergeNumber: Int, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMergeNumber", name, mergeNumber, itemType)

    /**
     * This function makes panel zone assignments to point objects. Any existing panel zone assignments are replaced by the new assignments.
     * @param name The name of an existing point object.
     * @param propType This is 0, 1, 2, or 3.
     * * 0 = Properties are elastic from column
     * * 1 = Properties are elastic from column and doubler plate
     * * 2 = Properties are from specified spring stiffnesses
     * * 3 = Properties are from a specified link property
     * @param thickness The thickness of the doubler plate. This item applies only when PropType = 1. (L)
     * @param k1 The spring stiffness for major axis bending (about the local 3 axis of the column and panel zone). This item applies only when PropType = 2. (FL/rad)
     * @param k2 The spring stiffness for minor axis bending (about the local 2 axis of the column and panel zone). This item applies only when PropType = 2. (FL/rad)
     * @param linkProp The name of the link property used to define the panel zone. This item applies only when PropType = 3.
     * @param connectivity This is 0 or 1.
     * * 0 = Panel zone connects beams to other objects
     * * 1 = Panel zone connects braces to other objects
     * @param localAxisFrom This is 0 or 1.
     * * 0 = Panel zone local axis angle is from column
     * * 1 = Panel zone local axis angle is user defined
     * The LocalAxisFrom item can be 1 only when the PropType item is 3.
     * @param localAxisAngle This item applies only when PropType = 3 and LocalAxisFrom = 1. It is the angle measured counter clockwise from the positive global X-axis to the local 2-axis of the panel zone. (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the panel zone assignment is made to the point object specified by the Name item.
     * If this item is Group, the panel zone assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the panel zone assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the panel zone data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setPanelZone(name: String, propType: Int, thickness: Double, k1: Double, k2: Double, linkProp: String, connectivity: Int, localAxisFrom: Int, localAxisAngle: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetPanelZone", name, propType, thickness, k1, k2, linkProp, connectivity, localAxisFrom, localAxisAngle, itemType)

    /**
     * This function sets the joint pattern value for a specified point object and joint pattern.
     * The joint pattern value is calculated as:
     * Value = ((z - zpoint) * w) + u
     * where z, w and u are described in the Parameters section and zpoint is the Z coordinate of the considered point object in the present coordinate system. All appropriate unit conversions are used to calculate the value in the database units, but thereafter it is assumed to be unitless.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param patternName The name of a defined joint pattern.
     * @param z The Z coordinate at zero pressure in the present coordinate system. (L)
     * @param w A weight per unit volume. (F/L3)
     * @param u An added uniform force per unit area. (F/L2)
     * @param r This is 0, 1, or 2.
     * This restriction applies before the pattern value has been added to any existing pattern value assigned to the point object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * If this item is Object, the joint pattern assignment is made to the point object specified by the Name item.
     * If this item is Group, the joint pattern assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the joint pattern assignment is made to all selected point objects and the Name item is ignored.
     * @param restriction This is 0, 1, or 2.
     * * 0 = All values are used
     * * 1 = Negative values are set to zero
     * * 2 = Positive values are set to zero
     * This restriction applies after the pattern value has been added to any existing pattern value assigned to the point object. This restriction applies even if there was no existing joint pattern value on the point object.
     * @param replace If this item is True, the joint pattern value calculated as shown in the Remarks section replaces any previous joint pattern value for the point object.
     * If this item is False, the joint pattern value calculated as shown in the Remarks section is added to any previous joint pattern value for the point object and then the Restriction items are checked.
     * @return zero if the pattern value is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setPatternByPressure(name: String, patternName: String, z: Double, w: Double, u: Double, r: Int, itemType: Int = ItemType.OBJECT.sapId, restriction: Int = 0, replace: Boolean = false): Int =
            callFunctionInt("SetPatternByPressure", name, patternName, z, w, u, r, itemType, restriction, replace)

    /**
     * This function sets the joint pattern value for a specified point object and joint pattern.
     * The joint pattern value is calculated as:
     * Value = ax + by + cz + d
     * where a, b, c and d are function input parameters and x, y and z are the coordinates of the considered point object in the present coordinate system
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param patternName The name of a defined joint pattern.
     * @param a The value a in the equation shown in the Remarks section. (1/L)
     * @param b The value b in the equation shown in the Remarks section. (1/L)
     * @param c The value c in the equation shown in the Remarks section. (1/L)
     * @param d The value d in the equation shown in the Remarks section. This item is unitless.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * If this item is Object, the joint pattern assignment is made to the point object specified by the Name item.
     * If this item is Group, the joint pattern assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the joint pattern assignment is made to all selected point objects and the Name item is ignored.
     * @param restriction This is either 0, 1, or 2.
     * @param replace If this item is True, the joint pattern value calculated as shown in the Remarks section replaces any previous joint pattern value for the point object.
     * If this item is False, the joint pattern value calculated as shown in the Remarks section is added to any previous joint pattern value for the point object and then the Restriction items are checked.
     * @return zero if the pattern value is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setPatternByXYZ(name: String, patternName: String, a: Double, b: Double, c: Double, d: Double, itemType: Int = ItemType.OBJECT.sapId, restriction: Int = 0, replace: Boolean = false): Int =
            callFunctionInt("SetPatternByXYZ", name, patternName, a, b, c, d, itemType, restriction, replace)

    /**
     * This function assigns the restraint assignments for a point object. The restraint assignments are always set in the point local coordinate system.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param value This is an array of six restraint values.
     * * Value(0) = U1
     * * Value(1) = U2
     * * Value(2) = U3
     * * Value(3) = R1
     * * Value(4) = R2
     * * Value(5) = R3
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the restraint assignment is made to the point object specified by the Name item.
     * If this item is Group, the restraint assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the restraint assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the restraint assignments are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setRestraint(name: String, value: ABooleanArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetRestraint", name, value, itemType)

    /**
     * This function sets the selected status for a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param selected This item is True if the specified point object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the point object specified by the Name item.
     * If this item is Group, the selected status is set for all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected point objects and the Name item is ignored.
     * @return zero if the selected status is successfully set, otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)

    /**
     * This function sets the special point status for a point object.
     * Special points are allowed to exist in the model even if no objects (line, area, solid, link) are connected to them. Points that are not special are automatically deleted if no objects connect to them.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param specialPoint This item is True if the point object is specified as a special point, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the special point status is set for the point object specified by the Name item.
     * If this item is Group, the special point status is set for all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the special point status is set for all selected point objects and the Name item is ignored.
     * @return zero if the special point status is successfully set, otherwise it returns a nonzero value.
     */
    fun setSpecialPoint(name: String, specialPoint: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSpecialPoint", name, specialPoint, itemType)

    /**
     * This function assigns coupled springs to a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param k This is an array of six spring stiffness values.
     * * Value(0) = U1 (F/L)
     * * Value(1) = U2 (F/L)
     * * Value(2) = U3 (F/L)
     * * Value(3) = R1 (FL/rad)
     * * Value(4) = R2 (FL/rad)
     * * Value(5) = R3 (FL/rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the spring assignment is made to the point object specified by the Name item.
     * If this item is Group, the spring assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the spring assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified spring assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point spring assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the spring assignments are added to any existing assignments.
     * @return zero if the stiffnesses are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setSpring(name: String, k: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = false, replace: Boolean = false): Int =
            callFunctionInt("SetSpring", name, k, itemType, isLocalCSys, replace)

    /**
     * This function assigns coupled springs to a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param k This is an array of twenty one spring stiffness values.
     * * Value(0) = U1U1 (F/L)
     * * Value(1) = U1U2 (F/L)
     * * Value(2) = U2U2 (F/L)
     * * Value(3) = U1U3 (F/L)
     * * Value(4) = U2U3 (F/L)
     * * Value(5) = U3U3 (F/L)
     * * Value(6) = U1R1 (F/rad)
     * * Value(7) = U2R1 (F/rad)
     * * Value(8) = U3R1 (F/rad)
     * * Value(9) = R1R1 (FL/rad)
     * * Value(10) = U1R2 (F/rad)
     * * Value(11) = U2R2 (F/rad)
     * * Value(12) = U3R2 (F/rad)
     * * Value(13) = R1R2 (FL/rad)
     * * Value(14) = R2R2 (FL/rad)
     * * Value(15) = U1R3 (F/rad)
     * * Value(16) = U2R3 (F/rad)
     * * Value(17) = U3R3 (F/rad)
     * * Value(18) = R1R3 (FL/rad)
     * * Value(19) = R2R3 (FL/rad)
     * * Value(20) = R3R3 (FL/rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the spring assignment is made to the point object specified by the Name item.
     * If this item is Group, the spring assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the spring assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified spring assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point spring assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the spring assignments are added to any existing assignments.
     * @return zero if the stiffnesses are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setSpringCoupled(name: String, k: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = false, replace: Boolean = false): Int =
            callFunctionInt("SetSpringCoupled", name, k, itemType, isLocalCSys, replace)
}