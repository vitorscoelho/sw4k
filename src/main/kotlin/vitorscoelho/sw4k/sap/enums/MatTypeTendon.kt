package vitorscoelho.sw4k.sap.enums

enum class MatTypeTendon(override val sapId: Int) : EnumWithSapIdInt {
    ASTM_A416Gr250(1),
    ASTM_A416Gr270(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeTendon with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeTendon>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeTendon() = Array(size = this.size) { MatTypeTendon.get(sapId = this[it]) }
fun Int.toMatTypeTendon() = MatTypeTendon.get(sapId = this)