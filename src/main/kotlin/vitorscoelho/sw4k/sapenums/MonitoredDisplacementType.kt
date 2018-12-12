package vitorscoelho.sw4k.sapenums

enum class MonitoredDisplacementType(override val sapId: Int) : EnumWithSapIdInt {
    /**Displacement at a specified point object*/
    SPECIFIED_POINT_OBJECT(1),

    /**Generalized displacement*/
    GENERALIZED(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MonitoredDisplacementType with sapId=$sapId nonexistent.") }
    }
}

fun Array<MonitoredDisplacementType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMonitoredDisplacementType() = Array(size = this.size) { MonitoredDisplacementType.get(sapId = this[it]) }
fun Int.toMonitoredDisplacementType() = MonitoredDisplacementType.get(sapId = this)