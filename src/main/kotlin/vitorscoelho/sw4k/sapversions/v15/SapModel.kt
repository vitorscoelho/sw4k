package vitorscoelho.sw4k.sapversions.v15

import vitorscoelho.sw4k.sapversions.v14.SapModelV14
import vitorscoelho.sw4k.sapversions.v15.sapmodel.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.analysismodel.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.analysisresults.ResultsV15
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.design.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.edit.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.objectmodel.*

interface SapModelV15 : SapModelV14 {
    override val areaElm: AreaElmV15
    override val lineElm: LineElmV15
    override val linkElm: LinkElmV15
    override val planeElm: PlaneElmV15
    override val pointElm: PointElmV15
    override val solidElm: SolidElmV15
    override val editArea: EditAreaV15
    override val editFrame: EditFrameV15
    override val editGeneral: EditGeneralV15
    override val editPoint: EditPointV15
    override val editSolid: EditSolidV15
    override val file: FileV15
    override val bridgeObj: BridgeObjV15
    override val respCombo: RespComboV15
    override val constraintDef: ConstraintDefV15
    override val coordSys: CoordSysV15
    override val func: FuncV15
    override val gDispl: GDisplV15
    override val groupDef: GroupDefV15
    override val patternDef: PatternDefV15
    override val loadCases: LoadCasesV15
    override val loadPatterns: LoadPatternsV15
    override val namedAssign: NamedAssignV15
    override val propArea: PropAreaV15
    override val propCable: PropCableV15
    override val propFrame: PropFrameV15
    override val propMaterial: PropMaterialV15
    override val propLink: PropLinkV15
    override val propSolid: PropSolidV15
    override val propTendon: PropTendonV15
    override val areaObj: AreaObjV15
    override val cableObj: CableObjV15
    override val frameObj: FrameObjV15
    override val linkObj: LinkObjV15
    override val pointObj: PointObjV15
    override val solidObj: SolidObjV15
    override val tendonObj: TendonObjV15
    override val analyze: AnalyzeV15
    override val results: ResultsV15
    override val designSteel: DesignSteelV15
    override val designConcrete: DesignConcreteV15
    override val designAluminum: DesignAluminumV15
    override val designColdFormed: DesignColdFormedV15
    override val select: SelectV15
    override val options: OptionsV15
    override val view: ViewV15
    override val bridgeAdvancedSuper: BridgeAdvancedSuperV15
}