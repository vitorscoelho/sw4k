package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignConcreteV14

class DesignConcrete internal constructor(programName: String) : DesignConcreteV14 {
    override val activeXComponentName: String = "$programName.cDesignConcrete"
}