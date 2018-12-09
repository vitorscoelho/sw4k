package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.ACI_318_05_IBC_2003V14

class ACI_318_05_IBC_2003 internal constructor(programName: String) : ACI_318_05_IBC_2003V14 {
    override val activeXComponentName: String = "$programName.cDCoACI_318-05_IBC_2003"
}