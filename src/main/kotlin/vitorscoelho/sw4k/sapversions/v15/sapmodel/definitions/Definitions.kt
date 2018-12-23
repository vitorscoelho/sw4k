package vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.functions.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.loadcases.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.loadpatterns.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.namedassign.*

interface BridgeObjV15 : BridgeObjV14

interface ConstraintDefV15 : ConstraintDefV14

interface CoordSysV15 : CoordSysV14

interface FuncV15 : FuncV14 {
    override val funcPSD: FuncPSDV15
    override val funcRS: FuncRSV15
    override val funcSS: FuncSSV15
    override val funcTH: FuncTHV15
}

interface GDisplV15 : GDisplV14

interface GroupDefV15 : GroupDefV14

interface LoadCasesV15 : LoadCasesV14 {
    override val buckling: BucklingV15
    override val dirHistLinear: DirHistLinearV15
    override val dirHistNonlinear: DirHistNonlinearV15
    override val hyperStatic: HyperStaticV15
    override val modalEigen: ModalEigenV15
    override val modalRitz: ModalRitzV15
    override val modHistLinear: ModHistLinearV15
    override val modHistNonlinear: ModHistNonlinearV15
    override val moving: MovingV15
    override val psd: PSDV15
    override val responseSpectrum: ResponseSpectrumV15
    override val staticLinear: StaticLinearV15
    override val staticLinearMultistep: StaticLinearMultistepV15
    override val staticNonlinear: StaticNonlinearV15
    override val staticNonlinearStaged: StaticNonlinearStagedV15
    override val steadyState: SteadyStateV15
}

interface LoadPatternsV15 : LoadPatternsV14 {
    override val autoSeismic: AutoSeismicV15
    override val autoWind: AutoWindV15
}

interface NamedAssignV15 : NamedAssignV14 {
    override val modifierArea: ModifierAreaV15
    override val modifierCable: ModifierCableV15
    override val modifierFrame: ModifierFrameV15
    override val releaseFrame: ReleaseFrameV15
}

interface PatternDefV15 : PatternDefV14

interface RespComboV15 : RespComboV14