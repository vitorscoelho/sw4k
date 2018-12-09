package vitorscoelho.sw4k.sap.sapmodel.enums

enum class ItemTypeElm(override val sapId: Int) : EnumWithSapIdInt {
    /**
     * The item request is for the point element corresponding to the point object specified by the Name item.
     */
    OBJECT_ELM(0),
    /**
     * The item request is for the point element specified by the Name item.
     */
    ELEMENT(1),
    /**
     * The item request is for all point elements directly or indirectly specified in the group specified by the Name item. If a point object is in the specified group, data is requested for its corresponding point element. If line, area, solid or link objects are in the specified group, data is requested for all point elements associated with those objects, including those point elements created as a result of automatic internal meshing of the object by the program.
     */
    GROUP_ELM(2),
    /**
     * The item request is for all point elements directly or indirectly selected and the Name item is ignored. If a point object is selected, data is requested for its corresponding point element. If line, area, solid or link objects are selected, data is requested for all point elements associated with those objects, including those point elements created as a result of automatic internal meshing of the object by the program.
     */
    SELECTION_ELM(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("ItemTypeElm with sapId=$sapId nonexistent.") }
    }
}

fun Array<ItemTypeElm>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toItemTypeElm() = Array(size = this.size) { ItemTypeElm.get(sapId = this[it]) }
fun Int.toItemTypeElm() = ItemTypeElm.get(sapId = this)