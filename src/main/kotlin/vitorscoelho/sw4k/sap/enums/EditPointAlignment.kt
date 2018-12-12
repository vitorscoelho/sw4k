package vitorscoelho.sw4k.sap.enums

enum class EditPointAlignment(override val sapId: Int) : EnumWithSapIdInt {
    /**Align points to X-ordinate in present coordinate system*/
    TO_X(1),

    /**Align points to Y-ordinate in present coordinate system*/
    TO_Y(2),

    /**Align points to Z-ordinate in present coordinate system*/
    TO_Z(3),

    /**Align points to nearest selected line object, area object edge or solid object edge*/
    TO_NEAREST_SELECTED(4);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("EditPointAlignment with sapId=$sapId nonexistent.") }
    }
}

fun Array<EditPointAlignment>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toEditPointAlignment() = Array(size = this.size) { EditPointAlignment.get(sapId = this[it]) }
fun Int.toEditPointAlignment() = EditPointAlignment.get(sapId = this)