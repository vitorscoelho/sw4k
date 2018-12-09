package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.ModHistNonlinearV14


class ModHistNonlinear internal constructor(programName: String) : ModHistNonlinearV14 {
    override val activeXComponentName: String = "$programName.cCaseModalHistoryNonlinear"
}