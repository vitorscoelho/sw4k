package vitorscoelho.sw4k.sap.sapmodel.enums

enum class WeightOrMass(override val sapId: Int) : EnumWithSapIdInt {
    WEIGHT_PER_UNIT_VOLUME(1),
    MASS_PER_UNIT_VOLUME(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("WeightOrMass with sapId=$sapId nonexistent.") }
    }
}

fun Array<WeightOrMass>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toWeightOrMass() = Array(size = this.size) { WeightOrMass.get(sapId = this[it]) }
fun Int.toWeightOrMass() = WeightOrMass.get(sapId = this)