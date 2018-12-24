package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties

import vitorscoelho.sw4k.comutils.*
import vitorscoelho.sw4k.sapenums.LinkPropType

interface PropLinkV14 : SapComponent {
    /**
     * This function changes the name of an existing link property.
     * @param name The existing name of a defined link property.
     * @param newName The new name for the link property.
     * @return zero if the new name is successfully applied; otherwise it returns a nonzero value.
     */
    fun changeName(name: String, newName: String): Int =
            callFunctionInt("ChangeName", name, newName)

    /**
     * @return the total number of defined link properties in the model.
     */
    fun count(): Int =
            callFunctionInt("Count")

    /**
     * @param propType This optional value is one of the following items in the [LinkPropType] enumeration.
     * * LINEAR = 1
     * * DAMPER = 2
     * * GAP = 3
     * * HOOK = 4
     * * PLASTIC_WEN = 5
     * * ISOLATOR1 = 6 (Rubber isolator)
     * * ISOLATOR2 = 7 (Friction isolator)
     * * MULTILINEAR_ELASTIC = 8
     * * MULTILINEAR_PLASTIC = 9
     * * ISOLATOR3 = 10 (T/C Friction isolator)
     * @return the total number of defined link properties of a specified type in the model.
     */
    fun count(propType: Int): Int =
            callFunctionInt("Count", propType)

    /**
     * The function deletes a specified link property.
     * @param name The name of an existing link property.
     * @return zero if the link property is successfully deleted; otherwise it returns a nonzero value. It returns an error if the specified link property can not be deleted, for example, if it is being used by an existing link object.
     */
    fun delete(name: String): Int =
            callFunctionInt("Delete", name)

