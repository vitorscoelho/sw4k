package vitorscoelho.sw4k.sap14.definitions.loadcases

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.enums.FrequencyUnits
import vitorscoelho.sw4k.sap14.enums.HystereticDampingType
import vitorscoelho.sw4k.sap14.enums.LoadType

class SteadyState(programName: String) : SteadyStateV14 {
    override val activeXComponentName: String = "$programName.cCaseSteadyState"
}

interface SteadyStateV14 : SapComponent {
    /**
     * This function retrieves the constant hysteretic damping for all frequencies assigned to the specified load case.
     * @param name The name of an existing steady state load case that has constant damping.
     * @param hysConMassCoeff The mass proportional damping coefficient.
     * @param hysConStiffCoeff The stiffness proportional damping coefficient.
     * @return zero if the damping is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampConstant(name: String, hysConMassCoeff: DoubleByRef, hysConStiffCoeff: DoubleByRef): Int =
            callFunctionInt("GetDampConstant", name, hysConMassCoeff, hysConStiffCoeff)

    /**
     * This function retrieves the interpolated hysteretic damping by frequency assigned to the specified load case.
     * @param name The name of an existing steady state load case that has interpolated damping.
     * @param hysIntFreqUnits This is 1 or 2, indicating the units for the frequency ([FrequencyUnits] enumeration).
     * * 1 = Hz (cyc/s)
     * * 2 = RPM
     * @param hysIntNumFreqs The number of sets of frequency, mass coefficient and stiffness coefficient data.
     * @param hysIntFreq This is an array of frequencies. The frequency is in Hz or RPM, depending on the value of HysIntFreqUnits.
     * @param hysIntMassCoeff This is an array that includes the mass proportional damping coefficient.
     * @param hysIntStiffCoeff This is an array that includes the stiffness proportional damping coefficient.
     * @return zero if the damping is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampInterpolated(name: String, hysIntFreqUnits: IntByRef, hysIntNumFreqs: IntByRef, hysIntFreq: DoubleArrayByRef, hysIntMassCoeff: DoubleArrayByRef, hysIntStiffCoeff: DoubleArrayByRef): Int =
            callFunctionInt("GetDampInterpolated", name, hysIntFreqUnits, hysIntNumFreqs, hysIntFreq, hysIntMassCoeff, hysIntStiffCoeff)

    /**
     * This function retrieves the hysteretic damping type for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param dampType This is 1 or 2, indicating the hysteretic damping type for the load case ([HystereticDampingType] enumeration).
     * * 1 = Constant hysteretic damping for all frequencies
     * * 2 = Interpolated hysteretic damping by frequency
     * @return zero if the type is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDampType(name: String, dampType: IntByRef): Int =
            callFunctionInt("GetDampType", name, dampType)

    /**
     * This function retrieves the frequency data for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param freqFirst The first frequency. (cyc/s)
     * @param freqLast The last frequency. (cyc/s)
     * @param freqNumIncs The number of frequency increments.
     * @param freqAddModal If this item is True then modal frequencies are added.
     * @param freqAddModalDev If this item is True then signed fractional deviations from modal frequencies are added.
     * @param freqAddSpecified If this item is True, specified frequencies are added.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which modal frequencies and modal frequency deviations are based.
     * @param freqNumModalDev The number of signed fractional deviations from modal frequencies that are added. This item applies only when FreqAddModalDev = True.
     * @param freqModalDev This is an array that includes the added signed fractional deviations from modal frequencies. This item applies only when FreqAddModalDev = True.
     * @param freqNumSpecified The number of specified frequencies that are added. This item applies only when FreqAddSpecified = True.
     * @param freqSpecified This is an array that includes the added specified frequencies. This item applies only when FreqAddModalDev = True.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getFreqData(name: String, freqFirst: DoubleByRef, freqLast: DoubleByRef, freqNumIncs: IntByRef, freqAddModal: BooleanByRef, freqAddModalDev: BooleanByRef, freqAddSpecified: BooleanByRef, modalCase: StringByRef, freqNumModalDev: IntByRef, freqModalDev: DoubleArrayByRef, freqNumSpecified: IntByRef, freqSpecified: DoubleArrayByRef): Int =
            callFunctionInt("GetFreqData", name, freqFirst, freqLast, freqNumIncs, freqAddModal, freqAddModalDev, freqAddSpecified, modalCase, freqNumModalDev, freqModalDev, freqNumSpecified, freqSpecified)

    /**
     * This function retrieves the initial condition assumed for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param initialCase This is blank, None, or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getInitialCase(name: String, initialCase: StringByRef): Int =
            callFunctionInt("GetInitialCase", name, initialCase)

    /**
     * This function retrieves the load data for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the steady state function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for U1 U2 and U3; otherwise unitless
     * @param phaseAngle This is an array that includes the phase angle. (deg)
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLoads(name: String, numberLoads: IntByRef, loadType: StringArrayByRef, loadName: StringArrayByRef, func: StringArrayByRef, sF: DoubleArrayByRef, phaseAngle: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("GetLoads", name, numberLoads, loadType, loadName, func, sF, phaseAngle, cSys, ang)

    /**
     * This function initializes a steady state load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case then that case is modified, otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase(name: String): Int =
            callFunctionInt("SetCase", name)

    /**
     * This function sets constant hysteretic damping for all frequencies for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param hysConMassCoeff The mass proportional damping coefficient.
     * @param hysConStiffCoeff The stiffness proportional damping coefficient.
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampConstant(name: String, hysConMassCoeff: Double, hysConStiffCoeff: Double): Int =
            callFunctionInt("SetDampConstant", name, hysConMassCoeff, hysConStiffCoeff)

    /**
     * This function sets interpolated hysteretic damping by frequency for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param hysIntFreqUnits This is either 1 or 2, indicating the units for the frequency ([FrequencyUnits] enumeration).
     * * 1 = Hz (cyc/s)
     * * 2 = RPM
     * @param hysIntNumFreqs The number of sets of frequency, mass coefficient and stiffness coefficient data.
     * @param hysIntFreq This is an array of frequencies. The frequency is either in Hz or RPM depending on the value of HysIntFreqUnits.
     * @param hysIntMassCoeff This is an array that includes the mass proportional damping coefficient.
     * @param hysIntStiffCoeff This is an array that includes the stiffness proportional damping coefficient.
     * @return zero if the damping is successfully set; otherwise it returns a nonzero value.
     */
    fun setDampInterpolated(name: String, hysIntFreqUnits: Int, hysIntNumFreqs: Int, hysIntFreq: DoubleArrayByRef, hysIntMassCoeff: DoubleArrayByRef, hysIntStiffCoeff: DoubleArrayByRef): Int =
            callFunctionInt("SetDampInterpolated", name, hysIntFreqUnits, hysIntNumFreqs, hysIntFreq, hysIntMassCoeff, hysIntStiffCoeff)

