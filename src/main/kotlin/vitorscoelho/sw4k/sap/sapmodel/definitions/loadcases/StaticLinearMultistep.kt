package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.StaticLinearMultistepV14


class StaticLinearMultistep internal constructor(programName: String) : StaticLinearMultistepV14 {
    override val activeXComponentName: String = "$programName.cCaseStaticLinearMultistep"
}