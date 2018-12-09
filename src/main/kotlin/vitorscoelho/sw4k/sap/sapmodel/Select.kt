package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.SelectV14

class Select internal constructor(programName: String) : SelectV14 {
    override val activeXComponentName: String = "$programName.cSelect"
}