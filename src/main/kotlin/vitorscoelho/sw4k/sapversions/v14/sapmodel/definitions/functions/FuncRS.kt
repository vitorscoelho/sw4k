package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions

import vitorscoelho.sw4k.comutils.*

interface FuncRSV14 : SapComponent {
    /**
     * This function retrieves the definition of an AASHTO2006 response spectrum function.
     * @param name The name of an AASHTO2006 response spectrum function.
     * @param AASHTO2006A The acceleration coefficient, A.
     * @param AASHTO2006SoilProfileType This is 1, 2, 3 or 4, indicating the soil profile type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * * 4 = IV
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAASHTO2006(name: String, AASHTO2006A: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2006SoilProfileType: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetAASHTO2006", name, AASHTO2006A, AASHTO2006SoilProfileType, dampRatio)

    /**
     * This function retrieves the definition of a AASHTO 20-07 response spectrum function.
     * @param name The name of an AASHTO 20-07 response spectrum function.
     * @param AASHTO2007Option This is 0, 1, or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param AASHTO2007Latitude, AASHTO2007Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are used only when AASHTO2007Option = 0.
     * @param AASHTO2007ZipCode The zip code for which the seismic coefficients are obtained. This item is used only when AASHTO2007Option = 1.
     * @param AASHTO2007SS, AASHTO2007S1, AASHTO2007PGA The seismic coefficients Ss, S1 and PGA. These items are used only when AASHTO2007Option = 2.
     * @param AASHTO2007SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param AASHTO2007Fa, AASHTO2007Fv, AASHTO2007Fpga The site coefficients Fa, Fv and Fpga. These items are used only when AASHTO2007SiteClass= 6.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAASHTO2007(name: String, AASHTO2007Option: AIntByRef = IntByRef.UNNECESSARY, AASHTO2007Latitude: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007Longitude: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007ZipCode: AStringByRef = StringByRef.UNNECESSARY, AASHTO2007SS: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007S1: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007PGA: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007SiteClass: AIntByRef = IntByRef.UNNECESSARY, AASHTO2007Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007Fpga: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetAASHTO2007", name, AASHTO2007Option, AASHTO2007Latitude, AASHTO2007Longitude, AASHTO2007ZipCode, AASHTO2007SS, AASHTO2007S1, AASHTO2007PGA, AASHTO2007SiteClass, AASHTO2007Fa, AASHTO2007Fv, AASHTO2007Fpga, dampRatio)

    /**
     * This function retrieves the definition of an AS 1170 2007 response spectrum function.
     * @param name The name of a AS 1170 2007 response spectrum function.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getAS11702007(name: String, AS2007SiteClass: AIntByRef = IntByRef.UNNECESSARY, AS2007kp: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Z: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Sp: ADoubleByRef = DoubleByRef.UNNECESSARY, AS2007Mu: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetAS11702007", name, AS2007SiteClass, AS2007kp, AS2007Z, AS2007Sp, AS2007Mu, dampRatio)

    /**
     * This function retrieves the definition of a BOCA96 response spectrum function.
     * @param name The name of a BOCA96 response spectrum function.
     * @param BOCA96Aa The effective peak acceleration, Aa.
     * @param BOCA96Av The effective peak velocity, Av.
     * @param BOCA96S The soil profile coefficient, S.
     * @param BOCA96R The response modification factor, R.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getBOCA96(name: String, BOCA96Aa: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96Av: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96S: ADoubleByRef = DoubleByRef.UNNECESSARY, BOCA96R: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetBOCA96", name, BOCA96Aa, BOCA96Av, BOCA96S, BOCA96R, dampRatio)

    /**
     * This function retrieves the definition of a Chinese_2002 2002 response spectrum function.
     * @param name The name of a Chinese_2002 2002 response spectrum function.
     * @param JGJ32002AlphaMax The maximum influence factor.
     * @param JGJ32002SI This is 1, 2, 3, 4, 5 or 6, indicating the seismic intensity.
     * * 1 = 6 (0.05g)
     * * 2 = 7 (0.10g)
     * * 3 = 7 (0.15g)
     * * 4 = 8 (0.20g)
     * * 5 = 8 (0.30g)
     * * 6 = 9 (0.40g)
     * @param JGJ32002Tg The characteristic ground period, Tg > 0.1. (s)
     * @param JGJ32002PTDF The period time discount factor.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getChinese2002(name: String, JGJ32002AlphaMax: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002SI: AIntByRef = IntByRef.UNNECESSARY, JGJ32002Tg: ADoubleByRef = DoubleByRef.UNNECESSARY, JGJ32002PTDF: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetChinese2002", name, JGJ32002AlphaMax, JGJ32002SI, JGJ32002Tg, JGJ32002PTDF, dampRatio)

    /**
     * This function retrieves the definition of a EuroCode8 response spectrum function.
     * @param name The name of a EuroCode8 response spectrum function.
     * @param euroCode8AG The design ground acceleration, Ag.
     * @param euroCode8S This is 1, 2 or 3, indicating the subsoil class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param euroCode8n The damping correction factor, n, where n >= 0.7.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEuroCode8(name: String, euroCode8AG: ADoubleByRef = DoubleByRef.UNNECESSARY, euroCode8S: AIntByRef = IntByRef.UNNECESSARY, euroCode8n: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetEuroCode8", name, euroCode8AG, euroCode8S, euroCode8n, dampRatio)

    /**
     * This function retrieves the definition of a Eurocode 8 2004 response spectrum function.
     * @param name The name of a Eurocode 8 2004 response spectrum function.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "The function is obsolete and has been superceded by GetEurocode82004_1 as of version 14.1.0. This function is maintained for backward compatibility. New function added.",
            replaceWith = ReplaceWith(
                    expression = "getEurocode82004_1(name,eURO2004Country,eURO2004Direction,eURO2004SpectrumType,eURO2004GroundType,eURO2004ag,eURO2004S,eURO2004AvgoverAg,eURO2004Tb,eURO2004Tc,eURO2004Td,eURO2004Beta,eURO2004q,dampRatio)",
                    imports = arrayOf("vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncRS")
            ),
            level = DeprecationLevel.WARNING
    )
    fun getEurocode82004(name: String, EURO2004GroundType: AIntByRef = IntByRef.UNNECESSARY, EURO2004SpectrumType: AIntByRef = IntByRef.UNNECESSARY, EURO2004ag: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004Beta: ADoubleByRef = DoubleByRef.UNNECESSARY, EURO2004q: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetEurocode82004", name, EURO2004GroundType, EURO2004SpectrumType, EURO2004ag, EURO2004Beta, EURO2004q, dampRatio)

    /**
     * This function retrieves the definition of a Eurocode 8 2004 response spectrum function.
     * @param name The name of a Eurocode 8 2004 response spectrum function.
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * @param eURO2004Direction This is 1 or 2, indicating the ground motion direction.
     * 1 = Horizontal
     * 2 = Vertical
     * @param eURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * 1 = Type 1
     * 2 = Type 2
     * @param eURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type. This item only applies when the EURO2004Direction item is 1 (horizontal).
     * 1 = A
     * 2 = B
     * 3 = C
     * 4 = D
     * 5 = E
     * @param eURO2004ag The design ground acceleration in g, ag.
     * @param eURO2004S The soil factor, S. This item only applies when the EURO2004Direction item is 1 (horizontal).
     * @param eURO2004AvgoverAg The vertical ground acceleration divided by the horizontal ground acceleration, Avg/Ag. This item only applies when the EURO2004Direction item is 2 (vertical).
     * @param eURO2004Tb The lower limit of period of the constant spectral acceleration branch, Tb.
     * @param eURO2004Tc The upper limit of period of the constant spectral acceleration branch, Tc.
     * @param eURO2004Td The period defining the start of the constant displacement range, Td.
     * @param eURO2004Beta The lower bound factor, Beta.
     * @param eURO2004q The behavior factor, q.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getEurocode82004_1 (name:String,eURO2004Country:AIntByRef=IntByRef.UNNECESSARY,eURO2004Direction:AIntByRef=IntByRef.UNNECESSARY,eURO2004SpectrumType:AIntByRef=IntByRef.UNNECESSARY,eURO2004GroundType:AIntByRef=IntByRef.UNNECESSARY,eURO2004ag:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004S:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004AvgoverAg:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004Tb:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004Tc:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004Td:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004Beta:ADoubleByRef=DoubleByRef.UNNECESSARY,eURO2004q:ADoubleByRef=DoubleByRef.UNNECESSARY,dampRatio:ADoubleByRef=DoubleByRef.UNNECESSARY):Int=
            callFunctionInt("GetEurocode82004_1",name,eURO2004Country,eURO2004Direction,eURO2004SpectrumType,eURO2004GroundType,eURO2004ag,eURO2004S,eURO2004AvgoverAg,eURO2004Tb,eURO2004Tc,eURO2004Td,eURO2004Beta,eURO2004q,dampRatio)

    /**
     * This function retrieves the definition of a response spectrum function from file.
     * @param name The name of a defined response spectrum function specified to be from a text file.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @param valueType This is either 1 or 2, indicating time value type.
     * * 1 = Frequency
     * * 2 = Period
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getFromFile(name: String, fileName: AStringByRef = StringByRef.UNNECESSARY, headLines: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY, valueType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetFromFile", name, fileName, headLines, dampRatio, valueType)

    /**
     * This function retrieves the definition of a IBC2003 response spectrum function.
     * @param name The name of a IBC2003 response spectrum function.
     * @param IBC2003SS The design spectral acceleration at short periods, Sds.
     * @param IBC2003S1 The design spectral acceleration at a one second period, Sd1.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIBC2003(name: String, IBC2003SS: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2003S1: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIBC2003", name, IBC2003SS, IBC2003S1, dampRatio)

    /**
     * This function retrieves the definition of a IBC2006 response spectrum function.
     * @param name The name of a IBC2006 response spectrum function.
     * @param IBC2006Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitiude and longitude
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIBC2006(name: String, IBC2006Option: AIntByRef = IntByRef.UNNECESSARY, IBC2006Latitude: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Longitude: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006ZipCode: AStringByRef = StringByRef.UNNECESSARY, IBC2006SS: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006S1: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006TL: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006SiteClass: AIntByRef = IntByRef.UNNECESSARY, IBC2006Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, IBC2006Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIBC2006", name, IBC2006Option, IBC2006Latitude, IBC2006Longitude, IBC2006ZipCode, IBC2006SS, IBC2006S1, IBC2006TL, IBC2006SiteClass, IBC2006Fa, IBC2006Fv, dampRatio)

    /**
     * This function retrieves the definition of a IS1893-2002 response spectrum function.
     * @param name The name of a IS1893-2002 response spectrum function.
     * @param INZ The seismic zone factor, Z.
     * @param INS This is 1, 2 or 3, indicating the soil type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getIS18932002(name: String, INZ: ADoubleByRef = DoubleByRef.UNNECESSARY, INS: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetIS18932002", name, INZ, INS, dampRatio)

    /**
     * This function retrieves the definition of a Italian 3274 response spectrum function.
     * @param name The name of a Italian 3274 response spectrum function.
     * @param italag The peak ground acceleration.
     * @param italSoilType This is 1, 2, 3, 4 or 5, indicating the seismic intensity.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = E
     * * 5 = D
     * @param italq The structure factor.
     * @param italLevel This is 0, 1, 2, 3, 4, 5, 6 or 7, indicating the spectral level, direction and building type.
     * * 0 = SLU/H/Building
     * * 1 = SLU/H/Bridge
     * * 2 = SLU/V/Building
     * * 3 = SLU/V/Bridge
     * * 4 = EL/H/Building
     * * 5 = EL/H/Bridge
     * * 6 = EL/V/Building
     * * 7 = EL/V/Bridge
     * SLU refers to ultimate strength design and EL refers to elastic design. H and V are horizontal and vertical, respectively.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getItalian3274(name: String, italag: ADoubleByRef = DoubleByRef.UNNECESSARY, italSoilType: AIntByRef = IntByRef.UNNECESSARY, italq: ADoubleByRef = DoubleByRef.UNNECESSARY, italLevel: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetItalian3274", name, italag, italSoilType, italq, italLevel, dampRatio)

    /**
     * This function retrieves the definition of a NBCC2005 response spectrum function.
     * @param name The name of a NBCC2005 response spectrum function.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNBCC2005(name: String, NBCC2005PGA: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S02: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S05: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S1: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005S2: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005SiteClass: AIntByRef = IntByRef.UNNECESSARY, NBCC2005Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC2005Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNBCC2005", name, NBCC2005PGA, NBCC2005S02, NBCC2005S05, NBCC2005S1, NBCC2005S2, NBCC2005SiteClass, NBCC2005Fa, NBCC2005Fv, dampRatio)

    /**
     * This function retrieves the definition of a NBCC95 response spectrum function.
     * @param name The name of a NBCC95 response spectrum function.
     * @param NBCC95ZVR The zonal velocity ratio.
     * @param NBCC95ZA The acceleration-related seismic zone.
     * @param NBCC95ZV The velocity-related seismic zone.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNBCC95(name: String, NBCC95ZVR: ADoubleByRef = DoubleByRef.UNNECESSARY, NBCC95ZA: AIntByRef = IntByRef.UNNECESSARY, NBCC95ZV: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNBCC95", name, NBCC95ZVR, NBCC95ZA, NBCC95ZV, dampRatio)

    /**
     * This function retrieves the definition of a NCHRP 20-07 response spectrum function.
     * @param name The name of a NCHRP 20-07 response spectrum function.
     * @param NCHRP2007Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitiude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param NCHRP2007Latitude, NCHRP2007Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are used only when NCHRP2007Option = 0.
     * @param NCHRP2007ZipCode The zip code for which the seismic coefficients are obtained. This item is used only when NCHRP2007Option = 1.
     * @param NCHRP2007SS, NCHRP2007S1 The seismic coefficients Ss and S1. This item is used only when NCHRP2007Option = 2.
     * @param NCHRP2007SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param NCHRP2007Fa, NCHRP2007Fv The site coefficients Fa and Fv. These items are used only when NCHRP2007SiteClass= 6.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNCHRP2007(name: String, NCHRP2007Option: AIntByRef = IntByRef.UNNECESSARY, NCHRP2007Latitude: ADoubleByRef = DoubleByRef.UNNECESSARY, NCHRP2007Longitude: ADoubleByRef = DoubleByRef.UNNECESSARY, NCHRP2007ZipCode: AStringByRef = StringByRef.UNNECESSARY, NCHRP2007SS: ADoubleByRef = DoubleByRef.UNNECESSARY, NCHRP2007S1: ADoubleByRef = DoubleByRef.UNNECESSARY, NCHRP2007SiteClass: AIntByRef = IntByRef.UNNECESSARY, NCHRP2007Fa: ADoubleByRef = DoubleByRef.UNNECESSARY, NCHRP2007Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNCHRP2007", name, NCHRP2007Option, NCHRP2007Latitude, NCHRP2007Longitude, NCHRP2007ZipCode, NCHRP2007SS, NCHRP2007S1, NCHRP2007SiteClass, NCHRP2007Fa, NCHRP2007Fv, dampRatio)

    /**
     * This function retrieves the definition of a NEHRP97 response spectrum function.
     * @param name The name of a NEHRP97 response spectrum function.
     * @param NEHRP97SS The design spectral acceleration at short periods, Sds.
     * @param NEHRP97S1 The design spectral acceleration at a one second period, Sd1.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNEHRP97(name: String, NEHRP97SS: ADoubleByRef = DoubleByRef.UNNECESSARY, NEHRP97S1: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNEHRP97", name, NEHRP97SS, NEHRP97S1, dampRatio)

    /**
     * This function retrieves the definition of an NZS 1170 2004 response spectrum function.
     * @param name The name of a NZS 1170 2004 response spectrum function.
     * @param NZS2004SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NZS2004Z The hazard factor, Z.
     * @param NZS2004R The return period factor, R.
     * @param NZS2004N The near fault factor, N.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNZS11702004(name: String, NZS2004SiteClass: Int, NZS2004Z: Double, NZS2004R: Double, NZS2004N: Double, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNZS11702004", name, NZS2004SiteClass, NZS2004Z, NZS2004R, NZS2004N, dampRatio)

    /**
     * This function retrieves the definition of a NZS4203-1992 response spectrum function.
     * @param name The name of a NZS4203-1992 response spectrum function.
     * @param NZS4203SF The scaling factor (Sm * Sp * R * Z * L).
     * @param NZS4203S This is 1, 2 or 3, indicating the site subsoil category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getNZS42031992(name: String, NZS4203SF: ADoubleByRef = DoubleByRef.UNNECESSARY, NZS4203S: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetNZS42031992", name, NZS4203SF, NZS4203S, dampRatio)

    /**
     * This function retrieves the definition of a UBC94 response spectrum function.
     * @param name The name of a UBC94 response spectrum function.
     * @param UBC94Z The seismic zone factor, Z.
     * @param UBC94S This is 1, 2 or 3, indicating the soil type.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUBC94(name: String, UBC94Z: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC94S: AIntByRef = IntByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUBC94", name, UBC94Z, UBC94S, dampRatio)

    /**
     * This function retrieves the definition of a UBC97 response spectrum function.
     * @param name The name of a UBC97 response spectrum function.
     * @param UBC97Ca The seismic coefficient, Ca.
     * @param UBC97Cv The seismic coefficient, Cv.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUBC97(name: String, UBC97Ca: ADoubleByRef = DoubleByRef.UNNECESSARY, UBC97Cv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUBC97", name, UBC97Ca, UBC97Cv, dampRatio)

    /**
     * This function retrieves the definition of a user defined response spectrum function.
     * @param name The name of a user defined response spectrum function.
     * @param numberItems The number of frequency and value pairs defined.
     * @param period This is an array that includes the time for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function definition is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getUser(name: String, numberItems: AIntByRef = IntByRef.UNNECESSARY, period: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dampRatio: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetUser", name, numberItems, period, value, dampRatio)

    /**
     * This function defines an AASHTO2006 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified, otherwise, a new function is added.
     * @param AASHTO2006A The acceleration coefficient, A.
     * @param AASHTO2006SoilProfileType This is 1, 2, 3 or 4, indicating the soil profile type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * * 4 = IV
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setAASHTO2006(name: String, AASHTO2006A: Double, AASHTO2006SoilProfileType: Int, dampRatio: Double): Int =
            callFunctionInt("SetAASHTO2006", name, AASHTO2006A, AASHTO2006SoilProfileType, dampRatio)

    /**
     * This function defines a AASHTO 2007 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param AASHTO2007Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param AASHTO2007Latitude, AASHTO2007Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are used only when AASHTO2007Option = 0.
     * @param AASHTO2007ZipCode The zip code for which the seismic coefficients are obtained. This item is used only when AASHTO2007Option = 1.
     * @param AASHTO2007SS, AASHTO2007S1, AASHTO2007PGA The seismic coefficients Ss, S1 and PGA. These items are used only when AASHTO2007Option = 2.
     * @param AASHTO2007SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param AASHTO2007Fa, AASHTO2007Fv, AASHTO2007Fpga The site coefficients Fa, Fv and Fpga. These items are used only when AASHTO2007SiteClass= 6.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setAASHTO2007(name: String, AASHTO2007Option: Int, AASHTO2007Latitude: Double, AASHTO2007Longitude: Double, AASHTO2007ZipCode: String, AASHTO2007SS: Double, AASHTO2007S1: Double, AASHTO2007PGA: Double, AASHTO2007SiteClass: Int, AASHTO2007Fa: Double, AASHTO2007Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, AASHTO2007Fpga: Double, dampRatio: Double): Int =
            callFunctionInt("SetAASHTO2007", name, AASHTO2007Option, AASHTO2007Latitude, AASHTO2007Longitude, AASHTO2007ZipCode, AASHTO2007SS, AASHTO2007S1, AASHTO2007PGA, AASHTO2007SiteClass, AASHTO2007Fa, AASHTO2007Fv, AASHTO2007Fpga, dampRatio)

    /**
     * This function defines an AS 1170.4 2007 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified, otherwise, a new function is added.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setAS11702007(name: String, AS2007SiteClass: Int, AS2007kp: Double, AS2007Z: Double, AS2007Sp: Double, AS2007Mu: Double, dampRatio: Double): Int =
            callFunctionInt("SetAS11702007", name, AS2007SiteClass, AS2007kp, AS2007Z, AS2007Sp, AS2007Mu, dampRatio)

    /**
     * This function defines a BOCA96 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param BOCA96Aa The effective peak acceleration, Aa.
     * @param BOCA96Av The effective peak velocity, Av.
     * @param BOCA96S The soil profile coefficient, S.
     * @param BOCA96R The response modification factor, R.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setBOCA96(name: String, BOCA96Aa: Double, BOCA96Av: Double, BOCA96S: Double, BOCA96R: Double, dampRatio: Double): Int =
            callFunctionInt("SetBOCA96", name, BOCA96Aa, BOCA96Av, BOCA96S, BOCA96R, dampRatio)

    /**
     * This function defines a Chinese_2002 2002 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param JGJ32002AlphaMax The maximum influence factor.
     * @param JGJ32002SI This is 1, 2, 3, 4, 5 or 6, indicating the seismic intensity.
     * * 1 = 6 (0.05g)
     * * 2 = 7 (0.10g)
     * * 3 = 7 (0.15g)
     * * 4 = 8 (0.20g)
     * * 5 = 8 (0.30g)
     * * 6 = 9 (0.40g)
     * @param JGJ32002Tg The characteristic ground period, Tg > 0.1. (s)
     * @param JGJ32002PTDF The period time discount factor.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setChinese2002(name: String, JGJ32002AlphaMax: Double, JGJ32002SI: Int, JGJ32002Tg: Double, JGJ32002PTDF: Double, dampRatio: Double): Int =
            callFunctionInt("SetChinese2002", name, JGJ32002AlphaMax, JGJ32002SI, JGJ32002Tg, JGJ32002PTDF, dampRatio)

    /**
     * This function defines a EuroCode8 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param euroCode8AG The design ground acceleration, Ag.
     * @param euroCode8S This is 1, 2 or 3, indicating the subsoil class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param euroCode8n The damping correction factor, n, where n >= 0.7.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setEuroCode8(name: String, euroCode8AG: Double, euroCode8S: Int, euroCode8n: Double, dampRatio: Double): Int =
            callFunctionInt("SetEuroCode8", name, euroCode8AG, euroCode8S, euroCode8n, dampRatio)

    /**
     * This function defines a Eurocode 8 2004 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function,n that function is modified; otherwise, a new function is added.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "The function is obsolete and has been superceded by SetEurocode82004_1 as of version 14.1.0. This function is maintained for backward compatibility. New function added.",
            replaceWith = ReplaceWith(
                    expression = "setEurocode82004_1(name,eURO2004Country,eURO2004Direction,eURO2004SpectrumType,eURO2004GroundType,eURO2004ag,eURO2004S,eURO2004AvgoverAg,eURO2004Tb,eURO2004Tc,eURO2004Td,eURO2004Beta,eURO2004q,dampRatio)",
                    imports = arrayOf("vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncRS")
            ),
            level = DeprecationLevel.WARNING
    )
    fun setEurocode82004(name: String, EURO2004GroundType: Int, EURO2004SpectrumType: Int, EURO2004ag: Double, EURO2004Beta: Double, EURO2004q: Double, dampRatio: Double): Int =
            callFunctionInt("SetEurocode82004", name, EURO2004GroundType, EURO2004SpectrumType, EURO2004ag, EURO2004Beta, EURO2004q, dampRatio)

    /**
     * This function defines a Eurocode 8 2004 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function,n that function is modified; otherwise, a new function is added.
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * @param eURO2004Direction This is 1 or 2, indicating the ground motion direction.
     * 1 = Horizontal
     * 2 = Vertical
     * @param eURO2004SpectrumType This is 1 or 2, indicating the spectrum type.
     * 1 = Type 1
     * 2 = Type 2
     * @param eURO2004GroundType This is 1, 2, 3, 4 or 5, indicating the ground type. This item only applies when the EURO2004Direction item is 1 (horizontal).
     * 1 = A
     * 2 = B
     * 3 = C
     * 4 = D
     * 5 = E
     * @param eURO2004ag The design ground acceleration in g, ag.
     * @param eURO2004S The soil factor, S. This item only applies when the EURO2004Direction item is 1 (horizontal). If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004AvgoverAg The vertical ground acceleration divided by the horizontal ground acceleration, Avg/Ag. This item only applies when the EURO2004Direction item is 2 (vertical). If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004Tb The lower limit of period of the constant spectral acceleration branch, Tb. If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004Tc The upper limit of period of the constant spectral acceleration branch, Tc. If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004Td The period defining the start of the constant displacement range, Td. If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004Beta The lower bound factor, Beta. If the EURO2004Country item is not 0, then the input value for this item is ignored.
     * @param eURO2004q The behavior factor, q.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setEurocode82004_1 (name:String,eURO2004Country:Int,eURO2004Direction:Int,eURO2004SpectrumType:Int,eURO2004GroundType:Int,eURO2004ag:Double,eURO2004S:Double,eURO2004AvgoverAg:Double,eURO2004Tb:Double,eURO2004Tc:Double,eURO2004Td:Double,eURO2004Beta:Double,eURO2004q:Double,dampRatio:Double):Int=
            callFunctionInt("SetEurocode82004_1",name,eURO2004Country,eURO2004Direction,eURO2004SpectrumType,eURO2004GroundType,eURO2004ag,eURO2004S,eURO2004AvgoverAg,eURO2004Tb,eURO2004Tc,eURO2004Td,eURO2004Beta,eURO2004q,dampRatio)

    /**
     * This function defines a response spectrum function from file.
     * @param name The name of an existing or new function. If this is an existing function. that function is modified; otherwise, a new function is added.
     * @param fileName The full path of the text file containing the function data.
     * @param headLines The number of header lines in the text file to be skipped before starting to read function data.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @param valueType This is either 1 or 2, indicating time value type.
     * * 1 = Frequency
     * * 2 = Period
     * @return zero if the function is successfully defined, otherwise it returns a nonzero value.
     */
    fun setFromFile(name: String, fileName: String, headLines: Int, dampRatio: Double, valueType: Int = 2): Int =
            callFunctionInt("SetFromFile", name, fileName, headLines, dampRatio, valueType)

