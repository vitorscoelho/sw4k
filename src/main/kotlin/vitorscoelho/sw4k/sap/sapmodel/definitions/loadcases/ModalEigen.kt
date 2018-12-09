package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.ModalEigenV14


class ModalEigen internal constructor(programName: String) : ModalEigenV14 {
    override val activeXComponentName: String = "$programName.cCaseModalEigen"
}