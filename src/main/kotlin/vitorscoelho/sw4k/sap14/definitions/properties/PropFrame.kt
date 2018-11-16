package vitorscoelho.sw4k.sap14.definitions.properties

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.LengthType
import vitorscoelho.sw4k.sap14.enums.VariationSegmentType

class PropFrame internal constructor(programName: String) : PropFrameV14 {
    override val activeXComponentName: String = "$programName.cPropFrame"
}

interface PropFrameV14 : SapComponent {
    /**
     * This function retrieves frame section property data for a precast concrete I girder frame section.
     * @param name The name of an existing precast concrete I girder frame section property.
     * @param fileName If the section property was imported from a property file, this is the name of that file. If the section property was not imported, this item is blank.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 3, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * Section dimensions B1 through B4 are defined on the precast concrete I girder definition form.
     * @param d This is an array, dimensioned to 5, containing the vertical section dimensions. (L)
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
     * This function assigns data to a nonprismatic frame section property.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param numberItems The number of segments assigned to the nonprismatic section.
     * @param startSec This is an array of the names of the frame section properties at the start of each segment.
     * Auto select lists and nonprismatic sections are not allowed in this array.
     * @param endSec This is an array of the names of the frame section properties at the end of each segment.
     * Auto select lists and nonprismatic sections are not allowed in this array.
     * @param myLength This is an array that includes the length of each segment. The length may be variable or absolute as indicated by the MyType item. (L) when length is absolute
     * @param myType This is an array of either 1 or 2, indicating the length type ([LengthType] enumeration) for each segment.
     * * 1 = Variable (relative length)
     * * 2 = Absolute
     * @param eI33 This is an array of 1, 2 or 3 ([VariationSegmentType] enumeration), indicating the variation type for EI33 in each segment.
     * * 1 = Linear
     * * 2 = Parabolic
     * * 3 = Cubic
     * @param eI22 This is an array of 1, 2 or 3 ([VariationSegmentType] enumeration), indicating the variation type for EI22 in each segment.
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
     * This function initializes a precast concrete I girder frame section property. If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, dimensioned to 3, containing the horizontal section dimensions. (L)
     * * b(0) = B1 (> 0)
     * * b(1) = B2 (> 0)
     * * b(2) = B3 (> 0)
     * * b(3) = B4 (>= 0)
     * Section dimensions B1 through B4 are defined on the precast concrete I girder definition form.
     * @param d This is an array, dimensioned to 5, containing the vertical section dimensions. (L)
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
}