package vitorscoelho.sw4k.sap14.enums

enum class MyOption(override val sapId: Int) : EnumWithSapIdInt {
    WEIGHT_PER_UNIT_VOLUME(1),
    MASS_PER_UNIT_VOLUME(2)
}