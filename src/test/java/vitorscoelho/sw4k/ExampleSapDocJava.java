package vitorscoelho.sw4k;

import org.junit.Assert;
import org.junit.Test;
import vitorscoelho.sw4k.comutils.*;
import vitorscoelho.sw4k.sap.SapObject;
import vitorscoelho.sw4k.sapenums.*;
import vitorscoelho.sw4k.sapversions.v14.SapModelV14;
import vitorscoelho.sw4k.sapversions.v14.SapObjectV14;

import java.text.DecimalFormat;

//public class ExampleSapDocJava {
//    @Test
//    public void example() {
//        //create Sap2000 object
//        SapObjectV14 sapObject = SapObject.v14();
//        //start Sap2000 application
//        sapObject.applicationStart(Units.kip_in_F.getSapId(), true, "");
//        //get sapModel object
//        SapModelV14 sapModel = sapObject.getSapModel();
//        //initialize model
//        sapModel.initializeNewModel(Units.kip_in_F.getSapId());
//        //create new blank model
//        sapModel.getFile().newBlank();
//        //define material property
//        sapModel.getPropMaterial().setMaterial("CONC", MatType.CONCRETE.getSapId(), -1, "", "");
//        //assign isotropic mechanical properties to material
//        sapModel.getPropMaterial().setMPIsotropic("CONC", 3600.0, 0.2, 0.0000055, 0.0);
//        //define rectangular frame section property
//        sapModel.getPropFrame().setRectangle("R1", "CONC", 12.0, 12.0, -1, "", "");
//        //define frame section property modifiers
//        sapModel.getPropFrame().setModifiers("R1", new DoubleArrayByRef(1000.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0));
//        //add points by coordinates
//        sapModel.getPointObj().addCartesian(0.0, 0.0, 0.0, StringByRef.UNNECESSARY(), "Bottom point", "Global", false, 0);
//        sapModel.getPointObj().addCartesian(0.0, 0.0, 10.0 * 12.0, StringByRef.UNNECESSARY(), "Middle point", "Global", false, 0);
//        sapModel.getPointObj().addCartesian(8.0 * 12.0, 0.0, 16.0 * 12.0, StringByRef.UNNECESSARY(), "Right point", "Global", false, 0);
//        sapModel.getPointObj().addCartesian(-4.0 * 12.0, 0.0, 10.0 * 12.0, StringByRef.UNNECESSARY(), "Left point", "Global", false, 0);
//        //add frame object by points
//        sapModel.getFrameObj().addByPoint("Bottom point", "Middle point", StringByRef.UNNECESSARY(), "R1", "1");
//        sapModel.getFrameObj().addByPoint("Middle point", "Right point", StringByRef.UNNECESSARY(), "R1", "2");
//        sapModel.getFrameObj().addByPoint("Left point", "Middle point", StringByRef.UNNECESSARY(), "R1", "3");
//        //assign point object restraint at base
//        sapModel.getPointObj().setRestraint(
//                "Bottom point",
//                new BooleanArrayByRef(true, true, true, true, false, false),
//                ItemType.OBJECT.getSapId()
//        );
//        //assign point object restraint at top
//        sapModel.getPointObj().setRestraint(
//                "Right point",
//                new BooleanArrayByRef(true, true, false, false, false, false),
//                ItemType.OBJECT.getSapId()
//        );
//        //refresh view, update (initialize) zoom
//        sapModel.getView().refreshView(0, false);
//        //switch to k-ft units
//        sapModel.setPresentUnits(Units.kip_ft_F.getSapId());
//        //add load patterns
//        sapModel.getLoadPatterns().add("1", LoadPatternType.OTHER.getSapId(), 1.0, true);
//        sapModel.getLoadPatterns().add("2", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        sapModel.getLoadPatterns().add("3", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        sapModel.getLoadPatterns().add("4", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        sapModel.getLoadPatterns().add("5", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        sapModel.getLoadPatterns().add("6", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        sapModel.getLoadPatterns().add("7", LoadPatternType.OTHER.getSapId(), 0.0, true);
//        //assign loading for load pattern 2
//        sapModel.getPointObj().setLoadForce(
//                "Left point",
//                "2",
//                new DoubleArrayByRef(0.0, 0.0, -10.0, 0.0, 0.0, 0.0),
//                false, "Global", ItemType.OBJECT.getSapId()
//        );
//        sapModel.getFrameObj().setLoadDistributed(
//                "3",
//                "2",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.GRAVITY_DIRECTION.getSapId(),
//                0.0, 1.0,
//                1.8, 1.8,
//                "Global", true, true, ItemType.OBJECT.getSapId()
//        );
//        //assign loading for load pattern 3
//        sapModel.getPointObj().setLoadForce(
//                "Middle point",
//                "3",
//                new DoubleArrayByRef(0.0, 0.0, -17.2, 0.0, -54.4, 0.0),
//                false, "Global", ItemType.OBJECT.getSapId()
//        );
//        //assign loading for load pattern 4
//        sapModel.getFrameObj().setLoadDistributed(
//                "2",
//                "4",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.PROJECTED_GRAVITY_DIRECTION.getSapId(),
//                0.0, 1.0,
//                2.0, 2.0,
//                "Global", true, true, ItemType.OBJECT.getSapId()
//        );
//        //assign loading for load pattern 5
//        sapModel.getFrameObj().setLoadDistributed(
//                "1",
//                "5",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.LOCAL_2_AXIS.getSapId(),
//                0.0, 1.0,
//                2.0, 2.0,
//                "Local", true, true, ItemType.OBJECT.getSapId()
//        );
//        sapModel.getFrameObj().setLoadDistributed(
//                "2",
//                "5",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.LOCAL_2_AXIS.getSapId(),
//                0.0, 1.0,
//                -2.0, -2.0,
//                "Local", true, true, ItemType.OBJECT.getSapId()
//        );
//        //assign loading for load pattern 6
//        sapModel.getFrameObj().setLoadDistributed(
//                "1",
//                "6",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.LOCAL_2_AXIS.getSapId(),
//                0.0, 1.0,
//                0.9984, 0.3744,
//                "Local", true, true, ItemType.OBJECT.getSapId()
//        );
//        sapModel.getFrameObj().setLoadDistributed(
//                "2",
//                "6",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.LOCAL_2_AXIS.getSapId(),
//                0.0, 1.0,
//                -0.3744, 0.0,
//                "Local", true, true, ItemType.OBJECT.getSapId()
//        );
//        //assign loading for load pattern 7
//        sapModel.getFrameObj().setLoadPoint(
//                "2",
//                "7",
//                DistributedLoadType.FORCE_PER_UNIT_LENGTH.getSapId(),
//                Dir.LOCAL_2_AXIS.getSapId(),
//                0.5, -15.0,
//                "Local", true, true, ItemType.OBJECT.getSapId()
//        );
//        //switch to k-in units
//        sapModel.setPresentUnits(Units.kip_in_F.getSapId());
//        //save model
//        sapModel.getFile().save("C:\\SapApiV14\\API_1-001.sdb");
//        //run model (this will create the analysis model)
//        sapModel.getAnalyze().runAnalysis();
//        //initialize for Sap2000 results
//        double[] sapResults = new double[7];
//        //get Sap2000 results for load patterns 1 through 7
//        for (int i = 0; i <= 6; i++) {
//            sapModel.getResults().getSetup().deselectAllCasesAndCombosForOutput();
//            sapModel.getResults().getSetup().setCaseSelectedForOutput(Integer.toString(i + 1), true);
//            DoubleArrayByRef u1 = new DoubleArrayByRef();
//            DoubleArrayByRef u3 = new DoubleArrayByRef();
//            String pointNameForResult;
//            if (i <= 3) {
//                pointNameForResult = "Right point";
//            } else {
//                pointNameForResult = "Middle point";
//            }
//            sapModel.getResults().jointDispl(
//                    pointNameForResult,
//                    ItemTypeElm.OBJECT_ELM.getSapId(),
//                    IntByRef.UNNECESSARY(),
//                    StringArrayByRef.UNNECESSARY(),
//                    StringArrayByRef.UNNECESSARY(),
//                    StringArrayByRef.UNNECESSARY(),
//                    StringArrayByRef.UNNECESSARY(),
//                    DoubleArrayByRef.UNNECESSARY(),
//                    u1,
//                    DoubleArrayByRef.UNNECESSARY(),
//                    u3,
//                    DoubleArrayByRef.UNNECESSARY(),
//                    DoubleArrayByRef.UNNECESSARY(),
//                    DoubleArrayByRef.UNNECESSARY()
//            );
//            if (i <= 3) {
//                sapResults[i] = u3.get(0);
//            } else {
//                sapResults[i] = u1.get(0);
//            }
//        }
//
//        //close Sap2000
//        sapObject.applicationExit(false);
//
//        //fill independent results (hand calculated)
//        double[] indResults = new double[]{-0.02639, 0.06296, 0.06296, -0.2963, 0.3125, 0.11556, 0.00651};
//        DecimalFormat dfResults = new DecimalFormat("0.00000");
//        DecimalFormat dfPercentage = new DecimalFormat("0%");
//        for (int i = 0; i <= 6; i++) {
//            Assert.assertEquals(indResults[i], sapResults[i], 0.000009);
//            String sapResult = dfResults.format(sapResults[i]);
//            String indResult = dfResults.format(indResults[i]);
//            String percentage = dfPercentage.format(sapResults[i] / indResults[i] - 1);
//            System.out.println("LC=" + (i + 1) + " // Sap result=" + sapResult + " // Independent result=" + indResult + " // %Dif=" + percentage);
//        }
//    }
//}
