package vitorscoelho.sw4k.sap.sapmodel.analysismodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.analysismodel.PlaneElmV14


class PlaneElm internal constructor(programName: String) : PlaneElmV14 {
    override val activeXComponentName: String = "$programName.cPlaneElm"
}