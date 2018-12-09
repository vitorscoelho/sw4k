package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.Eurocode_3_2005V14

class Eurocode_3_2005 internal constructor(programName: String) : Eurocode_3_2005V14 {
    override val activeXComponentName: String = "$programName.cDStEurocode_3-2005"
}