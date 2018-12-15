package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions

import vitorscoelho.sw4k.comutils.ADoubleArrayByRef
import vitorscoelho.sw4k.comutils.AIntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.AStringArrayByRef
import vitorscoelho.sw4k.sapenums.GeneralizedDisplacementType

interface GDisplV14 : SapComponent {
    /**
     * This function adds a new generalized displacement with the specified name and type.
     * The new generalized displacement must have a different name from all other generalized displacements. If the name is not unique, an error will be returned.
     * @param name The name of a new generalized displacement.
     * @param myType This is 1 or 2 indicating the generalized displacement type ([GeneralizedDisplacementType] enumeration).
     * * 1 = Translational
     * * 2 = Rotational
     * @return zero if the generalized displacement is successfully added, otherwise it returns a nonzero value.
     */
    fun add(name: String, myType: Int): Int =
            callFunctionInt("Add", name, myType)

    /**
     * The new generalized displacement name must be different from all other generalized displacement names. If the name is not unique, an error will be returned.
     * @param name The existing name of a defined generalized displacement.
     * @param newName The new name for the generalized displacement.
     * @return zero if the new name is successfully applied, otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * This function retrieves the total number of point objects included in a specified generalized displacement.
     * @param name The name of an existing generalized displacement.
     * @param count The number of point objects included in the specified generalized displacement.
     * @return zero if the count is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun countPoint(name: String, count: AIntByRef): Int =
            callFunctionInt("CountPoint", name, count)

    /**
     * @return the total number of generalized displacements defined in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function deletes one point object from a generalized displacement definition.
     * @param name The name of an existing generalized displacement.
     * @param pointName The name of a point object included in the generalized displacement that is to be deleted.
     * @return zero if the point is successfully deleted from the generalized displacement definition, otherwise it returns a nonzero value.
     */
    fun deletePoint(name: String, pointName: String): Int =
            callFunctionInt("DeletePoint", name, pointName)

    /**
     * This function deletes the specified generalized displacement.
     * @param name The name of an existing generalized displacement.
     * @return zero if the generalized displacement is successfully deleted, otherwise it returns a nonzero value.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the names of all defined generalized displacements.
     * @param numberNames The number of generalized displacement names retrieved by the program.
     * @param myName This is a one-dimensional array of generalized displacement names.
     * @return zero if the names are successfully retrieved, otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef, myName: AStringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the point objects and their scale factors from a generalized displacement definition.
     * @param name The name of an existing generalized displacement.
     * @param numberItems The number of point objects included in the generalized displacement definition.
     * @param pointName This is an array that includes the name of the point objects included in the generalized displacement definition.
     * @param u1, U2, U3, R1, R2, R3 These are arrays that include the unitless scale factors for each of the displacement degrees of freedom of the associated point objects that are included in the generalized displacement definition.
     * @return zero if the data is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getPoint(name: String, numberItems: AIntByRef, pointName: AStringArrayByRef, u1: ADoubleArrayByRef, u2: ADoubleArrayByRef, u3: ADoubleArrayByRef, r1: ADoubleArrayByRef, r2: ADoubleArrayByRef, r3: ADoubleArrayByRef): Int =
            callFunctionInt("GetPoint", name, numberItems, pointName, u1, u2, u3, r1, r2, r3)

    /**
     * This function retrieves the generalized displacement type ([GeneralizedDisplacementType] enumeration).
     * @param name The name of an existing generalized displacement.
     * @param myType This is 1 or 2, indicating the generalized displacement type ([GeneralizedDisplacementType] enumeration).
     * * 1 = Translational
     * * 2 = Rotational
     * @return zero if the type is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getType(name: String, myType: AIntByRef): Int =
            callFunctionInt("GetType", name, myType)

    /**
     * This function adds a point object and its scale factors to a generalized displacement definition, or, if the point object already exists in the generalized displacement definition, it modifies the scale factors.
     * @param name The name of an existing generalized displacement.
     * @param pointName The name of a point object to be included in the generalized displacement definition.
     * @param sF This is an array of six unitless scale factors for the point object displacement degrees of freedom.
     * * SF(0) = U1 scale factor
     * * SF(1) = U2 scale factor
     * * SF(2) = U3 scale factor
     * * SF(3) = R1 scale factor
     * * SF(4) = R2 scale factor
     * * SF(5) = R3 scale factor
     * @return zero if the data is successfully added or modified, otherwise it returns a nonzero value.
     */
    fun setPoint(name: String, pointName: String, sF: ADoubleArrayByRef): Int =
            callFunctionInt("SetPoint", name, pointName, sF)

    /**
     * This function sets the generalized displacement type.
     * @param name The name of an existing generalized displacement.
     * @param myType This is 1 or 2, indicating the generalized displacement type ([GeneralizedDisplacementType] enumeration).
     * * 1 = Translational
     * * 2 = Rotational
     * @return zero if the type is successfully set, otherwise it returns a nonzero value.
     */
    fun setType(name: String, myType: Int): Int =
            callFunctionInt("SetType", name, myType)
}