package vitorscoelho.sw4k.sap.sapmodel.enums

enum class LinkPropType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR(1),
    DAMPER(2),
    GAP(3),
    HOOK(4),
    PLASTIC_WEN(5),

    /**Rubber isolator*/
    ISOLATOR1(6),

    /**Friction isolator*/
    ISOLATOR2(7),

    MULTILINEAR_ELASTIC(8),
    MULTILINEAR_PLASTIC(9),

    /**T/C Friction isolator*/
    ISOLATOR3(10);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LinkPropType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LinkPropType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLinkPropType() = Array(size = this.size) { LinkPropType.get(sapId = this[it]) }
fun Int.toLinkPropType() = LinkPropType.get(sapId = this)