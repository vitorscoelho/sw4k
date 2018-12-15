package vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemType
import vitorscoelho.sw4k.sapenums.Dir
import vitorscoelho.sw4k.sapenums.DistributedLoadType

interface FrameObjV14 : SapComponent {
    /**
     * This function adds a new frame object whose end points are at the specified coordinates.
     * @param xi, yi, zi The coordinates of the I-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param xj, yj, zj The coordinates of the J-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param name This is the name that the program ultimately assigns for the frame object. If no UserName is specified, the program assigns a default name to the frame object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the frame object, otherwise a default name is assigned to the frame object.
     * @param propName This is Default, None, or the name of a defined frame section property.
     * If it is Default, the program assigns a default section property to the frame object. If it is None, no section property is assigned to the frame object. If it is the name of a defined frame section property, that property is assigned to the frame object.
     * @param userName This is an optional user specified name for the frame object. If a UserName is specified and that name is already used for another frame object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the frame object end point coordinates are defined.
     * @return zero if the frame object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: AStringByRef = StringByRef.UNNECESSARY, propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", xi, yi, zi, xj, yj, zj, name, propName, userName, cSys)

    /**
     * This function adds a new frame object whose end points are specified by name.
     * @param point1 The name of a defined point object at the I-End of the added frame object.
     * @param point2 The name of a defined point object at the J-End of the added frame object.
     * @param name This is the name that the program ultimately assigns for the frame object. If no UserName is specified, the program assigns a default name to the frame object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the frame object, otherwise a default name is assigned to the frame object.
     * @param propName This is Default, None, or the name of a defined frame section property.
     * If it is Default, the program assigns a default section property to the frame object. If it is None, no section property is assigned to the frame object. If it is the name of a defined frame section property, that property is assigned to the frame object.
     * @param userName This is an optional user specified name for the frame object. If a UserName is specified and that name is already used for another frame object, the program ignores the UserName.
     * @return zero if the frame object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByPoint(point1: String, point2: String, name: AStringByRef = StringByRef.UNNECESSARY, propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point1, point2, name, propName, userName)

    /**
     * @param name The existing name of a defined frame object.
     * @param newName The new name for the frame object.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @param myType This is All, Straight, or Curved.
     * All returns a count of all frame objects in the model, including both straight and curved frame objects. Straight returns a count of all straight frame objects in the model. Curved returns a count of all curved frame objects in the model.
     * @return a count of the frame objects in the model. Depending on the value of the MyType item, the count may be of all frame objects in the model, just the straight frame objects in the model or just the curved frame objects in the model.
     */
    fun count(myType: String = "All"): Int =
            callFunctionInt("Count", myType)

    /**
     * This function deletes the fireproofing assignments for frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the fireproofing assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the fireproofing assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the fireproofing assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the fireproofing assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteFireproofing(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteFireproofing", name, itemType)

    /**
     * This function deletes the lateral bracing assignments for frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1, 2 or 3, indicating the bracing to be deleted.
     * * 1 = Delete point bracing
     * * 2 = Delete uniform bracing
     * * 3 = Delete both point and uniform bracing
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the lateral bracing assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the lateral bracing assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects then the lateral bracing assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLateralBracing(name: String, myType: Int = 3, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLateralBracing", name, myType, itemType)

    /**
     * This function deletes the deformation load assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDeformation(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDeformation", name, loadPat, itemType)

    /**
     * This function deletes the distributed load assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDistributed(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDistributed", name, loadPat, itemType)

    /**
     * This function deletes the gravity load assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object,the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the point load assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadPoint(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadPoint", name, loadPat, itemType)

    /**
     * This function deletes the strain load assignments to the specified frame objects, for the specified load pattern, for the specified degree of freedom.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param dof This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain12
     * * 3 = Strain13
     * * 4 = Curvature1
     * * 5 = Curvature2
     * * 6 = Curvature3
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadStrain(name: String, loadPat: String, dof: Int, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadStrain", name, loadPat, dof, itemType)

    /**
     * This function deletes the target force assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadTargetForce(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTargetForce", name, loadPat, itemType)

    /**
     * This function deletes the temperature load assignments to the specified frame objects for the specified load pattern.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadTemperature(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTemperature", name, loadPat, itemType)

    /**
     * This function deletes the frame mass assignments for frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame mass assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the frame mass assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the frame mass assignments are deleted for all selected frame objects and the Name item is ignored.
     * @return zero if the mass assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteMass(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteMass", name, itemType)

    /**
     * This function deletes the frame modifier assignments for frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame modifier assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the frame modifier assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the frame modifier assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteModifiers(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteModifiers", name, itemType)

    /**
     * This function deletes the P-Delta force assignments for frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame modifier assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the frame modifier assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the frame modifier assignments are deleted for all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deletePDeltaForce(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeletePDeltaForce", name, itemType)

    /**
     * This function deletes all spring assignments for the specified frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame spring assignments are deleted for the frame object specified by the Name item.
     * If this item is Group, the frame spring assignments are deleted for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the frame spring assignments are deleted for all selected frame objects and the Name item is ignored.
     * @return zero if the assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteSpring(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteSpring", name, itemType)

    /**
     * The function deletes frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame object specified by the Name item is deleted.
     * If this item is Group, all of the frame objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all selected frame objects are deleted, and the Name item is ignored.
     * @return zero if the frame object is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves the automatic meshing assignments to frame objects.
     * @param name The name of an existing frame object.
     * @param autoMesh This item is True if the frame object is to be automatically meshed by the program when the analysis model is created.
     * @param autoMeshAtPoints This item is applicable only when the AutoMesh item is True. If this item is True, the frame object is automatically meshed at intermediate joints along its length.
     * @param autoMeshAtLines This item is applicable only when the AutoMesh item is True. If this item is True, the frame object is automatically meshed at intersections with other frames, area object edges and solid object edges.
     * @param numSegs This item is applicable only when the AutoMesh item is True. It is the minimum number of elements into which the frame object is automatically meshed. If this item is zero, the number of elements is not checked when the automatic meshing is done.
     * @param autoMeshMaxLength This item is applicable only when the AutoMesh item is True. It is the maximum length of auto meshed frame elements. If this item is zero, the element length is not checked when the automatic meshing is done. (L)
     * @return zero if the meshing assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getAutoMesh(name: String, autoMesh: ABooleanByRef, autoMeshAtPoints: ABooleanByRef, autoMeshAtLines: ABooleanByRef, numSegs: AIntByRef, autoMeshMaxLength: ADoubleByRef): Int =
            callFunctionInt("GetAutoMesh", name, autoMesh, autoMeshAtPoints, autoMeshAtLines, numSegs, autoMeshMaxLength)

    /**
     * This function retrieves definition data for all curved frame objects and returns the data in arrays.
     * @param numberItems The number of curved frame objects returned.
     * @param myType This is an array that includes a numeric value indicating the curved frame type. The type is 1, 2, 3, 4, or 5.
     * MyTypes 1, 2, 4, and 5 all define the curve by three points. The three points are the two end point of the frame object and a third point defined by naming an existing point object or specifying point coordinates.
     * MyType 3 defines a circular curved frame by it end points, the coordinates of another point that lies in the plane of the curve but not necessarily on the curved frame, and a curve radius.
     * @param gx, gy, gz These are arrays that include the point coordinates in the global coordinate system. (L)
     * For MyType 1 and 4 these items do not apply.
     * For MyType 2 and 5 these are the coordinates of the third point on the curved frame.
     * For MyType 3 these are the coordinates of the planar point that lies in the plane of the curved frame.
     * @param pointName This is an array that includes the name of the point object that is the third point on the curved frame. This item applies for MyType 1 and 4. It does not apply for MyType 2, 3 and 5.
     * @param radius This is an array of the radii of the circular curved frame. This item only applies for MyType 3. (L)
     * @param numSegs This is an array that includes the number of segments into which the program internally divides the curved frame.
     * @return zero if the curved frame object data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getCurved(numberItems: AIntByRef, myType: AIntArrayByRef, gx: ADoubleArrayByRef, gy: ADoubleArrayByRef, gz: ADoubleArrayByRef, pointName: AStringArrayByRef, radius: ADoubleArrayByRef, numSegs: AIntArrayByRef): Int =
            callFunctionInt("GetCurved", numberItems, myType, gx, gy, gz, pointName, radius, numSegs)

    /**
     * This function retrieves the design procedure for a frame object.
     * @param name The name of an existing frame object.
     * @param myType This is 1, 2, 7, 8 or 9, indicating the design procedure for the specified frame object.
     * * 1 = Steel
     * * 2 = Concrete
     * * 7 = Aluminum
     * * 8 = Cold Formed
     * * 9 = No Design
     * @return zero if the design procedure is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDesignProcedure(name: String, myType: AIntByRef): Int =
            callFunctionInt("GetDesignProcedure", name, myType)

    /**
     * This function retrieves the names of the frame elements (analysis model lines) associated with a specified frame object in the object-based model. It also retrieves information about the location of the frame elements along the frame object.
     * @param name The name of an existing frame object.
     * @param nelm The number of line elements created from the specified frame object.
     * @param elm An array that includes the name of a frame element created from the specified frame object.
     * @param rdi An array that includes the relative distance along the frame object to the I-End of the frame element.
     * @param rdj An array that includes the relative distance along the line object to the J-End of the frame element.
     * @return zero if the frame element information is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not exist.
     */
    fun getElm(name: String, nelm: AIntByRef, elm: AStringArrayByRef, rdi: ADoubleArrayByRef, rdj: ADoubleArrayByRef): Int =
            callFunctionInt("GetElm", name, nelm, elm, rdi, rdj)

