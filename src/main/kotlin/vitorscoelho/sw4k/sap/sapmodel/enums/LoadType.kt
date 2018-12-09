package vitorscoelho.sw4k.sap.sapmodel.enums

enum class LoadType(override val sapId: String) : EnumWithSapIdString {
    LOAD("Load"),
    ACCEL("Accel");

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: String) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadType>.toSapId() = this.map { it.sapId }.toTypedArray()
fun Array<String>.toLoadType() = Array(size = this.size) { LoadType.get(sapId = this[it]) }
fun String.toLoadType() = LoadType.get(sapId = this)