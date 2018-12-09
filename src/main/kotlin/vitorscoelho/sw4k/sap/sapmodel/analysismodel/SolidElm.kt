package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.SolidElmV14


class SolidElm internal constructor(programName: String) : SolidElmV14 {
    override val activeXComponentName: String = "$programName.cSolidElm"
}