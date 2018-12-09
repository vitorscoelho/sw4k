package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.KCI_1999V14

class KCI_1999 internal constructor(programName: String) : KCI_1999V14 {
    override val activeXComponentName: String = "$programName.cDCoKCI_1999"
}