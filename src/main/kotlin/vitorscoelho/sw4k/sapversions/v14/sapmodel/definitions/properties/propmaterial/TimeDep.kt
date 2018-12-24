package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.propmaterial

import vitorscoelho.sw4k.comutils.*

interface TimeDepV14 : SapComponent {
    /**
     * This function retrieves the time dependent CEB FIP-90 material property data for concrete materials.
     * @param name The name of an existing concrete material property.
     * @param considerConcreteAge If this item is True, time dependence is considered for concrete compressive strength and stiffness (modulus of elasticity).
     * @param considerConcreteCreep If this item is True, time dependence is considered for concrete creep.
     * @param considerConcreteShrinkage If this item is True, time dependence is considered for concrete shrinkage.
     * @param CEBFIPsCoefficient This is the cement type coefficient. This item applies only when ConsiderConcreteAge = True.
     * @param relativeHumidity This is relative humidity. This item applies only when ConsiderConcreteCreep = True or ConsiderConcreteShrinkage = True.
     * @param notionalSize This is notional size of the member. This item applies only when ConsiderConcreteCreep = True or ConsiderConcreteShrinkage = True.
     * As defined in Equation 2.1-69 of CEB_FIP Model Code 1990 the notional size is equal to two times the cross-sectional area of the member divided by the perimeter of the member in contact with the atmosphere.
     * @param shrinkageCoefficient This is the shrinkage coefficient as defined in Equation 2.1-76 of CEB_FIP Model Code 1990. This item applies only when ConsiderConcreteShrinkage = True.
     * @param shrinkageStartAge This is the shrinkage start age in days as used in Section 2.1.6.4.4 of CEB_FIP Model Code 1990. This item applies only when ConsiderConcreteShrinkage = True.
     * @param useSeries This is either 0 or 1, indicating the creep integration type.
     * * 0 = Full integration
     * * 1 = Dirichlet series
     * This item applies only when ConsiderConcreteCreep = True.
     * @param numberSeriesTerms This is the number of series terms used when integrating based on a Dirichlet series. This item applies only when ConsiderConcreteCreep = True and UseSeries = 1.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not concrete.
     */
    fun getConcreteCEBFIP90(name: String, considerConcreteAge: ABooleanByRef = BooleanByRef.UNNECESSARY, considerConcreteCreep: ABooleanByRef = BooleanByRef.UNNECESSARY, considerConcreteShrinkage: ABooleanByRef = BooleanByRef.UNNECESSARY, CEBFIPsCoefficient: ADoubleByRef = DoubleByRef.UNNECESSARY, relativeHumidity: ADoubleByRef = DoubleByRef.UNNECESSARY, notionalSize: ADoubleByRef = DoubleByRef.UNNECESSARY, shrinkageCoefficient: ADoubleByRef = DoubleByRef.UNNECESSARY, shrinkageStartAge: ADoubleByRef = DoubleByRef.UNNECESSARY, useSeries: AIntByRef = IntByRef.UNNECESSARY, numberSeriesTerms: AIntByRef = IntByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetConcreteCEBFIP90", name, considerConcreteAge, considerConcreteCreep, considerConcreteShrinkage, CEBFIPsCoefficient, relativeHumidity, notionalSize, shrinkageCoefficient, shrinkageStartAge, useSeries, numberSeriesTerms, temp)

    /**
     * This function retrieves the time dependent CEB FIP-90 material property data for tendon materials.
     * @param name The name of an existing tendon material property.
     * @param considerSteelRelaxation If this item is True, time dependence is considered for tendon steel relaxation.
     * @param CEBFIPClass This is either 1 or 2, indicating the CEB FIP-90 class. This item applies only when ConsiderSteelRelaxation = True.
     * @param useSeries This is either 0 or 1, indicating the steel relaxation integration type.
     * * 0 = Full integration
     * * 1 = Dirichlet series
     * This item applies only when ConsiderSteelRelaxation = True.
     * @param numberSeriesTerms This is the number of series terms used when integrating based on a Dirichlet series. This item applies only when ConsiderSteelRelaxation = True and UseSeries = 1.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data is to be retrieved. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. The function returns an error if the specified material is not tendon.
     */
    fun getTendonCEBFIP90(name: String, considerSteelRelaxation: ABooleanByRef = BooleanByRef.UNNECESSARY, CEBFIPClass: AIntByRef = IntByRef.UNNECESSARY, useSeries: AIntByRef = IntByRef.UNNECESSARY, numberSeriesTerms: AIntByRef = IntByRef.UNNECESSARY, temp: Double = 0.0): Int =
            callFunctionInt("GetTendonCEBFIP90", name, considerSteelRelaxation, CEBFIPClass, useSeries, numberSeriesTerms, temp)

    /**
     * This function sets the time dependent CEB FIP-90 material property data for concrete materials.
     * @param name The name of an existing concrete material property.
     * @param considerConcreteAge If this item is True, time dependence is considered for concrete compressive strength and stiffness (modulus of elasticity).
     * @param considerConcreteCreep If this item is True, time dependence is considered for concrete creep.
     * @param considerConcreteShrinkage If this item is True, time dependence is considered for concrete shrinkage.
     * @param CEBFIPsCoefficient This is the cement type coefficient. This item applies only when ConsiderConcreteAge = True.
     * @param relativeHumidity This is relative humidity. This item applies only when ConsiderConcreteCreep = True or ConsiderConcreteShrinkage = True.
     * @param notionalSize This is notional size of the member. This item applies only when ConsiderConcreteCreep = True or ConsiderConcreteShrinkage = True.
     * As defined in Equation 2.1-69 of CEB_FIP Model Code 1990 the notional size is equal to two times the cross-sectional area of the member divided by the perimeter of the member in contact with the atmosphere.
     * @param shrinkageCoefficient This is the shrinkage coefficient as defined in Equation 2.1-76 of CEB_FIP Model Code 1990. This item applies only when ConsiderConcreteShrinkage = True.
     * @param shrinkageStartAge This is the shrinkage start age in days as used in Section 2.1.6.4.4 of CEB_FIP Model Code 1990. This item applies only when ConsiderConcreteShrinkage = True.
     * @param useSeries This is either 0 or 1, indicating the creep integration type.
     * * 0 = Full integration
     * * 1 = Dirichlet series
     * This item applies only when ConsiderConcreteCreep = True.
     * @param numberSeriesTerms This is the number of series terms used when integrating based on a Dirichlet series. This item applies only when ConsiderConcreteCreep = True and UseSeries = 1.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setConcreteCEBFIP90(name: String, considerConcreteAge: Boolean, considerConcreteCreep: Boolean, considerConcreteShrinkage: Boolean, CEBFIPsCoefficient: Double, relativeHumidity: Double, notionalSize: Double, shrinkageCoefficient: Double, shrinkageStartAge: Double, useSeries: Int, numberSeriesTerms: Int, temp: Double = 0.0): Int =
            callFunctionInt("SetConcreteCEBFIP90", name, considerConcreteAge, considerConcreteCreep, considerConcreteShrinkage, CEBFIPsCoefficient, relativeHumidity, notionalSize, shrinkageCoefficient, shrinkageStartAge, useSeries, numberSeriesTerms, temp)

    /**
     * This function sets the time dependent CEB FIP-90 material property data for tendon materials.
     * @param name The name of an existing tendon material property.
     * @param considerSteelRelaxation If this item is True, time dependence is considered for tendon steel relaxation.
     * @param CEBFIPClass This is either 1 or 2, indicating the CEB FIP-90 class. This item applies only when ConsiderSteelRelaxation = True.
     * @param useSeries This is either 0 or 1, indicating the steel relaxation integration type.
     * * 0 = Full integration
     * * 1 = Dirichlet series
     * This item applies only when ConsiderSteelRelaxation = True.
     * @param numberSeriesTerms This is the number of series terms used when integrating based on a Dirichlet series. This item applies only when ConsiderSteelRelaxation = True and UseSeries = 1.
     * @param temp This item applies only if the specified material has properties that are temperature dependent. That is, it applies only if properties are specified for the material at more than one temperature.
     * This item is the temperature at which the specified data applies. The temperature must have been previously defined for the material.
     * @return zero if the data is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setTendonCEBFIP90(name: String, considerSteelRelaxation: Boolean, CEBFIPClass: Int, useSeries: Int, numberSeriesTerms: Int, temp: Double = 0.0): Int =
            callFunctionInt("SetTendonCEBFIP90", name, considerSteelRelaxation, CEBFIPClass, useSeries, numberSeriesTerms, temp)
}