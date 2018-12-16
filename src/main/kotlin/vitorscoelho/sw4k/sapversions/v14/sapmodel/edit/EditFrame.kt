package vitorscoelho.sw4k.sapversions.v14.sapmodel.edit

import vitorscoelho.sw4k.comutils.*

interface EditFrameV14 : SapComponent {
    /**
     * This function modifies the connectivity of a frame object.
     * @param name The name of an existing frame object.
     * @param point1 The name of the point object at the I-End of the frame object.
     * @param point2 The name of the point object at the J-End of the frame object.
     * @return zero if the frame object connectivity is successfully modified; otherwise it returns a nonzero value.
     */
    fun changeConnectivity(name: String, point1: String, point2: String): Int =
            callFunctionInt("ChangeConnectivity", name, point1, point2)

    /**
     * This function divides straight frame objects into two objects at a location defined by the Dist and IEnd items. Curved frame objects are not divided.
     * @param name The name of an existing straight frame object.
     * @param dist The frame object is divided at this distance from the end specified by the IEnd item.(L)
     * @param iEnd If this item is True, the Dist item is measured from the I-end of the frame object. Otherwise it is measured from the J-end of the frame object.
     * @param newName This is an array that includes the names of the two new frame objects.
     * @return zero if the frame objects are successfully divided; otherwise it returns a nonzero value.
     */
    fun divideAtDistance(name: String, dist: Double, iEnd: Boolean, newName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("DivideAtDistance", name, dist, iEnd, newName)

    /**
     * This function divides straight frame objects at intersections with selected point objects, line objects, area edges and solid edges. Curved frame objects are not divided.
     * @param name The name of an existing straight frame object.
     * @param num This is the number of frame objects into which the specified frame object is divided.
     * @param newName This is an array that includes the names of the new frame objects.
     * @return zero if the frame objects are successfully divided; otherwise it returns a nonzero value.
     */
    fun divideAtIntersections(name: String, num: ADoubleByRef = DoubleByRef.UNNECESSARY, newName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("DivideAtIntersections", name, num, newName)

    /**
     * This function divides straight frame objects based on a specified Last/First length ratio. Curved frame objects are not divided.
     * @param name The name of an existing straight frame object.
     * @param num The frame object is divided into this number of new objects.
     * @param ratio The Last/First length ratio for the new frame objects.
     * @param newName This is an array that includes the names of the new frame objects.
     * @return zero if the frame objects are successfully divided; otherwise it returns a nonzero value.
     */
    fun divideByRatio(name: String, num: Int, ratio: Double, newName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("DivideByRatio", name, num, ratio, newName)

    /**
     * This function extends straight frame objects. Curved frame objects are not extended.
     * @param name The name of an existing straight frame object to be extended.
     * @param iEnd This item is True if the I-End of the frame object specified by the Name item is to be extended.
     * @param jEnd This item is True if the J-End of the frame object specified by the Name item is to be extended.
     * @param item1 The name of an existing straight frame object used as a extension line.
     * @param item2 The name of an existing straight frame object used as a extension line.
     * @return zero if the frame objects are successfully extended; otherwise it returns a nonzero value.
     */
    fun extend(name: String, iEnd: Boolean, jEnd: Boolean, item1: String, item2: String = ""): Int =
            callFunctionInt("Extend", name, iEnd, jEnd, item1, item2)

    /**
     * This function joins two straight frame objects that have a common end point and are colinear.
     * @param name The name of an existing frame object to be joined. The new, joined frame object keeps this name.
     * @param item2 The name of an existing frame object to be joined.
     * @return zero if the frame objects are successfully joined; otherwise it returns a nonzero value.
     */
    fun join(name: String, item2: String): Int =
            callFunctionInt("Join", name, item2)

    /**
     * This function trims straight frame objects. Curved frame objects are not trimmed.
     * @param name The name of an existing straight frame object to be trimmed.
     * @param iEnd This item is True if the I-End of the frame object specified by the Name item is to be trimmed.
     * @param jEnd This item is True if the J-End of the frame object specified by the Name item is to be trimmed.
     * @param item1 The name of an existing straight frame object used as a trim line.
     * @param item2 The name of an existing straight frame object used as a trim line.
     * @return zero if the frame objects are successfully trimmed; otherwise it returns a nonzero value.
     */
    fun trim(name: String, iEnd: Boolean, jEnd: Boolean, item1: String, item2: String = ""): Int =
            callFunctionInt("Trim", name, iEnd, jEnd, item1, item2)
}