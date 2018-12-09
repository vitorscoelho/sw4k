package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.BS5950_90V14

class BS5950_90 internal constructor(programName: String) : BS5950_90V14 {
    override val activeXComponentName: String = "$programName.cDStBS5950_90"
}