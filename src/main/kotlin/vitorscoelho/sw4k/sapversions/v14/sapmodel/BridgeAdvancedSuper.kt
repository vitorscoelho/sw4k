package vitorscoelho.sw4k.sapversions.v14.sapmodel

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapversions.v14.sapmodel.bridgeadvanced.BASConcBoxV14

interface BridgeAdvancedSuperV14 : SapComponent {
    val basConcBox: BASConcBoxV14
    /**
     * This function returns the number of superstructure section cuts that are available for getting analysis results and performing design.
     * @param name The name of an existing bridge object.
     * @param count The number of section cuts in this bridge object. They will be identified in subsequent API functions using the indices 0 to Count-1. There may be one or two section cuts at each output station along the length of the superstructure.
     * @return zero if the count is successfully retrieved, otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun countSuperCut(name: String, count: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("CountSuperCut", name, count)

    /**
     * This function returns the number of stress points at the specified superstructure section cut.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut.
     * @param count The number of stress points for this section cut in this bridge object. They will be identified in subsequent API functions using the indices 0 to Count-1.
     * @return zero if the count is successfully retrieved, otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned
     */
    fun countSuperCutStressPoint(name: String, cutIndex: Int, count: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("CountSuperCutStressPoint", name, cutIndex, count)

    /**
     * This function returns location and orientation information about a single superstructure section cut in a bridge object.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut. Section cuts will be in order of increasing Station and increasing SuperCutType.
     * @param location This is 1 or 2, indicating whether the CutIndex section cut occurs before or after the associated station.
     * * 1 = Before the specified station.
     * 2 = After the specified station.
     * @param station The station ordinate of the CutIndex section cut at the reference line of the superstructure. (L)
     * @param xRefPt, YRefPt The transverse and vertical coordinates in the section of the reference point that corresponds to the layout line in the bridge object. XRefPt is positive to the right when looking upstation. YRefPt is positive upward. Coordinates are measured from the lower-left corner of the section bounding-box before skew, grade, and superelevation are applied. The rotations of the section due to skew, grade, and superelevation occur about the reference point. (L)
     * @param skew The skew angle, in degrees, of the section cut, measured from the horizontal normal to the superstructure reference line, with positive being about the upward vertical axis.
     * @param grade The grade, as a slope (abs(Grade) < 1.0), giving the vertical rise per distance along the superstructure reference line.
     * @param superElev The superelevation, as a slope (abs(SuperElev) < 1.0), giving the vertical rise per distance along the transverse normal to the superstructure reference line.
     * @return zero if the information is successfully retrieved, otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutLocation(name: String, cutIndex: Int, location: AIntByRef = IntByRef.UNNECESSARY, station: ADoubleByRef = DoubleByRef.UNNECESSARY, xRefPt: ADoubleByRef = DoubleByRef.UNNECESSARY, yRefPt: ADoubleByRef = DoubleByRef.UNNECESSARY, skew: ADoubleByRef = DoubleByRef.UNNECESSARY, grade: ADoubleByRef = DoubleByRef.UNNECESSARY, superElev: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetSuperCutLocation", name, cutIndex, location, station, xRefPt, yRefPt, skew, grade, superElev)

    /**
     * This function returns location and material information about a single stress point at a superstructure section cut in a bridge object.
     * @param name The name of an existing bridge object.
     * @param cutIndex The index number of section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCut.
     * @param pointIndex The index number of the stress point in this section cut in this bridge object. This must be from 0 to Count-1, where Count is the value returned by function CountSuperCutStressPoint.
     * @param x, Y The transverse and vertical coordinates of the stress point in the section, measured from the bottom left corner of the section. X is positive to the right when looking upstation. Y is positive upward. (L)
     * @param matProp The name of the material property at this stress point.
     * @param note A description of the stress point that may be used for identification. Points that are pre-defined by the program will have prescribed notes.
     * @return zero if the information is successfully retrieved, otherwise it returns a nonzero value. If the bridge object is not currently linked to existing objects in the model, an error is returned.
     */
    fun getSuperCutStressPoint(name: String, cutIndex: Int, pointIndex: Int, x: ADoubleByRef = DoubleByRef.UNNECESSARY, y: ADoubleByRef = DoubleByRef.UNNECESSARY, matProp: AStringByRef = StringByRef.UNNECESSARY, note: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetSuperCutStressPoint", name, cutIndex, pointIndex, x, y, matProp, note)
}