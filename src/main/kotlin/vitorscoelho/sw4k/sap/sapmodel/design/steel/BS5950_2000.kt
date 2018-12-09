package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.BS5950_2000V14

class BS5950_2000 internal constructor(programName: String) : BS5950_2000V14 {
    override val activeXComponentName: String = "$programName.cDStBS5950_2000"
}