package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.LinkObjV14

class LinkObj internal constructor(programName: String) : LinkObjV14 {
    override val activeXComponentName: String = "$programName.cLinkObj"
}