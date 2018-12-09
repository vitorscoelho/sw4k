package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.PSDV14


class PSD internal constructor(programName: String) : PSDV14 {
    override val activeXComponentName: String = "$programName.cCasePowerSpectralDensity"
}