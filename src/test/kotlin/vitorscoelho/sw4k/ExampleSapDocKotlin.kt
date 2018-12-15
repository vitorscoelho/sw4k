package vitorscoelho.sw4k

import org.junit.Assert
import org.junit.Test
import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.byRef
import vitorscoelho.sw4k.comutils.dlls.LoaderJacobDll
import vitorscoelho.sw4k.sap.SapObject
import vitorscoelho.sw4k.sapenums.*
import java.text.DecimalFormat

class ExampleSapDocKotlin {
    @Test
    fun example() {
        LoaderJacobDll.load() //this is mandatory before anything
        //create Sap2000 object
        val sapObject = SapObject.v14()
        //start Sap2000 application
        sapObject.applicationStart()
        //get sapModel object
        val sapModel = sapObject.sapModel
        //initialize model
        sapModel.initializeNewModel()
        //create new blank model
        sapModel.file.newBlank()
        //define material property
        sapModel.propMaterial.setMaterial(name = "CONC", matType = MatType.CONCRETE.sapId)
        //assign isotropic mechanical properties to material
        sapModel.propMaterial.setMPIsotropic(name = "CONC", e = 3600.0, u = 0.2, a = 0.0000055)
        //define rectangular frame section property
        sapModel.propFrame.setRectangle(name = "R1", matProp = "CONC", t3 = 12.0, t2 = 12.0)
        //define frame section property modifiers
        sapModel.propFrame.setModifiers(name = "R1", value = doubleArrayOf(1000.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0).byRef())
        //add points by coordinates
        sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = 0.0, userName = "Bottom point")
        sapModel.pointObj.addCartesian(x = 0.0, y = 0.0, z = 10.0 * 12.0, userName = "Middle point")
        sapModel.pointObj.addCartesian(x = 8.0 * 12.0, y = 0.0, z = 16.0 * 12.0, userName = "Right point")
        sapModel.pointObj.addCartesian(x = -4.0 * 12.0, y = 0.0, z = 10.0 * 12.0, userName = "Left point")
        //add frame object by points
        sapModel.frameObj.addByPoint(point1 = "Bottom point", point2 = "Middle point", propName = "R1", userName = "1")
        sapModel.frameObj.addByPoint(point1 = "Middle point", point2 = "Right point", propName = "R1", userName = "2")
        sapModel.frameObj.addByPoint(point1 = "Left point", point2 = "Middle point", propName = "R1", userName = "3")
        //assign point object restraint at base
        sapModel.pointObj.setRestraint(
                name = "Bottom point",
                value = booleanArrayOf(true, true, true, true, false, false).byRef()
        )
        //assign point object restraint at top
        sapModel.pointObj.setRestraint(
                name = "Right point",
                value = booleanArrayOf(true, true, false, false, false, false).byRef()
        )
        //refresh view, update (initialize) zoom
        sapModel.view.refreshView(window = 0, zoom = false)
        //switch to k-ft units
        sapModel.setPresentUnits(units = Units.kip_ft_F.sapId)
        //add load patterns
        sapModel.loadPatterns.add(name = "1", myType = LoadPatternType.OTHER.sapId, selfWTMultiplier = 1.0)
        sapModel.loadPatterns.add(name = "2", myType = LoadPatternType.OTHER.sapId)
        sapModel.loadPatterns.add(name = "3", myType = LoadPatternType.OTHER.sapId)
        sapModel.loadPatterns.add(name = "4", myType = LoadPatternType.OTHER.sapId)
        sapModel.loadPatterns.add(name = "5", myType = LoadPatternType.OTHER.sapId)
        sapModel.loadPatterns.add(name = "6", myType = LoadPatternType.OTHER.sapId)
        sapModel.loadPatterns.add(name = "7", myType = LoadPatternType.OTHER.sapId)
        //assign loading for load pattern 2
        sapModel.pointObj.setLoadForce(
                name = "Left point",
                loadPat = "2",
                value = doubleArrayOf(0.0, 0.0, -10.0, 0.0, 0.0, 0.0).byRef()
        )
        sapModel.frameObj.setLoadDistributed(
                name = "3",
                loadPat = "2",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.GRAVITY_DIRECTION.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = 1.8, val2 = 1.8
        )
        //assign loading for load pattern 3
        sapModel.pointObj.setLoadForce(
                name = "Middle point",
                loadPat = "3",
                value = doubleArrayOf(0.0, 0.0, -17.2, 0.0, -54.4, 0.0).byRef()
        )
        //assign loading for load pattern 4
        sapModel.frameObj.setLoadDistributed(
                name = "2",
                loadPat = "4",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.PROJECTED_GRAVITY_DIRECTION.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = 2.0, val2 = 2.0
        )
        //assign loading for load pattern 5
        sapModel.frameObj.setLoadDistributed(
                name = "1",
                loadPat = "5",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.LOCAL_2_AXIS.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = 2.0, val2 = 2.0,
                cSys = "Local"
        )
        sapModel.frameObj.setLoadDistributed(
                name = "2",
                loadPat = "5",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.LOCAL_2_AXIS.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = -2.0, val2 = -2.0,
                cSys = "Local"
        )
        //assign loading for load pattern 6
        sapModel.frameObj.setLoadDistributed(
                name = "1",
                loadPat = "6",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.LOCAL_2_AXIS.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = 0.9984, val2 = 0.3744,
                cSys = "Local"
        )
        sapModel.frameObj.setLoadDistributed(
                name = "2",
                loadPat = "6",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.LOCAL_2_AXIS.sapId,
                dist1 = 0.0, dist2 = 1.0,
                val1 = -0.3744, val2 = 0.0,
                cSys = "Local"
        )
        //assign loading for load pattern 7
        sapModel.frameObj.setLoadPoint(
                name = "2",
                loadPat = "7",
                myType = DistributedLoadType.FORCE_PER_UNIT_LENGTH.sapId,
                dir = Dir.LOCAL_2_AXIS.sapId,
                dist = 0.5, value = -15.0,
                cSys = "Local"
        )
        //switch to k-in units
        sapModel.setPresentUnits(Units.kip_in_F.sapId)
        //save model
        sapModel.file.save("C:\\SapApiV14\\API_1-001.sdb")
        //run model (this will create the analysis model)
        sapModel.analyze.runAnalysis()
        //initialize for Sap2000 results
        val sapResults = DoubleArray(size = 7)
        //get Sap2000 results for load patterns 1 through 7
        (0..6).forEach { i ->
            sapModel.results.setup.deselectAllCasesAndCombosForOutput()
            sapModel.results.setup.setCaseSelectedForOutput((i + 1).toString())
            val u1 = DoubleArrayByRef()
            val u3 = DoubleArrayByRef()
            val pointNameForResult = if (i <= 3) "Right point" else "Middle point"
            sapModel.results.jointDispl(
                    name = pointNameForResult,
                    itemTypeElm = ItemTypeElm.OBJECT_ELM.sapId,
                    u1 = u1,
                    u3 = u3
            )
            sapResults[i] = if (i <= 3) u3[0] else u1[0]
        }

        //close Sap2000
        sapObject.applicationExit(false)

        //fill independent results (hand calculated)
        val indResults = doubleArrayOf(-0.02639, 0.06296, 0.06296, -0.2963, 0.3125, 0.11556, 0.00651)
        val dfResults = DecimalFormat("0.00000")
        val dfPercentage = DecimalFormat("0%")
        (0..6).forEach { i ->
            Assert.assertEquals(indResults[i], sapResults[i], 0.000009)
            val sapResult = dfResults.format(sapResults[i])
            val indResult = dfResults.format(indResults[i])
            val percentage = dfPercentage.format(sapResults[i] / indResults[i] - 1)
            println("LC=${i + 1} // Sap result=$sapResult // Independent result=$indResult // %Dif=$percentage")
        }
    }
}