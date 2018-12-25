package vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.loadpatterns

import vitorscoelho.sw4k.comutils.ABooleanByRef
import vitorscoelho.sw4k.comutils.ADoubleByRef
import vitorscoelho.sw4k.comutils.AIntByRef
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns.*

interface AutoSeismicV15 : AutoSeismicV14 {
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getChinese2002(name: String, dirFlag: AIntByRef, eccen: ADoubleByRef, periodFlag: AIntByRef, userT: ADoubleByRef, userZ: ABooleanByRef, topZ: ADoubleByRef, bottomZ: ADoubleByRef, JGJ32002AlphaMax: ADoubleByRef, JGJ32002SI: AIntByRef, JGJ32002DampRatio: ADoubleByRef, JGJ32002Tg: ADoubleByRef, JGJ32002PTDF: ADoubleByRef, enhancementFactor: ADoubleByRef): Int {
        return super.getChinese2002(name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, JGJ32002AlphaMax, JGJ32002SI, JGJ32002DampRatio, JGJ32002Tg, JGJ32002PTDF, enhancementFactor)
    }

    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun setChinese2002(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, JGJ32002AlphaMax: Double, JGJ32002SI: Int, JGJ32002DampRatio: Double, JGJ32002Tg: Double, JGJ32002PTDF: Double, enhancementFactor: Double): Int {
        return super.setChinese2002(name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, JGJ32002AlphaMax, JGJ32002SI, JGJ32002DampRatio, JGJ32002Tg, JGJ32002PTDF, enhancementFactor)
    }

    /**
     * This function assigns auto seismic loading parameters for the Eurocode 8 2004 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * 1 = Global X
     * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * 1 = Approximate
     * 2 = Program calculated
     * 3 = User defined
     * @param CT The code-specified Ct factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3.(s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * 10 = Portugal
     * @param eURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * 1 = Type 1
     * 2 = Type 2
     * @param eURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type.
     * 1 = A
     * 2 = B
     * 3 = C
     * 4 = D
     * 5 = E
     * @param eURO2004ag The design ground acceleration in g, ag.
     * @param eURO2004S The soil factor, S. If the EURO2004Country item is not 0, the input value for this item is ignored.
     * @param eURO2004Tb The lower limit of period of the constant spectral acceleration branch, Tb. If the EURO2004Country item is not 0, the input value for this item is ignored.
     * @param eURO2004Tc The upper limit of period of the constant spectral acceleration branch, Tc. If the EURO2004Country item is not 0, the input value for this item is ignored.
     * @param eURO2004Td The period defining the start of the constant displacement range, Td. If the EURO2004Country item is not 0, the input value for this item is ignored.
     * @param eURO2004Beta The lower bound factor, Beta. If the EURO2004Country item is not 0, the input value for this item is ignored.
     * @param eURO2004q The behavior factor, q.
     * @param eURO2004Lambda The correction factor, Lambda.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    override fun setEurocode82004_1(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, eURO2004Country: Int, eURO2004SpectrumType: Int, eURO2004GroundType: Int, eURO2004ag: Double, eURO2004S: Double, eURO2004Tb: Double, eURO2004Tc: Double, eURO2004Td: Double, eURO2004Beta: Double, eURO2004q: Double, eURO2004Lambda: Double): Int {
        return super.setEurocode82004_1(name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, eURO2004Country, eURO2004SpectrumType, eURO2004GroundType, eURO2004ag, eURO2004S, eURO2004Tb, eURO2004Tc, eURO2004Td, eURO2004Beta, eURO2004q, eURO2004Lambda)
    }

    /**
     * This function retrieves auto seismic loading parameters for the Eurocode 8 2004 code.
     * @param name The name of an existing Quake-type load pattern with a Eurocode 8 2004 auto seismic load assignment.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * 1 = Global X
     * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * 1 = Approximate
     * 2 = Program calculated
     * 3 = User defined
     * @param CT The code-specified Ct factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * 10 = Portugal
     * @param eURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * 1 = Type 1
     * 2 = Type 2
     * @param eURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type.
     * 1 = A
     * 2 = B
     * 3 = C
     * 4 = D
     * 5 = E
     * @param eURO2004ag The design ground acceleration in g, ag.
     * @param eURO2004S The soil factor, S.
     * @param eURO2004Tb The lower limit of period of the constant spectral acceleration branch, Tb.
     * @param eURO2004Tc The upper limit of period of the constant spectral acceleration branch, Tc.
     * @param eURO2004Td The period defining the start of the constant displacement range, Td.
     * @param eURO2004Beta The lower bound factor, Beta.
     * @param eURO2004q The behavior factor, q.
     * @param eURO2004Lambda The correction factor, Lambda.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    override fun getEurocode82004_1(name: String, dirFlag: AIntByRef, eccen: ADoubleByRef, periodFlag: AIntByRef, CT: ADoubleByRef, userT: ADoubleByRef, userZ: ABooleanByRef, topZ: ADoubleByRef, bottomZ: ADoubleByRef, eURO2004Country: AIntByRef, eURO2004SpectrumType: AIntByRef, eURO2004GroundType: AIntByRef, eURO2004ag: ADoubleByRef, eURO2004S: ADoubleByRef, eURO2004Tb: ADoubleByRef, eURO2004Tc: ADoubleByRef, eURO2004Td: ADoubleByRef, eURO2004Beta: ADoubleByRef, eURO2004q: ADoubleByRef, eURO2004Lambda: ADoubleByRef): Int {
        return super.getEurocode82004_1(name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, eURO2004Country, eURO2004SpectrumType, eURO2004GroundType, eURO2004ag, eURO2004S, eURO2004Tb, eURO2004Tc, eURO2004Td, eURO2004Beta, eURO2004q, eURO2004Lambda)
    }
}

interface AutoWindV15 : AutoWindV14{
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getChinese2002_1(name: String, exposureFrom: AIntByRef, dirAngle: ADoubleByRef, buildingWidth: ADoubleByRef, us: ADoubleByRef, uniformTaper: ABooleanByRef, bHoverB0: ADoubleByRef, userZ: ABooleanByRef, topZ: ADoubleByRef, bottomZ: ADoubleByRef, wzero: ADoubleByRef, rt: AIntByRef, phiZOpt: AIntByRef, t1Opt: AIntByRef, userT: ADoubleByRef, dampRatio: ADoubleByRef, userExposure: ABooleanByRef): Int {
        return super.getChinese2002_1(name, exposureFrom, dirAngle, buildingWidth, us, uniformTaper, bHoverB0, userZ, topZ, bottomZ, wzero, rt, phiZOpt, t1Opt, userT, dampRatio, userExposure)
    }

    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun setChinese2002_1(name: String, exposureFrom: Int, dirAngle: Double, buildingWidth: Double, us: Double, uniformTaper: Boolean, bHoverB0: Double, userZ: Boolean, topZ: Double, bottomZ: Double, wzero: Double, rt: Int, phiZOpt: Int, t1Opt: Int, userT: Double, dampRatio: Double, userExposure: Boolean): Int {
        return super.setChinese2002_1(name, exposureFrom, dirAngle, buildingWidth, us, uniformTaper, bHoverB0, userZ, topZ, bottomZ, wzero, rt, phiZOpt, t1Opt, userT, dampRatio, userExposure)
    }
}