    /**
     * This function defines a IBC2003 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified, otherwise, a new function is added.
     * @param IBC2003SS The design spectral acceleration at short periods, Sds.
     * @param IBC2003S1 The design spectral acceleration at a one second period, Sd1.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setIBC2003(name: String, IBC2003SS: Double, IBC2003S1: Double, dampRatio: Double): Int =
            callFunctionInt("SetIBC2003", name, IBC2003SS, IBC2003S1, dampRatio)

    /**
     * This function defines a IBC2006 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified; otherwise, a new function is added.
     * @param IBC2006Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitiude and longitude
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setIBC2006(name: String, IBC2006Option: Int, IBC2006Latitude: Double, IBC2006Longitude: Double, IBC2006ZipCode: String, IBC2006SS: Double, IBC2006S1: Double, IBC2006TL: Double, IBC2006SiteClass: Int, IBC2006Fa: Double, IBC2006Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: Double): Int =
            callFunctionInt("SetIBC2006", name, IBC2006Option, IBC2006Latitude, IBC2006Longitude, IBC2006ZipCode, IBC2006SS, IBC2006S1, IBC2006TL, IBC2006SiteClass, IBC2006Fa, IBC2006Fv, dampRatio)

    /**
     * This function defines a IS1893-2002 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param INZ The seismic zone factor, Z.
     * @param INS This is 1, 2 or 3, indicating the soil type.
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setIS18932002(name: String, INZ: Double, INS: Int, dampRatio: Double): Int =
            callFunctionInt("SetIS18932002", name, INZ, INS, dampRatio)

    /**
     * This function defines a Italian 3274 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param italag The peak ground acceleration.
     * @param italSoilType This is 1, 2, 3, 4 or 5, indicating the seismic intensity.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = E
     * * 5 = D
     * @param italq The structure factor.
     * @param italLevel This is 0, 1, 2, 3, 4, 5, 6 or 7, indicating the spectral level, direction and building type.
     * * 0 = SLU/H/Building
     * * 1 = SLU/H/Bridge
     * * 2 = SLU/V/Building
     * * 3 = SLU/V/Bridge
     * * 4 = EL/H/Building
     * * 5 = EL/H/Bridge
     * * 6 = EL/V/Building
     * * 7 = EL/V/Bridge
     * SLU refers to ultimate strength design and EL refers to elastic design. H and V are horizontal and vertical, respectively.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setItalian3274(name: String, italag: Double, italSoilType: Int, italq: Double, italLevel: Double, dampRatio: Double): Int =
            callFunctionInt("SetItalian3274", name, italag, italSoilType, italq, italLevel, dampRatio)

    /**
     * This function defines a NBCC2005 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
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
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNBCC2005(name: String, NBCC2005PGA: Double, NBCC2005S02: Double, NBCC2005S05: Double, NBCC2005S1: Double, NBCC2005S2: Double, NBCC2005SiteClass: Int, NBCC2005Fa: Double, NBCC2005Fv: Double, dampRatio: Double): Int =
            callFunctionInt("SetNBCC2005", name, NBCC2005PGA, NBCC2005S02, NBCC2005S05, NBCC2005S1, NBCC2005S2, NBCC2005SiteClass, NBCC2005Fa, NBCC2005Fv, dampRatio)

    /**
     * This function defines a NBCC95 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified; otherwise, a new function is added.
     * @param NBCC95ZVR The zonal velocity ratio.
     * @param NBCC95ZA The acceleration-related seismic zone.
     * @param NBCC95ZV The velocity-related seismic zone.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNBCC95(name: String, NBCC95ZVR: Double, NBCC95ZA: Int, NBCC95ZV: Int, dampRatio: Double): Int =
            callFunctionInt("SetNBCC95", name, NBCC95ZVR, NBCC95ZA, NBCC95ZV, dampRatio)

    /**
     * This function defines a NCHRP 20-07 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param NCHRP2007Option This is 0, 1 or 2, indicating the seismic coefficient option.
     * * 0 = Ss and S1 from USGS by latitiude and longitude
     * * 1 = Ss and S1 from USGS by zip code
     * * 2 = Ss and S1 are user defined
     * @param NCHRP2007Latitude, NCHRP2007Longitude The latitude and longitude for which the seismic coefficients are obtained. These items are used only when NCHRP2007Option = 0.
     * @param NCHRP2007ZipCode The zip code for which the seismic coefficients are obtained. This item is used only when NCHRP2007Option = 1.
     * @param NCHRP2007SS, NCHRP2007S1 The seismic coefficients Ss and S1. This item is used only when NCHRP2007Option = 2.
     * @param NCHRP2007SiteClass This is 1, 2, 3, 4, 5 or 6, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * * 6 = F
     * @param NCHRP2007Fa, NCHRP2007Fv The site coefficients Fa and Fv. These items are used only when NCHRP2007SiteClass= 6.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNCHRP2007(name: String, NCHRP2007Option: Int, NCHRP2007Latitude: Double, NCHRP2007Longitude: Double, NCHRP2007ZipCode: String, NCHRP2007SS: Double, NCHRP2007S1: Double, NCHRP2007SiteClass: Int, NCHRP2007Fa: Double, NCHRP2007Fv: ADoubleByRef = DoubleByRef.UNNECESSARY, dampRatio: Double): Int =
            callFunctionInt("SetNCHRP2007", name, NCHRP2007Option, NCHRP2007Latitude, NCHRP2007Longitude, NCHRP2007ZipCode, NCHRP2007SS, NCHRP2007S1, NCHRP2007SiteClass, NCHRP2007Fa, NCHRP2007Fv, dampRatio)

    /**
     * This function defines a NEHRP97 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function then that function is modified; otherwise, a new function is added.
     * @param NEHRP97SS The design spectral acceleration at short periods, Sds.
     * @param NEHRP97S1 The design spectral acceleration at a one second period, Sd1.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNEHRP97(name: String, NEHRP97SS: Double, NEHRP97S1: Double, dampRatio: Double): Int =
            callFunctionInt("SetNEHRP97", name, NEHRP97SS, NEHRP97S1, dampRatio)

    /**
     * This function defines an NZS 1170.5 2004 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param NZS2004SiteClass This is 1, 2, 3, 4 or 5, indicating the site class.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * * 5 = E
     * @param NZS2004Z The hazard factor, Z.
     * @param NZS2004R The return period factor, R.
     * @param NZS2004N The near fault factor, N.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNZS11702004(name: String, NZS2004SiteClass: Int, NZS2004Z: Double, NZS2004R: Double, NZS2004N: Double, dampRatio: Double): Int =
            callFunctionInt("SetNZS11702004", name, NZS2004SiteClass, NZS2004Z, NZS2004R, NZS2004N, dampRatio)

    /**
     * This function defines a NZS4203-1992 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param NZS4203SF The scaling factor (Sm * Sp * R * Z * L).
     * @param NZS4203S This is 1, 2 or 3, indicating the site subsoil category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setNZS42031992(name: String, NZS4203SF: Double, NZS4203S: Int, dampRatio: Double): Int =
            callFunctionInt("SetNZS42031992", name, NZS4203SF, NZS4203S, dampRatio)

    /**
     * This function defines a UBC94 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param UBC94Z The seismic zone factor, Z.
     * @param UBC94S This is 1, 2 or 3, indicating the soil type.
     * @param dampRatio * The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUBC94(name: String, UBC94Z: Double, UBC94S: Int, dampRatio: Double): Int =
            callFunctionInt("SetUBC94", name, UBC94Z, UBC94S, dampRatio)

    /**
     * This function defines a UBC97 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param UBC97Ca The seismic coefficient, Ca.
     * @param UBC97Cv The seismic coefficient, Cv.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUBC97(name: String, UBC97Ca: Double, UBC97Cv: Double, dampRatio: Double): Int =
            callFunctionInt("SetUBC97", name, UBC97Ca, UBC97Cv, dampRatio)

    /**
     * This function defines a user response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function, that function is modified; otherwise, a new function is added.
     * @param numberItems The number of period and value pairs defined.
     * @param period This is an array that includes the period for each data point. (s)
     * @param value This is an array that includes the function value for each data point.
     * @param dampRatio The damping ratio for the function, 0 <= DampRatio < 1.
     * @return zero if the function is successfully defined; otherwise it returns a nonzero value.
     */
    fun setUser(name: String, numberItems: Int, period: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dampRatio: Double): Int =
            callFunctionInt("SetUser", name, numberItems, period, value, dampRatio)
}