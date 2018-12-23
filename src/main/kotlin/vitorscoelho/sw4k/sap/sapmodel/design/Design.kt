package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sap.sapmodel.design.aluminum.*
import vitorscoelho.sw4k.sap.sapmodel.design.coldformed.*
import vitorscoelho.sw4k.sap.sapmodel.design.concrete.*
import vitorscoelho.sw4k.sap.sapmodel.design.steel.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.*

class DesignAluminum internal constructor(programName: String) : DesignAluminumV15 {
    override val activeXComponentName: String = "$programName.cDesignAluminum"

    override val AA_ASD_2000 = AA_ASD_2000(programName)
    override val AA_LRFD_2000 = AA_LRFD_2000(programName)
}

class DesignColdFormed internal constructor(programName: String) : DesignColdFormedV15 {
    override val activeXComponentName: String = "$programName.cDesignColdFormed"

    override val AISI_ASD96 = AISI_ASD96(programName)
    override val AISI_LRFD96 = AISI_LRFD96(programName)
}

class DesignConcrete internal constructor(programName: String) : DesignConcreteV15 {
    override val activeXComponentName: String = "$programName.cDesignConcrete"

    override val ACI_318_02 = ACI_318_02(programName)
    override val ACI_318_05_IBC_2003 = ACI_318_05_IBC_2003(programName)
    override val ACI_318_99 = ACI_318_99(programName)
    override val Australian_AS_3600_01 = Australian_AS_3600_01(programName)
    override val BS8110_89 = BS8110_89(programName)
    override val BS8110_97 = BS8110_97(programName)
    override val Chinese = Chinese(programName)
    override val CSA_A23304 = CSA_A23304(programName)
    override val CSA_A23394 = CSA_A23394(programName)
    override val Eurocode_2_1992 = Eurocode_2_1992(programName)
    override val Eurocode_2_2004 = Eurocode_2_2004(programName)
    override val Hong_Kong_CP_2004 = Hong_Kong_CP_2004(programName)
    override val Indian_IS_456_2000 = Indian_IS_456_2000(programName)
    override val Italian_Dm_14_292 = Italian_Dm_14_292(programName)
    override val KCI_1999 = KCI_1999(programName)
    override val Mexican_RCDF_2001 = Mexican_RCDF_2001(programName)
    override val NZS_3101_95 = NZS_3101_95(programName)
    override val Singapore_CP_6599 = Singapore_CP_6599(programName)
    override val UBC_97 = UBC_97(programName)
}

class DesignSteel internal constructor(programName: String) : DesignSteelV15 {
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