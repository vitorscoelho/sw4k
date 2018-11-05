package vitorscoelho.sw4k

import vitorscoelho.sw4k.comutils.StringByRef
import vitorscoelho.sw4k.comutils.byRef
import vitorscoelho.sw4k.sap14.SapObject
import vitorscoelho.sw4k.sap14.enums.*
import kotlin.math.pow

fun main() {
    println("Hello")
    //Iniciando o SAP2000
    val sapObject = SapObject()
    val sapModel = sapObject.sapModel
    sapObject.applicationStart(units = Units.kN_cm_C)
    sapModel.initializeNewModel()
    sapModel.file.newBlank()

    //Definição dos materiais
    sapModel.propMaterial.setMaterial(name = "Concreto", matType = MatType.MATERIAL_CONCRETE)
    sapModel.propMaterial.setMPIsotropic(name = "Concreto", e = 22100.0, u = 0.2, a = 0.00001)
    sapModel.propMaterial.setWeightAndMass(name = "Concreto", myOption = MyOption.WEIGHT_PER_UNIT_VOLUME, value = 25.0 / 100.0.pow(3))

    //Definição das seções transversais
    sapModel.propFrame.setRectangle(name = "Seção", matProp = "Concreto", t3 = 20.0, t2 = 100.0)
    sapModel.propFrame.setPrecastI(name = "SeçãoI", matProp = "Concreto", b = doubleArrayOf(10.0, 10.0, 10.0).byRef(), d = doubleArrayOf(10.0, 10.0, 10.0, 10.0, 10.0, 10.0).byRef())

    //Definição dos pontos
    val larguraAduela = 220.0
    val alturaAduela = 170.0
    val stringByRef = StringByRef()
    sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = 0.0)
    sapModel.pointObj.addCartesian(x = larguraAduela, y = 0.0, z = 0.0)
    sapModel.pointObj.addCartesian(x = larguraAduela, y = 0.0, z = alturaAduela, name = stringByRef)
    sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = alturaAduela)
    println(stringByRef.value)

    //Definição das barras através das coordenadas dos pontos
    sapModel.frameObj.addByPoint(point1 = "1", point2 = "2", userName = "HI", propName = "Seção")
    sapModel.frameObj.addByPoint(point1 = "4", point2 = "3", userName = "HS", propName = "Seção")
    sapModel.frameObj.addByPoint(point1 = "1", point2 = "4", userName = "VE", propName = "Seção")
    sapModel.frameObj.addByPoint(point1 = "2", point2 = "3", userName = "VD", propName = "Seção")
    sapModel.frameObj.setOutputStations(name = "HS", myType = MyType.MAXIMUM_SEGMENT_SIZE, maxSegSize = 0.1, minSections = 50)
    val barra = StringByRef()
    sapModel.frameObj.addByCoord(xi = 100.0, yi = 200.0, zi = 300.0, xj = 400.0, yj = 500.0, zj = 600.0, name = barra)
    println(barra.value)

    //Definição de restrições
    sapModel.pointObj.setRestraint(name = "1", value = booleanArrayOf(true, true, true, true, true, true).byRef())

    //Definição de mola
    sapModel.pointObj.setSpring(name = "2", k = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).byRef())

    //Mola usando link

    //Definição dos LoadPatterns
    sapModel.loadPatterns.add(name = "peso próprio", myType = LoadPatternType.LTYPE_DEAD, selfWTMultiplier = 1.0)
    sapModel.loadPatterns.add(name = "permanente", myType = LoadPatternType.LTYPE_DEAD)
    sapModel.loadPatterns.add(name = "acidental", myType = LoadPatternType.LTYPE_DEAD)
    sapModel.loadPatterns.add(name = "acidental sem case", myType = LoadPatternType.LTYPE_DEAD, addLoadCase = false)

    //Aplicação de cargas em pontos
    sapModel.pointObj.setLoadForce(name = "3", loadPat = "acidental", value = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0).byRef())

    //Aplicação de cargas distribuídas
    sapModel.frameObj.setLoadDistributed(
            name = "VE",
            loadPat = "acidental",
            myType = DistributedLoadType.MOMENT_PER_UNIT_LENGTH,
            dir = Dir.X_DIRECTION,
            dist1 = 20.0,
            dist2 = 120.0,
            val1 = 1.0,
            val2 = 2.5,
            relDist = false
    )

    //Definição de Linear Cases
    sapModel.loadCases.staticLinear.setCase(name="Caso1")

    //Definição de NonLinear Cases

    //Definição de Combinations

    //Salvar arquivo

    //Processamento da estrutura

    //Coleta de resultados para Cases e Combinations

    //Fechar SAP
}