package vitorscoelho.sw4k.sap14.objectmodel

import vitorscoelho.sw4k.comutils.BooleanArrayByRef
import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringByRef
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.ItemType

class PointObj internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cPointObj"), PointObjV14 {

    override fun addCartesian(x: Double, y: Double, z: Double, name: StringByRef, userName: String, cSys: String, mergeOff: Boolean, mergeNumber: Int): Int =
            callFunctionInt("AddCartesian", x, y, z, name, userName, cSys, mergeOff, mergeNumber)

    override fun setLoadForce(name: String, loadPat: String, value: DoubleArrayByRef, replace: Boolean, cSys: String, itemType: Int): Int =
            callFunctionInt("SetLoadForce", name, loadPat, value, replace, cSys, itemType)

    override fun setSpring(name: String, k: DoubleArrayByRef, itemType: Int, isLocalCSys: Boolean, replace: Boolean): Int =
            callFunctionInt("SetSpring", name, k, itemType, isLocalCSys, replace)

    override fun setRestraint(name: String, value: BooleanArrayByRef, itemType: Int): Int =
            callFunctionInt("SetRestraint", name, value, itemType)
}

interface PointObjV14 {
    /**
     * This function adds a point object to a model. The added point object will be tagged as a Special Point except if it was merged with another point object. Special points are allowed to exist in the model with no objects connected to them.
     * @param x The X-coordinate of the added point object in the specified coordinate system. (L)
     * @param y The Y-coordinate of the added point object in the specified coordinate system. (L)
     * @param z The Z-coordinate of the added point object in the specified coordinate system. (L)
     * @param name This is the name that the program ultimately assigns for the point object. If no UserName is specified, the program assigns a default name to the point object. If a UserName is specified and that name is not used for another point, the UserName is assigned to the point; otherwise a default name is assigned to the point.
     * If a point is merged with another point, this will be the name of the point object with which it was merged.
     * @param userName This is an optional user specified name for the point object. If a UserName is specified and that name is already used for another point object, the program ignores the UserName.
     * @param cSys The name of the coordinate system in which the joint coordinates are defined.
     * @param mergeOff If this item is False, a new point object that is added at the same location as an existing point object will be merged with the existing point object (assuming the two point objects have the same MergeNumber) and thus only one point object will exist at the location.
     * If this item is True, the points will not merge and two point objects will exist at the same location.
     * @param mergeNumber Two points objects in the same location will merge only if their merge number assignments are the same. By default all pointobjects have a merge number of zero.
     * @return zero if the point object is successfully added or merged, otherwise it returns a nonzero value.
     */
    fun addCartesian(x: Double, y: Double, z: Double, name: StringByRef, userName: String = "", cSys: String = "Global", mergeOff: Boolean = false, mergeNumber: Int = 0): Int

    /**
     * This function makes point load assignments to point objects.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param loadPat The name of the load pattern for the point load.
     * @param value This is an array of six point load values.
     * * Value(0) = F1 (F)
     * * Value(1) = F2 (F)
     * * Value(2) = F3 (F)
     * * Value(3) = M1 (FL)
     * * Value(4) = M2 (FL)
     * * Value(5) = M3 (FL)
     * @param replace If this item is True, all previous point loads, if any, assigned to the specified point object(s) in the specified load pattern are deleted before making the new assignment.
     * @param cSys The name of the coordinate system for the considered point load. This is Local or the name of a defined coordinate system.
     * @param itemType This is one of the following items in the eItemType enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the load assignment is made to the point object specified by the Name item.
     * If this item is Group, the load assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the load assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the load assignments are successfully made, otherwise it returns a nonzero value.
     */
    fun setLoadForce(name: String, loadPat: String, value: DoubleArrayByRef, replace: Boolean = false, cSys: String = "Global", itemType: Int = ItemType.OBJECT.sapId): Int

    /**
     * This function assigns coupled springs to a point object.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param k This is an array of six spring stiffness values.
     * * Value(0) = U1 (F/L)
     * * Value(1) = U2 (F/L)
     * * Value(2) = U3 (F/L)
     * * Value(3) = R1 (FL/rad)
     * * Value(4) = R2 (FL/rad)
     * * Value(5) = R3 (FL/rad)
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the spring assignment is made to the point object specified by the Name item.
     * If this item is Group, the spring assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the spring assignment is made to all selected point objects and the Name item is ignored.
     * @param isLocalCSys If this item is True, the specified spring assignments are in the point object local coordinate system. If it is False, the assignments are in the Global coordinate system.
     * @param replace If this item is True, all existing point spring assignments to the specified point object(s) are deleted prior to making the assignment. If it is False, the spring assignments are added to any existing assignments.
     * @return zero if the stiffnesses are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setSpring(name: String, k: DoubleArrayByRef, itemType: Int = ItemType.OBJECT.sapId, isLocalCSys: Boolean = false, replace: Boolean = false): Int

    /**
     * This function assigns the restraint assignments for a point object. The restraint assignments are always set in the point local coordinate system.
     * @param name The name of an existing point object or group depending on the value of the ItemType item.
     * @param value This is an array of six restraint values.
     * * Value(0) = U1
     * * Value(1) = U2
     * * Value(2) = U3
     * * Value(3) = R1
     * * Value(4) = R2
     * * Value(5) = R3
     * @param itemType This is one of the following items in the [ItemType] enumeration:
     * * Object = 0
     * * Group = 1
     * * SelectedObjects = 2
     * If this item is Object, the restraint assignment is made to the point object specified by the Name item.
     * If this item is Group, the restraint assignment is made to all point objects in the group specified by the Name item.
     * If this item is SelectedObjects, the restraint assignment is made to all selected point objects and the Name item is ignored.
     * @return zero if the restraint assignments are successfully assigned, otherwise it returns a nonzero value.
     */
    fun setRestraint(name: String, value: BooleanArrayByRef, itemType: Int = ItemType.OBJECT.sapId): Int
}