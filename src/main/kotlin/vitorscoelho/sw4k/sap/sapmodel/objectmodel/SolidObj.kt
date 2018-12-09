package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.SolidObjV14

class SolidObj internal constructor(programName: String) : SolidObjV14 {
    override val activeXComponentName: String = "$programName.cSolidObj"
}