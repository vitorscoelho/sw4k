package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v14.sapmodel.edit.EditFrameV14

class EditFrame internal constructor(programName: String) : EditFrameV14 {
    override val activeXComponentName: String = "$programName.cEditFrame"
}