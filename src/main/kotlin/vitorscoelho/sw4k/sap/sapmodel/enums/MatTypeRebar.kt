package vitorscoelho.sw4k.sap.sapmodel.enums

enum class MatTypeRebar(override val sapId: Int) : EnumWithSapIdInt {
    ASTM_A615Gr40(1),
    ASTM_A615Gr60(2),
    ASTM_A615Gr75(3),
    ASTM_A706(4),
    CHINESE_HPB235(5),
    CHINESE_HRB335(6),
    CHINESE_HRB400(7);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeRebar with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeRebar>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeRebar() = Array(size = this.size) { MatTypeRebar.get(sapId = this[it]) }
fun Int.toMatTypeRebar() = MatTypeRebar.get(sapId = this)