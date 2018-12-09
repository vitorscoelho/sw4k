package vitorscoelho.sw4k.sap.sapmodel.design.concrete

import vitorscoelho.sw4k.sapversions.v14.sapmodel.design.concrete.BS8110_89V14

class BS8110_89 internal constructor(programName: String) : BS8110_89V14 {
    override val activeXComponentName: String = "$programName.cDCoBS8110_89"
}