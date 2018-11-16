package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinear
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinearV14
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticNonLinear
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticNonLinearV14

class LoadCases(programName: String) : LoadCasesV14 {
    override val activeXComponentName: String = "$programName.cLoadCases"
    override val staticLinear = StaticLinear(programName)
    override val staticNonLinear = StaticNonLinear(programName)
}

interface LoadCasesV14 : SapComponent {
    val staticLinear: StaticLinearV14
    val staticNonLinear: StaticNonLinearV14
}