package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.LineElmV14

class LineElm internal constructor(programName: String) : LineElmV14 {
    override val activeXComponentName: String = "$programName.cLineElm"
}