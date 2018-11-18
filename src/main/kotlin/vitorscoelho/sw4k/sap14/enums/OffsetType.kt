package vitorscoelho.sw4k.sap14.enums

enum class OffsetType(override val sapId: Int) : EnumWithSapIdInt {
    /**No joint offsets*/
    NO_JOINT_OFFSETS(0),
    
    /**User defined joint offsets specified by joint pattern*/
    USER_DEFINED_BY_JOINT_PATTERN(1),
    
    /**User defined joint offsets specified by point*/
    USER_DEFINED_BY_POINT(2);
    
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("OffsetType with sapId=$sapId nonexistent.") }
    }
}

fun Array<OffsetType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toOffsetType() = Array(size = this.size) { OffsetType.get(sapId = this[it]) }
fun Int.toOffsetType()=OffsetType.get(sapId = this)