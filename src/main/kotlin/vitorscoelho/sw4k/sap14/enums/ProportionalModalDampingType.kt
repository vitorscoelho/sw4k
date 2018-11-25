package vitorscoelho.sw4k.sap14.enums

enum class ProportionalModalDampingType(override val sapId: Int) : EnumWithSapIdInt {
    /**Mass and stiffness proportional damping by direct specification*/
    BY_DIRECT_SPECIFICATION(1),

    /**Mass and stiffness proportional damping by period*/
    BY_PERIOD(2),

    /**Mass and stiffness proportional damping by frequency*/
    BY_FREQUENCY(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ProportionalModalDampingType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ProportionalModalDampingType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toProportionalModalDampingType() = Array(size = this.size) { ProportionalModalDampingType.get(sapId = this[it]) }
fun Int.toProportionalModalDampingType() = ProportionalModalDampingType.get(sapId = this)