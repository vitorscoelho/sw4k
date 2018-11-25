package vitorscoelho.sw4k.sap14.enums

enum class MirrorPlaneType(override val sapId: Int) : EnumWithSapIdInt {
    PARALLEL_TO_Z(1),
    PARALLEL_TO_X(2),
    PARALLEL_TO_Y(3),
    TO_3D_PLANE(4);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MirrorPlaneType with sapId=$sapId nonexistent.") }
    }
}

fun Array<MirrorPlaneType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMirrorPlaneType() = Array(size = this.size) { MirrorPlaneType.get(sapId = this[it]) }
fun Int.toMirrorPlaneType() = MirrorPlaneType.get(sapId = this)