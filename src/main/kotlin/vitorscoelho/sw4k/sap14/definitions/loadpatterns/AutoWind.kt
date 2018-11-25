package vitorscoelho.sw4k.sap14.definitions.loadpatterns

import vitorscoelho.sw4k.comutils.*

class AutoWind(programName: String) : AutoWindV14 {
    override val activeXComponentName: String = "$programName.cAutoWind"
}

interface AutoWindV14 : SapComponent {
    /**
     * This function retrieves auto wind loading parameters for API 4F 2008.
     * @param name The name of an existing Wind-type load case with an API 4F 2008 auto wind assignment.
     * @param exposureFrom This is 2, 3 or 4, indicating the source of the wind exposure.
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The design reference wind velocity, Vref, in knots.
     * @param sSLFactor The structural safety level multiplier.
     * @return zero if the parameters are successfully assigned; otherwise, it returns a nonzero value.
     */
    fun getAPI4F2008(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, sSLFactor: DoubleByRef): Int =
            callFunctionInt("GetAPI4F2008", name, exposureFrom, dirAngle, userZ, topZ, bottomZ, windSpeed, sSLFactor)

    /**
     * This function retrieves auto wind loading parameters for ASCE 7-02.
     * @param name The name of an existing Wind-type load pattern with an ASCE7-02 auto wind assignment.
     * @param exposureFrom This is 1, 2, 3 or 4, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param ASCECase This is 1, 2, 3, 4 or 5, indicating the desired case from ASCE7-02 Figure 6-9. 1, 2, 3 and 4 refer to cases 1 through 4 in the figure. 5 means to create all cases. This item applies only when ExposureFrom = 1.
     * @param ASCEe1 This is the value e1 in ASCE7-02 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param ASCEe2 This is the value e2 in ASCE7-02 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param kd The directionality factor.
     * @param solidGrossRatio The solid area divided by gross area ratio for open frame structure loading. This item applies only when the loading is from open structure wind loading (ExposureFrom = 3 or ExposureFrom = 4).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getASCE702(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, ASCECase: IntByRef, ASCEe1: DoubleByRef, ASCEe2: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, kzt: DoubleByRef, gustFactor: DoubleByRef, kd: DoubleByRef, solidGrossRatio: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetASCE702", name, exposureFrom, dirAngle, cpw, cpl, ASCECase, ASCEe1, ASCEe2, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, kd, solidGrossRatio, userExposure)

    /**
     * This function retrieves auto wind loading parameters for ASCE 7-05.
     * @param name The name of an existing Wind-type load pattern with an ASCE7-05 auto wind assignment.
     * @param exposureFrom This is 1, 2, 3 or 4, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param ASCECase This is 1, 2, 3, 4 or 5, indicating the desired case from ASCE7-05 Figure 6-9. 1, 2, 3 and 4 refer to cases 1 through 4 in the figure. 5 means to create all cases. This item applies only when ExposureFrom = 1.
     * @param ASCEe1 This is the value e1 in ASCE7-05 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param ASCEe2 This is the value e2 in ASCE7-05 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param kd The directionality factor.
     * @param solidGrossRatio The solid area divided by the gross area ratio for open frame structure loading. This item applies only when the loading is from open structure wind loading (ExposureFrom = 3 or ExposureFrom = 4).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getASCE705(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, ASCECase: IntByRef, ASCEe1: DoubleByRef, ASCEe2: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, kzt: DoubleByRef, gustFactor: DoubleByRef, kd: DoubleByRef, solidGrossRatio: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetASCE705", name, exposureFrom, dirAngle, cpw, cpl, ASCECase, ASCEe1, ASCEe2, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, kd, solidGrossRatio, userExposure)

    /**
     * This function retrieves auto wind loading parameters for ASCE 7-88.
     * @param name The name of an existing Wind-type load pattern with an ASCE7-88 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getASCE788(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetASCE788", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for ASCE 7-95.
     * @param name The name of an existing Wind-type load pattern with an ASCE7-95 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getASCE795(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, kzt: DoubleByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetASCE795", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for BOCA 96.
     * @param name The name of an existing Wind-type load pattern with an BOCA 96 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param userGust If this item is True, the gust factor is user defined. If it is False, the gust factor is determined from the code specified values.
     * @param gustFactor The user defined gust factor. This item applies only when UserGust is True.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getBOCA96(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, userGust: BooleanByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetBOCA96", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, userGust, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for BS6399-95.
     * @param name The name of an existing Wind-type load pattern with an BS6399-95 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The front coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The rear coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param ve The effective wind speed in meters per second.
     * @param ca The size effect factor.
     * @param cr The dynamic augmentation factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getBS639995(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, ve: DoubleByRef, ca: DoubleByRef, cr: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetBS639995", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, ve, ca, cr, userExposure)

    /**
     * This function retrieves auto wind loading parameters for Chinese 2002.
     * @param name The name of an existing Wind-type load pattern with an Chinese 2002 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param buildingWidth The building width. (L)
     * @param us The shape coefficient. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param wzero The basic wind pressure in kN/m2.
     * @param rt This is 1, 2, 3 or 4, indicating the ground roughness.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param phiZOpt This is either 0 or 1, indicating the Phi Z source.
     * * 0 = Modal analysis
     * * 1 = Z/H ratio
     * @param t1Opt This is either 0 or 1, indicating the T1 source.
     * * 0 = Modal analysis
     * * 1 = User defined
     * @param userT This item applies only when the T1 source is user defined (T1Opt = 1). It is the user defined T1 period. (s)
     * @param dampRatio The damping ratio.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getChinese2002(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, buildingWidth: DoubleByRef, us: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, wzero: DoubleByRef, rt: IntByRef, phiZOpt: IntByRef, t1Opt: IntByRef, userT: DoubleByRef, dampRatio: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetChinese2002", name, exposureFrom, dirAngle, buildingWidth, us, userZ, topZ, bottomZ, wzero, rt, phiZOpt, t1Opt, userT, dampRatio, userExposure)

    /**
     * This function retrieves auto wind loading parameters for Eurocode 1 2005.
     * @param name The name of an existing Wind-type load pattern with a Eurocode 1 2005 auto wind assignment.
     * @param exposureFrom This is 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The basic wind speed, vb, in meters per second.
     * @param terrain This is 0, 1, 2, 3 or 4, indicating the terrain category.
     * * 0 = 0
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * * 4 = IV
     * @param orography The orography factor, Co.
     * @param k1 The turbulence factor, k1.
     * @param csCd The structural factor, CsCd.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getEurocode12005(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, terrain: IntByRef, orography: DoubleByRef, k1: DoubleByRef, csCd: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetEurocode12005", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, terrain, orography, k1, csCd, userExposure)

    /**
     * This function retrieves exposure parameters for auto wind loads determined from extents of rigid diaphragms. This function does not apply for User-type auto wind loads.
     * @param name The name of an existing Wind-type load pattern that has an auto wind load assigned.
     * @param num The number of diaphragms at which exposure data is reported.
     * @param diaph This is an array that includes the names of the diaphragms that have eccentricity overrides.
     * @param x This is an array that includes the global X-coordinate of the point where the wind force load is applied to the diaphragm. (L)
     * @param y This is an array that includes the global Y-coordinate of the point where the wind force load is applied to the diaphragm. (L)
     * @param myWidth This is an array that includes the exposure width for the wind load applied to the specified diaphragm. (L)
     * @param height This is an array that includes the exposure height for the wind load applied to the specified diaphragm. (L)
     * @return zero if the parameters are successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getExposure(name: String, num: IntByRef, diaph: StringArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef, myWidth: DoubleArrayByRef, height: DoubleArrayByRef): Int =
            callFunctionInt("GetExposure", name, num, diaph, x, y, myWidth, height)

    /**
     * This function retrieves auto wind loading parameters for Indian IS875-1987.
     * @param name The name of an existing Wind-type load pattern with an Indian IS875-1987 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in meters per second.
     * @param terrain This is 1, 2, 3 or 4, indicating the terrain category.
     * @param tClass This is 1, 2 or 3, indicating the terrain category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param k1 The risk coefficient (k1 factor).
     * @param k3 The topography factor (k3 factor).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getIS8751987(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, terrain: IntByRef, tClass: IntByRef, k1: DoubleByRef, k3: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetIS8751987", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, terrain, tClass, k1, k3, userExposure)

    /**
     * This function retrieves the Mexican auto wind loading parameters.
     * @param name The name of an existing Wind-type load pattern with an Indian IS875-1987 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in meters per second.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getMexican(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetMexican", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, userExposure)

    /**
     * This function retrieves auto wind loading parameters for NBCC 2005.
     * @param name The name of an existing Wind-type load pattern with an NBCC 2005 auto wind assignment.
     * @param exposureFrom This is 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param q The velocity pressure in kPa.
     * @param gustFactor The gust effect factor.
     * @param importanceFactor The importance factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getNBCC2005(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, q: DoubleByRef, gustFactor: DoubleByRef, importanceFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetNBCC2005", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, q, gustFactor, importanceFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for NBCC 95.
     * @param name The name of an existing Wind-type load pattern with an NBCC 95 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param q The velocity pressure in kPa.
     * @param gustFactor The gust effect factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getNBCC95(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, q: DoubleByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetNBCC95", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, q, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for 1994 UBC.
     * @param name The name of an existing Wind-type load pattern with an UBC94 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getUBC94(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetUBC94", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for 1997 UBC.
     * @param name The name of an existing Wind-type load pattern with an UBC97 auto wind assignment.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun getUBC97(name: String, exposureFrom: IntByRef, dirAngle: DoubleByRef, cpw: DoubleByRef, cpl: DoubleByRef, userZ: BooleanByRef, topZ: DoubleByRef, bottomZ: DoubleByRef, windSpeed: DoubleByRef, exposureType: IntByRef, importanceFactor: DoubleByRef, gustFactor: DoubleByRef, userExposure: BooleanByRef): Int =
            callFunctionInt("GetUBC97", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, gustFactor, userExposure)

    /**
     * This function retrieves auto wind loading parameters for User-type wind loading.
     * @param name The name of an existing Wind-type load pattern that has a User-type auto wind load assigned.
     * @param num The number of diaphragms at which user wind loads are reported.
     * @param diaph This is an array that includes the names of the diaphragms that have user wind loads.
     * @param fx This is an array that includes the global X direction force assigned to the specified diaphragm. (F)
     * @param fy This is an array that includes the global Y direction force assigned to the specified diaphragm. (F)
     * @param mz This is an array that includes the moment about the global Z axis assigned to the specified diaphragm. (FL)
     * @param x This is an array that includes the global X-coordinate of the point where the wind force load is applied to the diaphragm. (L)
     * @param y This is an array that includes the global Y-coordinate of the point where the wind force load is applied to the diaphragm. (L)
     * @return zero if the parameters are successfully assigned, otherwise it returns a nonzero value.
     */
    fun getUserLoad(name: String, num: IntByRef, diaph: StringArrayByRef, fx: DoubleArrayByRef, fy: DoubleArrayByRef, mz: DoubleArrayByRef, x: DoubleArrayByRef, y: DoubleArrayByRef): Int =
            callFunctionInt("GetUserLoad", name, num, diaph, fx, fx, mz, x, y)

