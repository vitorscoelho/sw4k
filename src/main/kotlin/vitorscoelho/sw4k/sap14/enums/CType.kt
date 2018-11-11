package vitorscoelho.sw4k.sap14.enums

enum class CType (override val sapId: Int) :  EnumWithSapIdInt {
    LOAD_CASE(0),
    LOAD_COMBO(1);
}