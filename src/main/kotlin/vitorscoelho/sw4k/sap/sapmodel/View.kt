package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.ViewV14

class View internal constructor(programName: String) : ViewV14 {
    override val activeXComponentName: String = "$programName.cView"
}