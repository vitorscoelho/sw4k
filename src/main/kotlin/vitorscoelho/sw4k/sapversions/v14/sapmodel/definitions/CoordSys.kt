package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.*

interface CoordSysV14 : SapComponent {
    /**
     * Changing the name of the Global coordinate system will fail and return an error.
     * @param name The existing name of a defined coordinate system.
     * @param newName The new name for the coordinate system.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the number of defined coordinate systems.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * The function deletes the specified coordinate system. Attempting to delete the Global coordinate system will fail and return an error.
     * @param name The name of an existing coordinate system.
     * @return zero if the coordinate system is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * @param name The name of an existing coordinate system.
     * @param x The global X coordinate of the origin of the coordinate system. (L)
     * @param y The global Y coordinate of the origin of the coordinate system. (L)
     * @param z The global Z coordinate of the origin of the coordinate system. (L)
     * @param rZ, RY, RX The rotation of an axis of the new coordinate system relative to the global coordinate system is defined as follows: (1) Rotate the coordinate system about the positive global Z-axis as defined by the RZ item. (2) Rotate the coordinate system about the positive global Y-axis as defined by the RY item. (3) Rotate the coordinate system about the positive global X-axis as defined by the RX item. Note that the order in which these rotations are performed is important. RX, RY and RZ are angles in degrees (deg).
     * @return zero if the coordinate system data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getCoordSys(name: String, x: ADoubleByRef = DoubleByRef.UNNECESSARY, y: ADoubleByRef = DoubleByRef.UNNECESSARY, z: ADoubleByRef = DoubleByRef.UNNECESSARY, rZ: ADoubleByRef = DoubleByRef.UNNECESSARY, rY: ADoubleByRef = DoubleByRef.UNNECESSARY, rX: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetCoordSys", name, x, y, z, rZ, rY, rX)

    /**
     * This function retrieves the names of all defined coordinate systems.
     * @param numberNames The number of coordinate system names retrieved by the program.
     * @param myName This is a one-dimensional array of coordinate system names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * @param name The name of an existing coordinate system.
     * @param value Value is an array of nine direction cosines that define the transformation matrix from the specified global coordinate system to the global coordinate system.
     * The following matrix equation shows how the transformation matrix is used to convert coordinates from a coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array; (x, y, z) are the coordinates of a point in the CSys coordinate system; (ux, uy, uz) are the offset of the origin of the CSys coordinate system from the global coordinate system; and (gx, gy, gz) are the global coordinates of the point.
     * @return zero if the coordinate system transformation matrix is successfully returned, otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetTransformationMatrix", name, value)

    /**
     * Modifying the Global coordinate system will fail and return an error.
     * @param name This is the name of a coordinate system. If this is the name of an existing coordinate system, that coordinate system is modified, otherwise a new coordinate system is added.
     * @param x The global X coordinate of the origin of the coordinate system. (L)
     * @param y The global Y coordinate of the origin of the coordinate system. (L)
     * @param z The global Z coordinate of the origin of the coordinate system. (L)
     * @param rZ, rY, rX The rotation of an axis of the new coordinate system relative to the global coordinate system is defined as follows: (1) Rotate the coordinate system about the positive global Z-axis as defined by the RZ item. (2) Rotate the coordinate system about the positive global Y-axis as defined by the RY item. (3) Rotate the coordinate system about the positive global X-axis as defined by the RX item. Note that the order in which these rotations are performed is important. RX, RY and RZ are angles in degrees (deg).
     * @return zero if the coordinate system is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setCoordSys(name: String, x: Double, y: Double, z: Double, rZ: Double, rY: Double, rX: Double): Int =
            callFunctionInt("SetCoordSys", name, x, y, z, rZ, rY, rX)
}