    /**
     * This function sets the frequency data for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param freqFirst The first frequency. (cyc/s)
     * @param freqLast The last frequency. (cyc/s)
     * @param freqNumIncs The number of frequency increments.
     * @param freqAddModal If this item is True, modal frequencies are added.
     * @param freqAddModalDev If this item is True, signed fractional deviations from modal frequencies are added.
     * @param freqAddSpecified If this item is True, specified frequencies are added.
     * @param modalCase This is the name of an existing modal load case. It specifies the modal load case on which modal frequencies and modal frequency deviations are based.
     * @param freqNumModalDev The number of signed fractional deviations from modal frequencies that are added. This item applies only when FreqAddModalDev = True.
     * @param freqModalDev This is an array that includes the added signed fractional deviations from modal frequencies. This item applies only when FreqAddModalDev = True.
     * @param freqNumSpecified The number of specified frequencies that are added. This item applies only when FreqAddSpecified = True.
     * @param freqSpecified This is an array that includes the added specified frequencies. This item applies only when FreqAddModalDev = True.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setFreqData(name: String, freqFirst: Double, freqLast: Double, freqNumIncs: Int, freqAddModal: Boolean, freqAddModalDev: Boolean, freqAddSpecified: Boolean, modalCase: String, freqNumModalDev: Int, freqModalDev: DoubleArrayByRef, freqNumSpecified: Int, freqSpecified: DoubleArrayByRef): Int =
            callFunctionInt("SetFreqData", name, freqFirst, freqLast, freqNumIncs, freqAddModal, freqAddModalDev, freqAddSpecified, modalCase, freqNumModalDev, freqModalDev, freqNumSpecified, freqSpecified)

    /**
     * This function sets the initial condition for the specified load case.
     * @param name The name of an existing steady state load case.
     * @param initialCase This is blank, None or the name of an existing analysis case. This item specifies if the load case starts from zero initial conditions, that is, an unstressed state, or if it starts using the stiffness that occurs at the end of a nonlinear static or nonlinear direct integration time history load case.
     * If the specified initial case is a nonlinear static or nonlinear direct integration time history load case, the stiffness at the end of that case is used. If the initial case is anything else, zero initial conditions are assumed.
     * @return zero if the initial condition is successfully set; otherwise it returns a nonzero value.
     */
    fun setInitialCase(name: String, initialCase: String): Int =
            callFunctionInt("SetInitialCase", name, initialCase)

    /**
     * This function sets the load data for the specified analysis case.
     * @param name The name of an existing steady state load case.
     * @param numberLoads The number of loads assigned to the specified analysis case.
     * @param loadType This is an array that includes either Load or Accel ([LoadType] enumeration), indicating the type of each load assigned to the load case.
     * @param loadName This is an array that includes the name of each load assigned to the load case.
     * If the LoadType item is Load, this item is the name of a defined load pattern.
     * If the LoadType item is Accel, this item is U1, U2, U3, R1, R2 or R3, indicating the direction of the load.
     * @param func This is an array that includes the name of the steady state function associated with each load.
     * @param sF This is an array that includes the scale factor of each load assigned to the load case. (L/s2) for U1 U2 and U3; otherwise unitless
     * @param phaseAngle This is an array that includes the phase angle. (deg)
     * @param cSys This is an array that includes the name of the coordinate system associated with each load. If this item is a blank string, the Global coordinate system is assumed.
     * This item applies only when the LoadType item is Accel.
     * @param ang This is an array that includes the angle between the acceleration local 1 axis and the +X-axis of the coordinate system specified by the CSys item. The rotation is about the Z-axis of the specified coordinate system. (deg)
     * This item applies only when the LoadType item is Accel.
     * @return zero if the data is successfully set; otherwise it returns a nonzero value.
     */
    fun setLoads(name: String, numberLoads: Int, loadType: StringArrayByRef, loadName: StringArrayByRef, func: StringArrayByRef, sF: DoubleArrayByRef, phaseAngle: DoubleArrayByRef, cSys: StringArrayByRef, ang: DoubleArrayByRef): Int =
            callFunctionInt("SetLoads", name, numberLoads, loadType, loadName, func, sF, phaseAngle, cSys, ang)
}