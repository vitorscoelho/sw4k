package vitorscoelho.sw4k.sap.sapmodel.definitions.functions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.functions.FuncPSDV14

class FuncPSD internal constructor(programName: String) : FuncPSDV14 {
    override val activeXComponentName: String = "$programName.cFunctionPSD"
}