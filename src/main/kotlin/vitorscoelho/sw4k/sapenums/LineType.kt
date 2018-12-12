package vitorscoelho.sw4k.sapenums

enum class LineType(override val sapId: Int) : EnumWithSapIdInt {
    STRAIGHT_FRAME(0),
    CURVED_FRAME(1),
    CABLE(2),
    TENDON(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LineType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LineType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLineType() = Array(size = this.size) { LineType.get(sapId = this[it]) }
fun Int.toLineType() = LineType.get(sapId = this)