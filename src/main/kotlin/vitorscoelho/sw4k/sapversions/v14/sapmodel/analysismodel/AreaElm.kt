package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.sapmodel.enums.ItemTypeElm
import vitorscoelho.sw4k.sap.sapmodel.enums.AreaTemperatureLoadType
import vitorscoelho.sw4k.sap.sapmodel.enums.Dir
import vitorscoelho.sw4k.sap.sapmodel.enums.JointOffsetType
import vitorscoelho.sw4k.sap.sapmodel.enums.ThicknessType
import vitorscoelho.sw4k.sap.sapmodel.enums.AreaDOF

interface AreaElmV14 : SapComponent {
    /**
     * @return the total number of area elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function retrieves the gravity load assignments to area elements.
     * @param name The name of an existing area element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each gravity load.
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
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, areaName, loadPat, cSys, x, y, z, itemTypeElm)

    /**
     * This function retrieves the pore pressure load assignments to area elements.
     * @param name The name of an existing area element or group depending on the value of the ItemType item.
     * @param numberItems The total number of pore pressure loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each pore pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each pore pressure load.
     * @param value This is an array that includes the pore pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the pore pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadPorePressure(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadPorePressure", name, numberItems, areaName, loadPat, value, patternName, itemTypeElm)

    /**
     * This function retrieves the strain load assignments to area elements.
     * @param name The name of an existing area element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param component This is an array that includes 1, 2, 3, 4, 5, 6, 7 or 8, indicating the component associated with each strain load ([AreaDOF] enumeration).
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain12
     * * 4 = Curvature11
     * * 5 = Curvature22
     * * 6 = Curvature12
     * * 7 = Strain13
     * * 8 = Strain23
     * @param value This is an array that includes the strain value. (L/L) for Component = 1, 2, 3, 7 and 8, and (1/L) for Component = 4, 5 and 6
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, component: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, areaName, loadPat, component, value, patternName, itemTypeElm)

    /**
     * This function retrieves the surface pressure load assignments to area elements.
     * @param name The name of an existing area element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of surface pressure loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each surface pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each surface pressure load.
     * @param face This is an array that includes -1, -2 or a nonzero, positive integer, indicating the area element face to which the specified load assignment applies.
     * * -1 = Bottom face
     * * -2 = Top face
     * * >0 = Edge face
     * Note that edge face n is from area element point n to area element point n + 1. For example, edge face 2 is from area element point 2 to area element point 3.
     * @param value This is an array that includes the surface pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the surface pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadSurfacePressure(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, face: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadSurfacePressure", name, numberItems, areaName, loadPat, face, value, patternName, itemTypeElm)

    /**
     * This function retrieves the temperature load assignments to area elements.
     * @param name The name of an existing area element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param myType This is an array that includes either 1 or 3, indicating the type of temperature load ([AreaTemperatureLoadType] enumeration)
     * * 1 = Temperature
     * * 3 = Temperature gradient along local 3 axis
     * @param value This is an array that includes the temperature load value. (T) for MyType= 1 and (T/L) for MyType= 3
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemTypeElm This is one of the following items in the eItemTypeElm enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, myType: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, areaName, loadPat, myType, value, patternName, itemTypeElm)

    /**
     * This function retrieves the uniform load assignments to area elements.
     * @param name The name of an existing area element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of uniform loads retrieved for the specified area elements.
     * @param areaName This is an array that includes the name of the area element associated with each uniform load.
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
     * If this item is ObjectElm, the load assignments are retrieved for the area elements corresponding to the area object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the area element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the area elements corresponding to all area objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for area elements corresponding to all selected area objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadUniform(name: String, numberItems: IntByRef, areaName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, dir: IntArrayByRef, value: DoubleArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadUniform", name, numberItems, areaName, loadPat, cSys, dir, value, itemTypeElm)

    /**
     * This function retrieves the local axis angle assignment for area elements.
     * @param name The name of an existing area element.
     * @param ang This is the angle that the local 1 and 2 axes are rotated about the positive local 3 axis from the default orientation. The rotation for a positive angle appears counter clockwise when the local +3 axis is pointing toward you. (deg)
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, ang: DoubleByRef): Int =
            callFunctionInt("GetLocalAxes", name, ang)

    /**
     * This function retrieves the material overwrite assigned to an area element, if any. The material property name is indicated as None if there is no material overwrite assignment.
     * @param name The name of a defined area element.
     * @param propName This is None, indicating that no material overwrite exists for the specified area element, or it is the name of an existing material property.
     * @return zero if the material overwrite assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMaterialOverwrite(name: String, propName: StringByRef): Int =
            callFunctionInt("GetMaterialOverwrite", name, propName)

    /**
     * This function retrieves the material temperature assignments to area elements.
     * @param name The name of an existing area element.
     * @param temp This is the material temperature value assigned to the area element. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the area element is uniform over the element at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the area element may vary. The material temperature at each corner point around the area element perimeter is equal to the specified temperature multiplied by the pattern value at the associated point element. The material temperature at other points in the area element is calculated by interpolation from the corner points.
     * @return zero if the material temperature assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the modifier assignment for area elements. The default value for all modifiers is one.
     * @param name The name of an existing area element.
     * @param value This is an array of ten unitless modifiers.
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
    fun getModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of all defined area elements.
     * @param numberNames The number of area element names retrieved by the program.
     * @param myName This is a one-dimensional array of area element names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the name of the area object from which an area element was created.
     * @param name The name of an existing area element.
     * @param obj The name of the area object from which the area element was created.
     * @return zero if the information is successfully retrieved; otherwise it returns nonzero.
     */
    fun getObj(name: String, obj: StringByRef): Int =
            callFunctionInt("GetObj", name, obj)

