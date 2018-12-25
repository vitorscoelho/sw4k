package vitorscoelho.sw4k.sapversions.v15.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.aluminum.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.coldformed.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.concrete.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.concrete.Chinese_2002V15
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.steel.*

interface DesignAluminumV15 : DesignAluminumV14 {
    override val AA_ASD_2000: AA_ASD_2000V15
    override val AA_LRFD_2000: AA_LRFD_2000V15
}

interface DesignColdFormedV15 : DesignColdFormedV14 {
    override val AISI_ASD96: AISI_ASD96V15
    override val AISI_LRFD96: AISI_LRFD96V15
}

interface DesignConcreteV15 : DesignConcreteV14 {
    override val ACI_318_02: ACI_318_02V15
    override val ACI_318_05_IBC_2003: ACI_318_05_IBC_2003V15
    override val ACI_318_99: ACI_318_99V15
    override val Australian_AS_3600_01: Australian_AS_3600_01V15
    override val BS8110_89: BS8110_89V15
    override val BS8110_97: BS8110_97V15
    override val Chinese_2002: vitorscoelho.sw4k.sapversions.v15.sapmodel.design.concrete.Chinese_2002V15
    override val CSA_A23304: CSA_A23304V15
    override val CSA_A23394: CSA_A23394V15
    override val Eurocode_2_1992: Eurocode_2_1992V15
    override val Eurocode_2_2004: Eurocode_2_2004V15
    override val Hong_Kong_CP_2004: Hong_Kong_CP_2004V15
    override val Indian_IS_456_2000: Indian_IS_456_2000V15
    override val Italian_Dm_14_292: Italian_Dm_14_292V15
    override val KCI_1999: KCI_1999V15
    override val Mexican_RCDF_2001: Mexican_RCDF_2001V15
    override val NZS_3101_95: NZS_3101_95V15
    override val Singapore_CP_6599: Singapore_CP_6599V15
    override val UBC_97: UBC_97V15
}

interface DesignSteelV15 : DesignSteelV14 {
    override val AISC_360_05_IBC_2006: AISC_360_05_IBC_2006V15
    override val AISC_ASD01: AISC_ASD01V15
    override val AISC_ASD89: AISC_ASD89V15
    override val AISC_LRFD93: AISC_LRFD93V15
    override val AISC_LRFD99: AISC_LRFD99V15
    override val API_RP2A_LRFD97: API_RP2A_LRFD97V15
    override val API_RP2A_WSD2000: API_RP2A_WSD2000V15
    override val ASCE_10_97: ASCE_10_97V15
    override val BS5950_2000: BS5950_2000V15
    override val BS5950_90: BS5950_90V15
    override val Chinese_2002: vitorscoelho.sw4k.sapversions.v15.sapmodel.design.steel.Chinese_2002V15
    override val CISC_95: CISC_95V15
    override val Eurocode_3_1993: Eurocode_3_1993V15
    override val Eurocode_3_2005: Eurocode_3_2005V15
    override val Indian_IS_800_1998: Indian_IS_800_1998V15
    override val Italian_UNI_10011: Italian_UNI_10011V15
    override val UBC97_ASD: UBC97_ASDV15
    override val UBC97_LRFD: UBC97_LRFDV15
}