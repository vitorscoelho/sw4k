package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.OptionsV14

class Options internal constructor(programName: String) : OptionsV14 {
    override val activeXComponentName: String = "$programName.cOptions"
}