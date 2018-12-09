package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.API_RP2A_WSD2000V14

class API_RP2A_WSD2000 internal constructor(programName: String) : API_RP2A_WSD2000V14 {
    override val activeXComponentName: String = "$programName.cDStAPI_RP2A_WSD2000"
}