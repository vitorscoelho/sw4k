package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases.*
import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.LoadCasesV14

class LoadCases internal constructor(programName: String) : LoadCasesV14 {
    override val activeXComponentName: String = "$programName.cLoadCases"
    override val buckling = Buckling(programName)
    override val dirHistLinear = DirHistLinear(programName)
    override val dirHistNonlinear = DirHistNonlinear(programName)
    override val hyperStatic = HyperStatic(programName)
    override val modalEigen = ModalEigen(programName)
    override val modalRitz = ModalRitz(programName)
    override val modHistLinear = ModHistLinear(programName)
    override val modHistNonlinear = ModHistNonlinear(programName)
    override val moving = Moving(programName)
    override val psd = PSD(programName)
    override val responseSpectrum = ResponseSpectrum(programName)
    override val staticLinear = StaticLinear(programName)
    override val staticLinearMultistep = StaticLinearMultistep(programName)
    override val staticNonlinear = StaticNonlinear(programName)
    override val staticNonlinearStaged = StaticNonlinearStaged(programName)
    override val steadyState = SteadyState(programName)
}