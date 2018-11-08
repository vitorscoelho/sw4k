package vitorscoelho.sw4k.sap14.enums

enum class DesignType(override val sapId: Int) : EnumWithSapIdInt {
    PROGRAM_DETERMINED(0),
    USER_SPECIFIED(1)
}