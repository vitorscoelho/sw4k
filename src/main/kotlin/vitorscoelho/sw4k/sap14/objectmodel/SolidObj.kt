package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.ItemType

class SolidObj internal constructor(programName: String) : SolidObjV14 {
    override val activeXComponentName: String = "$programName.cSolidObj"
}

interface SolidObjV14 : SapComponent {
    /**
     * This function adds a new solid object whose corner points are at the specified coordinates. Note that solid objects always are defined with eight corner points.
     * @param x, y, z These are arrays of x, y and z coordinates, respectively, for the corner points of the solid object. The coordinates are in the coordinate system defined by the CSys item.
     * @param name This is the name that the program ultimately assigns for the solid object. If no UserName is specified, the program assigns a default name to the solid object. If a UserName is specified and that name is not used for another solid object, the UserName is assigned to the solid object; otherwise a default name is assigned to the solid object.
     * @param propName This is either Default or the name of a defined solid property.
     * If it is Default, the program assigns a default solid property to the solid object. If it is the name of a defined solid property, that property is assigned to the solid object.
     * @param userName This is an optional user specified name for the solid object. If a UserName is specified and that name is already used for another solid object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the solid object point coordinates are defined.
     * @return zero if the solid object is successfully added; otherwise it returns a nonzero value.
     */
    fun addByCoord(x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunctionInt("AddByCoord", x, y, z, name, propName, userName, cSys)

    /**
     * This function adds a new solid object whose corner points are specified by name.
     * @param point This is an array containing the names of the eight point objects that define the corner points of the added solid object.
     * @param name This is the name that the program ultimately assigns for the solid object. If no UserName is specified, the program assigns a default name to the solid object. If a UserName is specified and that name is not used for another solid object, the UserName is assigned to the solid object; otherwise a default name is assigned to the solid object.
     * @param propName This is either Default or the name of a defined solid property.
     * If it is Default, the program assigns a default solid property to the solid object. If it is the name of a defined solid property, that property is assigned to the solid object.
     * @param userName This is an optional user specified name for the solid object. If a UserName is specified and that name is already used for another solid object, the program ignores the UserName.
     * @return zero if the solid object is successfully added; otherwise it returns a nonzero value.
     */
    fun addByPoint(point: StringArrayByRef, name: StringByRef = StringByRef(), propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point, name, propName, userName)

    /**
     * This function applies a new name to a solid object.
     * @param name The existing name of a defined solid object.
     * @param newName The new name for the solid object.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return a count of the solid objects in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes the gravity load assignments to the specified solid objects for the specified load pattern.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadGravity(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadGravity", name, loadPat, itemType)

    /**
     * This function deletes the pore pressure load assignments to the specified solid objects for the specified load pattern.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadPorePressure(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadPorePressure", name, loadPat, itemType)

    /**
     * This function deletes the strain load assignments to the specified solid objects, for the specified load pattern, for the specified components.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param component This is 1, 2, 3, 4, 5 or 6, indicating the component for which the strain load is to be deleted.
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain33
     * * 4 = Strain12
     * * 5 = Strain13
     * * 6 = Strain23
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadStrain(name: String, loadPat: String, component: Int, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadStrain", name, loadPat, component, itemType)

    /**
     * This function deletes the surface pressure load assignments to the specified solid objects for the specified load pattern.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadSurfacePressure(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadSurfacePressure", name, loadPat, itemType)

    /**
     * This function deletes the temperature load assignments to the specified solid objects for the specified load pattern.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the load assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteLoadTemperature(name: String, loadPat: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteLoadTemperature", name, loadPat, itemType)

    /**
     * This function deletes all spring assignments for the specified solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the spring assignments are deleted for the solid object specified by the Name item.
     * If this item is Group, the spring assignments are deleted for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the spring assignments are deleted for all selected solid objects, and the Name item is ignored.
     * @return zero if the assignments are successfully deleted; otherwise it returns a nonzero value.
     */
    fun deleteSpring(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("DeleteSpring", name, itemType)

    /**
     * The function deletes solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the solid object specified by the Name item is deleted.
     * If this item is Group, the all solid objects in the group specified by the Name item are deleted.
     * If this item is SelectedObjects, all selected solid objects are deleted, and the Name item is ignored.
     * @return zero if the solid objects are successfully deleted; otherwise it returns a nonzero value.
     */
    fun delete(name: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("Delete", name, itemType)

    /**
     * This function retrieves the automatic meshing assignments to solid objects.
     * @param name The name of an existing solid object.
     * @param meshType This item is 0, 1 or 2, indicating the automatic mesh type for the solid object.
     * * 0 = No automatic meshing
     * * 1 = Mesh solid into a specified number of objects
     * * 2 = Mesh solid into objects of a specified maximum size
     * @param n1 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 2.
     * @param n2 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 3.
     * @param n3 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 5.
     * @param maxSize1 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 2. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize2 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 3. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize3 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 5. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param restraintsOnEdge If this item is True, and if both points along an edge of the original solid object have the same restraint/constraint, then, if the an added point on that edge and the original corner points have the same local axes definition, the program assigns the restraint/constraint to the added point.
     * @param restraintsOnFace If this item is True, and if all corner points on an solid object face have the same restraint/constraint, then, if an added point on that face and the original corner points for the face have the same local axes definition, the program assigns the restraint/constraint to the added point.
     * @return zero if the meshing assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAutoMesh(name: String, meshType: IntByRef, n1: IntByRef, n2: IntByRef, n3: IntByRef, maxSize1: DoubleByRef, maxSize2: DoubleByRef, maxSize3: DoubleByRef, restraintsOnEdge: BooleanByRef, restraintsOnFace: BooleanByRef): Int =
            callFunctionInt("GetAutoMesh", name, meshType, n1, n2, n3, maxSize1, maxSize2, maxSize3, restraintsOnEdge, restraintsOnFace)

    /**
     * This function retrieves the generated edge constraint assignments to solid objects.
     * @param name The name of an existing solid object.
     * @param constraintExists This item is True if an automatic edge constraint is generated by the program for the solid object in the analysis model.
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEdgeConstraint(name: String, constraintExists: BooleanByRef): Int =
            callFunctionInt("GetEdgeConstraint", name, constraintExists)

    /**
     * This function retrieves the names of the solid elements (analysis model solid) associated with a specified solid object in the object-based model.
     * @param name The name of an existing solid object.
     * @param nelm The number of solid elements created from the specified solid object.
     * @param elm An array that includes the name of a solid element created from the specified solid object.
     * @return zero if the solid element information is successfully returned; otherwise it returns nonzero. An error occurs if the analysis model does not exist.
     */
    fun getElm(name: String, nelm: IntByRef, elm: StringArrayByRef): Int =
            callFunctionInt("GetElm", name, nelm, elm)

    /**
     * This function retrieves the GUID for the specified solid object.
     * @param name The name of an existing solid object.
     * @param GUID The GUID (Global Unique ID) for the specified solid object.
     * @return zero if the solid object GUID is successfully retrieved; otherwise it returns nonzero.
     */
    fun getGUID(name: String, GUID: StringByRef): Int =
            callFunctionInt("GetGUID", name, GUID)

    /**
     * This function retrieves the gravity load assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified solid objects.
     * @param solidName This is an array that includes the name of the solid object associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x, y, z These are arrays of gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the solid object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, solidName, loadPat, cSys, x, y, z, itemType)

    /**
     * This function retrieves the pore pressure load assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of pore pressure loads retrieved for the specified solid objects.
     * @param solidName This is an array that includes the name of the solid object associated with each pore pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each pore pressure load.
     * @param value This is an array that includes the pore pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the pore pressure load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the solid object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadPorePressure(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadPorePressure", name, numberItems, solidName, loadPat, value, patternName, itemType)

    /**
     * This function retrieves the strain load assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified solid objects.
     * @param solidName This is an array that includes the name of the solid object associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param component This is 1, 2, 3, 4, 5 or 6, indicating the component to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain33
     * * 4 = Strain12
     * * 5 = Strain13
     * * 6 = Strain23
     * @param value This is an array that includes the strain value. (L/L)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the solid object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected solid objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, component: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, solidName, loadPat, component, value, patternName, itemType)

    /**
     * This function retrieves the surface pressure load assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of surface pressure loads retrieved for the specified solid objects.
     * @param solidName This is an array that includes the name of the solid object associated with each surface pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each surface pressure load.
     * @param face This is an array that includes 1, 2, 3, 4, 5 or 6, indicating the solid object face to which the specified load assignment applies.
     * @param value This is an array that includes the surface pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the surface pressure load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the solid object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadSurfacePressure(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, face: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadSurfacePressure", name, numberItems, solidName, loadPat, face, value, patternName, itemType)

    /**
     * This function retrieves the temperature load assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified solid objects.
     * @param solidName This is an array that includes the name of the solid object associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param value This is an array that includes the temperature load value. (T)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignments are retrieved for the solid object specified by the Name item.
     * If this item is Group, the assignments are retrieved for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignments are retrieved for all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, solidName, loadPat, value, patternName, itemType)

    /**
     * This function assigns advanced local axes to solid objects.
     * @param name The name of an existing solid object.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2 or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 1 (2 integers) indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
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
     * @param plane2 This is 12, 13, 21, 23, 31 or 32, indicating that the local plane determined by the plane reference vector is the 1-2, 1-3, 2-1, 2-3, 3-1, 0r 3-2 plane. This item applies only when the Active item is True.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun getLocalAxesAdvanced(name: String, active: BooleanByRef, axVectOpt: IntByRef, axCSys: StringByRef, axDir: IntArrayByRef, axPt: StringArrayByRef, axVect: DoubleArrayByRef, plane2: IntByRef, plVectOpt: IntByRef, plCSys: StringByRef, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef): Int =
            callFunctionInt("GetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect)

    /**
     * This function retrieves the local axes angles for a solid object.
     * @param name The name of an existing solid object.
     * @param a, b, c The local axes of the solid object are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @param advanced This item is True if the solid object local axes orientation was obtained using advanced local axes parameters.
     * @return zero if the local axes angles are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, a: DoubleByRef, b: DoubleByRef, c: DoubleByRef, advanced: BooleanByRef): Int =
            callFunctionInt("GetLocalAxes", name, a, b, c, advanced)

    /**
     * This function retrieves the material temperature assignments to solid objects.
     * @param name The name of an existing solid object.
     * @param temp This is the material temperature value assigned to the solid object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the solid object is uniform over the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the solid object may vary. The material temperature at each corner point of the solid object is equal to the specified temperature multiplied by the pattern value at the associated point object. The material temperature at other points in the solid object is calculated by interpolation from the corner points.
     * @return zero if the material temperature assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the names of all defined solid objects.
     * @param numberNames The number of solid object names retrieved by the program.
     * @param myName This is a one-dimensional array of solid object names. The MyName array is created as a dynamic, zero-based, array by the APIuser:
     * The array is dimensioned to (NumberNames � 1) inside the SAP2000 program, filled with the names, and returned to the APIuser.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of the corner point objects of a solid object.
     * @param name The name of a defined solid object.
     * @param point This is an array containing the names of the corner point objects of the solid object.
     * @return zero if the point object names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point: StringArrayByRef): Int =
            callFunctionInt("GetPoints", name, point)

    /**
     * This function retrieves the solid property assigned to a solid object.
     * @param name The name of a defined solid object.
     * @param propName The name of the solid property assigned to the solid object.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the selected status for a solid object.
     * @param name The name of an existing solid object.
     * @param selected This item is True if the specified solid object is selected; otherwise it is False.
     * @return zero if the selected status is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSelected(name: String, selected: BooleanByRef): Int =
            callFunctionInt("GetSelected", name, selected)

    /**
     * This function retrieves the spring assignments to a solid object face.
     * @param name The name of an existing solid object.
     * @param numberSprings The number of springs assignments made to the specified solid object.
     * @param myType Each value in this array is either 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s Each value in this array is the simple spring stiffness per unit area of the specified solid object face. This item applies only when the corresponding MyType = 1. (F/L3)
     * @param simpleSpringType Each value in this array is 1, 2 or 3, indicating the simple spring type. This item applies only when the corresponding MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp Each value in this array is the name of the link property assigned to the spring. This item applies only when the corresponding MyType = 2.
     * @param face This is 1, 2, 3, 4, 5 or 6, indicating the solid object face to which the specified spring assignment applies.
     * @param springLocalOneType Each value in this array is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to solid object local axis
     * * 2 = Normal to specified solid object face
     * * 3 = User specified direction vector
     * @param dir Each value in this array is 1, 2, 3, -1, -2 or -3, indicating the solid object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when the corresponding SpringLocalOneType = 1.
     * @param outward Each value in this array is True if the spring positive local 1 axis is outward from the specified solid object face. This item applies only when SpringLocalOneType = 2.
     * @param vecX Each value in this array is the X-axis or solid object local 1-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecY Each value in this array is the Y-axis or solid object local 2-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param vecZ Each value in this array is the X-axis or solid object local 3-axis component (depending on the CSys specified) of the user specified direction vector for the spring local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param cSys Each value in this array is Local (meaning the solid object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when the corresponding SpringLocalOneType = 3.
     * @param ang Each value in this array is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when the corresponding MyType = 2. (deg)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSpring(name: String, numberSprings: IntByRef, myType: IntArrayByRef, s: DoubleArrayByRef, simpleSpringType: IntArrayByRef, linkProp: StringArrayByRef, face: IntArrayByRef, springLocalOneType: IntArrayByRef, dir: IntArrayByRef, outward: BooleanArrayByRef, vecX: DoubleArrayByRef, vecY: DoubleArrayByRef, vecZ: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("GetSpring", name, numberSprings, myType, s, simpleSpringType, linkProp, face, springLocalOneType, dir, outward, vecX, vecY, vecZ, cSys, ang)

    /**
     * @param name The name of an existing solid object.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the solid object local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the object local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * The transformation from the local coordinate system to the present coordinate system is the same as that shown above for the global system if you substitute the present system for the global system.
     * @param isGlobal If this item is True, the transformation matrix is between the Global coordinate system and the solid object local coordinate system.
     * If this item is False, the transformation matrix is between the present coordinate system and the solid object local coordinate system.
     * @return zero if the solid object transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef, isGlobal: Boolean = true): Int =
            callFunctionInt("GetTransformationMatrix", name, value, isGlobal)

    /**
     * This function makes automatic meshing assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param meshType This item is 0, 1 or 2, indicating the automatic mesh type for the solid object.
     * * 0 = No automatic meshing
     * * 1 = Mesh solid into a specified number of objects
     * * 2 = Mesh solid into objects of a specified maximum size
     * @param n1 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 2.
     * @param n2 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 3.
     * @param n3 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed solid object that runs from point 1 to point 5.
     * @param maxSize1 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 2. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize2 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 3. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize3 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed solid object that runs from point 1 to point 5. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param restraintsOnEdge If this item is True, and if both points along an edge of the original solid object have the same restraint/constraint, then, if the an added point on that edge and the original corner points have the same local axes definition, the program assigns the restraint/constraint to the added point.
     * @param restraintsOnFace If this item is True, and if all corner points on an solid object face have the same restraint/constraint, then, if an added point on that face and the original corner points for the face have the same local axes definition, the program assigns the restraint/constraint to the added point.
     * @return zero if the meshing options are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setAutoMesh(name: String, meshType: Int, n1: Int = 2, n2: Int = 2, n3: Int = 2, maxSize1: Double = 0.0, maxSize2: Double = 0.0, maxSize3: Double = 0.0, restraintsOnEdge: Boolean = false, restraintsOnFace: Boolean = false): Int =
            callFunctionInt("SetAutoMesh", name, meshType, n1, n2, n3, maxSize1, maxSize2, maxSize3, restraintsOnEdge, restraintsOnFace)

    /**
     * This function makes generated edge constraint assignments to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param constraintExists This item is True if an automatic edge constraint is generated by the program for the solid object in the analysis model.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the edge constraint option is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setEdgeConstraint(name: String, constraintExists: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetEdgeConstraint", name, constraintExists, itemType)

    /**
     * This function adds or removes solid objects from a specified group.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param groupName The name of an existing group to which the assignment is made.
     * @param remove If this item is False, the specified solid objects are added to the group specified by the GroupName item. If it is True, the solid objects are removed from the group.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the solid object specified by the Name item is added or removed from the group specified by the GroupName item.
     * If this item is Group, all solid objects in the group specified by the Name item are added or removed from the group specified by the GroupName item.
     * If this item is SelectedObjects, all selected solid objects are added or removed from the group specified by the GroupName item, and the Name item is ignored.
     * @return zero if the group assignment is successful; otherwise it returns a nonzero value.
     */
    fun setGroupAssign(name: String, groupName: String, remove: Boolean = false, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetGroupAssign", name, groupName, remove, itemType)

    /**
     * This function sets the GUID for the specified solid object. If the GUID is passed in as a blank string, the program automatically creates a GUID for the object.
     * @param name The name of an existing solid object.
     * @param GUID The GUID (Global Unique ID) for the specified solid object.
     * @return zero if the solid object GUID is successfully set; otherwise it returns nonzero.
     */
    fun setGUID(name: String, GUID: String = ""): Int =
            callFunctionInt("SetGUID", name, GUID)

    /**
     * This function assigns gravity load multipliers to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param x, y, z These are the gravity load multipliers in the x, y and z directions of the specified coordinate system.
     * @param replace If this item is True, all previous gravity loads, if any, assigned to the specified solid object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param cSys The coordinate system in which the x, y and z multipliers are specified.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadGravity(name: String, loadPat: String, x: Double, y: Double, z: Double, replace: Boolean = true, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadGravity", name, loadPat, x, y, z, replace, cSys, itemType)

    /**
     * This function assigns pore pressure loads to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the pore pressure value. (F/L2)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the pore pressure load for the solid object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the pore pressure load for the solid object is based on the specified pore pressure value multiplied by the pattern value at the corner point objects of the solid object.
     * @param replace If this item is True, all previous pore pressure loads, if any, assigned to the specified solid object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadPorePressure(name: String, loadPat: String, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadPorePressure", name, loadPat, value, patternName, replace, itemType)

    /**
     * This function assigns strain loads to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param component This is 1, 2, 3, 4, 5 or 6, indicating the component to which the strain load is applied.
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain33
     * * 4 = Strain12
     * * 5 = Strain13
     * * 6 = Strain23
     * @param value This is the strain load value. (L/L)
     * @param replace If this item is True, all previous strain loads, if any, assigned to the specified solid object(s), in the specified load pattern, for the specified degree of freedom, are deleted before making the new assignment.
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the strain load for the solid object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the strain load for the solid object is based on the specified strain value multiplied by the pattern value at the corner point objects of the solid object.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadStrain(name: String, loadPat: String, component: Int, value: Double, replace: Boolean = true, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadStrain", name, loadPat, component, value, replace, patternName, itemType)

    /**
     * This function assigns surface pressure loads to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param face This is 1, 2, 3, 4, 5 or 6, indicating the solid object face to which the specified load assignment applies.
     * @param value This is the surface pressure value. (F/L2)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the surface pressure load for the solid object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the surface pressure load for the solid object is based on the specified surface pressure value multiplied by the pattern value at the corner point objects of the solid object.
     * @param replace If this item is True, all previous surface pressure loads, if any, assigned to the specified solid object(s), on the specified face, in the specified load pattern, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadSurfacePressure(name: String, loadPat: String, face: Int, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadSurfacePressure", name, loadPat, face, value, patternName, replace, itemType)

    /**
     * This function assigns temperature loads to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param value This is the temperature change value. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the temperature load for the solid object is uniform over the object at the value specified by Value.
     * If PatternName is the name of a defined joint pattern, the temperature load for the solid object is based on the specified temperature value multiplied by the pattern value at the corner point objects of the solid object.
     * @param replace If this item is True, all previous temperature loads, if any, assigned to the specified solid object(s), in the specified load case, are deleted before making the new assignment.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the loads are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setLoadTemperature(name: String, loadPat: String, value: Double, patternName: String = "", replace: Boolean = true, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLoadTemperature", name, loadPat, value, patternName, replace, itemType)

    /**
     * This function assigns advanced local axes to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param active This is True if advanced local axes exist.
     * @param axVectOpt, PlVectOpt This is 1, 2, or 3, indicating the axis/plane reference vector option. This item applies only when the Active item is True.
     * * 1 = Coordinate direction
     * * 2 = Two joints
     * * 3 = User vector
     * @param axCSys, PlCSys The coordinate system used to define the axis/plane reference vector coordinate directions and the axis/plane user vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1 or 3.
     * @param axDir, PlDir This is an array dimensioned to 1 (2 integers) indicating the axis/plane reference vector primary and secondary coordinate directions, PlDir(0) and PlDir(1) respectively, taken at the object center in the specified coordinate system and used to determine the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 1. Possible coordinate direction values are:
     * * 1 = +X -1 = -X
     * * 2 = +Y -2 = -Y
     * * 3 = +Z -3 = -Z
     * * 4 = +CR -4 = -CR
     * * 5 = +CA -5 = -CA
     * * 6 = +CZ -6 = -CZ
     * * 7 = +SR -7 = -SR
     * * 8 = +SA -8 = -SA
     * * 9 = +SB -9 = -SB
     * @param axPt, PlPt This is an array dimensioned to 1 (2 strings) indicating the labels of two joints that define the axis/plane reference vector. Either of these joints may be specified as None to indicate the center of the specified object. If both joints are specified as None, they are not used to define the plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 2.
     * @param axVect, PlVect This is an array dimensioned to 2 (3 doubles) that defines the axis/plane reference vector. This item applies when the Active item is True and the AxVectOpt/PlVectOpt item is 3.
     * @param plane2 This is 12, 13, 21, 23, 31 or 32, indicating that the local plane determined by the plane reference vector is the 1-2, 1-3, 2-1, 2-3, 3-1, or 3-2 plane. This item applies only when the Active item is True.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * Selection = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is Selection, assignment is made to all selected solid objects and the Name item is ignored.
     * @return zero if the advanced local axes assignments are assigned successfully; otherwise it returns a nonzero value.
     */
    fun setLocalAxesAdvanced(name: String, active: Boolean, axVectOpt: Int, axCSys: String, axDir: IntArrayByRef, axPt: StringArrayByRef, axVect: DoubleArrayByRef, plane2: Int, plVectOpt: Int, plCSys: String, plDir: IntArrayByRef, plPt: StringArrayByRef, plVect: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxesAdvanced", name, active, axVectOpt, axCSys, axDir, axPt, axVect, plane2, plVectOpt, plCSys, plDir, plPt, plVect, itemType)

    /**
     * This function sets the local axes angles for solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param a, b, c The local axes of the solid object are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the local axes assignment is made to the solid object specified by the Name item.
     * If this item is Group, the local axes assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the local axes assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the local axes angles are successfully set; otherwise it returns a nonzero value.
     */
    fun setLocalAxes(name: String, a: Double, b: Double, c: Double, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetLocalAxes", name, a, b, c, itemType)

    /**
     * This function assigns material temperatures to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param temp This is the material temperature value assigned to the solid object. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the solid object is uniform over the object at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the solid object may vary. The material temperature at each corner point of the solid object is equal to the specified temperature multiplied by the pattern value at the associated point object. The material temperature at other points in the solid object is calculated by interpolation from the corner points.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the material temperatures are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMatTemp(name: String, temp: Double, patternName: String = "", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetMatTemp", name, temp, patternName, itemType)

    /**
     * This function assigns a solid property to solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param propName This is the name of a solid property to be assigned to the specified solid object(s).
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the property is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setProperty(name: String, propName: String, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetProperty", name, propName, itemType)

    /**
     * This function sets the selected status for solid objects.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param selected This item is True if the specified solid object is selected, otherwise it is False.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the selected status is set for the solid object specified by the Name item.
     * If this item is Group, the selected status is set for all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, the selected status is set for all selected solid objects, and the Name item is ignored.
     * @return zero if the selected status is successfully set; otherwise it returns a nonzero value.
     */
    fun setSelected(name: String, selected: Boolean, itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSelected", name, selected, itemType)

    /**
     * This function makes spring assignments to solid objects. The springs are assigned to a specified solid object face.
     * @param name The name of an existing solid object or group, depending on the value of the ItemType item.
     * @param myType This is either 1 or 2, indicating the spring property type.
     * * 1 = Simple spring
     * * 2 = Link property
     * @param s The simple spring stiffness per unit area of the specified solid object face. This item applies only when MyType = 1. (F/L3)
     * @param simpleSpringType This is 1, 2 or 3, indicating the simple spring type. This item applies only when MyType = 1.
     * * 1 = Spring resists tension and compression
     * * 2 = Spring resists compression only
     * * 3 = Spring resists tension only
     * @param linkProp The name of the link property assigned to the spring. This item applies only when MyType = 2.
     * @param face This is 1, 2, 3, 4, 5 or 6, indicating the solid object face to which the specified spring assignment applies.
     * @param springLocalOneType This is 1, 2 or 3, indicating the method used to specify the spring positive local 1-axis orientation.
     * * 1 = Parallel to solid object local axis
     * * 2 = Normal to specified solid object face
     * * 3 = User specified direction vector
     * @param dir This is 1, 2, 3, -1, -2 or -3, indicating the solid object local axis that corresponds to the positive local 1-axis of the spring. This item applies only when SpringLocalOneType = 1.
     * @param outward This item is True if the spring positive local 1 axis is outward from the specified solid object face. This item applies only when SpringLocalOneType = 2.
     * @param vec This is an array of three values that define the direction vector of the spring positive local 1-axis. The direction vector is in the coordinate system specified by the CSys item. This item applies only when SpringLocalOneType = 3.
     * @param ang This is the angle that the link local 2-axis is rotated from its default orientation. This item applies only when MyType = 2. (deg)
     * @param replace If this item is True, all existing spring assignments to the solid object are removed before assigning the specified spring. If it is False, the specified spring is added to any existing springs already assigned to the solid object.
     * @param cSys This is Local (meaning the solid object local coordinate system) or the name of a defined coordinate system. This item is the coordinate system in which the user specified direction vector, Vec, is specified. This item applies only when SpringLocalOneType = 3.
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the assignment is made to the solid object specified by the Name item.
     * If this item is Group, the assignment is made to all solid objects in the group specified by the Name item.
     * If this item is SelectedObjects, assignment is made to all selected solid objects, and the Name item is ignored.
     * @return zero if the assignments are successfully applied; otherwise it returns a nonzero value.
     */
    fun setSpring(name: String, myType: Int, s: Double, simpleSpringType: Int, linkProp: String, face: Int, springLocalOneType: Int, dir: Int, outward: Boolean, vec: DoubleArrayByRef, ang: Double, replace: Boolean, cSys: String = "Local", itemType: Int = ItemType.OBJECT.sapId): Int =
            callFunctionInt("SetSpring", name, myType, s, simpleSpringType, linkProp, face, springLocalOneType, dir, outward, vec, ang, replace, cSys, itemType)
}