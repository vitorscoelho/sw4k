package vitorscoelho.sw4k.sap14.enums

enum class MatType(override val sapId: Int) : EnumWithSapIdInt {
    NULL(Int.MIN_VALUE),
    MATERIAL_STEEL(1),
    MATERIAL_CONCRETE(2),
    MATERIAL_NODESIGN(3),
    MATERIAL_ALUMINUM(4),
    MATERIAL_COLDFORMED(5),
    MATERIAL_REBAR(6),
    MATERIAL_TENDON(7)
}