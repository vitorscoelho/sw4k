package vitorscoelho.sw4k.sap.sapmodel.definitions.properties

import vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propframe.*
import vitorscoelho.sw4k.sap.sapmodel.definitions.properties.propmaterial.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.*

class PropArea internal constructor(programName: String) : PropAreaV15 {
    override val activeXComponentName: String = "$programName.cPropArea"
}

class PropCable internal constructor(programName: String) : PropCableV15 {
    override val activeXComponentName: String = "$programName.cPropCable"
}

class PropFrame internal constructor(programName: String) : PropFrameV15 {
    override val activeXComponentName: String = "$programName.cPropFrame"

    override val sdShape = SDShape(programName)
}

class PropLink internal constructor(programName: String) : PropLinkV15 {
    override val activeXComponentName: String = "$programName.cPropLink"
}

class PropMaterial internal constructor(programName: String) : PropMaterialV15 {
    override val activeXComponentName: String = "$programName.cPropMaterial"

    override val timeDep = TimeDep(programName)
}

class PropSolid internal constructor(programName: String) : PropSolidV15 {
    override val activeXComponentName: String = "$programName.cPropSolid"
}

class PropTendon internal constructor(programName: String) : PropTendonV15 {
    override val activeXComponentName: String = "$programName.cPropTendon"
}