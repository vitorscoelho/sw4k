package vitorscoelho.sw4k.sap14.enums

enum class ControlDisplacementType(override val sapId: Int) : EnumWithSapIdInt {
    /**Conjugate displacement*/
    CONJUGATE(1),

    /**Monitored displacement*/
    MONITORED(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ControlDisplacementType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ControlDisplacementType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toControlDisplacementType() = Array(size = this.size) { ControlDisplacementType.get(sapId = this[it]) }
fun Int.toControlDisplacementType() = ControlDisplacementType.get(sapId = this)