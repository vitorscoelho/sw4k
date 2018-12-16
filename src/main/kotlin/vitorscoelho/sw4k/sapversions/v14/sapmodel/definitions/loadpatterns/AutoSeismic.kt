package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadpatterns

import vitorscoelho.sw4k.comutils.*

interface AutoSeismicV14 : SapComponent {
    /**
     * This function retrieves auto seismic loading parameters for the AS 1170 2007 code.
     * @param name The name of an existing Quake-type load pattern with a AS 1170 2007 auto seismic load assignment.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified kt factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param AS2007SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param AS2007kp The probability factor, kp.
     * @param AS2007Z The hazard factor, Z.
     * @param AS2007Sp The structural performance factor, Sp.
     * @param AS2007Mu The structural ductility factor, u.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAS11702007(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007SiteClass: AIntByRef = IntByRef.UNNECESSARY, AS2007kp: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Z: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Sp: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Mu: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetAS11702007", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, AS2007SiteClass, AS2007kp, AS2007Z, AS2007Sp, AS2007Mu)

    /**
     * This function retrieves auto seismic loading parameters for the 1996 BOCA code.
     * @param name The name of an existing Quake-type load pattern with a BOCA96 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param BOCA96Aa The effective peak acceleration coefficient.
     * @param BOCA96Av The effective peak velocity-related coefficient.
     * @param BOCA96S This is 1, 1.2, 1.5 or 2, indicating the site coefficient.
     * @param BOCA96R The response modification factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getBOCA96(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96Aa: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96Av: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96S: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96R: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetBOCA96", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, BOCA96Aa, BOCA96Av, BOCA96S, BOCA96R)

    /**
     * This function retrieves auto seismic loading parameters for the Chinese 2002 code.
     * @param name The name of an existing Quake-type load pattern with a Chinese 2002 auto seismic load assignment.
     * @param dirFlag This is 1, 2 or 3, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * * 3 = Global Z
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is either 2 or 3, indicating the time period option.
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param JGJ32002AlphaMax The maximum influence factor.
     * @param JGJ32002SI This is 1, 2, 3, 4, 5 or 6, indicating the seismic intensity.
     * * 1 = 6 (0.05g)
     * * 2 = 7 (0.10g)
     * * 3 = 7 (0.15g)
     * * 4 = 8 (0.20g)
     * * 5 = 8 (0.30g)
     * * 6 = 9 (0.40g)
     * @param JGJ32002DampRatio The damping ratio.
     * @param JGJ32002Tg The characteristic ground period. (s)
     * @param JGJ32002PTDF The period time discount factor.
     * @param enhancementFactor The enhancement factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getChinese2002(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002AlphaMax: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002SI: AIntByRef = IntByRef.UNNECESSARY, JGJ32002DampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002Tg: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002PTDF: ADoubleByRef = DoubleByRef.UNNECESSARY, enhancementFactor: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetChinese2002", name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, JGJ32002AlphaMax, JGJ32002SI, JGJ32002DampRatio, JGJ32002Tg, JGJ32002PTDF, enhancementFactor)

    /**
     * This function retrieves diaphragm eccentricity overrides for auto seismic loads. This function does not apply for User Load type auto seismic loads.
     * @param name The name of an existing Quake-type load pattern that has an auto seismic load assigned.
     * @param num The number of diaphragm eccentricity overrides for the specified load pattern.
     * @param diaph This is an array that includes the names of the diaphragms which have eccentricity overrides.
     * @param eccen This is an array that includes the eccentricity applied to each diaphragm. (L)
     * @return zero if the overrides are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDiaphragmEccentricityOverride(name: String, num: AIntByRef = IntByRef.UNNECESSARY, diaph: AStringArrayByRef = StringArrayByRef.UNNECESSARY, eccen: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetDiaphragmEccentricityOverride", name, num, diaph, eccen)

    /**
     * This function retrieves auto seismic loading parameters for the Eurocode 8 2004 code.
     * @param name The name of an existing Quake-type load pattern with a Eurocode 8 2004 auto seismic load assignment.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified Ct factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param EURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param EURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * * 1 = Type 1
     * * 2 = Type 2
     * @param EURO2004ag The design ground acceleration in g, ag.
     * @param EURO2004Beta The lower bound factor, Beta.
     * @param EURO2004q The behavior factor, q.
     * @param EURO2004Lambda The correction factor, Lambda.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEurocode82004(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004GroundType: AIntByRef = IntByRef.UNNECESSARY, EURO2004SpectrumType: AIntByRef = IntByRef.UNNECESSARY, EURO2004ag: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004Beta: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004q: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004Lambda: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetEurocode82004", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, EURO2004GroundType, EURO2004SpectrumType, EURO2004ag, EURO2004Beta, EURO2004q, EURO2004Lambda)

    /**
     * This function retrieves auto seismic loading parameters for the 2003 IBC code.
     * @param name The name of an existing Quake-type load pattern with a IBC2003 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor (ft). This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param IBC2003SG This is 1, 2 or 3, indicating the seismic group.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param IBC2003SeismicCoeffFlag This is either 1 or 2, indicating the seismic coefficient option.
     * * 1 = Coefficients are per code
     * * 2 = Coefficients are user defined
     * @param IBC2003Site This is either 1, 2, 3, 4 or 5, indicating the site class. This item is filled only when the IBC2003SeismicCoeffFlag = 1.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param IBC2003SS The response acceleration for short periods, (g).
     * @param IBC2003S1 The response acceleration for a one second period, (g).
     * @param IBC2003Fa The site coefficient Fa.
     * @param IBC2003Fv The site coefficient Fv.
     * @param IBC2003R The response modification factor.
     * @param IBC2003Omega The system overstrength factor.
     * @param IBC2003Cd The deflection amplification factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIBC2003(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003SG: AIntByRef = IntByRef.UNNECESSARY, IBC2003SeismicCoeffFlag: AIntByRef = IntByRef.UNNECESSARY, IBC2003Site: AIntByRef = IntByRef.UNNECESSARY, IBC2003SS: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003S1: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003R: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003Omega: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003Cd: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIBC2003", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, IBC2003SG, IBC2003SeismicCoeffFlag, IBC2003Site, IBC2003SS, IBC2003S1, IBC2003Fa, IBC2003Fv, IBC2003R, IBC2003Omega, IBC2003Cd)

    /**
     * This function retrieves auto seismic loading parameters for the 2006 IBC code.
     * @param name The name of an existing Quake-type load pattern with a IBC2006 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param IBC2006CtType This is 0, 1, 2 or 3, indicating the values of Ct and x. This item is meaningful when the PeriodFlag item is 1 or 2.
     * * 0 = Ct = 0.028 (ft), x = 0.8
     * * 1 = Ct = 0.016 (ft), x = 0.9
     * * 2 = Ct = 0.03 (ft), x = 0.75
     * * 3 = Ct = 0.02 (ft), x = 0.75
     * @param userT The user specified time period. This item is meaningful when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param IBC2006R The response modification factor.
     * @param IBC2006Omega The system overstrength factor.
     * @param IBC2006Cd The deflection amplification factor.
     * @param IBC2006I The occupancy importance factor.
     * @param IBC2006Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param IBC2006Latitude, IBC2006Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are meaningful only when IBC2006Option = 0 or 1.
     * @param IBC2006ZipCode The zip code for which the seismic coefficients are obtained. This item is meaningful only when IBC2006Option = 1.
     * @param IBC2006SS, IBC2006S1 The seismic coefficients Ss and S1.
     * @param IBC2006TL The long-period transition period. (s)
     * @param IBC2006SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param IBC2006Fa, IBC2006Fv The site coefficients Fa and Fv.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIBC2006(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, IBC2006CtType: AIntByRef = IntByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006R: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Omega: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Cd: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006I: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Option: AIntByRef = IntByRef.UNNECESSARY, IBC2006Latitude: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Longitude: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006ZipCode: AStringByRef = StringByRef.UNNECESSARY, IBC2006SS: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006S1: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006TL: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006SiteClass: AIntByRef = IntByRef.UNNECESSARY, IBC2006Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Fv: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIBC2006", name, dirFlag, eccen, periodFlag, IBC2006CtType, userT, userZ, topZ, bottomZ, IBC2006R, IBC2006Omega, IBC2006Cd, IBC2006I, IBC2006Option, IBC2006Latitude, IBC2006Longitude, IBC2006ZipCode, IBC2006SS, IBC2006S1, IBC2006TL, IBC2006SiteClass, IBC2006Fa, IBC2006Fv)

    /**
     * This function retrieves auto seismic loading parameters for the 2002 IS1893 code.
     * @param name The name of an existing Quake-type load pattern with an IS1893_2002 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor (m). This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param INZFlag This is either 1 or 2, indicating if the seismic zone factor is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param INZ The seismic zone factor, Z.
     * If the seismic zone factor is per code (INZFlag = 1), this item should be one of the following: 0.10, 0.16, 0.24, 0.36.
     * @param INS This is 1, 2 or 3, indicating the soil type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param BOCA96R The response modification factor.
     * @param INR The importance factor.
     * @param INR The response modification factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIS1893_2002(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, INZFlag: AIntByRef = IntByRef.UNNECESSARY, INZ: ADoubleByRef = DoubleByRef.UNNECESSARY, INS: AIntByRef = IntByRef.UNNECESSARY, INI: ADoubleByRef = DoubleByRef.UNNECESSARY, INR: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIS1893_2002", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, INZFlag, INZ, INS, INI, INR)

    /**
     * This function retrieves auto seismic loading parameters for the 2005 NBCC code.
     * @param name The name of an existing Quake-type load pattern with a NBCC2005 auto seismic load assignment.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param NBCC2005CtType This is 0, 1, 2, 3 or 4, indicating the structure type.
     * * 0 = Steel moment frame
     * * 1 = Concrete moment frame
     * * 2 = Other moment frame
     * * 3 = Braced frame
     * * 4 = Shear wall
     * @param NBCC95DS This item applies only when the NBCCPFlag = 2. It is the dimension of the lateral load resisting system in the direction of the applied forces. (L)
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Code
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NBCC2005PGA The peak ground acceleration.
     * @param NBCC2005S02 The spectral acceleration at a 0.2 second period.
     * @param NBCC2005S05 The spectral acceleration at a 0.52 second period.
     * @param NBCC2005S1 The spectral acceleration at a 1 second period.
     * @param NBCC2005S2 The spectral acceleration at a 2 second period.
     * @param NBCC2005SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param NBCC2005Fa The site coefficient, Fa.
     * @param NBCC2005Fv The site coefficient, Fv.
     * @param NBCC2005I The importance factor.
     * @param NBCC2005Mv The higher mode factor.
     * @param NBCC2005Rd The ductility modifier.
     * @param NBCC2005Ro The overstrength modifier.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNBCC2005(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005CtType: AIntByRef = IntByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005PGA: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S02: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S05: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S1: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S2: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005SiteClass: AIntByRef = IntByRef.UNNECESSARY, NBCC2005Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005I: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005Mv: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005Rd: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005Ro: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNBCC2005", name, dirFlag, eccen, NBCC2005CtType, periodFlag, userT, userZ, topZ, bottomZ, NBCC2005PGA, NBCC2005S02, NBCC2005S05, NBCC2005S1, NBCC2005S2, NBCC2005SiteClass, NBCC2005Fa, NBCC2005Fv, NBCC2005I, NBCC2005Mv, NBCC2005Rd, NBCC2005Ro)

    /**
     * This function retrieves auto seismic loading parameters for the 1995 NBCC code.
     * @param name The name of an existing Quake-type load pattern with a NBCC95 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param NBCCPFlag This is either 1 or 2, indicating the structure type.
     * * 1 = Moment frame
     * * 2 = Other
     * @param NBCC95DS This item applies only when the NBCCPFlag = 2. It is the dimension of the lateral load resisting system in the direction of the applied forces. (L)
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Code
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NBCC95ZA This is 0, 1, 2, 3, 4, 5 or 6, indicating the acceleration related zone, Za.
     * @param NBCC95ZV This is 0, 1, 2, 3, 4, 5 or 6, indicating the velocity related zone, Zv.
     * @param NBCC95ZVFlag This is either 1 or 2, indicating how the zonal velocity ratio, V, is specified.
     * * 1 = From code based on Zv
     * * 2 = User specified
     * @param NBCC95ZVR The zonal velocity ratio, V.
     * @param NBCC95I The importance factor.
     * @param NBCC95F The foundation factor.
     * @param NBCC95R The force modification factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNBCC95(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCCPFlag: AIntByRef = IntByRef.UNNECESSARY, NBCC95DS: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC95ZA: AIntByRef = IntByRef.UNNECESSARY, NBCC95ZV: AIntByRef = IntByRef.UNNECESSARY, NBCC95ZVFlag: AIntByRef = IntByRef.UNNECESSARY, NBCC95ZVR: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC95I: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC95F: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC95R: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNBCC95", name, dirFlag, eccen, NBCCPFlag, NBCC95DS, periodFlag, userT, userZ, topZ, bottomZ, NBCC95ZA, NBCC95ZV, NBCC95ZVFlag, NBCC95ZVR, NBCC95I, NBCC95F, NBCC95R)

    /**
     * This function retrieves auto seismic loading parameters for the 1997 NEHRP code.
     * @param name The name of an existing Quake-type load pattern with a NEHRP97 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NEHRP97SG This is 1, 2 or 3, indicating the seismic group.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param NEHRP97SeismicCoeffFlag This is 1 or 2, indicating the seismic coefficient option.
     * * 1 = Coefficients are per code
     * * 2 = Coefficients are user defined
     * @param NEHRP97Site This is 1, 2, 3, 4 or 5, indicating the site class. This item is only filled when the NEHRP97SeismicCoeffFlag = 1.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NEHRP97SS The response acceleration for short periods, (g).
     * @param NEHRP97S1 The response acceleration for a one second period, (g).
     * @param NEHRP97Fa The site coefficient Fa.
     * @param NEHRP97Fv The site coefficient Fv.
     * @param NEHRP97R The response modification factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNEHRP97(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97SG: AIntByRef = IntByRef.UNNECESSARY, NEHRP97SeismicCoeffFlag: AIntByRef = IntByRef.UNNECESSARY, NEHRP97Site: AIntByRef = IntByRef.UNNECESSARY, NEHRP97SS: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97S1: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97R: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNEHRP97", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, NEHRP97SG, NEHRP97SeismicCoeffFlag, NEHRP97Site, NEHRP97SS, NEHRP97S1, NEHRP97Fa, NEHRP97Fv, NEHRP97R)

    /**
     * This function retrieves auto seismic loading parameters for the NZS 1170 2004 code.
     * @param name The name of an existing Quake-type load pattern with a NZS 1170 2004 auto seismic load assignment.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NZS2004SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NZS2004Z The hazard factor, Z.
     * @param NZS2004R The return period factor, R.
     * @param NZS2004N The near fault factor, N.
     * @param NZS2004Sp The structural performance factor, Sp.
     * @param NZS2004Mu The structural ductility factor, u.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNZS11702004(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS2004SiteClass: AIntByRef = IntByRef.UNNECESSARY, NZS2004Z: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS2004R: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS2004N: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS2004Sp: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS2004Mu: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNZS11702004", name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, NZS2004SiteClass, NZS2004Z, NZS2004R, NZS2004N, NZS2004Sp, NZS2004Mu)

    /**
     * This function retrieves auto seismic loading parameters for the 1994 UBC code.
     * @param name The name of an existing Quake-type load pattern with a UBC94 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC94ZFlag This is 1 or 2, indicating if the seismic zone factor is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC94Z The seismic zone factor, Z.
     * If the seismic zone factor is per code (UBC94ZFlag = 1), this item should be one of the following: 0.075, 0.15, 0.20, 0.30, 0.40.
     * @param UBC94S This is 1, 1.2, 1.5 or 2, indicating the site coefficient.
     * @param UBC94I The importance factor.
     * @param UBC94RW The numerical coefficient, Rw.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUBC94(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC94ZFlag: AIntByRef = IntByRef.UNNECESSARY, UBC94Z: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC94S: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC94I: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC94RW: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUBC94", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, UBC94ZFlag, UBC94Z, UBC94S, UBC94I, UBC94RW)

    /**
     * This function retrieves auto seismic loading parameters for seismically isolated buildings using the 1997 UBC code.
     * @param name The name of an existing Quake-type load pattern with a UBC97Iso auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC97IsoSeismicCoeffFlag This is either 1 or 2, indicating if the seismic coefficient Cv is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC97IsoSoilProfileType This is 1, 2, 3, 4 or 5, indicating the soil profile type.
     * * 1 = SA
     * * 2 = SB
     * * 3 = SC
     * * 4 = SD
     * * 5 = SE
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated per code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97IsoZ This is 0.075, 0.15, 0.2, 0.3 or 0.4, indicating the seismic zone factor.
     * This item is applicable only when the seismic coefficient Cv is calculated per code (UBC97IsoSeismicCoeffFlag = 1).
     * @param UBC97IsoCv The seismic coefficient, Cv.
     * @param UBC97IsoNearSourceFlag This is either 1 or 2, indicating if the near source factor coefficient Nv is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * This item is applicable only when the seismic coefficient Cv is calculated per code (UBC97IsoSeismicCoeffFlag = 1) and UBC97IsoZ = 0.4.
     * @param UBC97IsoSourceType This is 1, 2 or 3, indicating the seismic source type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * This item is applicable only when the seismic coefficient Cv is calculated per code (UBC97IsoSeismicCoeffFlag = 1), UBC97IsoZ = 0.4, and the near source factor coefficient Nv is calculated per code (UBC97IsoNearSourceFlag = 1).
     * @param UBC97IsoDist This is the distance to the seismic source in kilometers.
     * This item is applicable only when the seismic coefficient Cv is calculated per code (UBC97IsoSeismicCoeffFlag = 1), UBC97IsoZ = 0.4, and the near source factor coefficient Nv is calculated per code (UBC97IsoNearSourceFlag = 1).
     * @param UBC97IsoNv The near source factor coefficient, Nv.
     * This item is applicable only when the seismic coefficient Cv is user defined (UBC97IsoSeismicCoeffFlag = 2).
     * @param UBC97IsoRI The overstrength factor, Ri.
     * @param UBC97IsoBD The coefficient for damping.
     * @param UBC97IsoKDmax The maximum effective stiffness of the isolation system. (F/L)
     * @param UBC97IsoKDmin The minimum effective stiffness of the isolation system. (F/L)
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUBC97Iso(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoSeismicCoeffFlag: AIntByRef = IntByRef.UNNECESSARY, UBC97IsoSoilProfileType: AIntByRef = IntByRef.UNNECESSARY, UBC97IsoZ: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoCv: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoNearSourceFlag: AIntByRef = IntByRef.UNNECESSARY, UBC97IsoSourceType: AIntByRef = IntByRef.UNNECESSARY, UBC97IsoDist: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoNv: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoRI: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoBD: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoKDmax: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97IsoKDmin: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUBC97Iso", name, dirFlag, eccen, userZ, topZ, bottomZ, UBC97IsoSeismicCoeffFlag, UBC97IsoSoilProfileType, UBC97IsoZ, UBC97IsoCv, UBC97IsoNearSourceFlag, UBC97IsoSourceType, UBC97IsoDist, UBC97IsoNv, UBC97IsoRI, UBC97IsoBD, UBC97IsoKDmax, UBC97IsoKDmin)

    /**
     * This function retrieves auto seismic loading parameters for the 1997 UBC code.
     * @param name The name of an existing Quake-type load pattern with a UBC97 auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC97SeismicCoeffFlag This is either 1 or 2, indicating if the seismic coefficients Ca and Cv are per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC97SoilProfileType This is 1, 2, 3, 4 or 5, indicating the soil profile type.
     * * 1 = SA
     * * 2 = SB
     * * 3 = SC
     * * 4 = SD
     * * 5 = SE
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated per code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97Z This is 0.075, 0.15, 0.2, 0.3 or 0.4, indicating the seismic zone factor.
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97Ca The seismic coefficient, Ca.
     * @param UBC97Cv The seismic coefficient, Cv.
     * @param UBC97NearSourceFlag This is 1 or 2, indicating if the near source factor coefficients Na and Nv are per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated per code (UBC97SeismicCoeffFlag = 1) and UBC97Z = 0.4.
     * @param UBC97SourceType This is 1, 2 or 3, indicating the seismic source type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated per code (UBC97SeismicCoeffFlag = 1), UBC97Z = 0.4, and the near source factor coefficients Na and Nv are calculated per code (UBC97NearSourceFlag = 1).
     * @param UBC97Dist This is the distance to the seismic source in kilometers.
     * This item is only applicable when the seismic coefficients Ca and Cv are calculated per code (UBC97SeismicCoeffFlag = 1), UBC97Z = 0.4, and the near source factor coefficients Na and Nv are calculated per code (UBC97NearSourceFlag = 1).
     * @param UBC97Na The near source factor coefficient, Na.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2).
     * @param UBC97Nv The near source factor coefficient, Nv.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2).
     * @param UBC97I The importance factor.
     * @param UBC97R The overstrength factor.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUBC97(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, periodFlag: AIntByRef = IntByRef.UNNECESSARY, CT: ADoubleByRef = DoubleByRef.UNNECESSARY, userT: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97SeismicCoeffFlag: AIntByRef = IntByRef.UNNECESSARY, UBC97SoilProfileType: AIntByRef = IntByRef.UNNECESSARY, UBC97Z: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97Ca: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97Cv: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97NearSourceFlag: AIntByRef = IntByRef.UNNECESSARY, UBC97SourceType: AIntByRef = IntByRef.UNNECESSARY, UBC97Dist: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97Na: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97Nv: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97I: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97R: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUBC97", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, UBC97SeismicCoeffFlag, UBC97SoilProfileType, UBC97Z, UBC97Ca, UBC97Cv, UBC97NearSourceFlag, UBC97SourceType, UBC97Dist, UBC97Na, UBC97Nv, UBC97I, UBC97R)

    /**
     * This function retrieves auto seismic loading parameters for User Coefficient type loading.
     * @param name The name of an existing Quake-type load pattern with a User Coefficient auto seismic load assignment.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param c The base shear coefficient.
     * @param k The building height exponent.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getBOCA96(name: String, dirFlag: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, userZ: ABooleanByRef, topZ: ADoubleByRef = DoubleByRef.UNNECESSARY, bottomZ: ADoubleByRef = DoubleByRef.UNNECESSARY, c: ADoubleByRef = DoubleByRef.UNNECESSARY, k: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetBOCA96", name, dirFlag, eccen, userZ, topZ, bottomZ, c, k)

    /**
     * This function retrieves auto seismic loading parameters for User Load type auto seismic loads.
     * @param name The name of an existing Quake-type load pattern which has been assigned a User Load auto seismic type.
     * @param myType This is either 1 or 2, indicating the application point type for the user load.
     * * 1 = User specified application point
     * * 2 = At center of mass with optional additional eccentricity
     * @param eccen The eccentricity ratio that applies to all diaphragms. This item is only applicable when MyType = 2.
     * @param num The number of diaphragms that can be loaded by the auto seismic load.
     * @param diaph This is an array that includes the names of the diaphragms that can be loaded by the auto seismic load.
     * @param fx This is an array that includes the global X direction force assigned to each diaphragm. (F)
     * @param fy This is an array that includes the global Y direction force assigned to each diaphragm. (F)
     * @param mz This is an array that includes the moment about the global Z axis for each diaphragm. (FL)
     * @param x This is an array that includes the global X-coordinate of the point where the seismic force is applied to each diaphragm. (L)
     * This item is applicable only when MyType = 1.
     * @param y This is an array that includes the global Y-coordinate of the point where the seismic force is applied to each diaphragm. (L)
     * This item is applicable only when MyType = 1.
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUserLoad(name: String, myType: AIntByRef = IntByRef.UNNECESSARY, eccen: ADoubleByRef = DoubleByRef.UNNECESSARY, num: AIntByRef = IntByRef.UNNECESSARY, diaph: AStringArrayByRef = StringArrayByRef.UNNECESSARY, fx: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fy: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, mz: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, x: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, y: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetUserLoad", name, myType, eccen, num, diaph, fx, fy, mz, x, y)

    /**
     * This function assigns auto seismic loading parameters for the AS 1170.4 2007 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified kt factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param AS2007SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param AS2007kp The probability factor, kp.
     * @param AS2007Z The hazard factor, Z.
     * @param AS2007Sp The structural performance factor, Sp.
     * @param AS2007Mu The structural ductility factor, u.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setAS11702007(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, AS2007SiteClass: Int, AS2007kp: Double, AS2007Z: Double, AS2007Sp: Double, AS2007Mu: Double): Int =
            callFunctionInt("SetAS11702007", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, AS2007SiteClass, AS2007kp, AS2007Z, AS2007Sp, AS2007Mu)

    /**
     * This function assigns auto seismic loading parameters for the 1996 BOCA code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param BOCA96Aa The effective peak acceleration coefficient.
     * @param BOCA96Av The effective peak velocity-related coefficient.
     * @param BOCA96S This is 1, 1.2, 1.5 or 2, indicating the site coefficient.
     * @param BOCA96R The response modification factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setBOCA96(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, BOCA96Aa: Double, BOCA96Av: Double, BOCA96S: Double, BOCA96R: Double): Int =
            callFunctionInt("SetBOCA96", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, BOCA96Aa, BOCA96Av, BOCA96S, BOCA96R)

    /**
     * This function assigns auto seismic loading parameters for the Chinese 2002 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1, 2 or 3, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * * 3 = Global Z
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is either 2 or 3, indicating the time period option.
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param JGJ32002AlphaMax The maximum influence factor.
     * @param JGJ32002SI This is 1, 2, 3, 4, 5 or 6, indicating the seismic intensity.
     * * 1 = 6 (0.05g)
     * * 2 = 7 (0.10g)
     * * 3 = 7 (0.15g)
     * * 4 = 8 (0.20g)
     * * 5 = 8 (0.30g)
     * * 6 = 9 (0.40g)
     * @param JGJ32002DampRatio The damping ratio.
     * @param JGJ32002Tg The characteristic ground period. (s)
     * @param JGJ32002PTDF The period time discount factor.
     * @param enhancementFactor The enhancement factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setChinese2002(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, JGJ32002AlphaMax: Double, JGJ32002SI: Int, JGJ32002DampRatio: Double, JGJ32002Tg: Double, JGJ32002PTDF: Double, enhancementFactor: Double): Int =
            callFunctionInt("SetChinese2002", name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, JGJ32002AlphaMax, JGJ32002SI, JGJ32002DampRatio, JGJ32002Tg, JGJ32002PTDF, enhancementFactor)

    /**
     * This function assigns diaphragm eccentricity overrides for auto seismic loads. This function does not apply for User Load type auto seismic loads.
     * @param name The name of an existing Quake-type load pattern that has an auto seismic load assigned.
     * @param diaph The name of an existing special rigid diaphragm constraint, that is, a diaphragm constraint with the following features:
     * * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * * 2. The constraint coordinate system is Global.
     * * 3. The constraint axis is Z.
     * @param eccen The eccentricity applied to the specified diaphragm. (L)
     * @param delete If this item is True, the eccentricity override for the specified diaphragm is deleted.
     * @return zero if the overrides are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setDiaphragmEccentricityOverride(name: String, diaph: String, eccen: Double, delete: Boolean = false): Int =
            callFunctionInt("SetDiaphragmEccentricityOverride", name, diaph, eccen, delete)

    /**
     * This function assigns auto seismic loading parameters for the Eurocode 8 2004 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified Ct factor. This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param EURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param EURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * * 1 = Type 1
     * * 2 = Type 2
     * @param EURO2004ag The design ground acceleration in g, ag.
     * @param EURO2004Beta The lower bound factor, Beta.
     * @param EURO2004q The behavior factor, q.
     * @param EURO2004Lambda The correction factor, Lambda.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setEurocode82004(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, EURO2004GroundType: Int, EURO2004SpectrumType: Int, EURO2004ag: Double, EURO2004Beta: Double, EURO2004q: Double, EURO2004Lambda: Double): Int =
            callFunctionInt("SetEurocode82004", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, EURO2004GroundType, EURO2004SpectrumType, EURO2004ag, EURO2004Beta, EURO2004q, EURO2004Lambda)

    /**
     * This function assigns auto seismic loading parameters for the 2003 IBC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor (ft). This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param IBC2003SG This is 1, 2 or 3, indicating the seismic group.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param IBC2003SeismicCoeffFlag This is either 1 or 2, indicating the seismic coefficient option.
     * * 1 = Coefficients are per code
     * * 2 = Coefficients are user defined
     * @param IBC2003Site This is 1, 2, 3, 4 or 5, indicating the site class. This item is only used when the IBC2003SeismicCoeffFlag = 1.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param IBC2003SS The response acceleration for short periods, (g).
     * @param IBC2003S1 The response acceleration for a one second period, (g).
     * @param IBC2003Fa The site coefficient Fa. This item is used only when the IBC2003SeismicCoeffFlag = 2.
     * @param IBC2003Fv The site coefficient Fv. This item is used only when the IBC2003SeismicCoeffFlag = 2
     * @param IBC2003R The response modification factor.
     * @param IBC2003Omega The system overstrength factor.
     * @param IBC2003Cd The deflection amplification factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setIBC2003(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, IBC2003SG: Int, IBC2003SeismicCoeffFlag: Int, IBC2003Site: Int, IBC2003SS: Double, IBC2003S1: Double, IBC2003Fa: Double, IBC2003Fv: Double, IBC2003R: Double, IBC2003Omega: Double, IBC2003Cd: Double): Int =
            callFunctionInt("SetIBC2003", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, IBC2003SG, IBC2003SeismicCoeffFlag, IBC2003Site, IBC2003SS, IBC2003S1, IBC2003Fa, IBC2003Fv, IBC2003R, IBC2003Omega, IBC2003Cd)

    /**
     * This function assigns auto seismic loading parameters for the 2006 IBC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param IBC2006CtType This is 0, 1, 2 or 3, indicating the values of Ct and x. This item applies when the PeriodFlag item is 1 or 2.
     * * 0 = Ct = 0.028 (ft), x = 0.8
     * * 1 = Ct = 0.016 (ft), x = 0.9
     * * 2 = Ct = 0.03 (ft), x = 0.75
     * * 3 = Ct = 0.02 (ft), x = 0.75
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param IBC2006R The response modification factor.
     * @param IBC2006Omega The system overstrength factor.
     * @param IBC2006Cd The deflection amplification factor.
     * @param IBC2006I The occupancy importance factor.
     * @param IBC2006Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param IBC2006Latitude, IBC2006Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are used only when IBC2006Option = 0.
     * @param IBC2006ZipCode The zip code for which the seismic coefficients are obtained. This item is used only when IBC2006Option = 1.
     * @param IBC2006SS, IBC2006S1 The seismic coefficients Ss and S1. This item is used only when IBC2006Option = 2.
     * @param IBC2006TL The long-period transition period. (s)
     * @param IBC2006SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param IBC2006Fa, IBC2006Fv The site coefficients Fa and Fv. These items are used only when IBC2006SiteClass= 6.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setIBC2006(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, IBC2006CtType: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, IBC2006R: Double, IBC2006Omega: Double, IBC2006Cd: Double, IBC2006I: Double, IBC2006Option: Int, IBC2006Latitude: Double, IBC2006Longitude: Double, IBC2006ZipCode: String, IBC2006SS: Double, IBC2006S1: Double, IBC2006TL: Double, IBC2006SiteClass: Int, IBC2006Fa: Double, IBC2006Fv: Double): Int =
            callFunctionInt("SetIBC2006", name, dirFlag, eccen, periodFlag, IBC2006CtType, userT, userZ, topZ, bottomZ, IBC2006R, IBC2006Omega, IBC2006Cd, IBC2006I, IBC2006Option, IBC2006Latitude, IBC2006Longitude, IBC2006ZipCode, IBC2006SS, IBC2006S1, IBC2006TL, IBC2006SiteClass, IBC2006Fa, IBC2006Fv)

    /**
     * This function assigns auto seismic loading parameters for the 2002 IS1893 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor (m). This item applies when the PeriodFlag item is 1.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param INZFlag This is either 1 or 2, indicating if the seismic zone factor is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param INZ The seismic zone factor, Z.
     * If the seismic zone factor is per code (INZFlag = 1), this item should be one of the following: 0.10, 0.16, 0.24, 0.36.
     * @param INS This is 1, 2 or 3, indicating the soil type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param BOCA96R The response modification factor.
     * @param INR The importance factor.
     * @param INR The response modification factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setIS1893_2002(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, INZFlag: Int, INZ: Double, INS: Int, INI: Double, INR: Double): Int =
            callFunctionInt("SetIS1893_2002", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, INZFlag, INZ, INS, INI, INR)

    /**
     * This function assigns auto seismic loading parameters for the 2005 NBCC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param NBCC2005CtType This is 0, 1, 2, 3 or 4, indicating the structure type.
     * * 0 = Steel moment frame
     * * 1 = Concrete moment frame
     * * 2 = Other moment frame
     * * 3 = Braced frame
     * * 4 = Shear wall
     * @param NBCC95DS This item applies only when the NBCCPFlag = 2. It is the dimension of the lateral load resisting system in the direction of the applied forces. (L)
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Code
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NBCC2005PGA The peak ground acceleration.
     * @param NBCC2005S02 The spectral acceleration at a 0.2 second period.
     * @param NBCC2005S05 The spectral acceleration at a 0.52 second period.
     * @param NBCC2005S1 The spectral acceleration at a 1 second period.
     * @param NBCC2005S2 The spectral acceleration at a 2 second period.
     * @param NBCC2005SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param NBCC2005Fa The site coefficient, Fa. This item is read when the site class is F only.
     * @param NBCC2005Fv The site coefficient, Fv. This item is read when the site class is F only.
     * @param NBCC2005I The importance factor.
     * @param NBCC2005Mv The higher mode factor.
     * @param NBCC2005Rd The ductility modifier.
     * @param NBCC2005Ro The overstrength modifier.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNBCC2005(name: String, dirFlag: Int, eccen: Double, NBCC2005CtType: Int, periodFlag: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, NBCC2005PGA: Double, NBCC2005S02: Double, NBCC2005S05: Double, NBCC2005S1: Double, NBCC2005S2: Double, NBCC2005SiteClass: Int, NBCC2005Fa: Double, NBCC2005Fv: Double, NBCC2005I: Double, NBCC2005Mv: Double, NBCC2005Rd: Double, NBCC2005Ro: Double): Int =
            callFunctionInt("SetNBCC2005", name, dirFlag, eccen, NBCC2005CtType, periodFlag, userT, userZ, topZ, bottomZ, NBCC2005PGA, NBCC2005S02, NBCC2005S05, NBCC2005S1, NBCC2005S2, NBCC2005SiteClass, NBCC2005Fa, NBCC2005Fv, NBCC2005I, NBCC2005Mv, NBCC2005Rd, NBCC2005Ro)

    /**
     * This function assigns auto seismic loading parameters for the 1995 NBCC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param NBCCPFlag This is either 1 or 2, indicating the structure type.
     * * 1 = Moment frame
     * * 2 = Other
     * @param NBCC95DS This item applies only when the NBCCPFlag = 2. It is the dimension of the lateral load resisting system in the direction of the applied forces. (L)
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Code
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NBCC95ZA This is 0, 1, 2, 3, 4, 5 or 6, indicating the acceleration related zone, Za.
     * @param NBCC95ZV This is 0, 1, 2, 3, 4, 5 or 6, indicating the velocity related zone, Zv.
     * @param NBCC95ZVFlag This is either 1 or 2, indicating how the zonal velocity ratio, V, is specified.
     * * 1 = From code based on Zv
     * * 2 = User specified
     * @param NBCC95ZVR The zonal velocity ratio, V. This item is used only when NBCC95ZVFlag = 2.
     * @param NBCC95I The importance factor.
     * @param NBCC95F The foundation factor.
     * @param NBCC95R The force modification factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNBCC95(name: String, dirFlag: Int, eccen: Double, NBCCPFlag: Int, NBCC95DS: Double, periodFlag: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, NBCC95ZA: Int, NBCC95ZV: Int, NBCC95ZVFlag: Int, NBCC95ZVR: Double, NBCC95I: Double, NBCC95F: Double, NBCC95R: Double): Int =
            callFunctionInt("SetNBCC95", name, dirFlag, eccen, NBCCPFlag, NBCC95DS, periodFlag, userT, userZ, topZ, bottomZ, NBCC95ZA, NBCC95ZV, NBCC95ZVFlag, NBCC95ZVR, NBCC95I, NBCC95F, NBCC95R)

    /**
     * This function assigns auto seismic loading parameters for the 1997 NEHRP code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NEHRP97SG This is 1, 2 or 3, indicating the seismic group.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param NEHRP97SeismicCoeffFlag This is either 1 or 2, indicating the seismic coefficient option.
     * * 1 = Coefficients are per code
     * * 2 = Coefficients are user defined
     * @param NEHRP97Site This is 1, 2, 3, 4 or 5, indicating the site class. This item is used only when the NEHRP97SeismicCoeffFlag = 1.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NEHRP97SS The response acceleration for short periods, (g).
     * @param NEHRP97S1 The response acceleration for a one second period, (g).
     * @param NEHRP97Fa The site coefficient Fa. This item is used only when the NEHRP97SeismicCoeffFlag = 2.
     * @param NEHRP97Fv The site coefficient Fv. This item is used only when the NEHRP97SeismicCoeffFlag = 2
     * @param NEHRP97R The response modification factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNEHRP97(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, NEHRP97SG: Int, NEHRP97SeismicCoeffFlag: Int, NEHRP97Site: Int, NEHRP97SS: Double, NEHRP97S1: Double, NEHRP97Fa: Double, NEHRP97Fv: Double, NEHRP97R: Double): Int =
            callFunctionInt("SetNEHRP97", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, NEHRP97SG, NEHRP97SeismicCoeffFlag, NEHRP97Site, NEHRP97SS, NEHRP97S1, NEHRP97Fa, NEHRP97Fv, NEHRP97R)

    /**
     * This function sets the auto seismic loading type for the specified load pattern to None.
     * @param name The name of an existing Quake-type load pattern.
     * @return zero if the loading type is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNone(name: String): Int =
            callFunctionInt("SetNone", name)

    /**
     * This function assigns auto seismic loading parameters for the NZS 1170.5 2004 code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param NZS2004SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NZS2004Z The hazard factor, Z.
     * @param NZS2004R The return period factor, R.
     * @param NZS2004N The near fault factor, N.
     * @param NZS2004Sp The structural performance factor, Sp.
     * @param NZS2004Mu The structural ductility factor, u.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNZS11702004(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, NZS2004SiteClass: Int, NZS2004Z: Double, NZS2004R: Double, NZS2004N: Double, NZS2004Sp: Double, NZS2004Mu: Double): Int =
            callFunctionInt("SetNZS11702004", name, dirFlag, eccen, periodFlag, userT, userZ, topZ, bottomZ, NZS2004SiteClass, NZS2004Z, NZS2004R, NZS2004N, NZS2004Sp, NZS2004Mu)

    /**
     * This function assigns auto seismic loading parameters for the 1994 UBC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC94ZFlag This is either 1 or 2, indicating if the seismic zone factor is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC94Z The seismic zone factor, Z.
     * If the seismic zone factor is per code (UBC94ZFlag = 1), this item should be one of the following: 0.075, 0.15, 0.20, 0.30, 0.40.
     * @param UBC94S This is 1, 1.2, 1.5 or 2, indicating the site coefficient.
     * @param UBC94I The importance factor.
     * @param UBC94RW The numerical coefficient, Rw.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUBC94(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, UBC94ZFlag: Int, UBC94Z: Double, UBC94S: Double, UBC94I: Double, UBC94RW: Double): Int =
            callFunctionInt("SetUBC94", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, UBC94ZFlag, UBC94Z, UBC94S, UBC94I, UBC94RW)

    /**
     * This function assigns auto seismic loading parameters for seismically isolated buildings using the 1997 UBC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC97IsoSeismicCoeffFlag This is either 1 or 2, indicating if the seismic coefficient Cv is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC97IsoSoilProfileType This is 1, 2, 3, 4 or 5, indicating the soil profile type.
     * * 1 = SA
     * * 2 = SB
     * * 3 = SC
     * * 4 = SD
     * * 5 = SE
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97IsoZ This is 0.075, 0.15, 0.2, 0.3 or 0.4, indicating the seismic zone factor.
     * This item is applicable only when the seismic coefficient Cv is calculated in accordance with code (UBC97IsoSeismicCoeffFlag = 1).
     * @param UBC97IsoCv The seismic coefficient, Cv.
     * This item is applicable only when the seismic coefficient Cv is user defined (UBC97IsoSeismicCoeffFlag = 2).
     * @param UBC97IsoNearSourceFlag This is either 1 or 2, indicating if the near source factor coefficient Nv is per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * This item is applicable only when the seismic coefficient Cv is calculated per code (UBC97IsoSeismicCoeffFlag = 1) and UBC97IsoZ = 0.4.
     * @param UBC97IsoSourceType This is 1, 2 or 3, indicating the seismic source type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * This item is applicable only when the seismic coefficient Cv is calculated in accordance with code (UBC97IsoSeismicCoeffFlag = 1), UBC97IsoZ = 0.4, and the near source factor coefficient Nv is calculated in accordance with code (UBC97IsoNearSourceFlag = 1).
     * @param UBC97IsoDist This is the distance to the seismic source in kilometers.
     * This item is only applicable when the seismic coefficient Cv is calculated in accordance with code (UBC97IsoSeismicCoeffFlag = 1), UBC97IsoZ = 0.4, and the near source factor coefficient Nv is calculated in accordance with code (UBC97IsoNearSourceFlag = 1).
     * @param UBC97IsoNv The near source factor coefficient, Nv.
     * This item is applicable only when the seismic coefficient Cv is user defined (UBC97IsoSeismicCoeffFlag = 2) and the near source factor coefficient Nv is user defined (UBC97IsoNearSourceFlag = 2).
     * @param UBC97IsoRI The overstrength factor, Ri.
     * @param UBC97IsoBD The coefficient for damping.
     * @param UBC97IsoKDmax The maximum effective stiffness of the isolation system. (F/L)
     * @param UBC97IsoKDmin The minimum effective stiffness of the isolation system. (F/L)
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUBC97Iso(name: String, dirFlag: Int, eccen: Double, userZ: Boolean, topZ: Double, bottomZ: Double, UBC97IsoSeismicCoeffFlag: Int, UBC97IsoSoilProfileType: Int, UBC97IsoZ: Double, UBC97IsoCv: Double, UBC97IsoNearSourceFlag: Int, UBC97IsoSourceType: Int, UBC97IsoDist: Double, UBC97IsoNv: Double, UBC97IsoRI: Double, UBC97IsoBD: Double, UBC97IsoKDmax: Double, UBC97IsoKDmin: Double): Int =
            callFunctionInt("SetUBC97Iso", name, dirFlag, eccen, userZ, topZ, bottomZ, UBC97IsoSeismicCoeffFlag, UBC97IsoSoilProfileType, UBC97IsoZ, UBC97IsoCv, UBC97IsoNearSourceFlag, UBC97IsoSourceType, UBC97IsoDist, UBC97IsoNv, UBC97IsoRI, UBC97IsoBD, UBC97IsoKDmax, UBC97IsoKDmin)

    /**
     * This function assigns auto seismic loading parameters for the 1997 UBC code.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param periodFlag This is 1, 2 or 3, indicating the time period option.
     * * 1 = Approximate
     * * 2 = Program calculated
     * * 3 = User defined
     * @param CT The code-specified CT factor. This item applies when the PeriodFlag item is 1 or 2.
     * @param userT The user specified time period. This item applies when the PeriodFlag item is 3. (s)
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param UBC97SeismicCoeffFlag This is either 1 or 2, indicating if the seismic coefficients Ca and Cv are per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * @param UBC97SoilProfileType This is 1, 2, 3, 4 or 5, indicating the soil profile type.
     * * 1 = SA
     * * 2 = SB
     * * 3 = SC
     * * 4 = SD
     * * 5 = SE
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with the code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97Z This is 0.075, 0.15, 0.2, 0.3 or 0.4, indicating the seismic zone factor.
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with code (UBC97SeismicCoeffFlag = 1).
     * @param UBC97Ca The seismic coefficient, Ca.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2).
     * @param UBC97Cv The seismic coefficient, Cv.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2).
     * @param UBC97NearSourceFlag This is either 1 or 2, indicating if the near source factor coefficients Na and Nv are per code or user defined.
     * * 1 = Per code
     * * 2 = User defined
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with the code (UBC97SeismicCoeffFlag = 1) and UBC97Z = 0.4.
     * @param UBC97SourceType This is 1, 2 or 3, indicating the seismic source type.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with code (UBC97SeismicCoeffFlag = 1), UBC97Z = 0.4, and the near source factor coefficients Na and Nv are calculated in accordance with code (UBC97NearSourceFlag = 1).
     * @param UBC97Dist This is the distance to the seismic source in kilometers.
     * This item is applicable only when the seismic coefficients Ca and Cv are calculated in accordance with code (UBC97SeismicCoeffFlag = 1), UBC97Z = 0.4, and the near source factor coefficients Na and Nv are calculated in accordance with code (UBC97NearSourceFlag = 1).
     * @param UBC97Na The near source factor coefficient, Na.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2) and the near source factor coefficients Na and Nv are user defined (UBC97NearSourceFlag = 2).
     * @param UBC97Nv The near source factor coefficient, Nv.
     * This item is applicable only when the seismic coefficients Ca and Cv are user defined (UBC97SeismicCoeffFlag = 2) and the near source factor coefficients Na and Nv are user defined (UBC97NearSourceFlag = 2).
     * @param UBC97I The importance factor.
     * @param UBC97R The overstrength factor.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUBC97(name: String, dirFlag: Int, eccen: Double, periodFlag: Int, CT: Double, userT: Double, userZ: Boolean, topZ: Double, bottomZ: Double, UBC97SeismicCoeffFlag: Int, UBC97SoilProfileType: Int, UBC97Z: Double, UBC97Ca: Double, UBC97Cv: Double, UBC97NearSourceFlag: Int, UBC97SourceType: Int, UBC97Dist: Double, UBC97Na: Double, UBC97Nv: Double, UBC97I: Double, UBC97R: Double): Int =
            callFunctionInt("SetUBC97", name, dirFlag, eccen, periodFlag, CT, userT, userZ, topZ, bottomZ, UBC97SeismicCoeffFlag, UBC97SoilProfileType, UBC97Z, UBC97Ca, UBC97Cv, UBC97NearSourceFlag, UBC97SourceType, UBC97Dist, UBC97Na, UBC97Nv, UBC97I, UBC97R)

    /**
     * This function assigns auto seismic loading parameters for User Coefficient type loading.
     * @param name The name of an existing Quake-type load pattern.
     * @param dirFlag This is either 1 or 2, indicating the seismic load direction.
     * * 1 = Global X
     * * 2 = Global Y
     * @param eccen The eccentricity ratio that applies to all diaphragms.
     * @param userZ This item is True if the top and bottom elevations of the seismic load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto seismic loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto seismic loads are applied. (L)
     * @param c The base shear coefficient.
     * @param k The building height exponent.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUserCoefficient(name: String, dirFlag: Int, eccen: Double, userZ: Boolean, topZ: Double, bottomZ: Double, c: Double, k: Double): Int =
            callFunctionInt("SetUserCoefficient", name, dirFlag, eccen, userZ, topZ, bottomZ, c, k)

    /**
     * This function assigns loading to an auto seismic load that is a User Load type. The SetUserLoad function is used to specify that an auto seismic load is a User Load type
     * @param name The name of an existing Quake-type load pattern that has been assigned a User Load auto seismic type.
     * @param diaph The name of an existing special rigid diaphragm constraint, that is, a diaphragm constraint with the following features:
     * * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * * 2. The constraint coordinate system is Global.
     * * 3. The constraint axis is Z.
     * @param fx The global X direction force assigned to the specified diaphragm. (F)
     * @param fy The global Y direction force assigned to the specified diaphragm. (F)
     * @param mz The moment about the global Z axis assigned to the specified diaphragm. (FL)
     * @param x The global X-coordinate of the point where the seismic force is applied. (L)
     * This item is applicable only when the auto seismic load is specified to have a user specified application point (see the SetUserLoad function).
     * @param y The global Y-coordinate of the point where the seismic force is applied. (L)
     * This item is applicable only when the auto seismic load is specified to have a user specified application point (see the SetUserLoad function).
     * @return zero if the loading is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUserLoadValue(name: String, diaph: String, fx: Double, fy: Double, mz: Double, x: Double = 0.0, y: Double = 0.0): Int =
            callFunctionInt("SetUserLoadValue", name, diaph, fx, fy, mz, x, y)

    /**
     * This function sets the auto seismic load type to User Load. User load values are assigned using the SetUserLoadValue function.
     * @param name The name of an existing Quake-type load pattern.
     * @param myType This is either 1 or 2, indicating the application point type for the user load.
     * * 1 = User specified application point
     * * 2 = At center of mass with optional additional eccentricity
     * @param eccen The eccentricity ratio that applies to all diaphragms. This item is only applicable when MyType = 2.
     * @return zero if the load type is successfully set; otherwise it returns a nonzero value.
     */
    fun setUserLoad(name: String, myType: Int, eccen: Double = 0.05): Int =
            callFunctionInt("SetUserLoad", name, myType, eccen)
}