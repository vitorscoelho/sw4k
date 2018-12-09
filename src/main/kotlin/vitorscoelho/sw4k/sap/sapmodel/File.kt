package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.FileV14

class File internal constructor(programName: String) : FileV14 {
    override val activeXComponentName: String = "$programName.cFile"
}