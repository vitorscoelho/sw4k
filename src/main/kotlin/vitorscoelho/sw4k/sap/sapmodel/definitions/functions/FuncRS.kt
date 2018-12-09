package vitorscoelho.sw4k.sap.sapmodel.definitions.functions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions.FuncRSV14


class FuncRS internal constructor(programName: String) : FuncRSV14 {
    override val activeXComponentName: String = "$programName.cFunctionRS"
}