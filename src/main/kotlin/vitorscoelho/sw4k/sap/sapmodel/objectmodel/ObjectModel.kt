package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v15.sapmodel.objectmodel.*

class AreaObj internal constructor(programName: String) : AreaObjV15 {
    override val activeXComponentName: String = "$programName.cAreaObj"
}

class CableObj internal constructor(programName: String) : CableObjV15 {
    override val activeXComponentName: String = "$programName.cCableObj"
}

class FrameObj internal constructor(programName: String) : FrameObjV15 {
    override val activeXComponentName: String = "$programName.cFrameObj"
}

class LinkObj internal constructor(programName: String) : LinkObjV15 {
    override val activeXComponentName: String = "$programName.cLinkObj"
}

class PointObj internal constructor(programName: String) : PointObjV15 {
    override val activeXComponentName: String = "$programName.cPointObj"
}


class SolidObj internal constructor(programName: String) : SolidObjV15 {
    override val activeXComponentName: String = "$programName.cSolidObj"
}

class TendonObj internal constructor(programName: String) : TendonObjV15 {
    override val activeXComponentName: String = "$programName.cTendonObj"
}