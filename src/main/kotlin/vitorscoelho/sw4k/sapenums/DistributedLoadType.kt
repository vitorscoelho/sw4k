package vitorscoelho.sw4k.sapenums

enum class DistributedLoadType(override val sapId: Int) : EnumWithSapIdInt {
    FORCE_PER_UNIT_LENGTH(1),
    MOMENT_PER_UNIT_LENGTH(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("DistributedLoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<DistributedLoadType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toDistributedLoadType() = Array(size = this.size) { DistributedLoadType.get(sapId = this[it]) }
fun Int.toDistributedLoadType() = DistributedLoadType.get(sapId = this)