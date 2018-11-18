package vitorscoelho.sw4k.sap14.enums

enum class ThicknessType(override val sapId: Int) : EnumWithSapIdInt {
    NO_THICKNESS_OVERWRITES(0),
    USER_DEFINED_BY_JOINT_PATTERN(1),
    USER_DEFINED_BY_POINT(2);
    
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ThicknessType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ThicknessType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toThicknessType() = Array(size = this.size) { ThicknessType.get(sapId = this[it]) }
fun Int.toThicknessType()=ThicknessType.get(sapId = this)