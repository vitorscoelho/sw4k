package vitorscoelho.sw4k.sap.sapmodel.enums

enum class MatType(override val sapId: Int) : EnumWithSapIdInt {
    STEEL(1),
    CONCRETE(2),
    NODESIGN(3),
    ALUMINUM(4),
    COLDFORMED(5),
    REBAR(6),
    TENDON(7);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatType with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatType() = Array(size = this.size) { MatType.get(sapId = this[it]) }
fun Int.toMatType() = MatType.get(sapId = this)