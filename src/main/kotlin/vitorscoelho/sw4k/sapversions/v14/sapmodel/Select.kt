package vitorscoelho.sw4k.sapversions.v14.sapmodel

import vitorscoelho.sw4k.comutils.*

interface SelectV14 : SapComponent {
    /**
     * This function selects or deselects all objects in the model.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun all(deSelect: Boolean = false): Int =
            callFunctionInt("All", deSelect)

    /**
     * @return zero if the selection status is successfully set, otherwise it returns nonzero.
     */
    fun clearSelection(): Int =
            callFunctionInt("ClearSelection")

    /**
     * This function selects or deselects all point objects to which the specified constraint has been assigned.
     * @param name The name of an existing joint constraint.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun constraint(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("Constraint", name, deSelect)

    /**
     * This function selects or deselects objects inside the box defined by the XMin, XMax, YMin, YMax, ZMin and ZMax coordinates.
     * @param xMin, XMax The maximum and minimum X coordinates of the selection box in the specified coordinate system.
     * @param yMin, YMax The maximum and minimum Y coordinates of the selection box in the specified coordinate system.
     * @param zMin, ZMax The maximum and minimum Z coordinates of the selection box in the specified coordinate system.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @param cSys The name of the coordinate system in which XMin, XMax, YMin, YMax, ZMin and ZMax are specified.
     * @param includeIntersections When this item is True, objects that are inside the box or intersecting the sides and edges of the box are selected or deselected.
     * When this item is False, only objects that are fully inside the box are selected or deselected.
     * @param point Point objects that fall inside the box are only selected or deselected when this item is True.
     * @param line Line objects that fall inside the box are only selected or deselected when this item is True.
     * @param area Area objects that fall inside the box are only selected or deselected when this item is True.
     * @param solid Solid objects that fall inside the box are only selected or deselected when this item is True.
     * @param link Link objects that fall inside the box are only selected or deselected when this item is True.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun coordinateRange(xMin: Double, xMax: Double, yMin: Double, yMax: Double, zMin: Double, zMax: Double, deSelect: Boolean = false, cSys: String = "Global", includeIntersections: Boolean = false, point: Boolean = true, line: Boolean = true, area: Boolean = true, solid: Boolean = true, link: Boolean = true): Int =
            callFunctionInt("CoordinateRange", xMin, xMax, yMin, yMax, zMin, zMax, deSelect, cSys, includeIntersections, point, line, area, solid, link)

    /**
     * This function retrieves a list of selected objects.
     * @param numberItems The number of selected objects.
     * @param objectType This is an array that includes the object type of each selected object.
     * * 1 = Point object
     * * 2 = Frame object
     * * 3 = Cable object
     * * 4 = Tendon object
     * * 5 = Area object
     * * 6 = Solid object
     * * 7 = Link object
     * @param objectName This is an array that includes the name of each selected object.
     * @return zero if the selection list is successfully retrieved, otherwise it returns a nonzero value.
     */
    fun getSelected(numberItems: AIntByRef = IntByRef.UNNECESSARY, objectType: AIntArrayByRef = IntArrayByRef.UNNECESSARY, objectName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetSelected", numberItems, objectType, objectName)

    /**
     * This function selects or deselects all objects in the specified group.
     * @param name The name of an existing group.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun group(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("Group", name, deSelect)

    /**
     * This function deselects all selected objects and selects all unselected objects; that is, it inverts the selection.
     * @return zero if the selection is successfully inverted, otherwise it returns nonzero.
     */
    fun invertSelection(): Int =
            callFunctionInt("InvertSelection")

    /**
     * This function selects or deselects objects parallel to specified coordinate axes or planes.
     * @param parallelTo This is an array of six booleans representing three coordinate axes and three coordinate planes. Any combination of the six may be specified.
     * * ParallelTo(0) = X axis
     * * ParallelTo(1) = Y axis
     * * ParallelTo(2) = Z axis
     * * ParallelTo(3) = XY plane
     * * ParallelTo(4) = XZ plane
     * * ParallelTo(5) = YZ plane
     * @param cSys The name of the coordinate system to which the ParallelTo items apply.
     * @param tolerance Line objects that are within this angle in degrees of being parallel to a specified coordinate axis or plane are selected or deselected. (deg)
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun linesParallelToCoordAxis(parallelTo: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, cSys: String = "Global", tolerance: Double = 0.057, deSelect: Boolean = false): Int =
            callFunctionInt("LinesParallelToCoordAxis", parallelTo, cSys, tolerance, deSelect)

    /**
     * This function selects or deselects all line objects that are parallel to a specified line object.
     * @param name The name of a line object.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun linesParallelToLine(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("LinesParallelToLine", name, deSelect)

    /**
     * This function selects or deselects all objects that are in the same XY plane (in the present coordinate system) as the specified point object.
     * @param name The name of a point object.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun planeXY(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PlaneXY", name, deSelect)

    /**
     * This function selects or deselects all objects that are in the same XZ plane (in the present coordinate system) as the specified point object.
     * @param name The name of a point object.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun planeXZ(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PlaneXZ", name, deSelect)

    /**
     * This function selects or deselects all objects that are in the same YZ plane (in the present coordinate system) as the specified point object.
     * @param name The name of a point object.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun planeYZ(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PlaneYZ", name, deSelect)

    /**
     * This function restores the previous selection.
     * @return zero if the selection is successfully restored, otherwise it returns nonzero.
     */
    fun previousSelection(): Int =
            callFunctionInt("PreviousSelection")

    /**
     * This function selects or deselects all area objects to which the specified section has been assigned.
     * @param name The name of an existing area section property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyArea(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyArea", name, deSelect)

    /**
     * This function selects or deselects all cable objects to which the specified section has been assigned.
     * @param name The name of an existing cable section property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyCable(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyCable", name, deSelect)

    /**
     * This function selects or deselects all line objects to which the specified section has been assigned.
     * @param name The name of an existing frame section property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyFrame(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyFrame", name, deSelect)

    /**
     * This function selects or deselects all link objects to which the specified section property has been assigned.
     * @param name The name of an existing link property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyLink(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyLink", name, deSelect)

    /**
     * This function selects or deselects all link objects to which the specified frequency dependent link property has been assigned.
     * @param name The name of an existing frequency dependent link property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyLinkFD(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyLinkFD", name, deSelect)

    /**
     * This function selects or deselects all objects to which the specified material property has been assigned.
     * @param name The name of an existing material property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyMaterial(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyMaterial", name, deSelect)

    /**
     * This function selects or deselects all solid objects to which the specified property has been assigned.
     * @param name The name of an existing solid property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertySolid(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertySolid", name, deSelect)

    /**
     * This function selects or deselects all tendon objects to which the specified section has been assigned.
     * @param name The name of an existing tendon section property.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun propertyTendon(name: String, deSelect: Boolean = false): Int =
            callFunctionInt("PropertyTendon", name, deSelect)

    /**
     * This function selects or deselects point objects with support in the specified degrees of freedom.
     * @param dof This is an array of six booleans for the six degrees of freedom of a point object.
     * * dof(0) = U1
     * * dof(1) = U2
     * * dof(2) = U3
     * * dof(3) = R1
     * * dof(4) = R2
     * * dof(5) = R3
     * @param cSys The name of the coordinate system in which degrees of freedom (dof) are specified. This is either Local or the name of a defined coordinate system. Local means the point local coordinate system.
     * @param deSelect The item is False if objects are to be selected and True if they are to be deselected.
     * @param selectRestraints If this item is True then points with restraint assignments in one of the specified degrees of freedom are selected or deselected.
     * @param selectJointSprings If this item is True then points with joint spring assignments in one of the specified degrees of freedom are selected or deselected.
     * @param selectLineSprings If this item is True, points with a contribution from line spring assignments in one of the specified degrees of freedom are selected or deselected.
     * @param selectAreaSprings If this item is True, points with a contribution from area spring assignments in one of the specified degrees of freedom are selected or deselected.
     * @param selectSolidSprings If this item is True, points with a contribution from solid surface spring assignments in one of the specified degrees of freedom are selected or deselected.
     * @param selectOneJointLinks If this item is True, points with one joint link assignments in one of the specified degrees of freedom are selected or deselected.
     * @return zero if the selection is successfully completed, otherwise it returns nonzero.
     */
    fun supportedPoints(dOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, cSys: String = "Local", deSelect: Boolean = false, selectRestraints: Boolean = true, selectJointSprings: Boolean = true, selectLineSprings: Boolean = true, selectAreaSprings: Boolean = true, selectSolidSprings: Boolean = true, selectOneJointLinks: Boolean = true): Int =
            callFunctionInt("SupportedPoints", dOF, cSys, deSelect, selectRestraints, selectJointSprings, selectLineSprings, selectAreaSprings, selectSolidSprings, selectOneJointLinks)
}