package vitorscoelho.sw4k.sapversions.v14.sapmodel.edit

import vitorscoelho.sw4k.comutils.*

interface EditSolidV14 : SapComponent {
    /**
     * This function meshes solid objects.
     * @param name The name of an existing solid object.
     * @param n1 This is the number of objects created between faces 2 and 4 of the solid object.
     * @param n2 This is the number of objects created between faces 1 and 3 of the solid object.
     * @param n3 This is the number of objects created between faces 5 and 6 of the solid object.
     * @param numberSolids The number of solid objects created when the specified solid object is divided.
     * @param solidName This is an array of the name of each solid object created when the specified solid object is divided.
     * @return zero if the meshing is successful; otherwise it returns a nonzero value.
     */
    fun divide(name: String, n1: Int, n2: Int, n3: Int, numberSolids: AIntByRef = IntByRef.UNNECESSARY, solidName: AStringArrayByRef = StringArrayByRef.UNNECESSARY): Int =
            callFunctionInt("Divide", name, n1, n2, n3, numberSolids, solidName)
}