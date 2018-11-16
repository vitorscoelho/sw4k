package vitorscoelho.sw4k.sap14.definitions.loadcases

import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.StringArrayByRef
import vitorscoelho.sw4k.sap14.enums.LoadType
import vitorscoelho.sw4k.sap14.enums.NLGeomType

class StaticNonLinear(programName: String) : StaticNonLinearV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonLinear"
}

interface StaticNonLinearV14 : SapComponent {
    /**
     * This function initializes a static nonlinear analysis case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int = callFunctionInt("SetCase", name)

    /**
     * This function sets the geometric nonlinearity option for the specified load case.
     * @param name The name of an existing static nonlinear load case.
     * @param nLGeomType This is 0, 1 or 2, indicating the geometric nonlinearity option ([NLGeomType] enumeration) selected for the load case.
     * * 0 = None
     * * 1 = P-delta
     * * 2 = P-delta plus large displacements
     * @return zero if the option is successfully set; otherwise it returns a nonzero value.
     */
    fun setGeometricNonlinearity(name: String, nLGeomType: Int): Int =
            callFunctionInt("SetGeometricNonlinearity", name, nLGeomType)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing static nonlinear load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ indicating the direction of the load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for Accel UX UY and UZ; otherwise unitless
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: StringArrayByRef, loadName: StringArrayByRef, sF: DoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, sF)
}