# sw4k
It is a simple wrapper of SAP2000 functions for Kotlin/Java.

Only SAP2000 v14, for a while.

Example:
```kotlin
fun main() {
    LoaderJacobDll.load() //this is mandatory before anything
    //create Sap2000 object
    val sapObject = SapObject.v14()
    //start Sap2000 application
    sapObject.applicationStart()
    //get SapModel object
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
    //switch to k-ft units
    sapModel.setPresentUnits(units = Units.kip_ft_F.sapId)
    //add frame object by coordinates
    val frameNameByRef = Array(size = 3) { StringByRef() }
    sapModel.frameObj.addByCoord(0.0, 0.0, 0.0, 0.0, 0.0, 10.0, frameNameByRef[0], "R1", "1")
    sapModel.frameObj.addByCoord(0.0, 0.0, 10.0, 8.0, 0.0, 16.0, frameNameByRef[1], "R1", "2")
    sapModel.frameObj.addByCoord(-4.0, 0.0, 10.0, 0.0, 0.0, 10.0, frameNameByRef[2], "R1", "3")
    val frameName = frameNameByRef.map { it.value }
    //assign point object restraint at base
    val restraintAtBase = booleanArrayOf(true, true, true, true, false, false)
    val pointNameAtBaseByRef = Array(size = 2) { StringByRef() }
    sapModel.frameObj.getPoints(frameName[0], pointNameAtBaseByRef[0], pointNameAtBaseByRef[1])
    sapModel.pointObj.setRestraint(pointNameAtBaseByRef[0].value, restraintAtBase.byRef())
    //assign point object restraint at top
    val restraintAtTop = booleanArrayOf(true, true, false, false, false, false)
    val pointNameAtTopByRef = Array(size = 3) { StringByRef() }
    sapModel.frameObj.getPoints(frameName[1], pointNameAtTopByRef[0], pointNameAtTopByRef[1])
    sapModel.pointObj.setRestraint(pointNameAtTopByRef[1].value, restraintAtTop.byRef())
    //refresh view, update (initialize) zoom
    sapModel.view.refreshView(0, false)
    //add load patterns
    sapModel.loadPatterns.add("1", LoadPatternType.OTHER.sapId, 1.0)
    sapModel.loadPatterns.add("2", LoadPatternType.OTHER.sapId)
    sapModel.loadPatterns.add("3", LoadPatternType.OTHER.sapId)
    sapModel.loadPatterns.add("4", LoadPatternType.OTHER.sapId)
    sapModel.loadPatterns.add("5", LoadPatternType.OTHER.sapId)
    sapModel.loadPatterns.add("6", LoadPatternType.OTHER.sapId)
    sapModel.loadPatterns.add("7", LoadPatternType.OTHER.sapId)
}
```
