package vitorscoelho.sw4k.sapversions.v14.sapmodel.bridgeadvanced

import vitorscoelho.sw4k.comutils.*

interface BASConcBoxV14 : SapComponent {
    /**
     * This function returns the number of stress points at the specified web of the specified superstructure section cut.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut.
     * @param webIndex The index number of the web in this section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function GetSuperCutSectionValues.
     * @param count The number of stress points in this web for this section cut in this bridge object. They will be identified in subsequent API functions using the indices 0 to Count-1.
     * @return zero if the count is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun countSuperCutWebStressPoint(name: String, cutIndex: Int, webIndex: Int, count: IntByRef): Int =
            callFunctionInt("CountSuperCutWebStressPoint", name, cutIndex, webIndex, count)

    /**
     * This function returns section properties for the region above or below a given Y coordinate value at a single superstructure section cut in a bridge object. These properties are calculated for the section before skew, grade, and superelevation are applied. Coordinate values are measured from the lower-left corner of the section bounding-box. X is positive to the right when looking upstation, and Y is positive upward.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param Y The Y coordinate in the section local coordinate system above or below which the section properties are calculated.
     * @param aboveY Boolean indicating whether properties are to be computed for the region above (if true) or below (if false) the specified coordinate Y.
     * @param ycg Y coordinate of the centroid of the region above/below specified coordinate Y. (L)
     * @param area Area of the region above/below specified coordinate Y. (L2)
     * @param inertia Moment of inertia of the region above/below specified coordinate Y, taken about a horizontal axis at Ycg. (L4)
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutSectionPropsAtY(name: String, cutIndex: Int, Y: Double, aboveY: Boolean, ycg: DoubleByRef, area: DoubleByRef, inertia: DoubleByRef): Int =
            callFunctionInt("GetSuperCutSectionPropsAtY", name, cutIndex, Y, aboveY, ycg, area, inertia)

    /**
     * This function returns an individual section property at a single superstructure section cut in a bridge object. These properties are calculated for the section before skew, grade, and superelevation are applied. Coordinate values are measured from the lower-left corner of the section bounding-box. X is positive to the right when looking upstation, and Y is positive upward.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param item This is an integer from 1 to 12, inclusive, indicating the type of property value to be gotten:
     * 16 = Right outside length of torsion circuit (along slope), HTorsionRight
     * @param value The value of the requested item:
     * Value >= 0, integral.
     * Value > 0. (L2)
     * Value >= 0. (L2)
     * Value > 0. (L)
     * Value >= 0. (L)
     * Any value is valid. (L)
     * Any value is valid. (L)
     * Value >= 0. (L)
     * Value <= 0. (L)
     * Value >= 0. (L2)
     * Value >= 0. (L)
     * Value >= 0.
     * Value > 0. (L)
     * Value > 0. (L)
     * Value > 0. (L)
     * Value > 0. (L)
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutSectionValues(name: String, cutIndex: Int, item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetSuperCutSectionValues", name, cutIndex, item, value)

    /**
     * This function returns information about the box girder slab thicknesses at a given horizontal location across the box girder section.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param X The X coordinate in the section local coordinate system at which a vertical line is passed through the section and the slab coordinates are returned.
     * @param status This is 0, 1, or 2.
     * * 0 = No portion of the section is cut.
     * * 1 = Only the section is cut; no interior cell is cut.
     * * 2 = The section and an interior cell are cut.
     * @param y1 The topmost Y coordinate where the vertical line cuts the section. This item is returned as zero when Status < 1.
     * @param y2 The bottommost Y coordinate where the vertical line cuts the section. This item is returned as zero when Status < 1.
     * @param y3 The topmost Y coordinate where the vertical line cuts an interior cell. This item is returned as zero when Status < 2.
     * @param y4 The bottommost Y coordinate where the vertical line cuts an interior cell. This item is returned as zero when Status < 2.
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutSlabCoordsAtX(name: String, cutIndex: Int, X: Double, status: IntByRef, y1: DoubleByRef, y2: DoubleByRef, y3: DoubleByRef, y4: DoubleByRef): Int =
            callFunctionInt("GetSuperCutSlabCoordsAtX", name, cutIndex, X, status, y1, y2, y3, y4)

    /**
     * This function returns the name of a single tendon object, giving access to tendon assignments, tendon section, and material property.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param tendonIndex The index number of a tendon in this section cut of this bridge object. This must be from 0 to CountTendon-1, where CountTendon is the number of tendons returned by function GetSuperCutSectionValues using Item = 12.
     * @param bridgeTendon The name of the tendon inside of the bridge object corresponding to TendonIndex.
     * @param tendonObj The name of the tendon object created by the program from the bridge object tendon corresponding to TendonIndex.
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutTendonNames(name: String, cutIndex: Int, tendonIndex: Int, bridgeTendon: StringByRef, tendonObj: StringByRef): Int =
            callFunctionInt("GetSuperCutTendonNames", name, cutIndex, tendonIndex, bridgeTendon, tendonObj)

    /**
     * This function returns an individual section property for a single tendon at a single superstructure section cut in a bridge object. These properties are calculated for the section before skew, grade, and superelevation are applied. Coordinate values are measured from the lower-left corner of the section bounding-box. X is positive to the right when looking upstation, and Y is positive upward.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param tendonIndex The index number of a tendon in this section cut of this bridge object. This must be from 0 to CountTendon-1, where CountTendon is the number of tendons returned by the function GetSuperCutSectionValues using Item = 12.
     * @param item This is an integer from 1 to 4, inclusive, indicating the type of property value to be gotten:
     * * 1 = X coordinate of tendon centroid, Xcg
     * * 2 = Y coordinate of tendon centroid, Ycg
     * * 3 = Duct diameter for tendon
     * * 4 = Bonding type for tendon
     * * 5 = Tendon slope
     * @param value The value of the requested item:
     * * 1 = X coordinate of tendon centroid, Xcg. Any value OK. (L)
     * * 2 = Y coordinate of tendon centroid, Ycg. Any value OK. (L)
     * * 3 = Duct diameter for tendon; Value >= 0. (L)
     * * 4 = Bonding type for tendon
     * * * 1 = Bonded
     * * * 2 = Unbonded
     * * 5 = Tendon slope. Any value OK. (L/L)
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutTendonValues(name: String, cutIndex: Int, tendonIndex: Int, item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetSuperCutTendonValues", name, cutIndex, tendonIndex, item, value)

    /**
     * This function returns information about the box girder web thicknesses at a given elevation in the box girder section.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param Y The Y coordinate in the section local coordinate system at which the web coordinates are returned.
     * @param numberWebs The number of webs in the section.
     * @param webIsCut This is a array of booleans indicating if each web is cut by a horizontal line at the specified Y coordinate.
     * @param webLeft This is a array of X coordinates of the left side of each web. If the web is not cut by a horizontal line at the specified Y coordinate, this value is returned as zero.
     * @param webRight This is a array of X coordinates of the right side of each web. If the web is not cut by a horizontal line at the specified Y coordinate, this value is returned as zero.
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutWebCoordsAtY(name: String, cutIndex: Int, Y: Double, numberWebs: IntByRef, webIsCut: BooleanArrayByRef, webLeft: DoubleArrayByRef, webRight: DoubleArrayByRef): Int =
            callFunctionInt("GetSuperCutWebCoordsAtY", name, cutIndex, Y, numberWebs, webIsCut, webLeft, webRight)

    /**
     * This function returns location and material information about a single stress point in a web at a superstructure section cut in a bridge object.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut.
     * @param webIndex The index number of the web in this section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function GetSuperCutSectionValues.
     * @param pointIndex The index number of the stress point in this web of this section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCutWebStressPoint.
     * @param x, Y The transverse and vertical coordinates of the stress point in the section, measured from the bottom left corner of the section. X is positive to the right when looking upstation. Y is positive upward. (L)
     * @param matProp The name of the material property at this stress point.
     * @param note A description of the stress point that may be used for identification. Points that are pre-defined by the program will have prescribed notes.
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutWebStressPoint(name: String, cutIndex: Int, webIndex: Int, pointIndex: Int, x: DoubleByRef, y: DoubleByRef, matProp: StringByRef, note: StringByRef): Int =
            callFunctionInt("GetSuperCutWebStressPoint", name, cutIndex, webIndex, pointIndex, x, y, matProp, note)

    /**
     * This function returns an individual section property for a single web at a single superstructure section cut in a bridge object. These properties are calculated for the section before skew, grade, and superelevation are applied. Coordinate values are measured from the lower-left corner of the section bounding-box. X is positive to the right when looking upstation, and Y is positive upward
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of the section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by the function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param webIndex The index number of a web in this section cut of this bridge object. This must be from 0 to CountWeb-1, where CountWeb is the number of webs returned by thenfunction GetSuperCutSectionValues using Item = 1. Webs count from left to right when looking upstation.
     * @param item This is an integer from 1 to 6, inclusive, indicating the type of property value to be gotten:
     * 2 = Minimum horizontal (X) web thickness
     * 3 = Minimum top slab thickness above cell to left of web
     * 4 = Minimum bottom slab thickness above cell to left of web
     * 5 = Top width of cell to left of web measured from centerline of girders on each side of cell
     * 6 = Bottom width of cell to left of web measured from centerline of girders on each side of cell.
     * @param value The value of the requested item:
     * Abs(Value) < 90. (deg)
     * Value < 0. (L)
     * Value >= 0. (L)
     * @return zero if the information is successfully retrieved; otherwise it returns a nonzero value. An error is returned for items 3, 4, 5 and 6 if the WebIndex is specified as 0. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutWebValues(name: String, cutIndex: Int, webIndex: Int, item: Int, value: DoubleByRef): Int =
            callFunctionInt("GetSuperCutWebValues", name, cutIndex, webIndex, item, value)
}