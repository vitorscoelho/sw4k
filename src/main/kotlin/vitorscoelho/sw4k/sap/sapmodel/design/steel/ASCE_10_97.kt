package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.ASCE_10_97V14

class ASCE_10_97 internal constructor(programName: String) : ASCE_10_97V14 {
    override val activeXComponentName: String = "$programName.cDStASCE_10-97"
}