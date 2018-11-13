package vitorscoelho.sw4k

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sap14.SapObject
import vitorscoelho.sw4k.comutils.dlls.LoaderJacobDll
import vitorscoelho.sw4k.sap14.enums.*
import kotlin.math.pow

fun main() {
    LoaderJacobDll.load()

    println("Hello")
    //Iniciando o SAP2000
    val sapObject = SapObject()
    val sapModel = sapObject.sapModel
    sapObject.applicationStart()
    sapModel.initializeNewModel(units = Units.kN_cm_C.sapId)
    sapModel.file.newBlank()

    //Definição dos materiais
    sapModel.propMaterial.setMaterial(name = "Concreto", matType = MatType.MATERIAL_CONCRETE.sapId, color = 25, notes = "Notas e notas")
    sapModel.propMaterial.setMPIsotropic(name = "Concreto", e = 22100.0, u = 0.2, a = 0.00001)
    sapModel.propMaterial.setWeightAndMass(name = "Concreto", myOption = WeightOrMass.WEIGHT_PER_UNIT_VOLUME.sapId, value = 25.0 / 100.0.pow(3))
    val matTypeRef = IntByRef()
    val colorRef = IntByRef(1)
    val notesRef = StringByRef("")
    val guidRef = StringByRef("")
    sapModel.propMaterial.getMaterial(name = "Concreto", matType = matTypeRef, color = colorRef, notes = notesRef, GUID = guidRef)
    println("MatType: ${MatType.get(sapId = matTypeRef.value)}")
    println("Color: ${colorRef.value}")
    println("Notes: ${notesRef.value}")

    //Definição das seções transversais
    sapModel.propFrame.setRectangle(name = "Seção", matProp = "Concreto", t3 = 20.0, t2 = 100.0)
    sapModel.propFrame.setCircle("Secao Circular", matProp = "Concreto", t3 = 26.0)
    sapModel.propFrame.setPrecastI(name = "SeçãoI", matProp = "Concreto", b = doubleArrayOf(10.0, 20.0, 30.0, 40.0).byRef(), d = doubleArrayOf(100.0, 200.0, 300.0, 400.0, 500.0, 600.0).byRef())

    val matPropByRef = StringByRef()
    val fileNameByRef = StringByRef()
    val bByRef = DoubleArrayByRef()
    val dByRef = DoubleArrayByRef()
    val colorIByRef = IntByRef()
    val notesIByRef = StringByRef()
    val guidIByRef = StringByRef()
    sapModel.propFrame.getPrecastI(name = "SeçãoI", matProp = matPropByRef, fileName = fileNameByRef, b = bByRef, d = dByRef, color = colorIByRef, notes = notesIByRef, GUID = guidIByRef)
    println("____SEÇÃO I____")
    println("MatProp: ${matPropByRef.value}")
    println("FileName: ${fileNameByRef.value}")
    println("B1: ${bByRef[0]}")
    println("B2: ${bByRef[1]}")
    println("B3: ${bByRef[2]}")
    println("B4: ${bByRef[3]}")
    println("D1: ${dByRef[0]}")
    println("D2: ${dByRef[1]}")
    println("D3: ${dByRef[2]}")
    println("D4: ${dByRef[3]}")
    println("D5: ${dByRef[4]}")
    println("D6: ${dByRef[5]}")
    println("_______________")


    //Definição dos pontos
    val larguraAduela = 220.0
    val alturaAduela = 170.0
    val stringByRef = StringByRef()
    sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = 0.0, name = StringByRef())
    sapModel.pointObj.addCartesian(x = larguraAduela, y = 0.0, z = 0.0, name = StringByRef())
    sapModel.pointObj.addCartesian(x = larguraAduela, y = 0.0, z = alturaAduela, name = stringByRef)
    sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = alturaAduela, name = StringByRef())
    println(stringByRef.value)

    //Definição das barras através das coordenadas dos pontos
    sapModel.frameObj.addByPoint(point1 = "1", point2 = "2", userName = "HI", propName = "Seção", name = StringByRef())
    sapModel.frameObj.addByPoint(point1 = "4", point2 = "3", userName = "HS", propName = "Seção", name = StringByRef())
    sapModel.frameObj.addByPoint(point1 = "1", point2 = "4", userName = "VE", propName = "Seção", name = StringByRef())
    sapModel.frameObj.addByPoint(point1 = "2", point2 = "3", userName = "VD", propName = "Seção", name = StringByRef())
    sapModel.frameObj.setOutputStations(name = "HS", myType = OutputStationType.MAXIMUM_SEGMENT_SIZE.sapId, maxSegSize = 0.1, minSections = 50)
    val barra = StringByRef()
//    sapModel.frameObj.addByCoord(xi = 100.0, yi = 200.0, zi = 300.0, xj = 400.0, yj = 500.0, zj = 600.0, name = barra)
    println(barra.value)

    //Definição de restrições
    sapModel.pointObj.setRestraint(name = "1", value = booleanArrayOf(true, true, true, true, true, true).byRef())

    //Definição de mola
    sapModel.pointObj.setSpring(name = "2", k = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).byRef())

