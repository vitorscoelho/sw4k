package vitorscoelho.sw4k.sap.sapmodel.enums

enum class PointLoadType(override val sapId: Int) : EnumWithSapIdInt {
    FORCE(1),
    MOMENT(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("PointLoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<PointLoadType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toPointLoadType() = Array(size = this.size) { PointLoadType.get(sapId = this[it]) }
fun Int.toPointLoadType() = PointLoadType.get(sapId = this)