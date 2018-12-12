package vitorscoelho.sw4k.sap.enums

enum class DampingType(override val sapId: Int) : EnumWithSapIdInt {
    /**Mass and stiffness proportional damping by direct specification*/
    MASS_STIFFNESS_PROPORTIONAL_BY_DIRECT_SPECIFICATION(1),

    /**Mass and stiffness proportional damping by period*/
    MASS_STIFFNESS_PROPORTIONAL_BY_PERIOD(2),

    /**Mass and stiffness proportional damping by frequency*/
    MASS_STIFFNESS_PROPORTIONAL_BY_FREQUENCY(3),

    /**Constant damping for all modes*/
    CONSTANT_ALL_MODES(4),

    /**Interpolated damping by period*/
    INTERPOLATED_BY_PERIOD(5),

    /**Interpolated damping by frequency*/
    INTERPOLATED_BY_FREQUENCY(6);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("DampingType with sapId=$sapId nonexistent.") }
    }
}

fun Array<DampingType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toDampingType() = Array(size = this.size) { DampingType.get(sapId = this[it]) }
fun Int.toDampingType() = DampingType.get(sapId = this)