    /**
     * This function retrieves the frame object end offsets along the 1-axis of the object.
     * @param name The name of an existing frame object.
     * @param autoOffset If this item is True, the end length offsets are automatically determined by the program from object connectivity.
     * @param length1 The offset length along the 1-axis of the frame object at the I-End of the frame object. (L)
     * @param length2 The offset along the 1-axis of the frame object at the J-End of the frame object. (L)
     * @param rz The rigid zone factor. This is the fraction of the end offset length assumed to be rigid for bending and shear deformations.
     * @return zero if the offsets are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getEndLengthOffset(name: String, autoOffset: ABooleanByRef, length1: ADoubleByRef, length2: ADoubleByRef, rz: ADoubleByRef): Int =
            callFunctionInt("GetEndLengthOffset", name, autoOffset, length1, length2, rz)

    /**
     * This function retrieves frame object end skew assignments.
     * End skew assignments are only applicable to straight frame objects. An error is returned if skew data is requested for a curved frame object.
     * End skew data is only used in the program to plot the extruded view of bridge objects that have been updated as spine models.
     * @param name The name of an existing frame object.
     * @param skewI The angle in degrees measured counter clockwise from the positive local 3-axis to a line parallel to the I-End of the frame object (-90 < SkewI < 90). (deg)
     * @param skewJ The angle in degrees measured counter clockwise from the positive local 3-axis to a line parallel to the J-End of the frame object (-90 < SkewJ < 90). (deg)
     * @return zero if the end skew data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getEndSkew(name: String, skewI: ADoubleByRef, skewJ: ADoubleByRef): Int =
            callFunctionInt("GetEndSkew", name, skewI, skewJ)

    /**
     * This function retrieves the fireproofing assignments to frame objects.
     * @param name The name of an existing frame object.
     * @param myType This is 1, 2 or 3, indicating the type of fireproofing assigned.
     * * 1 = Sprayed on - program calculate section perimeter
     * * 2 = Sprayed on - user provides section perimeter
     * * 3 = Concrete encased
     * @param thickness When MyType = 1 or MyType = 2 this is the thickness of the sprayed on fireproofing. When MyType = 3 this is the concrete cover dimension. (L)
     * @param perimeter This item applies only when MyType = 2. It is the length of fireproofing applied measured around the perimeter of the frame object cross-section. (L)
     * @param density This is the weight per unit volume of the fireproofing material. [F/L3]
     * @param tf This item applies only when MyType = 1 or MyType = 3. If this item is True, the fireproofing is assumed to be applied to the top flange of the section. If it is False, the program assumes no fireproofing is applied to the section top flange. This flag applies for I, channel and double channel sections.
     * @return zero if the fireproofing assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getFireproofing(name: String, myType: AIntByRef, thickness: ADoubleByRef, perimeter: ADoubleByRef, density: ADoubleByRef, tf: ABooleanByRef): Int =
            callFunctionInt("GetFireproofing", name, myType, thickness, perimeter, density, tf)

    /**
     * This function retrieves the GUID for the specified frame object.
     * @param name The name of an existing frame object.
     * @param GUID The GUID (Global Unique ID) for the specified frame object.
     * @return zero if the frame object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: AStringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves frame object insertion point assignments. The assignments include the cardinal point and end joint offsets.
     * @param name The name of an existing frame object.
     * @param cardinalPoint This is a numeric value from 1 to 11 that specifies the cardinal point for the frame object. The cardinal point specifies the relative position of the frame section on the line representing the frame object.
     * @param mirror2 If this item is True, the frame object section is assumed to be mirrored (flipped) about its local 2-axis.
     * @param stiffTransform If this item is True, the frame object stiffness is transformed for cardinal point and joint offsets from the frame section centroid.
     * @param offset1 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the I-End of the frame object. (L)
     * @param offset2 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the J-End of the frame object. (L)
     * * Offset2(0) = Offset in the 1-axis or X-axis direction
     * * Offset2(1) = Offset in the 2-axis or Y-axis direction
     * * Offset2(2) = Offset in the 3-axis or Z-axis direction
     * @param cSys This is either Local or the name of a defined coordinate system. It is the coordinate system in which the Offset1 and Offset2 items are specified.
     * @return zero if the insertion point data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getInsertionPoint(name: String, cardinalPoint: AIntByRef, mirror2: ABooleanByRef, stiffTransform: ABooleanByRef, offset1: ADoubleArrayByRef, offset2: ADoubleArrayByRef, cSys: AStringByRef): Int =
            callFunctionInt("GetInsertionPoint", name, cardinalPoint, mirror2, stiffTransform, offset1, offset2, cSys)

    /**
     * This function retrieves the lateral bracing location assignments for frame objects.
     * @param name The name of an existing frame object.
     * @param numberItems The total number of bracing assignments retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each bracing assignment.
     * @param myType This is an array that includes 1 or 2, indicating the bracing type assigned.
     * * 1 = Point bracing
     * * 2 = Uniform bracing
     * @param loc This is an array that includes 1, 2 or 3; indicating the bracing location.
     * * 1 = Top
     * * 2 = Bottom
     * * 3 = All (top and bottom)
     * @param rd1 This is an array that includes the relative location of the point bracing (when MyType = 1) or the relative location of the start of the uniform bracing (when MyType = 2).
     * @param rd2 This is an array that includes the relative location of the start of the uniform bracing (when MyType = 2).
     * This item does not apply for point bracing (when MyType = 1).
     * @param dist1 This is an array that includes the actual location of the point bracing (when MyType = 1) or the actual location of the start of the uniform bracing (when MyType = 2). (L)
     * @param dist2 This is an array that includes the actual location of the start of the uniform bracing (when MyType = 2). (L)
     * This item does not apply for point bracing (when MyType = 1).
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLateralBracing(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, myType: AIntArrayByRef, loc: AIntArrayByRef, rd1: ADoubleArrayByRef, rd2: ADoubleArrayByRef, dist1: ADoubleArrayByRef, dist2: ADoubleArrayByRef): Int =
            callFunctionInt("GetLateralBracing", name, numberItems, frameName, myType, loc, rd1, rd2, dist1, dist2)

    /**
     * This function retrieves the deformation load assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each deformation load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each deformation load.
     * @param dof1, dof2, dof3, dof4, dof5, dof6 These are arrays of boolean values indicating if the considered degree of freedom has a deformation load.
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
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, dof1: ABooleanArrayByRef, dof2: ABooleanArrayByRef, dof3: ABooleanArrayByRef, dof4: ABooleanArrayByRef, dof5: ABooleanArrayByRef, dof6: ABooleanArrayByRef, u1: ADoubleArrayByRef, u2: ADoubleArrayByRef, u3: ADoubleArrayByRef, r1: ADoubleArrayByRef, r2: ADoubleArrayByRef, r3: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, frameName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, u1, u2, u3, r1, r2, r3, itemType)

    /**
     * This function retrieves the distributed load assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of distributed loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each distributed load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the distributed loads are specified.
     * @param myType This is 1 or 2 ([DistributedLoadType] enumeration), indicating the type of distributed load.
     * * 1 = Force
     * * 2 = Moment
     * @param cSys This is an array that includes the name of the coordinate system in which each distributed load is defined. It may be Local or the name of a defined coordinate system.
     * @param dir This is an integer between 1 and 11 ([Dir] enumeration), indicating the direction of the load.
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
     * @param rd1 This is an array that includes the relative distance from the I-End of the frame object to the start of the distributed load.
     * @param rd2 This is an array that includes the relative distance from the I-End of the frame object to the end of the distributed load.
     * @param dist1 This is an array that includes the actual distance from the I-End of the frame object to the start of the distributed load. (L)
     * @param dist2 This is an array that includes the actual distance from the I-End of the frame object to the end of the distributed load. (L)
     * @param val1 This is an array that includes the load value at the start of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param val2 This is an array that includes the load value at the end of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDistributed(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, myType: AIntArrayByRef, cSys: AStringArrayByRef, dir: AIntArrayByRef, rd1: ADoubleArrayByRef, rd2: ADoubleArrayByRef, dist1: ADoubleArrayByRef, dist2: ADoubleArrayByRef, val1: ADoubleArrayByRef, val2: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDistributed", name, numberItems, frameName, loadPat, myType, cSys, dir, rd1, rd2, dist1, dist2, val1, val2, itemType)

    /**
     * This function retrieves the gravity load assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, cSys: AStringArrayByRef, x: ADoubleArrayByRef, y: ADoubleArrayByRef, z: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, frameName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the point load assignments to frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param numberItems The total number of point loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each point load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the point loads are specified.
     * @param myType This is an array that includes 1 or 2, indicating the type of point load.
     * * 1 = Force
     * * 2 = Moment
     * @param cSys This is an array that includes the name of the coordinate system in which each point load is defined. It may be Local or the name of a defined coordinate system.
     * @param dir This is an array that includes an integer between 1 and 11 indicating the direction of the load.
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
     * @param relDist This is an array that includes the relative distance from the I-End of the frame object to the location where the point load is applied.
     * @param dist This is an array that includes the actual distance from the I-End of the frame object to the location where the point load is applied. (L)
     * @param value This is an array that includes the value of the point load. (F) when MyType is 1 and (FL) when MyType is 2
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadPoint(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, myType: AIntArrayByRef, cSys: AStringArrayByRef, dir: AIntArrayByRef, relDist: ADoubleArrayByRef, dist: ADoubleArrayByRef, value: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadPoint", name, numberItems, frameName, loadPat, myType, cSys, dir, relDist, dist, value, itemType)

    /**
     * This function retrieves the strain load assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param dof This is an array that includes 1, 2, 3, 4, 5 or 6, indicating the degree of freedom associated with each strain load.
     * * 1 = Strain11
     * * 2 = Strain12
     * * 3 = Strain13
     * * 4 = Curvature1
     * * 5 = Curvature2
     * * 6 = Curvature3
     * @param value This is an array that includes the strain value. (L/L) for dof = 1, 2 and 3 and (1/L) for dof = 4, 5 and 6
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, dof: AIntArrayByRef, value: ADoubleArrayByRef, patternName: AStringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, frameName, loadPat, dof, value, patternName, itemType)

    /**
     * This function retrieves the target force assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each target force.
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
     * @param t1, T2, T3, T4, T5, T6 * These are arrays of the relative distances along the frame objects where the target force values apply. The relative distances specified for a given degree of freedom are applicable only if the corresponding dofn item for that degree of freedom is True.
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
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTargetForce(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, dof1: ABooleanArrayByRef, dof2: ABooleanArrayByRef, dof3: ABooleanArrayByRef, dof4: ABooleanArrayByRef, dof5: ABooleanArrayByRef, dof6: ABooleanArrayByRef, p: ADoubleArrayByRef, v2: ADoubleArrayByRef, v3: ADoubleArrayByRef, t: ADoubleArrayByRef, m2: ADoubleArrayByRef, m3: ADoubleArrayByRef, t1: ADoubleArrayByRef, t2: ADoubleArrayByRef, t3: ADoubleArrayByRef, t4: ADoubleArrayByRef, t5: ADoubleArrayByRef, t6: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTargetForce", name, numberItems, frameName, loadPat, dof1, dof2, dof3, dof4, dof5, dof6, p, v2, v3, t, m2, m3, t1, t2, t3, t4, t5, t6, itemType)

    /**
     * This function retrieves the temperature load assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified frame objects.
     * @param frameName This is an array that includes the name of the frame object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param myType This is an array that includes 1, 2 or 3, indicating the type of temperature load.
     * * 1 = Temperature
     * * 2 = Temperature gradient along local 2 axis
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is an array that includes the temperature load value. (T) for MyType= 1 and (T/L) for MyType= 2 and 3
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the frame object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected frame objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: AIntByRef, frameName: AStringArrayByRef, loadPat: AStringArrayByRef, myType: AIntArrayByRef, value: ADoubleArrayByRef, patternName: AStringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, frameName, loadPat, myType, value, patternName, itemType)

    /**
     * This function retrieves the advanced local axes assignments to frame objects.
     * @param name The name of an existing frame object.
     * @param active This is True if advanced local axes exist.
     * @param plane2 This is 12 or 13, indicating that the local plane determined by the plane reference vector is the 1-2 plane or the 1-3 plane. This item applies only when the Active item is True.
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
     * @param plPt This is an array dimensioned to 2 (2 strings), indicating the labels of two joints that define the plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 2.
     * @param plVect This is an array dimensioned to 3 (3 doubles) that defines the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 3.
     * @return zero if the advanced local axes assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxesAdvanced(name: String, active: ABooleanByRef, plane2: AIntByRef, plVectOpt: AIntByRef, plCSys: AStringByRef, plDir: AIntArrayByRef, plPt: AStringArrayByRef, plVect: ADoubleArrayByRef): Int =
            callFunctionInt("GetLocalAxesAdvanced", name, active, plane2, plVectOpt, plCSys, plDir, plPt, plVect)

    /**
     * This function retrieves the frame local axis angle assignment for frame objects.
     * @param name The name of an existing frame object.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation or, if the Advanced item is True, from the orientation determined by the plane reference vector. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @param advanced This item is True if the line object local axes orientation was obtained using advanced local axes parameters.
     * @return zero if the assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: ADoubleByRef, advanced: ABooleanByRef): Int =
            callFunctionInt("GetLocalAxes", name, ang, advanced)

    /**
     * This function retrieves the frame mass per unit length assignment for frame objects.
     * @param name The name of an existing frame object.
     * @param massOverL The mass per unit length assigned to the frame object. (M/L)
     * @return zero if the mass assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMass(name: String, massOverL: ADoubleByRef): Int =
            callFunctionInt("GetMass", name, massOverL)

    /**
     * This function retrieves the material overwrite assigned to a frame object, if any. It returns None if there is no material overwrite assignment.
     * @param name The name of a defined frame object.
     * @param propName This is None, indicating that no material overwrite exists for the specified frame object, or it is the name of an existing material property.
     * @return zero if the material overwrite assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMaterialOverwrite(name: String, propName: AStringByRef): Int =
            callFunctionInt("GetMaterialOverwrite", name, propName)

    /**
     * This function retrieves the material temperature assignments to frame objects.
     * @param name The name of an existing frame object.
     * @param temp This is the material temperature value assigned to the frame object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the frame object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the frame object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the frame object.
     * @return zero if the material temperature assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: ADoubleByRef, patternName: AStringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the frame modifier assignment for frame objects. The default value for all modifiers is one.
     * @param name The name of an existing frame object.
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
    fun getModifiers(name: String, value: ADoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined frame objects.
     * @param numberNames The number of frame object names retrieved by the program.
     * @param myName This is a one-dimensional array of frame object names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves frame object output station data.
     * @param name The name of an existing frame object.
     * @param myType This is either 1 or 2 indicating how the output stations are specified.
     * * 1 = maximum segment size, that is, maximum station spacing
     * * 2 = minimum number of stations
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum number of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the frame object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getOutputStations(name: String, myType: AIntByRef, maxSegSize: ADoubleByRef, minSections: AIntByRef, noOutPutAndDesignAtElementEnds: ABooleanByRef, noOutPutAndDesignAtPointLoads: ABooleanByRef): Int =
            callFunctionInt("GetOutputStations", name, myType, maxSegSize, minSections, noOutPutAndDesignAtElementEnds, noOutPutAndDesignAtPointLoads)

    /**
     * This function retrieves the P-Delta force assignments to frame objects. P-Delta forces do not apply to curved frame objects. If you request data for a curved frame, an error is returned.
     * @param name The name of an existing straight frame object.
     * @param numberForces The number of P-Delta forces assigned to the frame object.
     * @param pDeltaForce This is an array of the P-Delta force values assigned to the frame object. (F)
     * @param dir This is an array that contains 0, 1, 2 or 3, indicating the direction of each P-Delta force assignment.
     * * 0 = Frame object local 1-axis direction
     * * 1 = Projected X direction in CSys coordinate system
     * * 2 = Projected Y direction in CSys coordinate system
     * * 3 = Projected Z direction in CSys coordinate system
     * @param cSys This is an array that contains the name of the coordinate system in which each projected P-Delta force is defined. This item is blank when the Dir item is zero, that is, when the P-Delta force is defined in the frame object local 1-axis direction.
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPDeltaForce(name: String, numberForces: AIntByRef, pDeltaForce: ADoubleArrayByRef, dir: AIntArrayByRef, cSys: AStringArrayByRef): Int =
            callFunctionInt("GetPDeltaForce", name, numberForces, pDeltaForce, dir, cSys)

    /**
     * This function retrieves the names of the point objects at each end of a specified frame object.
     * @param name The name of a defined frame object.
     * @param point1 The name of the point object at the I-End of the specified frame object.
     * @param point2 The name of the point object at the J-End of the specified frame object.
     * @return zero if the point names are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: AStringByRef, point2: AStringByRef): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the frame object end release and partial fixity assignments.
     * @param name The name of an existing frame object.
     * @param ii, jj These are arrays of six booleans indicating the I-End and J-End releases for the frame object.
     * * ii(0) and jj(0) = U1 release
     * * ii(1) and jj(1) = U2 release
     * * ii(2) and jj(2) = U3 release
     * * ii(3) and jj(3) = R1 release
     * * ii(4) and jj(4) = R2 release
     * * ii(5) and jj(5) = R3 release
     * @param startValue, EndValue These are arrays of six values indicating the I-End and J-End partial fixity springs for the frame object.
     * * StartValue(0) and EndValue(0) = U1 partial fixity (F/L)
     * * StartValue(1) and EndValue(1) = U2 partial fixity (F/L)
     * * StartValue(2) and EndValue(2) = U3 partial fixity (F/L)
     * * StartValue(3) and EndValue(3) = R1 partial fixity (FL/rad)
     * * StartValue(4) and EndValue(4) = R2 partial fixity (FL/rad)
     * * StartValue(5) and EndValue(5) = R3 partial fixity (FL/rad)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getReleases(name: String, ii: ABooleanArrayByRef, jj: ABooleanArrayByRef, startValue: ADoubleArrayByRef, endValue: ADoubleArrayByRef): Int =
            callFunctionInt("GetReleases", name, ii, jj, startValue, endValue)

    /**
     * This function retrieves the nonprismatic frame section property data assigned to a frame object.
     * The function returns zero if the nonprismatic frame object property data is successfully retrieved, otherwise it returns a nonzero value.
     * @param name The name of a defined frame object.
     * @param propName The name of the nonprismatic frame section property assigned to the frame object.
     * @param sVarTotalLength This is the total assumed length of the nonprismatic section. Enter 0 for this item to indicate that the section length is the same as the frame object length.
     * @param sVarRelStartLoc This is the relative distance along the nonprismatic section to the I-End (start) of the frame object. This item is ignored when the sVarTotalLengthitem is 0.
     * @return an error if the section property assigned to the frame object is not a nonprismatic property.
     */
    fun getSectionNonPrismatic(name: String, propName: AStringByRef, sVarTotalLength: ADoubleByRef, sVarRelStartLoc: ADoubleByRef): Int =
            callFunctionInt("GetSectionNonPrismatic", name, propName, sVarTotalLength, sVarRelStartLoc)

