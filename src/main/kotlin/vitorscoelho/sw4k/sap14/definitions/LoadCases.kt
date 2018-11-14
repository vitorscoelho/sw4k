package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinear
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinearV14
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticNonLinear
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticNonLinearV14

class LoadCases(val sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cLoadCases"), LoadCasesV14 {
    override val staticLinear = StaticLinear(this)
    override val staticNonLinear = StaticNonLinear(this)
}

interface LoadCasesV14 {
    val staticLinear: StaticLinearV14
    val staticNonLinear: StaticNonLinearV14
}