package vitorscoelho.sw4k.sap14.enums

enum class FramePropType(override val sapId: Int) : EnumWithSapIdInt {
    SECTION_I(1),
    SECTION_CHANNEL(2),
    SECTION_T(3),
    SECTION_ANGLE(4),
    SECTION_DBLANGLE(5),
    SECTION_BOX(6),
    SECTION_PIPE(7),
    SECTION_RECTANGULAR(8),
    SECTION_CIRCLE(9),
    SECTION_GENERAL(10),
    SECTION_DBCHANNEL(11),
    SECTION_AUTO(12),
    SECTION_SD(13),
    SECTION_VARIABLE(14),
    SECTION_JOIST(15),
    SECTION_BRIDGE(16),
    SECTION_COLD_C(17),
    SECTION_COLD_2C(18),
    SECTION_COLD_Z(19),
    SECTION_COLD_L(20),
    SECTION_COLD_2L(21),
    SECTION_COLD_HAT(22),
    SECTION_BUILTUP_I_COVERPLATE(23),
    SECTION_PCC_GIRDER_I(24),
    SECTION_PCC_GIRDER_U(25);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("FramePropType with sapId=$sapId nonexistent.") }
    }
}

fun Array<FramePropType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toFramePropType() = Array(size = this.size) { FramePropType.get(sapId = this[it]) }
fun Int.toFramePropType() = FramePropType.get(sapId = this)