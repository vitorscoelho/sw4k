package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap.enums.LengthType
import vitorscoelho.sw4k.sap.enums.VariationSegmentType
import vitorscoelho.sw4k.sap.enums.FramePropType
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propframe.SDShapeV14

interface PropFrameV14 : SapComponent {
    val sdShape: SDShapeV14

    /**
     * This function changes the name of an existing frame section property.
     * @param name The existing name of a defined frame section property.
     * @param newName The new name for the frame section property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined frame section properties in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * @param propType This value is one of the following items in the [FramePropType] enumeration.
     * * SECTION_I = 1
     * * SECTION_CHANNEL = 2
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_DBLANGLE = 5
     * * SECTION_BOX = 6
     * * SECTION_PIPE = 7
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * * SECTION_GENERAL = 10
     * * SECTION_DBCHANNEL = 11
     * * SECTION_AUTO = 12
     * * SECTION_SD = 13
     * * SECTION_VARIABLE = 14
     * * SECTION_JOIST = 15
     * * SECTION_BRIDGE = 16
     * * SECTION_COLD_C = 17
     * * SECTION_COLD_2C = 18
     * * SECTION_COLD_Z = 19
     * * SECTION_COLD_L = 20
     * * SECTION_COLD_2L = 21
     * * SECTION_COLD_HAT = 22
     * * SECTION_BUILTUP_I_COVERPLATE = 23
     * * SECTION_PCC_GIRDER_I = 24
     * * SECTION_PCC_GIRDER_U = 25
     * @return the total number of defined frame section properties of a specified type in the model.
     */
    fun count(propType: Int): Int =
            callFunctionInt("Count", propType)

    /**
     * The function deletes a specified frame section property.
     * @param name The name of an existing frame section property.
     * @return zero if the frame section property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified frame section property can not be deleted; for example, if it is being used by a frame object.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves frame section property data for an angle-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file; this is the name of that file. If the section property was not imported; this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The vertical leg depth. (L)
     * @param t2 The horizontal leg width. (L)
     * @param tf The horizontal leg thickness. (L)
     * @param tw The vertical leg thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAngle(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetAngle", name, fileName, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a aluminum auto select lists.
     * @param name The name of an existing auto select section list-type frame section property.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * @param autoStartSection This is Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAutoSelectAluminum(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: StringByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetAutoSelectAluminum", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function retrieves frame section property data for a cold formed auto select lists.
     * @param name The name of an existing auto select section list-type frame section property.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * @param autoStartSection This is Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAutoSelectColdFormed(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: StringByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetAutoSelectColdFormed", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function retrieves frame section property data for a steel auto select lists.
     * @param name The name of an existing auto select section list�type frame section property.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * @param autoStartSection This is either Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAutoSelectSteel(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: StringByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetAutoSelectSteel", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function retrieves frame section property data for a channel-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getChannel(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetChannel", name, fileName, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a circular frame section.
     * @param name The name of an existing circular frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section diameter. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCircle(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetCircle", name, fileName, matProp, t3, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a cold formed C-type frame section.
     * @param name The name of an existing cold formed C-type frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getColdC(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, thickness: DoubleByRef, radius: DoubleByRef, lipDepth: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetColdC", name, fileName, matProp, t3, t2, thickness, radius, lipDepth, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a cold formed hat-type frame section.
     * @param name The name of an existing cold formed hat-type frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getColdHat(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, thickness: DoubleByRef, radius: DoubleByRef, lipDepth: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetColdHat", name, fileName, matProp, t3, t2, thickness, radius, lipDepth, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a cold formed Z-type frame section.
     * @param name The name of an existing cold formed Z-type frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param lipAngle The lip angle measured from horizontal (0 <= LipAngle <= 90). (deg)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getColdZ(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, thickness: DoubleByRef, radius: DoubleByRef, lipDepth: DoubleByRef, lipAngle: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetColdZ", name, fileName, matProp, t3, t2, thickness, radius, lipDepth, lipAngle, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a tube-type frame section.
     * @param name The name of an existing frame section property.
     * @param sectName The name of an existing I-type frame section property that is used for the I-section portion of the coverplated I section.
     * @param fyTopFlange The yield strength of the top flange of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param fyWeb The yield strength of the web of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param fyBotFlange The yield strength of the bottom flange of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param tc The thickness of the top cover plate. (L)
     * If the tc or the bc item is less than or equal to 0, no top cover plate exists.
     * @param bc The width of the top cover plate. (L)
     * If the tc or the bc item is less than or equal to 0, no top cover plate exists.
     * @param matPropTop The name of the material property for the top cover plate.
     * This item applies only if both the tc and the bc items are greater than 0.
     * @param tcb The thickness of the bottom cover plate. (L)
     * If the tcb or the bcb item is less than or equal to 0, no bottom cover plate exists.
     * @param bcb The width of the bottom cover plate. (L)
     * If the tcb or the bcb item is less than or equal to 0, no bottom cover plate exists.
     * @param matPropBot The name of the material property for the bottom cover plate.
     * This item applies only if both the tcb and the bcb items are greater than 0.
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getCoverPlatedI(name: String, sectName: StringByRef, fyTopFlange: DoubleByRef, fyWeb: DoubleByRef, fyBotFlange: DoubleByRef, tc: DoubleByRef, bc: DoubleByRef, matPropTop: StringByRef, tcb: DoubleByRef, bcb: DoubleByRef, matPropBot: StringByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetCoverPlatedI", name, sectName, fyTopFlange, fyWeb, fyBotFlange, tc, bc, matPropTop, tcb, bcb, matPropBot, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a double angle-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The vertical leg depth. (L)
     * @param t2 The total width of the section, that is, the sum of the widths of each horizontal leg plus the back-to-back distance. (L)
     * @param tf The horizontal leg thickness. (L)
     * @param tw The vertical leg thickness. (L)
     * @param dis The back-to-back distance between the angles. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDblAngle(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, dis: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetDblAngle", name, fileName, matProp, t3, t2, tf, tw, dis, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a double channel-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The total width of the section, that is, the sum of the widths of each flange plus the back-to-back distance. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param dis The back-to-back distance between the channels. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDblChannel(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, dis: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetDblChannel", name, fileName, matProp, t3, t2, tf, tw, dis, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a general frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param area The cross-sectional area. (L2)
     * @param as2 The shear area for forces in the section local 2-axis direction. (L2)
     * @param as3 The shear area for forces in the section local 3-axis direction. (L2)
     * @param torsion The torsional constant. (L4)
     * @param i22 The moment of inertia for bending about the local 2 axis. (L4)
     * @param i33 The moment of inertia for bending about the local 3 axis. (L4)
     * @param s22 The section modulus for bending about the local 2 axis. (L3)
     * @param s33 The section modulus for bending about the local 3 axis. (L3)
     * @param z22 The plastic modulus for bending about the local 2 axis. (L3)
     * @param z33 The plastic modulus for bending about the local 3 axis. (L3)
     * @param r22 The radius of gyration about the local 2 axis. (L)
     * @param r33 The radius of gyration about the local 3 axis. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getGeneral(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, area: DoubleByRef, as2: DoubleByRef, as3: DoubleByRef, torsion: DoubleByRef, i22: DoubleByRef, i33: DoubleByRef, s22: DoubleByRef, s33: DoubleByRef, z22: DoubleByRef, z33: DoubleByRef, r22: DoubleByRef, r33: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetGeneral", name, fileName, matProp, t3, t2, area, as2, as3, torsion, i22, i33, s22, s33, z22, z33, r22, r33, color, notes, GUID)

    /**
     * This function retrieves frame section property data for an I-type frame section.
     * @param name The name of an existing I-type frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The top flange width. (L)
     * @param tf The top flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param t2b The bottom flange width. (L)
     * @param tfb The bottom flange thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getISection(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, t2b: DoubleByRef, tfb: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetISection", name, fileName, matProp, t3, t2, tf, tw, t2b, tfb, color, notes, GUID)

    /**
     * This function retrieves the modifier assignments for a frame section property. The default value for all modifiers is one.
     * @param name The name of an existing frame section property.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @return zero if the modifier assignments are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("GetModifiers", name, value)

    /**
     * This function retrieves the names of the section property file from which an imported frame section originated, and it also retrieves the section name used in the property file.
     * @param name The name of an existing frame section property.
     * @param nameInFile The name of the specified frame section property in the frame section property file.
     * @param fileName The name of the frame section property file from which the specified frame section property was obtained.
     * @param matProp The name of the material property for the section.
     * @param propType This is one of the following items in the [FramePropType] enumeration.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero. If the specified frame section property was not imported, blank strings are returned for NameInFile and FileName.
     */
    fun getNameInPropFile(name: String, nameInFile: StringByRef, fileName: StringByRef, matProp: StringByRef, propType: IntByRef): Int =
            callFunctionInt("GetNameInPropFile", name, nameInFile, fileName, matProp, propType)

