package vitorscoelho.sw4k.sap.enums

enum class MatTypeConcrete(override val sapId: Int) : EnumWithSapIdInt {
    FC3000_NORMALWEIGHT(1),
    FC4000_NORMALWEIGHT(2),
    FC5000_NORMALWEIGHT(3),
    FC6000_NORMALWEIGHT(4),
    FC3000_LIGHTWEIGHT(5),
    FC4000_LIGHTWEIGHT(6),
    FC5000_LIGHTWEIGHT(7),
    FC6000_LIGHTWEIGHT(8),
    CHINESE_C20_NORMALWEIGHT(9),
    CHINESE_C30_NORMALWEIGHT(10),
    CHINESE_C40_NORMALWEIGHT(11);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeConcrete with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeConcrete>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeConcrete() = Array(size = this.size) { MatTypeConcrete.get(sapId = this[it]) }
fun Int.toMatTypeConcrete() = MatTypeConcrete.get(sapId = this)