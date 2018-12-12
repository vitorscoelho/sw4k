package vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType

interface TendonObjV14 : SapComponent {
    /**
     * This function adds a new tendon object whose end points are at the specified coordinates.
     * @param xi, yi, zi The coordinates of the I-End of the added tendon object. The coordinates are in the coordinate system defined by the CSys item.
     * @param xj, yj, zj The coordinates of the J-End of the added tendon object. The coordinates are in the coordinate system defined by the CSys item.
     * @param name This is the name that the program ultimately assigns for the tendon object. If no UserName is specified, the program assigns a default name to the tendon object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the tendon object; otherwise a default name is assigned to the tendon object.
     * @param propName This is Default, None or the name of a defined tendon property.
     * If it is Default, the program assigns a default tendon property to the tendon object. If it is None, no tendon property is assigned to the tendon object. If it is the name of a defined tendon property, that property is assigned to the tendon object.
     * @param userName This is an optional user specified name for the tendon object. If a UserName is specified and that name is already used for another tendon object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the tendon object end point coordinates are defined.
     * @return zero if the tendon object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", xi, yi, zi, xj, yj, zj, name, propName, userName, cSys)

    /**
     * This function adds a new tendon object whose end points are specified by name.
     * @param point1 The name of a defined point object at the I-End of the added tendon object.
     * @param point2 The name of a defined point object at the J-End of the added tendon object.
     * @param name This is the name that the program ultimately assigns for the tendon object. If no UserName is specified, the program assigns a default name to the tendon object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the tendon object; otherwise a default name is assigned to the tendon object.
     * @param propName This is Default, None or the name of a defined tendon property.
     * If it is Default, the program assigns a default tendon property to the tendon object. If it is None, no tendon property is assigned to the tendon object. If it is the name of a defined tendon property, that property is assigned to the tendon object.
     * @param userName This is an optional user specified name for the tendon object. If a UserName is specified and that name is already used for another tendon object, the program ignores the UserName.
     * @return zero if the tendon object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByPoint(point1: String, point2: String, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point1, point2, name, propName, userName)

    /**
     * @param name The existing name of a defined tendon object.
     * @param newName The new name for the tendon object.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * None
     * @return a count of the tendon objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes the deformation load assignments to the specified tendon objects for the specified load pattern.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the tendon object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected tendon objects and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDeformation(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDeformation", name, loadPat, itemType)

    /**
     * This function deletes the tendon force/stress load assignments to the specified tendon objects for the specified load pattern.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the tendon object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadForceStress(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadForceStress", name, loadPat, itemType)

    /**
     * This function deletes the gravity load assignments to the specified tendon objects for the specified load pattern.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the tendon object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the strain load assignments to the specified tendon objects for the specified load pattern.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the tendon object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadStrain(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadStrain", name, loadPat, itemType)

    /**
     * This function deletes the temperature load assignments to the specified tendon objects for the specified load pattern.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the tendon object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadTemperature(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTemperature", name, loadPat, itemType)

    /**
     * The function deletes tendon objects.
     * @param name The name of an existing tendon object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the tendon object specified by the Name item is deleted.
     * If this item is Group, all of the tendon objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all selected tendon objects are deleted, and the Name item is ignored.
     * @return zero if the tendon objects are successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves the maximum discretization length assignment for tendon objects.
     * @param name The name of an existing tendon object.
     * @param value The maximum discretization length for the tendon. (L)
     * @return zero if the assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getDiscretization(name: String, value: DoubleByRef): Int =
            callFunctionInt("GetDiscretization", name, value)

    /**
     * This function retrieves the names of the line elements (analysis model lines) associated with a specified tendon object in the object-based model. It also retrieves information about the location of the line elements along the tendon object.
     * @param name The name of an existing tendon object.
     * @param nelm The number of line elements created from the specified tendon object.
     * @param elm An array that includes the name of a line element created from the specified tendon object.
     * @param rdi An array that includes the relative distance along the tendon object to the I-End of the line element.
     * @param rdj An array that includes the relative distance along the tendon object to the J-End of the line element.
     * @return zero if the line element information is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not currently exist.
     */
    fun getElm(name: String, nelm: IntByRef, elm: StringArrayByRef, rdi: DoubleArrayByRef, rdj: DoubleArrayByRef): Int =
            callFunctionInt("GetElm", name, nelm, elm, rdi, rdj)