    /**
     * This function assigns auto wind loading parameters for API 4F 2008.
     * @param name The name of an existing Wind-type load case.
     * @param exposureFrom This is 2, 3 or 4, indicating the source of the wind exposure.
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The design reference wind velocity, Vref, in knots.
     * @param sSLFactor The structural safety level multiplier.
     * @return zero if the parameters are successfully assigned; otherwise, it returns a nonzero value.
     */
    fun setAPI4F2008(name: String, exposureFrom: Int, dirAngle: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, sSLFactor: Double): Int =
            callFunctionInt("SetAPI4F2008", name, exposureFrom, dirAngle, userZ, topZ, bottomZ, windSpeed, sSLFactor)

    /**
     * This function assigns auto wind loading parameters for ASCE 7-02.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is 1, 2, 3 or 4, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param ASCECase This is either 1, 2, 3, 4 or 5, indicating the desired case from ASCE7-02 Figure 6-9. 1, 2, 3 and 4 refer to cases 1 through 4 in the figure. 5 means to create all cases. This item applies only when ExposureFrom = 1.
     * @param ASCEe1 This is the value e1 in ASCE7-02 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param ASCEe2 This is the value e2 in ASCE7-02 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies pnly when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param kd The directionality factor.
     * @param solidGrossRatio The solid area divided by gross area ratio for open frame structure loading. This item applies only when the loading is from open structure wind loading (ExposureFrom = 3 or ExposureFrom = 4).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setASCE702(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, ASCECase: Int, ASCEe1: Double, ASCEe2: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, kzt: Double, gustFactor: Double, kd: Double, solidGrossRatio: Double = 0.2, userExposure: Boolean = false): Int =
            callFunctionInt("SetASCE702", name, exposureFrom, dirAngle, cpw, cpl, ASCECase, ASCEe1, ASCEe2, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, kd, solidGrossRatio, userExposure)

    /**
     * This function assigns auto wind loading parameters for ASCE 7-05.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is 1, 2, 3 or 4, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * * 3 = From frame objects (open structure)
     * * 4 = From area objects and frame objects (open structure)
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param ASCECase This is 1, 2, 3, 4 or 5, indicating the desired case from ASCE7-05 Figure 6-9. 1, 2, 3 and 4 refer to cases 1 through 4 in the figure. 5 means to create all cases. This item applies only when ExposureFrom = 1.
     * @param ASCEe1 This is the value e1 in ASCE7-05 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param ASCEe2 This is the value e2 in ASCE7-05 Figure 6-9. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param kd The directionality factor.
     * @param solidGrossRatio The solid area divided by gross area ratio for open frame structure loading. This item applies only when the loading is from open structure wind loading (ExposureFrom = 3 or ExposureFrom = 4).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setASCE705(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, ASCECase: Int, ASCEe1: Double, ASCEe2: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, kzt: Double, gustFactor: Double, kd: Double, solidGrossRatio: Double = 0.2, userExposure: Boolean = false): Int =
            callFunctionInt("SetASCE705", name, exposureFrom, dirAngle, cpw, cpl, ASCECase, ASCEe1, ASCEe2, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, kd, solidGrossRatio, userExposure)

    /**
     * This function assigns auto wind loading parameters for ASCE 7-88.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setASCE788(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, gustFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetASCE788", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, gustFactor, userExposure)

    /**
     * This function assigns auto wind loading parameters for ASCE 7-95.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param kzt The topographical factor.
     * @param gustFactor The gust factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setASCE795(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, kzt: Double, gustFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetASCE795", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, kzt, gustFactor, userExposure)

    /**
     * This function assigns auto wind loading parameters for BOCA 96.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2, 3 or 4, indicating the exposure category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param importanceFactor The importance factor.
     * @param gustFactor The user defined gust factor. This item applies only when UserGust is True.
     * @param userGust If this item is True, the gust factor is user defined. If it is False, the gust factor is determined from the code specified values.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setBOCA96(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, gustFactor: Double, userGust: Boolean = false, userExposure: Boolean = false): Int =
            callFunctionInt("SetBOCA96", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, gustFactor, userGust, userExposure)

    /**
     * This function assigns auto wind loading parameters for BS6399-95.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The front coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The rear coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param ve The effective wind speed in meters per second.
     * @param ca The size effect factor.
     * @param cr The dynamic augmentation factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setBS639995(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, ve: Double, ca: Double, cr: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetBS639995", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, ve, ca, cr, userExposure)

    /**
     * This function assigns auto wind loading parameters for Chinese 2002.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param buildingWidth The building width. (L)
     * @param us The shape coefficient. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param wzero The basic wind pressure in kN/m2.
     * @param rt This is 1, 2, 3 or 4, indicating the ground roughness.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * * 4 = D
     * @param phiZOpt This is either 0 or 1, indicating the Phi Z source.
     * * 0 = Modal analysis
     * * 1 = Z/H ratio
     * @param t1Opt This is either 0 or 1, indicating the T1 source.
     * * 0 = Modal analysis
     * * 1 = User defined
     * @param userT This item applies only when the T1 source is user defined (T1Opt = 1). It is the user defined T1 period. (s)
     * @param dampRatio The damping ratio.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setChinese2002(name: String, exposureFrom: Int, dirAngle: Double, buildingWidth: Double, us: Double, userZ: Boolean, topZ: Double, bottomZ: Double, wzero: Double, rt: Int, phiZOpt: Int, t1Opt: Int, userT: Double, dampRatio: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetChinese2002", name, exposureFrom, dirAngle, buildingWidth, us, userZ, topZ, bottomZ, wzero, rt, phiZOpt, t1Opt, userT, dampRatio, userExposure)

    /**
     * This function assigns auto wind loading parameters for Eurocode 1 2005.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The basic wind speed, vb, in meters per second.
     * @param terrain This is 0, 1, 2, 3 or 4, indicating the terrain category.
     * * 0 = 0
     * * 1 = I
     * * 2 = II
     * * 3 = III
     * * 4 = IV
     * @param orography The orography factor, Co.
     * @param k1 The turbulence factor, k1.
     * @param csCd The structural factor, CsCd.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setEurocode12005(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, terrain: Int, orography: Double, k1: Double, csCd: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetEurocode12005", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, terrain, orography, k1, csCd, userExposure)

    /**
     * This function assigns exposure parameters for auto wind loads determined from extents of rigid diaphragms. This function does not apply for User-type auto wind loads.
     * @param name The name of an existing Wind-type load pattern that has an auto wind load assigned.
     * @param diaph The name of an existing special rigid diaphragm constraint, that is, a diaphragm constraint with the following features:
     * * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * * 2. The constraint coordinate system is Global.
     * * 3. The constraint axis is Z.
     * @param x The global X-coordinate of the point where the wind force is applied. (L)
     * @param y The global Y-coordinate of the point where the wind force is applied. (L)
     * @param width The exposure width for the wind load applied to the specified diaphragm. (L)
     * @param height The exposure height for the wind load applied to the specified diaphragm. (L)
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value. The function returns an error if the auto wind load is not specified to have user exposure parameters.
     */
    fun setExposure(name: String, diaph: String, x: Double, y: Double, width: Double, height: Double): Int =
            callFunctionInt("SetExposure", name, diaph, x, y, width, height)

