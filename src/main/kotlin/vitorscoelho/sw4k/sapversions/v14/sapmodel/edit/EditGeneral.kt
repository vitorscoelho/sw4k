package vitorscoelho.sw4k.sapversions.v14.sapmodel.edit

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.Axis
import vitorscoelho.sw4k.sapenums.ObjectType
import vitorscoelho.sw4k.sapenums.MirrorPlaneType
import vitorscoelho.sw4k.sapenums.RotationAxis

interface EditGeneralV14 : SapComponent {
    /**
     * This function creates new solid objects by linearly extruding a specified area object, in the local 3-axis direction of the area object, into solid objects.
     * @param name The name of an existing area object to be extruded.
     * @param propName This is either Default or the name of a defined solid property to be used for the new extruded solid objects.
     * @param nPlus3 The number of solid objects created in the positive local 3-axis direction of the specified area object.
     * @param tPlus3 The thickness of the solid objects created in the positive local 3-axis direction of the specified area object.
     * @param nMinus3 The number of solid objects created in the negative local 3-axis direction of the specified area object.
     * @param tMinus3 The thickness of the solid objects created in the negative local 3-axis direction of the specified area object.
     * @param numberSolids The number of solid objects created when the specified area object is extruded.
     * @param solidName This is an array of the name of each solid object created when the specified area object is extruded.
     * @param remove If this item is True, the area object indicated by the Name item is deleted after the extrusion is complete.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudeAreaToSolidLinearNormal(name: String, propName: String, nPlus3: Int, tPlus3: Double, nMinus3: Int, tMinus3: Double, numberSolids: AIntByRef = IntByRef.UNNECESSARY, solidName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, remove: Boolean = true): Int =
            callFunctionInt("ExtrudeAreaToSolidLinearNormal", name, propName, nPlus3, tPlus3, nMinus3, tMinus3, numberSolids, solidName, remove)

    /**
     * This function creates new solid objects by linearly extruding a specified area object, in a user specified direction, into solid objects.
     * @param name The name of an existing area object to be extruded.
     * @param propName This is either Default or the name of a defined solid property to be used for the new extruded solid objects.
     * @param dx The x offset used, in the present coordinate system, to create each new solid object.
     * @param dy The y offset used, in the present coordinate system, to create each new solid object.
     * @param dz The z offset used, in the present coordinate system, to create each new solid object.
     * @param number The number of increments for the extrusion.
     * @param numberSolids The number of solid objects created when the specified area object is extruded. Usually this item is returned the same as the Number item. However, in some cases, such as when an area object with more than four sides is extruded, this item will be larger than the Number item.
     * @param solidName This is an array of the name of each solid object created when the specified area object is extruded.
     * @param remove If this item is True, the area object indicated by the Name item is deleted after the extrusion is complete.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudeAreaToSolidLinearUser(name: String, propName: String, dx: Double, dy: Double, dz: Double, number: Int, numberSolids: AIntByRef = IntByRef.UNNECESSARY, solidName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, remove: Boolean = true): Int =
            callFunctionInt("ExtrudeAreaToSolidLinearUser", name, propName, dx, dy, dz, number, numberSolids, solidName, remove)

    /**
     * This function creates new solid objects by radially extruding a specified area object into solid objects.
     * @param name The name of an existing area object to be extruded.
     * @param propName This is either Default or the name of a defined solid property to be used for the new extruded solid objects.
     * @param rotateAxis This is 0, 1 or 2, indicating the axis that the radial extrusion is around ([Axis] enumeration).
     * * 0 = X axis
     * * 1 = Y axis
     * * 2 = Z axis
     * @param x The x coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the X axis the value of the x coordinate is irrelevant. (L)
     * @param y The y coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Y axis the value of the y coordinate is irrelevant. (L)
     * @param z The z coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Z axis the value of the z coordinate is irrelevant. (L)
     * @param incrementAng The angle is rotated by this amount for each added solid object. (deg)
     * @param totalRise The total rise over the full length of the extrusion. (L)
     * @param number The number of angle increments for the extrusion.
     * @param numberSolids The number of solid objects created when the specified area object is extruded. Usually this item is returned the same as the Number item. However, in some cases, such as when an area object with more than four sides is extruded, this item will be larger than the Number item.
     * @param solidName This is an array of the name of each solid object created when the specified area object is extruded.
     * @param remove If this item is True, the area object indicated by the Name item is deleted after the extrusion is complete.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudeAreaToSolidRadial(name: String, propName: String, rotateAxis: Int, x: Double, y: Double, z: Double, incrementAng: Double, totalRise: Double, number: Int, numberSolids: AIntByRef = IntByRef.UNNECESSARY, solidName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, remove: Boolean = true): Int =
            callFunctionInt("ExtrudeAreaToSolidRadial", name, propName, rotateAxis, x, y, z, incrementAng, totalRise, number, numberSolids, solidName, remove)

    /**
     * This function creates new area objects by linearly extruding a specified straight frame object into area objects.
     * @param name The name of an existing straight frame object to be extruded.
     * @param propName This is Default, None or the name of a defined area property to be used for the new extruded area objects.
     * @param dx The x offset used, in the present coordinate system, to create each new area object.
     * @param dy The y offset used, in the present coordinate system, to create each new area object.
     * @param dz The z offset used, in the present coordinate system, to create each new area object.
     * @param numberAreas The number of area objects created when the specified line object is extruded.
     * @param areaName This is an array of the name of each area object created when the specified line object is extruded.
     * @param remove If this item is True, the straight frame object indicated by the Name item is deleted after the extrusion is complete.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudeFrameToAreaLinear(name: String, propName: String, dx: Double, dy: Double, dz: Double, numberAreas: Int, areaName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, remove: Boolean = true): Int =
            callFunctionInt("ExtrudeFrameToAreaLinear", name, propName, dx, dy, dz, numberAreas, areaName, remove)

    /**
     * This function creates new area objects by radially extruding a specified straight frame object into area objects.
     * @param name The name of an existing line object to be extruded.
     * @param propName This is Default, None or the name of a defined area property to be used for the new extruded area objects.
     * @param rotateAxis This is 0, 1 or 2, indicating the axis that the radial extrusion is around  ([Axis] enumeration).
     * * 0 = X axis
     * * 1 = Y axis
     * * 2 = Z axis
     * @param x The x coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the X axis the value of the x coordinate is irrelevant. (L)
     * @param y The y coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Y axis the value of the y coordinate is irrelevant. (L)
     * @param z The z coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Z axis the value of the z coordinate is irrelevant. (L)
     * @param incrementAng The angle is rotated by this amount for each added area object. (deg)
     * @param totalRise The total rise over the full length of the extrusion. (L)
     * @param numberAreas The number of area objects created when the specified line object is extruded.
     * @param areaName This is an array of the name of each area object created when the specified line object is extruded.
     * @param remove If this item is True, the straight frame object indicated by the Name item is deleted after the extrusion is complete.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudeFrameToAreaRadial(name: String, propName: String, rotateAxis: Int, x: Double, y: Double, z: Double, incrementAng: Double, totalRise: Double, numberAreas: Int, areaName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, remove: Boolean = true): Int =
            callFunctionInt("ExtrudeFrameToAreaRadial", name, propName, rotateAxis, x, y, z, incrementAng, totalRise, numberAreas, areaName, remove)

    /**
     * This function creates new frame objects by linearly extruding a specified point object into frame objects.
     * @param name The name of an existing point object to be extruded.
     * @param propName This is Default, None or the name of a defined frame section property to be used for the new extruded frame objects.
     * @param dx The x offset used, in the present coordinate system, to create each new frame object.
     * @param dy The y offset used, in the present coordinate system, to create each new frame object.
     * @param dz The z offset used, in the present coordinate system, to create each new frame object.
     * @param numberFrames The number of frame objects created when the specified point object is extruded.
     * @param frameName This is an array of the name of each frame object created when the specified point object is extruded.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudePointToFrameLinear(name: String, propName: String, dx: Double, dy: Double, dz: Double, numberFrames: Int, frameName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ExtrudePointToFrameLinear", name, propName, dx, dy, dz, numberFrames, frameName)

    /**
     * This function creates new frame objects by radially extruding a specified point object into frame objects.
     * @param name The name of an existing point object to be extruded.
     * @param propName This is Default, None or the name of a defined frame section property to be used for the new extruded frame objects.
     * @param rotateAxis This is 0, 1 or 2, indicating the axis that the radial extrusion is around ([Axis] enumeration).
     * * 0 = X axis
     * * 1 = Y axis
     * * 2 = Z axis
     * @param x The x coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the X axis, the value of the x coordinate is irrelevant. (L)
     * @param y The y coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Y axis, the value of the y coordinate is irrelevant. (L)
     * @param z The z coordinate, in the present coordinate system, of the point that the radial extrusion is around. For rotation about the Z axis, the value of the z coordinate is irrelevant. (L)
     * @param incrementAng The angle is rotated by this amount for each added frame object. (deg)
     * @param totalRise The total rise over the full length of the extrusion. (L)
     * @param numberFrames The number of frame objects created when the specified point object is extruded.
     * @param frameName This is an array of the name of each frame object created when the specified point object is extruded.
     * @return zero if the extrusion is successful; otherwise it returns a nonzero value.
     */
    fun extrudePointToFrameRadial(name: String, propName: String, rotateAxis: Int, x: Double, y: Double, z: Double, incrementAng: Double, totalRise: Double, numberFrames: Int, frameName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ExtrudePointToFrameRadial", name, propName, rotateAxis, x, y, z, incrementAng, totalRise, numberFrames, frameName)

    /**
     * This function moves selected point, frame, cable, tendon, area, solid and link objects.
     * @param dx The x offset used, in the present coordinate system, for moving the selected objects.
     * @param dy The y offset used, in the present coordinate system, for moving the selected objects.
     * @param dz The z offset used, in the present coordinate system, for moving the selected objects.
     * @return zero if the move is successful; otherwise it returns a nonzero value.
     */
    fun move(dx: Double, dy: Double, dz: Double): Int =
            callFunctionInt("Move", dx, dy, dz)

    /**
     * This function linearly replicates selected objects.
     * @param dx The x offset used, in the present coordinate system, to replicate the selected objects.
     * @param dy The y offset used, in the present coordinate system, to replicate the selected objects.
     * @param dz The z offset used, in the present coordinate system, to replicate the selected objects.
     * @param number The number of times the selected objects are to be replicated.
     * @param numberObjects The number of new objects created by the replication process.
     * @param objectName This is an array of the name of each object created by the replication process.
     * @param objectType This is an array of the type of each object created by the replication process ([ObjectType] enumeration).
     * * 1 = Point object
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * * 7 = Link object
     * @param remove If this item is True, the originally selected objects are deleted after the replication is complete.
     * @return zero if the replication is successful; otherwise it returns a nonzero value.
     */
    fun replicateLinear(dx: Double, dy: Double, dz: Double, number: Int, numberObjects: AIntByRef = IntByRef.UNNECESSARY, objectName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, objectType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, remove: Boolean = false): Int =
            callFunctionInt("ReplicateLinear", dx, dy, dz, number, numberObjects, objectName, objectType, remove)

    /**
     * This function mirror replicates selected objects.
     * @param plane This is 1, 2, 3 or 4, indicating the mirror plane type ([MirrorPlaneType] enumeration).
     * * 1 = Parallel to Z
     * * 2 = Parallel to X
     * * 3 = Parallel to Y
     * * 4 = 3D plane
     * @param x1, y1, z1, x2, y2, z2, x3, y3, z3 These are the coordinates of three points used to define the mirror plane. (L)
     * When Plane = 1, x1, y1, x2 and y2 define the intersection of the mirror plane with the XY plane.
     * When Plane = 2, y1, z1, y2 and z2 define the intersection of the mirror plane with the YZ plane.
     * When Plane = 3, x1, z1, x2 and z2 define the intersection of the mirror plane with the XZ plane.
     * When Plane = 4, x1, y1, z1, x2, y2, z2, x3, y3 and z3 define three points that define the mirror plane.
     * @param numberObjects The number of new objects created by the replication process.
     * @param objectName This is an array of the name of each object created by the replication process.
     * @param objectType This is an array of the type of each object created by the replication process ([ObjectType] enumeration).
     * * 1 = Point object
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * * 7 = Link object
     * @param remove If this item is True, the originally selected objects are deleted after the replication is complete.
     * @return zero if the replication is successful; otherwise it returns a nonzero value.
     */
    fun replicateMirror(plane: Int, x1: Double, y1: Double, z1: Double, x2: Double, y2: Double, z2: Double, x3: Double, y3: Double, z3: Double, numberObjects: AIntByRef = IntByRef.UNNECESSARY, objectName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, objectType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, remove: Boolean = false): Int =
            callFunctionInt("ReplicateMirror", plane, x1, y1, z1, x2, y2, z2, x3, y3, z3, numberObjects, objectName, objectType, remove)

    /**
     * This function radially replicates selected objects.
     * @param rotateAxis This is 1, 2, 3 or 4, indicating the rotation axis ([RotationAxis] enumeration).
     * * 1 = Parallel to X axis
     * * 2 = Parallel to Y axis
     * * 3 = Parallel to Z axis
     * * 4 = 3D line
     * @param x1, y1, z1 These are coordinates used to define the rotation axis. (L)
     * When RotateAxis = 1, y1 and z1 define the intersection of the rotation axis with the YZ plane.
     * When RotateAxis = 2, x1 and z1 define the intersection of the rotation axis with the XZ plane.
     * When RotateAxis = 3, x1 and y1 define the intersection of the rotation axis with the XY plane.
     * When RotateAxis = 4, x1, y1 and z1 define one point on the rotation axis.
     * @param x2, y2, z2 These are coordinates used to define the rotation axis when RotateAxis = 4. x2, y2 and z2 define a second point on the rotation axis. (L)
     * @param number The increment angle for each replication.
     * @param ang The number of times the selected objects are to be replicated.
     * @param numberObjects The number of new objects created by the replication process.
     * @param objectName This is an array of the name of each object created by the replication process.
     * @param objectType This is an array of the type of each object created by the replication process ([ObjectType] enumeration).
     * * 1 = Point object
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * * 7 = Link object
     * @param remove If this item is True, the originally selected objects are deleted after the replication is complete.
     * @return zero if the replication is successful; otherwise it returns a nonzero value.
     */
    fun replicateRadial(rotateAxis: Int, x1: Double, y1: Double, z1: Double, x2: Double, y2: Double, z2: Double, number: Int, ang: Double, numberObjects: AIntByRef = IntByRef.UNNECESSARY, objectName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, objectType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, remove: Boolean = false): Int =
            callFunctionInt("ReplicateRadial", rotateAxis, x1, y1, z1, x2, y2, z2, number, ang, numberObjects, objectName, objectType, remove)
}