    /**
     * This function retrieves the GUID for the specified tendon object.
     * @param name The name of an existing tendon object.
     * @param GUID The GUID (Global Unique ID) for the specified tendon object.
     * @return zero if the tendon object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: StringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves the deformation load assignments to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified tendon objects.
     * @param tendonName This is an array that includes the name of the tendon object associated with each deformation load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each deformation load.
     * @param u1 This is an array of axial deformation load values. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the tendon object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: IntByRef, tendonName: StringArrayByRef, loadPat: StringArrayByRef, u1: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, tendonName, loadPat, u1, itemType)

    /**
     * This function retrieves the loaded group for tendon objects. A tendon object transfers its load to any object that is in the specified group.
     * @param name The name of an existing tendon object.
     * @param groupName This is the name of an existing group. All objects in the specified group can be loaded by the tendon.
     * @return zero if the assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadedGroup(name: String, groupName: StringByRef): Int =
            callFunctionInt("GetLoadedGroup", name, groupName)

    /**
     * This function retrieves the force/stress load assignments to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified tendon objects.
     * @param tendonName This is an array that includes the name of the tendon object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param jackFrom This is an array that includes 1, 2 or 3, indicating how the tendon is jacked.
     * * 1 = Tendon jacked from I-End
     * * 2 = Tendon jacked from J-End
     * * 3 = Tendon jacked from both ends
     * @param loadType This is an array that includes either 0 or 1, indicating how the type of load.
     * * 0 = Force
     * * 1 = Stress
     * @param value This is an array that includes the load value. (F) when LoadType is 0, and (F/L2) when Loadtype is 1
     * @param curvatureCoeff This is an array that includes the curvature coefficient used when calculating friction losses.
     * @param wobbleCoeff This is an array that includes the wobble coefficient used when calculating friction losses. (1/L)
     * @param lossAnchorage This is an array that includes the anchorage set slip. (L)
     * @param lossShortening This is an array that includes the tendon stress loss due to elastic shortening. (F/L2)
     * @param lossCreep This is an array that includes the tendon stress loss due to creep. (F/L2)
     * @param lossShrinkage This is an array that includes the tendon stress loss due to shrinkage. (F/L2)
     * @param lossSteelRelax This is an array that includes the tendon stress loss due to tendon steel relaxation. (F/L2)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the tendon object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadForceStress(name: String, numberItems: IntByRef, tendonName: StringArrayByRef, loadPat: StringArrayByRef, jackFrom: IntArrayByRef, loadType: IntArrayByRef, value: DoubleArrayByRef, curvatureCoeff: DoubleArrayByRef, wobbleCoeff: DoubleArrayByRef, lossAnchorage: DoubleArrayByRef, lossShortening: DoubleArrayByRef, lossCreep: DoubleArrayByRef, lossShrinkage: DoubleArrayByRef, lossSteelRelax: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadForceStress", name, numberItems, tendonName, loadPat, jackFrom, loadType, value, curvatureCoeff, wobbleCoeff, lossAnchorage, lossShortening, lossCreep, lossShrinkage, lossSteelRelax, itemType)

    /**
     * This function retrieves the gravity load assignments to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified tendon objects.
     * @param tendonName This is an array that includes the name of the tendon object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the tendon object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, tendonName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, tendonName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the strain load assignments to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified tendon objects.
     * @param tendonName This is an array that includes the name of the tendon object associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param strain This is an array that includes the axial strain value. (L/L)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the tendon object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected tendon objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, tendonName: StringArrayByRef, loadPat: StringArrayByRef, strain: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, tendonName, loadPat, strain, patternName, itemType)

    /**
     * This function retrieves the temperature load assignments to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified tendon objects.
     * @param tendonName This is an array that includes the name of the tendon object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param value This is an array that includes the temperature load value. (T)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the tendon object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected tendon objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, tendonName: StringArrayByRef, loadPat: StringArrayByRef, myType: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, tendonName, loadPat, myType, value, patternName, itemType)

    /**
     * This function retrieves the tendon local axis angle assignment for tendon objects.
     * @param name The name of an existing tendon object.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @return zero if the assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: DoubleByRef): Int =
            callFunctionInt("GetLocalAxes", name, ang)

    /**
     * This function retrieves the material temperature assignments to tendon objects.
     * @param name The name of an existing tendon object.
     * @param temp This is the material temperature value assigned to the tendon object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the tendon object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the tendon object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the tendon object.
     * @return zero if the material temperature assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the names of all defined tendon objects.
     * @param numberNames The number of tendon object names retrieved by the program.
     * @param myName This is a one-dimensional array of tendon object names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of the point objects at each end of a specified tendon object.
     * @param name The name of a defined tendon object.
     * @param point1 The name of the point object at the I-End of the specified tendon object.
     * @param point2 The name of the point object at the J-End of the specified tendon object.
     * @return zero if the point names are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: StringByRef, point2: StringByRef): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the tendon property assigned to a tendon object.
     * @param name The name of a defined tendon object.
     * @param propName The name of the tendon property assigned to the tendon object.
     * @return zero if the tendon object property is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the selected status for a tendon object.
     * @param name The name of an existing tendon object.
     * @param selected This item returns True if the specified tendon object is selected, otherwise it returns False.
     * @return zero if the selected status is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * This function retrieves the tension/compression force limit assignments to tendon objects.
     * Note that the tension and compression limits are used in nonlinear analyses only.
     * @param name The name of an existing tendon object.
     * @param limitCompressionExists This item is True if a compression force limit exists for the tendon object.
     * @param limitCompression The compression force limit for the tendon object. (F)
     * @param limitTensionExists This item is True if a tension force limit exists for the tendon object.
     * @param limitTension The tension force limit for the tendon object. (F)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTCLimits(name: String, limitCompressionExists: BooleanByRef, limitCompression: DoubleByRef, limitTensionExists: BooleanByRef, limitTension: DoubleByRef): Int =
            callFunctionInt("GetTCLimits", name, limitCompressionExists, limitCompression, limitTensionExists, limitTension)

    /**
     * This function retrieves the tendon geometric definition parameters for a tendon object.
     * @param name The name of a defined tendon object.
     * @param numberPoints The number of items used to define the tendon geometry.
     * @param myType This is an array of values that are 1, 3, 6, 7, 8, or 9, indicating the tendon geometry definition parameter for the specified point.
     * * 1 = Start of tendon
     * * 2 = The segment preceding the point is linear
     * * 6 = The specified point is the end of a parabola
     * * 7 = The specified point is an intermediate point on a parabola
     * * 8 = The specified point is the end of a circle
     * * 9 = The specified point is an intermediate point on a parabola
     * The first point always has a MyType value of 1.
     * MyType of 6 through 9 is based on using three points to calculate a parabolic or circular arc. MyType 6 and 8 use the specified point and the two previous points as the three points. MyType 7 and 9 use the specified point and the points just before and after the specified point as the three points.
     * @param x This is an array of the X (or local 1) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param y This is an array of the Y (or local 2) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param z This is an array of the Z (or local 3) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param cSys This is the coordinate system in which the x, y and z coordinate parameters are defined. It is Local or the name of a defined coordinate system.
     * Local means that the point coordinates are in the local system of the specified tendon object with the origin assumed to be at the I-End of the tendon.
     * @return zero if the tendon object parameters are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTendonData(name: String, numberPoints: IntByRef, myType: IntArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetTendonData", name, numberPoints, myType, x, y, z, cSys)

    /**
     * This function retrieves tendon object discretized geometry, that is, it retrieves the coordinates of the points along the discretized tendon.
     * @param name The name of a defined tendon object.
     * @param numberPoints The number of items used to define the discretized tendon geometry.
     * @param x This is an array of the X (or local 1) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param y This is an array of the Y (or local 2) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param z This is an array of the Z (or local 3) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param cSys This is the coordinate system in which the x, y and z coordinate parameters are defined. It is Local or the name of a defined coordinate system.
     * Local means that the point coordinates are in the local system of the specified tendon object with the origin assumed to be at the I-End of the tendon.
     * @return zero if the tendon object discretized geometry is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTendonGeometry(name: String, numberPoints: IntByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetTendonGeometry", name, numberPoints, x, y, z, cSys)

    /**
     * @param name The name of an existing tendon object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the tendon object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the tendon object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the tendon object local coordinate system.
     * @return zero if the tendon object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function assigns a maximum discretization length to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param value The maximum discretization length for the tendon. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the discretization length is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setDiscretization(name: String, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetDiscretization", name, value, itemType)

    /**
     * This function adds or removes tendon objects from a specified group.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified tendon objects are added to the group specified by the GroupName item. If it is True, the tendon objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the tendon object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all tendon objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected tendon objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful, otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified tendon object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing tendon object.
     * @param GUID The GUID (Global Unique ID) for the specified tendon object.
     * @return zero if the tendon object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns deformation loads to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param d This is the axial deformation load value. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDeformation(name: String, loadPat: String, d: DoubleByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDeformation", name, loadPat, d, itemType)

    /**
     * This function makes the loaded group assignment to tendon objects. A tendon object transfers its load to any object that is in the specified group.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param groupName This is the name of an existing group. All objects in the specified group can be loaded by the tendon.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the group is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadedGroup(name: String, groupName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadedGroup", name, groupName, itemType)

    /**
     * This function assigns force/stress loads to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param jackFrom This is 1, 2 or 3, indicating how the tendon is jacked.
     * * 1 = Tendon jacked from I-End
     * * 2 = Tendon jacked from J-End
     * * 3 = Tendon jacked from both ends
     * @param loadType This is either 0 or 1, indicating how the type of load.
     * * 0 = Force
     * * 1 = Stress
     * @param value This is the load value. (F) whenLoadType is 0, and (F/L2) when Loadtype is 1
     * @param curvatureCoeff The curvature coefficient used when calculating friction losses.
     * @param wobbleCoeff The wobble coefficient used when calculating friction losses. (1/L)
     * @param lossAnchorage The anchorage set slip. (L)
     * @param lossShortening The tendon stress loss due to elastic shortening. (F/L2)
     * @param lossCreep The tendon stress loss due to creep. (F/L2)
     * @param lossShrinkage The tendon stress loss due to shrinkage. (F/L2)
     * @param lossSteelRelax The tendon stress loss due to tendon steel relaxation. (F/L2)
     * @param replace If this item is True, all previous force/stress loads, if any, assigned to the specified tendon object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadForceStress(name: String, loadPat: String, jackFrom: Int, loadType: Int, value: Double, curvatureCoeff: Double, wobbleCoeff: Double, lossAnchorage: Double, lossShortening: Double, lossCreep: Double, lossShrinkage: Double, lossSteelRelax: Double, replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadForceStress", name, loadPat, jackFrom, loadType, value, curvatureCoeff, wobbleCoeff, lossAnchorage, lossShortening, lossCreep, lossShrinkage, lossSteelRelax, replace, itemType)

    /**
     * This function assigns gravity load multipliers to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified tendon object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns strain loads to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param strain This is the axial strain load value. (L/L)
     * @param replace If this item is True, all previous strain loads, if any, assigned to the specified tendon object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the strain load for the tendon object is uniform along the object at the value specified by Strain.
     * If PatternName is the name of a defined joint pattern, the strain load for the tendon object is based on the specified strain value multiplied by the pattern value at the joints at each end of the tendon object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadStrain(name: String, loadPat: String, strain: Double, replace: Boolean = true, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadStrain", name, loadPat, strain, replace, patternName, itemType)

    /**
     * This function assigns temperature loads to tendon objects.
     * @param name The name of an existing tendon object or group depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the temperature change value. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the temperature load for the tendon object is uniform along the object at the value specified by Val.
     * If PatternName is the name of a defined joint pattern, the temperature load for the tendon object is based on the specified temperature value multiplied by the pattern value at the joints at each end of the tendon object.
     * @param replace If this item is True, all previous temperature loads, if any, assigned to the specified tendon object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadTemperature(name: String, loadPat: String, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTemperature", name, loadPat, value, patternName, replace, itemType)

    /**
     * This function assigns a local axis angle to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the local axis angle is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, ang: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, ang, itemType)

    /**
     * This function assigns material temperatures to tendon objects.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param temp This is the material temperature value assigned to the tendon object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the tendon object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the tendon object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the tendon object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the material temperatures are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMatTemp(name: String, temp: Double, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMatTemp", name, temp, patternName, itemType)

    /**
     * This function assigns a tendon property to a tendon object.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param propName This is None or the name of a tendon property to be assigned to the specified tendon object(s). None means that no property is assigned to the tendon.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects, and the Name item is ignored.
     * @return zero if the tendon property is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setProperty(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetProperty", name, propName, itemType)

    /**
     * This function sets the selected status for a tendon object.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified tendon object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the tendon object specified by the Name item.
     * If this item is Group, the selected status is set for all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected tendon objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set, otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)

    /**
     * This function makes tension/compression force limit assignments to tendon objects.
     * Note that the tension and compression limits are used in nonlinear analyses only.
     * @param name The name of an existing tendon object or group, depending on the value of the ItemType item.
     * @param limitCompressionExists This item is True if a compression force limit exists for the tendon object.
     * @param limitCompression The compression force limit for the tendon object. (F)
     * @param limitTensionExists This item is True if a tension force limit exists for the tendon object.
     * @param limitTension The tension force limit for the tendon object. (F)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the tendon object specified by the Name item.
     * If this item is Group, the assignment is made to all tendon objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected tendon objects and the Name item is ignored.
     * @return zero if the assignments are successfully applied, otherwise it returns a nonzero value.
     */
    fun setTCLimits(name: String, limitCompressionExists: Boolean, limitCompression: Double, limitTensionExists: Boolean, limitTension: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetTCLimits", name, limitCompressionExists, limitCompression, limitTensionExists, limitTension, itemType)

    /**
     * This function assigns the tendon geometric definition parameters to a tendon object.
     * @param name The name of a defined tendon object.
     * @param numberPoints The number of items used to define the tendon geometry.
     * @param myType This is an array of values that are 1, 3, 6, 7, 8, or 9, indicating the tendon geometry definition parameter for the specified point.
     * * 1 = Start of tendon
     * * 2 = The segment preceding the point is linear
     * * 6 = The specified point is the end of a parabola
     * * 7 = The specified point is an intermediate point on a parabola
     * * 8 = The specified point is the end of a circle
     * * 9 = The specified point is an intermediate point on a parabola
     * The first point should always have a MyType value of 1. If it is not equal to 1, the program uses 1 anyway.
     * MyType of 6 through 9 is based on using three points to calculate a parabolic or circular arc. MyType 6 and 8 use the specified point and the two previous points as the three points. MyType 7 and 9 use the specified point and the points just before and after the specified point as the three points.
     * @param x This is an array of the X (or local 1) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param y This is an array of the Y (or local 2) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param z This is an array of the Z (or local 3) coordinate of each point in the coordinate system specified by CSys. (L)
     * @param cSys This is the coordinate system in which the x, y and z coordinate parameters are defined. It is Local or the name of a defined coordinate system.
     * Local means that the point coordinates are in the local system of the specified tendon object with the origin assumed to be at the I-End of the tendon.
     * @return zero if the tendon object is successfully defined, otherwise it returns a nonzero value. If the tendon object is not successfully defined, it may be deleted.
     */
    fun setTendonData(name: String, numberPoints: Int, myType: IntArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("SetTendonData", name, numberPoints, myType, x, y, z, cSys)
}