    /**
     * This function assigns auto wind loading parameters for Indian IS875-1987.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in meters per second.
     * @param terrain This is 1, 2, 3 or 4, indicating the terrain category.
     * @param tClass This is 1, 2 or 3, indicating the terrain category.
     * * 1 = A
     * * 2 = B
     * * 3 = C
     * @param k1 The risk coefficient (k1 factor).
     * @param k3 The topography factor (k3 factor).
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setIS8751987(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, terrain: Int, tClass: Int, k1: Double, k3: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetIS8751987", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, terrain, tClass, k1, k3, userExposure)

    /**
     * This function assigns the Mexican auto wind loading parameters.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in meters per second.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setMexican(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetMexican", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, userExposure)

    /**
     * This function assigns auto wind loading parameters for NBCC 2005.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param q The velocity pressure in kPa.
     * @param gustFactor The gust effect factor.
     * @param importanceFactor The importance factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNBCC2005(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, q: Double, gustFactor: Double, importanceFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetNBCC2005", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, q, gustFactor, importanceFactor, userExposure)

    /**
     * This function assigns auto wind loading parameters for NBCC 95.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cp. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param q The velocity pressure in kPa.
     * @param gustFactor The gust effect factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNBCC95(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, q: Double, gustFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetNBCC95", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, q, gustFactor, userExposure)

    /**
     * This function set the auto wind loading type for the specified load pattern to None.
     * @param name The name of an existing Wind-type load pattern.
     * @return zero if the loading type is successfully assigned; otherwise it returns a nonzero value.
     */
    fun setNone(name: String): Int =
            callFunctionInt("SetNone", name)

