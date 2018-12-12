package vitorscoelho.sw4k.sapenums

enum class ComboType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR_ADDITIVE(0),
    ENVELOPE(1),
    ABSOLUTE_ADDITIVE(2),
    SRSS(3),
    RANGE_ADDITIVE(4);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ComboType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ComboType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toComboType() = Array(size = this.size) { ComboType.get(sapId = this[it]) }
fun Int.toComboType()=ComboType.get(sapId = this)