//    //Mola usando link
//
    //Definição dos LoadPatterns
    sapModel.loadPatterns.add(name = "peso próprio", myType = LoadPatternType.LTYPE_DEAD.sapId, selfWTMultiplier = 1.0)
    sapModel.loadPatterns.add(name = "permanente", myType = LoadPatternType.LTYPE_DEAD.sapId)
    sapModel.loadPatterns.add(name = "acidental", myType = LoadPatternType.LTYPE_DEAD.sapId)
    sapModel.loadPatterns.add(name = "acidental sem case", myType = LoadPatternType.LTYPE_DEAD.sapId, addLoadCase = false)

    //Aplicação de cargas em pontos
    sapModel.pointObj.setLoadForce(name = "3", loadPat = "acidental", value = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).byRef())

    //Aplicação de cargas distribuídas
    sapModel.frameObj.setLoadDistributed(
            name = "VE",
            loadPat = "acidental",
            myType = DistributedLoadType.MOMENT_PER_UNIT_LENGTH.sapId,
            dir = Dir.X_DIRECTION.sapId,
            dist1 = 20.0,
            dist2 = 120.0,
            val1 = 1.0,
            val2 = 2.5,
            relDist = false
    )

    //Definição de Linear Cases
    sapModel.loadCases.staticLinear.setCase(name = "Caso1")
    sapModel.loadCases.staticLinear.setLoads(
            name = "Caso1",
            numberLoads = 3,
            loadType = arrayOf(LoadType.LOAD, LoadType.LOAD, LoadType.LOAD).toSapId().byRef(),
            loadName = arrayOf("permanente", "acidental", "permanente").byRef(),
            sF = doubleArrayOf(1.2, 2.3, 0.5).byRef()
    )

    //Definição de NonLinear Cases
    sapModel.loadCases.staticNonLinear.setCase(name = "Caso2")
    sapModel.loadCases.staticNonLinear.setLoads(
            name = "Caso2",
            numberLoads = 3,
            loadType = arrayOf(LoadType.LOAD, LoadType.LOAD, LoadType.LOAD).toSapId().byRef(),
            loadName = arrayOf("permanente", "acidental", "permanente").byRef(),
            sF = doubleArrayOf(2.2, -1.3, 0.5).byRef()
    )
    sapModel.loadCases.staticNonLinear.setGeometricNonlinearity(name = "Caso2", nLGeomType = NLGeomType.P_DELTA.sapId)

    //Definição de Combinations
    sapModel.respCombo.add("Envoltoria1", comboType = ComboType.ENVELOPE.sapId)
    sapModel.respCombo.setCaseList(name = "Envoltoria1", cType = CType.LOAD_CASE.sapId, cName = "Caso1", sF = 1.2)
    sapModel.respCombo.setCaseList(name = "Envoltoria1", cType = CType.LOAD_CASE.sapId, cName = "Caso2", sF = 0.9)
    sapModel.respCombo.add(name = "Combinação Add1", comboType = ComboType.ENVELOPE.sapId)
    sapModel.respCombo.setCaseList(name = "Combinação Add1", cType = CType.LOAD_CASE.sapId, cName = "Caso1", sF = 1.0)
    sapModel.respCombo.setCaseList(name = "Combinação Add1", cType = CType.LOAD_CASE.sapId, cName = "Caso2", sF = 1.3)
    sapModel.respCombo.setType(name = "Combinação Add1", comboType = ComboType.LINEAR_ADDITIVE.sapId)

    //Salvar arquivo
    sapModel.file.save(fileName = "C:\\Users\\vitor\\Desktop\\SAPKotlin\\SapKotlin.sdb")
//    sapModel.file.openFile(fileName = "C:\\Users\\vitor\\Desktop\\SAPKotlin\\SapKotlin.sdb")

    //Processamento da estrutura
    sapModel.analyze.setActiveDOF(DOF = booleanArrayOf(true, false, true, false, true, false).byRef())
    sapModel.analyze.setRunCaseFlag(name = "Caso1", run = false)
    sapModel.analyze.runAnalysis()

    //Coleta de resultados para Cases e Combinations
    sapModel.results.setup.deselectAllCasesAndCombosForOutput()
    sapModel.results.setup.setCaseSelectedForOutput(name = "Caso2")
    val numberResults = IntByRef()
    val elmSta = DoubleArrayByRef()
    val m3ByRef = DoubleArrayByRef()
    println("Resultado função FrameForce: ${sapModel.results.frameForce(
            name = "HS",
            itemTypeElm = ItemTypeElm.OBJECT_ELM.sapId,
            numberResults = numberResults,
            obj = StringArrayByRef(),
            objSta = DoubleArrayByRef(),
            elm = StringArrayByRef(),
            elmSta = elmSta,
            loadCase = StringArrayByRef(),
            stepType = StringArrayByRef(),
            stepNum = DoubleArrayByRef(),
            p = DoubleArrayByRef(),
            v2 = DoubleArrayByRef(),
            v3 = DoubleArrayByRef(),
            t = DoubleArrayByRef(),
            m2 = DoubleArrayByRef(),
            m3 = m3ByRef
    )}")
    println("Qtd. resultados= ${numberResults.value}")
    println("x= ${elmSta[10]} -> momento= ${m3ByRef[10]}")

    //Destrava a análise
//    sapModel.setModelIsLocked(lockIt = false)

    //Fechar SAP
//    sapObject.applicationExit(fileSave = true)

//    //TODO descobrir o motivo da parte que está abaixo estar travando
//    val sapObject2 = SapObject()
//    val sapModel2 = sapObject2.sapModel
//    sapObject2.applicationStart()
//    sapModel2.initializeNewModel(units = Units.kN_cm_C.sapId)
//    sapModel2.file.newBlank()
//    sapModel2.file.openFile(fileName = "C:\\Users\\vitor\\Desktop\\SAPKotlin\\SapKotlin.sdb")
}