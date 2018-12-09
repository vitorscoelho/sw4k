package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.UBC97_LRFDV14

class UBC97_LRFD internal constructor(programName: String) : UBC97_LRFDV14 {
    override val activeXComponentName: String = "$programName.cDStUBC97-LRFD"
}