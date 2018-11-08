package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.ItemType

class PointObj internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cPointObj") {

    /**
     * This function adds a point object to a model.
     * The added point object will be tagged as a Special Point except if it was merged with another point object.
     * Special points are allowed to exist in the model with no objects connected to them.
     * @param x The X-coordinate of the added point object in the specified coordinate system. (L)
     * @param y The Y-coordinate of the added point object in the specified coordinate system. (L)
     * @param z The Z-coordinate of the added point object in the specified coordinate system. (L)
     * @param name This is the name that the program ultimately assigns for the point object. If no UserName is specified, the program assigns a default name to the point object. If a UserName is specified and that name is not used for another point, the UserName is assigned to the point; otherwise a default name is assigned to the point. If a point is merged with another point, this will be the name of the point object with which it was merged.
     * @param userName This is an optional user specified name for the point object. If a UserName is specified and that name is already used for another point object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the joint coordinates are defined.
     * @param mergeOff If this item is False, a new point object that is added at the same location as an existing point object will be merged with the existing point object (assuming the two point objects have the same MergeNumber) and thus only one point object will exist at the location. If this item is True, the points will not merge and two point objects will exist at the same location.
     * @param mergeNumber Two points objects in the same location will merge only if their merge value assignments are the same. By default all pointobjects have a merge value of zero.
     * @return zero if the point object is successfully added or merged, otherwise it returns a nonzero value.
     */
//    fun addCartesian(x: Double, y: Double, z: Double, name: StringByRef = StringByRef.NONE, userName: String = "", cSys: String = "Global", mergeOff: Boolean = false, mergeNumber: Int = 0): Int =
//            callFunction("AddCartesian", x, y, z, name.variant, userName, cSys, mergeOff, mergeNumber).int

    /**
     * This function makes point load assignments to point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param loadPat The name of the load pattern for the point load.
     * @param value This is an array,size=6, of six point load values.
     * * Value[0] = F1 (F)
     * * Value[1] = F2 (F)
     * * Value[2] = F3 (F)
     * * Value[3] = M1 (FL)
     * * Value[4] = M2 (FL)
     * * Value[5] = M3 (FL)
     * @param replace If this item is True, all previous point loads, if any, assigned to the specified point object(s) in the specified load pattern are deleted before making the new assignment.
     * @param cSys The name of the coordinate system for the considered point load. This is Local or the name of a defined coordinate system.
     * @param itemType [ItemType]
     * @return zero if the load assignments are successfully made, otherwise it returns a nonzero value.
     */
//    fun setLoadForce(name: String, loadPat: String, value: DoubleArrayByRef, replace: Boolean = false, cSys: String = "Global", itemType: ItemType = ItemType.OBJECT): Int =
//            callFunction("SetLoadForce", name, loadPat, value.safeArray, replace, cSys, itemType.value).int

    /**
     * This function assigns coupled springs to a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param k This is an array, size=6, of six spring stiffness values.
     * * Value[0] = U1 (F/L)
     * * Value[1] = U2 (F/L)
     * * Value[2] = U3 (F/L)
     * * Value[3] = R1 (FL/rad)
     * * Value[4] = R2 (FL/rad)
     * * Value[5] = R3 (FL/rad)
     * @param itemType [ItemType]
     * @param isLocalCSys If this item is True, the specified spring assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point spring assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the spring assignments are added to any existing assignments.
     * @return zero if the stiffnesses are successfully assigned, otherwise it returns a nonzero value.
     */
//    fun setSpring(name: String, k: DoubleArrayByRef, itemType: ItemType = ItemType.OBJECT, isLocalCSys: Boolean = false, replace: Boolean = false): Int =
//            callFunction("SetSpring", name, k.safeArray, itemType.value, isLocalCSys, replace).int

    /**
     * This function assigns the restraint assignments for a point object. The restraint assignments are always set in the point local coordinate system.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param value This is an array ,size=6, of six restraint values.
     * * value[0] = U1
     * * value[1] = U2
     * * value[2] = U3
     * * value[3] = R1
     * * value[4] = R2
     * * value[5] = R3
     * @param itemType [ItemType]
     * @return zero if the restraint assignments are successfully assigned, otherwise it returns a nonzero value.
     */
//    fun setRestraint(name: String, value: BooleanArrayByRef, itemType: ItemType = ItemType.OBJECT): Int =
//            callFunction("SetRestraint", name, value.safeArray, itemType.value).int
}