    /**
     * This function retrieves the names of all defined frame section properties of the specified type.
     * @param numberNames The number of frame section property names retrieved by the program.
     * @param myName This is a one-dimensional array of frame section property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of all defined frame section properties of the specified type.
     * @param numberNames The number of frame section property names retrieved by the program.
     * @param myName This is a one-dimensional array of frame section property names.
     * @param propType This value is one of the following items in the [FramePropType] enumeration.
     * * SECTION_I = 1
     * * SECTION_CHANNEL = 2
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_DBLANGLE = 5
     * * SECTION_BOX = 6
     * * SECTION_PIPE = 7
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * * SECTION_GENERAL = 10
     * * SECTION_DBCHANNEL = 11
     * * SECTION_AUTO = 12
     * * SECTION_SD = 13
     * * SECTION_VARIABLE = 14
     * * SECTION_JOIST = 15
     * * SECTION_BRIDGE = 16
     * * SECTION_COLD_C = 17
     * * SECTION_COLD_2C = 18
     * * SECTION_COLD_Z = 19
     * * SECTION_COLD_L = 20
     * * SECTION_COLD_2L = 21
     * * SECTION_COLD_HAT = 22
     * * SECTION_BUILTUP_I_COVERPLATE = 23
     * * SECTION_PCC_GIRDER_I = 24
     * * SECTION_PCC_GIRDER_U = 25
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: IntByRef, myName: StringArrayByRef, propType: Int): Int =
            callFunctionInt("GetNameList", numberNames, myName, propType)

    /**
     * This function retrieves frame section property data for nonprismatic (variable) sections.
     * @param numberItems The number of segments assigned to the nonprismatic section.
     * @param startSec This is an array of the names of the frame section properties at the start of each segment.
     * @param endSec This is an array of the names of the frame section properties at the end of each segment.
     * @param myLength This is an array that includes the length of each segment. The length may be variable or absolute as indicated by the MyType item. (L) when length is absolute
     * @param myType This is an array of either 1 or 2, indicating the length type for each segment ([LengthType] enumeration).
     * * 1 = Variable (relative length)
     * * 2 = Absolute
     * @param eI33, eI22 This is an array of either 1, 2 or 3 ([VariationSegmentType] enumeration), indicating the variation type for EI33 and EI22 in each segment.
     * * 1 = Linear
     * * 2 = Parabolic
     * * 3 = Cubic
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNonPrismatic(name: String, numberItems: IntByRef, startSec: StringArrayByRef, endSec: StringArrayByRef, myLength: DoubleArrayByRef, myType: IntArrayByRef, eI33: IntArrayByRef, eI22: IntArrayByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetNonPrismatic", name, numberItems, startSec, endSec, myLength, myType, eI33, eI22, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a pipe-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The outside diameter. (L)
     * @param tw The wall thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPipe(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, tw: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetPipe", name, fileName, matProp, t3, tw, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a precast concrete I girder frame section.
     * @param name The name of an existing precast concrete I girder frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 4, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * Section dimensions B1 through B4 are defined on the precast concrete I girder definition form.
     * @param d This is an array, dimensioned to 6, containing the vertical section dimensions. (L)
     * * d(0) = D1 (> 0)
     * * d(1) = D2 (> 0)
     * * d(2) = D3 (>= 0)
     * * d(3) = D4 (>= 0)
     * * d(4) = D5 (>= 0)
     * * d(5) = D6 (> 0)
     * Section dimensions D1 through D6 are defined on the precast concrete I girder definition form.
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPrecastI(name: String, fileName: StringByRef, matProp: StringByRef, b: DoubleArrayByRef, d: DoubleArrayByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetPrecastI", name, fileName, matProp, b, d, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a precast concrete U girder frame section.
     * @param name The name of an existing precast concrete U girder frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 6, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * * b(4) = B5 (>= 0)
     * * b(5) = B6 (>= 0)
     * Section dimensions B1 through B6 are defined on the precast concrete U girder definition form.
     * @param d This is an array, dimensioned to 7, containing the vertical section dimensions. (L)
     * * d(0) = D1 (> 0)
     * * d(1) = D2 (> 0)
     * * d(2) = D3 (>= 0)
     * * d(3) = D4 (>= 0)
     * * d(4) = D5 (>= 0)
     * * d(5) = D6 (>= 0)
     * * d(6) = D7 (>= 0)
     * Section dimensions D1 through D7 are defined on the precast concrete U girder definition form.
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPrecastU(name: String, fileName: StringByRef, matProp: StringByRef, b: DoubleArrayByRef, d: DoubleArrayByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetPrecastU", name, fileName, matProp, b, d, color, notes, GUID)

    /**
     * This function retrieves the names of all defined frame section properties of a specified type in a specified frame section property file.
     * @param fileName The name of the frame section property file from which to get the name list.
     * In most cases, inputting only the name of the property file (e.g. Sections8.pro) is required, and the program will be able to find it. In some cases, inputting the full path to the property file may be necessary.
     * @param numberNames The number of frame section property names retrieved by the program.
     * @param myName This is an array the includes the property names obtained from the frame section property file.
     * @param myPropType This is an array the includes the property type for each property obtained from the frame section property file. See the PropType item below for a list of the possible property types.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPropFileNameList(fileName: String, numberNames: IntByRef, myName: StringArrayByRef, myPropType: IntArrayByRef): Int =
            callFunctionInt("GetPropFileNameList", fileName, numberNames, myName, myPropType)

    /**
     * This function retrieves the names of all defined frame section properties of a specified type in a specified frame section property file.
     * @param fileName The name of the frame section property file from which to get the name list.
     * In most cases, inputting only the name of the property file (e.g. Sections8.pro) is required, and the program will be able to find it. In some cases, inputting the full path to the property file may be necessary.
     * @param numberNames The number of frame section property names retrieved by the program.
     * @param myName This is an array the includes the property names obtained from the frame section property file.
     * @param myPropType This is an array the includes the property type for each property obtained from the frame section property file. See the PropType item below for a list of the possible property types.
     * @param propType This value is one of the following items in the [FramePropType] enumeration.
     * * SECTION_I = 1
     * * SECTION_CHANNEL = 2
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_DBLANGLE = 5
     * * SECTION_BOX = 6
     * * SECTION_PIPE = 7
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * * SECTION_GENERAL = 10
     * * SECTION_DBCHANNEL = 11
     * * SECTION_AUTO = 12
     * * SECTION_SD = 13
     * * SECTION_VARIABLE = 14
     * * SECTION_JOIST = 15
     * * SECTION_BRIDGE = 16
     * * SECTION_COLD_C = 17
     * * SECTION_COLD_2C = 18
     * * SECTION_COLD_Z = 19
     * * SECTION_COLD_L = 20
     * * SECTION_COLD_2L = 21
     * * SECTION_COLD_HAT = 22
     * * SECTION_BUILTUP_I_COVERPLATE = 23
     * * SECTION_PCC_GIRDER_I = 24
     * * SECTION_PCC_GIRDER_U = 25
     * If no value is input for PropType, names are returned for all frame section properties in the specified file regardless of type.
     * @return zero if the names are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPropFileNameList(fileName: String, numberNames: IntByRef, myName: StringArrayByRef, myPropType: IntArrayByRef, propType: Int): Int =
            callFunctionInt("GetPropFileNameList", fileName, numberNames, myName, myPropType, propType)

    /**
     * This function retrieves beam rebar data for frame sections.
     * @param name The name of an existing frame section property.
     * @param matPropLong The name of the rebar material property for the longitudinal rebar.
     * @param matPropConfine The name of the rebar material property for the confinement rebar.
     * @param coverTop The distance from the top of the beam to the centroid of the top longitudinal reinforcement. (L)
     * @param coverBot The distance from the bottom of the beam to the centroid of the bottom longitudinal reinforcement. (L)
     * @param topLeftArea The total area of longitudinal reinforcement at the top left end of the beam. (L2)
     * @param topRightArea The total area of longitudinal reinforcement at the top right end of the beam. (L2)
     * @param botLeftArea The total area of longitudinal reinforcement at the bottom left end of the beam. (L2)
     * @param botRightArea The total area of longitudinal reinforcement at the bottom right end of the beam. (L2)
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     * This function applies only to the following section types. Calling this function for any other type of frame section property returns an error.
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * The material assigned to the specified frame section property must be concrete or this function returns an error.
     */
    fun getRebarBeam(name: String, matPropLong: StringByRef, matPropConfine: StringByRef, coverTop: DoubleByRef, coverBot: DoubleByRef, topLeftArea: DoubleByRef, topRightArea: DoubleByRef, botLeftArea: DoubleByRef, botRightArea: DoubleByRef): Int =
            callFunctionInt("GetRebarBeam", name, matPropLong, matPropConfine, coverTop, coverBot, topLeftArea, topRightArea, botLeftArea, botRightArea)

