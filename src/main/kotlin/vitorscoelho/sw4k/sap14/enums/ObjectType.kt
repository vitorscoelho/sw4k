package vitorscoelho.sw4k.sap14.enums

enum class ObjectType(override val sapId: Int) : EnumWithSapIdInt {
    POINT(1),
    FRAME(2),
    CABLE(3),
    TENDON(4),
    AREA(5),
    SOLID(6),
    LINK(7);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ObjectType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ObjectType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toObjectType() = Array(size = this.size) { ObjectType.get(sapId = this[it]) }
fun Int.toObjectType() = ObjectType.get(sapId = this)