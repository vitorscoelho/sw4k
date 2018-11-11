package vitorscoelho.sw4k.sap14.enums

enum class NLGeomType(override val sapId: Int) : EnumWithSapIdInt {
    NONE(0),
    P_DELTA(1),
    P_DELTA_PLUS_LARGE_DISPLACEMENTS(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("NLGeomType with sapId=$sapId nonexistent.") }
    }
}

fun Array<NLGeomType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toNLGeomType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toNLGeomType() = NLGeomType.get(sapId = this)