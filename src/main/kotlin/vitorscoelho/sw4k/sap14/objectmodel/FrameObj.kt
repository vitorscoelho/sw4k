package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.StringByRef
import vitorscoelho.sw4k.sap14.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.Dir
import vitorscoelho.sw4k.sap14.enums.DistributedLoadType
import vitorscoelho.sw4k.sap14.enums.ItemType
import vitorscoelho.sw4k.sap14.enums.MyType

class FrameObj internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cFrameObj") {

    /**
     * This function adds a new frame object whose end points are at the specified coordinates.
     * @param xi The coordinate x of the I-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param yi The coordinate y of the I-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param zi The coordinate z of the I-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param xj The coordinate x of the J-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param yj The coordinate y of the J-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param zj The coordinate z of the J-End of the added frame object. The coordinates are in the coordinate system defined by the CSys item.
     * @param name This is the name that the program ultimately assigns for the frame object. If no UserName is specified, the program assigns a default name to the frame object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the frame object, otherwise a default name is assigned to the frame object.
     * @param propName This is Default, None, or the name of a defined frame section property. If it is Default, the program assigns a default section property to the frame object. If it is None, no section property is assigned to the frame object. If it is the name of a defined frame section property, that property is assigned to the frame object.
     * @param userName This is an optional user specified name for the frame object. If a UserName is specified and that name is already used for another frame object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the frame object end point coordinates are defined.
     * @return zero if the frame object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByCoord(xi: Double, yi: Double, zi: Double, xj: Double, yj: Double, zj: Double, name: StringByRef = StringByRef.NONE, propName: String = "Default", userName: String = "", cSys: String = "Global"): Int =
            callFunction("AddByCoord", xi, yi, zi, xj, yj, zj, name.variant, propName, userName, cSys).int

    /**
     * This function adds a new frame object whose end points are specified by name.
     * @param point1 The name of a defined point object at the I-End of the added frame object.
     * @param point2 The name of a defined point object at the J-End of the added frame object.
     * @param name This is the name that the program ultimately assigns for the frame object. If no UserName is specified, the program assigns a default name to the frame object. If a UserName is specified and that name is not used for another frame, cable or tendon object, the UserName is assigned to the frame object, otherwise a default name is assigned to the frame object.
     * @param propName This is Default, None, or the name of a defined frame section property. If it is Default, the program assigns a default section property to the frame object. If it is None, no section property is assigned to the frame object. If it is the name of a defined frame section property, that property is assigned to the frame object.
     * @param userName This is an optional user specified name for the frame object. If a UserName is specified and that name is already used for another frame object, the program ignores the UserName.
     * @return zero if the frame object is successfully added, otherwise it returns a nonzero value.
     */
    fun addByPoint(point1: String, point2: String, name: StringByRef = StringByRef.NONE, propName: String = "Default", userName: String = ""): Int =
            callFunction("AddByPoint", point1, point2, name.variant, propName, userName).int

    /**
     * This function assigns distributed loads to frame objects.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param loadPat The name of a defined load pattern.
     * @param myType [DistributedLoadType]
     * @param dir [Dir], indicating the direction of the load.
     * @param dist1 This is the distance from the I-End of the frame object to the start of the distributed load. This may be a relative distance (0 <= Dist1 <= 1) or an actual distance, depending on the value of the RelDist item. [L] when RelDist is False
     * @param dist2 This is the distance from the I-End of the frame object to the end of the distributed load. This may be a relative distance (0 <= Dist2 <= 1) or an actual distance, depending on the value of the RelDist item. [L] when RelDist is False
     * @param val1 This is the load value at the start of the distributed load. [F/L] when MyType is 1 and [FL/L] when MyType is 2
     * @param val2 This is the load value at the end of the distributed load. [F/L] when MyType is 1 and [FL/L] when MyType is 2
     * @param cSys This is Local or the name of a defined coordinate system. It is the coordinate system in which the loads are specified.
     * @param relDist If this item is True, the specified Dist item is a relative distance, otherwise it is an actual distance.
     * @param replace If this item is True, all previous loads, if any, assigned to the specified frame object(s), in the specified load pattern, are deleted before making the new assignment.
     * @param itemType [ItemType]
     * @return zero if the loads are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setLoadDistributed(name: String, loadPat: String, myType: DistributedLoadType, dir: Dir, dist1: Double, dist2: Double, val1: Double, val2: Double, cSys: String = "Global", relDist: Boolean = true, replace: Boolean = true, itemType: ItemType = ItemType.OBJECT): Int =
            callFunction("SetLoadDistributed", name, loadPat, myType.value, dir.value, dist1, dist2, val1, val2, cSys, relDist, replace, itemType.value).int

    /**
     * This function assigns frame object output station data.
     * @param name The name of an existing frame object or group, depending on the value of the ItemType item.
     * @param myType [MyType], indicating how the output stations are specified.
     * @param maxSegSize The maximum segment size, that is, the maximum station spacing. This item applies only when MyType = 1. (L)
     * @param minSections The minimum value of stations. This item applies only when MyType = 2.
     * @param noOutPutAndDesignAtElementEnds If this item is True, no additional output stations are added at the ends of line elements when the frame object is internally meshed.
     * @param noOutPutAndDesignAtPointLoads If this item is True, no additional output stations are added at point load locations.
     * @param itemType [ItemType]
     * @return zero if the data is successfully assigned, otherwise it returns a nonzero value.
     */
    fun setOutputStations(name: String, myType: MyType, maxSegSize: Double, minSections: Int, noOutPutAndDesignAtElementEnds: Boolean = false, noOutPutAndDesignAtPointLoads: Boolean = false, itemType: ItemType = ItemType.OBJECT): Int =
            callFunction("SetOutputStations", name, myType.value, maxSegSize, minSections, noOutPutAndDesignAtElementEnds, noOutPutAndDesignAtPointLoads, itemType.value).int
}