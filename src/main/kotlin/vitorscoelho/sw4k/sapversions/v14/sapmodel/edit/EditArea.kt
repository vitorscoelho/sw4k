package vitorscoelho.sw4k.sapversions.v14.sapmodel.edit

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.MeshType
import vitorscoelho.sw4k.sapenums.EditAreaOffsetType

interface EditAreaV14 : SapComponent {
    /**
     * This function modifies the connectivity of an area object.
     * @param name The name of an existing area object.
     * @param numberPoints The number of points in the area abject.
     * @param point This is an array containing the names of the point objects that define the added area object. The point object names should be ordered to run clockwise or counter-clockwise around the area object.
     * @return zero if the area object connectivity is successfully modified; otherwise it returns a nonzero value.
     */
    fun changeConnectivity(name: String, numberPoints: Int, point: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("ChangeConnectivity", name, numberPoints, point)

    /**
     * This function meshes area objects.
     * @param name The name of an existing area object.
     * @param meshType This item is 1, 2, 3, 4, 5 or 6, indicating the mesh type for the area object ([MeshType] enumeration).
     * * 1 = Mesh area into a specified number of objects
     * * 2 = Mesh area into objects of a specified maximum size
     * * 3 = Mesh area based on points on area edges
     * * 4 = Cookie cut mesh area based on lines intersecting edges
     * * 5 = Cookie cut mesh area based on points
     * * 6 = Mesh area using General Divide Tool
     * Mesh options 1, 2 and 3 apply to quadrilaterals and triangles only.
     * @param numberAreas The number of area objects created when the specified area object is divided.
     * @param areaName This is an array of the name of each area object created when the specified area object is divided.
     * @param n1 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 2.
     * @param n2 This item applies when MeshType = 1. It is the number of objects created along the edge of the meshed area object that runs from point 1 to point 3.
     * @param maxSize1 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 2. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param maxSize2 This item applies when MeshType = 2. It is the maximum size of objects created along the edge of the meshed area object that runs from point 1 to point 3. (L)
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param pointOnEdgeFromGrid This item applies when MeshType = 3. If it is True, points on the area object edges are determined from intersections of visible grid lines with the area object edges.
     * @param pointOnEdgeFromLine This item applies when MeshType = 3. If it is True, points on the area object edges are determined from intersections of selected straight line objects with the area object edges.
     * @param pointOnEdgeFromPoint This item applies when MeshType = 3. If it is True, points on the area object edges are determined from selected point objects that lie on the area object edges.
     * @param extendCookieCutLines This item applies when MeshType = 4. MeshType = 4 provides cookie cut meshing based on selected straight line objects that intersect the area object edges. If the ExtendCookieCutLines item is True, all selected straight line objects are extended to intersect the area object edges for the purpose of meshing the area object.
     * @param rotation This item applies when MeshType = 5. MeshType = 5 provides cookie cut meshing based on two perpendicular lines passing through selected point objects. By default these lines align with the area object local 1 and 2 axes. The Rotation item is an angle in degrees that the meshing lines are rotated from their default orientation. (deg)
     * @param maxSizeGeneral This item applies when MeshType = 6. It is the maximum size of objects created by the General Divide Tool.
     * If this item is input as 0, the default value is used. The default value is 48 inches if the database units are English or 120 centimeters if the database units are metric.
     * @param localAxesOnEdge If this item is True, and if both points along an edge of the original area object have the same local axes, the program makes the local axes for added points along the edge the same as the edge end points.
     * @param localAxesOnFace If this item is True, and if all points around the perimeter of the original area object have the same local axes, the program makes the local axes for all added points the same as the perimeter points.
     * @param restraintsOnEdge If this item is True, and if both points along an edge of the original area object have the same restraint/constraint, then, if the added point and the adjacent corner points have the same local axes definition, the program includes the restraint/constraint for added points along the edge.
     * @param restraintsOnFace If this item is True, and if all points around the perimeter of the original area object have the same restraint/constraint, then, if an added point and the perimeter points have the same local axes definition, the program includes the restraint/constraint for the added point.
     * @return zero if the meshing is successful; otherwise it returns a nonzero value.
     */
    fun divide(name: String, meshType: Int, numberAreas: AIntByRef = IntByRef.UNNECESSARY, areaName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, n1: Int = 2, n2: Int = 2, maxSize1: Double = 0.0, maxSize2: Double = 0.0, pointOnEdgeFromGrid: Boolean = false, pointOnEdgeFromLine: Boolean = false, pointOnEdgeFromPoint: Boolean = false, extendCookieCutLines: Boolean = false, rotation: Double = 0.0, maxSizeGeneral: Double = 0.0, localAxesOnEdge: Boolean = false, localAxesOnFace: Boolean = false, restraintsOnEdge: Boolean = false, restraintsOnFace: Boolean = false): Int =
            callFunctionInt("Divide", name, meshType, numberAreas, areaName, n1, n2, maxSize1, maxSize2, pointOnEdgeFromGrid, pointOnEdgeFromLine, pointOnEdgeFromPoint, extendCookieCutLines, rotation, maxSizeGeneral, localAxesOnEdge, localAxesOnFace, restraintsOnEdge, restraintsOnFace)

    /**
     * This function expands or shrinks selected area objects.
     * @param offsetType This item is 0, 1 or 2, indicating the offset type for the selected area objects ([EditAreaOffsetType] enumeration).
     * * 0 = Offset all area edges
     * * 1 = Offset selected area edges only
     * * 2 = Offset selected points of selected areas only
     * @param offset The area edge offset distance. Positive distances expand the object and negative distances shrink the object.(L)
     * @return zero if it is successful; otherwise it returns a nonzero value.
     */
    fun divide(offsetType: Int, offset: Double): Int =
            callFunctionInt("Divide", offsetType, offset)

    /**
     * This function merges selected area objects.
     * @param numberAreas The number of originally selected area objects that remain when the merge is successfully completed.
     * @param areaName This is an array that includes the names of the selected area objects that remain when the merge is successfully completed.
     * @return zero if it is successful; otherwise it returns a nonzero value.
     */
    fun merge(numberAreas: AIntByRef = IntByRef.UNNECESSARY, areaName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("Merge", numberAreas, areaName)

    /**
     * This function adds a point object at the midpoint of selected area object edges.
     * @return zero if it is successful; otherwise it returns a nonzero value.
     */
    fun pointAdd(): Int =
            callFunctionInt("PointAdd")

    /**
     * This function removes selected point objects from selected area objects. Note that in some cases this command can cause the area object to be deleted.
     * @return zero if it is successful; otherwise it returns a nonzero value.
     */
    fun pointRemove(): Int =
            callFunctionInt("PointRemove")
}