package vitorscoelho.sw4k.sapversions.v15.sapmodel.design.steel

import vitorscoelho.sw4k.comutils.ABooleanByRef
import vitorscoelho.sw4k.comutils.ADoubleByRef
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.*

interface AISC_360_05_IBC_2006V15 : AISC_360_05_IBC_2006V14
interface AISC_ASD01V15 : AISC_ASD01V14
interface AISC_ASD89V15 : AISC_ASD89V14
interface AISC_LRFD93V15 : AISC_LRFD93V14
interface AISC_LRFD99V15 : AISC_LRFD99V14
interface API_RP2A_LRFD97V15 : API_RP2A_LRFD97V14
interface API_RP2A_WSD2000V15 : API_RP2A_WSD2000V14
interface ASCE_10_97V15 : ASCE_10_97V14
interface BS5950_2000V15 : BS5950_2000V14
interface BS5950_90V15 : BS5950_90V14
interface Chinese_2002V15 : Chinese_2002V14 {
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getOverwrite(name: String, item: Int, value: ADoubleByRef, progDet: ABooleanByRef): Int {
        return super.getOverwrite(name, item, value, progDet)
    }

    /**
     * This function retrieves the value of a steel design preference item.
     * @param item This is an integer between 1 and 14, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Gamma0
     * * 3 = Ignore b/t check
     * * 4 = Classify beam as flexo compression member
     * * 5 = Consider deflection
     * * 6 = DL deflection limit, L/Value
     * * 7 = SDL + LL deflection limit, L/Value
     * * 8 = LL deflection limit, L/Value
     * * 9 = Total load deflection limit, L/Value
     * * 10 = Total camber limit, L/Value
     * * 11 = Pattern live load factor
     * * 12 = Demand/capacity ratio limit
     * * 13 = Multi-response case design
     * * 14 = Is tall building?
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * * 0 = As specified in preferences
     * * * 1 = Sway Moment Frame, SMF
     * * * 2 = Concentrically Braced Frame, CBF
     * * * 3 = Eccentrically Braced Frame, EBF
     * * * 4 = NonSway Moment Frame, NMF
     * * 2 = Gamma0
     * * Value > 0
     * * 3 = Ignore b/t check
     * * * 0 = No
     * * * Any other value = Yes
     * * 4 = Classify beam as flexo compression member
     * * * 0 = No
     * * * Any other value = Yes
     * * 5 = Consider deflection
     * * * 0 = No
     * * * Any other value = Yes
     * * 6 = DL deflection limit, L/Value
     * * Value > 0
     * * 7 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 8 = LL deflection limit, L/Value
     * * Value > 0
     * * 9 = Total load deflection limit, L/Value
     * * Value > 0
     * * 10 = Total camber limit, L/Value
     * * Value > 0
     * * 11 = Pattern live load factor
     * * Value >= 0
     * * 12 = Demand/capacity ratio limit
     * * Value > 0
     * * 13 = Multi-response case design
     * * * 1 = Envelopes
     * * * 2 = Step-by-step
     * * * 3 = Last step
     * * * 4 = Envelopes -- All
     * * * 5 = Step-by-step -- All
     * * 14 = Tall building
     * * * 0 = No
     * * * 1 = Yes
     * @return zero if the item is successfully retrieved; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getPreference(item: Int, value: ADoubleByRef): Int {
        return super.getPreference(item, value)
    }

    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun setOverwrite(name: String, item: Int, value: Double, itemType: Int): Int {
        return super.setOverwrite(name, item, value, itemType)
    }

    /**
     * This function sets the value of a steel design preference item.
     * @param item This is an integer between 1 and 14, inclusive, indicating the preference item considered.
     * * 1 = Framing type
     * * 2 = Gamma0
     * * 3 = Ignore b/t check
     * * 4 = Classify beam as flexo compression member
     * * 5 = Consider deflection
     * * 6 = DL deflection limit, L/Value
     * * 7 = SDL + LL deflection limit, L/Value
     * * 8 = LL deflection limit, L/Value
     * * 9 = Total load deflection limit, L/Value
     * * 10 = Total camber limit, L/Value
     * * 11 = Pattern live load factor
     * * 12 = Demand/capacity ratio limit
     * * 13 = Multi-response case design
     * * 14 = Is tall building?
     * @param value The value of the considered preference item.
     * * 1 = Framing type
     * * 0 = As specified in preferences
     * * 1 = Sway Moment Frame, SMF
     * * 2 = Concentrically Braced Frame, CBF
     * * 3 = Eccentrically Braced Frame, EBF
     * * 4 = NonSway Moment Frame, NMF
     * * 2 = Gamma0
     * * Value > 0
     * * 3 = Ignore b/t check
     * * 0 = No
     * * Any other value = Yes
     * * 4 = Classify beam as flexo compression member
     * * 0 = No
     * * Any other value = Yes
     * * 5 = Consider deflection
     * * 0 = No
     * * Any other value = Yes
     * * 6 = DL deflection limit, L/Value
     * * Value > 0
     * * 7 = SDL + LL deflection limit, L/Value
     * * Value > 0
     * * 8 = LL deflection limit, L/Value
     * * Value > 0
     * * 9 = Total load deflection limit, L/Value
     * * Value > 0
     * * 10 = Total camber limit, L/Value
     * * Value > 0
     * * 11 = Pattern live load factor
     * * Value >= 0
     * * 12 = Demand/capacity ratio limit
     * * Value > 0
     * * 13 = Multi-response case design
     * * 1 = Envelopes
     * * 2 = Step-by-step
     * * 3 = Last step
     * * 4 = Envelopes -- All
     * * 5 = Step-by-step -- All
     * @return zero if the item is successfully set; otherwise it returns a nonzero value.
     */
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun setPreference(item: Int, value: Double): Int {
        return super.setPreference(item, value)
    }
}

interface CISC_95V15 : CISC_95V14
interface Eurocode_3_1993V15 : Eurocode_3_1993V14
interface Eurocode_3_2005V15 : Eurocode_3_2005V14
interface Indian_IS_800_1998V15 : Indian_IS_800_1998V14
interface Italian_UNI_10011V15 : Italian_UNI_10011V14
interface UBC97_ASDV15 : UBC97_ASDV14
interface UBC97_LRFDV15 : UBC97_LRFDV14