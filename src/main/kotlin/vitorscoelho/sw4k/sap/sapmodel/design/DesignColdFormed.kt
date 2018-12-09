package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignColdFormedV14

class DesignColdFormed internal constructor(programName: String) : DesignColdFormedV14 {
    override val activeXComponentName: String = "$programName.cDesignColdFormed"
}