package vitorscoelho.sw4k.sap.sapmodel.enums

enum class HingeUnloadType(override val sapId: Int) : EnumWithSapIdInt {
    /**Unload entire structure*/
    ENTIRE_STRUCTURE(1),

    /**Apply local redistribution*/
    LOCAL_REDISTRIBUTION(2),

    /**Restart using secant stiffness*/
    SECANT_STIFFNESS(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("HingeUnloadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<HingeUnloadType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toHingeUnloadType() = Array(size = this.size) { HingeUnloadType.get(sapId = this[it]) }
fun Int.toHingeUnloadType() = HingeUnloadType.get(sapId = this)