    /**
     * This function retrieves column rebar data for frame sections.
     * @param name The name of an existing frame section property.
     * @param matPropLong The name of the rebar material property for the longitudinal rebar.
     * @param matPropConfine The name of the rebar material property for the confinement rebar.
     * @param pattern This is either 1 or 2, indicating the rebar configuration.
     * * 1 = Rectangular
     * * 2 = Circular
     * For circular frame section properties, this item must be 2; otherwise an error is returned.
     * @param confineType This is either 1 or 2, indicating the confinement bar type.
     * * 1 = Ties
     * * 2 = Spiral
     * This item applies only when Pattern = 2. If Pattern = 1, the confinement bar type is assumed to be ties.
     * @param cover The clear cover for the confinement steel (ties). In the special case of circular reinforcement in a rectangular column, this is the minimum clear cover. (L)
     * @param numberCBars This item applies to a circular rebar configuration, Pattern = 2. It is the total number of longitudinal reinforcing bars in the column.
     * @param numberR3Bars This item applies to a rectangular rebar configuration, Pattern = 1. It is the number of longitudinal bars (including the corner bar) on each face of the column that is parallel to the local 3-axis of the column.
     * @param numberR2Bars This item applies to a rectangular rebar configuration, Pattern = 1. It is the number of longitudinal bars (including the corner bar) on each face of the column that is parallel to the local 2-axis of the column.
     * @param rebarSize The rebar name for the longitudinal rebar in the column.
     * @param tieSize The rebar name for the confinement rebar in the column.
     * @param tieSpacingLongit The longitudinal spacing of the confinement bars (ties). (L)
     * @param number2DirTieBars This item applies to a rectangular reinforcing configuration, Pattern = 1. It is the number of confinement bars (tie legs) extending in the local 2-axis direction of the column.
     * @param number3DirTieBars This item applies to a rectangular reinforcing configuration, Pattern = 1. It is the number of confinement bars (tie legs) extending in the local 3-axis direction of the column.
     * @param toBeDesigned If this item is True, the column longitudinal rebar is to be designed; otherwise it is to be checked.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     * This function applies only to the following section types. Calling this function for any other type of frame section property returns an error.
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * The material assigned to the specified frame section property must be concrete or else this function returns an error.
     */
    fun getRebarColumn(name: String, matPropLong: StringByRef, matPropConfine: StringByRef, pattern: IntByRef, confineType: IntByRef, cover: DoubleByRef, numberCBars: IntByRef, numberR3Bars: IntByRef, numberR2Bars: IntByRef, rebarSize: StringByRef, tieSize: StringByRef, tieSpacingLongit: DoubleByRef, number2DirTieBars: IntByRef, number3DirTieBars: IntByRef, toBeDesigned: BooleanByRef): Int =
            callFunctionInt("GetRebarColumn", name, matPropLong, matPropConfine, pattern, confineType, cover, numberCBars, numberR3Bars, numberR2Bars, rebarSize, tieSize, tieSpacingLongit, number2DirTieBars, number3DirTieBars, toBeDesigned)

