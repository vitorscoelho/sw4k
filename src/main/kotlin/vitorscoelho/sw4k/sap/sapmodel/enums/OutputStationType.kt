package vitorscoelho.sw4k.sap.sapmodel.enums

enum class OutputStationType(override val sapId: Int) : EnumWithSapIdInt {
    MAXIMUM_SEGMENT_SIZE(1),
    MINIMUM_NUMBER_OF_STATION(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("OutputStationType with sapId=$sapId nonexistent.") }
    }
}

fun Array<OutputStationType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toOutputStationType() = Array(size = this.size) { OutputStationType.get(sapId = this[it]) }
fun Int.toOutputStationType() = OutputStationType.get(sapId = this)