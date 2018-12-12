package vitorscoelho.sw4k.sap.enums

enum class TimeHistoryMotionType(override val sapId: Int) : EnumWithSapIdInt {
    TRANSIENT(1),
    PERIODIC(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("TimeHistoryMotionType with sapId=$sapId nonexistent.") }
    }
}

fun Array<TimeHistoryMotionType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toTimeHistoryMotionType() = Array(size = this.size) { TimeHistoryMotionType.get(sapId = this[it]) }
fun Int.toTimeHistoryMotionType() = TimeHistoryMotionType.get(sapId = this)