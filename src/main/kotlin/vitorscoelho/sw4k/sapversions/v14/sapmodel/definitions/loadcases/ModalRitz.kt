package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*

interface ModalRitzV14 : SapComponent {
    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing modal ritz load case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: StringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing modal ritz load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load, Accel or Link, indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * If the LoadType item is Link, this item is not used.
     * @param ritzMaxCyc This is an array that includes the maximum number of generation cycles to be performed for the specified ritz starting vector. A value of 0 means there is no limit on the number of cycles.
     * @param targetPar This is an array that includes the target dynamic participation ratio.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: IntByRef, loadType: StringArrayByRef, loadName: StringArrayByRef, ritzMaxCyc: IntArrayByRef, targetPar: DoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, ritzMaxCyc, targetPar)

    /**
     * This function retrieves the number of modes requested for the specified load case.
     * @param name The name of an existing modal ritz load case.
     * @param maxModes The maximum number of modes requested.
     * @param minModes The minimum number of modes requested.
     * @return zero if the number of modes is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNumberModes(name: String, maxModes: IntByRef, minModes: IntByRef): Int =
            callFunctionInt("GetNumberModes", name, maxModes, minModes)

    /**
     * This function initializes a modal ritz load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing modal ritz load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing modal ritz load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes Load, Accel or Link, indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is UX, UY, UZ, RX, RY or RZ, indicating the direction of the load.
     * If the LoadType item is Link, this item is not used.
     * @param ritzMaxCyc This is an array that includes the maximum number of generation cycles to be performed for the specified ritz starting vector. A value of 0 means there is no limit on the number of cycles.
     * @param targetPar This is an array that includes the target dynamic participation ratio.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: StringArrayByRef, loadName: StringArrayByRef, ritzMaxCyc: IntArrayByRef, targetPar: DoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, ritzMaxCyc, targetPar)

    /**
     * This function sets the number of modes requested for the specified load case.
     * @param name The name of an existing modal ritz load case.
     * @param maxModes The maximum number of modes requested.
     * @param minModes The minimum number of modes requested.
     * @return zero if the number of modes is successfully set; otherwise it returns a nonzero value.
     */
    fun setNumberModes(name: String, maxModes: Int, minModes: Int): Int =
            callFunctionInt("SetNumberModes", name, maxModes, minModes)
}