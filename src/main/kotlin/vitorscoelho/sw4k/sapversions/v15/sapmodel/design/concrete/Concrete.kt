package vitorscoelho.sw4k.sapversions.v15.sapmodel.design.concrete

import vitorscoelho.sw4k.comutils.ABooleanByRef
import vitorscoelho.sw4k.comutils.ADoubleByRef
import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.*

interface ACI_318_02V15 : ACI_318_02V14
interface ACI_318_05_IBC_2003V15 : ACI_318_05_IBC_2003V14
interface ACI_318_99V15 : ACI_318_99V14
interface Australian_AS_3600_01V15 : Australian_AS_3600_01V14
interface BS8110_89V15 : BS8110_89V14
interface BS8110_97V15 : BS8110_97V14
interface Chinese_2002V15 : Chinese_2002V14 {
    @Deprecated(
            message = "This function is maintained for backward compatibility.",
            level = DeprecationLevel.WARNING
    )
    override fun getOverwrite(name: String, item: Int, value: ADoubleByRef, progDet: ABooleanByRef): Int {
        return super.getOverwrite(name, item, value, progDet)
    }

    /**
     * This function retrieves the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Importance factor gamma 0
     * * 4 = Column design procedure
     * * 5 = Seismic design grade
     * * 6 = Pattern live load factor
     * * 7 = Utilization factor limit
     * * 8 = Multi-response case design
     * * 9 = Structural system
     * * 10 = Is tall building?
     * * 11 = Seismic field type
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Importance factor gamma 0
     * * Value > 0
     * * 4 = Column design procedure
     * * * 1 = Appendix F
     * * * 2 = Simplified
     * * 5 = Seismic design grade
     * * * 1 = Super I
     * * * 2 = Grade I
     * * * 3 = Grade II
     * * * 4 = Grade III
     * * * 5 = Grade IV
     * * * 6 = Nonseismic
     * * 6 = Pattern live load factor
     * * Value >= 0
     * * 7 = Utilization factor limit
     * * Value > 0
     * * 8 = Multi-response case design
     * * * 1 = Envelopes
     * * * 2 = Step-by-step
     * * * 3 = Last step
     * * * 4 = Envelopes -- All
     * * * 5 = Step-by-step -- All
     * * 9 = Structural system
     * * * 1 = Frame only
     * * * 2 = Shearwall only
     * * * 3 = Frame-shearwall
     * * * 4 = Braced frame only
     * * * 5 = Frame-braced frame
     * * 10 =  Is tall building?
     * * * 0 = No
     * * * 1 = Yes
     * * 11 =  Seismic field type
     * * * 1 = I
     * * * 2 = II
     * * * 3 = III
     * * * 4 = IV
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
     * This function sets the value of a concrete design preference item.
     * @param item This is an integer between 1 and 11, inclusive, indicating the preference item considered.
     * * 1 = Number of interaction curves
     * * 2 = Number of interaction points
     * * 3 = Importance factor gamma 0
     * * 4 = Column design procedure
     * * 5 = Seismic design grade
     * * 6 = Pattern live load factor
     * * 7 = Utilization factor limit
     * * 8 = Multi-response case design
     * * 9 = Structural system
     * * 10 = Is tall building?
     * * 11 = Seismic field type
     * @param value The value of the considered preference item.
     * * 1 = Number of interaction curves
     * * Value >= 4 and devisable by 4
     * * 2 = Number of interaction points
     * * Value >= 5 and odd
     * * 3 = Importance factor gamma 0
     * * Value > 0
     * * 4 = Column design procedure
     * * 1 = Appendix F
     * * 2 = Simplified
     * * 5 = Seismic design grade
     * * 1 = Super I
     * * 2 = Grade I
     * * 3 = Grade II
     * * 4 = Grade III
     * * 5 = Grade IV
     * * 6 = Nonseismic
     * * 6 = Pattern live load factor
     * * Value >= 0
     * * 7 = Utilization factor limit
     * * Value > 0
     * * 8 = Multi-response case design
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

interface CSA_A23304V15 : CSA_A23304V14
interface CSA_A23394V15 : CSA_A23394V14
interface Eurocode_2_1992V15 : Eurocode_2_1992V14
interface Eurocode_2_2004V15 : Eurocode_2_2004V14
interface Hong_Kong_CP_2004V15 : Hong_Kong_CP_2004V14
interface Indian_IS_456_2000V15 : Indian_IS_456_2000V14
interface Italian_Dm_14_292V15 : Italian_Dm_14_292V14
interface KCI_1999V15 : KCI_1999V14
interface Mexican_RCDF_2001V15 : Mexican_RCDF_2001V14
interface NZS_3101_95V15 : NZS_3101_95V14
interface Singapore_CP_6599V15 : Singapore_CP_6599V14
interface UBC_97V15 : UBC_97V14