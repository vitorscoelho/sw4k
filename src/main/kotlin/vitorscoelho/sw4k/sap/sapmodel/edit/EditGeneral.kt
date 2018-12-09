package vitorscoelho.sw4k.sap.sapmodel.edit

import vitorscoelho.sw4k.sapversions.v14.sapmodel.edit.EditGeneralV14

class EditGeneral internal constructor(programName: String) : EditGeneralV14 {
    override val activeXComponentName: String = "$programName.cEditGeneral"
}