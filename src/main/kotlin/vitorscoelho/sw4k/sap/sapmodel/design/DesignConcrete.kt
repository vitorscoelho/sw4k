package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignConcreteV14
import vitorscoelho.sw4k.sap.sapmodel.design.concrete.*

class DesignConcrete internal constructor(programName: String) : DesignConcreteV14 {
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