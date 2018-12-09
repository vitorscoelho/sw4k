package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.PointElmV14

class PointElm internal constructor(programName: String) : PointElmV14 {
    override val activeXComponentName: String = "$programName.cPointElm"
}