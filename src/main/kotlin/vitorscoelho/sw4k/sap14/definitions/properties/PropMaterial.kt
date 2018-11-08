package vitorscoelho.sw4k.sap14.definitions.properties

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.MatType
import vitorscoelho.sw4k.sap14.enums.MyOption

class PropMaterial internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cPropMaterial") {

    /**
     * This function retrieves some basic material property data.
     * @param name The name of an existing material property.
     * @param matType [MatTypeByRef]
     * @param color The display color assigned to the material.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material.
     * @return zero if the material is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterial(name: String, matType: MatTypeByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetMaterial", name, matType, color, notes, GUID)

    /**
     * This function initializes a material property. If this function is called for an existing material property, all items for the material are reset to their default value.
     * @param name The name of an existing or new material property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matType [MatType]
     * @param color The display color assigned to the material. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material. If this item is input as Default, the program assigns a GUID to the material.
     * @return zero if the material is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setMaterial(name: String, matType: MatType, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetMaterial", name, matType, color, notes, GUID)

    /**
     * This function sets the material directional symmetry type to isotropic, and assigns the isotropic mechanical properties.
     * @param name The name of an existing material property.
     * @param e The modulus of elasticity. [F/L²]
     * @param u Poisson’s ratio.
     * @param a The thermal coefficient. [1/T]
     * @param temp This item applies only if the specified material has properties that are temperature dependent.That is, it applies only if properties are specified for the material at more than one temperature.This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMPIsotropic(name: String, e: Double, u: Double, a: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetMPIsotropic", name, e, u, a, temp)

    /**
     * This function assigns weight per unit volume or mass per unit volume to a material property.
     * @param name The name of an existing material property.
     * @param myOption If the weight is specified, the corresponding mass is program calculated based on the specified weight. Similarly, if the mass is specified, the corresponding weight is program calculated based on the specified mass.
     * @param value This is either the weight per unit volume or the mass per unit volume, depending on the value of the MyOption item. [F/L3] for [myOption] = [MyOption.WEIGHT_PER_UNIT_VOLUME], and [M/L3] for [myOption] = [MyOption.MASS_PER_UNIT_VOLUME]
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature. This item is the temperature at which the specified data applies. The temperature must have been define previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setWeightAndMass(name: String, myOption: MyOption, value: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetWeightAndMass", name, myOption, value, temp)
}
