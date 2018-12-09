package vitorscoelho.sw4k.sap.sapmodel.bridgeadvanced

import vitorscoelho.sw4k.sapversions.v14.sapmodel.bridgeadvanced.BASConcBoxV14


class BASConcBox internal constructor(programName: String) : BASConcBoxV14 {
    override val activeXComponentName: String = "$programName.cBASConcBox"
}