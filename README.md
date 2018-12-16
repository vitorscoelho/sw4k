# sw4k
It is a simple wrapper of SAP2000 functions for Kotlin/Java.
It uses JACOB (https://sourceforge.net/projects/jacob-project/) to make Java-COM bridge.

Only SAP2000 v14, for a while.

Example (SAP2000 with Kotlin):
```kotlin
import vitorscoelho.sw4k.comutils.DoubleArrayByRef
import vitorscoelho.sw4k.comutils.byRef
import vitorscoelho.sw4k.sap.SapObject
import vitorscoelho.sw4k.sapenums.*
import java.text.DecimalFormat

fun kotlinExample() {
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
        val sapResult = dfResults.format(sapResults[i])
        val indResult = dfResults.format(indResults[i])
        val percentage = dfPercentage.format(sapResults[i] / indResults[i] - 1)
        println("LC=${i + 1} // Sap result=$sapResult // Independent result=$indResult // %Dif=$percentage")
    }
}
```

Example (SAP2000 with Java):
```java
import vitorscoelho.sw4k.comutils.*;
import vitorscoelho.sw4k.sap.SapObject;
import vitorscoelho.sw4k.sapenums.*;
import vitorscoelho.sw4k.sapversions.v14.SapModelV14;
import vitorscoelho.sw4k.sapversions.v14.SapObjectV14;
import java.text.DecimalFormat;

public class ExampleSapDocJava {
    public void javaExample() {
        //create Sap2000 object
        SapObjectV14 sapObject = SapObject.v14();
        //start Sap2000 application
        sapObject.applicationStart(Units.kip_in_F.getSapId(), true, "");
        //get sapModel object
        SapModelV14 sapModel = sapObject.getSapModel();
        //initialize model
        sapModel.initializeNewModel(Units.kip_in_F.getSapId());
        //create new blank model
        sapModel.getFile().newBlank();
        //define material property
        sapModel.getPropMaterial().setMaterial("CONC", MatType.CONCRETE.getSapId(), -1, "", "");
        //assign isotropic mechanical properties to material
        sapModel.getPropMaterial().setMPIsotropic("CONC", 3600.0, 0.2, 0.0000055, 0.0);
        //define rectangular frame section property
        sapModel.getPropFrame().setRectangle("R1", "CONC", 12.0, 12.0, -1, "", "");
        //define frame section property modifiers
        sapModel.getPropFrame().setModifiers("R1", new DoubleArrayByRef(1000.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0));
        //add points by coordinates
        sapModel.getPointObj().addCartesian(0.0, 0.0, 0.0, StringByRef.UNNECESSARY(), "Bottom point", "Global", false, 0);
        sapModel.getPointObj().addCartesian(0.0, 0.0, 10.0 * 12.0, StringByRef.UNNECESSARY(), "Middle point", "Global", false, 0);
        sapModel.getPointObj().addCartesian(8.0 * 12.0, 0.0, 16.0 * 12.0, StringByRef.UNNECESSARY(), "Right point", "Global", false, 0);
        sapModel.getPointObj().addCartesian(-4.0 * 12.0, 0.0, 10.0 * 12.0, StringByRef.UNNECESSARY(), "Left point", "Global", false, 0);
        //add frame object by points
        sapModel.getFrameObj().addByPoint("Bottom point", "Middle point", StringByRef.UNNECESSARY(), "R1", "1");
        sapModel.getFrameObj().addByPoint("Middle point", "Right point", StringByRef.UNNECESSARY(), "R1", "2");
        sapModel.getFrameObj().addByPoint("Left point", "Middle point", StringByRef.UNNECESSARY(), "R1", "3");
        //assign point object restraint at base
        sapModel.getPointObj().setRestraint(
                "Bottom point",
                new BooleanArrayByRef(true, true, true, true, false, false),
                ItemType.OBJECT.getSapId()
        );
        //assign point object restraint at top
        sapModel.getPointObj().setRestraint(
                "Right point",
                new BooleanArrayByRef(true, true, false, false, false, false),
                ItemType.OBJECT.getSapId()
        );
        //refresh view, update (initialize) zoom
        sapModel.getView().refreshView(0, false);
        //switch to k-ft units
        sapModel.setPresentUnits(Units.kip_ft_F.getSapId());
        //add load patterns
        sapModel.getLoadPatterns().add("1", LoadPatternType.OTHER.getSapId(), 1.0, true);
        sapModel.getLoadPatterns().add("2", LoadPatternType.OTHER.getSapId(), 0.0, true);
        sapModel.getLoadPatterns().add("3", LoadPatternType.OTHER.getSapId(), 0.0, true);
        sapModel.getLoadPatterns().add("4", LoadPatternType.OTHER.getSapId(), 0.0, true);
        sapModel.getLoadPatterns().add("5", LoadPatternType.OTHER.getSapId(), 0.0, true);
        sapModel.getLoadPatterns().add("6", LoadPatternType.OTHER.getSapId(), 0.0, true);
        sapModel.getLoadPatterns().add("7", LoadPatternType.OTHER.getSapId(), 0.0, true);
        //assign loading for load pattern 2
        sapModel.getPointObj().setLoadForce(
                "Left point",
                "2",
                new DoubleArrayByRef(0.0, 0.0, -10.0, 0.0, 0.0, 0.0),
                false, "Global", ItemType.OBJECT.getSapId()
        );
        sapModel.getFrameObj().setLoadDistributed(
                "3",
                "2",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.GRAVITY_DIRECTION.getSapId(),
                0.0, 1.0,
                1.8, 1.8,
                "Global", true, true, ItemType.OBJECT.getSapId()
        );
        //assign loading for load pattern 3
        sapModel.getPointObj().setLoadForce(
                "Middle point",
                "3",
                new DoubleArrayByRef(0.0, 0.0, -17.2, 0.0, -54.4, 0.0),
                false, "Global", ItemType.OBJECT.getSapId()
        );
        //assign loading for load pattern 4
        sapModel.getFrameObj().setLoadDistributed(
                "2",
                "4",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.PROJECTED_GRAVITY_DIRECTION.getSapId(),
                0.0, 1.0,
                2.0, 2.0,
                "Global", true, true, ItemType.OBJECT.getSapId()
        );
        //assign loading for load pattern 5
        sapModel.getFrameObj().setLoadDistributed(
                "1",
                "5",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.LOCAL_2_AXIS.getSapId(),
                0.0, 1.0,
                2.0, 2.0,
                "Local", true, true, ItemType.OBJECT.getSapId()
        );
        sapModel.getFrameObj().setLoadDistributed(
                "2",
                "5",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.LOCAL_2_AXIS.getSapId(),
                0.0, 1.0,
                -2.0, -2.0,
                "Local", true, true, ItemType.OBJECT.getSapId()
        );
        //assign loading for load pattern 6
        sapModel.getFrameObj().setLoadDistributed(
                "1",
                "6",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.LOCAL_2_AXIS.getSapId(),
                0.0, 1.0,
                0.9984, 0.3744,
                "Local", true, true, ItemType.OBJECT.getSapId()
        );
        sapModel.getFrameObj().setLoadDistributed(
                "2",
                "6",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.LOCAL_2_AXIS.getSapId(),
                0.0, 1.0,
                -0.3744, 0.0,
                "Local", true, true, ItemType.OBJECT.getSapId()
        );
        //assign loading for load pattern 7
        sapModel.getFrameObj().setLoadPoint(
                "2",
                "7",
                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
                Dir.LOCAL_2_AXIS.getSapId(),
                0.5, -15.0,
                "Local", true, true, ItemType.OBJECT.getSapId()
        );
        //switch to k-in units
        sapModel.setPresentUnits(Units.kip_in_F.getSapId());
        //save model
        sapModel.getFile().save("C:\\SapApiV14\\API_1-001.sdb");
        //run model (this will create the analysis model)
        sapModel.getAnalyze().runAnalysis();
        //initialize for Sap2000 results
        double[] sapResults = new double[7];
        //get Sap2000 results for load patterns 1 through 7
        for (int i = 0; i <= 6; i++) {
            sapModel.getResults().getSetup().deselectAllCasesAndCombosForOutput();
            sapModel.getResults().getSetup().setCaseSelectedForOutput(Integer.toString(i + 1), true);
            DoubleArrayByRef u1 = new DoubleArrayByRef();
            DoubleArrayByRef u3 = new DoubleArrayByRef();
            String pointNameForResult;
            if (i <= 3) {
                pointNameForResult = "Right point";
            } else {
                pointNameForResult = "Middle point";
            }
            sapModel.getResults().jointDispl(
                    pointNameForResult,
                    ItemTypeElm.OBJECT_ELM.getSapId(),
                    IntByRef.UNNECESSARY(),
                    StringArrayByRef.UNNECESSARY(),
                    StringArrayByRef.UNNECESSARY(),
                    StringArrayByRef.UNNECESSARY(),
                    StringArrayByRef.UNNECESSARY(),
                    DoubleArrayByRef.UNNECESSARY(),
                    u1,
                    DoubleArrayByRef.UNNECESSARY(),
                    u3,
                    DoubleArrayByRef.UNNECESSARY(),
                    DoubleArrayByRef.UNNECESSARY(),
                    DoubleArrayByRef.UNNECESSARY()
            );
            if (i <= 3) {
                sapResults[i] = u3.get(0);
            } else {
                sapResults[i] = u1.get(0);
            }
        }

        //close Sap2000
        sapObject.applicationExit(false);

        //fill independent results (hand calculated)
        double[] indResults = new double[]{-0.02639, 0.06296, 0.06296, -0.2963, 0.3125, 0.11556, 0.00651};
        DecimalFormat dfResults = new DecimalFormat("0.00000");
        DecimalFormat dfPercentage = new DecimalFormat("0%");
        for (int i = 0; i <= 6; i++) {
            String sapResult = dfResults.format(sapResults[i]);
            String indResult = dfResults.format(indResults[i]);
            String percentage = dfPercentage.format(sapResults[i] / indResults[i] - 1);
            System.out.println("LC=" + (i + 1) + " // Sap result=" + sapResult + " // Independent result=" + indResult + " // %Dif=" + percentage);
        }
    }
}
```
