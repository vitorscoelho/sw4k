package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.StaticNonlinearStagedV14


class StaticNonlinearStaged internal constructor(programName: String) : StaticNonlinearStagedV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonlinearStaged"
}