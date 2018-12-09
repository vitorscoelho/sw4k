package vitorscoelho.sw4k.sap.sapmodel.enums

enum class LoadCaseType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR_STATIC(1),
    NONLINEAR_STATIC(2),
    MODAL(3),
    RESPONSE_SPECTRUM(4),

    /**Modal Time History*/
    LINEAR_HISTORY(5),

    /**Modal Time History*/
    NONLINEAR_HISTORY(6),

    /**Direct Integration Time History*/
    LINEAR_DYNAMIC(7),

    /**Direct Integration Time History*/
    NONLINEAR_DYNAMIC(8),

    MOVING_LOAD(9),
    BUCKLING(10),
    STEADY_STATE(11),
    POWER_SPECTRAL_DENSITY(12),
    LINEAR_STATIC_MULTISTEP(13),
    HYPERSTATIC(14);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadCaseType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadCaseType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLoadCaseType() = Array(size = this.size) { LoadCaseType.get(sapId = this[it]) }
fun Int.toLoadCaseType() = LoadCaseType.get(sapId = this)