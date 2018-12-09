package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.CoordSysV14

class CoordSys internal constructor(programName: String) : CoordSysV14 {
    override val activeXComponentName: String = "$programName.cCoordSys"
}