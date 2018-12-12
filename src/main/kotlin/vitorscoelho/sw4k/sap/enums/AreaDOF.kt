package vitorscoelho.sw4k.sap.enums

enum class AreaDOF(override val sapId: Int) : EnumWithSapIdInt {
    STRAIN_11(1),
    STRAIN_22(2),
    STRAIN_12(3),
    CURVATURE_11(4),
    CURVATURE_22(5),
    CURVATURE_12(6),
    STRAIN_13(7),
    STRAIN_23(8);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("AreaDOF with sapId=$sapId nonexistent.") }
    }
}

fun Array<AreaDOF>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toAreaDOF() = Array(size = this.size) { AreaDOF.get(sapId = this[it]) }
fun Int.toAreaDOF() = AreaDOF.get(sapId = this)