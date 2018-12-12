package vitorscoelho.sw4k.sapenums

enum class HystereticDampingType(override val sapId: Int) : EnumWithSapIdInt {
    /**Constant hysteretic damping for all frequencies*/
    CONSTANT(1),

    /**Interpolated hysteretic damping by frequency*/
    INTERPOLATED(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("HystereticDampingType with sapId=$sapId nonexistent.") }
    }
}

fun Array<HystereticDampingType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toHystereticDampingType() = Array(size = this.size) { HystereticDampingType.get(sapId = this[it]) }
fun Int.toHystereticDampingType() = HystereticDampingType.get(sapId = this)