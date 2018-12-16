package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.MatType
import vitorscoelho.sw4k.sapenums.MatTypeAluminum
import vitorscoelho.sw4k.sapenums.MatTypeColdFormed
import vitorscoelho.sw4k.sapenums.MatTypeConcrete
import vitorscoelho.sw4k.sapenums.MatTypeRebar
import vitorscoelho.sw4k.sapenums.MatTypeSteel
import vitorscoelho.sw4k.sapenums.MatTypeTendon
import vitorscoelho.sw4k.sapenums.WeightOrMass
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propmaterial.TimeDepV14

interface PropMaterialV14 : SapComponent {
    val timeDep: TimeDepV14

    /**
     * This function adds a new material property to the model using built-in default values.
     * @param name This item is returned by the program. It is the name that the program ultimately assigns for the material property. If no UserName is specified, the program assigns a default name to the material property. If a UserName is specified and that name is not used for another material property, the UserName is assigned to the material property.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @param steelType This is one of the following items in the [MatTypeSteel] enumeration.
     * * ASTM_A36 = 1
     * * ASTM_A53GrB = 2
     * * ASTM_A500GrB_Fy42 = 3
     * * ASTM_A500GrB_Fy46 = 4
     * * ASTM_A572Gr50 = 5
     * * ASTM_A913Gr50 = 6
     * * ASTM_A992_Fy50 = 7
     * * CHINESE_Q235 = 8
     * * CHINESE_Q345 = 9
     * This item is applicable only when MatType = STEEL.
     * @param concreteType This is one of the following items in the [MatTypeConcrete] enumeration.
     * * FC3000_NORMALWEIGHT = 1
     * * FC4000_NORMALWEIGHT = 2
     * * FC5000_NORMALWEIGHT = 3
     * * FC6000_NORMALWEIGHT = 4
     * * FC3000_LIGHTWEIGHT = 5
     * * FC4000_LIGHTWEIGHT = 6
     * * FC5000_LIGHTWEIGHT = 7
     * * FC6000_LIGHTWEIGHT = 8
     * * CHINESE_C20_NORMALWEIGHT = 9
     * * CHINESE_C30_NORMALWEIGHT = 10
     * * CHINESE_C40_NORMALWEIGHT = 11
     * This item is applicable only when MatType = CONCRETE.
     * @param aluminumType This is one of the following items in the [MatTypeAluminum] enumeration.
     * * ALU_6061_T6 = 1
     * * ALU_6063_T6 = 2
     * * ALU_5052_H34 = 3
     * This item is applicable only when MatType = ALUMINUM.
     * @param coldFormedType This is one of the following items in the eMatTypeColdFormed enumeration.
     * * ASTM_A653SQGr33 = 1
     * * ASTM_A653SQGr50 = 2
     * This item is applicable only when MatType = COLDFORMED.
     * @param rebarType This is one of the following items in the [MatTypeRebar] enumeration.
     * * ASTM_A615Gr40 = 1
     * * ASTM_A615Gr60 = 2
     * * ASTM_A615Gr75 = 3
     * * ASTM_A706 = 4
     * * CHINESE_HPB235 = 5
     * * CHINESE_HRB335 = 6
     * * CHINESE_HRB400 = 7
     * This item is applicable only when MatType = REBAR.
     * @param tendonType This is one of the following items in the [MatTypeTendon] enumeration.
     * * ASTM_A416Gr250 = 1
     * * ASTM_A416Gr270 = 2
     * This item is applicable only when MatType = TENDON.
     * @param userName This is an optional user specified name for the material property. If a UserName is specified and that name is already used for another material property, the program ignores the UserName.
     * @return zero if the property is successfully added; otherwise it returns nonzero.
     */
    fun addQuick(name: String, matType: Int, steelType: Int = MatTypeSteel.ASTM_A992_Fy50.sapId, concreteType: Int = MatTypeConcrete.FC4000_NORMALWEIGHT.sapId, aluminumType: Int = MatTypeAluminum.ALU_6061_T6.sapId, coldFormedType: Int = MatTypeColdFormed.ASTM_A653SQGr50.sapId, rebarType: Int = MatTypeRebar.ASTM_A615Gr60.sapId, tendonType: Int = MatTypeTendon.ASTM_A416Gr270.sapId, userName: String = ""): Int =
            callFunctionInt("AddQuick", name, matType, steelType, concreteType, aluminumType, coldFormedType, rebarType, tendonType, userName)

