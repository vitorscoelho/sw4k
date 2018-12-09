package vitorscoelho.sw4k.sap.sapmodel.enums

enum class RotationAxis(override val sapId: Int) : EnumWithSapIdInt {
    PARALLEL_TO_X(1),
    PARALLEL_TO_Y(2),
    PARALLEL_TO_Z(3),
    TO_3D_LINE(4);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("RotationAxis with sapId=$sapId nonexistent.") }
    }
}

fun Array<RotationAxis>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toRotationAxis() = Array(size = this.size) { RotationAxis.get(sapId = this[it]) }
fun Int.toRotationAxis() = RotationAxis.get(sapId = this)