package vitorscoelho.sw4k.sapenums

enum class ConstraintType(override val sapId: Int) : EnumWithSapIdInt {
    BODY(1),
    DIAPHRAGM(2),
    PLATE(3),
    ROD(4),
    BEAM(5),
    EQUAL(6),
    LOCAL(7),
    WELD(8),
    LINE(13);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ConstraintType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ConstraintType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toConstraintType() = Array(size = this.size) { ConstraintType.get(sapId = this[it]) }
fun Int.toConstraintType() = ConstraintType.get(sapId = this)