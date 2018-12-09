package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignSteelV14

class DesignSteel internal constructor(programName: String) : DesignSteelV14 {
    override val activeXComponentName: String = "$programName.cDesignSteel"
}