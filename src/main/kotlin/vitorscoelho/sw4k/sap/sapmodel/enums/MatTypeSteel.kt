package vitorscoelho.sw4k.sap.sapmodel.enums

enum class MatTypeSteel(override val sapId: Int) : EnumWithSapIdInt {
    ASTM_A36(1),
    ASTM_A53GrB(2),
    ASTM_A500GrB_Fy42(3),
    ASTM_A500GrB_Fy46(4),
    ASTM_A572Gr50(5),
    ASTM_A913Gr50(6),
    ASTM_A992_Fy50(7),
    CHINESE_Q235(8),
    CHINESE_Q345(9);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeSteel with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeSteel>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeSteel() = Array(size = this.size) { MatTypeSteel.get(sapId = this[it]) }
fun Int.toMatTypeSteel() = MatTypeSteel.get(sapId = this)