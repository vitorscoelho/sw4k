package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.LinkElmV14

class LinkElm internal constructor(programName: String) : LinkElmV14 {
    override val activeXComponentName: String = "$programName.cLinkElm"
}