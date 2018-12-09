package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.RespComboV14

class RespCombo internal constructor(programName: String) : RespComboV14 {
    override val activeXComponentName: String = "$programName.cCombo"
}