package vitorscoelho.sw4k.sap.sapmodel.design.steel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.steel.Chinese_2002V14

class Chinese_2002 internal constructor(programName: String) : Chinese_2002V14 {
    override val activeXComponentName: String = "$programName.cDStChinese_2002"
}