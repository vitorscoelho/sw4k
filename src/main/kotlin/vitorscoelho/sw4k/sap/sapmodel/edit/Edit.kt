package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v15.sapmodel.edit.*

class EditArea internal constructor(programName: String) : EditAreaV15 {
    override val activeXComponentName: String = "$programName.cEditArea"
}

class EditFrame internal constructor(programName: String) : EditFrameV15 {
    override val activeXComponentName: String = "$programName.cEditFrame"
}

class EditGeneral internal constructor(programName: String) : EditGeneralV15 {
    override val activeXComponentName: String = "$programName.cEditGeneral"
}

class EditPoint internal constructor(programName: String) : EditPointV15 {
    override val activeXComponentName: String = "$programName.cEditPoint"
}

class EditSolid internal constructor(programName: String) : EditSolidV15 {
    override val activeXComponentName: String = "$programName.cEditSolid"
}