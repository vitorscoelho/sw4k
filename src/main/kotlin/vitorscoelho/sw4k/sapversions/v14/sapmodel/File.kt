package vitorscoelho.sw4k.sapversions.v14.sapmodel

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap.sapmodel.enums.E2DFrameType
import vitorscoelho.sw4k.sap.sapmodel.enums.E3DFrameType

interface FileV14 : SapComponent {
    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @param tempType One of the following 2D frame template types in the [E2DFrameType] enumeration.
     * * PortalFrame = 0
     * * ConcentricBraced = 1
     * * EccentricBraced = 2
     * @param numberStorys The number of stories in the frame.
     * @param storyHeight The height of each story. (L)
     * @param numberBays The number of bays in the frame.
     * @param bayWidth The width of each bay. (L)
     * @param restraint Joint restraints are provided at the base of the frame when this item is True.
     * @param beam The frame section property used for all beams in the frame. This must either be Default or the name of a defined frame section property.
     * @param column The frame section property used for all columns in the frame. This must either be Default or the name of a defined frame section property.
     * @param brace The frame section property used for all braces in the frame. This must either be Default or the name of a defined frame section property. This item does not apply to the portal frame.
     * @return zero if the new 2D frame model is successfully created, otherwise it returns a nonzero value.
     */
    fun new2DFrame(tempType: Int, numberStorys: Int, storyHeight: Double, numberBays: Int, bayWidth: Double, restraint: Boolean = true, beam: String = "Default", column: String = "Default", brace: String = "Default"): Int =
            callFunctionInt("New2DFrame", tempType, numberStorys, storyHeight, numberBays, bayWidth, restraint, beam, column, brace)

    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @param tempType One of the following 3D frame template types in the [E3DFrameType] enumeration.
     * * OpenFrame = 0
     * * PerimeterFrame = 1
     * * BeamSlab = 2
     * * FlatPlate = 3
     * @param numberStorys The number of stories in the frame.
     * @param storyHeight The height of each story. (L)
     * @param numberBaysX The number of bays in the global X direction of the frame.
     * @param bayWidthX The width of each bay in the global X direction of the frame. (L)
     * @param numberBaysY The number of bays in the global Y direction of the frame.
     * @param bayWidthY The width of each bay in the global Y direction of the frame. (L)
     * @param restraint Joint restraints are provided at the base of the frame when this item is True.
     * @param beam The frame section property used for all beams in the frame. This must either be Default or the name of a defined frame section property.
     * @param column The frame section property used for all columns in the frame. This must either be Default or the name of a defined frame section property.
     * @param area The shell section property used for all floor slabs in the frame. This must either be Default or the name of a defined shell section property. This item does not apply to the open and perimeter frames.
     * @param numberXDivisions The number of divisions for each floor area object in the global X direction. This item does not apply to the open and perimeter frames.
     * @param numberYDivisions The number of divisions for each floor area object in the global Y direction. This item does not apply to the open and perimeter frames.
     * @return zero if the new 3D frame model is successfully created, otherwise it returns a nonzero value.
     */
    fun new3DFrame(tempType: Int, numberStorys: Int, storyHeight: Double, numberBaysX: Int, bayWidthX: Double, numberBaysY: Int, bayWidthY: Double, restraint: Boolean = true, beam: String = "Default", column: String = "Default", area: String = "Default", numberXDivisions: Int = 4, numberYDivisions: Int = 4): Int =
            callFunctionInt("New3DFrame", tempType, numberStorys, storyHeight, numberBaysX, bayWidthX, numberBaysY, bayWidthY, restraint, beam, column, area, numberXDivisions, numberYDivisions)

    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @param numberSpans The number of spans for the beam.
     * @param spanLength The length of each span. (L)
     * @param restraint Joint restraints are provided at the ends of each span when this item is True.
     * @param beam The frame section property used for the beam. This must either be Default or the name of a defined frame section property.
     * @return zero if the new beam model is successfully created, otherwise it returns a nonzero value.
     */
    fun newBeam(numberSpans: Int, spanLength: Double, restraint: Boolean = true, beam: String = "Default"): Int =
            callFunctionInt("NewBeam", numberSpans, spanLength, restraint, beam)

    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @return zero if the new blank model is successfully created, otherwise it returns a nonzero value.
     */
    fun newBlank(): Int = callFunctionInt("NewBlank")

    /**
     * @param xWidth The total width of the solid block measured in the global X direction. (L)
     * @param yWidth The total width of the solid block measured in the global Y direction. (L)
     * @param height The total height of the solid block measured in the global Z direction. (L)
     * @param restraint Joint restraints are provided at the base of the solid block when this item is True.
     * @param solid The solid property used for the solid block. This must either be Default or the name of a defined solid property.
     * @param numberXDivisions The number of solid objects in the global X direction of the block.
     * @param numberYDivisions The number of solid objects in the global Y direction of the block.
     * @param numberZDivisions The number of solid objects in the global Z direction of the block.
     * @return zero if the new solid block model is successfully created, otherwise it returns a nonzero value.
     */
    fun newSolidBlock(xWidth: Double, yWidth: Double, height: Double, restraint: Boolean = true, solid: String = "Default", numberXDivisions: Int = 5, numberYDivisions: Int = 8, numberZDivisions: Int = 10): Int =
            callFunctionInt("NewSolidBlock", xWidth, yWidth, height, restraint, solid, numberXDivisions, numberYDivisions, numberZDivisions)

    /**
     * Do not use this function to add to an existing model. This function should be used only for creating a new model and typically would be preceded by calls to ApplicationStart or InitializeNewModel.
     * @param numberXDivisions The number of area objects in the global X direction of the wall.
     * @param divisionWidthX The width of each area object measured in the global X direction. (L)
     * @param numberZDivisions The number of area objects in the global Z direction of the wall.
     * @param divisionWidthZ The height of each area object measured in the global Z direction. (L)
     * @param restraint Joint restraints are provided at the base of the wall when this item is True.
     * @param area The shell section property used for the wall. This must either be Default or the name of a defined shell section property.
     * @return zero if the new wall model is successfully created, otherwise it returns a nonzero value.
     */
    fun newWall(numberXDivisions: Int, divisionWidthX: Double, numberZDivisions: Int, divisionWidthZ: Double, restraint: Boolean = true, area: String = "Default"): Int =
            callFunctionInt("NewWall", numberXDivisions, divisionWidthX, numberZDivisions, divisionWidthZ, restraint, area)

    /**
     * This function opens an existing Sap2000 file. The file name must have an sdb, $2k, s2k, xls, or mdb extension. Files with sdb extensions are opened as standard Sap2000 files. Files with $2k and s2k extensions are imported as text files. Files with xls extensions are imported as Microsoft Excel files. Files with mdb extensions are imported as Microsoft Access files.
     * The function is only applicable when you are accessing the Sap2000 API from an external application. It will return an error if you call it from VBA inside Sap2000.
     * @param fileName The full path of a model file to be opened in the Sap2000 application.
     * @return zero if the file is successfully opened and nonzero if it is not opened.
     */
    fun openFile(fileName: String): Int = callFunctionInt("OpenFile", fileName)

    /**
     * If a file name is specified, it should have an .sdb extension. If no file name is specified, the file is saved using its current name.
     * If there is no current name for the file (the file has not been saved previously) and this function is called with no file name specified, an error will be returned.
     * @param fileName The full path to which the model file is saved.
     * @return zero if the file is successfully saved and nonzero if it is not saved.
     */
    fun save(fileName: String = ""): Int = callFunctionInt("Save", fileName)
}