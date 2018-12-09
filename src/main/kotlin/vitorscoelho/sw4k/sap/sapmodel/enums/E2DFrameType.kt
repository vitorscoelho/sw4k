package vitorscoelho.sw4k.sap.sapmodel.enums

enum class E2DFrameType(override val sapId: Int) : EnumWithSapIdInt {
    PORTAL_FRAME(0),
    CONCENTRIC_BRACED(1),
    ECCENTRIC_BRACED(2);
    
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("E2DFrameType with sapId=$sapId nonexistent.") }
    }
}

fun Array<E2DFrameType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toE2DFrameType() = Array(size = this.size) { E2DFrameType.get(sapId = this[it]) }
fun Int.toE2DFrameType() = E2DFrameType.get(sapId = this)