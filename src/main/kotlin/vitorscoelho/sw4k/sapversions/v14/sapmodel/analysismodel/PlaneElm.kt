package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm
import vitorscoelho.sw4k.sapenums.PlaneDOF
import vitorscoelho.sw4k.sapenums.AreaTemperatureLoadType
import vitorscoelho.sw4k.sapenums.Dir

interface PlaneElmV14 : SapComponent {
    /**
     * @return the total number of plane elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function retrieves the gravity load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each gravity load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the gravity load multipliers are specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each gravity load.
     * @param x array of gravity load multipliers in the x direction of the specified coordinate system.
     * @param y array of gravity load multipliers in the y direction of the specified coordinate system.
     * @param z array of gravity load multipliers in the z direction of the specified coordinate system.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, x: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, y: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, z: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, planeName, loadPat, cSys, x, y, z, itemTypeElm)

    /**
     * This function retrieves the pore pressure load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of pore pressure loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each pore pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each pore pressure load.
     * @param value This is an array that includes the pore pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the pore pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadPorePressure(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadPorePressure", name, numberItems, planeName, loadPat, value, patternName, itemTypeElm)

    /**
     * This function retrieves the rotate load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of rotate loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each rotate load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each rotate load.
     * @param value This is an array that includes the rotate load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the rotate load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadRotate(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadRotate", name, numberItems, planeName, loadPat, value, patternName, itemTypeElm)

    /**
     * This function retrieves the strain load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param component This is an array that includes 1, 2, 3, 4 or 5, indicating the component associated with each strain load ([PlaneDOF] enumeration).
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain12
     * * 4 = Strain13
     * * 5 = Strain23
     * @param value This is an array that includes the strain value. (L/L)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, component: AIntArrayByRef = IntArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, planeName, loadPat, component, value, patternName, itemTypeElm)

    /**
     * This function retrieves the surface pressure load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of surface pressure loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each surface pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each surface pressure load.
     * @param face This is an array that includes -1, -2 or a nonzero, positive integer, indicating the area element face to which the specified load assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from plane element point n to plane element point n + 1. For example, edge face 2 is from plane element point 2 to plane element point 3.
     * @param value This is an array that includes the surface pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the surface pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadSurfacePressure(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, face: AIntArrayByRef = IntArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadSurfacePressure", name, numberItems, planeName, loadPat, face, value, patternName, itemTypeElm)

    /**
     * This function retrieves the temperature load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param myType This is an array that includes either 1 or 3, indicating the type of temperature load ([AreaTemperatureLoadType] enumeration).
     * * 1 = Temperature
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is an array that includes the temperature load value. (T) for MyType= 1 and (T/L) for MyType= 3
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, myType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, patternName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, planeName, loadPat, myType, value, patternName, itemTypeElm)

    /**
     * This function retrieves the uniform load assignments to plane elements.
     * @param name The name of an existing plane element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of uniform loads retrieved for the specified plane elements.
     * @param planeName This is an array that includes the name of the plane element associated with each uniform load.
     * @param loadPat This is an array that includes the name of the coordinate system in which the uniform load is specified.
     * @param cSys This is an array that includes the name of the coordinate system associated with each uniform load.
     * @param dir This is an integer between 1 and 11, indicating the direction of the load ([Dir] enumeration).
     * * 1 = Local 1 axis (applies only when CSys is Local)
     * * 2 = Local 2 axis (applies only when CSys is Local)
     * * 3 = Local 3 axis (applies only when CSys is Local)
     * * 4 = X direction (does not apply when CSys is Local)
     * * 5 = Y direction (does not apply when CSys is Local)
     * * 6 = Z direction (does not apply when CSys is Local)
     * * 7 = Projected X direction (does not apply when CSys is Local)
     * * 8 = Projected Y direction (does not apply when CSys is Local)
     * * 9 = Projected Z direction (does not apply when CSys is Local)
     * * 10 = Gravity direction (applies only when CSys is Global)
     * * 11 = Projected Gravity direction (applies only when CSys is Global)
     * The positive gravity direction (see Dir = 10 and 11) is in the negative Global Z direction.
     * @param value The uniform load value. (F/L2)
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the plane elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the plane element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the plane elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for plane elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadUniform(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, planeName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, loadPat: AStringArrayByRef = StringArrayByRef.UNNECESSARY, cSys: AStringArrayByRef = StringArrayByRef.UNNECESSARY, dir: AIntArrayByRef = IntArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadUniform", name, numberItems, planeName, loadPat, cSys, dir, value, itemTypeElm)

    /**
     * This function retrieves the local axis angle assignment for plane elements.
     * @param name The name of an existing plane element.
     * @param ang This is the angle that the local 1 and 2 axes are rotated about the positive local 3 axis from the default orientation. The rotation for a positive angle appears counter clockwise when the local +3 axis is pointing toward you. (deg)
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetLocalAxes", name, ang)

    /**
     * This function retrieves the material temperature assignments to plane elements.
     * @param name The name of an existing plane element.
     * @param temp This is the material temperature value assigned to the plane element. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the plane element is uniform over the element at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the plane element may vary. The material temperature at each corner point around the plane element perimeter is equal to the specified temperature multiplied by the pattern value at the associated point element. The material temperature at other points in the plane element is calculated by interpolation from the corner points.
     * @return zero if the material temperature assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: ADoubleByRef = DoubleByRef.UNNECESSARY, patternName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the names of all defined plane elements.
     * @param numberNames The number of plane element names retrieved by the program.
     * @param myName This is a one-dimensional array of plane element names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the name of the area object from which an plane element was created.
     * @param name The name of an existing plane element.
     * @param obj The name of the area object from which the plane element was created.
     * @return zero if the information is successfully retrieved; otherwise it returns nonzero.
     */
    fun getObj(name: String, obj: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetObj", name, obj)

    /**
     * This function retrieves the names of the point elements that define an plane element.
     * @param name The name of an plane element.
     * @param numberPoints The number of point elements that define the plane element.
     * @param point This is an array containing the names of the point elements that define the plane element. The point names are in order around the plane element.
     * @return zero if the point element names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, numberPoints: AIntByRef = IntByRef.UNNECESSARY, point: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetPoints", name, numberPoints, point)

    /**
     * This function retrieves the area property assigned to an plane element.
     * @param name The name of a defined plane element.
     * @param propName The name of the area property assigned to the plane element. This item is None if there is no area property assigned to the plane element.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * @param name The name of an existing plane element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the plane element local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the element local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetTransformationMatrix", name, value)
}