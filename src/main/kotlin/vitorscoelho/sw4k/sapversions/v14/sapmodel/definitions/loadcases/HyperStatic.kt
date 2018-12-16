package vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.loadcases

import vitorscoelho.sw4k.comutils.SapComponent
import vitorscoelho.sw4k.comutils.AStringByRef
import vitorscoelho.sw4k.comutils.StringByRef

interface HyperStaticV14 : SapComponent {
    /**
     * This function retrieves the base case for the specified hyperstatic load case.
     * @param name The name of an existing hyperstatic load case.
     * @param baseCase The name of an existing static linear load case that is the base case for the specified hyperstatic load case.
     * @return zero if the base case is successfully retrieved; otherwise it returns a nonzero value.
     */
    fun getBaseCase (name:String,baseCase: AStringByRef = StringByRef.UNNECESSARY):Int=
            callFunctionInt("GetBaseCase",name,baseCase)
    /**
     * This function sets the base case for the specified hyperstatic load case.
     * @param name The name of an existing hyperstatic load case.
     * @param baseCase The name of an existing static linear load case that is the base case for the specified hyperstatic load case.
     * @return zero if the base case is successfully set; otherwise it returns a nonzero value.
     */
    fun setBaseCase (name:String,baseCase:String):Int=
            callFunctionInt("SetBaseCase",name,baseCase)
    /**
     * This function initializes a hyperstatic load case. If this function is called for an existing load case, all items for the case are reset to their default value.
     * @param name The name of an existing or new load case. If this is an existing case, that case is modified; otherwise, a new case is added.
     * @return zero if the load case is successfully initialized; otherwise it returns a nonzero value.
     */
    fun setCase (name:String):Int=
            callFunctionInt("SetCase",name)
}