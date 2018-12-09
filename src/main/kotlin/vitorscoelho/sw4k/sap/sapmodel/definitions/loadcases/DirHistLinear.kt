package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.DirHistLinearV14


class DirHistLinear internal constructor(programName: String) : DirHistLinearV14 {
    override val activeXComponentName: String = "$programName.cCaseDirectHistoryLinear"
}