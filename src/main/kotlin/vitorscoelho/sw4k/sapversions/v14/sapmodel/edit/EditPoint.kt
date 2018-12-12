package vitorscoelho.sw4k.sapversions.v14.sapmodel.edit

import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef
import vitorscoelho.sw4k.sapenums.EditPointAlignment

interface EditPointV14 : SapComponent {
    /**
     * This function aligns selected point objects.
     * @param myType This is 1, 2, 3 or 4, indicating the alignment option ([EditPointAlignment] enumeration).
     * * 1 = Align points to X-ordinate in present coordinate system
     * * 2 = Align points to Y-ordinate in present coordinate system
     * * 3 = Align points to Z-ordinate in present coordinate system
     * * 4 = Align points to nearest selected line object, area object edge or solid object edge
     * @param ordinate The X, Y or Z ordinate that applies if MyType is 1, 2 or 3, respectively. (L)
     * @param numberPoints The number of point objects that are in a new location after the alignment is complete.
     * @param pointName This is an array of the name of each point object that is in a new location after the alignment is complete.
     * @return zero if the alignment is successful; otherwise it returns a nonzero value.
     */
    fun align(myType: Int, ordinate: Double, numberPoints: IntByRef, pointName: StringArrayByRef): Int =
            callFunctionInt("Align", myType, ordinate, numberPoints, pointName)

    /**
     * This function changes the coordinates of a specified point object.
     * @param name The name of an existing point object.
     * @param x The new x coordinate, in the present coordinate system, for the specified point object.
     * @param y The new y coordinate, in the present coordinate system, for the specified point object.
     * @param z The new z coordinate, in the present coordinate system, for the specified point object.
     * @param noRefresh If this item is True, the model display window is not refreshed after the point object is moved.
     * @return zero if the coordinate change is successful; otherwise it returns a nonzero value.
     */
    fun changeCoordinates_1(name: String, x: Double, y: Double, z: Double, noRefresh: Boolean = false): Int =
            callFunctionInt("ChangeCoordinates_1", name, x, y, z, noRefresh)

    /**
     * This function connects objects that have been disconnected using the Disconnect function. If two or more objects have different end points objects that are at the same location, all of those objects can be connected together by selecting the objects, and selecting their end points, and calling the Connect function. The result will be that all of the objects are connected at a single point.
     * @param numberPoints The number of the point objects that remain at locations where connections were made.
     * @param pointName This is an array of the name of each point object that remains at locations where connections were made.
     * @return zero if the connect is successful; otherwise it returns a nonzero value.
     */
    fun connect(numberPoints: IntByRef, pointName: StringArrayByRef): Int =
            callFunctionInt("Connect", numberPoints, pointName)

    /**
     * This function disconnects selected point objects. Disconnect creates a separate point for each object that frames into the selected point object.
     * @param numberPoints The number of the point objects (including the original selected point objects) that are created by the disconnect action.
     * @param pointName This is an array of the name of each point object (including the original selected point objects) that is created by the disconnect action.
     * @return zero if the disconnect is successful; otherwise it returns a nonzero value.
     */
    fun disconnect(numberPoints: IntByRef, pointName: StringArrayByRef): Int =
            callFunctionInt("Disconnect", numberPoints, pointName)

    /**
     * This function merges selected point objects that are within a specified distance of one another.
     * @param mergeTol Point objects within this distance of one another are merged into one point object. (L)
     * @param numberPoints The number of the selected point objects that still exist after the merge is complete.
     * @param pointName This is an array of the name of each selected point object that still exists after the merge is complete.
     * @return zero if the merge is successful; otherwise it returns a nonzero value.
     */
    fun merge(mergeTol: Double, numberPoints: IntByRef, pointName: StringArrayByRef): Int =
            callFunctionInt("Merge", mergeTol, numberPoints, pointName)
}