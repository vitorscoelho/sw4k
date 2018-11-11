package vitorscoelho.sw4k.sap14.enums

enum class CType (override val sapId: Int) :  EnumWithSapIdInt {
    LOAD_CASE(0),
    LOAD_COMBO(1);
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("CType with sapId=$sapId nonexistent.") }
    }
}

fun Array<CType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toCType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toCType()=CType.get(sapId = this)