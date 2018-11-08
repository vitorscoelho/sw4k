package vitorscoelho.sw4k.sap14.enums

enum class MyType(override val sapId: Int) : EnumWithSapIdInt {
    MAXIMUM_SEGMENT_SIZE(1),
    MINIMUM_NUMBER_OF_STATION(2)
}