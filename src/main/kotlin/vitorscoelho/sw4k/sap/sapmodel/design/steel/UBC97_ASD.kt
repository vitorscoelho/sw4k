package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.UBC97_ASDV14

class UBC97_ASD internal constructor(programName: String) : UBC97_ASDV14 {
    override val activeXComponentName: String = "$programName.cDStUBC97-ASD"
}