    /**
     * This function retrieves the joint offset assignments for area elements.
     * @param name The name of an existing area element.
     * @param offsetType This is 0, 1 or 2, indicating the joint offset type ([JointOffsetType] enumeration).
     * * 0 = No joint offsets
     * * 1 = User defined joint offsets specified by joint pattern
     * * 2 = User defined joint offsets specified by point
     * @param offsetPattern This item applies only when JointOffsetType = 1. It is the name of the defined joint pattern that is used to calculate the joint offsets.
     * @param offsetPatternSF This item only applies when JointOffsetType = 1. It is the scale factor applied to the joint pattern when calculating the joint offsets. (L)
     * @param offset This item applies only when JointOffsetType = 2. It is an array of joint offsets for each of the points that define the area element. (L)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getOffsets(name: String, offsetType: IntByRef, offsetPattern: StringByRef, offsetPatternSF: DoubleByRef, offset: DoubleArrayByRef): Int =
            callFunctionInt("GetOffsets", name, offsetType, offsetPattern, offsetPatternSF, offset)

    /**
     * This function retrieves the names of the point elements that define an area element.
     * @param name The name of an area element.
     * @param numberPoints The number of point elements that define the area element.
     * @param point This is an array containing the names of the point elements that define the area element. The point names are in order around the area element.
     * @return zero if the point element names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, numberPoints: IntByRef, point: StringArrayByRef): Int =
            callFunctionInt("GetPoints", name, numberPoints, point)

    /**
     * This function retrieves the area property assigned to an area element.
     * @param name The name of a defined area element.
     * @param propName The name of the area property assigned to the area element. This item is None if there is no area property assigned to the area element.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * This function retrieves the thickness overwrite assignments for area elements.
     * @param name The name of an existing area element.
     * @param thicknessType This is 0, 1 or 2, indicating the thickness overwrite type ([ThicknessType] enumeration).
     * * 0 = No thickness overwrites
     * * 1 = User defined thickness overwrites specified by joint pattern
     * * 2 = User defined thickness overwrites specified by point
     * @param thicknessPattern This item applies only when ThicknessType = 1. It is the name of the defined joint pattern that is used to calculate the thicknesses.
     * @param thicknessPatternSF This item applies only when ThicknessType = 1. It is the scale factor applied to the joint pattern when calculating the thicknesses. (L)
     * @param thickness This item applies only when ThicknessType = 2. It is an array of thicknesses at each of the points that define the area element. (L)
     * @return zero if the assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getThickness(name: String, thicknessType: IntByRef, thicknessPattern: StringByRef, thicknessPatternSF: DoubleByRef, thickness: DoubleArrayByRef): Int =
            callFunctionInt("GetThickness", name, thicknessType, thicknessPattern, thicknessPatternSF, thickness)

    /**
     * @param name The name of an existing area element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the area element local coordinate system to the global coordinate system.
     * In the equation c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the element local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetTransformationMatrix", name, value)
}