    /**
     * This function retrieves frame section property data for a rectangular frame section.
     * @param name The name of an existing rectangular frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRectangle(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetRectangle", name, fileName, matProp, t3, t2, color, notes, GUID)

    /**
     * This function retrieves section property data for a section designer section.
     * @param name The name of an existing section designer property.
     * @param matProp The name of the base material property for the section.
     * @param numberItems The number of shapes defined in the section designer section.
     * @param shapeName This is an array that includes the name of each shape in the section designer section.
     * @param myType This is an array that includes the type of each shape in the section designer section.
     * * 1 = I-section
     * * 2 = Channel
     * * 3 = Tee
     * * 4 = Angle
     * * 5 = Double Angle
     * * 6 = Box
     * * 7 = Pipe
     * * 8 = Plate
     * * 101 = Solid Rectangle
     * * 102 = Solid Circle
     * * 103 = Solid Segment
     * * 104 = Solid Sector
     * * 201 = Polygon
     * * 301 = Reinforcing Single
     * * 302 = Reinforcing Line
     * * 303 = Reinforcing Rectangle
     * * 304 = Reinforcing Circle
     * * 401 = Reference Line
     * * 402 = Reference Circle
     * * 501 = Caltrans Square
     * * 502 = Caltrans Circle
     * * 503 = Caltrans Hexagon
     * * 504 = Caltrans Octagon
     * @param designType This is 0, 1, 2 or 3, indicating the design option for the section.
     * * 0 = No design
     * * 1 = Design as general steel section
     * * 2 = Design as a concrete column; check the reinforcing
     * * 3 = Design as a concrete column; design the reinforcing
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSDSection(name: String, matProp: StringByRef, numberItems: IntByRef, shapeName: StringArrayByRef, myType: IntArrayByRef, designType: IntByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetSDSection", name, matProp, numberItems, shapeName, myType, designType, color, notes, GUID)

    /**
     * This function retrieves properties for frame section.
     * @param name The name of an existing frame section property.
     * @param area The cross-sectional area. (L2)
     * @param as2 The shear area for forces in the section local 2-axis direction. (L2)
     * @param as3 The shear area for forces in the section local 3-axis direction. (L2)
     * @param torsion The torsional constant. (L4)
     * @param i22 The moment of inertia for bending about the local 2 axis. (L4)
     * @param i33 The moment of inertia for bending about the local 3 axis. (L4)
     * @param s22 The section modulus for bending about the local 2 axis. (L3)
     * @param s33 The section modulus for bending about the local 3 axis. (L3)
     * @param z22 The plastic modulus for bending about the local 2 axis. (L3)
     * @param z33 The plastic modulus for bending about the local 3 axis. (L3)
     * @param r22 The radius of gyration about the local 2 axis. (L)
     * @param r33 The radius of gyration about the local 3 axis. (L)
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSectProps(name: String, area: DoubleByRef, as2: DoubleByRef, as3: DoubleByRef, torsion: DoubleByRef, i22: DoubleByRef, i33: DoubleByRef, s22: DoubleByRef, s33: DoubleByRef, z22: DoubleByRef, z33: DoubleByRef, r22: DoubleByRef, r33: DoubleByRef): Int =
            callFunctionInt("GetSectProps", name, area, as2, as3, torsion, i22, i33, s22, s33, z22, z33, r22, r33)

    /**
     * This function retrieves frame section property data for a tee-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTee(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetTee", name, fileName, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function retrieves frame section property data for a tube-type frame section.
     * @param name The name of an existing frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section.
     * @return zero if the section property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTube(name: String, fileName: StringByRef, matProp: StringByRef, t3: DoubleByRef, t2: DoubleByRef, tf: DoubleByRef, tw: DoubleByRef, color: IntByRef, notes: StringByRef, GUID: StringByRef): Int =
            callFunctionInt("GetTube", name, fileName, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function retrieves the rebar design type for the specified frame section property.
     * This function applies only to the following section property types. Calling this function for any other type of frame section property returns an error.
     * @param name The name of an existing frame section property.
     * @param propType This is 0, 1 or 2, indicating the rebar design type.
     * * 0 = None
     * * 1 = Column
     * * 2 = Beam
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getTypeRebar(name: String, propType: IntByRef): Int =
            callFunctionInt("GetTypeRebar", name, propType)

    /**
     * This function retrieves the property type for the specified frame section property.
     * @param name The name of an existing frame section property.
     * @param propType This is one of the following items in the [FramePropType] enumeration.
     * * SECTION_I = 1
     * * SECTION_CHANNEL = 2
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_DBLANGLE = 5
     * * SECTION_BOX = 6
     * * SECTION_PIPE = 7
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * * SECTION_GENERAL = 10
     * * SECTION_DBCHANNEL = 11
     * * SECTION_AUTO = 12
     * * SECTION_SD = 13
     * * SECTION_VARIABLE = 14
     * * SECTION_JOIST = 15
     * * SECTION_BRIDGE = 16
     * * SECTION_COLD_C = 17
     * * SECTION_COLD_2C = 18
     * * SECTION_COLD_Z = 19
     * * SECTION_COLD_L = 20
     * * SECTION_COLD_2L = 21
     * * SECTION_COLD_HAT = 22
     * * SECTION_BUILTUP_I_COVERPLATE = 23
     * * SECTION_PCC_GIRDER_I = 24
     * * SECTION_PCC_GIRDER_U = 25
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType(name: String, propType: IntByRef): Int =
            callFunctionInt("GetType", name, propType)

    /**
     * This function imports a frame section property from a property file.
     * If the property file is not found, or the specified property name is not found in the property file, the section is set to be a general section with default properties.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added. This name does not need to be the same as the PropName item.
     * @param matProp The name of the material property for the section.
     * @param fileName The name of the frame section property file from which to get the frame section property specified by the PropName item.
     * In most cases you can input just the name of the property file (e.g. Sections8.pro) and the program will be able to find it. In some cases you may have to input the full path to the property file.
     * @param propName The name of the frame section property, inside the property file specified by the FileName item, that is to be imported.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun importProp(name: String, matProp: String, fileName: String, propName: String, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("ImportProp", name, matProp, fileName, propName, color, notes, GUID)

    /**
     * This function initializes an angle-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The vertical leg depth. (L)
     * @param t2 The horizontal leg width. (L)
     * @param tf The horizontal leg thickness. (L)
     * @param tw The vertical leg thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, then the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setAngle(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetAngle", name, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function assigns frame section properties to an auto select list. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * Auto select lists and nonprismatic (variable) sections are not allowed in this array.
     * @param autoStartSection This is Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the auto select list is successfully filled; otherwise it returns a nonzero value.
     */
    fun setAutoSelectAluminum(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: String = "Median", notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetAutoSelectAluminum", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function assigns frame section properties to an auto select list. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * Auto select lists and nonprismatic (variable) sections are not allowed in this array.
     * @param autoStartSection This is Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the auto select list is successfully filled; otherwise it returns a nonzero value.
     */
    fun setAutoSelectColdFormed(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: String = "Median", notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetAutoSelectColdFormed", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function assigns frame section properties to an auto select list. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param numberItems The number of frame section properties included in the auto select list.
     * @param sectName This is an array of the names of the frame section properties included in the auto select list.
     * Auto select lists and nonprismatic (variable) sections are not allowed in this array.
     * @param autoStartSection This is either Median or the name of a frame section property in the SectName array. It is the starting section for the auto select list.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the auto select list is successfully filled; otherwise it returns a nonzero value.
     */
    fun setAutoSelectSteel(name: String, numberItems: Int, sectName: StringArrayByRef, autoStartSection: String = "Median", notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetAutoSelectSteel", name, numberItems, sectName, autoStartSection, notes, GUID)

    /**
     * This function initializes a channel-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setChannel(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetChannel", name, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function initializes a solid circular frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section diameter. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCircle(name: String, matProp: String, t3: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetCircle", name, matProp, t3, color, notes, GUID)

    /**
     * This function initializes an cold formed C-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setColdC(name: String, matProp: String, t3: Double, t2: Double, thickness: Double, radius: Double, lipDepth: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetColdC", name, matProp, t3, t2, thickness, radius, lipDepth, color, notes, GUID)

    /**
     * This function initializes an cold formed hat-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, then the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setColdHat(name: String, matProp: String, t3: Double, t2: Double, thickness: Double, radius: Double, lipDepth: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetColdHat", name, matProp, t3, t2, thickness, radius, lipDepth, color, notes, GUID)

    /**
     * This function initializes an cold formed Z-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property then that property is modified, otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param thickness The section thickness. (L)
     * @param radius The corner radius, if any. (L)
     * @param lipDepth The lip depth, if any. (L)
     * @param lipAngle The lip angle measured from horizontal (0 <= LipAngle <= 90). (deg)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setColdZ(name: String, matProp: String, t3: Double, t2: Double, thickness: Double, radius: Double, lipDepth: Double, lipAngle: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetColdZ", name, matProp, t3, t2, thickness, radius, lipDepth, lipAngle, color, notes, GUID)

    /**
     * This function initializes a cover plated I-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param sectName The name of an existing I-type frame section property that is used for the I-section portion of the coverplated I section.
     * @param fyTopFlange The yield strength of the top flange of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param fyWeb The yield strength of the web of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param fyBotFlange The yield strength of the bottom flange of the I-section. (F/L2)
     * If this item is 0, the yield strength of the I-section specified by the SectName item is used.
     * @param tc The thickness of the top cover plate. (L)
     * If the tc or the bc item is less than or equal to 0, no top cover plate exists.
     * @param bc The width of the top cover plate. (L)
     * If the tc or the bc item is less than or equal to 0, no top cover plate exists.
     * @param matPropTop The name of the material property for the top cover plate.
     * This item applies only if both the tc and the bc items are greater than 0.
     * @param tcb The thickness of the bottom cover plate. (L)
     * If the tcb or the bcb item is less than or equal to 0, no bottom cover plate exists.
     * @param bcb The width of the bottom cover plate. (L)
     * If the tcb or the bcb item is less than or equal to 0, no bottom cover plate exists.
     * @param matPropBot The name of the material property for the bottom cover plate.
     * This item applies only if both the tcb and the bcb items are greater than 0.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCoverPlatedI(name: String, sectName: String, fyTopFlange: Double, fyWeb: Double, fyBotFlange: Double, tc: Double, bc: Double, matPropTop: String, tcb: Double, bcb: Double, matPropBot: String, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetCoverPlatedI", name, sectName, fyTopFlange, fyWeb, fyBotFlange, tc, bc, matPropTop, tcb, bcb, matPropBot, color, notes, GUID)

    /**
     * This function initializes a double angle-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The vertical leg depth. (L)
     * @param t2 The total width of the section, that is, the sum of the widths of each horizontal leg plus the back-to-back distance. (L)
     * @param tf The horizontal leg thickness. (L)
     * @param tw The vertical leg thickness. (L)
     * @param dis The back-to-back distance between the angles. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setDblAngle(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, dis: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetDblAngle", name, matProp, t3, t2, tf, tw, dis, color, notes, GUID)

    /**
     * This function initializes a double channel-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The total width of the section, that is, the sum of the widths of each flange plus the back-to-back distance. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param dis The back-to-back distance between the channels. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setDblChannel(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, dis: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetDblChannel", name, matProp, t3, t2, tf, tw, dis, color, notes, GUID)

    /**
     * This function initializes a general frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param area The cross-sectional area. (L2)
     * @param as2 The shear area for forces in the section local 2-axis direction. (L2)
     * @param as3 The shear area for forces in the section local 3-axis direction. (L2)
     * @param torsion The torsional constant. (L4)
     * @param i22 The moment of inertia for bending about the local 2 axis. (L4)
     * @param i33 The moment of inertia for bending about the local 3 axis. (L4)
     * @param s22 The section modulus for bending about the local 2 axis. (L3)
     * @param s33 The section modulus for bending about the local 3 axis. (L3)
     * @param z22 The plastic modulus for bending about the local 2 axis. (L3)
     * @param z33 The plastic modulus for bending about the local 3 axis. (L3)
     * @param r22 The radius of gyration about the local 2 axis. (L)
     * @param r33 The radius of gyration about the local 3 axis. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setGeneral(name: String, matProp: String, t3: Double, t2: Double, area: Double, as2: Double, as3: Double, torsion: Double, i22: Double, i33: Double, s22: Double, s33: Double, z22: Double, z33: Double, r22: Double, r33: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetGeneral", name, matProp, t3, t2, area, as2, as3, torsion, i22, i33, s22, s33, z22, z33, r22, r33, color, notes, GUID)

    /**
     * This function initializes an I-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The top flange width. (L)
     * @param tf The top flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param t2b The bottom flange width. (L)
     * @param tfb The bottom flange thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setISection(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, t2b: Double, tfb: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetISection", name, matProp, t3, t2, tf, tw, t2b, tfb, color, notes, GUID)

    /**
     * This function assigns property modifiers to a frame section property. The default value for all modifiers is one.
     * @param name The name of an existing frame section property.
     * @param value This is an array of eight unitless modifiers.
     * * Value(0) = Cross sectional area modifier
     * * Value(1) = Shear area in local 2 direction modifier
     * * Value(2) = Shear area in local 3 direction modifier
     * * Value(3) = Torsional constant modifier
     * * Value(4) = Moment of inertia about local 2 axis modifier
     * * Value(5) = Moment of inertia about local 3 axis modifier
     * * Value(6) = Mass modifier
     * * Value(7) = Weight modifier
     * @return zero if the modifiers are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setModifiers(name: String, value: DoubleArrayByRef): Int =
            callFunctionInt("SetModifiers", name, value)

    /**
     * This function assigns data to a nonprismatic frame section property.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param numberItems The number of segments assigned to the nonprismatic section.
     * @param startSec This is an array of the names of the frame section properties at the start of each segment.
     * Auto select lists and nonprismatic sections are not allowed in this array.
     * @param endSec This is an array of the names of the frame section properties at the end of each segment.
     * Auto select lists and nonprismatic sections are not allowed in this array.
     * @param myLength This is an array that includes the length of each segment. The length may be variable or absolute as indicated by the MyType item. (L) when length is absolute
     * @param myType This is an array of either 1 or 2, indicating the length type for each segment ([LengthType] enumeration).
     * * 1 = Variable (relative length)
     * * 2 = Absolute
     * @param eI33, EI22 This is an array of 1, 2 or 3 ([VariationSegmentType] enumeration), indicating the variation type for EI33 and EI22 in each segment.
     * * 1 = Linear
     * * 2 = Parabolic
     * * 3 = Cubic
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the data is successfully filled; otherwise it returns a nonzero value.
     */
    fun setNonPrismatic(name: String, numberItems: Int, startSec: StringArrayByRef, endSec: StringArrayByRef, myLength: DoubleArrayByRef, myType: IntArrayByRef, eI33: IntArrayByRef, eI22: IntArrayByRef, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetNonPrismatic", name, numberItems, startSec, endSec, myLength, myType, eI33, eI22, color, notes, GUID)

    /**
     * This function initializes a pipe-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The outside diameter. (L)
     * @param tw The wall thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPipe(name: String, matProp: String, t3: Double, tw: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetPipe", name, matProp, t3, tw, color, notes, GUID)

    /**
     * This function initializes a precast concrete I girder frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 4, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * Section dimensions B1 through B4 are defined on the precast concrete I girder definition form.
     * @param d This is an array, dimensioned to 6, containing the vertical section dimensions. (L)
     * * d(0) = D1 (> 0)
     * * d(1) = D2 (> 0)
     * * d(2) = D3 (>= 0)
     * * d(3) = D4 (>= 0)
     * * d(4) = D5 (>= 0)
     * * d(5) = D6 (> 0)
     * Section dimensions D1 through D6 are defined on the precast concrete I girder definition form.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPrecastI(name: String, matProp: String, b: DoubleArrayByRef, d: DoubleArrayByRef, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetPrecastI", name, matProp, b, d, color, notes, GUID)

    /**
     * This function initializes a precast concrete U girder frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 6, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * * b(4) = B5 (>= 0)
     * * b(5) = B6 (>= 0)
     * Section dimensions B1 through B6 are defined on the precast concrete U girder definition form.
     * @param d This is an array, dimensioned to 7, containing the vertical section dimensions. (L)
     * * d(0) = D1 (> 0)
     * * d(1) = D2 (> 0)
     * * d(2) = D3 (>= 0)
     * * d(3) = D4 (>= 0)
     * * d(4) = D5 (>= 0)
     * * d(5) = D6 (>= 0)
     * * d(6) = D7 (>= 0)
     * Section dimensions D1 through D7 are defined on the precast concrete U girder definition form.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPrecastU(name: String, matProp: String, b: DoubleArrayByRef, d: DoubleArrayByRef, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetPrecastU", name, matProp, b, d, color, notes, GUID)

    /**
     * This function assigns beam rebar data to frame sections.
     * @param name The name of an existing frame section property.
     * @param matPropLong The name of the rebar material property for the longitudinal rebar.
     * @param matPropConfine The name of the rebar material property for the confinement rebar.
     * @param coverTop The distance from the top of the beam to the centroid of the top longitudinal reinforcement. (L)
     * @param coverBot The distance from the bottom of the beam to the centroid of the bottom longitudinal reinforcement. (L)
     * @param topLeftArea The total area of longitudinal reinforcement at the top left end of the beam. (L2)
     * @param topRightArea The total area of longitudinal reinforcement at the top right end of the beam. (L2)
     * @param botLeftArea The total area of longitudinal reinforcement at the bottom left end of the beam. (L2)
     * @param botRightArea The total area of longitudinal reinforcement at the bottom right end of the beam. (L2)
     * @return zero if the rebar data is successfully assigned; otherwise it returns a nonzero value.
     * * This function applies only to the following section types. Calling this function for any other type of frame section property returns an error.
     * * SECTION_T = 3
     * * SECTION_ANGLE = 4
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * The material assigned to the specified frame section property must be concrete or this function returns an error.
     */
    fun setRebarBeam(name: String, matPropLong: String, matPropConfine: String, coverTop: Double, coverBot: Double, topLeftArea: Double, topRightArea: Double, botLeftArea: Double, botRightArea: Double): Int =
            callFunctionInt("SetRebarBeam", name, matPropLong, matPropConfine, coverTop, coverBot, topLeftArea, topRightArea, botLeftArea, botRightArea)

    /**
     * This function assigns column rebar data to frame sections.
     * @param name The name of an existing frame section property.
     * @param matPropLong The name of the rebar material property for the longitudinal rebar.
     * @param matPropConfine The name of the rebar material property for the confinement rebar.
     * @param pattern This is either 1 or 2, indicating the rebar configuration.
     * * 1 = Rectangular
     * * 2 = Circular
     * For circular frame section properties this item must be 2; otherwise an error is returned.
     * @param confineType This is either 1 or 2, indicating the confinement bar type.
     * * 1 = Ties
     * * 2 = Spiral
     * This item applies only when Pattern = 2. If Pattern = 1, the confinement bar type is assumed to be ties.
     * @param cover The clear cover for the confinement steel (ties). In the special case of circular reinforcement in a rectangular column, this is the minimum clear cover. (L)
     * @param numberCBars This item applies to a circular rebar configuration, Pattern = 2. It is the total number of longitudinal reinforcing bars in the column.
     * @param numberR3Bars This item applies to a rectangular rebar configuration, Pattern = 1. It is the number of longitudinal bars (including the corner bar) on each face of the column that is parallel to the local 3-axis of the column.
     * @param numberR2Bars This item applies to a rectangular rebar configuration, Pattern = 1. It is the number of longitudinal bars (including the corner bar) on each face of the column that is parallel to the local 2-axis of the column.
     * @param rebarSize The rebar name for the longitudinal rebar in the column.
     * @param tieSize The rebar name for the confinement rebar in the column.
     * @param tieSpacingLongit The longitudinal spacing of the confinement bars (ties). (L)
     * @param number2DirTieBars This item applies to a rectangular reinforcing configuration, Pattern = 1. It is the number of confinement bars (tie legs) running in the local 2-axis direction of the column.
     * @param number3DirTieBars This item applies to a rectangular reinforcing configuration, Pattern = 1. It is the number of confinement bars (tie legs) running in the local 3-axis direction of the column.
     * @param toBeDesigned If this item is True, the column longitudinal rebar is to be designed; otherwise it is to be checked.
     * @return zero if the rebar data is successfully assigned; otherwise it returns a nonzero value.
     * This function applies only to the following section types. Calling this function for any other type of frame section property returns an error.
     * * SECTION_RECTANGULAR = 8
     * * SECTION_CIRCLE = 9
     * The material assigned to the specified frame section property must be concrete or else this function returns an error.
     */
    fun setRebarColumn(name: String, matPropLong: String, matPropConfine: String, pattern: Int, confineType: Int, cover: Double, numberCBars: Int, numberR3Bars: Int, numberR2Bars: Int, rebarSize: String, tieSize: String, tieSpacingLongit: Double, number2DirTieBars: Int, number3DirTieBars: Int, toBeDesigned: Boolean): Int =
            callFunctionInt("SetRebarColumn", name, matPropLong, matPropConfine, pattern, confineType, cover, numberCBars, numberR3Bars, numberR2Bars, rebarSize, tieSize, tieSpacingLongit, number2DirTieBars, number3DirTieBars, toBeDesigned)

    /**
     * This function initializes a solid rectangular frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setRectangle(name: String, matProp: String, t3: Double, t2: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetRectangle", name, matProp, t3, t2, color, notes, GUID)

    /**
     * This function initializes a section designer property.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the base material property for the section.
     * @param designType This is 0, 1, 2 or 3, indicating the design option for the section.
     * * 0 = No design
     * * 1 = Design as general steel section
     * * 2 = Design as a concrete column; check the reinforcing
     * * 3 = Design as a concrete column; design the reinforcing
     * When DesignType = 1 is assigned, the material property specified by the MatProp item must be a steel material; otherwise the program sets DesignType = 0.
     * Similarly, when DesignType = 2 or DesignType = 3 is assigned, the material property specified by the MatProp item must be a concrete material; otherwise the program sets DesignType = 0.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setSDSection(name: String, matProp: String, designType: Int = 0, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetSDSection", name, matProp, designType, color, notes, GUID)

    /**
     * This function initializes a tee-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The flange width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setTee(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetTee", name, matProp, t3, t2, tf, tw, color, notes, GUID)

    /**
     * This function initializes a tube-type frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section depth. (L)
     * @param t2 The section width. (L)
     * @param tf The flange thickness. (L)
     * @param tw The web thickness. (L)
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setTube(name: String, matProp: String, t3: Double, t2: Double, tf: Double, tw: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetTube", name, matProp, t3, t2, tf, tw, color, notes, GUID)
}