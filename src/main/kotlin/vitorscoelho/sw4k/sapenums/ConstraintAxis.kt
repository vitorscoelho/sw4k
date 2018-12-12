package vitorscoelho.sw4k.sapenums

enum class ConstraintAxis(override val sapId: Int) : EnumWithSapIdInt {
    X(1),
    Y(2),
    Z(3),
    AUTO_AXIS(4);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ConstraintAxis with sapId=$sapId nonexistent.") }
    }
}

fun Array<ConstraintAxis>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toConstraintAxis() = Array(size = this.size) { ConstraintAxis.get(sapId = this[it]) }
fun Int.toConstraintAxis() = ConstraintAxis.get(sapId = this)