package vitorscoelho.sw4k.sap14.enums

enum class DistributedLoadType(override val sapId: Int) : EnumWithSapIdInt {
    FORCE_PER_UNIT_LENGTH(1),
    MOMENT_PER_UNIT_LENGTH(2)
}