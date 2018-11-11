package vitorscoelho.sw4k.sap14.enums

enum class LoadType(override val sapId: String) : EnumWithSapIdString {
    LOAD("Load"),
    ACCEL("Accel");

    companion object {
        private val map = values().associate { it.sapId to it }
        fun get(sapId: String) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadType>.toSapId(): Array<String> = this.map { it.sapId }.toTypedArray()