package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.LoadType

interface BucklingV14 : SapComponent {
    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing buckling load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else then zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: AStringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing buckling load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for Accel UX UY and UZ; otherwise unitless
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: AIntByRef, loadType: AStringArrayByRef, loadName: AStringArrayByRef, sF: ADoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, sF)

    /**
     * This function retrieves various parameters for the specified load case.
     * @param name The name of an existing buckling load case.
     * @param numBucklingModes The number of buckling modes requested.
     * @param eigenTol The relative convergence tolerance for eigenvalues.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getParameters(name: String, numBucklingModes: AIntByRef, eigenTol: ADoubleByRef): Int =
            callFunctionInt("GetParameters", name, numBucklingModes, eigenTol)

    /**
     * This function initializes a buckling load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case then that case is modified, otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing buckling load case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing buckling load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Acce, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * @param SF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for Accel UX UY and UZ; otherwise unitless
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: AStringArrayByRef, loadName: AStringArrayByRef, sF: ADoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, sF)

    /**
     * This function sets various parameters for the specified buckling load case.
     * @param name The name of an existing buckling load case.
     * @param numBucklingModes The number of buckling modes requested.
     * @param eigenTol The relative convergence tolerance for eigenvalues.
     * @return zero if the parameters are successfully set; otherwise it returns a nonzero value.
     */
    fun setParameters(name: String, numBucklingModes: Int, eigenTol: Double): Int =
            callFunctionInt("SetParameters", name, numBucklingModes, eigenTol)
}