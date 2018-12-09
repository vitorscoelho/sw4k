package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.AreaElmV14

class AreaElm internal constructor(programName: String) : AreaElmV14 {
    override val activeXComponentName: String = "$programName.cAreaElm"
}