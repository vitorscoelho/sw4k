package vitorscoelho.sw4k.sap

import vitorscoelho.sw4k.sap.sapmodel.analysismodel.*
import vitorscoelho.sw4k.sap.sapmodel.analysisresults.Results
import vitorscoelho.sw4k.sap.sapmodel.definitions.*
import vitorscoelho.sw4k.sap.sapmodel.definitions.properties.*
import vitorscoelho.sw4k.sap.sapmodel.edit.*
import vitorscoelho.sw4k.sap.sapmodel.objectmodel.*
import vitorscoelho.sw4k.sap.sapmodel.*
import vitorscoelho.sw4k.sapversions.v14.SapModelV14

class SapModel internal constructor(programName: String) : SapModelV14 {
    override val activeXComponentName: String = "$programName.cSapModel"
    override val areaElm = AreaElm(programName)
    override val lineElm = LineElm(programName)
    override val linkElm = LinkElm(programName)
    override val planeElm = PlaneElm(programName)
    override val pointElm = PointElm(programName)
    override val solidElm = SolidElm(programName)
    override val editArea = EditArea(programName)
    override val editFrame = EditFrame(programName)
    override val editGeneral = EditGeneral(programName)
    override val editPoint = EditPoint(programName)
    override val editSolid = EditSolid(programName)
    override val file = File(programName)
    override val bridgeObj = BridgeObj(programName)
    override val respCombo = RespCombo(programName)
    override val constraintDef = ConstraintDef(programName)
    override val coordSys = CoordSys(programName)
    override val func = Func(programName)
    override val gDispl = GDispl(programName)
    override val groupDef = GroupDef(programName)
    override val patternDef = PatternDef(programName)
    override val loadCases = LoadCases(programName)
    override val loadPatterns = LoadPatterns(programName)
    override val namedAssign = NamedAssign(programName)
    override val propArea = PropArea(programName)
    override val propCable = PropCable(programName)
    override val propFrame = PropFrame(programName)
    override val propMaterial = PropMaterial(programName)
    override val propLink = PropLink(programName)
    override val propSolid = PropSolid(programName)
    override val propTendon = PropTendon(programName)
    override val areaObj = AreaObj(programName)
    override val cableObj = CableObj(programName)
    override val frameObj = FrameObj(programName)
    override val linkObj = LinkObj(programName)
    override val pointObj = PointObj(programName)
    override val solidObj = SolidObj(programName)
    override val tendonObj = TendonObj(programName)
    override val analyze = Analyze(programName)
    override val results = Results(programName)
    override val select = Select(programName)
    override val options = Options(programName)
    override val view = View(programName)
    override val bridgeAdvancedSuper = BridgeAdvancedSuper(programName)
}