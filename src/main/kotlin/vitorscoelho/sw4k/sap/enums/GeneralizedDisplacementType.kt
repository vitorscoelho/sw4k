package vitorscoelho.sw4k.sap.enums

enum class GeneralizedDisplacementType(override val sapId: Int) : EnumWithSapIdInt {
    TRANSLATIONAL(1),
    ROTATIONAL(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("GeneralizedDisplacementType with sapId=$sapId nonexistent.") }
    }
}

fun Array<GeneralizedDisplacementType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toGeneralizedDisplacementType() = Array(size = this.size) { GeneralizedDisplacementType.get(sapId = this[it]) }
fun Int.toGeneralizedDisplacementType() = GeneralizedDisplacementType.get(sapId = this)