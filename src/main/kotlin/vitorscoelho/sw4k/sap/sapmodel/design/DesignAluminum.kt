package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignAluminumV14

class DesignAluminum internal constructor(programName: String) : DesignAluminumV14 {
    override val activeXComponentName: String = "$programName.cDesignAluminum"
}