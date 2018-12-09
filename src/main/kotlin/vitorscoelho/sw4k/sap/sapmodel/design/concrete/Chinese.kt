package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.ChineseV14

class Chinese internal constructor(programName: String) : ChineseV14 {
    override val activeXComponentName: String = "$programName.cDCoChinese"
}