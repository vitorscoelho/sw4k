package vitorscoelho.sw4k.sap14.enums

enum class Axis(override val sapId: Int) : EnumWithSapIdInt {
    X(0),
    Y(1),
    Z(2);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("Axis with sapId=$sapId nonexistent.") }
    }
}

fun Array<Axis>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toAxis() = Array(size = this.size) { Axis.get(sapId = this[it]) }
fun Int.toAxis() = Axis.get(sapId = this)