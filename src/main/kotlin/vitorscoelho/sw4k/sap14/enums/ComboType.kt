package vitorscoelho.sw4k.sap14.enums

enum class ComboType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR_ADDITIVE(0),
    ENVELOPE(1),
    ABSOLUTE_ADDITIVE(2),
    SRSS(3),
    RANGE_ADDITIVE(4);
}