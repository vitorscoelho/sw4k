package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.SteadyStateV14


class SteadyState internal constructor(programName: String) : SteadyStateV14 {
    override val activeXComponentName: String = "$programName.cCaseSteadyState"
}