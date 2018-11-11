package vitorscoelho.sw4k.sap14.enums

enum class LengthType(override val sapId: Int) : EnumWithSapIdInt {
    /**Relative length*/
    VARIABLE(1),
    /**Absolute length*/
    ABSOLUTE(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LengthType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LengthType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLengthType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toLengthType() = LengthType.get(sapId = this)