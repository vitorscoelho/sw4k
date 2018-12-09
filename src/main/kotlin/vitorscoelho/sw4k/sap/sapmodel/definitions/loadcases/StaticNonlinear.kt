package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.StaticNonlinearV14


class StaticNonlinear internal constructor(programName: String) : StaticNonlinearV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonLinear"
}