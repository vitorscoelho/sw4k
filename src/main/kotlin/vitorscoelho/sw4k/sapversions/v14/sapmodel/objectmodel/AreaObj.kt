package vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.enums.ItemType

interface AreaObjV14 : SapComponent {
    /**
     * This function adds a new area object, defining points at the specified coordinates.
     * @param numberPoints The number of points in the area abject.
     * @param x, y, z These are arrays of x, y and z coordinates, respectively, for the corner points of the area object. The coordinates are in the coordinate system defined by the CSys item. The coordinates should be ordered to run clockwise or counter clockwise around the area object.
     * @param name This is the name that the program ultimately assigns to the area object. If no UserName is specified, the program assigns a default name to the area object. If a UserName is specified and that name is not used for another area object, the UserName is assigned to the area object; otherwise a default name is assigned to the area object.
     * @param propName This is Default, None or the name of a defined area property.
     * If it is Default, the program assigns a default area property to the area object. If it is None, no area property is assigned to the area object. If it is the name of a defined area property, that property is assigned to the area object.
     * @param userName This is an optional user specified name for the area object. If a UserName is specified and that name is already used for another area object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the area object point coordinates are defined.
     * @return zero if the area object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByCoord(numberPoints: Int, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", numberPoints, x, y, z, name, propName, userName, cSys)

    /**
     * This function adds a new area object whose defining points are specified by name.
     * @param numberPoints The number of points in the area abject.
     * @param point This is an array containing the names of the point objects that define the added area object. The point object names should be ordered to run clockwise or counter clockwise around the area object.
     * @param name This is the name that the program ultimately assigns for the area object. If no UserName is specified, the program assigns a default name to the area object. If a UserName is specified and that name is not used for another area object, the UserName is assigned to the area object; otherwise a default name is assigned to the area object.
     * @param propName This is Default, None or the name of a defined area property.
     * If it is Default, the program assigns a default area property to the area object. If it is None, no area property is assigned to the area object. If it is the name of a defined area property, that property is assigned to the area object.
     * @param userName This is an optional user specified name for the area object. If a UserName is specified and that name is already used for another area object, the program ignores the UserName.
     * @return zero if the area object is successfully added; otherwise it returns a nonzero value.
     */
    fun addByPoint(numberPoints: Int, point: StringArrayByRef, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", numberPoints, point, name, propName, userName)

    /**
     * This function applies a new name to an area object.
     * @param name The existing name of a defined area object.
     * @param newName The new name for the area object.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return a count of the area objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes the gravity load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects,the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the pore pressure load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadPorePressure(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadPorePressure", name, loadPat, itemType)

    /**
     * This function deletes the rotate load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadRotate(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadRotate", name, loadPat, itemType)

    /**
     * This function deletes the strain load assignments to the specified area objects, for the specified load pattern, for the specified components.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param component This is 1, 2, 3, 4, 5, 6, 7 or 8, indicating the component to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain12
     * * 3 = Strain13
     * * 4 = Curvature11
     * * 5 = Curvature22
     * * 6 = Curvature33
     * * 7 = Strain13
     * * 8 = Strain23
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadStrain(name: String, loadPat: String, component: Int, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadStrain", name, loadPat, component, itemType)

    /**
     * This function deletes the surface pressure load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadSurfacePressure(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadSurfacePressure", name, loadPat, itemType)

    /**
     * This function deletes the temperature load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadTemperature(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTemperature", name, loadPat, itemType)

    /**
     * This function deletes the uniform load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadUniform(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadUniform", name, loadPat, itemType)

    /**
     * This function deletes the uniform to frame load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadUniformToFrame(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadUniformToFrame", name, loadPat, itemType)

    /**
     * This function deletes the wind pressure load assignments to the specified area objects for the specified load pattern.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadWindPressure(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadWindPressure", name, loadPat, itemType)

    /**
     * This function deletes the mass assignments for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the mass assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the mass assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the mass assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the mass assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteMass(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteMass", name, itemType)

    /**
     * This function deletes the modifier assignments for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the modifier assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the modifier assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the modifier assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteModifiers(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteModifiers", name, itemType)

    /**
     * This function deletes all spring assignments for the specified area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the spring assignments are deleted for the area object specified by the Name item.
     * If this item is Group, the spring assignments are deleted for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the spring assignments are deleted for all selected area objects, and the Name item is ignored.
     * @return zero if the assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteSpring(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteSpring", name, itemType)

    /**
     * The function deletes area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the area object specified by the Name item is deleted.
     * If this item is Group, all of the area objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all of the selected area objects are deleted, and the Name item is ignored.
     * @return zero if the area objects are successfully deleted; otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves the automatic meshing assignments to area objects.
     * @param name The name of an existing area object.
     * @param meshType This item is 0, 1, 2, 3, 4, 5 or 6, indicating the automatic mesh type for the area object.
     * * 0 = No automatic meshing
     * * 1 = Mesh area into a specified number of objects
     * * 2 = Mesh area into objects of a specified maximum size
     * * 3 = Mesh area based on points on area edges
     * * 4 = Cookie cut mesh area based on lines intersecting edges
     * * 5 = Cookie cut mesh area based on points
     * * 6 = Mesh area using General Divide Tool
     * Mesh options 1, 2 and 3 apply to quadrilaterals and triangles only.
     * @param n1 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 2.
     * @param n2 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 3.
     * @param maxSize1 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 2. (L)
     * @param maxSize2 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 3. (L)
     * @param pointOnEdgeFromLine This item applies when MeshType = 3. If it is True, points on the area object edges are determined from intersections of straight line objects included in the group specified by the Group item with the area object edges.
     * @param pointOnEdgeFromPoint This item applies when MeshType = 3. If it is True, points on the area object edges are determined from point objects included in the group specified by the Group item that lie on the area object edges.
     * @param extendCookieCutLines This item applies when MeshType = 4. MeshType = 4 provides cookie cut meshing based on straight line objects included in the group specified by the Group item that intersect the area object edges. If the ExtendCookieCutLines item is True, all straight line objects included in the group specified by the Group item are extended to intersect the area object edges for the purpose of meshing the area object.
     * @param rotation This item applies when MeshType = 5. MeshType = 5 provides cookie cut meshing based on two perpendicular lines passing through point objects included in the group specified by the Group item. By default these lines align with the area object local 1 and 2 axes. The Rotation item is an angle in degrees that the meshing lines are rotated from their default orientation. (deg)
     * @param maxSizeGeneral This item applies when MeshType = 6. It is the maximum size of objects created by the General Divide Tool.
     * @param localAxesOnEdge If this item is True, and if both points along an edge of the original area object have the same local axes, the program makes the local axes for added points along the edge the same as the edge end points.
     * @param localAxesOnFace If this item is True, and if all points around the perimeter of the original area object have the same local axes, the program makes the local axes for all added points the same as the perimeter points.
     * @param restraintsOnEdge If this item is True, and if both points along an edge of the original area object have the same restraint/constraint, then, if the added point and the adjacent corner points have the same local axes definition, the program includes the restraint/constraint for added points along the edge.
     * @param restraintsOnFace If this item is True, and if all points around the perimeter of the original area object have the same restraint/constraint, then, if an added point and the perimeter points have the same local axes definition, the program includes the restraint/constraint for the added point.
     * @param group The name of a defined group. Some of the meshing options make use of point and line objects included in this group.
     * @param subMesh If this item is True, after initial meshing, the program further meshes any area objects that have an edge longer than the length specified by the SubMeshSize item.
     * @param subMeshSize This item applies when the SubMesh item is True. It is the maximum size of area objects to remain when the auto meshing is complete. (L)
     * @return zero if the meshing assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getAutoMesh(name: String, meshType: IntByRef, n1: IntByRef, n2: IntByRef, maxSize1: DoubleByRef, maxSize2: DoubleByRef, pointOnEdgeFromLine: BooleanByRef, pointOnEdgeFromPoint: BooleanByRef, extendCookieCutLines: BooleanByRef, rotation: DoubleByRef, maxSizeGeneral: DoubleByRef, localAxesOnEdge: BooleanByRef, localAxesOnFace: BooleanByRef, restraintsOnEdge: BooleanByRef, restraintsOnFace: BooleanByRef, group: StringByRef, subMesh: BooleanByRef, subMeshSize: DoubleByRef): Int =
            callFunctionInt("GetAutoMesh", name, meshType, n1, n2, maxSize1, maxSize2, pointOnEdgeFromLine, pointOnEdgeFromPoint, extendCookieCutLines, rotation, maxSizeGeneral, localAxesOnEdge, localAxesOnFace, restraintsOnEdge, restraintsOnFace, group, subMesh, subMeshSize)

    /**
     * This function retrieves the generated edge constraint assignments to area objects.
     * @param name The name of an existing area object.
     * @param constraintExists This item is True if an automatic edge constraint is generated by the program for the area object in the analysis model.
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEdgeConstraint(name: String, constraintExists: BooleanByRef): Int =
            callFunctionInt("GetEdgeConstraint", name, constraintExists)

    /**
     * This function retrieves the names of the area elements (analysis model area) associated with a specified area object in the object-based model.
     * @param name The name of an existing area object.
     * @param nelm The number of area elements created from the specified area object.
     * @param elm An array that includes the name of a area element created from the specified area object.
     * @return zero if the area element information is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not currently exist.
     */
    fun getElm(name: String, nelm: IntByRef, elm: StringArrayByRef): Int =
            callFunctionInt("GetElm", name, nelm, elm)

    /**
     * This function retrieves the GUID for the specified area object.
     * @param name The name of an existing area object.
     * @param GUID The GUID (Global Unique ID) for the specified area object.
     * @return zero if the area object GUID is successfully retrieved; otherwise, it returns nonzero.
     */
    fun getGUID(name: String, GUID: StringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves the gravity load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, areaName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the pore pressure load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of pore pressure loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each pore pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each pore pressure load.
     * @param value This is an array that includes the pore pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the pore pressure load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadPorePressure(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadPorePressure", name, numberItems, areaName, loadPat, value, patternName, itemType)

    /**
     * This function retrieves the rotate load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of rotate loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each rotate load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each rotate load.
     * @param value This is an array that includes the angular velocity value. [Cyc/T]
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadRotate(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadRotate", name, numberItems, areaName, loadPat, value, itemType)

    /**
     * This function retrieves the strain load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param component This is an array that includes 1, 2, 3, 4, 5, 6, 7 or 8, indicating the component associated with each strain load.
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain12
     * * 4 = Curvature11
     * * 5 = Curvature22
     * * 6 = Curvature12
     * * 7 = Strain13
     * * 8 = Strain23
     * @param value This is an array that includes the strain value. (L/L) for Component = 1, 2, 3, 7 and 8, and (1/L) for Component = 4, 5 and 6
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, component: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, areaName, loadPat, component, value, patternName, itemType)

    /**
     * This function retrieves the surface pressure load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of surface pressure loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each surface pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each surface pressure load.
     * @param face This is an array that includes either -1, -2 or a nonzero, positive integer, indicating the area object face to which the specified load assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from area object point n to area object point n + 1. For example, edge face 2 is from area object point 2 to area object point 3.
     * @param value This is an array that includes the surface pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the surface pressure load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadSurfacePressure(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, face: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadSurfacePressure", name, numberItems, areaName, loadPat, face, value, patternName, itemType)

    /**
     * This function retrieves the temperature load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param myType This is an array that includes either 1 or 3, indicating the type of temperature load.
     * * 1 = Temperature
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is an array that includes the temperature load value. (T) for MyType= 1 and (T/L) for MyType= 3
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, myType: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, areaName, loadPat, myType, value, patternName, itemType)

    /**
     * This function retrieves the uniform to frame load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of uniform loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each uniform load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the uniform load is specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each uniform load.
     * @param dir This is an integer between 1 and 11, indicating the direction of the load.
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
     * @param value The uniform load value. (F/L2)
     * @param distType This is either 1 or 2, indicating the load distribution type.
     * * 1 = One-way load distribution
     * * 2 = Two-way load distribution
     * One-way distribution is parallel to the area object local 1 axis. Two-way distribution is parallel to the area object local 1 and 2 axes.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadUniformToFrame(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, dir: IntArrayByRef, value: DoubleArrayByRef, distType: IntArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadUniformToFrame", name, numberItems, areaName, loadPat, cSys, dir, value, distType, itemType)

    /**
     * This function retrieves the uniform load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of uniform loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each uniform load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the uniform load is specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each uniform load.
     * @param dir This is an integer between 1 and 11, indicating the direction of the load.
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
     * @param value The uniform load value. (F/L2)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadUniform(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, dir: IntArrayByRef, value: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadUniform", name, numberItems, areaName, loadPat, cSys, dir, value, itemType)

    /**
     * This function retrieves the wind pressure load assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of wind pressure loads retrieved for the specified area objects.
     * @param areaName This is an array that includes the name of the area object associated with each wind pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each wind pressure load.
     * @param myType This is an array that includes either 1 or 2, indicating the wind pressure type.
     * * 1 = Windward, pressure varies over height
     * * 2 = Other, pressure is constant over height
     * @param cp This is an array that includes the wind pressure coefficient value.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the area object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadWindPressure(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, myType: DoubleArrayByRef, cp: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadWindPressure", name, numberItems, areaName, loadPat, myType, cp, itemType)

    /**
     * This function retrieves the advanced local axes assignments to area objects.
     * @param name The name of an existing area object.
     * @param active This is True if advanced local axes exist.
     * @param plane2 This is 31 or 32, indicating that the local plane determined by the plane reference vector is the 3-1 plane or the 3-2 plane. This item applies only when the Active item is True.
     * @param plVectOpt This is 1, 2, or 3, indicating the plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param plCSys The coordinate system used to define the plane reference vector coordinate directions and the plane user vector. This item applies when the Active item is True and the PlVectOpt item is 1 or 3.
     * @param plDir This is an array dimensioned to 2 (2 integers) indicating the plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param plPt This is an array dimensioned to 2 (2 strings) indicating the labels of two joints that define the plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 2.
     * @param plVect This is an array dimensioned to 3 (3 doubles) that defines the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 3.
     * @return zero if the advanced local axes assignments are retrieved successfully; otherwise it returns a nonzero value.
     */
    fun getLocalAxesAdvanced(name: String, active: BooleanByRef, plane2: IntByRef, plVectOpt: IntByRef, plCSys: StringByRef, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef): Int =
            callFunctionInt("GetLocalAxesAdvanced", name, active, plane2, plVectOpt, plCSys, plDir, plPt, plVect)

    /**
     * This function retrieves the local axis angle assignment for area objects.
     * @param name The name of an existing area object.
     * @param ang This is the angle that the local 1 and 2 axes are rotated about the positive local 3 axis from the default orientation. The rotation for a positive angle appears counter clockwise when the local +3 axis is pointing toward you. (deg)
     * @param advanced This item is True if the area object local axes orientation was obtained using advanced local axes parameters.
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: DoubleByRef, advanced: BooleanByRef): Int =
            callFunctionInt("GetLocalAxes", name, ang, advanced)

    /**
     * This function retrieves the mass per unit area assignment for area objects.
     * @param name The name of an existing area object.
     * @param massOverL2 The mass per unit area assigned to the area object. [M/L2]
     * @return zero if the mass assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMass(name: String, massOverL2: DoubleByRef): Int =
            callFunctionInt("GetMass", name, massOverL2)

    /**
     * This function retrieves the material overwrite assigned to an area object, if any. The material property name is indicated as None if there is no material overwrite assignment.
     * @param name The name of a defined area object.
     * @param propName This is None, indicating that no material overwrite exists for the specified area object, or it is the name of an existing material property.
     * @return zero if the material overwrite assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterialOverwrite(name: String, propName: StringByRef): Int =
            callFunctionInt("GetMaterialOverwrite", name, propName)

    /**
     * This function retrieves the material temperature assignments to area objects.
     * @param name The name of an existing area object.
     * @param temp This is the material temperature value assigned to the area object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the area object is uniform over the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the area object may vary. The material temperature at each corner point around the area object perimeter is equal to the specified temperature multiplied by the pattern value at the associated point object. The material temperature at other points in the area object is calculated by interpolation from the corner points.
     * @return zero if the material temperature assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the modifier assignment for area objects. The default value for all modifiers is one.
     * @param name The name of an existing area object.
     * @param value This is an array of ten unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined area objects.
     * @param numberNames The number of area object names retrieved by the program.
     * @param myName This is a one-dimensional array of area object names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the joint offset assignments for area objects.
     * @param name The name of an existing area object.
     * @param offsetType This is 0, 1 or 2, indicating the joint offset type.
     * * 0 = No joint offsets
     * * 1 = User defined joint offsets specified by joint pattern
     * * 2 = User defined joint offsets specified by point
     * @param offsetPattern This item applies only when OffsetType = 1. It is the name of the defined joint pattern that is used to calculate the joint offsets.
     * @param offsetPatternSF This item applies only when OffsetType = 1. It is the scale factor applied to the joint pattern when calculating the joint offsets. (L)
     * @param offset This item applies only when OffsetType = 2. It is an array of joint offsets for each of the points that define the area object. (L)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOffsets(name: String, offsetType: IntByRef, offsetPattern: StringByRef, offsetPatternSF: DoubleByRef, offset: DoubleArrayByRef): Int =
            callFunctionInt("GetOffsets", name, offsetType, offsetPattern, offsetPatternSF, offset)

    /**
     * This function retrieves the names of the point objects that define an area object.
     * @param name The name of a defined area object.
     * @param numberPoints The number of point objects that define the area object.
     * @param point This is an array containing the names of the point objects that define the area object. The point names are in order around the area object.
     * @return zero if the point object names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, numberPoints: IntByRef, point: StringArrayByRef): Int =
            callFunctionInt("GetPoints", name, numberPoints, point)

    /**
     * This function retrieves the area property assigned to an area object.
     * @param name The name of a defined area object.
     * @param propName The name of the area property assigned to the area object. This item is None if no area property is assigned to the area object.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the selected status for area object edges.
     * @param name The name of an existing area object.
     * @param numberEdges The number of edges in the specified area object.
     * @param selected This is an array of items that is True if the specified area object edge is selected; otherwise it is False.
     * * Selected(0) = Selected status for edge 1
     * * Selected(1) = Selected status for edge 2
     * * Selected(n) = Selected status for edge (n + 1)
     * This array is internally dimensioned by Sap2000 to (NumberEdges - 1).
     * @return zero if the selected status is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSelectedEdge(name: String, numberEdges: IntByRef, selected: BooleanArrayByRef): Int =
            callFunctionInt("GetSelectedEdge", name, numberEdges, selected)

    /**
     * This function retrieves the selected status for an area object.
     * @param name The name of an existing area object.
     * @param selected This item is True if the specified area object is selected; otherwise it is False.
     * @return zero if the selected status is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * This function retrieves the spring assignments to an area object face.
     * @param name The name of an existing area object.
     * @param numberSprings The number of spring assignments made to the specified area object.
     * @param myType Each value in this array is either 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s Each value in this array is the simple spring stiffness per unit area of the specified area object face. This item applies only when the corresponding MyType = 1. (F/L3)
     * @param simpleSpringType Each value in this array is 1, 2 or 3, indicating the simple spring type. This item applies only when the corresponding MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp Each value in this array is the name of the link property assigned to the spring. This item applies only when the corresponding MyType = 2.
     * @param face Each value in this array is -1, -2 or a nonzero, positive integer, indicating the area object face to which the specified spring assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from area object point n to area object point n + 1. For example, edge face 2 is from area object point 2 to area object point 3.
     * @param springLocalOneType Each value in this array is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to area object local axis
     * * 2 = Normal to specified area object face
     * * 3 = User specified direction vector
     * @param dir Each value in this array is 1, 2, 3, -1, -2 or -3, indicating the area object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when the corresponding SpringLocalOneType = 1.
     * @param outward Each value in this array is True if the spring positive local 1 axis is outward from the specified area object face. This item applies only when SpringLocalOneType = 2.
     * @param vecX Each value in this array is the X-axis or area object local 1-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecY Each value in this array is the Y-axis or area object local 2-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecZ Each value in this array is the X-axis or area object local 3-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param cSys Each value in this array is Local (meaning the area object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param ang Each value in this array is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when the corresponding MyType = 2. (deg)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSpring(name: String, numberSprings: IntByRef, myType: IntArrayByRef, s: DoubleArrayByRef, simpleSpringType: IntArrayByRef, linkProp: StringArrayByRef, face: IntArrayByRef, springLocalOneType: IntArrayByRef, dir: IntArrayByRef, outward: BooleanArrayByRef, vecX: DoubleArrayByRef, vecY: DoubleArrayByRef, vecZ: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("GetSpring", name, numberSprings, myType, s, simpleSpringType, linkProp, face, springLocalOneType, dir, outward, vecX, vecY, vecZ, cSys, ang)

    /**
     * This function retrieves the thickness overwrite assignments for area objects.
     * @param name The name of an existing area object.
     * @param thicknessType This is 0, 1 or 2, indicating the thickness overwrite type.
     * * 0 = No thickness overwrites
     * * 1 = User defined thickness overwrites specified by joint pattern
     * * 2 = User defined thickness overwrites specified by point
     * @param thicknessPattern This item applies only when ThicknessType = 1. It is the name of the defined joint pattern that is used to calculate the thicknesses.
     * @param thicknessPatternSF This item applies only when ThicknessType = 1. It is the scale factor applied to the joint pattern when calculating the thicknesses. (L)
     * @param thickness This item applies only when ThicknessType = 2. It is an array of thicknesses at each of the points that define the area object. (L)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getThickness(name: String, thicknessType: IntByRef, thicknessPattern: StringByRef, thicknessPatternSF: DoubleByRef, thickness: DoubleArrayByRef): Int =
            callFunctionInt("GetThickness", name, thicknessType, thicknessPattern, thicknessPatternSF, thickness)

    /**
     * @param name The name of an existing area object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the area object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the area object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the area object local coordinate system.
     * @return zero if the area object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function makes automatic meshing assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param meshType This item is 0, 1, 2, 3, 4, 5 or 6, indicating the automatic mesh type for the area object.
     * * 0 = No automatic meshing
     * * 1 = Mesh area into a specified number of objects
     * * 2 = Mesh area into objects of a specified maximum size
     * * 3 = Mesh area based on points on area edges
     * * 4 = Cookie cut mesh area based on lines intersecting edges
     * * 5 = Cookie cut mesh area based on points
     * * 6 = Mesh area using General Divide Tool
     * Mesh options 1, 2 and 3 apply to quadrilaterals and triangles only.
     * @param n1 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 2.
     * @param n2 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 3.
     * @param maxSize1 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 2. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize2 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 3. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param pointOnEdgeFromLine This item applies when MeshType = 3. If it is True, points on the area object edges are determined from intersections of straight line objects included in the group specified by the Group item with the area object edges.
     * @param pointOnEdgeFromPoint This item applies when MeshType = 3. If it is True, points on the area object edges are determined from point objects included in the group specified by the Group item that lie on the area object edges.
     * @param extendCookieCutLines This item applies when MeshType = 4. MeshType = 4 provides cookie cut meshing based on straight line objects included in the group specified by the Group item that intersect the area object edges. If the ExtendCookieCutLines item is True, all straight line objects included in the group specified by the Group item are extended to intersect the area object edges for the purpose of meshing the area object.
     * @param rotation This item applies when MeshType = 5. MeshType = 5 provides cookie cut meshing based on two perpendicular lines passing through point objects included in the group specified by the Group item. By default these lines align with the area object local 1 and 2 axes. The Rotation item is an angle in degrees that the meshing lines are rotated from their default orientation. (deg)
     * @param maxSizeGeneral This item applies when MeshType = 6. It is the maximum size of objects created by the General Divide Tool.
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param localAxesOnEdge If this item is True, and if both points along an edge of the original area object have the same local axes, then the program makes the local axes for added points along the edge the same as the edge end points.
     * @param localAxesOnFace If this item is True, and if all points around the perimeter of the original area object have the same local axes, the program makes the local axes for all added points the same as the perimeter points.
     * @param restraintsOnEdge If this item is True, and if both points along an edge of the original area object have the same restraint/constraint, then, if the added point and the adjacent corner points have the same local axes definition, the program includes the restraint/constraint for added points along the edge.
     * @param restraintsOnFace If this item is True, and if all points around the perimeter of the original area object have the same restraint/constraint, then, if an added point and the perimeter points have the same local axes definition, the program includes the restraint/constraint for the added point.
     * @param group The name of a defined group. Some of the meshing options make use of point and line objects included in this group.
     * @param subMesh If this item is True, after initial meshing, the program further meshes any area objects that have an edge longer than the length specified by the SubMeshSize item.
     * @param subMeshSize This item applies when the SubMesh item is True. It is the maximum size of area objects to remain when the auto meshing is complete. (L)
     * If this item is input as 0, the default value is used. The default value is 12 inches if the database units are English or 30 centimeters if the database units are metric.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the meshing options are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setAutoMesh(name: String, meshType: Int, n1: Int = 2, n2: Int = 2, maxSize1: Double = 0.0, maxSize2: Double = 0.0, pointOnEdgeFromLine: Boolean = false, pointOnEdgeFromPoint: Boolean = false, extendCookieCutLines: Boolean = false, rotation: Double = 0.0, maxSizeGeneral: Double = 0.0, localAxesOnEdge: Boolean = false, localAxesOnFace: Boolean = false, restraintsOnEdge: Boolean = false, restraintsOnFace: Boolean = false, group: String = "ALL", subMesh: Boolean = false, subMeshSize: Double = 0.0, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetAutoMesh", name, meshType, n1, n2, maxSize1, maxSize2, pointOnEdgeFromLine, pointOnEdgeFromPoint, extendCookieCutLines, rotation, maxSizeGeneral, localAxesOnEdge, localAxesOnFace, restraintsOnEdge, restraintsOnFace, group, subMesh, subMeshSize, itemType)

    /**
     * This function makes generated edge constraint assignments to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param constraintExists This item is True if an automatic edge constraint is generated by the program for the area object in the analysis model.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the edge constraint option is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setEdgeConstraint(name: String, constraintExists: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetEdgeConstraint", name, constraintExists, itemType)

    /**
     * This function adds or removes area objects from a specified group.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified area objects are added to the group specified by the GroupName item. If it is True, the area objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the area object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all area objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected area objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful; otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified area object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing area object.
     * @param GUID The GUID (Global Unique ID) for the specified area object.
     * @return zero if the area object GUID is successfully set; otherwise, it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns gravity load multipliers to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified area object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns pore pressure loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the pore pressure value. (F/L2)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the pore pressure load for the area object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the pore pressure load for the area object is based on the specified pore pressure value multiplied by the pattern value at the point objects that define the area object.
     * @param replace If this item is True, all previous pore pressure loads, if any, assigned to the specified area object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadPorePressure(name: String, loadPat: String, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadPorePressure", name, loadPat, value, patternName, replace, itemType)

    /**
     * This function assigns rotate loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the angular velocity. [Cyc/T]
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadRotate(name: String, loadPat: String, value: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadRotate", name, loadPat, value, itemType)

    /**
     * This function assigns strain loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param component This is 1, 2, 3, 4, 5, 6, 7 or 8, indicating the component to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain12
     * * 4 = Curvature11
     * * 5 = Curvature22
     * * 6 = Curvature12
     * * 7 = Strain13
     * * 8 = Strain23
     * @param value This is the strain load value. (L/L) for Component = 1, 2, 3, 7 and 8 and (1/L) for Component = 4, 5 and 6
     * @param replace If this item is True, all previous strain loads, if any, assigned to the specified area object(s), in the specified load pattern, for the specified degree of freedom, are deleted before making the new assignment.
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the strain load for the area object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the strain load for the area object is based on the specified strain value multiplied by the pattern value at the corner points of the area object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadStrain(name: String, loadPat: String, component: Int, value: Double, replace: Boolean = true, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadStrain", name, loadPat, component, value, replace, patternName, itemType)

    /**
     * This function assigns surface pressure loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param face This is -1, -2 or a nonzero, positive integer, indicating the area object face to which the specified load assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from area object point n to area object point n + 1. For example, edge face 2 is from area object point 2 to area object point 3.
     * @param value This is the surface pressure value. (F/L2)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the surface pressure load for the area object face is uniform over the face at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the surface pressure load for the area object face is based on the specified surface pressure value multiplied by the pattern value at the point objects that are part of the face.
     * @param replace If this item is True, all previous surface pressure loads, if any, assigned to the specified area object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadSurfacePressure(name: String, loadPat: String, face: Int, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadSurfacePressure", name, loadPat, face, value, patternName, replace, itemType)

    /**
     * This function assigns temperature loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is either 1 or 3, indicating the type of temperature load.
     * * 1 = Temperature
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is the temperature change value. (T) for MyType = 1 and (T/L) for MyType = 3
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the temperature load for the area object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern the temperature load for the area object is based on the specified temperature value multiplied by the pattern value at the joints that define the area object.
     * @param replace If this item is True, all previous temperature loads, if any, assigned to the specified area object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadTemperature(name: String, loadPat: String, myType: Int, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTemperature", name, loadPat, myType, value, patternName, replace, itemType)

    /**
     * This function assigns uniform loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value The uniform load value. (F/L2)
     * @param dir This is an integer between 1 and 11, indicating the direction of the load.
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
     * @param replace If this item is True, all previous uniform loads, if any, assigned to the specified area object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys This is Local or the name of a defined coordinate system, indicating the coordinate system in which the uniform load is specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadUniform(name: String, loadPat: String, value: Double, dir: Int, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadUniform", name, loadPat, value, dir, replace, cSys, itemType)

    /**
     * This function assigns uniform to frame loads to area objects.
     * @param name The name of an existing area object or group depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value The uniform load value. (F/L2)
     * @param dir This is an integer between 1 and 11, indicating the direction of the load.
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
     * @param distType This is either 1 or 2, indicating the load distribution type.
     * * 1 = One-way load distribution
     * * 2 = Two-way load distribution
     * One-way distribution is parallel to the area object local 1 axis. Two-way distribution is parallel to the area object local 1 and 2 axes.
     * @param replace If this item is True, all previous uniform loads, if any, assigned to the specified area object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys This is Local or the name of a defined coordinate system, indicating the coordinate system in which the uniform load is specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadUniformToFrame(name: String, loadPat: String, value: Double, dir: Int, distType: Int, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadUniformToFrame", name, loadPat, value, dir, distType, replace, cSys, itemType)

    /**
     * This function assigns wind pressure loads to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is either 1 or 2, indicating the wind pressure type.
     * * 1 = Windward, pressure varies over height
     * * 2 = Other, pressure is constant over height
     * @param cp This is the wind pressure coefficient.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadWindPressure(name: String, loadPat: String, myType: Double, cp: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadWindPressure", name, loadPat, myType, cp, itemType)

    /**
     * This function assigns advanced local axes to area objects.
     * @param name The name of an existing area object or group depending on the value of the ItemType item.
     * @param active This is True if advanced local axes exist.
     * @param plane2 This is 31 or 32, indicating that the local plane determined by the plane reference vector is the 3-1 plane or the 3-2 plane. This item applies only when the Active item is True.
     * @param plVectOpt This is 1, 2, or 3, indicating the plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param plCSys The coordinate system used to define the plane reference vector coordinate directions and the plane user vector. This item applies when the Active item is True and the PlVectOpt item is 1 or 3.
     * @param plDir This is an array dimensioned to 2 (2 integers), indicating the plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param plPt This is an array dimensioned to 2 (2 strings) indicating the labels of two joints that define the plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 2.
     * @param plVect This is an array dimensioned to 3 (3 doubles) that defines the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 3.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected area objects and the Name item is ignored.
     * @return zero if the advanced local axes assignments are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLocalAxesAdvanced(name: String, active: Boolean, plane2: Int, plVectOpt: Int, plCSys: String, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxesAdvanced", name, active, plane2, plVectOpt, plCSys, plDir, plPt, plVect, itemType)

    /**
     * This function assigns a local axis angle to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param ang This is the angle that the local 1 and 2 axes are rotated about the positive local 3 axis from the default orientation. The rotation for a positive angle appears counter clockwise when the local +3 axis is pointing toward you. (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the local axis angle is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, ang: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, ang, itemType)

    /**
     * This function assigns mass per unit area to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param massOverL2 The mass per unit area assigned to the area object. [M/L2]
     * @param replace If this item is True, all existing mass assignments to the area object are removed before assigning the specified mas. If it is False, the specified mass is added to any existing mass already assigned to the area object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects and the Name item is ignored.
     * @return zero if the mass is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMass(name: String, massOverL2: Double, replace: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMass", name, massOverL2, replace, itemType)

    /**
     * This function sets the material overwrite assignment for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param propName This is None or a blank string, indicating that any existing material overwrites assigned to the specified area objects are to be removed, or it is the name of an existing material property.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the material overwrite assignment is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMaterialOverwrite(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMaterialOverwrite", name, propName, itemType)

    /**
     * This function assigns material temperatures to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param temp This is the material temperature value assigned to the area object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the area object is uniform over the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the area object may vary. The material temperature at each corner point around the area object perimeter is equal to the specified temperature multiplied by the pattern value at the associated point object. The material temperature at other points in the area object is calculated by interpolation from the corner points.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the material temperatures are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMatTemp(name: String, temp: Double, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMatTemp", name, temp, patternName, itemType)

    /**
     * This function sets the modifier assignment for area objects. The default value for all modifiers is one.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param value This is an array of ten unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetModifiers", name, value, itemType)

    /**
     * This function sets the joint offset assignments for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param offsetType This is 0, 1 or 2, indicating the joint offset type.
     * * 0 = No joint offsets
     * * 1 = User defined joint offsets specified by joint pattern
     * * 2 = User defined joint offsets specified by point
     * @param offsetPattern This item applies only when OffsetType = 1. It is the name of the defined joint pattern that is used to calculate the joint offsets.
     * @param offsetPatternSF This item applies only when OffsetType = 1. It is the scale factor applied to the joint pattern when calculating the joint offsets. (L)
     * @param offset This item applies only when OffsetType = 2. It is an array of joint offsets for each of the points that define the area object. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the offsets are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOffsets(name: String, offsetType: Int, offsetPattern: String, offsetPatternSF: Double, offset: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOffsets", name, offsetType, offsetPattern, offsetPatternSF, offset, itemType)

    /**
     * This function assigns an area property to area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param propName This is None or the name of a area property to be assigned to the specified area object(s). None means that no property is assigned to the area object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the property is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setProperty(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetProperty", name, propName, itemType)

    /**
     * This function sets the selected status for area object edges.
     * @param name The name of an existing area object.
     * @param edgeNum The area object edge that is have its selected status set.
     * @param selected This item is True if the specified area object edge is selected; otherwise it is False.
     * @return zero if the selected status is successfully set; otherwise it returns a nonzero value.
     */
    fun setSelectedEdge(name: String, edgeNum: Int, selected: Boolean): Int =
            callFunctionInt("SetSelectedEdge", name, edgeNum, selected)

    /**
     * This function sets the selected status for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified area object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the area object specified by the Name item.
     * If this item is Group, the selected status is set for all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected area objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set; otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)

    /**
     * This function makes spring assignments to area objects. The springs are assigned to a specified area object face.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param myType This is either 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s The simple spring stiffness per unit area of the specified area object face. This item applies only when MyType = 1. F/L3)
     * @param simpleSpringType This is 1, 2 or 3, indicating the simple spring type. This item applies only when MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp The name of the link property assigned to the spring. This item applies only when MyType = 2.
     * @param face This is -1, -2 or a nonzero, positive integer indicating the area object face to which the specified spring assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from area object point n to area object point n + 1. For example, edge face 2 is from area object point 2 to area object point 3.
     * @param springLocalOneType This is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to area object local axis
     * * 2 = Normal to specified area object face
     * * 3 = User specified direction vector
     * @param dir This is 1, 2, 3, -1, -2 or -3, indicating the area object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when SpringLocalOneType = 1.
     * @param outward This item is True if the spring positive local 1 axis is outward from the specified area object face. This item applies only when SpringLocalOneType = 2.
     * @param vec This is an array of three values that define the direction vector of the spring positive local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when SpringLocalOneType = 3.
     * @param ang This is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when MyType = 2. (deg)
     * @param replace If this item is True, all existing spring assignments to the area object are removed before assigning the specified spring. If it is False, the specified spring is added to any existing springs already assigned to the area object.
     * @param cSys This is Local (meaning the area object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when SpringLocalOneType = 3.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the assignments are successfully applied; otherwise it returns a nonzero value.
     */
    fun setSpring(name: String, myType: Int, s: Double, simpleSpringType: Int, linkProp: String, face: Int, springLocalOneType: Int, dir: Int, outward: Boolean, vec: DoubleArrayByRef, ang: Double, replace: Boolean, cSys: String = "Local", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSpring", name, myType, s, simpleSpringType, linkProp, face, springLocalOneType, dir, outward, vec, ang, replace, cSys, itemType)

    /**
     * This function sets the thickness overwrite assignments for area objects.
     * @param name The name of an existing area object or group, depending on the value of the ItemType item.
     * @param thicknessType This is 0, 1 or 2, indicating the thickness overwrite type.
     * * 0 = No thickness overwrites
     * * 1 = User defined thickness overwrites specified by joint pattern
     * * 2 = User defined thickness overwrites specified by point
     * @param thicknessPattern This item applies only when ThicknessType = 1. It is the name of the defined joint pattern that is used to calculate the thicknesses.
     * @param thicknessPatternSF This item applies only when ThicknessType = 1. It is the scale factor applied to the joint pattern when calculating the thicknesses. (L)
     * @param thickness This item applies only when ThicknessType = 2. It is an array of thicknesses at each of the points that define the area object. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the area object specified by the Name item.
     * If this item is Group, the assignment is made to all area objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected area objects, and the Name item is ignored.
     * @return zero if the thickness overwrites are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setThickness(name: String, thicknessType: Int, thicknessPattern: String, thicknessPatternSF: Double, thickness: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetThickness", name, thicknessType, thicknessPattern, thicknessPatternSF, thickness, itemType)
}