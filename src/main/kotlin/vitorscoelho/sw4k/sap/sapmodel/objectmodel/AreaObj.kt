package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.AreaObjV14

class AreaObj internal constructor(programName: String) : AreaObjV14 {
    override val activeXComponentName: String = "$programName.cAreaObj"
}