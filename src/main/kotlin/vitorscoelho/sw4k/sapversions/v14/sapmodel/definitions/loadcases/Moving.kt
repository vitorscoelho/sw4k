package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.*

interface MovingV14 : SapComponent {
    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing moving load load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the lanes loaded data for a specified load assignment number in a specified load case.
     * @param name The name of an existing moving load case.
     * @param loadNumber The load assignment number.
     * @param numberItems The number of lanes loaded for the specified load assignment number.
     * @param myName This is an array that includes the name of each lane loaded for the specified load assignment number.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLanesLoaded(name: String, loadNumber: Int, numberItems: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetLanesLoaded", name, loadNumber, numberItems, myName)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing moving load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param myClass This is an array that includes the vehicle class for each load assigned to the load case.
     * @param sF This is an array that includes the scale factor for each load assigned to the load case.
     * @param min This is an array that includes the minimum number of lanes loaded for each load assigned to the load case.
     * @param max This is an array that includes the maximum number of lanes loaded for each load assigned to the load case. This item must be 0, or it must be greater than or equal to Min. If this item is 0, all available lanes are loaded.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: AIntByRef = IntByRef.UNNECESSARY, myClass: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, min: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, max: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetLoads", name, numberLoads, myClass, sF, min, max)

    /**
     * This function retrieves the multilane scale factor data for the specified load case.
     * @param name The name of an existing moving load case.
     * @param numberItems The number of lanes loaded up to which reduction scale factors are provided.
     * @param sF This is an array that includes the reduction scale factor for the number of lanes loaded from 1 up to NumberItems.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMultiLaneSF(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetMultiLaneSF", name, numberItems, sF)

    /**
     * This function initializes a moving load load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case then that case is modified, otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing moving load load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the lanes loaded data for a specified load assignment number in a specified load case.
     * @param name The name of an existing moving load case.
     * @param loadNumber The load assignment number.
     * @param numberItems The number of lanes loaded for the specified load assignment number.
     * @param myName This is an array that includes the name of each lane loaded for the specified load assignment number.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setMultiLaneSF(name: String, loadNumber: Int, numberItems: Int, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetMultiLaneSF", name, loadNumber, numberItems, myName)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing moving load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param myClass This is an array that includes the vehicle class for each load assigned to the load case.
     * @param sF This is an array that includes the scale factor for each load assigned to the load case.
     * @param min This is an array that includes the minimum number of lanes loaded for each load assigned to the load case.
     * @param max This is an array that includes the maximum number of lanes loaded for each load assigned to the load case. This item must be 0, or it must be greater than or equal to Min. If this item is 0, all available lanes are loaded.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, myClass: AStringArrayByRef = StringArrayByRef.UNNECESSARY, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, min: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, max: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetLoads", name, numberLoads, myClass, sF, min, max)

    /**
     * This function sets the multilane scale factor data for the specified load case.
     * @param name The name of an existing moving load case.
     * @param numberItems The number of lanes loaded up to which reduction scale factors are provided (NumberItems >= 1).
     * @param sF This is an array that includes the reduction scale factor for the number of lanes loaded from 1 up to NumberItems.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setMultiLaneSF(name: String, numberItems: Int, sF: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetMultiLaneSF", name, numberItems, sF)
}