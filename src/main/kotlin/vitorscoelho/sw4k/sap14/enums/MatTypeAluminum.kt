package vitorscoelho.sw4k.sap14.enums

enum class MatTypeAluminum(override val sapId: Int) : EnumWithSapIdInt {
    ALU_6061_T6 ( 1),
    ALU_6063_T6 ( 2),
    ALU_5052_H34 ( 3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MatTypeAluminum with sapId=$sapId nonexistent.") }
    }
}

fun Array<MatTypeAluminum>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMatTypeAluminum() = Array(size = this.size) { MatTypeAluminum.get(sapId = this[it]) }
fun Int.toMatTypeAluminum() = MatTypeAluminum.get(sapId = this)