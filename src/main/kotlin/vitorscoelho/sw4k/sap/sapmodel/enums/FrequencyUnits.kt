package vitorscoelho.sw4k.sap.sapmodel.enums

enum class FrequencyUnits(override val sapId: Int) : EnumWithSapIdInt {
    /**Hertz (cyc/s)*/
    HZ(1),

    /**Revolutions per minute*/
    RPM(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("FrequencyUnits with sapId=$sapId nonexistent.") }
    }
}

fun Array<FrequencyUnits>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toFrequencyUnits() = Array(size = this.size) { FrequencyUnits.get(sapId = this[it]) }
fun Int.toFrequencyUnits() = FrequencyUnits.get(sapId = this)