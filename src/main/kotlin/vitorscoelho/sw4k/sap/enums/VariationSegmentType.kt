package vitorscoelho.sw4k.sap.enums

enum class VariationSegmentType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR(1),
    PARABOLIC(2),
    CUBIC(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("VariationSegmentType with sapId=$sapId nonexistent.") }
    }
}

fun Array<VariationSegmentType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toVariationSegmentType() = Array(size = this.size) { VariationSegmentType.get(sapId = this[it]) }
fun Int.toVariationSegmentType() = VariationSegmentType.get(sapId = this)