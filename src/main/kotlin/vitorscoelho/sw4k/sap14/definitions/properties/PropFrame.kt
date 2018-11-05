package vitorscoelho.sw4k.sap14.definitions.properties

import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.sap14.SapComponent
import vitorscoelho.sw4k.sap14.SapModel

class PropFrame internal constructor(sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cPropFrame") {

    /**
     * This function initializes a solid circular frame section property.
     * If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param t3 The section diameter. (L)
     * @param color The display color assigned to the section. If Color is specified:-1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input:Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCircle(name: String, matProp: String, t3: Double, color: Int = -1, notes: String = "", GUID: String = ""): Int =
            callFunction("SetCircle", name, matProp, t3, color, notes, GUID).int


    //fun setNonPrismatic( Name:String,  NumberItems:Int, ByRef StartSec():String, ByRef EndSec():String, ByRef MyLength():Double, ByRef MyType():Int, ByRef EI33():Int, ByRef EI22():Int, Optional  Color:Int = -1, Optional  Notes:String = "", Optional  GUID:String = ""):Int


    /**
     * This function initializes a precast concrete I girder frame section property.
     * If this function is called for an existing frame section property, all items for the section are reset to their default value.
     * @param name The name of an existing or new frame section property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param matProp The name of the material property for the section.
     * @param b This is an array, size=4, containing the horizontal section dimensions. (L)
     *
     * * b[0] = B1 (> 0)
     * * b[1] = B2 (> 0)
     * * b[2] = B3 (> 0)
     * * b[3] = B4 (>= 0)
     *
     * Section dimensions B1 through B4 are defined on the precast concrete I girder definition form.
     * @param d This is an array, size=6, containing the vertical section dimensions. (L)
     *
     * * d[0] = D1 (> 0)
     * * d[1] = D2 (> 0)
     * * d[2] = D3 (>= 0)
     * * d[3] = D4 (>= 0)
     * * d[4] = D5 (>= 0)
     * * d[5] = D6 (> 0)
     *
     * Section dimensions D1 through D6 are defined on the precast concrete I girder definition form.
     * @param color The display color assigned to the section. If Color is specified as -1, the program will automatically assign a color.
     * @param notes The notes, if any, assigned to the section.
     * @param GUID The GUID (global unique identifier), if any, assigned to the section. If this item is input as Default, the program assigns a GUID to the section.
     * @return zero if the section property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPrecastI(name: String, matProp: String, b: DoubleArrayByRef, d: DoubleArrayByRef, color: Int = -1, notes: String = "", GUID: String = ""): Int {
        /*require(b.size==4){"|b| size must be equal to 4. size=${b.size}"}
        require(d.size==6){"|d| size must be equal to 6. size=${d.size}"}
        require(b[0]>0 && b[1]>0 && b)*/
        return callFunction("SetPrecastI", name, matProp, b.safeArray, d.safeArray, color, notes, GUID).int
    }

    /**
     * This function initializes a solid rectangular frame section property.
     * If this function is called for an existing frame section property, all items for the section are reset to their default value.
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
            callFunction("SetRectangle", name, matProp, t3, t2, color, notes, GUID).int
}