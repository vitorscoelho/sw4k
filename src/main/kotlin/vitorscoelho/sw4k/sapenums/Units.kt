package vitorscoelho.sw4k.sapenums

enum class Units(override val sapId: Int) : EnumWithSapIdInt {
    lb_in_F(1),
    lb_ft_F(2),
    kip_in_F(3),
    kip_ft_F(4),
    kN_mm_C(5),
    kN_m_C(6),
    kgf_mm_C(7),
    kgf_m_C(8),
    N_mm_C(9),
    N_m_C(10),
    Ton_mm_C(11),
    Ton_m_C(12),
    kN_cm_C(13),
    kgf_cm_C(14),
    N_cm_C(15),
    Ton_cm_C(16);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("Units with sapId=$sapId nonexistent.") }
    }
}

fun Array<Units>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toUnits() = Array(size = this.size) { Units.get(sapId = this[it]) }
fun Int.toUnits() = Units.get(sapId = this)