package vitorscoelho.sw4k.sap14.enums

enum class TimeIntegrationType(override val sapId: Int) : EnumWithSapIdInt {
    NEWMARK(1),
    WILSON(2),
    COLLOCATION(3),
    HILBER_HUGHES_TAYLOR(4),
    CHUNG_AND_HULBERT(5);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("TimeIntegrationType with sapId=$sapId nonexistent.") }
    }
}

fun Array<TimeIntegrationType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toTimeIntegrationType() = Array(size = this.size) { TimeIntegrationType.get(sapId = this[it]) }
fun Int.toTimeIntegrationType() = TimeIntegrationType.get(sapId = this)