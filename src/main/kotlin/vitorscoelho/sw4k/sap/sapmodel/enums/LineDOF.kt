package vitorscoelho.sw4k.sap.sapmodel.enums

enum class LineDOF(override val sapId: Int) : EnumWithSapIdInt {
    STRAIN_11(1),
    STRAIN_12(2),
    STRAIN_13(3),
    CURVATURE_1(4),
    CURVATURE_2(5),
    CURVATURE_3(6);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LineDOF with sapId=$sapId nonexistent.") }
    }
}

fun Array<LineDOF>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLineDOF() = Array(size = this.size) { LineDOF.get(sapId = this[it]) }
fun Int.toLineDOF() = LineDOF.get(sapId = this)