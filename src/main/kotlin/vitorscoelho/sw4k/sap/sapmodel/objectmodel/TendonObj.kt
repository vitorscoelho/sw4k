package vitorscoelho.sw4k.sap.sapmodel.objectmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.objectmodel.TendonObjV14

class TendonObj internal constructor(programName: String) : TendonObjV14 {
    override val activeXComponentName: String = "$programName.cTendonObj"
}