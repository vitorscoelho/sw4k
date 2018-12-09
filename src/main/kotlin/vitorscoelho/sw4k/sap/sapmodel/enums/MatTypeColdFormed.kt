package vitorscoelho.sw4k.sap.sapmodel.enums

enum class MatTypeColdFormed(override val sapId: Int) : EnumWithSapIdInt {
    ASTM_A653SQGr33(1),
    ASTM_A653SQGr50(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeColdFormed with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeColdFormed>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeColdFormed() = Array(size = this.size) { MatTypeColdFormed.get(sapId = this[it]) }
fun Int.toMatTypeColdFormed() = MatTypeColdFormed.get(sapId = this)