package vitorscoelho.sw4k.sap.sapmodel.definitions.functions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions.FuncSSV14

class FuncSS internal constructor(programName: String) : FuncSSV14 {
    override val activeXComponentName: String = "$programName.cFunctionSS"
}