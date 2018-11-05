package vitorscoelho.sw4k.sap14

import vitorscoelho.sw4k.sap14.definitions.LoadCases
import vitorscoelho.sw4k.sap14.definitions.LoadPatterns
import vitorscoelho.sw4k.sap14.definitions.properties.PropFrame
import vitorscoelho.sw4k.sap14.definitions.properties.PropMaterial
import vitorscoelho.sw4k.sap14.enums.Units
import vitorscoelho.sw4k.sap14.objectmodel.FrameObj
import vitorscoelho.sw4k.sap14.objectmodel.PointObj

class SapModel internal constructor(val sapObject: SapObject) : SapComponent("${sapObject.sapObjectString}.cSapModel") {
    val file = File(this)
    val propMaterial = PropMaterial(this)
    val propFrame = PropFrame(this)
    val pointObj = PointObj(this)
    val frameObj = FrameObj(this)
    val loadPatterns = LoadPatterns(this)
    val loadCases = LoadCases(this)

    /**
     * This function clears the previous model and initializes the program for a new model. If it is later needed, you should save your previous model prior to calling this function.
     * After calling the InitializeNewModel function, it is not necessary to also call the ApplicationStart function because the functionality of the ApplicationStart function is included in the InitializeNewModel function.
     * @param units The database units used when a new model is created. Data is internally stored in the program in the database units.
     * @return zero if a new model is successfully initialized, otherwise it returns a nonzero value.
     */
    fun initializeNewModel(units: Units = Units.kip_in_F): Int =
            callFunction("InitializeNewModel", units.value).int
}