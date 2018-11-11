package vitorscoelho.sw4k.sap14.enums

enum class NLGeomType(override val sapId: Int) : EnumWithSapIdInt {
    NONE(0),
    P_DELTA(1),
    P_DELTA_PLUS_LARGE_DISPLACEMENTS(2);
}