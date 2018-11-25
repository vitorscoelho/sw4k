package vitorscoelho.sw4k.sap14.enums

enum class JointOffsetType(override val sapId: Int) : EnumWithSapIdInt {
    /**No joint offsets*/
    NO_JOINT_OFFSETS(0),
    
    /**User defined joint offsets specified by joint pattern*/
    USER_DEFINED_BY_JOINT_PATTERN(1),
    
    /**User defined joint offsets specified by point*/
    USER_DEFINED_BY_POINT(2);
    
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("JointOffsetType with sapId=$sapId nonexistent.") }
    }
}

fun Array<JointOffsetType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toJointOffsetType() = Array(size = this.size) { JointOffsetType.get(sapId = this[it]) }
fun Int.toJointOffsetType()=JointOffsetType.get(sapId = this)