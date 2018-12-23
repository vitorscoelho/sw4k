package vitorscoelho.sw4k.sap.sapmodel.definitions.functions

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.functions.*

class FuncPSD internal constructor(programName: String) : FuncPSDV15 {
    override val activeXComponentName: String = "$programName.cFunctionPSD"
}

class FuncRS internal constructor(programName: String) : FuncRSV15 {
    override val activeXComponentName: String = "$programName.cFunctionRS"
}

class FuncSS internal constructor(programName: String) : FuncSSV15 {
    override val activeXComponentName: String = "$programName.cFunctionSS"
}

class FuncTH internal constructor(programName: String) : FuncTHV15 {
    override val activeXComponentName: String = "$programName.cFunctionTH"
}