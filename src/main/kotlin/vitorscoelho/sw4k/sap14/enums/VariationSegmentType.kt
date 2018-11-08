package vitorscoelho.sw4k.sap14.enums

enum class VariationSegmentType(override val sapId: Int) : EnumWithSapIdInt {
    LINEAR(1),
    PARABOLIC(2),
    CUBIC(3);
}