    /**
     * This function retrieves the frame section property assigned to a frame object.
     * @param name The name of a defined frame object.
     * @param propName If no auto select list is assigned to the frame object, this is the name of the frame section property assigned to the frame object. If an auto select list is assigned to the frame object, this is the name of the frame section property, within the auto select list, which is currently being used as the analysis property for the frame object. If this item is None, no frame section property is assigned to the frame object.
     * @param sAuto This is the name of the auto select list assigned to the frame object, if any. If this item is returned as a blank string, no auto select list is assigned to the frame object.
     * @return zero if the frame object property is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSection(name: String, propName: AStringByRef, sAuto: AStringByRef): Int =
            callFunctionInt("GetSection", name, propName, sAuto)

    /**
     * This function retrieves the selected status for a frame object.
     * @param name The name of an existing frame object.
     * @param selected This item returns True if the specified frame object is selected, otherwise it returns False.
     * @return zero if the selected status is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: ABooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * This function retrieves the spring assignments to a frame object.
     * @param name The name of an existing frame object.
     * @param numberSprings The number of springs assignments made to the specified frame object.
     * @param myType Each value in this array is either 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s Each value in this array is the simple spring stiffness per unit length of the frame object. This item applies only when the corresponding MyType = 1. [F/L2]
     * @param simpleSpringType Each value in this array is 1, 2 or 3, indicating the simple spring type. This item applies only when the corresponding MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp Each value in this array is the name of the link property assigned to the spring. This item applies only when the corresponding MyType = 2.
     * @param springLocalOneType Each value in this array is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to frame object local axis
     * * 2 = In the frame object 2-3 plane
     * * 3 = User specified direction vector
     * @param dir Each value in this array is 1, 2, 3, -1, -2 or -3, indicating the frame object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when the corresponding SpringLocalOneType = 1.
     * @param plane23Angle Each value in this array is the angle in the frame object 2-3 plane measured counter clockwise from the frame positive 2-axis to the spring positive 1-axis. This item applies only when the corresponding SpringLocalOneType = 2. (deg)
     * @param vecX Each value in this array is the X-axis or frame local 1-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecY Each value in this array is the Y-axis or frame local 2-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecZ Each value in this array is the X-axis or frame local 3-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param cSys Each value in this array is Local (meaning the frame object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param ang Each value in this array is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when the corresponding MyType = 2. (deg)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSpring(name: String, numberSprings: AIntByRef, myType: AIntArrayByRef, s: ADoubleArrayByRef, simpleSpringType: AIntArrayByRef, linkProp: AStringArrayByRef, springLocalOneType: AIntArrayByRef, dir: AIntArrayByRef, plane23Angle: ADoubleArrayByRef, vecX: ADoubleArrayByRef, vecY: ADoubleArrayByRef, vecZ: ADoubleArrayByRef, cSys: AStringArrayByRef, ang: ADoubleArrayByRef): Int =
            callFunctionInt("GetSpring", name, numberSprings, myType, s, simpleSpringType, linkProp, springLocalOneType, dir, plane23Angle, vecX, vecY, vecZ, cSys, ang)

    /**
     * This function retrieves the tension/compression force limit assignments to frame objects.
     * Note that the tension and compression limits are used only in nonlinear analyses.
     * @param name The name of an existing frame object.
     * @param limitCompressionExists This item is True if a compression force limit exists for the frame object.
     * @param limitCompression The compression force limit for the frame object. (F)
     * @param limitTensionExists This item is True if a tension force limit exists for the frame object.
     * @param limitTension The tension force limit for the frame object. (F)
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getTCLimits(name: String, limitCompressionExists: ABooleanByRef, limitCompression: ADoubleByRef, limitTensionExists: ABooleanByRef, limitTension: ADoubleByRef): Int =
            callFunctionInt("GetTCLimits", name, limitCompressionExists, limitCompression, limitTensionExists, limitTension)

    /**
     * @param name The name of an existing frame object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the frame object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the frame object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the frame object local coordinate system.
     * @return zero if the frame object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function retrieves the type of frame object (straight or curved).
     * @param name The name of a defined frame object.
     * @param myType This is Straight or Curved, indicating the type of frame object.
     * @return zero if the frame object type is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getType(name: String, myType: AStringByRef): Int =
            callFunctionInt("GetType", name, myType)

    /**
     * This function makes automatic meshing assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param autoMesh This item is True if the frame object is to be automatically meshed by the program when the analysis model is created.
     * @param autoMeshAtPoints This item is applicable only when the AutoMesh item is True. If this item is True, the frame object is automatically meshed at intermediate joints along its length.
     * @param autoMeshAtLines This item is applicable only when the AutoMesh item is True. If this item is True, the frame object is automatically meshed at intersections with other frames, area object edges and solid object edges.
     * @param numSegs This item is applicable only when the AutoMesh item is True. It is the minimum number of elements into which the frame object is automatically meshed. If this item is zero, the number of elements is not checked when the automatic meshing is done.
     * @param autoMeshMaxLength This item is applicable only when the AutoMesh item is True. It is the maximum length of auto meshed frame elements. If this item is zero, the element length is not checked when the automatic meshing is done. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the meshing options are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setAutoMesh(name: String, autoMesh: Boolean, autoMeshAtPoints: Boolean, autoMeshAtLines: Boolean, numSegs: Int, autoMeshMaxLength: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetAutoMesh", name, autoMesh, autoMeshAtPoints, autoMeshAtLines, numSegs, autoMeshMaxLength, itemType)

    /**
     * This function changes the curve data for a curved frame object and sets straight frame objects to be curved.
     * @param name The name of a defined curved frame object.
     * @param myType This is 1, 2, 3, 4, or 5, indicating the curved frame type.
     * * 1 = Circular Arc Specified by a Third Point Name
     * * 2 = Circular Arc Specified by Third Point Coordinates
     * * 3 = Circular Arc Specified by Planar Point Coordinates and Radius
     * * 4 = Parabolic Arc Specified by a Third Point Name
     * * 5 = Parabolic Arc Specified by Third Point Coordinates
     * MyTypes 1, 2, 4, and 5 all define the curve by three points. The three points are the two end point of the frame object and a third point defined by naming an existing point object or specifying point coordinates.
     * MyType 3 defines a circular curved frame by it end points, the coordinates of another point that lies in the plane of the curve but not necessarily on the curved frame, and a curve radius.
     * @param x, y, z These are point coordinates in the coordinate system specified by CSys. (L)
     * For MyType 1 and 4 these items do not apply.
     * For MyType 2 and 5 these are the coordinates of the third point on the curved frame.
     * For MyType 3 these are the coordinates of the planar point that lies in the plane of the curved frame.
     * @param pointName This is the name of the point object that is the third point on the curved frame. This item applies for MyType 1 and 4. It does not apply for MyType 2, 3 and 5.
     * @param radius The radius of the circular curved frame. This item only applies for MyType 3. (L)
     * @param numSegs This is the number of segments into which the program internally divides the curved frame.
     * @param cSys This is the coordinate system in which the coordinates x, y and z are defined.
     * @return zero if the frame object type is successfully set, otherwise it returns a nonzero value.
     */
    fun setCurved(name: String, myType: Int, x: Double, y: Double, z: Double, pointName: String, radius: Double, numSegs: Int, cSys: String = "Global"): Int =
            callFunctionInt("SetCurved", name, myType, x, y, z, pointName, radius, numSegs, cSys)

