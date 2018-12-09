package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.ModalRitzV14

class ModalRitz internal constructor(programName: String) : ModalRitzV14 {
    override val activeXComponentName: String = "$programName.cCaseModalRitz"
}