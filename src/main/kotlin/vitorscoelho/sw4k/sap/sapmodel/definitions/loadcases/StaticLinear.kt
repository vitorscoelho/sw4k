package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.StaticLinearV14


class StaticLinear internal constructor(programName: String) : StaticLinearV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticLinear"
}