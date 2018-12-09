package vitorscoelho.sw4k.sap.sapmodel.enums

enum class LoadCaseStatus(override val sapId: Int) : EnumWithSapIdInt {
    NOT_RUN(1),
    COULD_NOT_START(2),
    NOT_FINISHED(3),
    FINISHED(4);
    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadCaseStatus with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadCaseStatus>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLoadCaseStatus() = Array(size = this.size) { LoadCaseStatus.get(sapId = this[it]) }
fun Int.toLoadCaseStatus() = LoadCaseStatus.get(sapId = this)