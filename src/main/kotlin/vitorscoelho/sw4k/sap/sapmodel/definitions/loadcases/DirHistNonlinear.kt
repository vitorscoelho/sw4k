package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.DirHistNonlinearV14


class DirHistNonlinear internal constructor(programName: String) : DirHistNonlinearV14 {
    override val activeXComponentName: String = "$programName.cCaseDirectHistoryNonlinear"
}