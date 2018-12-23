package vitorscoelho.sw4k.sapversions.v15.sapmodel

import vitorscoelho.sw4k.sapversions.v14.sapmodel.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.bridgeadvanced.BASConcBoxV15

interface AnalyzeV15 : AnalyzeV14

interface BridgeAdvancedSuperV15 : BridgeAdvancedSuperV14 {
    override val basConcBox: BASConcBoxV15
}

interface FileV15 : FileV14

interface OptionsV15 : OptionsV14

interface SelectV15 : SelectV14

interface ViewV15 : ViewV14