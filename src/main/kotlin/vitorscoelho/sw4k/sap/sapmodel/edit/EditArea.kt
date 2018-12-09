package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v14.sapmodel.edit.EditAreaV14

class EditArea internal constructor(programName: String) : EditAreaV14 {
    override val activeXComponentName: String = "$programName.cEditArea"
}