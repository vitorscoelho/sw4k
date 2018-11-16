package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringByRef
import vitorscoelho.sw4k.sap14.enums.ItemType
import vitorscoelho.sw4k.sap14.enums.Dir
import vitorscoelho.sw4k.sap14.enums.DistributedLoadType

class FrameObj internal constructor(programName: String) : FrameObjV14 {
    override val activeXComponentName: String = "$programName.cFrameObj"
}

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
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: StringByRef, propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
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
    fun addByPoint(point1: String, point2: String, name: StringByRef, propName: String = "Default", userName: String = ""): Int =
            callFunctionInt("AddByPoint", point1, point2, name, propName, userName)

    /**
     * This function assigns distributed loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType This is 1 or 2 ([DistributedLoadType] enumeration), indicating the type of distributed load.
     * * 1 = Force per unit length
     * * 2 = Moment per unit length
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
     * This function assigns frame object output station data.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType This is 1 or 2, indicating how the output stations are specified.
     * * 1 = maximum segment size, that is, maximum station spacing
     * * 2 = minimum number of stations
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum number of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the frame object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @param itemType This is one of the following items in the eItemType enumeration:
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
}