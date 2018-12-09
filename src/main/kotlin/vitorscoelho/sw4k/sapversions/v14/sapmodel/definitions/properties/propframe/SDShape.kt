package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propframe

import vitorscoelho.sw4k.comutils.*

interface SDShapeV14 : SapComponent {
    /**
     * This function deletes shapes from a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing shape in a section designer property. If the All item is True, this item may be specified as a blank string.
     * @param all If this item is True, all shapes in the section designer property specified by the Name item are deleted.
     * @return zero if the shape is successfully deleted; otherwise it returns a nonzero value.
     */
    fun delete (name:String,shapeName:StringByRef,all:Boolean=false):Int=
            callFunctionInt("Delete",name,shapeName,all)
    /**
     * This function retrieves property data for an Angle shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Angle shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Angle property that has been imported from a section property file. If it is the name of a defined Angle property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param bf The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAngle (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,bf:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetAngle",name,shapeName,matProp,propName,color,xCenter,yCenter,h,bf,tf,tw,rotation)
    /**
     * This function retrieves property data for a Channel shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Channel shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Channel property that has been imported from a section property file. If it is the name of a defined Channel property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param bf The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getChannel (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,bf:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetChannel",name,shapeName,matProp,propName,color,xCenter,yCenter,h,bf,tf,tw,rotation)
    /**
     * This function retrieves property data for a Double Angle shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Double Angle shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Double Angle property that has been imported from a section property file. If it is the name of a defined Double Angle property, then the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param w The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param dis Separation between the two flanges that are parallel. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDblAngle (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,w:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,dis:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetDblAngle",name,shapeName,matProp,propName,color,xCenter,yCenter,h,w,tf,tw,dis,rotation)
    /**
     * This function retrieves property data for an I-section shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing I-section shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined I-section property that has been imported from a section property file. If it is the name of a defined I-section property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param bf The top flange width. (L)
     * @param tf The top flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param bfb The bottom flange width. (L)
     * @param tfb The bottom flange thickness. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getISection (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,bf:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,bfb:DoubleByRef,tfb:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetISection",name,shapeName,matProp,propName,color,xCenter,yCenter,h,bf,tf,tw,bfb,tfb,rotation)
    /**
     * This function retrieves property data for a Pipe shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Pipe shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Pipe property that has been imported from a section property file. If it is the name of a defined Pipe property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The outer diameter of the Pipe. (L)
     * @param thickness The wall thickness of the Pipe. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPipe (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,diameter:DoubleByRef,thickness:DoubleByRef):Int=
            callFunctionInt("GetPipe",name,shapeName,matProp,propName,color,xCenter,yCenter,diameter,thickness)
    /**
     * This function retrieves property data for an Plate shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Plate shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param thickness The thickness of the plate. (L)
     * @param w The width of the Plate. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPlate (name:String,shapeName:String,matProp:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,thickness:DoubleByRef,w:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetPlate",name,shapeName,matProp,color,xCenter,yCenter,thickness,w,rotation)
    /**
     * This function retrieves property data for a reference circle shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circular shape. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRefCircle (name:String,shapeName:String,xCenter:DoubleByRef,yCenter:DoubleByRef,diameter:DoubleByRef):Int=
            callFunctionInt("GetRefCircle",name,shapeName,xCenter,yCenter,diameter)
    /**
     * This function retrieves property data for a reference line shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of a reference line shape in the section designer section.
     * @param x1 The section designer X coordinate of the first drawn end point of the line pattern reinforcing. (L)
     * @param y1 The section designer Y coordinate of the first drawn end point of the line pattern reinforcing. (L)
     * @param x2 The section designer X coordinate of the second drawn end point of the line pattern reinforcing. (L)
     * @param y2 The section designer Y coordinate of the second drawn end point of the line pattern reinforcing. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRefLine (name:String,shapeName:String,x1:DoubleByRef,y1:DoubleByRef,x2:DoubleByRef,y2:DoubleByRef):Int=
            callFunctionInt("GetRefLine",name,shapeName,x1,y1,x2,y2)
    /**
     * This function retrieves property data for a circular reinforcing shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of a circular reinforcing shape in the section designer section.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circular shape. (L)
     * @param numberBars The number of equally spaced bars for the circular reinforcing.
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param rebarSize It is the size of the reinforcing bar.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfCircle (name:String, shapeName:String, xCenter:DoubleByRef, yCenter:DoubleByRef, diameter:DoubleByRef, numberBars:IntByRef, rotation:DoubleByRef, rebarSize:StringByRef, matRebar:StringByRef):Int=
            callFunctionInt("GetReinfCircle",name,shapeName,xCenter,yCenter,diameter,numberBars,rotation,rebarSize,matRebar)
    /**
     * This function retrieves corner point reinforcing data for solid rectangle, circle and polygon shapes in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid rectangle shape in the specified frame section property.
     * @param numberItems The number of edges in the shape.
     * @param pointNum This is an array that includes the corner point number in the shape.
     * @param rebarSize This is an array that includes None or the name of a defined rebar, indicating the rebar assignment to the considered corner point.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfCorner (name:String,shapeName:String,numberItems:IntByRef,pointNum:IntArrayByRef,rebarSize:StringArrayByRef):Int=
            callFunctionInt("GetReinfCorner",name,shapeName,numberItems,pointNum,rebarSize)
    /**
     * This function retrieves edge reinforcing data for solid rectangle, circle, polygon, and rectangular reinforcing shapes in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid rectangle shape in the specified frame section property.
     * @param numberItems The number of edges in the shape.
     * @param edgeNum This is an array that includes the edge number in the shape.
     * @param rebarSize This is an array that includes None or the name of a defined rebar, indicating the rebar assignment to the considered edge.
     * @param spacing This is an array that includes the rebar maximum center-to-center along the considered edge. (L)
     * @param cover This is an array that includes the rebar clear cover along the considered edge. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfEdge (name:String,shapeName:String,numberItems:IntByRef,edgeNum:IntArrayByRef,rebarSize:StringArrayByRef,spacing:DoubleArrayByRef,cover:DoubleArrayByRef):Int=
            callFunctionInt("GetReinfEdge",name,shapeName,numberItems,edgeNum,rebarSize,spacing,cover)
    /**
     * This function retrieves property data for a line reinforcing shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of a line reinforcing shape in the section designer section.
     * @param x1 The section designer X coordinate of the first drawn end point of the line reinforcing. (L)
     * @param y1 The section designer Y coordinate of the first drawn end point of the line reinforcing. (L)
     * @param x2 The section designer X coordinate of the second drawn end point of the line reinforcing. (L)
     * @param y2 The section designer Y coordinate of the second drawn end point of the line reinforcing. (L)
     * @param spacing The center-to-center spacing of the bars in the line pattern shape. (L)
     * @param rebarSize The size of the reinforcing bars used in the line reinforcing shape.
     * @param endBars This item is True when there are bars at the end points of the line reinforcing.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfLine (name:String,shapeName:String,x1:DoubleByRef,y1:DoubleByRef,x2:DoubleByRef,y2:DoubleByRef,spacing:DoubleByRef,rebarSize:StringByRef,endBars:BooleanByRef,matRebar:StringByRef):Int=
            callFunctionInt("GetReinfLine",name,shapeName,x1,y1,x2,y2,spacing,rebarSize,endBars,matRebar)
    /**
     * This function retrieves property data for a rectangular reinforcing shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of a rectangular reinforcing shape in the section designer section.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param w The top flange width. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfRectangular (name:String,shapeName:String,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,w:DoubleByRef,rotation:DoubleByRef,matRebar:StringByRef):Int=
            callFunctionInt("GetReinfRectangular",name,shapeName,xCenter,yCenter,h,w,rotation,matRebar)
    /**
     * This function retrieves property data for a single bar reinforcing shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of a single bar reinforcing shape in the section designer section.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rebarSize The size of the reinforcing bar.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getReinfSingle (name:String,shapeName:String,xCenter:DoubleByRef,yCenter:DoubleByRef,rebarSize:StringByRef,matRebar:StringByRef):Int=
            callFunctionInt("GetReinfSingle",name,shapeName,xCenter,yCenter,rebarSize,matRebar)
    /**
     * This function retrieves property data for a solid circle shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid circle shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param sSOverwrite This is a blank string, Default, or the name of a defined stress-strain curve.
     * If this item is a blank string or Default, the shape stress-strain curve is based on the assigned material property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circle.(L)
     * @param reinf This item is True when there is edge and corner reinforcing steel associated with the shape. The MatProp item must refer to a concrete material for this item to be True.
     * @param # Bars This item is visible only if the Reinforcing item is set to True. It is the number of equally spaced bars for the circular reinforcing.
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param barCover This item is visible only if the Reinforcing item is set to True. It is the clear cover for the specified rebar.
     * @param rebarSize This item is visible only if the Reinforcing item is set to True. It is the size of the reinforcing bar.
     * @param matRebar The material property for the edge and corner reinforcing steel associated with the shape. This item applies only when the MatProp item is a concrete material and the Reinf item is True.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolidCircle (name:String,shapeName:String,matProp:StringByRef,sSOverwrite:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,diameter:DoubleByRef,reinf:BooleanByRef,numberBars:IntByRef,rotation:DoubleByRef,barCover:DoubleByRef,rebarSize:StringByRef,matRebar:StringByRef):Int=
            callFunctionInt("GetSolidCircle",name,shapeName,matProp,sSOverwrite,color,xCenter,yCenter,diameter,reinf,numberBars,rotation,barCover,rebarSize,matRebar)
    /**
     * This function retrieves property data for a solid rectangular shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid rectangle shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param sSOverwrite This is a blank string, Default, or the name of a defined stress-strain curve.
     * If this item is a blank string or Default, the shape stress-strain curve is based on the assigned material property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param w The section width. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param reinf This item is True when there is edge and corner reinforcing steel associated with the shape. The MatProp item must refer to a concrete material for this item to be True.
     * @param matRebar The material property for the edge and corner reinforcing steel associated with the shape. This item applies only when the MatProp item is a concrete material and the Reinf item is True.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolidRect (name:String,shapeName:String,matProp:StringByRef,sSOverwrite:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,w:DoubleByRef,rotation:DoubleByRef,reinf:BooleanByRef,matRebar:StringByRef):Int=
            callFunctionInt("GetSolidRect",name,shapeName,matProp,sSOverwrite,color,xCenter,yCenter,h,w,rotation,reinf,matRebar)
    /**
     * This function retrieves property data for a solid sector shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid sector shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param angle The angle between the two radii that define the circular sector. (deg)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param radius The radius of the circle defining the Sector. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolidSector (name:String,shapeName:String,matProp:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,angle:DoubleByRef,rotation:DoubleByRef,radius:DoubleByRef):Int=
            callFunctionInt("GetSolidSector",name,shapeName,matProp,color,xCenter,yCenter,angle,rotation,radius)
    /**
     * This function retrieves property data for a solid segment shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid segment shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param angle The angle between lines drawn from the center of the circle to the end points of the chord tat defines the segment. (deg)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param radius The radius of the circle defining the segment.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSolidSegment (name:String,shapeName:String,matProp:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,angle:DoubleByRef,rotation:DoubleByRef,radius:DoubleByRef):Int=
            callFunctionInt("GetSolidSegment",name,shapeName,matProp,color,xCenter,yCenter,angle,rotation,radius)
    /**
     * This function retrieves property data for a Tee shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Tee shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Tee property that has been imported from a section property file. If it is the name of a defined Tee property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section depth. (L)
     * @param bf The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTee (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,bf:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetTee",name,shapeName,matProp,propName,color,xCenter,yCenter,h,bf,tf,tw,rotation)
    /**
     * This function retrieves property data for a Tube shape in a section designer section.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing Tube shape in the specified frame section property.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Tube property that has been imported from a section property file. If it is the name of a defined Tube property, the section dimensions are taken from that property.
     * @param color The fill color assigned to the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param h The section height. (L)
     * @param w The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTube (name:String,shapeName:String,matProp:StringByRef,propName:StringByRef,color:IntByRef,xCenter:DoubleByRef,yCenter:DoubleByRef,h:DoubleByRef,w:DoubleByRef,tf:DoubleByRef,tw:DoubleByRef,rotation:DoubleByRef):Int=
            callFunctionInt("GetTube",name,shapeName,matProp,propName,color,xCenter,yCenter,h,w,tf,tw,rotation)
    /**
     * This function adds a new Angle shape or modifies an existing shape to be an Angle shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Angle property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined Angle property that has been imported from a section property file, the section dimensions are taken from the specified Angle property.
     * If this item is not blank, and the specified property name is not an Angle that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section depth. (L)
     * @param bf The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setAngle (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,bf:Double=24.0,tf:Double=2.4,tw:Double=2.4):Int=
            callFunctionInt("SetAngle",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,bf,tf,tw)
    /**
     * This function adds a new Channel shape or modifies an existing shape to be a Channel shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Channel property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined Channel property that has been imported from a section property file, the section dimensions are taken from the specified Channel property.
     * If this item is not blank, and the specified property name is not an Channel that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color @param h The section depth. (L)
     * @param bf The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setChannel (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,bf:Double=24.0,tf:Double=2.4,tw:Double=2.4):Int=
            callFunctionInt("SetChannel",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,bf,tf,tw)
    /**
     * This function adds a new Double Angle shape or modifies an existing shape to be an Double Angle shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined DblAngle property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined DblAngle property that has been imported from a section property file, the section dimensions are taken from the specified DblAngle property.
     * If this item is not blank and the specified property name is not an DblAngle that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section depth. (L)
     * @param w The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param dis Separation between the two flanges that are parallel. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setDblAngle (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,w:Double=24.0,tf:Double=2.4,tw:Double=2.4,dis:Double=1.2):Int=
            callFunctionInt("SetDblAngle",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,w,tf,tw,dis)
    /**
     * This function adds a new I-section shape or modifies an existing shape to be an I-section shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined I-section property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined I-section property that has been imported from a section property file, the section dimensions are taken from the specified I-section property.
     * If this item is not blank, and the specified property name is not an I-section that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section depth. (L)
     * @param bf The top flange width. (L)
     * @param tf The top flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param bfb The bottom flange width. (L)
     * @param tfb The bottom flange thickness. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setISection (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,bf:Double=24.0,tf:Double=2.4,tw:Double=2.4,bfb:Double=24.0,tfb:Double=2.4):Int=
            callFunctionInt("SetISection",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,bf,tf,tw,bfb,tfb)
    /**
     * This function adds a new Pipe shape or modifies an existing shape to be a Pipe shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Pipe property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined Pipe property that has been imported from a section property file, the section dimensions are taken from the specified Pipe property.
     * If this item is not blank and the specified property name is not a Pipe that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param diameter The outer diameter of the Pipe. (L)
     * @param thickness The wall thickness of the Pipe. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setPipe (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,color:Int=-1,diameter:Double=24.0,thickness:Double=2.4):Int=
            callFunctionInt("SetPipe",name,shapeName,matProp,propName,xCenter,yCenter,color,diameter,thickness)
    /**
     * This function adds a new Plate shape or modifies an existing shape to be a Plate shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape,n that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param thickness The thickness of the plate. (L)
     * @param w The width of the Plate. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setPlate (name:String,shapeName:StringByRef,matProp:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,thickness:Double=2.4,w:Double=24.0):Int=
            callFunctionInt("SetPlate",name,shapeName,matProp,xCenter,yCenter,rotation,color,thickness,w)
    /**
     * This function adds a new reference circle shape or modifies an existing shape to be a reference circle shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circular shape. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setRefCircle (name:String,shapeName:StringByRef,xCenter:Double,yCenter:Double,diameter:Double):Int=
            callFunctionInt("SetRefCircle",name,shapeName,xCenter,yCenter,diameter)
    /**
     * This function adds a new reference line shape or modifies an existing shape to be a reference line shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param x1 The section designer X coordinate of the first drawn end point of the line pattern reinforcing. (L)
     * @param y1 The section designer Y coordinate of the first drawn end point of the line pattern reinforcing. (L)
     * @param x2 The section designer X coordinate of the second drawn end point of the line pattern reinforcing. (L)
     * @param y2 The section designer Y coordinate of the second drawn end point of the line pattern reinforcing. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setRefLine (name:String,shapeName:StringByRef,x1:Double,y1:Double,x2:Double,y2:Double):Int=
            callFunctionInt("SetRefLine",name,shapeName,x1,y1,x2,y2)
    /**
     * This function adds a new circular reinforcing shape or modifies an existing shape to be an circular reinforcing shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circular shape. (L)
     * @param numberBars The number of equally spaced bars for the circular reinforcing.
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param rebarSize It is the size of the reinforcing bar.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setReinfCircle (name:String,shapeName:StringByRef,xCenter:Double,yCenter:Double,diameter:Double,numberBars:Int,rotation:Double,rebarSize:Double,matRebar:String=""):Int=
            callFunctionInt("SetReinfCircle",name,shapeName,xCenter,yCenter,diameter,numberBars,rotation,rebarSize,matRebar)
    /**
     * This function specifies corner reinforcing in solid rectangle, circle and polygon shapes in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid rectangle, circle or polygon shape in the specified section.
     * @param pointNum An corner point number in the shape. This item is ignored if the All item is True.
     * @param rebarSize This is None or the name of a defined rebar, indicating the rebar assignment to the specified corner.
     * @param all If this item is True, the specified rebar data applies to all corners in the shape.
     * @return zero if the reinforcing is successfully specified; otherwise it returns a nonzero value.
     */
    fun setReinfCorner (name:String,shapeName:StringByRef,pointNum:Int,rebarSize:String,all:Boolean=false):Int=
            callFunctionInt("SetReinfCorner",name,shapeName,pointNum,rebarSize,all)
    /**
     * This function specifies edge reinforcing in solid rectangle, circle, polygon and rectangular reinforcing shapes in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing solid rectangle, circle or polygon shape in the specified section.
     * @param edgeNum An edge number in the shape. This item is ignored if the All item is True.
     * @param rebarSize This is None or the name of a defined rebar, indicating the rebar assignment to the specified edge.
     * @param spacing This is the rebar maximum center-to-center along the specified edge. (L)
     * @param cover This is the rebar clear cover along the specified edge. (L)
     * @param all If this item is True, the specified rebar data applies to all edges in the shape.
     * @return zero if the reinforcing is successfully specified; otherwise it returns a nonzero value.
     */
    fun setReinfEdge (name:String,shapeName:StringByRef,edgeNum:Int,rebarSize:String,spacing:Double,cover:Double,all:Boolean=false):Int=
            callFunctionInt("SetReinfEdge",name,shapeName,edgeNum,rebarSize,spacing,cover,all)
    /**
     * This function adds a new line reinforcing shape or modifies an existing shape to be a line reinforcing shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param x1 The section designer X coordinate of the first drawn end point of the line reinforcing. (L)
     * @param y1 The section designer Y coordinate of the first drawn end point of the line reinforcing. (L)
     * @param x2 The section designer X coordinate of the second drawn end point of the line reinforcing. (L)
     * @param y2 The section designer Y coordinate of the second drawn end point of the line reinforcing. (L)
     * @param spacing The center-to-center spacing of the bars in the line pattern shape. (L)
     * @param rebarSize The size of the reinforcing bars used in the line reinforcing shape.
     * @param endBars This item is True when there are bars at the end points of the line reinforcing.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setReinfLine (name:String,shapeName:StringByRef,x1:Double,y1:Double,x2:Double,y2:Double,spacing:Double=6.0,rebarSize:String="",endBars:Boolean=false,matRebar:String):Int=
            callFunctionInt("SetReinfLine",name,shapeName,x1,y1,x2,y2,spacing,rebarSize,endBars,matRebar)
    /**
     * This function adds a new rectangular reinforcing shape or modifies an existing shape to be a rectangular reinforcing shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param h The section depth. (L)
     * @param w The top flange width. (L)
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setReinfRectangular (name:String,shapeName:StringByRef,xCenter:Double,yCenter:Double,rotation:Double,h:Double,w:Double,matRebar:String=""):Int=
            callFunctionInt("SetReinfRectangular",name,shapeName,xCenter,yCenter,rotation,h,w,matRebar)
    /**
     * This function adds a new single bar reinforcing shape or modifies an existing shape to be a single bar reinforcing shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rebarSize It is the size of the reinforcing bar.
     * @param matRebar The material property for the reinforcing steel.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setReinfSingle (name:String,shapeName:StringByRef,xCenter:Double,yCenter:Double,rebarSize:String="",matRebar:StringByRef=StringByRef("")):Int=
            callFunctionInt("SetReinfSingle",name,shapeName,xCenter,yCenter,rebarSize,matRebar)
    /**
     * This function adds a new solid circle shape or modifies an existing shape to be a solid circle shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param sSOverwrite This is a blank string, Default, or the name of a defined stress-strain curve.
     * If this item is a blank string or Default, the shape stress-strain curve is based on the assigned material property.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param diameter The diameter of the circle.(L)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param reinf This item is True when there is edge and corner reinforcing steel associated with the shape.
     * If the MatProp item is not a concrete material, this item is always assumed to be False.
     * @param # Bars This item is visible only if the Reinforcing item is set to True. It is the number of equally spaced bars for the circular reinforcing.
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param cover Cover This item is visible only if the Reinforcing item is set to True. It is the clear cover for the specified rebar. (L)
     * @param rebarSize This item is visible only if the Reinforcing item is set to True. It is the size of the reinforcing bar.
     * @param matRebar The material property for the edge and corner reinforcing steel associated with the shape. This item applies only when the MatProp item is a concrete material and the Reinf item is True.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setSolidCircle (name:String,shapeName:StringByRef,matProp:String,sSOverwrite:String,xCenter:Double,yCenter:Double,diameter:Double=24.0,color:Int=-1,reinf:Boolean=false,numberBars:Int=8,rotation:Double=22.5,cover:Double=2.0,rebarSize:String="",matRebar:String=""):Int=
            callFunctionInt("SetSolidCircle",name,shapeName,matProp,sSOverwrite,xCenter,yCenter,diameter,color,reinf,numberBars,rotation,cover,rebarSize,matRebar)
    /**
     * This function adds a new solid rectangle shape or modifies an existing shape to be an solid rectangle shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param sSOverwrite This is a blank string, Default, or the name of a defined stress-strain curve.
     * If this item is a blank string or Default, the shape stress-strain curve is based on the assigned material property.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section depth. (L)
     * @param w The section width. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param reinf This item is True when there is edge and corner reinforcing steel associated with the shape.
     * If the MatProp item is not a concrete material, this item is always assumed to be False.
     * @param matRebar The material property for the edge and corner reinforcing steel associated with the shape. This item applies only when the MatProp item is a concrete material and the Reinf item is True.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setSolidRect (name:String,shapeName:StringByRef,matProp:String,sSOverwrite:String,xCenter:Double,yCenter:Double,h:Double,w:Double,rotation:Double,color:Int=-1,reinf:Boolean=false,matRebar:String=""):Int=
            callFunctionInt("SetSolidRect",name,shapeName,matProp,sSOverwrite,xCenter,yCenter,h,w,rotation,color,reinf,matRebar)
    /**
     * This function adds a new solid sector shape or modifies an existing shape to be a solid sector shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param angle The angle between the two radii that define the circular sector. (deg)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param radius The radius of the circle defining the Sector. (L)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setSolidSector (name:String,shapeName:StringByRef,matProp:String,xCenter:Double,yCenter:Double,angle:Double,rotation:Double,radius:Double,color:Int=-1):Int=
            callFunctionInt("SetSolidSector",name,shapeName,matProp,xCenter,yCenter,angle,rotation,radius,color)
    /**
     * This function adds a new solid segment shape or modifies an existing shape to be a solid segment shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param angle The angle between lines drawn from the center of the circle to the end points of the chord tat defines the segment. (deg)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param radius The radius of the circle defining the segment.
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setSolidSegment (name:String,shapeName:StringByRef,matProp:String,xCenter:Double,yCenter:Double,angle:Double,rotation:Double,radius:Double,color:Int=-1):Int=
            callFunctionInt("SetSolidSegment",name,shapeName,matProp,xCenter,yCenter,angle,rotation,radius,color)
    /**
     * This function adds a new Tee shape or modifies an existing shape to be a Tee shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Tee property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined Tee property that has been imported from a section property file, the section dimensions are taken from the specified Tee property.
     * If this item is not blank, and the specified property name is not a Tee that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section depth. (L)
     * @param bf The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setTee (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,bf:Double=24.0,tf:Double=2.4,tw:Double=2.4):Int=
            callFunctionInt("SetTee",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,bf,tf,tw)
    /**
     * This function adds a new Tube shape or modifies an existing shape to be a Tube shape in a section designer property.
     * @param name The name of an existing frame section property that is a section designer section.
     * @param shapeName The name of an existing or new shape in a section designer property. If this is an existing shape, that shape is modified; otherwise, a new shape is added.
     * This item may be input as a blank string, in which case the program will assign a shape name to the shape and return that name in the ShapeName variable.
     * @param matProp The name of the material property for the shape.
     * @param propName This is a blank string or the name of a defined Tube property that has been imported from a section property file.
     * If this item is a blank string, the section dimensions are taken from the values input in this function.
     * If this item is the name of a defined Tube property that has been imported from a section property file, the section dimensions are taken from the specified Tube property.
     * If this item is not blank and the specified property name is not an Tube that was imported from a section property file, an error is returned.
     * @param xCenter The X-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param yCenter The Y-coordinate of the center of the shape in the section designer coordinate system. (L)
     * @param rotation The counter clockwise rotation of the shape from its default orientation. (deg)
     * @param color The fill color assigned to the shape. If Color is specified as -1, the program will automatically assign the default fill color.
     * @param h The section height. (L)
     * @param w The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @return zero if the shape is successfully added or modified; otherwise it returns a nonzero value.
     */
    fun setTube (name:String,shapeName:StringByRef,matProp:String,propName:String,xCenter:Double,yCenter:Double,rotation:Double,color:Int=-1,h:Double=24.0,w:Double=24.0,tf:Double=2.4,tw:Double=2.4):Int=
            callFunctionInt("SetTube",name,shapeName,matProp,propName,xCenter,yCenter,rotation,color,h,w,tf,tw)
}