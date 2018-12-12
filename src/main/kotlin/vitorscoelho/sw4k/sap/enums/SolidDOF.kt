package vitorscoelho.sw4k.sap.enums

enum class SolidDOF(override val sapId: Int) : EnumWithSapIdInt {
    STRAIN_11(1),
    STRAIN_22(2),
    STRAIN_33(3),
    STRAIN_12(4),
    STRAIN_13(5),
    STRAIN_23(6);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("SolidDOF with sapId=$sapId nonexistent.") }
    }
}

fun Array<SolidDOF>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toSolidDOF() = Array(size = this.size) { SolidDOF.get(sapId = this[it]) }
fun Int.toSolidDOF() = SolidDOF.get(sapId = this)