package vitorscoelho.sw4k.sap14.enums

enum class SolverType(override val sapId: Int) : EnumWithSapIdInt {
    STANDARD(0),
    ADVANCED(1);
}