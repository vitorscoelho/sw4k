package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignSteelV14
import vitorscoelho.sw4k.sap.sapmodel.design.steel.*

class DesignSteel internal constructor(programName: String) : DesignSteelV14 {
    override val activeXComponentName: String = "$programName.cDesignSteel"

    override val AISC_360_05_IBC_2006 = AISC_360_05_IBC_2006(programName)
    override val AISC_ASD01 = AISC_ASD01(programName)
    override val AISC_ASD89 = AISC_ASD89(programName)
    override val AISC_LRFD93 = AISC_LRFD93(programName)
    override val AISC_LRFD99 = AISC_LRFD99(programName)
    override val API_RP2A_LRFD97 = API_RP2A_LRFD97(programName)
    override val API_RP2A_WSD2000 = API_RP2A_WSD2000(programName)
    override val ASCE_10_97 = ASCE_10_97(programName)
    override val BS5950_2000 = BS5950_2000(programName)
    override val BS5950_90 = BS5950_90(programName)
    override val Chinese_2002 = Chinese_2002(programName)
    override val CISC_95 = CISC_95(programName)
    override val Eurocode_3_1993 = Eurocode_3_1993(programName)
    override val Eurocode_3_2005 = Eurocode_3_2005(programName)
    override val Indian_IS_800_1998 = Indian_IS_800_1998(programName)
    override val Italian_UNI_10011 = Italian_UNI_10011(programName)
    override val UBC97_ASD = UBC97_ASD(programName)
    override val UBC97_LRFD = UBC97_LRFD(programName)
}