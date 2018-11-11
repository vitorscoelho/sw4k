package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinear
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticNonLinear

class LoadCases(val sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cLoadCases") {
    val staticLinear = StaticLinear(this)
    val staticNonLinear = StaticNonLinear(this)
}