package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.Eurocode_2_1992V14

class Eurocode_2_1992 internal constructor(programName: String) : Eurocode_2_1992V14 {
    override val activeXComponentName: String = "$programName.cDCoEurocode_2_1992"
}