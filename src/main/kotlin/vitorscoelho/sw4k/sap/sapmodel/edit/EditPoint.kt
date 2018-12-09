package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v14.sapmodel.edit.EditPointV14

class EditPoint internal constructor(programName: String) : EditPointV14 {
    override val activeXComponentName: String = "$programName.cEditPoint"
}