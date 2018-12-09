package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v14.sapmodel.edit.EditSolidV14

class EditSolid internal constructor(programName: String) : EditSolidV14 {
    override val activeXComponentName: String = "$programName.cEditSolid"
}