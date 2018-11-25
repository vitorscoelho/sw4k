package vitorscoelho.sw4k.sap14.enums

enum class EditAreaOffsetType(override val sapId: Int) : EnumWithSapIdInt {
    /**Offset all area edges*/
    ALL_AREA_EDGES(0),

    /**Offset selected area edges only*/
    SELECTED_AREA_EDGES(1),

    /**Offset selected points of selected areas only*/
    SELECTED_POINTS(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("EditAreaOffsetType with sapId=$sapId nonexistent.") }
    }
}

fun Array<EditAreaOffsetType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toEditAreaOffsetType() = Array(size = this.size) { EditAreaOffsetType.get(sapId = this[it]) }
fun Int.toEditAreaOffsetType() = EditAreaOffsetType.get(sapId = this)