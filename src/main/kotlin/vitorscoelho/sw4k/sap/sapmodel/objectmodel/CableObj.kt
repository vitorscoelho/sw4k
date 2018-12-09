package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.CableObjV14

class CableObj internal constructor(programName: String) : CableObjV14 {
    override val activeXComponentName: String = "$programName.cCableObj"
}