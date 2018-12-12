package vitorscoelho.sw4k.sap.enums

enum class LineTemperatureLoadType(override val sapId: Int) : EnumWithSapIdInt {
    TEMPERATURE(1),
    TEMPERATURE_GRADIENT_ALONG_LOCAL_2_AXIS(2),
    TEMPERATURE_GRADIENT_ALONG_LOCAL_3_AXIS(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LineTemperatureLoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LineTemperatureLoadType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLineTemperatureLoadType() = Array(size = this.size) { LineTemperatureLoadType.get(sapId = this[it]) }
fun Int.toLineTemperatureLoadType() = LineTemperatureLoadType.get(sapId = this)