    /**
     * This function sets the design procedure for frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating the design procedure type desired for the specified frame object.
     * * 1 = Default from material
     * * 2 = No design
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the design procedure is successfully set; otherwise it returns a nonzero value.
     */
    fun setDesignProcedure(name: String, myType: Int, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetDesignProcedure", name, myType, itemType)

    /**
     * This function assigns frame object end offsets along the 1-axis of the object.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param autoOffset If this item is True, the end length offsets are automatically determined by the program from object connectivity, and the Length1, Length2 and rz items are ignored.
     * @param length1 The offset length along the 1-axis of the frame object at the I-End of the frame object. (L)
     * @param length2 The offset along the 1-axis of the frame object at the J-End of the frame object. (L)
     * @param rz The rigid zone factor. This is the fraction of the end offset length assumed to be rigid for bending and shear deformations.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the offsets are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setEndLengthOffset(name: String, autoOffset: Boolean, length1: Double, length2: Double, rz: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetEndLengthOffset", name, autoOffset, length1, length2, rz, itemType)

    /**
     * This function assigns frame object end skew data. End skew data is used in the program to plot the extruded view of bridge objects that have been updated as spine models only.
     * End skew assignments are applicable only to straight frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param skewI The angle in degrees measured counter clockwise from the positive local 3-axis to a line parallel to the I-End of the frame object (-90 < SkewI < 90). (deg)
     * @param skewJ The angle in degrees measured counter clockwise from the positive local 3-axis to a line parallel to the J-End of the frame object (-90 < SkewJ < 90). (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the end skew data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setEndSkew(name: String, skewI: Double, skewJ: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetEndSkew", name, skewI, skewJ, itemType)

    /**
     * This function assigns fireproofing to frame objects.
     * The program automatically adds the load *(weight) calculated for the fireproofing to all load patterns that include self weight.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1, 2 or 3, indicating the type of fireproofing assigned.
     * * 1 = Sprayed on - program calculate section perimeter
     * * 2 = Sprayed on - user provides section perimeter
     * * 3 = Concrete encased
     * @param thickness When MyType = 1 or MyType = 2, this is the thickness of the sprayed on fireproofing. When MyType = 3, this is the concrete cover dimension. (L)
     * @param perimeter This item applies only when MyType = 2. It is the length of fireproofing applied, measured around the perimeter of the frame object cross-section. (L)
     * @param density This is the weight per unit volume of the fireproofing material. [F/L3]
     * @param tf This item applies only when MyType = 1 or MyType = 3. If this item is True, the fireproofing is assumed to be applied to the top flange of the section. If it is False, the program assumes no fireproofing is applied to the section top flange. This flag applies for I, channel and double channel sections.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the fireproofing assignments are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setFireproofing(name: String, myType: Int, thickness: Double, perimeter: Double, density: Double, tf: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetFireproofing", name, myType, thickness, perimeter, density, tf, itemType)

    /**
     * This function adds or removes frame objects from a specified group.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified frame objects are added to the group specified by the GroupName item. If it is True, the frame objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the frame object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all frame objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected frame objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful, otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified frame object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing frame object.
     * @param GUID The GUID (Global Unique ID) for the specified frame object.
     * @return zero if the frame object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns frame object insertion point data. The assignments include the cardinal point and end joint offsets.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param cardinalPoint This is a numeric value from 1 to 11 that specifies the cardinal point for the frame object. The cardinal point specifies the relative position of the frame section on the line representing the frame object.
     * * 1 = bottom left
     * * 2 = bottom center
     * * 3 = bottom right
     * * 4 = middle left
     * * 5 = middle center
     * * 6 = middle right
     * * 7 = top left
     * * 8 = top center
     * * 9 = top right
     * * 10 = centroid
     * * 11 = shear center
     * @param mirror2 If this item is True, the frame object section is assumed to be mirrored (flipped) about its local 2-axis.
     * @param stiffTransform If this item is True, the frame object stiffness is transformed for cardinal point and joint offsets from the frame section centroid.
     * @param offset1 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the I-End of the frame object. (L)
     * * Offset1(0) = Offset in the 1-axis or X-axis direction
     * * Offset1(1) = Offset in the 2-axis or Y-axis direction
     * * Offset1(2) = Offset in the 3-axis or Z-axis direction
     * @param offset2 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the J-End of the frame object. (L)
     * * Offset2(0) = Offset in the 1-axis or X-axis direction
     * * Offset2(1) = Offset in the 2-axis or Y-axis direction
     * * Offset2(2) = Offset in the 3-axis or Z-axis direction
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the Offset1 and Offset2 items are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the insertion point data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setInsertionPoint(name: String, cardinalPoint: Int, mirror2: Boolean, stiffTransform: Boolean, offset1: ADoubleArrayByRef, offset2: ADoubleArrayByRef, cSys: String = "Local", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetInsertionPoint", name, cardinalPoint, mirror2, stiffTransform, offset1, offset2, cSys, itemType)

    /**
     * This function assigns a lateral bracing location to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating the bracing type assigned.
     * * 1 = Point bracing
     * * 2 = Uniform bracing
     * @param loc This is 1, 2 or 3, indicating the bracing location.
     * * 1 = Top
     * * 2 = Bottom
     * * 3 = All (top and bottom)
     * @param myDist1 When MyType = 1 this is the location of the point bracing.
     * When MyType = 2 this is the location of the start of the uniform bracing. (L) when RelDist = False
     * @param myDist2 This item is not used when MyType = 1.
     * When MyType = 2 this is the location of the end of the uniform bracing. (L) when RelDist = False
     * @param relDist If this item is True, MyDist1 and MyDist2 are relative distances; otherwise they are actual distances.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the location is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLateralBracing(name: String, myType: Int, loc: Int, myDist1: Double, myDist2: Double, relDist: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLateralBracing", name, myType, loc, myDist1, myDist2, relDist, itemType)

    /**
     * This function assigns deformation loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
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
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDeformation(name: String, loadPat: String, dof: ABooleanArrayByRef, d: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDeformation", name, loadPat, dof, d, itemType)

    /**
     * This function assigns distributed loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is 1 or 2, indicating the type of distributed load.
     * * 1 = Force per unit length
     * * 2 = Moment per unit length
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
     * @param dist1 This is the distance from the I-End of the frame object to the start of the distributed load. This may be a relative distance (0 <= Dist1 <= 1) or an actual distance, depending on the value of the RelDist item. (L) when RelDist is False
     * @param dist2 This is the distance from the I-End of the frame object to the end of the distributed load. This may be a relative distance (0 <= Dist2 <= 1) or an actual distance, depending on the value of the RelDist item. (L) when RelDist is False
     * @param val1 This is the load value at the start of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param val2 This is the load value at the end of the distributed load. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the loads are specified.
     * @param relDist If this item is True, the specified Dist item is a relative distance, otherwise it is an actual distance.
     * @param replace If this item is True, all previous loads, if any, assigned to the specified frame object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDistributed(name: String, loadPat: String, myType: Int, dir: Int, dist1: Double, dist2: Double, val1: Double, val2: Double, cSys: String = "Global", relDist: Boolean = true, replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDistributed", name, loadPat, myType, dir, dist1, dist2, val1, val2, cSys, relDist, replace, itemType)

    /**
     * This function assigns gravity load multipliers to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified frame object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns point loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is 1 or 2, indicating the type of point load.
     * * 1 = Force
     * * 2 = Moment
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
     * @param dist This is the distance from the I-End of the frame object to the load location. This may be a relative distance (0 <= Dist <= 1) or an actual distance, depending on the value of the RelDist item. (L) when RelDist is False
     * @param value This is the value of the point load. (F) when MyType is 1 and (FL) when MyType is 2
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the loads are specified.
     * @param relDist If this item is True, the specified Dist item is a relative distance, otherwise it is an actual distance.
     * @param replace If this item is True, all previous loads, if any, assigned to the specified frame object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadPoint(name: String, loadPat: String, myType: Int, dir: Int, dist: Double, value: Double, cSys: String = "Global", relDist: Boolean = true, replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadPoint", name, loadPat, myType, dir, dist, value, cSys, relDist, replace, itemType)

    /**
     * This function assigns strain loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param dof This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain12
     * * 3 = Strain13
     * * 4 = Curvature1
     * * 5 = Curvature2
     * * 6 = Curvature3
     * @param value This is the strain load value. (L/L) for dof = 1, 2 and 3 and (1/L) for dof = 4, 5 and 6
     * @param replace If this item is True, all previous strain loads, if any, assigned to the specified frame object(s), in the specified load pattern, for the specified degree of freedom, are deleted before making the new assignment.
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the strain load for the frame object is uniform along the object at the value specified by Val.
     * If PatternName is the name of a defined joint pattern, the strain load for the frame object is based on the specified strain value multiplied by the pattern value at the joints at each end of the frame object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadStrain(name: String, loadPat: String, dof: Int, value: Double, replace: Boolean = true, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadStrain", name, loadPat, dof, value, replace, patternName, itemType)

    /**
     * This function assigns target forces to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
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
     * @param rd This is a array of relative distances along the frame objects where the target force values apply. The relative distances specified for a given degree of freedom are applicable only if the corresponding dof item for that degree of freedom is True. The relative distance must be between 0 and 1, 0 <= RD <=1.
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
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the target forces are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadTargetForce(name: String, loadPat: String, dof: ABooleanArrayByRef, f: ADoubleArrayByRef, rd: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTargetForce", name, loadPat, dof, f, rd, itemType)

    /**
     * This function assigns temperature loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is 1, 2 or 3, indicating the type of temperature load.
     * * 1 = Temperature
     * * 2 = Temperature gradient along local 2 axis
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is the temperature change value. (T) for MyType = 1 and (T/L) for MyType = 2 and 3
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank the temperature load for the frame object is uniform along the object at the value specified by Val.
     * If PatternName is the name of a defined joint pattern, the temperature load for the frame object is based on the specified temperature value multiplied by the pattern value at the joints at each end of the frame object.
     * @param replace If this item is True, all previous temperature loads, if any, assigned to the specified frame object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadTemperature(name: String, loadPat: String, myType: Int, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTemperature", name, loadPat, myType, value, patternName, replace, itemType)

    /**
     * This function assigns advanced local axes to frame objects.
     * @param name The name of an existing frame object or group depending on the value of the ItemType item.
     * @param active This is True if advanced local axes exist.
     * @param plane2 This is 12 or 13, indicating that the local plane determined by the plane reference vector is the 1-2 plane or the 1-3 plane. This item applies only when the Active item is True.
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
     * @param plPt This is an array dimensioned to 2 (2 strings), indicating the labels of two joints that define the plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 2.
     * @param plVect This is an array dimensioned to 3 (3 doubles) that defines the plane reference vector. This item applies when the Active item is True and the PlVectOpt item is 3.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun setLocalAxesAdvanced(name: String, active: Boolean, plane2: Int, plVectOpt: Int, plCSys: String, plDir: AIntArrayByRef, plPt: AStringArrayByRef, plVect: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxesAdvanced", name, active, plane2, plVectOpt, plCSys, plDir, plPt, plVect, itemType)

    /**
     * This function assigns a local axis angle to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param ang This is the angle that the local 2 and 3 axes are rotated about the positive local 1 axis, from the default orientation or, if the Advanced item is True, from the orientation determined by the plane reference vector. The rotation for a positive angle appears counter clockwise when the local +1 axis is pointing toward you. (deg)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the local axis angle is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, ang: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, ang, itemType)

    /**
     * This function assigns mass per unit length to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param massOverL The mass per unit length assigned to the frame object. (M/L)
     * @param replace If this item is True, all existing mass assignments to the frame object are removed before assigning the specified mas. If it is False, the specified mass is added to any existing mass already assigned to the frame object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the mass is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMass(name: String, massOverL: Double, replace: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMass", name, massOverL, replace, itemType)

    /**
     * This function sets the material overwrite assignment for frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param propName This is None or a blank string, indicating that any existing material overwrites assigned to the specified frame objects are to be removed, or it is the name of an existing material property.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the material overwrite assignment is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMaterialOverwrite(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMaterialOverwrite", name, propName, itemType)

    /**
     * This function assigns material temperatures to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param temp This is the material temperature value assigned to the frame object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the frame object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the frame object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the frame object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the material temperatures are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMatTemp(name: String, temp: Double, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMatTemp", name, temp, patternName, itemType)

    /**
     * This function sets the frame modifier assignment for frame objects. The default value for all modifiers is one.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetModifiers", name, value, itemType)

    /**
     * This function assigns frame object output station data.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating how the output stations are specified.
     * * 1 = maximum segment size, that is, maximum station spacing
     * * 2 = minimum number of stations
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum number of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the frame object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects and the Name item is ignored.
     * @return zero if the data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setOutputStations(name: String, myType: Int, maxSegSize: Double, minSections: Int, noOutPutAndDesignAtElementEnds: Boolean = false, noOutPutAndDesignAtPointLoads: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOutputStations", name, myType, maxSegSize, minSections, noOutPutAndDesignAtElementEnds, noOutPutAndDesignAtPointLoads, itemType)

    /**
     * This function assigns P-Delta forces to straight frame objects. P-Delta force assignments do not apply to curved frames.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param pDeltaForce The P-Delta force assigned to the frame object. (F)
     * @param dir This is 0, 1, 2 or 3, indicating the direction of the P-Delta force assignment.
     * * 0 = Frame object local 1-axis direction
     * * 1 = Projected X direction in CSys coordinate system
     * * 2 = Projected Y direction in CSys coordinate system
     * * 3 = Projected Z direction in CSys coordinate system
     * @param replace If this item is True, all existing P-Delta force assignments to the frame object are removed before assigning the specified P-Delta force. If it is False, the specified P-Delta force is added to any existing P-Delta forces already assigned to the frame object.
     * @param cSys This is the name of the coordinate system in which the projected X, Y or Z direction P-Delta forces are defined. This item does not apply if the Dir item is zero (frame object local 1-axis direction).
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully applied, otherwise it returns a nonzero value.
     */
    fun setPDeltaForce(name: String, pDeltaForce: Double, dir: Int, replace: Boolean, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetPDeltaForce", name, pDeltaForce, dir, replace, cSys, itemType)

    /**
     * This function makes end release and partial fixity assignments to frame objects.
     * Partial fixity assignments are made to degrees of freedom that have been released only.
     * Some release assignments would cause instability in the model. An error is returned if this type of assignment is made. Unstable release assignments include the following:
     * U1 released at both ends
     * U2 released at both ends
     * U3 released at both ends
     * R1 released at both ends
     * R2 released at both ends and U3 at either end
     * R3 released at both ends and U2 at either end
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param ii, jj These are arrays of six booleans indicating the I-End and J-End releases for the frame object.
     * * ii(0) and jj(0) = U1 release
     * * ii(1) and jj(1) = U2 release
     * * ii(2) and jj(2) = U3 release
     * * ii(3) and jj(3) = R1 release
     * * ii(4) and jj(4) = R2 release
     * * ii(5) and jj(5) = R3 release
     * @param startValue, EndValue These are arrays of six values indicating the I-End and J-End partial fixity springs for the frame object.
     * * StartValue(0) and EndValue(0) = U1 partial fixity (F/L)
     * * StartValue(1) and EndValue(1) = U2 partial fixity (F/L)
     * * StartValue(2) and EndValue(2) = U3 partial fixity (F/L)
     * * StartValue(3) and EndValue(3) = R1 partial fixity (FL/rad)
     * * StartValue(4) and EndValue(4) = R2 partial fixity (FL/rad)
     * * StartValue(5) and EndValue(5) = R3 partial fixity (FL/rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun setReleases(name: String, ii: ABooleanArrayByRef, jj: ABooleanArrayByRef, startValue: ADoubleArrayByRef, endValue: ADoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetReleases", name, ii, jj, startValue, endValue, itemType)

    /**
     * This function assigns a frame section property to a frame object.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param propName This is None or the name of a frame section property to be assigned to the specified frame object(s).
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @param sVarTotalLength This is the total assumed length of the nonprismatic section. Enter 0 for this item to indicate that the section length is the same as the frame object length.
     * This item is applicable only when the assigned frame section property is a nonprismatic section.
     * @param sVarRelStartLoc This is the relative distance along the nonprismatic section to the I-End (start) of the frame object. This item is ignored when the sVarTotalLengthitem is 0.
     * This item is applicable only when the assigned frame section property is a nonprismatic section, and the sVarTotalLengthitem is greater than zero.
     * @return zero if the frame section property data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setSection(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId, sVarRelStartLoc: Double = 0.0, sVarTotalLength: Double = 0.0): Int =
            callFunctionInt("SetSection", name, propName, itemType, sVarRelStartLoc, sVarTotalLength)

    /**
     * This function sets the selected status for a frame object.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified frame object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the frame object specified by the Name item.
     * If this item is Group, the selected status is set for all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected frame objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set, otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)

    /**
     * This function makes spring assignments to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s The simple spring stiffness per unit length of the frame object. This item applies only when MyType = 1. [F/L2]
     * @param simpleSpringType This is 1, 2 or 3, indicating the simple spring type. This item applies only when MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp The name of the link property assigned to the spring. This item applies only when MyType = 2.
     * @param springLocalOneType This is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to frame object local axis
     * * 2 = In the frame object 2-3 plane
     * * 3 = User specified direction vector
     * @param dir This is 1, 2, 3, -1, -2 or -3, indicating the frame object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when SpringLocalOneType = 1.
     * @param plane23Angle This is the angle in the frame object 2-3 plane measured counter clockwise from the frame positive 2-axis to the spring positive 1-axis. This item applies only when SpringLocalOneType = 2. (deg)
     * @param vec This is an array of three values that define the direction vector of the spring positive local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when SpringLocalOneType = 3.
     * @param ang This is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when MyType = 2. (deg)
     * @param replace If this item is True, all existing spring assignments to the frame object are removed before assigning the specified spring. If it is False, the specified spring is added to any existing springs already assigned to the frame object.
     * @param cSys This is Local (meaning the frame object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when SpringLocalOneType = 3.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully applied, otherwise it returns a nonzero value.
     */
    fun setSpring(name: String, myType: Int, s: Double, simpleSpringType: Int, linkProp: String, springLocalOneType: Int, dir: Int, plane23Angle: Double, vec: ADoubleArrayByRef, ang: Double, replace: Boolean, cSys: String = "Local", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSpring", name, myType, s, simpleSpringType, linkProp, springLocalOneType, dir, plane23Angle, vec, ang, replace, cSys, itemType)

    /**
     * This function sets a curved frame object straight.
     * @param name The name of a defined curved frame object.
     * @return zero if the frame object type is successfully set, otherwise it returns a nonzero value.
     */
    fun setStraight(name: String): Int =
            callFunctionInt("SetStraight", name)

    /**
     * This function makes tension/compression force limit assignments to frame objects.
     * Note that the tension and compression limits are only used in nonlinear analyses.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param limitCompressionExists This item is True if a compression force limit exists for the frame object.
     * @param limitCompression The compression force limit for the frame object. (F)
     * @param limitTensionExists This item is True if a tension force limit exists for the frame object.
     * @param limitTension The tension force limit for the frame object. (F)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the frame object specified by the Name item.
     * If this item is Group, the assignment is made to all frame objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected frame objects, and the Name item is ignored.
     * @return zero if the assignments are successfully applied, otherwise it returns a nonzero value.
     */
    fun setTCLimits(name: String, limitCompressionExists: Boolean, limitCompression: Double, limitTensionExists: Boolean, limitTension: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetTCLimits", name, limitCompressionExists, limitCompression, limitTensionExists, limitTension, itemType)
}