package vitorscoelho.sw4k.sap14.enums

enum class SolverType(override val sapId: Int) : EnumWithSapIdInt {
    STANDARD(0),
    ADVANCED(1);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("SolverType with sapId=$sapId nonexistent.") }
    }
}

fun Array<SolverType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toSolverType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toSolverType() = SolverType.get(sapId = this)