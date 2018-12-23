package vitorscoelho.sw4k.sap.sapmodel.bridgeadvanced

import vitorscoelho.sw4k.sapversions.v15.sapmodel.bridgeadvanced.BASConcBoxV15

class BASConcBox internal constructor(programName: String) : BASConcBoxV15 {
    override val activeXComponentName: String = "$programName.cBASConcBox"
}