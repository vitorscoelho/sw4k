package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.HyperStaticV14


class HyperStatic internal constructor(programName: String) : HyperStaticV14 {
    override val activeXComponentName: String = "$programName.cCaseHyperStatic"
}