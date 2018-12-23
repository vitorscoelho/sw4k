package vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.loadcases.*


class Buckling internal constructor(programName: String) : BucklingV15 {
    override val activeXComponentName: String = "$programName.cCaseBuckling"
}

class DirHistLinear internal constructor(programName: String) : DirHistLinearV15 {
    override val activeXComponentName: String = "$programName.cCaseDirectHistoryLinear"
}

class DirHistNonlinear internal constructor(programName: String) : DirHistNonlinearV15 {
    override val activeXComponentName: String = "$programName.cCaseDirectHistoryNonlinear"
}

class HyperStatic internal constructor(programName: String) : HyperStaticV15 {
    override val activeXComponentName: String = "$programName.cCaseHyperStatic"
}

class ModalEigen internal constructor(programName: String) : ModalEigenV15 {
    override val activeXComponentName: String = "$programName.cCaseModalEigen"
}

class ModalRitz internal constructor(programName: String) : ModalRitzV15 {
    override val activeXComponentName: String = "$programName.cCaseModalRitz"
}

class ModHistLinear internal constructor(programName: String) : ModHistLinearV15 {
    override val activeXComponentName: String = "$programName.cCaseModalHistoryLinear"
}

class ModHistNonlinear internal constructor(programName: String) : ModHistNonlinearV15 {
    override val activeXComponentName: String = "$programName.cCaseModalHistoryNonlinear"
}

class Moving internal constructor(programName: String) : MovingV15 {
    override val activeXComponentName: String = "$programName.cCaseMovingLoad"
}

class PSD internal constructor(programName: String) : PSDV15 {
    override val activeXComponentName: String = "$programName.cCasePowerSpectralDensity"
}

class ResponseSpectrum internal constructor(programName: String) : ResponseSpectrumV15 {
    override val activeXComponentName: String = "$programName.cCaseResponseSpectrum"
}

class StaticLinear internal constructor(programName: String) : StaticLinearV15 {
    override val activeXComponentName: String = "$programName.cCaseStaticLinear"
}

class StaticLinearMultistep internal constructor(programName: String) : StaticLinearMultistepV15 {
    override val activeXComponentName: String = "$programName.cCaseStaticLinearMultistep"
}

class StaticNonlinear internal constructor(programName: String) : StaticNonlinearV15 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonLinear"
}

class StaticNonlinearStaged internal constructor(programName: String) : StaticNonlinearStagedV15 {
    override val activeXComponentName: String = "$programName.cCaseStaticNonlinearStaged"
}

class SteadyState internal constructor(programName: String) : SteadyStateV15 {
    override val activeXComponentName: String = "$programName.cCaseSteadyState"
}