    /**
     * This function assigns auto wind loading parameters for 1994 UBC.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cq. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cq. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUBC94(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetUBC94", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, userExposure)

    /**
     * This function assigns auto wind loading parameters for 1997 UBC.
     * @param name The name of an existing Wind-type load pattern.
     * @param exposureFrom This is either 1 or 2, indicating the source of the wind exposure.
     * * 1 = From extents of rigid diaphragms
     * * 2 = From area objects
     * @param dirAngle The direction angle for the wind load. This item applies only when ExposureFrom = 1.
     * @param cpw The windward coefficient, Cq. This item applies only when ExposureFrom = 1.
     * @param cpl The leeward coefficient, Cq. This item applies only when ExposureFrom = 1.
     * @param userZ This item is True if the top and bottom elevations of the wind load are user specified. It is False if the elevations are determined by the program.
     * @param topZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the highest level where auto wind loads are applied. (L)
     * @param bottomZ This item applies only when the UserZ item is True. It is the global Z-coordinate at the lowest level where auto wind loads are applied. (L)
     * @param windSpeed The wind speed in miles per hour.
     * @param exposureType This is 1, 2 or 3, indicating the exposure category.
     * * 1 = B
     * * 2 = C
     * * 3 = D
     * @param importanceFactor The importance factor.
     * @param userExposure If this item is True, the wind exposure widths are provided by the user. If it is False, the wind exposure widths are calculated by the program from the extents of the diaphragms.
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUBC97(name: String, exposureFrom: Int, dirAngle: Double, cpw: Double, cpl: Double, userZ: Boolean, topZ: Double, bottomZ: Double, windSpeed: Double, exposureType: Int, importanceFactor: Double, userExposure: Boolean = false): Int =
            callFunctionInt("SetUBC97", name, exposureFrom, dirAngle, cpw, cpl, userZ, topZ, bottomZ, windSpeed, exposureType, importanceFactor, userExposure)

    /**
     * This function assigns auto wind loading parameters for User-type wind loads.
     * @param name The name of an existing Wind-type load pattern that has an auto wind load assigned.
     * @param diaph The name of an existing special rigid diaphragm constraint, that is, a diaphragm constraint with the following features:
     * * 1. The constraint type is CONSTRAINT_DIAPHRAGM = 2.
     * * 2. The constraint coordinate system is Global.
     * * 3. The constraint axis is Z.
     * @param fx The global X direction force assigned to the specified diaphragm. (F)
     * @param fy The global Y direction force assigned to the specified diaphragm. (F)
     * @param mz The moment about the global Z axis assigned to the specified diaphragm. (FL)
     * @param x The global X-coordinate of the point where the wind force is applied. (L)
     * @param y The global Y-coordinate of the point where the wind force is applied. (L)
     * @return zero if the parameters are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setUserLoad(name: String, diaph: String, fx: Double, fy: Double, mz: Double, x: Double, y: Double): Int =
            callFunctionInt("SetUserLoad", name, diaph, fx, fy, mz, x, y)
}