    /**
     * This function changes the name of an existing material property.
     * @param name The existing name of a defined material property.
     * @param newName The new name for the material property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined material properties in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * @param matType This optional value is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @return the total number of defined material properties of a specified type in the model.
     */
    fun count(matType: Int): Int =
            callFunctionInt("Count", matType)

    /**
     * The function deletes a specified material property.
     * @param name The name of an existing material property.
     * @return zero if the material property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified material property can not be deleted, for example, if it is being used in a section property.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves the additional material damping data for the material.
     * @param name The name of an existing material property.
     * @param modalRatio The modal damping ratio.
     * @param viscousMassCoeff The mass coefficient for viscous proportional damping.
     * @param viscousStiffCoeff The stiffness coefficient for viscous proportional damping.
     * @param hystereticMassCoeff The mass coefficient for hysteretic proportional damping.
     * @param hystereticStiffCoeff The stiffness coefficient for hysteretic proportional damping.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDamping(name: String, modalRatio: ADoubleByRef = DoubleByRef.UNNECESSARY, viscousMassCoeff: ADoubleByRef = DoubleByRef.UNNECESSARY, viscousStiffCoeff: ADoubleByRef = DoubleByRef.UNNECESSARY, hystereticMassCoeff: ADoubleByRef = DoubleByRef.UNNECESSARY, hystereticStiffCoeff: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetDamping", name, modalRatio, viscousMassCoeff, viscousStiffCoeff, hystereticMassCoeff, hystereticStiffCoeff, temp)

    /**
     * This function retrieves the mass source for the model.
     * @param myOption This is 1, 2 or 3, indicating the mass source option.
     * * 1 = From element self mass and additional masses
     * * 2 = From loads
     * * 3 = From element self mass and additional masses and loads
     * @param numberLoads The number of load patterns from which mass is obtained. This item applies only when MyOption is 2 or 3.
     * @param loadPat This is an array of the names of the load patterns from which mass is obtained. This item applies only when MyOption is 2 or 3.
     * @param sf This is an array of load patterns multipliers used to calculate the mass. This item applies only when MyOption is 2 or 3.
     * @return zero if the mass source is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMassSource(myOption: AIntByRef = IntByRef.UNNECESSARY, numberLoads: AIntByRef = IntByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sf: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetMassSource", myOption, numberLoads, loadPat, sf)

    /**
     * This function retrieves some basic material property data.
     * @param name The name of an existing material property.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @param color The display color assigned to the material.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material.
     * @return zero if the material is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterial(name: String, matType: AIntByRef = IntByRef.UNNECESSARY, color: AIntByRef = IntByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMaterial", name, matType, color, notes, GUID)

    /**
     * This function retrieves the mechanical properties for a material with an anisotropic directional symmetry type.
     * @param name The name of an existing material property.
     * @param e This is an array that includes the modulus of elasticity.
     * * e(0) = E1 (F/L2)
     * * e(1) = E2 (F/L2)
     * * e(2) = E3 (F/L2)
     * @param u This is an array that includes poisson's ratio.
     * * u(0) = U12
     * * u(1) = U13
     * * u(2) = U23
     * * u(3) = U14
     * * u(4) = U24
     * * u(5) = U34
     * * u(6) = U15
     * * u(7) = U25
     * * u(8) = U35
     * * u(9) = U45
     * * u(10) = U16
     * * u(11) = U26
     * * u(12) = U36
     * * u(13) = U46
     * * u(14) = U56
     * @param a This is an array that includes the thermal coefficient.
     * * a(0) = A1 (1/T)
     * * a(1) = A2 (1/T)
     * * a(2) = A3 (1/T)
     * * a(3) = A12 (1/T)
     * * a(4) = A13 (1/T)
     * * a(5) = A23 (1/T)
     * @param g This is an array that includes the shear modulus.
     * * g(0) = G12 (F/L2)
     * * g(1) = G13 (F/L2)
     * * g(2) = G23 (F/L2)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the symmetry type of the specified material is not anisotropic.
     */
    fun getMPAnisotropic(name: String, e: ADoubleByRef = DoubleByRef.UNNECESSARY, u: ADoubleByRef = DoubleByRef.UNNECESSARY, a: ADoubleByRef = DoubleByRef.UNNECESSARY, g: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetMPAnisotropic", name, e, u, a, g, temp)

    /**
     * This function retrieves the mechanical properties for a material with an isotropic directional symmetry type.
     * @param name The name of an existing material property.
     * @param e The modulus of elasticity. (F/L2)
     * @param u Poisson's ratio.
     * @param a The thermal coefficient. (1/T)
     * @param g The shear modulus. For isotropic materials this value is program calculated from the modulus of elasticity and poisson's ratio. (F/L2)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the symmetry type of the specified material is not isotropic.
     */
    fun getMPIsotropic(name: String, e: ADoubleByRef = DoubleByRef.UNNECESSARY, u: ADoubleByRef = DoubleByRef.UNNECESSARY, a: ADoubleByRef = DoubleByRef.UNNECESSARY, g: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetMPIsotropic", name, e, u, a, g, temp)

    /**
     * This function retrieves the mechanical properties for a material with an orthotropic directional symmetry type.
     * @param name The name of an existing material property.
     * @param e This is an array that includes the modulus of elasticity.
     * * e(0) = E1 (F/L2)
     * * e(1) = E2 (F/L2)
     * * e(2) = E3 (F/L2)
     * @param u This is an array that includes poisson's ratio.
     * * u(0) = U12
     * * u(1) = U13
     * * u(2) = U23
     * @param a This is an array that includes the thermal coefficient.
     * * a(0) = A1 (1/T)
     * * a(1) = A2 (1/T)
     * * a(2) = A3 (1/T)
     * @param g This is an array that includes the shear modulus.
     * * g(0) = G12 (F/L2)
     * * g(1) = G13 (F/L2)
     * * g(2) = G23 (F/L2)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the symmetry type of the specified material is not orthotropic.
     */
    fun getMPOrthotropic(name: String, e: ADoubleByRef = DoubleByRef.UNNECESSARY, u: ADoubleByRef = DoubleByRef.UNNECESSARY, a: ADoubleByRef = DoubleByRef.UNNECESSARY, g: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetMPOrthotropic", name, e, u, a, g, temp)

    /**
     * This function retrieves the mechanical properties for a material with a uniaxial directional symmetry type.
     * @param name The name of an existing material property.
     * @param e The modulus of elasticity. (F/L2)
     * @param a The thermal coefficient. (1/T)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the symmetry type of the specified material is not uniaxial.
     */
    fun getMPUniaxial(name: String, e: ADoubleByRef = DoubleByRef.UNNECESSARY, a: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetMPUniaxial", name, e, a, temp)

    /**
     * This function retrieves the names of all defined material properties of the specified type.
     * @param numberNames The number of material property names retrieved by the program.
     * @param myName This is a one-dimensional array of material property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of all defined material properties of the specified type.
     * @param numberNames The number of material property names retrieved by the program.
     * @param myName This is a one-dimensional array of material property names.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, matType: Int): Int =
            callFunctionInt("GetNameList", numberNames, myName, matType)

    /**
     * This function retrieves the other material property data for aluminum materials.
     * @param name The name of an existing aluminum material property.
     * @param myType This is 1, 2 or 3, indicating the type of aluminum.
     * * 1 = Wrought
     * * 2 = Cast-Mold
     * * 3 = Cast-Sand
     * @param alloy The Alloy designation for the aluminum, for example, 2014-T6 for wrought or 356.0-T7 for cast (mold or sand) aluminum.
     * @param fcy The compressive yield strength of aluminum. (F/L2)
     * @param fty The tensile yield strength of aluminum. (F/L2)
     * @param ftu The tensile ultimate strength of aluminum. (F/L2)
     * @param fsu The shear ultimate strength of aluminum. (F/L2)
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not aluminum.
     */
    fun getOAluminum(name: String, myType: Int, alloy: AStringByRef = StringByRef.UNNECESSARY, fcy: ADoubleByRef = DoubleByRef.UNNECESSARY, fty: ADoubleByRef = DoubleByRef.UNNECESSARY, ftu: ADoubleByRef = DoubleByRef.UNNECESSARY, fsu: ADoubleByRef = DoubleByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetOAluminum", name, myType, alloy, fcy, fty, ftu, fsu, sSHysType, temp)

    /**
     * This function retrieves the other material property data for cold formed materials.
     * @param name The name of an existing cold formed material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not cold formed.
     */
    fun getOColdFormed(name: String, fy: ADoubleByRef = DoubleByRef.UNNECESSARY, fu: ADoubleByRef = DoubleByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetOColdFormed", name, fy, fu, sSHysType, temp)

    /**
     * This function retrieves the other material property data for concrete materials.
     * @param name The name of an existing concrete material property.
     * @param fc The concrete compressive strength. (F/L2)
     * @param isLightweight If this item is True, the concrete is assumed to be lightweight concrete.
     * @param fcsfactor The shear strength reduction factor for lightweight concrete.
     * @param eFu The effective tensile stress. (F/L2)
     * @param sSType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * * 2 = Parametric - Mander
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtfc This item applies only to parametric stress-strain curves. It is the strain at the unconfined compressive strength.
     * @param strainUltimate This item applies only to parametric stress-strain curves. It is the ultimate unconfined strain capacity.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope on the compression side of the curve.
     * @param frictionAngle The Drucker-Prager friction angle, 0 <= FrictionAngle < 90. (deg)
     * @param dilatationalAngle The Drucker-Prager dilatational angle, 0 <= DilatationalAngle < 90. (deg)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not concrete.
     */
    fun getOConcrete_1(name: String, fc: ADoubleByRef = DoubleByRef.UNNECESSARY, isLightweight: ABooleanByRef, fcsfactor: ADoubleByRef = DoubleByRef.UNNECESSARY, sSType: AIntByRef = IntByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, strainAtfc: ADoubleByRef = DoubleByRef.UNNECESSARY, strainUltimate: ADoubleByRef = DoubleByRef.UNNECESSARY, finalSlope: ADoubleByRef = DoubleByRef.UNNECESSARY, frictionAngle: ADoubleByRef = DoubleByRef.UNNECESSARY, dilatationalAngle: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetOConcrete_1", name, fc, isLightweight, fcsfactor, sSType, sSHysType, strainAtfc, strainUltimate, finalSlope, frictionAngle, dilatationalAngle, temp)

    /**
     * This function retrieves the other material property data for no design type materials.
     * @param name The name of an existing concrete material property.
     * @param frictionAngle The Drucker-Prager friction angle, 0 <= FrictionAngle < 90. (deg)
     * @param dilatationalAngle The Drucker-Prager dilatational angle, 0 <= DilatationalAngle < 90. (deg)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not concrete.
     */
    fun getONoDesign(name: String, frictionAngle: ADoubleByRef = DoubleByRef.UNNECESSARY, dilatationalAngle: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetONoDesign", name, frictionAngle, dilatationalAngle, temp)

    /**
     * This function retrieves the other material property data for rebar materials.
     * @param name The name of an existing rebar material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param eFy The effective yield stress. (F/L2)
     * @param eFu The effective tensile stress. (F/L2)
     * @param sSType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * * 2 = Parametric - Park
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtHardening This item applies only when parametric stress-strain curves are used and when UseCaltransSSDefaults is False. It is the strain at the onset of strain hardening.
     * @param strainUltimate This item applies only when parametric stress-strain curves are used and when UseCaltransSSDefaults is False. It is the ultimate strain capacity. This item must be larger than the StrainAtHardening item.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param useCaltransSSDefaults If this item is True, the program uses Caltrans default controlling strain values, which are bar size dependent.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not rebar.
     */
    fun getORebar_1(name: String, fy: ADoubleByRef = DoubleByRef.UNNECESSARY, fu: ADoubleByRef = DoubleByRef.UNNECESSARY, eFy: ADoubleByRef = DoubleByRef.UNNECESSARY, eFu: ADoubleByRef = DoubleByRef.UNNECESSARY, sSType: AIntByRef = IntByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, strainAtHardening: ADoubleByRef = DoubleByRef.UNNECESSARY, strainUltimate: ADoubleByRef = DoubleByRef.UNNECESSARY, finalSlope: ADoubleByRef = DoubleByRef.UNNECESSARY, useCaltransSSDefaults: ABooleanByRef, temp: Double = 0.0): Int =
            callFunctionInt("GetORebar_1", name, fy, fu, eFy, eFu, sSType, sSHysType, strainAtHardening, strainUltimate, finalSlope, useCaltransSSDefaults, temp)

    /**
     * This function retrieves the other material property data for steel materials.
     * @param name The name of an existing steel material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param eFy The effective yield stress. (F/L2)
     * @param eFu The effective tensile stress. (F/L2)
     * @param sSType This is 0 or 1. indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtHardening This item applies only to parametric stress-strain curves. It is the strain at the onset of strain hardening.
     * @param strainAtMaxStress This item applies only to parametric stress-strain curves. It is the strain at maximum stress.
     * @param strainAtRupture This item applies only to parametric stress-strain curves. It is the strain at rupture.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not steel.
     */
    fun getOSteel_1(name: String, fy: ADoubleByRef = DoubleByRef.UNNECESSARY, fu: ADoubleByRef = DoubleByRef.UNNECESSARY, eFy: ADoubleByRef = DoubleByRef.UNNECESSARY, eFu: ADoubleByRef = DoubleByRef.UNNECESSARY, sSType: AIntByRef = IntByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, strainAtHardening: ADoubleByRef = DoubleByRef.UNNECESSARY, strainAtMaxStress: ADoubleByRef = DoubleByRef.UNNECESSARY, strainAtRupture: ADoubleByRef = DoubleByRef.UNNECESSARY, finalSlope: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetOSteel_1", name, fy, fu, eFy, eFu, sSType, sSHysType, strainAtHardening, strainAtMaxStress, strainAtRupture, finalSlope, temp)

    /**
     * This function retrieves the other material property data for tendon materials.
     * @param name The name of an existing tendon material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param sSType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - 250 ksi strand
     * * 2 = Parametric - 270 ksi strand
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not tendon.
     */
    fun getOTendon_1(name: String, fy: ADoubleByRef = DoubleByRef.UNNECESSARY, fu: ADoubleByRef = DoubleByRef.UNNECESSARY, sSType: AIntByRef = IntByRef.UNNECESSARY, sSHysType: AIntByRef = IntByRef.UNNECESSARY, finalSlope: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetOTendon_1", name, fy, fu, sSType, sSHysType, finalSlope, temp)

    /**
     * This function retrieves the material stress-strain curve.
     * @param name The name of an existing material property.
     * @param numberPoints The number of points in the stress-strain curve.
     * @param pointID This is one of the following integers which sets the point ID. The point ID controls the color that will be displayed for hinges in a deformed shape plot.
     * * -5 = -E
     * * -4 = -D
     * * -3 = -C
     * * -2 = -B
     * * 0 = None
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param strain This is an array that includes the strain at each point on the stress strain curve.
     * @param stress This is an array that includes the stress at each point on the stress strain curve. (F/L2)
     * @param sectName This item applies only if the specified material is concrete with a Mander concrete type.
     * This is the frame section property for which the Mander stress-strain curve is retrieved.
     * The section must be round or rectangular.
     * @param rebarArea This item applies only if the specified material is rebar, which does not have a user-defined stress-strain curve and is specified to use Caltrans default controlling strain values, which are bar size dependent.
     * This is the area of the rebar for which the stress-strain curve is retrieved.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMPIsotropic(name: String, numberPoints: AIntByRef = IntByRef.UNNECESSARY, pointID: AIntArrayByRef = IntArrayByRef.UNNECESSARY, strain: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, stress: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, sectName: String = "", rebarArea: Double = 0.0, temp: Double = 0.0): Int =
            callFunctionInt("GetMPIsotropic", name, numberPoints, pointID, strain, stress, sectName, rebarArea, temp)

    /**
     * This function retrieves the temperatures at which properties are specified for a material.
     * @param name The name of a material property.
     * @param numberItems The number of different temperatures at which properties are specified for the material.
     * @param temp This is an array that includes the different temperatures at which properties are specified for the material.
     * @return zero if the temperatures are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTemp(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, temp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetTemp", name, numberItems, temp)

    /**
     * This function retrieves the material type for the specified material.
     * @param name The name of an existing material property.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @param symType This is 0, 1, 2 or 3, indicating the material directional symmetry type.
     * * 0 = Isotropic
     * * 1 = Orthotropic
     * * 2 = Anisotropic
     * * 3 = Uniaxial
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType(name: String, matType: AIntByRef = IntByRef.UNNECESSARY, symType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetType", name, matType, symType)

    /**
     * This function retrieves the weight per unit volume and mass per unit volume of the material.
     * @param name The name of an existing material property.
     * @param w The weight per unit volume for the material. [F/L3]
     * @param m The mass per unit volume for the material. [M/L3]
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getWeightAndMass(name: String, w: ADoubleByRef = DoubleByRef.UNNECESSARY, m: ADoubleByRef = DoubleByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetWeightAndMass", name, w, m, temp)

    /**
     * This function sets the additional material damping data for the material.
     * @param name The name of an existing material property.
     * @param modalRatio The modal damping ratio.
     * @param viscousMassCoeff The mass coefficient for viscous proportional damping.
     * @param viscousStiffCoeff The stiffness coefficient for viscous proportional damping.
     * @param hystereticMassCoeff The mass coefficient for hysteretic proportional damping.
     * @param hystereticStiffCoeff The stiffness coefficient for hysteretic proportional damping.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setDamping(name: String, modalRatio: Double, viscousMassCoeff: Double, viscousStiffCoeff: Double, hystereticMassCoeff: Double, hystereticStiffCoeff: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetDamping", name, modalRatio, viscousMassCoeff, viscousStiffCoeff, hystereticMassCoeff, hystereticStiffCoeff, temp)

    /**
     * This function sets the mass source for the model.
     * @param myOption This is 1, 2 or 3, indicating the mass source option.
     * * 1 = From element self mass and additional masses
     * * 2 = From loads
     * * 3 = From element self mass and additional masses and loads
     * @param numberLoads The number of load patterns from which mass is obtained. This item applies only when MyOption is 2 or 3.
     * @param loadPat This is an array of the names of the load patterns from which mass is obtained. This item applies only when MyOption is 2 or 3.
     * @param sf This is an array of load patterns multipliers used to calculate the mass. This item applies only when MyOption is 2 or 3.
     * @return zero if the mass source is successfully set; otherwise it returns a nonzero value.
     */
    fun setMassSource(myOption: Int, numberLoads: Int, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sf: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetMassSource", myOption, numberLoads, loadPat, sf)

    /**
     * This function initializes a material property. If this function is called for an existing material property, all items for the material are reset to their default value.
     * @param name The name of an existing or new material property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matType This is one of the following items in the [MatType] enumeration.
     * * STEEL = 1
     * * CONCRETE = 2
     * * NODESIGN = 3
     * * ALUMINUM = 4
     * * COLDFORMED = 5
     * * REBAR = 6
     * * TENDON = 7
     * @param color The display color assigned to the material. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the material.
     * @param GUID The GUID (global unique identifier), if any, assigned to the material. If this item is input as Default, the program assigns a GUID to the material.
     * @return zero if the material is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setMaterial(name: String, matType: Int, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetMaterial", name, matType, color, notes, GUID)

    /**
     * This function sets the material directional symmetry type to anisotropic, and assigns the anisotropic mechanical properties.
     * @param name The name of an existing material property.
     * @param e This is an array that includes the modulus of elasticity.
     * * e(0) = E1 (F/L2)
     * * e(1) = E2 (F/L2)
     * * e(2) = E3 (F/L2)
     * @param u This is an array that includes poisson's ratio.
     * * u(0) = U12
     * * u(1) = U13
     * * u(2) = U23
     * * u(3) = U14
     * * u(4) = U24
     * * u(5) = U34
     * * u(6) = U15
     * * u(7) = U25
     * * u(8) = U35
     * * u(9) = U45
     * * u(10) = U16
     * * u(11) = U26
     * * u(12) = U36
     * * u(13) = U46
     * * u(14) = U56
     * @param a This is an array that includes the thermal coefficient.
     * * a(0) = A1 (1/T)
     * * a(1) = A2 (1/T)
     * * a(2) = A3 (1/T)
     * * a(3) = A12 (1/T)
     * * a(4) = A13 (1/T)
     * * a(5) = A23 (1/T)
     * @param g This is an array that includes the shear modulus.
     * * g(0) = G12 (F/L2)
     * * g(1) = G13 (F/L2)
     * * g(2) = G23 (F/L2)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMPAnisotropic(name: String, e: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, a: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, g: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("SetMPAnisotropic", name, e, u, a, g, temp)

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
    fun setMPIsotropic(name: String, e: Double, u: Double, a: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetMPIsotropic", name, e, u, a, temp)

    /**
     * This function sets the material directional symmetry type to orthotropic, and assigns the orthotropic mechanical properties.
     * @param name The name of an existing material property.
     * @param e This is an array that includes the modulus of elasticity.
     * * e(0) = E1 (F/L2)
     * * e(1) = E2 (F/L2)
     * * e(2) = E3 (F/L2)
     * @param u This is an array that includes poisson's ratio.
     * * u(0) = U12
     * * u(1) = U13
     * * u(2) = U23
     * @param a * This is an array that includes the thermal coefficient.
     * * a(0) = A1 (1/T)
     * * a(1) = A2 (1/T)
     * * a(2) = A3 (1/T)
     * @param g This is an array that includes the shear modulus.
     * * g(0) = G12 (F/L2)
     * * g(1) = G13 (F/L2)
     * * g(2) = G23 (F/L2)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMPOrthotropic(name: String, e: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, u: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, a: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, g: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("SetMPOrthotropic", name, e, u, a, g, temp)

    /**
     * This function sets the material directional symmetry type to uniaxial, and assigns the uniaxial mechanical properties.
     * @param name The name of an existing material property.
     * @param e The modulus of elasticity. (F/L2)
     * @param a The thermal coefficient. (1/T)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMPUniaxial(name: String, e: Double, a: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetMPUniaxial", name, e, a, temp)

    /**
     * This function sets the other material property data for aluminum materials.
     * @param name The name of an existing aluminum material property.
     * @param myType This is 1, 2 or 3, indicating the type of aluminum.
     * * 1 = Wrought
     * * 2 = Cast-Mold
     * * 3 = Cast-Sand
     * @param alloy The Alloy designation for the aluminum, for example, 2014-T6 for wrought or 356.0-T7 for cast (mold or sand) aluminum.
     * @param fcy The compressive yield strength of aluminum. (F/L2)
     * @param fty The tensile yield strength of aluminum. (F/L2)
     * @param ftu The tensile ultimate strength of aluminum. (F/L2)
     * @param fsu The shear ultimate strength of aluminum. (F/L2)
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOAluminum(name: String, myType: Int, alloy: String, fcy: Double, fty: Double, ftu: Double, fsu: Double, sSHysType: Int, temp: Double = 0.0): Int =
            callFunctionInt("SetOAluminum", name, myType, alloy, fcy, fty, ftu, fsu, sSHysType, temp)

    /**
     * This function sets the other material property data for cold formed materials.
     * @param name The name of an existing cold formed material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOColdFormed(name: String, fy: Double, fu: Double, sSHysType: Int, temp: Double = 0.0): Int =
            callFunctionInt("SetOColdFormed", name, fy, fu, sSHysType, temp)

    /**
     * This function sets the other material property data for concrete materials.
     * @param name The name of an existing concrete material property.
     * @param fc The concrete compressive strength. (F/L2)
     * @param isLightweight If this item is True, the concrete is assumed to be lightweight concrete.
     * @param fcsFactor The shear strength reduction factor for lightweight concrete.
     * @param ssType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * * 2 = Parametric - Mander
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtfc This item applies only to parametric stress-strain curves. It is the strain at the unconfined compressive strength.
     * @param strainUltimate This item applies only to parametric stress-strain curves. It is the ultimate unconfined strain capacity. This item must be larger than the StrainAtfc item.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope on the compression side of the curve.
     * @param frictionAngle The Drucker-Prager friction angle, 0 <= FrictionAngle < 90. (deg)
     * @param dilatationalAngle The Drucker-Prager dilatational angle, 0 <= DilatationalAngle < 90. (deg)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOConcrete_1(name: String, fc: Double, isLightweight: Boolean, fcsFactor: Double, ssType: Int, sSHysType: Int, strainAtfc: Double, strainUltimate: Double, finalSlope: Double, frictionAngle: Double = 0.0, dilatationalAngle: Double = 0.0, temp: Double = 0.0): Int =
            callFunctionInt("SetOConcrete_1", name, fc, isLightweight, fcsFactor, ssType, sSHysType, strainAtfc, strainUltimate, finalSlope, frictionAngle, dilatationalAngle, temp)

    /**
     * This function sets the other material property data for no design type materials.
     * @param name The name of an existing concrete material property.
     * @param frictionAngle The Drucker-Prager friction angle, 0 <= FrictionAngle < 90. (deg)
     * @param dilatationalAngle The Drucker-Prager dilatational angle, 0 <= DilatationalAngle < 90. (deg)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setONoDesign(name: String, frictionAngle: Double = 0.0, dilatationalAngle: Double = 0.0, temp: Double = 0.0): Int =
            callFunctionInt("SetONoDesign", name, frictionAngle, dilatationalAngle, temp)

    /**
     * This function sets the other material property data for rebar materials.
     * @param name The name of an existing rebar material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param eFy The effective yield stress. (F/L2)
     * @param eFu The effective tensile stress. (F/L2)
     * @param sSType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * * 2 = Parametric - Park
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtHardening This item applies only when parametric stress-strain curves are used and when UseCaltransSSDefaults is False. It is the strain at the onset of strain hardening.
     * @param strainUltimate This item applies only when parametric stress-strain curves are used and when UseCaltransSSDefaults is False. It is the ultimate strain capacity. This item must be larger than the StrainAtHardening item.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param useCaltransSSDefaults If this item is True, the program uses Caltrans default controlling strain values, which are bar size dependent.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setORebar_1(name: String, fy: Double, fu: Double, eFy: Double, eFu: Double, sSType: Int, sSHysType: Int, strainAtHardening: Double, strainUltimate: Double, finalSlope: Double, useCaltransSSDefaults: Boolean, temp: Double = 0.0): Int =
            callFunctionInt("SetORebar_1", name, fy, fu, eFy, eFu, sSType, sSHysType, strainAtHardening, strainUltimate, finalSlope, useCaltransSSDefaults, temp)

    /**
     * This function sets the other material property data for steel materials.
     * @param name The name of an existing steel material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param eFy The effective yield stress. (F/L2)
     * @param eFu The effective tensile stress. (F/L2)
     * @param sSType This is 0 or 1, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - Simple
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param strainAtHardening This item applies only to parametric stress-strain curves. It is the strain at the onset of strain hardening.
     * @param strainAtMaxStress This item applies only to parametric stress-strain curves. It is the strain at maximum stress. This item must be larger than the StrainAtHardening item.
     * @param strainAtRupture This item applies only to parametric stress-strain curves. It is the strain at rupture. This item must be larger than the StrainAtMaxStress item.
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOSteel_1(name: String, fy: Double, fu: Double, eFy: Double, eFu: Double, sSType: Int, sSHysType: Int, strainAtHardening: Double, strainAtMaxStress: Double, strainAtRupture: Double, finalSlope: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetOSteel_1", name, fy, fu, eFy, eFu, sSType, sSHysType, strainAtHardening, strainAtMaxStress, strainAtRupture, finalSlope, temp)

    /**
     * This function sets the other material property data for tendon materials.
     * @param name The name of an existing tendon material property.
     * @param fy The minimum yield stress. (F/L2)
     * @param fu The minimum tensile stress. (F/L2)
     * @param sSType This is 0, 1 or 2, indicating the stress-strain curve type.
     * * 0 = User defined
     * * 1 = Parametric - 250 ksi strand
     * * 2 = Parametric - 270 ksi strand
     * @param sSHysType This is 0, 1 or 2, indicating the stress-strain hysteresis type.
     * * 0 = Elastic
     * * 1 = Kinematic
     * * 2 = Takeda
     * @param finalSlope This item applies only to parametric stress-strain curves. It is a multiplier on the material modulus of elasticity, E. This value multiplied times E gives the final slope of the curve.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setOTendon_1(name: String, fy: Double, fu: Double, sSType: Int, sSHysType: Int, finalSlope: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetOTendon_1", name, fy, fu, sSType, sSHysType, finalSlope, temp)

    /**
     * This function sets the material stress-strain curve for materials that are specified to have user-defined stress-strain curves.
     * @param name The name of an existing material property.
     * @param numberPoints The number of points in the stress-strain curve. This item must be at least 3.
     * @param pointID This is one of the following integers which sets the point ID. The point ID controls the color that will be displayed for hinges in a deformed shape plot.
     * * -5 = -E
     * * -4 = -D
     * * -3 = -C
     * * -2 = -B
     * * 0 = None
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * The point IDs must be input in numerically increasing order, except that 0 (None) values are allowed anywhere. No duplicate values are allowed excepth for 0 (None).
     * @param strain This is an array that includes the strain at each point on the stress strain curve. The strains must increase monotonically.
     * @param stress This is an array that includes the stress at each point on the stress strain curve. (F/L2)
     * Points that have a negative strain must have a zero or negative stress. Similarly, points that have a positive strain must have a zero or positive stress.
     * There must be one point defined that has zero strain and zero stress.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been defined previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setSSCurve(name: String, numberPoints: Int, pointID: AIntArrayByRef = IntArrayByRef.UNNECESSARY, strain: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, stress: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("SetSSCurve", name, numberPoints, pointID, strain, stress, temp)

    /**
     * This function assigns the temperatures at which properties are specified for a material. This data is required only for materials whose properties are temperature dependent.
     * @param name The name of an existing material property.
     * @param numberItems The number of different temperatures at which properties are specified for the material.
     * @param temp This is an array that includes the different temperatures at which properties are specified for the material.
     * @return zero if the temperatures are successfully set; otherwise it returns a nonzero value.
     */
    fun setTemp(name: String, numberItems: Int, temp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetTemp", name, numberItems, temp)

    /**
     * This function assigns weight per unit volume or mass per unit volume to a material property.
     * @param name The name of an existing material property.
     * @param myOption This is either 1 or 2 ([WeightOrMass] enumeration), indicating what is specified by the Value item.
     * * 1 = Weight per unit volume is specified
     * * 2 = Mass per unit volume is specified
     * If the weight is specified, the corresponding mass is program calculated based on the specified weight. Similarly, if the mass is specified, the corresponding weight is program calculated based on the specified mass.
     * @param value This is either the weight per unit volume or the mass per unit volume, depending on the value of the MyOption item. [F/L3] for MyOption = 1 (weight), and [M/L3] for MyOption = 2 (mass)
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been define previously for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setWeightAndMass(name: String, myOption: Int, value: Double, temp: Double = 0.0): Int =
            callFunctionInt("SetWeightAndMass", name, myOption, value, temp)
}
