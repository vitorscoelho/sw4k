package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*

interface PropAreaV14 : SapComponent {
    /**
     * This function changes the name of an existing area property.
     * @param name The existing name of a defined area property.
     * @param newName The new name for the area property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @param propType This optional value is 0, 1, 2 or 3, indicating the type of area properties included in the count.
     * * 0 = All
     * * 1 = Shell
     * * 2 = Plane
     * * 3 = Asolid
     * @return the total number of defined area properties in the model. If desired, counts can be returned for all area properties of a specified type in the model.
     */
    fun count(propType: Int = 0): Int =
            callFunctionInt("Count", propType)

    /**
     * The function deletes a specified area property.
     * @param name The name of an existing area property.
     * @return zero if the area property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified area property can not be deleted, for example, if it is being used by an area object.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves area property data for an asolid-type area section.
     * @param name The name of an existing asolid-type area property.
     * @param matProp The name of the material property for the area property.
     * @param matAng The material angle. (deg)
     * @param arc The arc angle through which the area object is passed to define the asolid element. (deg)
     * A value of zero means 1 radian (approximately 57.3 degrees).
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param cSys The area object is rotated about the Z-axis in this coordinate system to define the asolid element.
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAsolid(name: String, matProp: AStringByRef = StringByRef.UNNECESSARY, matAng: ADoubleByRef = DoubleByRef.UNNECESSARY, arc: ADoubleByRef = DoubleByRef.UNNECESSARY, incompatible: ABooleanByRef, cSys: AStringByRef = StringByRef.UNNECESSARY, color: AIntByRef = IntByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetAsolid", name, matProp, matAng, arc, incompatible, cSys, color, notes, GUID)

    /**
     * This function retrieves the modifier assignments for an area property. The default value for all modifiers is one.
     * @param name The name of an existing area property.
     * @param value This is an array of 10 unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined area properties of the specified type.
     * @param numberNames The number of area property names retrieved by the program.
     * @param myName This is a one-dimensional array of area property names.
     * @param propType This optional value is 0, 1, 2 or 3, indicating the type of area properties included in the name list.
     * * 0 = All
     * * 1 = Shell
     * * 2 = Plane
     * * 3 = Asolid
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, propType: Int = 0): Int =
            callFunctionInt("GetNameList", numberNames, myName, propType)

    /**
     * This function retrieves area property data for a plane-type area section.
     * @param name The name of an existing plane-type area property.
     * @param myType This is either 1 or 2, indicating the plane type.
     * * 1 = Plane-stress
     * * 2 = Plane-strain
     * @param matProp The name of the material property for the area property.
     * @param matAng The material angle. (deg)
     * @param thickness The plane thickness. (L)
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPlane(name: String, myType: AIntByRef = IntByRef.UNNECESSARY, matProp: AStringByRef = StringByRef.UNNECESSARY, matAng: ADoubleByRef = DoubleByRef.UNNECESSARY, thickness: ADoubleByRef = DoubleByRef.UNNECESSARY, incompatible: ABooleanByRef, color: AIntByRef = IntByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetPlane", name, myType, matProp, matAng, thickness, incompatible, color, notes, GUID)

    /**
     * This function retrieves area property design parameters for a shell-type area section.
     * @param name The name of an existing shell-type area property.
     * @param matProp The name of the material property for the area property.
     * @param steelLayoutOption This is 0, 1 or 2 indicating, the rebar layout option.
     * * 0 = Default
     * * 1 = One layer
     * * 2 = Two layers
     * @param designCoverTopDir1, DesignCoverTopDir2 The cover to the centroid of the top reinforcing steel running in the local 1 and 2 axes directions of the area object, respectively. (L)
     * This item applies only when SteelLayoutOption = 1 or 2.
     * @param designCoverBotDir1, DesignCoverBotDir2 The cover to the centroid of the bottom reinforcing steel running in the local 1 and 2 axes directions of the area object, respectively. (L)
     * This item applies only when SteelLayoutOption = 2.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getShellDesign(name: String, matProp: AStringByRef = StringByRef.UNNECESSARY, steelLayoutOption: AIntByRef = IntByRef.UNNECESSARY, designCoverTopDir1: ADoubleByRef = DoubleByRef.UNNECESSARY, designCoverTopDir2: ADoubleByRef = DoubleByRef.UNNECESSARY, designCoverBotDir1: ADoubleByRef = DoubleByRef.UNNECESSARY, designCoverBotDir2: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetShellDesign", name, matProp, steelLayoutOption, designCoverTopDir1, designCoverTopDir2, designCoverBotDir1, designCoverBotDir2)

    /**
     * This function retrieves area property layer parameters for a shell-type area section.
     * The function returns zero if the parameters are successfully retrieved, otherwise it returns a nonzero value.
     * @param name The name of an existing shell-type area property that is specified to be a layered shell property.
     * @param numberLayers The number of layers in the area property.
     * @param layerName This is an array that includes the name of each layer.
     * @param dist This is an array that includes the distance from the area reference surface (area object joint location plus offsets) to the mid-height of the layer. (L)
     * @param thickness This is an array that includes the thickness of each layer. (L)
     * @param type This is an array that includes 1, 2 or 3, indicating the layer type.
     * @param numIntegrationPts The number of integration points in the thickness direction for the layer. The locations are determined by the program using standard Gauss-quadrature rules.
     * @param matProp This is an array that includes the name of the material property for the layer.
     * @param matAng This is an array that includes the material angle for the layer. (deg)
     * @param s11Type, S22Type, S12Type These are arrays that include 0, 1 or 2, indicating the material component behavior.
     * @return an error if the specified area property is not a shell-type property specified to be a layered shell.
     */
    fun getShellLayer_1(name: String, numberLayers: AIntByRef = IntByRef.UNNECESSARY, layerName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dist: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, thickness: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, numIntegrationPts: AIntArrayByRef = IntArrayByRef.UNNECESSARY, matProp: AStringArrayByRef = StringArrayByRef.UNNECESSARY, matAng: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, s22Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, s12Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetShellLayer_1", name, numberLayers, layerName, dist, thickness, type, numIntegrationPts, matProp, matAng, s11Type, s22Type, s12Type)

    /**
     * This function retrieves area property data for a shell-type area section.
     * @param name The name of an existing shell-type area property.
     * @param shellType This is 1, 2, 3, 4, 5 or 6, indicating the shell type.
     * * 1 = Shell - thin
     * * 2 = Shell - thick
     * * 3 = Plate - thin
     * * 4 = Plate - thick
     * * 5 = Membrane
     * * 6 = Shell layered/nonlinear
     * @param includeDrillingDOF This item is True if drilling degrees of freedom are included in the element formulation in the analysis model. This item does not apply when ShellType = 3, 4 or 6.
     * @param matProp The name of the material property for the area property. This item does not apply when ShellType = 6.
     * @param matAng The material angle. (deg)
     * This item does not apply when ShellType = 6.
     * @param thickness The membrane thickness. (L)
     * This item does not apply when ShellType = 6.
     * @param bending The bending thickness. (L)
     * This item does not apply when ShellType = 6.
     * @param color The display color assigned to the property.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getShell_1(name: String, shellType: AIntByRef = IntByRef.UNNECESSARY, includeDrillingDOF: ABooleanByRef, matProp: AStringByRef = StringByRef.UNNECESSARY, matAng: ADoubleByRef = DoubleByRef.UNNECESSARY, thickness: ADoubleByRef = DoubleByRef.UNNECESSARY, bending: ADoubleByRef = DoubleByRef.UNNECESSARY, color: AIntByRef = IntByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetShell_1", name, shellType, includeDrillingDOF, matProp, matAng, thickness, bending, color, notes, GUID)

    /**
     * This function retrieves the property type for the specified area property.
     * @param name The name of an existing area property.
     * @param propType This is 1, 2 or 3, indicating the type of area property.
     * * 1 = Shell
     * * 2 = Plane
     * * 3 = Asolid
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType(name: String, propType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetType", name, propType)

    /**
     * This function initializes an asolid-type area property. If this function is called for an existing area property, all items for the property are reset to their default value.
     * @param name The name of an existing or new area property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the area property.
     * @param matAng The material angle. (deg)
     * @param arc The arc angle through which the area object is passed to define the asolid element. (deg)
     * A value of zero means 1 radian (approximately 57.3 degrees).
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param cSys The area object is rotated about the Z-axis in this coordinate system to define the asolid element.
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setAsolid(name: String, matProp: String, matAng: Double, arc: Double, incompatible: Boolean, cSys: String = "Global", color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetAsolid", name, matProp, matAng, arc, incompatible, cSys, color, notes, GUID)

    /**
     * This function assigns property modifiers to an area property. The default value for all modifiers is one.
     * @param name The name of an existing area property.
     * @param value This is an array of 10 unitless modifiers.
     * * Value(0) = Membrane f11 modifier
     * * Value(1) = Membrane f22 modifier
     * * Value(2) = Membrane f12 modifier
     * * Value(3) = Bending m11 modifier
     * * Value(4) = Bending m22 modifier
     * * Value(5) = Bending m12 modifier
     * * Value(6) = Shear v13 modifier
     * * Value(7) = Shear v23 modifier
     * * Value(8) = Mass modifier
     * * Value(9) = Weight modifier
     * @return zero if the modifiers are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetModifiers", name, value)

    /**
     * This function initializes a plane-type area property. If this function is called for an existing area property, all items for the property are reset to their default value.
     * @param name The name of an existing or new area property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param myType This is either 1 or 2, indicating the plane type.
     * * 1 = Plane-stress
     * * 2 = Plane-strain
     * @param matProp The name of the material property for the area property.
     * @param matAng The material angle. (deg)
     * @param thickness The plane thickness. (L)
     * @param incompatible If this item is True, incompatible bending modes are included in the stiffness formulation. In general, incompatible modes significantly improve the bending behavior of the object.
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPlane(name: String, myType: Int, matProp: String, matAng: Double, thickness: Double, incompatible: Boolean, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetPlane", name, myType, matProp, matAng, thickness, incompatible, color, notes, GUID)

    /**
     * This function assigns the design parameters for shell-type area properties.
     * @param name The name of an existing shell-type area property.
     * @param matProp The name of the material property for the area property.
     * @param steelLayoutOption This is 0, 1 or 2, indicating the rebar layout option.
     * * 0 = Default
     * * 1 = One layer
     * * 2 = Two layers
     * @param designCoverTopDir1, DesignCoverTopDir2 The cover to the centroid of the top reinforcing steel running in the local 1 and 2 axes directions of the area object, respectively. (L)
     * This item applies only when SteelLayoutOption = 1 or 2.
     * @param designCoverBotDir1, DesignCoverBotDir2 The cover to the centroid of the bottom reinforcing steel running in the local 1 and 2 axes directions of the area object, respectively. (L)
     * This item applies only when SteelLayoutOption = 2.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setShellDesign(name: String, matProp: String, steelLayoutOption: Int, designCoverTopDir1: Double, designCoverTopDir2: Double, designCoverBotDir1: Double, designCoverBotDir2: Double): Int =
            callFunctionInt("SetShellDesign", name, matProp, steelLayoutOption, designCoverTopDir1, designCoverTopDir2, designCoverBotDir1, designCoverBotDir2)

    /**
     * This function assigns the layer parameters for shell-type area properties.
     * The function returns zero if the parameters are successfully assigned; otherwise, it returns a nonzero value.
     * @param name The name of an existing shell-type area property that is specified to be a layered shell property.
     * @param numberLayers The number of layers in the area property.
     * @param layerName This is an array that includes the name of each layer.
     * @param dist This is an array that includes the distance from the area reference surface (area object joint location plus offsets) to the mid-height of the layer. (L)
     * @param thickness This is an array that includes the thickness of each layer. (L)
     * @param type This is an array that includes 1, 2 or 3, indicating the layer type.
     * @param numIntegrationPts The number of integration points in the thickness direction for the layer. The locations are determined by the program using standard Gauss-quadrature rules.
     * @param matProp This is an array that includes the name of the material property for the layer.
     * @param matAng This is an array that includes the material angle for the layer. (deg)
     * @param s11Type, S22Type, S12Type These are arrays that include 0, 1 or 2, indicating the material component behavior.
     * @return an error if the specified area property is not a shell-type property specified to be a layered shell.
     */
    fun setShellLayer_1(name: String, numberLayers: AIntByRef = IntByRef.UNNECESSARY, layerName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dist: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, thickness: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, numIntegrationPts: AIntArrayByRef = IntArrayByRef.UNNECESSARY, matProp: AStringArrayByRef = StringArrayByRef.UNNECESSARY, matAng: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, s11Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, s22Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY, s12Type: AIntArrayByRef = IntArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetShellLayer_1", name, numberLayers, layerName, dist, thickness, type, numIntegrationPts, matProp, matAng, s11Type, s22Type, s12Type)

    /**
     * This function initializes a shell-type area property. If this function is called for an existing area property, all items for the property are reset to their default value.
     * @param name The name of an existing or new area property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param shellType This is 1, 2, 3, 4, 5 or 6, indicating the shell type.
     * * 1 = Shell - thin
     * * 2 = Shell - thick
     * * 3 = Plate - thin
     * * 4 = Plate - thick
     * * 5 = Membrane
     * * 6 = Shell layered/nonlinear
     * @param includeDrillingDOF This item is True if drilling degrees of freedom are included in the element formulation in the analysis model. This item does not apply when ShellType = 3, 4 or 6.
     * @param matProp The name of the material property for the area property. This item does not apply when ShellType = 6.
     * @param matAng The material angle. (deg)
     * This item does not apply when ShellType = 6.
     * @param thickness The membrane thickness. (L)
     * This item does not apply when ShellType = 6.
     * @param bending The bending thickness. (L)
     * This item does not apply when ShellType = 6.
     * @param color The display color assigned to the property. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, then the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setShell_1(name: String, shellType: Int, includeDrillingDOF: Boolean, matProp: String, matAng: Double, thickness: Double, bending: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetShell_1", name, shellType, includeDrillingDOF, matProp, matAng, thickness, bending, color, notes, GUID)
}