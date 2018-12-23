package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v15.sapmodel.analysismodel.*

class AreaElm internal constructor(programName: String) : AreaElmV15 {
    override val activeXComponentName: String = "$programName.cAreaElm"
}

class LineElm internal constructor(programName: String) : LineElmV15 {
    override val activeXComponentName: String = "$programName.cLineElm"
}

class LinkElm internal constructor(programName: String) : LinkElmV15 {
    override val activeXComponentName: String = "$programName.cLinkElm"
}

class PlaneElm internal constructor(programName: String) : PlaneElmV15 {
    override val activeXComponentName: String = "$programName.cPlaneElm"
}

class PointElm internal constructor(programName: String) : PointElmV15 {
    override val activeXComponentName: String = "$programName.cPointElm"
}

class SolidElm internal constructor(programName: String) : SolidElmV15 {
    override val activeXComponentName: String = "$programName.cSolidElm"
}