package vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.namedassign.ReleaseFrameV14

class ReleaseFrame internal constructor(programName: String) : ReleaseFrameV14 {
    override val activeXComponentName: String = "$programName.cReleaseFrame"
}