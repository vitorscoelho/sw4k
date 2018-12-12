package vitorscoelho.sw4k.sap.enums


enum class LinkObjectAssociatedType(override val sapId: Int) : EnumWithSapIdInt {
    /**Obj is a line object that is has a line spring assignment. The springs are modeled using link elements.*/
    LINE(2),

    /**Obj is a area object that is has an area spring assignment. The springs are modeled using link elements.*/
    AREA(3),

    /**Obj is a solid object that is has a surface spring assignment. The springs are modeled using link elements.*/
    SOLID(6),

    /**Obj is a point object that has a panel zone assignment. The specified link element is internally added by the program at the point object (panel zone) location to model the panel zone.*/
    POINT(9);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LinkObjectAssociatedType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LinkObjectAssociatedType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLinkObjectAssociatedType() = Array(size = this.size) { LinkObjectAssociatedType.get(sapId = this[it]) }
fun Int.toLinkObjectAssociatedType() = LinkObjectAssociatedType.get(sapId = this)