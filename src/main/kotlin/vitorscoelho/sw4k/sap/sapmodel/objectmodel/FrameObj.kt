package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.FrameObjV14

class FrameObj internal constructor(programName: String) : FrameObjV14 {
    override val activeXComponentName: String = "$programName.cFrameObj"
}