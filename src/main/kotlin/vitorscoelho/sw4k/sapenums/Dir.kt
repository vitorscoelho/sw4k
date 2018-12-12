package vitorscoelho.sw4k.sapenums

enum class Dir(override val sapId: Int) : EnumWithSapIdInt {
    /**Local 1 axis (only applies when CSys is Local)*/
    LOCAL_1_AXIS(1),
    /**Local 2 axis (only applies when CSys is Local)*/
    LOCAL_2_AXIS(2),
    /**Local 3 axis (only applies when CSys is Local)*/
    LOCAL_3_AXIS(3),
    /**X direction (does not apply when CSys is Local)*/
    X_DIRECTION(4),
    /**Y direction (does not apply when CSys is Local)*/
    Y_DIRECTION(5),
    /**Z direction (does not apply when CSys is Local)*/
    Z_DIRECTION(6),
    /**Projected X direction (does not apply when CSys is Local)*/
    PROJECTED_X_DIRECTION(7),
    /**Projected Y direction (does not apply when CSys is Local)*/
    PROJECTED_Y_DIRECTION(8),
    /**Projected Z direction (does not apply when CSys is Local)*/
    PROJECTED_Z_DIRECTION(9),
    /**
     * Gravity direction (only applies when CSys is Global).
     * The positive gravity direction is in the negative Global Z direction.
     * */
    GRAVITY_DIRECTION(10),
    /**
     * Projected Gravity direction (only applies when CSys is Global)
     * The positive gravity direction is in the negative Global Z direction.
     * */
    PROJECTED_GRAVITY_DIRECTION(11);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("Dir with sapId=$sapId nonexistent.") }
    }
}

fun Array<Dir>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toDir() = Array(size = this.size) { Dir.get(sapId = this[it]) }
fun Int.toDir() = Dir.get(sapId = this)