    /**
     * This function retrieves link property data for a damper-type link property.
     * @param name The name of an existing damper-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param c This is an array of nonlinear damping coefficient terms for the link property. The nonlinear damping coefficient applies for nonlinear analyses.
     * * c(0) = U1 (F/(L^cexp))
     * * c(1) = U2 (F/(L^cexp))
     * * c(2) = U3 (F/(L^cexp))
     * * c(3) = R1 (FL)
     * * c(4) = R2 (FL)
     * * c(5) = R3 (FL)
     * The term c(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param cexp This is an array of the nonlinear damping exponent terms. The nonlinear damping exponent applies for nonlinear analyses. It is applied to the velocity across the damper in the equation of motion.
     * * cexp(0) = U1
     * * cexp(1) = U2
     * * cexp(2) = U3
     * * cexp(3) = R1
     * * cexp(4) = R2
     * * cexp(5) = R3
     * The term cexp(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getDamper(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, c: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, cexp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetDamper", name, DOF, fixed, nonLinear, ke, ce, k, c, cexp, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a friction isolator-type link property.
     * @param name The name of an existing friction isolator-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slow This is an array of the friction coefficient at zero velocity terms for the link property. This coefficient applies for nonlinear analyses.
     * * Slow(0) = U1, Not Used
     * * Slow(1) = U2
     * * Slow(2) = U3
     * * Slow(3) = R1, Not Used
     * * Slow(4) = R2, Not Used
     * * Slow(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Slow(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fast This is an array of the friction coefficient at fast velocity terms for the link property. This coefficient applies for nonlinear analyses.
     * * Fast(0) = U1, Not Used
     * * Fast(1) = U2
     * * Fast(2) = U3
     * * Fast(3) = R1, Not Used
     * * Fast(4) = R2, Not Used
     * * Fast(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Fast(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rate This is an array of the inverse of the characteristic sliding velocity terms for the link property. This item applies for nonlinear analyses.
     * * Rate(0) = U1, Not Used
     * * Rate(1) = U2 (s/L)
     * * Rate(2) = U3 (s/L)
     * * Rate(3) = R1, Not Used
     * * Rate(4) = R2, Not Used
     * * Rate(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Rate(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param radius This is an array of the radius of the sliding contact surface terms for the link property. Inputting 0 means there is an infinite radius, that is, the slider is flat. This item applies for nonlinear analyses.
     * * Radius(0) = U1, Not Used
     * * Radius(1) = U2 (L)
     * * Radius(2) = U3 (L)
     * * Radius(3) = R1, Not Used
     * * Radius(4) = R2, Not Used
     * * Radius(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Radius(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param damping This is the nonlinear damping coefficient used for the axial translational degree of freedom, U1. This item applies for nonlinear analyses. (F/L)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getFrictionIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slow: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fast: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rate: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, radius: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, damping: ADoubleByRef = DoubleByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetFrictionIsolator", name, DOF, fixed, nonLinear, ke, ce, k, slow, fast, rate, radius, damping, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a gap-type link property.
     * @param name The name of an existing gap-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dis This is an array of initial gap opening terms for the link property. The initial gap opening applies for nonlinear analyses.
     * * c(0) = U1 (L)
     * * c(1) = U2 (L)
     * * c(2) = U3 (L)
     * * c(3) = R1 (rad)
     * * c(4) = R2 (rad)
     * * c(5) = R3 (rad)
     * The term dis(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is retrieved successfully; otherwise it returns a nonzero value.
     */
    fun getGap(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dis: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetGap", name, DOF, fixed, nonLinear, ke, ce, k, dis, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a hook-type link property.
     * @param name The name of an existing hook-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dis This is an array of initial hook opening terms for the link property. The initial hook opening applies for nonlinear analyses.
     * * c(0) = U1 (L)
     * * c(1) = U2 (L)
     * * c(2) = U3 (L)
     * * c(3) = R1 (rad)
     * * c(4) = R2 (rad)
     * * c(5) = R3 (rad)
     * The term dis(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getHook(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dis: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetHook", name, DOF, fixed, nonLinear, ke, ce, k, dis, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a linear-type link property.
     * @param name The name of an existing linear-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity if DOF(0) = True
     * * Fixed(1) = U2 fixity if DOF(1) = True
     * * Fixed(2) = U3 fixity if DOF(2) = True
     * * Fixed(3) = R1 fixity if DOF(3) = True
     * * Fixed(4) = R2 fixity if DOF(4) = True
     * * Fixed(5) = R3 fixity if DOF(5) = True
     * @param ke This is an array of stiffness terms for the link property. There are 6 terms in the array if the stiffness is uncoupled and 21 if it is coupled. The KeCoupled item indicates if the stiffness is coupled.
     * If the stiffness is uncoupled:
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * If the stiffness is coupled:
     * * Ke(0) = U1U1 (F/L)
     * * Ke(1) = U1U2 (F/L)
     * * Ke(2) = U2U2 (F/L)
     * * Ke(3) = U1U3 (F/L)
     * * Ke(4) = U2U3 (F/L)
     * * Ke(5) = U3U3 (F/L)
     * * Ke(6) = U1R1 (F)
     * * Ke(7) = U2R1 (F)
     * * Ke(8) = U3R1 (F)
     * * Ke(9) = R1R1 (FL)
     * * Ke(10) = U1R2 (F)
     * * Ke(11) = U2R2 (F)
     * * Ke(12) = U3R2 (F)
     * * Ke(13) = R1R2 (FL)
     * * Ke(14) = R2R2 (FL)
     * * Ke(15) = U1R3 (F)
     * * Ke(16) = U2R3 (F)
     * * Ke(17) = U3R3 (F)
     * * Ke(18) = R1R3 (FL)
     * * Ke(19) = R2R3 (FL)
     * * Ke(20) = R3R3 (FL)
     * @param ce This is an array of damping terms for the link property. There are 6 terms in the array if the damping is uncoupled and 21 if it is coupled. The CeCoupled item indicates if the damping is coupled.
     * If the damping is uncoupled:
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * If the damping is coupled:
     * * Ce(0) = U1U1 (F/L)
     * * Ce(1) = U1U2 (F/L)
     * * Ce(2) = U2U2 (F/L)
     * * Ce(3) = U1U3 (F/L)
     * * Ce(4) = U2U3 (F/L)
     * * Ce(5) = U3U3 (F/L)
     * * Ce(6) = U1R1 (F)
     * * Ce(7) = U2R1 (F)
     * * Ce(8) = U3R1 (F)
     * * Ce(9) = R1R1 (FL)
     * * Ce(10) = U1R2 (F)
     * * Ce(11) = U2R2 (F)
     * * Ce(12) = U3R2 (F)
     * * Ce(13) = R1R2 (FL)
     * * Ce(14) = R2R2 (FL)
     * * Ce(15) = U1R3 (F)
     * * Ce(16) = U2R3 (F)
     * * Ce(17) = U3R3 (F)
     * * Ce(18) = R1R3 (FL)
     * * Ce(19) = R2R3 (FL)
     * * Ce(20) = R3R3 (FL)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param keCoupled This item is True if the link stiffness, Ke, is coupled. There are 21 terms in the Ke array if Ke is coupled; otherwise there are 6 terms.
     * @param ceCoupled This item is True if the link damping, Ce, is coupled. There are 21 terms in the Ce array if Ce is coupled; otherwise there are 6 terms.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getLinear(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, keCoupled: ABooleanByRef = BooleanByRef.UNNECESSARY, ceCoupled: ABooleanByRef = BooleanByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetLinear", name, DOF, fixed, ke, ce, dj2, dj3, keCoupled, ceCoupled, notes, GUID)

    /**
     * This function retrieves link property data for a multilinear elastic-type link property.
     * @param name The name of an existing multilinear elastic-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMultiLinearElastic(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMultiLinearElastic", name, DOF, fixed, nonLinear, ke, ce, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a multilinear plastic-type link property.
     * @param name The name of an existing multilinear plastic-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getMultiLinearPlastic(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetMultiLinearPlastic", name, DOF, fixed, nonLinear, ke, ce, dj2, dj3, notes, GUID)

    /**
     * This function retrieves the force-deformation data for a specified degree of freedom in multilinear elastic and multilinear plastic link properties.
     * @param name The name of an existing multilinear elastic or multilinear plastic link property.
     * @param DOF This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom to which the multilinear points apply.
     * * 1 = U1
     * * 2 = U2
     * * 3 = U3
     * * 4 = R1
     * * 5 = R2
     * * 6 = R3
     * @param numberPoints The number of foce-defomation points for the specified degree of freedom.
     * @param f This is an array, dimensioned to NumberPoints, that includes the force at each point. When DOF is U1, U2 or U3, this is a force. When DOF is R1, R2 or R3, this is a moment. (F) if DOF <= 3, and (FL) if DOF > 3
     * @param d This is an array, dimensioned to NumberPoints, that includes the displacement at each point. When DOF is U1, U2 or U3, this is a translation. When DOF is R1, R2 or R3, this is a rotation. (L) if DOF <= 3, and (rad) if DOF > 3
     * @param myType This item applies only to multilinear plastic link properties. It is 1, 2 or 3, indicating the hysteresis type.
     * * 1 = Kinematic
     * * 2 = Takeda
     * * 3 = Pivot
     * @param a1 This item only applies to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Alpha1 hysteresis parameter.
     * @param a2 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Alpha2 hysteresis parameter.
     * @param b1 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Beta1 hysteresis parameter.
     * @param b2 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Beta2 hysteresis parameter.
     * @param eta This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Eta hysteresis parameter.
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value. To successfully retrieve this data from the indicated link property, the following conditions must be met:
     * * 1. The link property must be multilinear elastic or multilinear plastic.
     * * 2. The specified DOF must be active.
     * * 3. The specified DOF must not be fixed.
     */
    fun getMultiLinearPoints(name: String, DOF: Int, numberPoints: AIntByRef = IntByRef.UNNECESSARY, f: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, d: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, myType: AIntByRef = IntByRef.UNNECESSARY, a1: ADoubleByRef = DoubleByRef.UNNECESSARY, a2: ADoubleByRef = DoubleByRef.UNNECESSARY, b1: ADoubleByRef = DoubleByRef.UNNECESSARY, b2: ADoubleByRef = DoubleByRef.UNNECESSARY, eta: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetMultiLinearPoints", name, DOF, numberPoints, f, d, myType, a1, a2, b1, b2, eta)

    /**
     * This function retrieves the names of all defined link properties of the specified type.
     * @param numberNames The number of link property names retrieved by the program.
     * @param myName This is a one-dimensional array of link property names.
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetNameList", numberNames, myName)

    /**
     * This function retrieves the names of all defined link properties of the specified type.
     * @param numberNames The number of link property names retrieved by the program.
     * @param myName This is a one-dimensional array of link property names.
     * @param propType This optional value is one of the following items in the [LinkPropType] enumeration.
     * * LINEAR = 1
     * * DAMPER = 2
     * * GAP = 3
     * * HOOK = 4
     * * PLASTIC_WEN = 5
     * * ISOLATOR1 = 6 (Rubber isolator)
     * * ISOLATOR2 = 7 (Friction isolator)
     * * MULTILINEAR_ELASTIC = 8
     * * MULTILINEAR_PLASTIC = 9
     * * ISOLATOR3 = 10 (T/C Friction isolator)
     * @return zero if the names are successfully retrieved; otherwise it returns nonzero.
     */
    fun getNameList(numberNames: AIntByRef = IntByRef.UNNECESSARY, myName: AStringArrayByRef = StringArrayByRef.UNNECESSARY, propType: Int): Int =
            callFunctionInt("GetNameList", numberNames, myName, propType)

    /**
     * This function retrieves P-delta parameters for a link property.
     * @param name The name of an existing link property.
     * @param value This is an array of P-delta parameters.
     * * Value(0) = M2 P-delta to I-end of link as moment, M2I
     * * Value(1) = M2 P-delta to J-end of link as moment, M2J
     * * Value(2) = M3 P-delta to I-end of link as moment, M3I
     * * Value(3) = M3 P-delta to J-end of link as moment, M3J
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPDelta(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("GetPDelta", name, value)

    /**
     * This function retrieves link property data for a plastic Wen-type link property.
     * @param name The name of an existing plastic Wen-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param yield This is an array of yield force terms for the link property. The yield force applies for nonlinear analyses.
     * * Yield(0) = U1 (F)
     * * Yield(1) = U2 (F)
     * * Yield(2) = U3 (F)
     * * Yield(3) = R1 (FL)
     * * Yield(4) = R2 (FL)
     * * Yield(5) = R3 (FL)
     * The term Yield(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param ratio This is an array of post-yield stiffness ratio terms for the link property. The post-yield stiffness ratio applies for nonlinear analyses. It is the post-yield stiffness divided by the initial stiffness.
     * * Ratio(0) = U1
     * * Ratio(1) = U2
     * * Ratio(2) = U3
     * * Ratio(3) = R1
     * * Ratio(4) = R2
     * * Ratio(5) = R3
     * The term Ratio(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param exp This is an array of yield exponent terms for the link property. The yield exponent applies for nonlinear analyses. The yielding exponent that controls the sharpness of the transition from the initial stiffness to the yielded stiffness.
     * * exp(0) = U1
     * * exp(1) = U2
     * * exp(2) = U3
     * * exp(3) = R1
     * * exp(4) = R2
     * * exp(5) = R3
     * The term exp(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getPlasticWen(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, `yield`: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ratio: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, exp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetPlasticWen", name, DOF, fixed, nonLinear, ke, ce, k, `yield`, ratio, exp, dj2, dj3, notes, GUID)

    /**
     * This function retrieves link property data for a rubber isolator-type link property.
     * @param name The name of an existing rubber isolator-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1, Not Used
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1, Not Used
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param yield This is an array of yield force terms for the link property. The yield force applies for nonlinear analyses.
     * * Yield(0) = U1, Not Used
     * * Yield(1) = U2 (F)
     * * Yield(2) = U3 (F)
     * * Yield(3) = R1, Not Used
     * * Yield(4) = R2, Not Used
     * * Yield(5) = R3, Not Used
     * The term Yield(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param ratio This is an array of post-yield stiffness ratio terms for the link property. The post-yield stiffness ratio applies for nonlinear analyses. It is the post-yield stiffness divided by the initial stiffness.
     * * Ratio(0) = U1, Not Used
     * * Ratio(1) = U2
     * * Ratio(2) = U3
     * * Ratio(3) = R1, Not Used
     * * Ratio(4) = R2, Not Used
     * * Ratio(5) = R3, Not Used
     * The term Ratio(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getRubberIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, `yield`: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ratio: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetRubberIsolator", name, DOF, fixed, nonLinear, ke, ce, k, `yield`, ratio, dj2, dj3, notes, GUID)

    /**
     * This function retrieves length and area values for a link property that are used if the link property is specified in line and area spring assignments.
     * @param name The name of an existing link property.
     * @param definedForThisLength The link property is defined for this length in a line (frame) spring. (L)
     * @param definedForThisArea The link property is defined for this area in an area spring. (L2)
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getSpringData(name: String, definedForThisLength: ADoubleByRef = DoubleByRef.UNNECESSARY, definedForThisArea: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetSpringData", name, definedForThisLength, definedForThisArea)

    /**
     * This function retrieves link property data for a T/C friction isolator-type link property.
     * @param name The name of an existing T/C friction isolator-type link property.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slow This is an array of the friction coefficient at zero velocity terms when U1 is in compression for the link property. This coefficient applies for nonlinear analyses.
     * * Slow(0) = U1, Not Used
     * * Slow(1) = U2
     * * Slow(2) = U3
     * * Slow(3) = R1, Not Used
     * * Slow(4) = R2, Not Used
     * * Slow(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Slow(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fast This is an array of the friction coefficient at fast velocity terms when U1 is in compression for the link property. This coefficient applies for nonlinear analyses.
     * * Fast(0) = U1, Not Used
     * * Fast(1) = U2
     * * Fast(2) = U3
     * * Fast(3) = R1, Not Used
     * * Fast(4) = R2, Not Used
     * * Fast(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Fast(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rate This is an array of the inverse of the characteristic sliding velocity terms when U1 is in compression for the link property. This item applies for nonlinear analyses.
     * * Rate(0) = U1, Not Used
     * * Rate(1) = U2 (s/L)
     * * Rate(2) = U3 (s/L)
     * * Rate(3) = R1, Not Used
     * * Rate(4) = R2, Not Used
     * * Rate(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Rate(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param radius This is an array of the radius of the sliding contact surface terms for the link property. Inputting 0 means there is an infinite radius, that is, the slider is flat. This item applies for nonlinear analyses.
     * * Radius(0) = U1, Not Used
     * * Radius(1) = U2 (L)
     * * Radius(2) = U3 (L)
     * * Radius(3) = R1, Not Used
     * * Radius(4) = R2, Not Used
     * * Radius(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Radius(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slowT This is an array of the friction coefficient at zero velocity terms when U1 is in tension for the link property. This coefficient applies for nonlinear analyses.
     * * SlowT(0) = U1, Not Used
     * * SlowT(1) = U2
     * * SlowT(2) = U3
     * * SlowT(3) = R1, Not Used
     * * SlowT(4) = R2, Not Used
     * * SlowT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term SlowT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fastT This is an array of the friction coefficient at fast velocity terms when U1 is in tension for the link property. This coefficient applies for nonlinear analyses.
     * * FastT(0) = U1, Not Used
     * * FastT(1) = U2
     * * FastT(2) = U3
     * * FastT(3) = R1, Not Used
     * * FastT(4) = R2, Not Used
     * * FastT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term FastT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rateT This is an array of the inverse of the characteristic sliding velocity terms when U1 is in tension for the link property. This item applies for nonlinear analyses.
     * * RateT(0) = U1, Not Used
     * * RateT(1) = U2 (s/L)
     * * RateT(2) = U3 (s/L)
     * * RateT(3) = R1, Not Used
     * * RateT(4) = R2, Not Used
     * * RateT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term RateT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param kt The axial translational tension stiffness for the U1 degree of freedom. This item applies for nonlinear analyses. (F/L)
     * @param dis The U1 degree of freedom gap opening for compression. This item applies for nonlinear analyses. (L)
     * @param dist The U1 degree of freedom gap opening for tension. This item applies for nonlinear analyses. (L)
     * @param damping The nonlinear damping coefficient used for the axial translational degree of freedom, U1. This item applies for nonlinear analyses. (F/L)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property.
     * @return zero if the property data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getTCFrictionIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slow: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fast: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rate: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, radius: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slowT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fastT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rateT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, kt: ADoubleByRef = DoubleByRef.UNNECESSARY, dis: ADoubleByRef = DoubleByRef.UNNECESSARY, dist: ADoubleByRef = DoubleByRef.UNNECESSARY, damping: ADoubleByRef = DoubleByRef.UNNECESSARY, dj2: ADoubleByRef = DoubleByRef.UNNECESSARY, dj3: ADoubleByRef = DoubleByRef.UNNECESSARY, notes: AStringByRef = StringByRef.UNNECESSARY, GUID: AStringByRef = StringByRef.UNNECESSARY): Int =
            callFunctionInt("GetTCFrictionIsolator", name, DOF, fixed, nonLinear, ke, ce, k, slow, fast, rate, radius, slowT, fastT, rateT, kt, dis, dist, damping, dj2, dj3, notes, GUID)

    /**
     * This function retrieves the property type for the specified link property.
     * @param name The name of an existing link property.
     * @param propType This is one of the following items in the [LinkPropType] enumeration.
     * * LINEAR = 1
     * * DAMPER = 2
     * * GAP = 3
     * * HOOK = 4
     * * PLASTIC_WEN = 5
     * * ISOLATOR1 = 6 (Rubber isolator)
     * * ISOLATOR2 = 7 (Friction isolator)
     * * MULTILINEAR_ELASTIC = 8
     * * MULTILINEAR_PLASTIC = 9
     * * ISOLATOR3 = 10 (T/C Friction isolator)
     * @return zero if the type is successfully retrieved; otherwise it returns nonzero.
     */
    fun getType(name: String, propType: AIntByRef = IntByRef.UNNECESSARY): Int =
            callFunctionInt("GetType", name, propType)

    /**
     * This function retrieves weight and mass data for a link property.
     * @param name The name of an existing link property.
     * @param w The weight of the link. (F)
     * @param m The translational mass of the link. (M)
     * @param r1 The rotational inertia of the link about its local 1 axis. (ML2)
     * @param r2 The rotational inertia of the link about its local 2 axis. (ML2)
     * @param r3 The rotational inertia of the link about its local 3 axis. (ML2)
     * @return zero if the data is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getWeightAndMass(name: String, w: ADoubleByRef = DoubleByRef.UNNECESSARY, m: ADoubleByRef = DoubleByRef.UNNECESSARY, r1: ADoubleByRef = DoubleByRef.UNNECESSARY, r2: ADoubleByRef = DoubleByRef.UNNECESSARY, r3: ADoubleByRef = DoubleByRef.UNNECESSARY): Int =
            callFunctionInt("GetWeightAndMass", name, w, m, r1, r2, r3)

    /**
     * This function initializes a damper-type link property. If this function is called for an existing link property, all items for the property are reset to their default values.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) only applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param c This is an array of nonlinear damping coefficient terms for the link property. The nonlinear damping coefficient applies for nonlinear analyses.
     * * c(0) = U1 (F/(L^cexp))
     * * c(1) = U2 (F/(L^cexp))
     * * c(2) = U3 (F/(L^cexp))
     * * c(3) = R1 (FL)
     * * c(4) = R2 (FL)
     * * c(5) = R3 (FL)
     * The term c(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param cexp This is an array of the nonlinear damping exponent terms. The nonlinear damping exponent applies for nonlinear analyses. It is applied to the velocity across the damper in the equation of motion.
     * * cexp(0) = U1
     * * cexp(1) = U2
     * * cexp(2) = U3
     * * cexp(3) = R1
     * * cexp(4) = R2
     * * cexp(5) = R3
     * The term cexp(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setDamper(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, c: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, cexp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetDamper", name, DOF, fixed, nonLinear, ke, ce, k, c, cexp, dj2, dj3, notes, GUID)

    /**
     * This function initializes a friction isolator-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slow This is an array of the friction coefficient at zero velocity terms for the link property. This coefficient applies for nonlinear analyses.
     * * Slow(0) = U1, Not Used
     * * Slow(1) = U2
     * * Slow(2) = U3
     * * Slow(3) = R1, Not Used
     * * Slow(4) = R2, Not Used
     * * Slow(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Slow(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fast This is an array of the friction coefficient at fast velocity terms for the link property. This coefficient applies for nonlinear analyses.
     * * Fast(0) = U1, Not Used
     * * Fast(1) = U2
     * * Fast(2) = U3
     * * Fast(3) = R1, Not Used
     * * Fast(4) = R2, Not Used
     * * Fast(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Fast(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rate This is an array of the inverse of the characteristic sliding velocity terms for the link property. This item applies for nonlinear analyses.
     * * Rate(0) = U1, Not Used
     * * Rate(1) = U2 (s/L)
     * * Rate(2) = U3 (s/L)
     * * Rate(3) = R1, Not Used
     * * Rate(4) = R2, Not Used
     * * Rate(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Rate(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param radius This is an array of the radius of the sliding contact surface terms for the link property. Inputting 0 means there is an infinite radius, that is, the slider is flat. This item applies for nonlinear analyses.
     * * Radius(0) = U1, Not Used
     * * Radius(1) = U2 (L)
     * * Radius(2) = U3 (L)
     * * Radius(3) = R1, Not Used
     * * Radius(4) = R2, Not Used
     * * Radius(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Radius(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param damping This is the nonlinear damping coefficient used for the axial translational degree of freedom, U1. This item applies for nonlinear analyses. (F/L)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setFrictionIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slow: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fast: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rate: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, radius: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, damping: Double, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetFrictionIsolator", name, DOF, fixed, nonLinear, ke, ce, k, slow, fast, rate, radius, damping, dj2, dj3, notes, GUID)

    /**
     * This function initializes a gap-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property then that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dis This is an array of initial gap opening terms for the link property. The initial gap opening applies for nonlinear analyses.
     * * c(0) = U1 (L)
     * * c(1) = U2 (L)
     * * c(2) = U3 (L)
     * * c(3) = R1 (rad)
     * * c(4) = R2 (rad)
     * * c(5) = R3 (rad)
     * The term dis(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setGap(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dis: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetGap", name, DOF, fixed, nonLinear, ke, ce, k, dis, dj2, dj3, notes, GUID)

    /**
     * This function initializes a hook-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property then that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dis This is an array of initial hook opening terms for the link property. The initial hook opening applies for nonlinear analyses.
     * * c(0) = U1 (L)
     * * c(1) = U2 (L)
     * * c(2) = U3 (L)
     * * c(3) = R1 (rad)
     * * c(4) = R2 (rad)
     * * c(5) = R3 (rad)
     * The term dis(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setHook(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dis: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetHook", name, DOF, fixed, nonLinear, ke, ce, k, dis, dj2, dj3, notes, GUID)

    /**
     * This function initializes a linear-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity if DOF(0) = True
     * * Fixed(1) = U2 fixity if DOF(1) = True
     * * Fixed(2) = U3 fixity if DOF(2) = True
     * * Fixed(3) = R1 fixity if DOF(3) = True
     * * Fixed(4) = R2 fixity if DOF(4) = True
     * * Fixed(5) = R3 fixity if DOF(5) = True
     * @param ke This is an array of stiffness terms for the link property. There are 6 terms in the array if the stiffness is uncoupled and 21 if it is coupled. The KeCoupled item indicates if the stiffness is coupled.
     * If the stiffness is uncoupled:
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * If the stiffness is coupled:
     * * Ke(0) = U1U1 (F/L)
     * * Ke(1) = U1U2 (F/L)
     * * Ke(2) = U2U2 (F/L)
     * * Ke(3) = U1U3 (F/L)
     * * Ke(4) = U2U3 (F/L)
     * * Ke(5) = U3U3 (F/L)
     * * Ke(6) = U1R1 (F)
     * * Ke(7) = U2R1 (F)
     * * Ke(8) = U3R1 (F)
     * * Ke(9) = R1R1 (FL)
     * * Ke(10) = U1R2 (F)
     * * Ke(11) = U2R2 (F)
     * * Ke(12) = U3R2 (F)
     * * Ke(13) = R1R2 (FL)
     * * Ke(14) = R2R2 (FL)
     * * Ke(15) = U1R3 (F)
     * * Ke(16) = U2R3 (F)
     * * Ke(17) = U3R3 (F)
     * * Ke(18) = R1R3 (FL)
     * * Ke(19) = R2R3 (FL)
     * * Ke(20) = R3R3 (FL)
     * @param ce This is an array of damping terms for the link property. There are 6 terms in the array if the damping is uncoupled and 21 if it is coupled. The CeCoupled item indicates if the damping is coupled.
     * If the damping is uncoupled:
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * If the damping is coupled:
     * * Ce(0) = U1U1 (F/L)
     * * Ce(1) = U1U2 (F/L)
     * * Ce(2) = U2U2 (F/L)
     * * Ce(3) = U1U3 (F/L)
     * * Ce(4) = U2U3 (F/L)
     * * Ce(5) = U3U3 (F/L)
     * * Ce(6) = U1R1 (F)
     * * Ce(7) = U2R1 (F)
     * * Ce(8) = U3R1 (F)
     * * Ce(9) = R1R1 (FL)
     * * Ce(10) = U1R2 (F)
     * * Ce(11) = U2R2 (F)
     * * Ce(12) = U3R2 (F)
     * * Ce(13) = R1R2 (FL)
     * * Ce(14) = R2R2 (FL)
     * * Ce(15) = U1R3 (F)
     * * Ce(16) = U2R3 (F)
     * * Ce(17) = U3R3 (F)
     * * Ce(18) = R1R3 (FL)
     * * Ce(19) = R2R3 (FL)
     * * Ce(20) = R3R3 (FL)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param keCoupled This item is True if the link stiffness, Ke, is coupled. There are 21 terms in the Ke array if Ke is coupled; otherwise there are 6 terms.
     * @param ceCoupled This item is True if the link damping, Ce, is coupled. There are 21 terms in the Ce array if Ce is coupled; otherwise there are 6 terms.
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setLinear(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, keCoupled: Boolean = false, ceCoupled: Boolean = false, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetLinear", name, DOF, fixed, ke, ce, dj2, dj3, keCoupled, ceCoupled, notes, GUID)

    /**
     * This function initializes a multilinear elastic-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property then. that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setMultiLinearElastic(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetMultiLinearElastic", name, DOF, fixed, nonLinear, ke, ce, dj2, dj3, notes, GUID)

    /**
     * This function initializes a multilinear plastic-type link property. If this function is called for an existing link property, all items for the property are reset to their default values.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setMultiLinearPlastic(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetMultiLinearPlastic", name, DOF, fixed, nonLinear, ke, ce, dj2, dj3, notes, GUID)

    /**
     * This function sets the force-deformation data for a specified degree of freedom in multilinear elastic and multilinear plastic link properties.
     * The function returns zero if the data is successfully assigned; otherwise it returns a nonzero value.
     * To successfully apply this data to the indicated link property, the following conditions must be met:
     * 1. The link property must be multilinear elastic or multilinear plastic.
     * 2. The specified DOF must be active.
     * 3. The specified DOF must not be fixed.
     * @param name The name of an existing multilinear elastic or multilinear plastic link property.
     * @param DOF This is 1, 2, 3, 4, 5 or 6, indicating the degree of freedom to which the multilinear points apply.
     * * 1 = U1
     * * 2 = U2
     * * 3 = U3
     * * 4 = R1
     * * 5 = R2
     * * 6 = R3
     * @param numberPoints The number of foce-defomation points for the specified degree of freedom.
     * @param f This is an array, dimensioned to NumberPoints, that includes the force at each point. When DOF is U1, U2 or U3, this is a force. When DOF is R1, R2 or R3. this is a moment. (F) if DOF <= 3, and (FL) if DOF > 3
     * @param d This is an array, dimensioned to NumberPoints, that includes the displacement at each point. When DOF is U1, U2 or U3, this is a translation. When DOF is R1, R2 or R3, this is a rotation. (L) if DOF <= 3, and (rad) if DOF > 3
     * @param myType This item applies only to multilinear plastic link properties. It is 1, 2 or 3, indicating the hysteresis type.
     * * 1 = Kinematic
     * * 2 = Takeda
     * * 3 = Pivot
     * @param a1 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Alpha1 hysteresis parameter.
     * @param a2 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Alpha2 hysteresis parameter.
     * @param b1 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Beta1 hysteresis parameter.
     * @param b2 This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Beta2 hysteresis parameter.
     * @param eta This item applies only to multilinear plastic link properties that have a pivot hysteresis type (MyType = 3). It is the Eta hysteresis parameter.
     * @return
     */
    fun setMultiLinearPoints(name: String, DOF: Int, numberPoints: Int, f: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, d: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, myType: Int = 1, a1: Double = 0.0, a2: Double = 0.0, b1: Double = 0.0, b2: Double = 0.0, eta: Double = 0.0): Int =
            callFunctionInt("SetMultiLinearPoints", name, DOF, numberPoints, f, d, myType, a1, a2, b1, b2, eta)

    /**
     * This function assigns P-delta parameters to a link property.
     * @param name The name of an existing link property.
     * @param value This is an array of P-delta parameters.
     * * Value(0) = M2 P-delta to I-end of link as moment, M2I
     * * Value(1) = M2 P-delta to J-end of link as moment, M2J
     * * Value(2) = M3 P-delta to I-end of link as moment, M3I
     * * Value(3) = M3 P-delta to J-end of link as moment, M3J
     * @return zero if the values are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setPDelta(name: String, value: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY): Int =
            callFunctionInt("SetPDelta", name, value)

    /**
     * This function initializes a plastic Wen-type link property. If this function is called for an existing link property, all items for the property are reset to their default values.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1 has nonlinear properties
     * * NonLinear(4) = R2 has nonlinear properties
     * * NonLinear(5) = R3 has nonlinear properties
     * The term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1 (FL)
     * * k(4) = R2 (FL)
     * * k(5) = R3 (FL)
     * The term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param yield This is an array of yield force terms for the link property. The yield force applies for nonlinear analyses.
     * * Yield(0) = U1 (F)
     * * Yield(1) = U2 (F)
     * * Yield(2) = U3 (F)
     * * Yield(3) = R1 (FL)
     * * Yield(4) = R2 (FL)
     * * Yield(5) = R3 (FL)
     * The term Yield(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param ratio This is an array of post-yield stiffness ratio terms for the link property. The post-yield stiffness ratio applies for nonlinear analyses. It is the post-yield stiffness divided by the initial stiffness.
     * * Ratio(0) = U1
     * * Ratio(1) = U2
     * * Ratio(2) = U3
     * * Ratio(3) = R1
     * * Ratio(4) = R2
     * * Ratio(5) = R3
     * The term Ratio(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param exp This is an array of yield exponent terms for the link property. The yield exponent applies for nonlinear analyses. The yielding exponent that controls the sharpness of the transition from the initial stiffness to the yielded stiffness.
     * * exp(0) = U1
     * * exp(1) = U2
     * * exp(2) = U3
     * * exp(3) = R1
     * * exp(4) = R2
     * * exp(5) = R3
     * The term exp(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setPlasticWen(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, `yield`: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ratio: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, exp: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetPlasticWen", name, DOF, fixed, nonLinear, ke, ce, k, `yield`, ratio, exp, dj2, dj3, notes, GUID)

    /**
     * This function initializes a rubber isolator-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1, Not Used
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1, Not Used
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param yield This is an array of yield force terms for the link property. The yield force applies for nonlinear analyses.
     * * Yield(0) = U1, Not Used
     * * Yield(1) = U2 (F)
     * * Yield(2) = U3 (F)
     * * Yield(3) = R1, Not Used
     * * Yield(4) = R2, Not Used
     * * Yield(5) = R3, Not Used
     * The term Yield(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param ratio This is an array of post-yield stiffness ratio terms for the link property. The post-yield stiffness ratio applies for nonlinear analyses. It is the post-yield stiffness divided by the initial stiffness.
     * * Ratio(0) = U1, Not Used
     * * Ratio(1) = U2
     * * Ratio(2) = U3
     * * Ratio(3) = R1, Not Used
     * * Ratio(4) = R2, Not Used
     * * Ratio(5) = R3, Not Used
     * The term Ratio(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setRubberIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, `yield`: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ratio: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetRubberIsolator", name, DOF, fixed, nonLinear, ke, ce, k, `yield`, ratio, dj2, dj3, notes, GUID)

    /**
     * This function assigns length and area values to a link property that are used if the link property is specified in line and area spring assignments.
     * @param name The name of an existing link property.
     * @param definedForThisLength The link property is defined for this length in a line (frame) spring. (L)
     * @param definedForThisArea The link property is defined for this area in an area spring. (L2)
     * @return zero if the values are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setSpringData(name: String, definedForThisLength: Double, definedForThisArea: Double): Int =
            callFunctionInt("SetSpringData", name, definedForThisLength, definedForThisArea)

    /**
     * This function initializes a T/C friction isolator-type link property. If this function is called for an existing link property, all items for the property are reset to their default value.
     * @param name The name of an existing or new link property. If this is an existing property, that property is modified; otherwise, a new property is added.
     * @param DOF This is a boolean array, dimensioned to 6, indicating if properties exist for a specified degree of freedom.
     * * DOF(0) = U1
     * * DOF(1) = U2
     * * DOF(2) = U3
     * * DOF(3) = R1
     * * DOF(4) = R2
     * * DOF(5) = R3
     * @param fixed This is a boolean array, dimensioned to 6, indicating if the specified degree of freedom is fixed (restrained).
     * * Fixed(0) = U1 fixity
     * * Fixed(1) = U2 fixity
     * * Fixed(2) = U3 fixity
     * * Fixed(3) = R1 fixity
     * * Fixed(4) = R2 fixity
     * * Fixed(5) = R3 fixity
     * The term Fixed(n) applies only when DOF(n) = True.
     * @param nonLinear This is a boolean array, dimensioned to 6, indicating if nonlinear properties exist for a specified degree of freedom.
     * * NonLinear(0) = U1 has nonlinear properties
     * * NonLinear(1) = U2 has nonlinear properties
     * * NonLinear(2) = U3 has nonlinear properties
     * * NonLinear(3) = R1, Not Used
     * * NonLinear(4) = R2, Not Used
     * * NonLinear(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term NonLinear(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ke This is an array of effective stiffness terms for the link property. The effective stiffness applies for linear analyses.
     * * Ke(0) = U1 (F/L)
     * * Ke(1) = U2 (F/L)
     * * Ke(2) = U3 (F/L)
     * * Ke(3) = R1 (FL)
     * * Ke(4) = R2 (FL)
     * * Ke(5) = R3 (FL)
     * The term Ke(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param ce This is an array of effective damping terms for the link property. The effective damping applies for linear analyses.
     * * Ce(0) = U1 (F/L)
     * * Ce(1) = U2 (F/L)
     * * Ce(2) = U3 (F/L)
     * * Ce(3) = R1 (FL)
     * * Ce(4) = R2 (FL)
     * * Ce(5) = R3 (FL)
     * The term Ce(n) applies only when DOF(n) = True and Fixed(n) = False.
     * @param k This is an array of initial stiffness terms for the link property. The initial stiffness applies for nonlinear analyses.
     * * k(0) = U1 (F/L)
     * * k(1) = U2 (F/L)
     * * k(2) = U3 (F/L)
     * * k(3) = R1, Not Used
     * * k(4) = R2, Not Used
     * * k(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U1, U2 and U3. For those degrees of freedom, the term k(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slow This is an array of the friction coefficient at zero velocity terms when U1 is in compression for the link property. This coefficient applies for nonlinear analyses.
     * * Slow(0) = U1, Not Used
     * * Slow(1) = U2
     * * Slow(2) = U3
     * * Slow(3) = R1, Not Used
     * * Slow(4) = R2, Not Used
     * * Slow(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Slow(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fast This is an array of the friction coefficient at fast velocity terms when U1 is in compression for the link property. This coefficient applies for nonlinear analyses.
     * * Fast(0) = U1, Not Used
     * * Fast(1) = U2
     * * Fast(2) = U3
     * * Fast(3) = R1, Not Used
     * * Fast(4) = R2, Not Used
     * * Fast(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Fast(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rate This is an array of the inverse of the characteristic sliding velocity terms when U1 is in compression for the link property. This item applies for nonlinear analyses.
     * * Rate(0) = U1, Not Used
     * * Rate(1) = U2 (s/L)
     * * Rate(2) = U3 (s/L)
     * * Rate(3) = R1, Not Used
     * * Rate(4) = R2, Not Used
     * * Rate(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Rate(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param radius This is an array of the radius of the sliding contact surface terms for the link property. Inputting 0 means there is an infinite radius, that is, the slider is flat. This item applies for nonlinear analyses.
     * * Radius(0) = U1, Not Used
     * * Radius(1) = U2 (L)
     * * Radius(2) = U3 (L)
     * * Radius(3) = R1, Not Used
     * * Radius(4) = R2, Not Used
     * * Radius(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term Radius(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param slowT This is an array of the friction coefficient at zero velocity terms when U1 is in tension for the link property. This coefficient applies for nonlinear analyses.
     * * SlowT(0) = U1, Not Used
     * * SlowT(1) = U2
     * * SlowT(2) = U3
     * * SlowT(3) = R1, Not Used
     * * SlowT(4) = R2, Not Used
     * * SlowT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term SlowT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param fastT This is an array of the friction coefficient at fast velocity terms when U1 is in tension for the link property. This coefficient applies for nonlinear analyses.
     * * FastT(0) = U1, Not Used
     * * FastT(1) = U2
     * * FastT(2) = U3
     * * FastT(3) = R1, Not Used
     * * FastT(4) = R2, Not Used
     * * FastT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term FastT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param rateT This is an array of the inverse of the characteristic sliding velocity terms when U1 is in tension for the link property. This item applies for nonlinear analyses.
     * * RateT(0) = U1, Not Used
     * * RateT(1) = U2 (s/L)
     * * RateT(2) = U3 (s/L)
     * * RateT(3) = R1, Not Used
     * * RateT(4) = R2, Not Used
     * * RateT(5) = R3, Not Used
     * Note that this item is applicable only for degrees of freedom U2 and U3. For those degrees of freedom, the term RateT(n) applies only when DOF(n) = True, Fixed(n) = False and NonLinear(n) = True.
     * @param kt The axial translational tension stiffness for the U1 degree of freedom. This item applies for nonlinear analyses. (F/L)
     * @param dis The U1 degree of freedom gap opening for compression. This item applies for nonlinear analyses. (L)
     * @param dist The U1 degree of freedom gap opening for tension. This item applies for nonlinear analyses. (L)
     * @param damping The nonlinear damping coefficient used for the axial translational degree of freedom, U1. This item applies for nonlinear analyses. (F/L)
     * @param dj2 The distance from the J-End of the link to the U2 shear spring. This item applies only when DOF(1) = True. (L)
     * @param dj3 The distance from the J-End of the link to the U3 shear spring. This item applies only when DOF(2) = True. (L)
     * @param notes The notes, if any, assigned to the property.
     * @param GUID The GUID (global unique identifier), if any, assigned to the property. If this item is input as Default, the program assigns a GUID to the property.
     * @return zero if the property is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setTCFrictionIsolator(name: String, DOF: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, fixed: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, nonLinear: ABooleanArrayByRef = BooleanArrayByRef.UNNECESSARY, ke: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, ce: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, k: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slow: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fast: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rate: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, radius: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, slowT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, fastT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, rateT: ADoubleArrayByRef = DoubleArrayByRef.UNNECESSARY, kt: Double, dis: Double, dist: Double, damping: Double, dj2: Double, dj3: Double, notes: String = "", GUID: String = ""): Int =
            callFunctionInt("SetTCFrictionIsolator", name, DOF, fixed, nonLinear, ke, ce, k, slow, fast, rate, radius, slowT, fastT, rateT, kt, dis, dist, damping, dj2, dj3, notes, GUID)

    /**
     * This function assigns weight and mass values to a link property.
     * @param name The name of an existing link property.
     * @param w The weight of the link. (F)
     * @param m The translational mass of the link. (M)
     * @param r1 The rotational inertia of the link about its local 1 axis. (ML2)
     * @param r2 The rotational inertia of the link about its local 2 axis. (ML2)
     * @param r3 The rotational inertia of the link about its local 3 axis. (ML2)
     * @return zero if the values are successfully assigned; otherwise it returns a nonzero value.
     */
    fun setWeightAndMass(name: String, w: Double, m: Double, r1: Double, r2: Double, r3: Double): Int =
            callFunctionInt("SetWeightAndMass", name, w, m, r1, r2, r3)
}