package vitorscoelho.sw4k.sap14.enums

enum class PointObjectAssociatedType(override val sapId: Int) : EnumWithSapIdInt {
    /**Obj is the point object corresponding to the specified point element.*/
    POINT(1),

    /**Obj is a line object that is internally meshed by the program to create the specified point element.*/
    LINE(2),

    /**Obj is an area object that is internally meshed by the program to create the specified point element.*/
    AREA(3),

    /**Obj is a solid object that is internally meshed by the program to create the specified point element.*/
    SOLID(6),

    /**Obj is a point object that has a panel zone assignment. The specified point element is internally added by the program at the point object (panel zone) location to model the panel zone. The specified point element does not directly correspond to the point object returned; it is an added point at the same location as the point object.*/
    POINT_PANEL_ZONE(9),

    /**Obj is a defined diaphragm constraint. The specified point element was internally added by the program for application of auto wind and auto seismic loads.*/
    DIAPHRAGM_CONSTRAINT(21);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("PointObjectAssociatedType with sapId=$sapId nonexistent.") }
    }
}

fun Array<PointObjectAssociatedType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toPointObjectAssociatedType() = Array(size = this.size) { PointObjectAssociatedType.get(sapId = this[it]) }
fun Int.toPointObjectAssociatedType() = PointObjectAssociatedType.get(sapId = this)