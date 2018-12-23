package vitorscoelho.sw4k.sap.sapmodel.definitions

import vitorscoelho.sw4k.sap.sapmodel.definitions.functions.*
import vitorscoelho.sw4k.sap.sapmodel.definitions.loadcases.*
import vitorscoelho.sw4k.sap.sapmodel.definitions.loadpatterns.*
import vitorscoelho.sw4k.sap.sapmodel.definitions.namedassign.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.*

class BridgeObj(programName: String) : BridgeObjV15 {
    override val activeXComponentName: String = "$programName.cBridgeObj"
}

class ConstraintDef internal constructor(programName: String) : ConstraintDefV15 {
    override val activeXComponentName: String = "$programName.cConstraint"
}

class CoordSys internal constructor(programName: String) : CoordSysV15 {
    override val activeXComponentName: String = "$programName.cCoordSys"
}

class Func internal constructor(programName: String) : FuncV15 {
    override val activeXComponentName: String = "$programName.cFunction"
    override val funcPSD = FuncPSD(programName)
    override val funcRS = FuncRS(programName)
    override val funcSS = FuncSS(programName)
    override val funcTH = FuncTH(programName)
}

class GDispl internal constructor(programName: String) : GDisplV15 {
    override val activeXComponentName: String = "$programName.cGenDispl"
}

class GroupDef internal constructor(programName: String) : GroupDefV15 {
    override val activeXComponentName: String = "$programName.cGroup"
}

class LoadCases internal constructor(programName: String) : LoadCasesV15 {
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

class LoadPatterns internal constructor(programName: String) : LoadPatternsV15 {
    override val activeXComponentName: String = "$programName.cLoadPatterns"

    override val autoSeismic = AutoSeismic(programName)
    override val autoWind = AutoWind(programName)
}

class NamedAssign internal constructor(programName: String) : NamedAssignV15 {
    override val activeXComponentName: String = "$programName.CNamedAssign"

    override val modifierArea = ModifierArea(programName)
    override val modifierCable = ModifierCable(programName)
    override val modifierFrame = ModifierFrame(programName)
    override val releaseFrame = ReleaseFrame(programName)
}

class PatternDef internal constructor(programName: String) : PatternDefV15 {
    override val activeXComponentName: String = "$programName.cPattern"
}

class RespCombo internal constructor(programName: String) : RespComboV15 {
    override val activeXComponentName: String = "$programName.cCombo"
}