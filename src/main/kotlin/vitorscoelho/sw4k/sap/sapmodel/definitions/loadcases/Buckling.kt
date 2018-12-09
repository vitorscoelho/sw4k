package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.BucklingV14


class Buckling internal constructor(programName: String) : BucklingV14 {
    override val activeXComponentName: String = "$programName.cCaseBuckling"
}