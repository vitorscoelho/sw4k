package vitorscoelho.sw4k.sap.enums

enum class LoadControlMethod(override val sapId: Int) : EnumWithSapIdInt {
    FULL_LOAD(1),
    DISPLACEMENT_CONTROL(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadControlMethod with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadControlMethod>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLoadControlMethod() = Array(size = this.size) { LoadControlMethod.get(sapId = this[it]) }
fun Int.toLoadControlMethod() = LoadControlMethod.get(sapId = this)