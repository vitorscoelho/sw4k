package vitorscoelho.sw4k.sap14.definitions.properties

import vitorscoelho.sw4k.comutils.IntByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringByRef
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.enums.MatType
import vitorscoelho.sw4k.sap14.enums.WeightOrMass

class PropMaterial internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cPropMaterial"), PropMaterialV14 {
    override fun getMaterial(name: String, matType: IntByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetMaterial", name, matType, color, notes, GUID)

    override fun setMaterial(name: String, matType: Int, color: Int, notes: String, GUID: String): Int =
            callFunctionInt("SetMaterial", name, matType, color, notes, GUID)

    override fun setMPIsotropic(name: String, e: Double, u: Double, a: Double, temp: Double): Int =
            callFunctionInt("SetMPIsotropic", name, e, u, a, temp)

    override fun setWeightAndMass(name: String, myOption: Int, value: Double, temp: Double): Int =
            callFunctionInt("SetWeightAndMass", name, myOption, value, temp)
}

interface PropMaterialV14 {
    /**
     * This function retrieves some basic material property data.
     * @param name The name of an existing material property.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * MATERIAL_STEEL = 1
     * * MATERIAL_CONCRETE = 2
     * * MATERIAL_NODESIGN = 3
     * * MATERIAL_ALUMINUM = 4
     * * MATERIAL_COLDFORMED = 5
     * * MATERIAL_REBAR = 6
     * * MATERIAL_TENDON = 7
     * @param color The display color assigned to the material.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material.
     * @return zero if the material is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterial(name: String, matType: IntByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int

    /**
     * This function initializes a material property. If this function is called for an existing material property, all items for the material are reset to their default value.
     * @param name The name of an existing or new material property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * MATERIAL_STEEL = 1
     * * MATERIAL_CONCRETE = 2
     * * MATERIAL_NODESIGN = 3
     * * MATERIAL_ALUMINUM = 4
     * * MATERIAL_COLDFORMED = 5
     * * MATERIAL_REBAR = 6
     * * MATERIAL_TENDON = 7
     * @param color The display color assigned to the material. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material. If this item is input as Default, the program assigns a GUID to the material.
     * @return zero if the material is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setMaterial(name: String, matType: Int, color: Int = -1, notes: String = "", GUID: String = ""): Int

    /**
     * This function sets the material directional symmetry type to isotropic, and assigns the isotropic mechanical properties.
     * @param name The name of an existing material property.
     * @param e The modulus of elasticity. (F/L2)
     * @param u Poisson's ratio.
     * @param a The thermal coefficient. (1/T)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMPIsotropic(name: String, e: Double, u: Double, a: Double, temp: Double = 0.0): Int

    /**
     * This function assigns weight per unit volume or mass per unit volume to a material property.
     * @param name The name of an existing material property.
     * @param myOption This is either 1 or 2 ([WeightOrMass] enumeration), indicating what is specified by the Value item.
     * * 1 = Weight per unit volume is specified
     * * 2 = Mass per unit volume is specified
     * If the weight is specified, the corresponding mass is program calculated based on the specified weight. Similarly, if the mass is specified, the corresponding weight is program calculated based on the specified mass.
     * @param value This is either the weight per unit volume or the mass per unit volume, depending on the value of the MyOption item. (F/L3) for MyOption = 1 (weight), and (M/L3) for MyOption = 2 (mass)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been define previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setWeightAndMass(name: String, myOption: Int, value: Double, temp: Double = 0.0): Int
}
