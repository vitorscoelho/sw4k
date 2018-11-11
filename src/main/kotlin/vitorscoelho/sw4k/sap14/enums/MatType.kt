package vitorscoelho.sw4k.sap14.enums

enum class MatType(override val sapId: Int) : EnumWithSapIdInt {
    MATERIAL_STEEL(1),
    MATERIAL_CONCRETE(2),
    MATERIAL_NODESIGN(3),
    MATERIAL_ALUMINUM(4),
    MATERIAL_COLDFORMED(5),
    MATERIAL_REBAR(6),
    MATERIAL_TENDON(7);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatType with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toMatType() = MatType.get(sapId = this)