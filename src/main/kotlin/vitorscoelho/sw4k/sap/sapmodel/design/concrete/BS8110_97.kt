package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.BS8110_97V14

class BS8110_97 internal constructor(programName: String) : BS8110_97V14 {
    override val activeXComponentName: String = "$programName.cDCoBS8110_97"
}