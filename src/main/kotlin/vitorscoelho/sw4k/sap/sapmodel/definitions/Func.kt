package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncPSD
import vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncRS
import vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncSS
import vitorscoelho.sw4k.sap.sapmodel.definitions.functions.FuncTH
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.FuncV14

class Func internal constructor(programName: String) : FuncV14 {
    override val activeXComponentName: String = "$programName.cFunction"
    override val funcPSD = FuncPSD(programName)
    override val funcRS = FuncRS(programName)
    override val funcSS = FuncSS(programName)
    override val funcTH = FuncTH(programName)
}