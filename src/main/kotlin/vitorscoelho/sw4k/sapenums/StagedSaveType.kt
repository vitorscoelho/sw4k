package vitorscoelho.sw4k.sapenums

enum class StagedSaveType(override val sapId: Int) : EnumWithSapIdInt {
    /**End of final stage*/
    END_FINAL_STAGE(0),

    /**End of each stage*/
    END_EACH_STAGE(1),

    /**Start and end of each stage*/
    START_END_EACH_STAGE(2),

    /**Two or more times in each stage*/
    TWO_OR_MORE_TIMES_EACH_STAGE(3);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("StagedSaveType with sapId=$sapId nonexistent.") }
    }
}

fun Array<StagedSaveType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toStagedSaveType() = Array(size = this.size) { StagedSaveType.get(sapId = this[it]) }
fun Int.toStagedSaveType() = StagedSaveType.get(sapId = this)