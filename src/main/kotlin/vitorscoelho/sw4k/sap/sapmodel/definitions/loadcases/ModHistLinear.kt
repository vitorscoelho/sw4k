package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.ModHistLinearV14


class ModHistLinear internal constructor(programName: String) : ModHistLinearV14 {
    override val activeXComponentName: String = "$programName.cCaseModalHistoryLinear"
}