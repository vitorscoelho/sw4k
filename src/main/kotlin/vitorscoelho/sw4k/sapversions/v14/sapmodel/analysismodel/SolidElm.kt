package vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.ItemTypeElm
import vitorscoelho.sw4k.sapenums.SolidDOF

interface SolidElmV14 : SapComponent {
    /**
     * @return the total number of solid elements in the analysis model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * This function retrieves the gravity load assignments to solid elements.
     * @param name The name of an existing solid element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of gravity loads retrieved for the specified solid elements.
     * @param solidName This is an array that includes the name of the solid element associated with each gravity load.
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
     * If this item is ObjectElm, the load assignments are retrieved for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the solid element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for solid elements corresponding to all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadGravity(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, cSys: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, z: DoubleArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadGravity", name, numberItems, solidName, loadPat, cSys, x, y, z, itemTypeElm)

    /**
     * This function retrieves the pore pressure load assignments to solid elements.
     * @param name The name of an existing solid element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of pore pressure loads retrieved for the specified solid elements.
     * @param solidName This is an array that includes the name of the solid element associated with each pore pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each pore pressure load.
     * @param value This is an array that includes the pore pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the pore pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the solid element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for solid elements corresponding to all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadPorePressure(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadPorePressure", name, numberItems, solidName, loadPat, value, patternName, itemTypeElm)

    /**
     * This function retrieves the strain load assignments to solid elements.
     * @param name The name of an existing solid element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of strain loads retrieved for the specified solid elements.
     * @param solidName This is an array that includes the name of the solid element associated with each strain load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each strain load.
     * @param component This is 1, 2, 3, 4, 5 or 6, indicating the component to which the strain load is applied ([SolidDOF] enumeration).
     * * 1 = Strain11
     * * 2 = Strain22
     * * 3 = Strain33
     * * 4 = Strain12
     * * 5 = Strain13
     * * 6 = Strain23
     * @param value This is an array that includes the strain value. (L/L)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the strain load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the solid element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for solid elements corresponding to all selected solid objects, and the Name item is ignored.
     * @return zero if the strain load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadStrain(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, component: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadStrain", name, numberItems, solidName, loadPat, component, value, patternName, itemTypeElm)

    /**
     * This function retrieves the surface pressure load assignments to solid objects.
     * @param name The name of an existing solid element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of surface pressure loads retrieved for the specified solid elements.
     * @param solidName This is an array that includes the name of the solid element associated with each surface pressure load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each surface pressure load.
     * @param face This is an array that includes 1, 2, 3, 4, 5 or 6, indicating the solid element face to which the specified load assignment applies.
     * @param value This is an array that includes the surface pressure load value. (F/L2)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the surface pressure load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the solid element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for solid elements corresponding to all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadSurfacePressure(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, face: IntArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadSurfacePressure", name, numberItems, solidName, loadPat, face, value, patternName, itemTypeElm)

    /**
     * This function retrieves the temperature load assignments to solid elements.
     * @param name The name of an existing solid element or group, depending on the value of the ItemType item.
     * @param numberItems The total number of temperature loads retrieved for the specified solid elements.
     * @param solidName This is an array that includes the name of the solid element associated with each temperature load.
     * @param loadPat This is an array that includes the name of the load pattern associated with each temperature load.
     * @param value This is an array that includes the temperature load value. (T)
     * @param patternName This is an array that includes the joint pattern name, if any, used to specify the temperature load.
     * @param itemTypeElm This is one of the following items in the [ItemTypeElm] enumeration:
     * * ObjectElm = 0
     * * Element = 1
     * * GroupElm = 2
     * * SelectionElm = 3
     * If this item is ObjectElm, the load assignments are retrieved for the solid elements corresponding to the solid object specified by the Name item.
     * If this item is Element, the load assignments are retrieved for the solid element specified by the Name item.
     * If this item is GroupElm, the load assignments are retrieved for the solid elements corresponding to all solid objects included in the group specified by the Name item.
     * If this item is SelectionElm, the load assignments are retrieved for solid elements corresponding to all selected solid objects, and the Name item is ignored.
     * @return zero if the load assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoadTemperature(name: String, numberItems: IntByRef, solidName: StringArrayByRef, loadPat: StringArrayByRef, value: DoubleArrayByRef, patternName: StringArrayByRef, itemTypeElm: Int = ItemTypeElm.ELEMENT.sapId): Int =
            callFunctionInt("GetLoadTemperature", name, numberItems, solidName, loadPat, value, patternName, itemTypeElm)

    /**
     * This function retrieves the local axis angle assignment for solid elements.
     * @param name The name of an existing solid element.
     * @param a, b, c The local axes of the solid element are defined by first setting the positive local 1, 2 and 3 axes the same as the positive global X, Y and Z axes and then doing the following: (deg)
     * * 1. Rotate about the 3 axis by angle a.
     * * 2. Rotate about the resulting 2 axis by angle b.
     * * 3. Rotate about the resulting 1 axis by angle c.
     * @return zero if the assignment is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLocalAxes(name: String, a: DoubleByRef, b: DoubleByRef, c: DoubleByRef): Int =
            callFunctionInt("GetLocalAxes", name, a, b, c)

    /**
     * This function retrieves the material temperature assignments to solid elements.
     * @param name The name of an existing solid element.
     * @param temp This is the material temperature value assigned to the solid element. (T)
     * @param patternName This is blank or the name of a defined joint pattern. If it is blank, the material temperature for the solid element is uniform over the element at the value specified by Temp.
     * If PatternName is the name of a defined joint pattern, the material temperature for the solid element may vary. The material temperature at each corner point of the solid element is equal to the specified temperature multiplied by the pattern value at the associated point element. The material temperature at other locations in the solid element is calculated by interpolation from the corner points.
     * @return zero if the material temperature assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMatTemp(name: String, temp: DoubleByRef, patternName: StringByRef): Int =
            callFunctionInt("GetMatTemp", name, temp, patternName)

    /**
     * This function retrieves the names of all defined solid elements.
     * @param numberNames The number of solid element names retrieved by the program.
     * @param myName This is a one-dimensional array of solid element names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the name of the solid object from which a solid element was created.
     * @param name The name of an existing solid element.
     * @param obj The name of the solid object from which the solid element was created.
     * @return zero if the information is successfully retrieved; otherwise it returns nonzero.
     */
    fun getObj(name: String, obj: StringByRef): Int =
            callFunctionInt("GetObj", name, obj)

    /**
     * This function retrieves the names of the eight point elements that define a solid element.
     * @param name The name of an solid element.
     * @param point This is an array containing the names of the eight point elements that define the solid element. The point names are in order around the solid element.
     * @return zero if the point element names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPoints(name: String, point: StringArrayByRef): Int =
            callFunctionInt("GetPoints", name, point)

    /**
     * This function retrieves the solid property assigned to a solid element.
     * @param name The name of a defined solid element.
     * @param propName The name of the solid property assigned to the solid element.
     * @return zero if the property is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getProperty(name: String, propName: StringByRef): Int =
            callFunctionInt("GetProperty", name, propName)

    /**
     * @param name The name of an existing solid element.
     * @param value Value is an array of nine direction cosines that define the transformation matrix.
     * The following matrix equation shows how the transformation matrix is used to convert items from the solid element local coordinate system to the global coordinate system.
     * In the equation, c0 through c8 are the nine values from the transformation array, (Local1, Local2, Local3) are an item (such as a load) in the element local coordinate system, and (GlobalX, GlobalY, GlobalZ) are the same item in the global coordinate system.
     * @return zero if the transformation matrix is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTransformationMatrix(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetTransformationMatrix", name, value)
}