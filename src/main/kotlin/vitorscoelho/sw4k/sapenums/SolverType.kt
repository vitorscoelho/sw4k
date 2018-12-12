package vitorscoelho.sw4k.sapenums

enum class SolverType(override val sapId: Int) : EnumWithSapIdInt {
    STANDARD(0),
    ADVANCED(1);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("SolverType with sapId=$sapId nonexistent.") }
    }
}

fun Array<SolverType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toSolverType() = Array(size = this.size) { SolverType.get(sapId = this[it]) }
fun Int.toSolverType() = SolverType.get(sapId = this)