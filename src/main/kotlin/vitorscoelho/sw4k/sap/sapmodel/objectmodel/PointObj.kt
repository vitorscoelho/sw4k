package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.PointObjV14

class PointObj internal constructor(programName: String) : PointObjV14 {
    override val activeXComponentName: String = "$programName.cPointObj"
}