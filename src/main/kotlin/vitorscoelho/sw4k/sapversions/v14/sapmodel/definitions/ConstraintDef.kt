package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.ConstraintType
import vitorscoelho.sw4k.sap.sapmodel.enums.ConstraintAxis

interface ConstraintDefV14 : SapComponent {
    /**
     * @param name The existing name of a defined constraint.
     * @param newName The new name for the constraint.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined constraints.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * @param constraintType This is one of the following items in the [ConstraintType] enumeration:
     * CONSTRAINT_BODY = 1
     * CONSTRAINT_DIAPHRAGM = 2
     * CONSTRAINT_PLATE = 3
     * CONSTRAINT_ROD = 4
     * CONSTRAINT_BEAM = 5
     * CONSTRAINT_EQUAL = 6
     * CONSTRAINT_LOCAL = 7
     * CONSTRAINT_WELD = 8
     * CONSTRAINT_LINE = 13
     * @return the number of defined constraints of the specified type.
     */
    fun count(constraintType: Int): Int =
            callFunctionInt("Count", constraintType)

    /**
     * The function deletes the specified constraint. All constraint assignments for that constraint are also deleted.
     * @param name The name of an existing constraint.
     * @return zero if the constraint is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is parallel to the axis of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getBeam(name: String, axis: IntByRef, cSys: StringByRef): Int =
            callFunctionInt("GetBeam", name, axis, cSys)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getBody(name: String, value: BooleanArrayByRef, cSys: StringByRef): Int =
            callFunctionInt("GetBody", name, value, cSys)

    /**
     * The function returns the constraint type for the specified constraint.
     * @param name The name of an existing constraint.
     * @param constraintType This is one of the following items in the [ConstraintType] enumeration:
     * CONSTRAINT_BODY = 1
     * CONSTRAINT_DIAPHRAGM = 2
     * CONSTRAINT_PLATE = 3
     * CONSTRAINT_ROD = 4
     * CONSTRAINT_BEAM = 5
     * CONSTRAINT_EQUAL = 6
     * CONSTRAINT_LOCAL = 7
     * CONSTRAINT_WELD = 8
     * CONSTRAINT_LINE = 13
     * @return zero if the constraint type is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getConstraintType(name: String, constraintType: IntByRef): Int =
            callFunctionInt("GetConstraintType", name, constraintType)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is perpendicular to the plane of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getDiaphragm(name: String, axis: IntByRef, cSys: StringByRef): Int =
            callFunctionInt("GetDiaphragm", name, axis, cSys)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getEqual(name: String, value: BooleanArrayByRef, cSys: StringByRef): Int =
            callFunctionInt("GetEqual", name, value, cSys)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getLine(name: String, value: BooleanArrayByRef, cSys: StringByRef): Int =
            callFunctionInt("GetLine", name, value, cSys)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are U1, U2, U3, R1, R2 and R3.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getLocal(name: String, value: BooleanArrayByRef): Int =
            callFunctionInt("GetLocal", name, value)

    /**
     * This function retrieves the names of all defined joint constraints.
     * @param numberNames The number of joint constraint names retrieved by the program.
     * @param myName This is a one-dimensional array of joint constraint names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is perpendicular to the plane of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getPlate(name: String, axis: IntByRef, cSys: StringByRef): Int =
            callFunctionInt("GetPlate", name, axis, cSys)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is parallel to the axis of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getRod(name: String, axis: IntByRef, cSys: StringByRef): Int =
            callFunctionInt("GetRod", name, axis, cSys)

    /**
     * This function retrieves the list of the names of each special rigid diaphragm constraint. A special rigid diaphragm constraint is required for assignment of auto seismic load diaphragm eccentricity overwrites. It is also required for calculation of auto wind loads whose exposure widths are determined from the extents of rigid diaphragms.
     * A special rigid diaphragm constraint is a constraint with the following features:
     * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * 2. The constraint coordinate system is Global.
     * 3. The constraint axis is Z.
     *
     * @param num The number of special rigid diaphragm constraints.
     * @param diaph This is an array that includes the name of each special rigid diaphragm constraint.
     * @return zero if the name list is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSpecialRigidDiaphragmList(num: IntByRef, diaph: StringArrayByRef): Int =
            callFunctionInt("GetSpecialRigidDiaphragmList", num, diaph)

    /**
     * The function returns the definition for the specified constraint.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param tolerance Joints within this distance of each other are constrained together.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully obtained, otherwise it returns a nonzero value.
     */
    fun getWeld(name: String, value: BooleanArrayByRef, tolerance: DoubleByRef, cSys: StringByRef): Int =
            callFunctionInt("GetWeld", name, value, tolerance, cSys)

