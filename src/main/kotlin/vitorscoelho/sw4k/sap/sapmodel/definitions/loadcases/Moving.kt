package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.MovingV14


class Moving internal constructor(programName: String) : MovingV14 {
    override val activeXComponentName: String = "$programName.cCaseMovingLoad"
}