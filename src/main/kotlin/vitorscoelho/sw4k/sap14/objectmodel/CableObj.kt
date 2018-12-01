package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class CableObj internal constructor(programName: String) : CableObjV14 {
    override val activeXComponentName: String = "$programName.cCableObj"
}

interface CableObjV14 : SapComponent {
    /**
     * This function adds a new cable object whose end points are at the specified coordinates.
     * @param xi, yi, zi The coordinates of the I-End of the added cable object. The coordinates are in the coordinate system defined by the CSys item.
     * @param xj, yj, zj The coordinates of the J-End of the added cable object. The coordinates are in the coordinate system defined by the CSys item.
     * @param name This is the name that the program ultimately assigns for the cable object. If no UserName is specified,n the program assigns a default name to the cable object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the cable object; otherwise a default name is assigned to the cable object.
     * @param propName This is Default or the name of a defined cable property.
     * If it is Default, the program assigns a default cable property to the cable object. If it is the name of a defined cable property, that property is assigned to the cable object.
     * @param userName This is an optional user specified name for the cable object. If a UserName is specified and that name is already used for another cable object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the cable object end point coordinates are defined.
     * @return zero if the cable object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: StringByRef= StringByRef(), propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", xi, yi, zi, xj, yj, zj, name, propName, userName, cSys)

    /**
     * This function adds a new cable object whose end points are specified by name.
     * @param point1 The name of a defined point object at the I-End of the added cable object.
     * @param point2 The name of a defined point object at the J-End of the added cable object.
     * @param name This is the name that the program ultimately assigns for the cable object. If no UserName is specified, the program assigns a default name to the cable object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the cable object; otherwise a default name is assigned to the cable object.
     * @param propName This is Default or the name of a defined cable property.
     * If it is Default, the program assigns a default cable property to the cable object. If it is the name of a defined cable property, that property is assigned to the cable object.
     * @param userName This is an optional user specified name for the cable object. If a UserName is specified and that name is already used for another cable object, the program ignores the UserName.
     * @return zero if the cable object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByPoint(point1: String, point2: String, name: StringByRef=StringByRef(), propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point1, point2, name, propName, userName)

    /**
     * @param name The existing name of a defined cable object.
     * @param newName The new name for the cable object.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return a count of the cable objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes the deformation load assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDeformation(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDeformation", name, loadPat, itemType)

    /**
     * This function deletes the distributed load assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadDistributed(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadDistributed", name, loadPat, itemType)

    /**
     * This function deletes the gravity load assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the strain load assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadStrain(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadStrain", name, loadPat, itemType)

    /**
     * This function deletes the target force assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadTargetForce(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTargetForce", name, loadPat, itemType)

    /**
     * This function deletes the temperature load assignments to the specified cable objects for the specified load pattern.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteLoadTemperature(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTemperature", name, loadPat, itemType)

    /**
     * This function deletes the cable mass assignments for cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the cable mass assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the cable mass assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the cable mass assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the mass assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteMass(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteMass", name, itemType)

    /**
     * This function deletes the cable modifier assignments for cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the cable modifier assignments are deleted for the cable object specified by the Name item.
     * If this item is Group, the cable modifier assignments are deleted for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the cable modifier assignments are deleted for all selected cable objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully deleted, otherwise it returns a nonzero value.
     */
    fun deleteModifiers(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteModifiers", name, itemType)

    /**
     * The function deletes cable objects.
     * @param name The name of an existing cable object or group depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the cable object specified by the Name item is deleted.
     * If this item is Group, the all cable objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all selected cable objects are deleted, and the Name item is ignored.
     * @return zero if the cable objects are successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves definition data for a specified cable object.
     * @param name The name of a defined cable object.
     * @param cableType This is 1, 2, 3, 4, 5, 6, 7, 8, or 9, indicating the cable definition parameter.
     * * 1 = Minimum tension at I-End
     * * 2 = Minimum tension at J-End
     * * 3 = Tension at I-End
     * * 4 = Tension at J-End
     * * 5 = Horizontal tension component
     * * 6 = Maximum vertical sag
     * * 7 = Low-point vertical sag
     * * 8 = Undeformed length
     * * 9 = Relative undeformed length
     * @param numSegs This is the number of segments into which the program internally divides the cable.
     * @param weight The added weight per unit length used when calculating the cable shape. (F/L)
     * @param projectedLoad The projected uniform gravity load used when calculating the cable shape. (F/L)
     * @param useDeformedGeom If this item is True, the program uses the deformed geometry for the cable object; otherwise it uses the undeformed geometry.
     * @param modelUsingFrames If this item is True, the analysis model uses frame elements to model the cable instead of using cable elements.
     * @param parameter This is an array of parameters related to the cable shape. The array is dimensioned by Sap2000.
     * * Parameter(0) = Tension at I-End (F)
     * * Parameter(1) = Tension at J-End (F)
     * * Parameter(2) = Horizontal tension component (F)
     * * Parameter(3) = Maximum deformed vertical sag (L)
     * * Parameter(4) = Deformed low-point vertical sag (L)
     * * Parameter(5) = Deformed length (L)
     * * Parameter(6) = Deformed relative length
     * * Parameter(7) = Maximum undeformed vertical sag (L)
     * * Parameter(8) = Undeformed low-point vertical sag (L)
     * * Parameter(9) = Undeformed length (L)
     * * Parameter(10) = Undeformed relative length
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getCableData(name: StringByRef, cableType: IntByRef, numSegs: IntByRef, weight: DoubleByRef, projectedLoad: DoubleByRef, useDeformedGeom: BooleanByRef, modelUsingFrames: BooleanByRef, parameter: DoubleArrayByRef): Int =
            callFunctionInt("GetCableData", name, cableType, numSegs, weight, projectedLoad, useDeformedGeom, modelUsingFrames, parameter)

    /**
     * This function retrieves geometric data for a specified cable object.
     * @param name The name of a defined cable object.
     * @param numberPoints The number of points defining the cable geometry.
     * @param x, y, z The x, y and z coordinates of the considered point on the cable in the coordinate system specified by the CSys item. (L)
     * @param sag The cable vertical sag, measured from the chord, at the considered point. (L)
     * @param dist The distance along the cable, measured from the cable I-End, to the considered point. (L)
     * @param rd The relative distance along the cable, measured from the cable I-End, to the considered point.
     * @param cSys The name of the coordinate system in which the x, y and z coordinates are to be reported.
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getCableGeometry(name: StringByRef, numberPoints: IntByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, sag: DoubleArrayByRef, dist: DoubleArrayByRef, rd: DoubleArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("GetCableGeometry", name, numberPoints, x, y, z, sag, dist, rd, cSys)

    /**
     * This function retrieves the names of the line elements (analysis model lines) associated with a specified cable object in the object-based model. It also retrieves information about the location of the line elements along the cable object.
     * @param name The name of an existing cable object.
     * @param nelm The number of line elements created from the specified cable object.
     * @param elm An array that includes the name of a line element created from the specified cable object.
     * @param rdi An array that includes the relative distance along the cable object to the I-End of the line element.
     * @param rdj An array that includes the relative distance along the cable object to the J-End of the line element.
     * @return zero if the line element information is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not currently exist.
     */
    fun getElm(name: String, nelm: IntByRef, elm: StringArrayByRef, rdi: DoubleArrayByRef, rdj: DoubleArrayByRef): Int =
            callFunctionInt("GetElm", name, nelm, elm, rdi, rdj)

    /**
     * This function retrieves the GUID for the specified cable object.
     * @param name The name of an existing cable object.
     * @param GUID The GUID (Global Unique ID) for the specified cable object.
     * @return zero if the cable object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: StringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves cable object insertion point assignments. The assignments include the end joint offsets.
     * @param name The name of an existing cable object.
     * @param stiffTransform If this item is True, the cable object stiffness is transformed for cardinal point and joint offsets from the cable section centroid.
     * @param offset1 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the I-End of the cable object. (L)
     * * Offset1(0) = Offset in the 1-axis or X-axis direction
     * * Offset1(1) = Offset in the 2-axis or Y-axis direction
     * * Offset1(2) = Offset in the 3-axis or Z-axis direction
     * @param offset2 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the J-End of the cable object. (L)
     * * Offset2(0) = Offset in the 1-axis or X-axis direction
     * * Offset2(1) = Offset in the 2-axis or Y-axis direction
     * * Offset2(2) = Offset in the 3-axis or Z-axis direction
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the Offset1 and Offset2 items are specified.
     * @return zero if the insertion point data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getInsertionPoint(name: String, stiffTransform: BooleanByRef, offset1: DoubleArrayByRef, offset2: DoubleArrayByRef, cSys: StringByRef): Int =
            callFunctionInt("GetInsertionPoint", name, stiffTransform, offset1, offset2, cSys)

    /**
     * This function retrieves the deformation load assignments to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each deformation load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each deformation load.
     * @param u1 This is an array of axial deformation load values. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDeformation(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, u1: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDeformation", name, numberItems, cableName, loadPat, u1, itemType)

    /**
     * This function retrieves the distributed load assignments to cable objects. The loads are uniformly distributed over the full length of cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of distributed loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each distributed load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the distributed loads are specified.
     * @param myType This is an array that includes 1 or 2, indicating the type of distributed load.
     * * 1 = Force
     * * 2 = Moment
     * @param cSys This is an array that includes the name of the coordinate system in which each distributed load is defined. It may be Local or the name of a defined coordinate system.
     * @param dir This is 1, 2, 3, 4, 5, 6 or 10, indicating the direction of the load.
     * * 1 = Local 1 axis (only applies when CSys is Local)
     * * 2 = Local 2 axis (only applies when CSys is Local)
     * * 3 = Local 3 axis (only applies when CSys is Local)
     * * 4 = X direction (does not apply when CSys is Local)
     * * 5 = Y direction (does not apply when CSys is Local)
     * * 6 = Z direction (does not apply when CSys is Local)
     * * 10 = Gravity direction (only applies when CSys is Global)
     * The positive gravity direction (see Dir = 10) is in the negative Global Z direction.
     * @param value This is the load value of the distributed load. The distributed load is applied over the full length of the cable. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadDistributed(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, myType: IntArrayByRef, cSys: StringArrayByRef, dir: IntArrayByRef, value: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadDistributed", name, numberItems, cableName, loadPat, myType, cSys, dir, value, itemType)

    /**
     * This function retrieves the gravity load assignments to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, cableName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the strain load assignments to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param strain This is an array that includes the axial strain value. (L/L)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, strain: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, cableName, loadPat, strain, patternName, itemType)

    /**
     * This function retrieves the target force assignments to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of deformation loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each target force.
     * @param loadPat This is an array that includes the name of the load pattern associated with each target force.
     * @param p This is an array of axial target force values. (F)
     * @param rd This is an array of the relative distances along the cable objects where the axial target force values apply.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the target force assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTargetForce(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, p: DoubleArrayByRef, rd: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTargetForce", name, numberItems, cableName, loadPat, p, rd, itemType)

    /**
     * This function retrieves the temperature load assignments to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified cable objects.
     * @param cableName This is an array that includes the name of the cable object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param value This is an array that includes the temperature load value. (T)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the cable object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected cable objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, cableName: StringArrayByRef, loadPat: StringArrayByRef, myType: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, cableName, loadPat, myType, value, patternName, itemType)

    /**
     * This function retrieves the mass per unit length assignment for cable objects.
     * @param name The name of an existing cable object.
     * @param massOverL The mass per unit length assigned to the cable object. (M/L)
     * @return zero if the mass assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMass(name: String, massOverL: DoubleByRef): Int =
            callFunctionInt("GetMass", name, massOverL)

    /**
     * This function retrieves the material overwrite assigned to a cable object, if any. It returns None if there is no material overwrite assignment.
     * @param name The name of a defined cable object.
     * @param propName This is None, indicating that no material overwrite exists for the specified cable object, or it is the name of an existing material property.
     * @return zero if the material overwrite assignment is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMaterialOverwrite(name: String, propName: StringByRef): Int =
            callFunctionInt("GetMaterialOverwrite", name, propName)

    /**
     * This function retrieves the material temperature assignments to cable objects.
     * @param name The name of an existing cable object.
     * @param temp This is the material temperature value assigned to the cable object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the cable object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the cable object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the cable object.
     * @return zero if the material temperature assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the cable modifier assignment for cable objects. The default value for all modifiers is one.
     * @param name The name of an existing cable object.
     * @param value This is an array of three unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined cable objects.
     * @param numberNames The number of cable object names retrieved by the program.
     * @param myName This is a one-dimensional array of cable object names. The MyName array is created as a dynamic, zero-based, array by the APIuser:
     * The array is dimensioned to (NumberNames � 1) inside the Sap2000 program, filled with the names, and returned to the APIuser.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves cable object output station data.
     * @param name The name of an existing cable object.
     * @param myType This is 1 or 2, indicating how the output stations are specified.
     * * 1 = maximum segment size, that is, maximum station spacing
     * * 2 = minimum number of stations
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum number of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the cable object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getOutputStations(name: String, myType: IntByRef, maxSegSize: DoubleByRef, minSections: IntByRef, noOutPutAndDesignAtElementEnds: BooleanByRef, noOutPutAndDesignAtPointLoads: BooleanByRef): Int =
            callFunctionInt("GetOutputStations", name, myType, maxSegSize, minSections, noOutPutAndDesignAtElementEnds, noOutPutAndDesignAtPointLoads)

    /**
     * This function retrieves the names of the point objects at each end of a specified cable object.
     * @param name The name of a defined cable object.
     * @param point1 The name of the point object at the I-End of the specified cable object.
     * @param point2 The name of the point object at the J-End of the specified cable object.
     * @return zero if the point names are successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point1: StringByRef, point2: StringByRef): Int =
            callFunctionInt("GetPoints", name, point1, point2)

    /**
     * This function retrieves the cable property assigned to a cable object.
     * @param name The name of a defined cable object.
     * @param propName The name of the cable property assigned to the cable object.
     * @return zero if the cable object property is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the selected status for a cable object.
     * @param name The name of an existing cable object.
     * @param selected This item returns True if the specified cable object is selected, otherwise it returns False.
     * @return zero if the selected status is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * @param name The name of an existing cable object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the cable object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the cable object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the cable object local coordinate system.
     * @return zero if the cable object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function assigns the cable definition parameters to a cable object.
     * @param name The name of a defined cable object.
     * @param cableType This is 1, 2, 3, 4, 5, 6, 7, 8, or 9, indicating the cable definition parameter.
     * * 1 = Minimum tension at I-End
     * * 2 = Minimum tension at J-End
     * * 3 = Tension at I-End
     * * 4 = Tension at J-End
     * * 5 = Horizontal tension component
     * * 6 = Maximum vertical sag
     * * 7 = Low-point vertical sag
     * * 8 = Undeformed length
     * * 9 = Relative undeformed length
     * @param numSegs This is the number of segments into which the program internally divides the cable.
     * @param weight The added weight per unit length used when calculating the cable shape. (F/L)
     * @param projectedLoad The projected uniform gravity load used when calculating the cable shape. (F/L)
     * @param value This is the value of the parameter used to define the cable shape. The item that Value represents depends on the CableType item.
     * * CableType = 1: Not Used
     * * CableType = 2: Not Used
     * * CableType = 3: Tension at I-End (F)
     * * CableType = 4: Tension at J-End (F)
     * * CableType = 5: Horizontal tension component (F)
     * * CableType = 6: Maximum vertical sag (L)
     * * CableType = 7: Low-point vertical sag (L)
     * * CableType = 8: Undeformed length (L)
     * * CableType = 9: Relative undeformed length
     * @param useDeformedGeom If this item is True, the program uses the deformed geometry for the cable object; otherwise it uses the undeformed geometry.
     * @param modelUsingFrames If this item is True, the analysis model uses frame elements to model the cable instead of using cable elements.
     * @return zero if the cable object is successfully defined; otherwise it returns a nonzero value. If the cable object is not successfully defined, it may be deleted.
     */
    fun setCableData(name: String, cableType: Int, numSegs: Int, weight: Double, projectedLoad: Double, value: Double, useDeformedGeom: Boolean = false, modelUsingFrames: Boolean = false): Int =
            callFunctionInt("SetCableData", name, cableType, numSegs, weight, projectedLoad, value, useDeformedGeom, modelUsingFrames)

    /**
     * This function adds or removes cable objects from a specified group.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified cable objects are added to the group specified by the GroupName item. If it is True, the cable objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the cable object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all cable objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected cable objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful, otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified cable object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing cable object.
     * @param GUID The GUID (Global Unique ID) for the specified cable object.
     * @return zero if the cable object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns cable object insertion point data. The assignments include the end joint offsets.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param stiffTransform If this item is True, the cable object stiffness is transformed for cardinal point and joint offsets from the cable section centroid.
     * @param offset1 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the I-End of the cable object. (L)
     * * Offset1(0) = Offset in the 1-axis or X-axis direction
     * * Offset1(1) = Offset in the 2-axis or Y-axis direction
     * * Offset1(2) = Offset in the 3-axis or Z-axis direction
     * @param offset2 This is an array of three joint offset distances, in the coordinate directions specified by CSys, at the J-End of the cable object. (L)
     * * Offset2(0) = Offset in the 1-axis or X-axis direction
     * * Offset2(1) = Offset in the 2-axis or Y-axis direction
     * * Offset2(2) = Offset in the 3-axis or Z-axis direction
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the Offset1 and Offset2 items are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the insertion point data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setInsertionPoint(name: String, stiffTransform: Boolean, offset1: DoubleArrayByRef, offset2: DoubleArrayByRef, cSys: String = "Local", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetInsertionPoint", name, stiffTransform, offset1, offset2, cSys, itemType)

    /**
     * This function assigns deformation loads to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param d This is the axial deformation load value. (L)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDeformation(name: String, loadPat: String, d: DoubleByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDeformation", name, loadPat, d, itemType)

    /**
     * This function assigns uniform distributed loads over the full length of cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is 1 or 2, indicating the type of distributed load.
     * * 1 = Force per unit length
     * * 2 = Moment per unit length
     * @param dir This is 1, 2, 3, 4, 5, 6 or 10, indicating the direction of the load.
     * * 1 = Local 1 axis (only applies when CSys is Local)
     * * 2 = Local 2 axis (only applies when CSys is Local)
     * * 3 = Local 3 axis (only applies when CSys is Local)
     * * 4 = X direction (does not apply when CSys is Local)
     * * 5 = Y direction (does not apply when CSys is Local)
     * * 6 = Z direction (does not apply when CSys is Local)
     * * 10 = Gravity direction (only applies when CSys is Global)
     * The positive gravity direction (see Dir = 10) is in the negative Global Z direction.
     * @param value This is the load value of the distributed load. The distributed load is applied over the full length of the cable. (F/L) when MyType is 1 and (FL/L) when MyType is 2
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the loads are specified.
     * @param replace If this item is True, all previous loads, if any, assigned to the specified cable object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDistributed(name: String, loadPat: String, myType: Int, dir: Int, value: Double, cSys: String = "Global", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadDistributed", name, loadPat, myType, dir, value, cSys, replace, itemType)

    /**
     * This function assigns gravity load multipliers to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified cable object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns strain loads to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param strain This is the axial strain load value. (L/L)
     * @param replace If this item is True, all previous strain loads, if any, assigned to the specified cable object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the strain load for the cable object is uniform along the object at the value specified by Strain.
     * If PatternName is the name of a defined joint pattern, the strain load for the cable object is based on the specified strain value multiplied by the pattern value at the joints at each end of the cable object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadStrain(name: String, loadPat: String, strain: Double, replace: Boolean = true, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadStrain", name, loadPat, strain, replace, patternName, itemType)

    /**
     * This function assigns target forces to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param p This is the axial target force value. (F)
     * @param rd This is the relative distance along the cable object to the location where the target force value applies. The relative distance must be between 0 and 1, 0 <= RD <=1.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the target forces are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadTargetForce(name: String, loadPat: String, p: DoubleByRef, rd: DoubleByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTargetForce", name, loadPat, p, rd, itemType)

    /**
     * This function assigns temperature loads to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the temperature change value. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the temperature load for the cable object is uniform along the object at the value specified by Val.
     * If PatternName is the name of a defined joint pattern, the temperature load for the cable object is based on the specified temperature value multiplied by the pattern value at the joints at each end of the cable object.
     * @param replace If this item is True, all previous temperature loads, if any, assigned to the specified cable object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadTemperature(name: String, loadPat: String, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTemperature", name, loadPat, value, patternName, replace, itemType)

    /**
     * This function assigns mass per unit length to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param massOverL The mass per unit length assigned to the cable object. (M/L)
     * @param replace If this item is True, all existing mass assignments to the cable object are removed before assigning the specified mas. If it is False, the specified mass is added to any mass already assigned to the cable object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the mass is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMass(name: String, massOverL: Double, replace: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMass", name, massOverL, replace, itemType)

    /**
     * This function sets the material overwrite assignment for cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param propName This is None or a blank string, indicating that any existing material overwrites assigned to the specified cable objects are to be removed, or it is the name of an existing material property.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the material overwrite assignment is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMaterialOverwrite(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMaterialOverwrite", name, propName, itemType)

    /**
     * This function assigns material temperatures to cable objects.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param temp This is the material temperature value assigned to the cable object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the cable object is uniform along the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the cable object may vary from one end to the other. The material temperature at each end of the object is equal to the specified temperature multiplied by the pattern value at the joint at the end of the cable object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the material temperatures are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setMatTemp(name: String, temp: Double, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMatTemp", name, temp, patternName, itemType)

    /**
     * This function sets the cable modifier assignment for cable objects. The default value for all modifiers is one.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param value This is an array of three unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Mass modifier
     * * Value(2) = Weight modifier
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the modifier assignments are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetModifiers", name, value, itemType)

    /**
     * This function assigns cable object output station data.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating how the output stations are specified.
     * * 1 = maximum segment size, that is, maximum station spacing
     * * 2 = minimum number of stations
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum number of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the cable object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setOutputStations(name: String, myType: Int, maxSegSize: Double, minSections: Int, noOutPutAndDesignAtElementEnds: Boolean = false, noOutPutAndDesignAtPointLoads: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetOutputStations", name, myType, maxSegSize, minSections, noOutPutAndDesignAtElementEnds, noOutPutAndDesignAtPointLoads, itemType)

    /**
     * This function assigns a cable property to a cable object.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param propName The name of a cable property to be assigned to the specified cable object(s).
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the cable object specified by the Name item.
     * If this item is Group, the assignment is made to all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected cable objects, and the Name item is ignored.
     * @return zero if the cable property is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setProperty(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetProperty", name, propName, itemType)

    /**
     * This function sets the selected status for a cable object.
     * @param name The name of an existing cable object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified cable object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the cable object specified by the Name item.
     * If this item is Group, the selected status is set for all cable objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected cable objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set, otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)
}