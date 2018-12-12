package vitorscoelho.sw4k.sapenums

enum class E3DFrameType(override val sapId: Int) : EnumWithSapIdInt {
    OPEN_FRAME(0),
    PERIMETER_FRAME(1),
    BEAM_SLAB(2),
    FLAT_PLATE(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("E3DFrameType with sapId=$sapId nonexistent.") }
    }
}

fun Array<E3DFrameType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toE3DFrameType() = Array(size = this.size) { E3DFrameType.get(sapId = this[it]) }
fun Int.toE3DFrameType() = E3DFrameType.get(sapId = this)