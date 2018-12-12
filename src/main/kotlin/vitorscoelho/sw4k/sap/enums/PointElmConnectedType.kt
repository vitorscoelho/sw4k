package vitorscoelho.sw4k.sap.enums

enum class PointElmConnectedType(override val sapId: Int) : EnumWithSapIdInt {
    FRAME(2),
    CABLE(3),
    TENDON(4),
    AREA(5),
    SOLID(6),
    LINK(7);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("PointElmConnectedType with sapId=$sapId nonexistent.") }
    }
}

fun Array<PointElmConnectedType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toPointElmConnectedType() = Array(size = this.size) { PointElmConnectedType.get(sapId = this[it]) }
fun Int.toPointElmConnectedType() = PointElmConnectedType.get(sapId = this)