package vitorscoelho.sw4k.sap14.enums

enum class PDeltaDirection(override val sapId: Int) : EnumWithSapIdInt {
    /**Frame object local 1-axis direction*/
    FRAME_LOCAL_1_AXIS(0),

    /**Projected X direction in CSys coordinate system*/
    PROJECTED_X(1),

    /**Projected Y direction in CSys coordinate system*/
    PROJECTED_Y(2),

    /**Projected Z direction in CSys coordinate system*/
    PROJECTED_Z(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("PDeltaDirection with sapId=$sapId nonexistent.") }
    }
}

fun Array<PDeltaDirection>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toPDeltaDirection() = Array(size = this.size) { PDeltaDirection.get(sapId = this[it]) }
fun Int.toPDeltaDirection() = PDeltaDirection.get(sapId = this)