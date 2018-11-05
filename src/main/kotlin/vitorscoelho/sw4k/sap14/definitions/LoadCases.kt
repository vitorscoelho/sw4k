package vitorscoelho.sw4k.sap14.definitions

import vitorscoelho.sw4k.sap14.SapComponent
import vitorscoelho.sw4k.sap14.SapModel
import vitorscoelho.sw4k.sap14.definitions.loadcases.StaticLinear
import vitorscoelho.sw4k.sap14.enums.DesignType
import vitorscoelho.sw4k.sap14.enums.LoadPatternType

class LoadCases(val sapModel: SapModel) : SapComponent("${sapModel.sapObject.sapObjectString}.cLoadCases") {
    val staticLinear = StaticLinear(this)
}