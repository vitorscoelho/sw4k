package vitorscoelho.sw4k.sap14.enums

enum class PlaneDOF(override val sapId: Int) : EnumWithSapIdInt {
    STRAIN_11(1),
    STRAIN_22(2),
    STRAIN_12(3),
    STRAIN_13(4),
    STRAIN_23(5);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("PlaneDOF with sapId=$sapId nonexistent.") }
    }
}

fun Array<PlaneDOF>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toPlaneDOF() = Array(size = this.size) { PlaneDOF.get(sapId = this[it]) }
fun Int.toPlaneDOF() = PlaneDOF.get(sapId = this)