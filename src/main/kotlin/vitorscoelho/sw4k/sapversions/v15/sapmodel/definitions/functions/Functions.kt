package vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.functions

import vitorscoelho.sw4k.comutils.ADoubleByRef
import vitorscoelho.sw4k.comutils.AIntByRef
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions.*

interface FuncPSDV15 : FuncPSDV14

interface FuncRSV15 : FuncRSV14 {
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getChinese2002(name: String, JGJ32002AlphaMax: ADoubleByRef, JGJ32002SI: AIntByRef, JGJ32002Tg: ADoubleByRef, JGJ32002PTDF: ADoubleByRef, dampRatio: ADoubleByRef): Int {
        return super.getChinese2002(name, JGJ32002AlphaMax, JGJ32002SI, JGJ32002Tg, JGJ32002PTDF, dampRatio)
    }

    /**
     * This function retrieves the definition of a Eurocode 8 2004 response spectrum function.
     * @param name The name of a Eurocode 8 2004 response spectrum function.
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * 10 = Portugal
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
    override fun getEurocode82004_1(name: String, eURO2004Country: AIntByRef, eURO2004Direction: AIntByRef, eURO2004SpectrumType: AIntByRef, eURO2004GroundType: AIntByRef, eURO2004ag: ADoubleByRef, eURO2004S: ADoubleByRef, eURO2004AvgoverAg: ADoubleByRef, eURO2004Tb: ADoubleByRef, eURO2004Tc: ADoubleByRef, eURO2004Td: ADoubleByRef, eURO2004Beta: ADoubleByRef, eURO2004q: ADoubleByRef, dampRatio: ADoubleByRef): Int {
        return super.getEurocode82004_1(name, eURO2004Country, eURO2004Direction, eURO2004SpectrumType, eURO2004GroundType, eURO2004ag, eURO2004S, eURO2004AvgoverAg, eURO2004Tb, eURO2004Tc, eURO2004Td, eURO2004Beta, eURO2004q, dampRatio)
    }

    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun setChinese2002(name: String, JGJ32002AlphaMax: Double, JGJ32002SI: Int, JGJ32002Tg: Double, JGJ32002PTDF: Double, dampRatio: Double): Int {
        return super.setChinese2002(name, JGJ32002AlphaMax, JGJ32002SI, JGJ32002Tg, JGJ32002PTDF, dampRatio)
    }

    /**
     * This function defines a Eurocode 8 2004 response spectrum function.
     * @param name The name of an existing or new function. If this is an existing function,n that function is modified; otherwise, a new function is added.
     * @param eURO2004Country This is 0, 1, 5, or 10 indicating the country for which the Nationally Determined Parameters (NDPs) are specified.
     * 0 = Other (NDPs are user specified)
     * 1 = CEN Default
     * 5 = Norway
     * 10 = Portugal
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
    override fun setEurocode82004_1(name: String, eURO2004Country: Int, eURO2004Direction: Int, eURO2004SpectrumType: Int, eURO2004GroundType: Int, eURO2004ag: Double, eURO2004S: Double, eURO2004AvgoverAg: Double, eURO2004Tb: Double, eURO2004Tc: Double, eURO2004Td: Double, eURO2004Beta: Double, eURO2004q: Double, dampRatio: Double): Int {
        return super.setEurocode82004_1(name, eURO2004Country, eURO2004Direction, eURO2004SpectrumType, eURO2004GroundType, eURO2004ag, eURO2004S, eURO2004AvgoverAg, eURO2004Tb, eURO2004Tc, eURO2004Td, eURO2004Beta, eURO2004q, dampRatio)
    }
}

interface FuncSSV15 : FuncSSV14

interface FuncTHV15 : FuncTHV14