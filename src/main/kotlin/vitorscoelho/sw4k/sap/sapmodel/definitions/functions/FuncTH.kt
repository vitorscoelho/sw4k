package vitorscoelho.sw4k.sap.sapmodel.definitions.functions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions.FuncTHV14


class FuncTH internal constructor(programName: String) : FuncTHV14 {
    override val activeXComponentName: String = "$programName.cFunctionTH"
}