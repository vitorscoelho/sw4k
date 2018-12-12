package vitorscoelho.sw4k.sap.sapmodel.design

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.DesignAluminumV14
import vitorscoelho.sw4k.sap.sapmodel.design.aluminum.*

class DesignAluminum internal constructor(programName: String) : DesignAluminumV14 {
    override val activeXComponentName: String = "$programName.cDesignAluminum"

    override val AA_ASD_2000 = AA_ASD_2000(programName)
    override val AA_LRFD_2000 = AA_LRFD_2000(programName)
}