    /**
     * This function defines a Beam constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Beam constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Beam constraint, an error is returned.
     * @param name The name of a constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is parallel to the axis of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setBeam(name: String, axis: Int = ConstraintAxis.AUTO_AXIS.sapId, cSys: String = "Global"): Int =
            callFunctionInt("SetBeam", name, axis, cSys)

    /**
     * This function defines a Body constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Body constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Body constraint, an error is returned.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setBody(name: String, value: BooleanArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("SetBody", name, value, cSys)

    /**
     * This function defines a Diaphragm constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Diaphragm constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Diaphragm constraint, an error is returned.
     * @param name The name of a constraint.
     * @param axis This is one of the following items from the eConstraintAxis enumeration. It specifies the axis in the specified coordinate system that is perpendicular to the plane of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setDiaphragm(name: String, axis: Int = ConstraintAxis.AUTO_AXIS.sapId, cSys: String = "Global"): Int =
            callFunctionInt("SetDiaphragm", name, axis, cSys)

    /**
     * This function defines an Equal constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Equal constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not an Equal constraint, an error is returned.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setEqual(name: String, value: BooleanArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("SetEqual", name, value, cSys)

    /**
     * This function defines a Line constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Line constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Line constraint, an error is returned.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setLine(name: String, value: BooleanArrayByRef, cSys: String = "Global"): Int =
            callFunctionInt("SetLine", name, value, cSys)

    /**
     * This function defines a Local constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Local constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Local constraint, an error is returned.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are U1, U2, U3, R1, R2 and R3.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setLocal(name: String, value: BooleanArrayByRef): Int =
            callFunctionInt("SetLocal", name, value)

    /**
     * This function defines a Plate constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Plate constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Plate constraint, an error is returned.
     * @param name The name of a constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is perpendicular to the plane of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setPlate(name: String, axis: Int = ConstraintAxis.AUTO_AXIS.sapId, cSys: String = "Global"): Int =
            callFunctionInt("SetPlate", name, axis, cSys)

    /**
     * This function defines a Rod constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Rod constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Rod constraint, an error is returned.
     * @param name The name of a constraint.
     * @param axis This is one of the following items from the [ConstraintAxis] enumeration. It specifies the axis in the specified coordinate system that is parallel to the axis of the constraint. If AutoAxis is specified, the axis of the constraint is automatically determined from the joints assigned to the constraint.
     * * X = 1
     * * Y = 2
     * * Z = 3
     * * AutoAxis = 4
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setRod(name: String, axis: Int = ConstraintAxis.AUTO_AXIS.sapId, cSys: String = "Global"): Int =
            callFunctionInt("SetRod", name, axis, cSys)

    /**
     * This function defines a Weld constraint. If the specified name is not used for a constraint, a new constraint is defined using the specified name. If the specified name is already used for another Weld constraint, the definition of that constraint is modified. If the specified name is already used for some constraint that is not a Weld constraint, an error is returned.
     * @param name The name of an existing constraint.
     * @param value Value is an array of six booleans that indicate which joint degrees of freedom are included in the constraint. In order, the degrees of freedom addressed in the array are UX, UY, UZ, RX, RY and RZ.
     * @param tolerance Joints within this distance of each other are constrained together.
     * @param cSys The name of the coordinate system in which the constraint is defined.
     * @return zero if the constraint data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setWeld(name: String, value: BooleanArrayByRef, tolerance: Double, cSys: String = "Global"): Int =
            callFunctionInt("SetWeld", name, value, tolerance, cSys)
}