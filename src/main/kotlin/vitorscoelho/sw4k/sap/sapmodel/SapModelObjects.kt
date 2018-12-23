package vitorscoelho.sw4k.sap.sapmodel

import vitorscoelho.sw4k.sap.sapmodel.bridgeadvanced.BASConcBox
import vitorscoelho.sw4k.sapversions.v15.sapmodel.*

class Analyze internal constructor(programName: String) : AnalyzeV15 {
    override val activeXComponentName: String = "$programName.cAnalyze"
}

class BridgeAdvancedSuper internal constructor(programName: String) : BridgeAdvancedSuperV15 {
    override val activeXComponentName: String = "$programName.cBridgeAdvancedSuper"
    override val basConcBox = BASConcBox(programName)
}

class File internal constructor(programName: String) : FileV15 {
    override val activeXComponentName: String = "$programName.cFile"
}

class Options internal constructor(programName: String) : OptionsV15 {
    override val activeXComponentName: String = "$programName.cOptions"
}

class Select internal constructor(programName: String) : SelectV15 {
    override val activeXComponentName: String = "$programName.cSelect"
}

class View internal constructor(programName: String) : ViewV15 {
    override val activeXComponentName: String = "$programName.cView"
}