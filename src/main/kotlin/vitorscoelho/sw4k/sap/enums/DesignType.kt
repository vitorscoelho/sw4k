package vitorscoelho.sw4k.sap.enums

enum class DesignType(override val sapId: Int) : EnumWithSapIdInt {
    PROGRAM_DETERMINED(0),
    USER_SPECIFIED(1);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("DesignType with sapId=$sapId nonexistent.") }
    }
}

fun Array<DesignType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toDesignType() = Array(size = this.size) { DesignType.get(sapId = this[it]) }
fun Int.toDesignType() = DesignType.get(sapId = this)