package vitorscoelho.sw4k.sap14.definitions.properties

import vitorscoelho.sw4k.comutils.*

class PropArea(programName: String) : PropAreaV14 {
    override val activeXComponentName: String = "$programName.cPropArea"
}

interface PropAreaV14 : SapComponent {
}