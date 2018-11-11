package vitorscoelho.sw4k.sap14.enums

enum class ItemType(override val sapId: Int) : EnumWithSapIdInt {
    /**
     * The assignment is made to the frame object specified by the Name item.
     */
    OBJECT(0),

    /**
     * The assignment is made to all frame objects in the group specified by the Name item.
     */
    GROUP(1),

    /**
     * The assignment is made to all selected frame objects and the Name item is ignored.
     */
    SELECTED_OBJECTS(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ItemType with sapId=$sapId nonexistent.") }
    }
}

fun Array<ItemType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toItemType() = Array(size = this.size) { ComboType.get(sapId = it) }
fun Int.toItemType() = ItemType.get(sapId = this)