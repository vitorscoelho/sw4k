package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases.ResponseSpectrumV14


class ResponseSpectrum internal constructor(programName: String) : ResponseSpectrumV14 {
    override val activeXComponentName: String = "$programName.cCaseResponseSpectrum"
}