package vitorscoelho.sw4k.sap14.enums

enum class AreaTemperatureLoadType(override val sapId: Int) : EnumWithSapIdInt {
    TEMPERATURE(1),
    TEMPERATURE_GRADIENT_ALONG_LOCAL_3_AXIS(3);
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("AreaTemperatureLoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<AreaTemperatureLoadType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toAreaTemperatureLoadType() = Array(size = this.size) { AreaTemperatureLoadType.get(sapId = this[it]) }
fun Int.toAreaTemperatureLoadType() = AreaTemperatureLoadType.get(sapId = this)