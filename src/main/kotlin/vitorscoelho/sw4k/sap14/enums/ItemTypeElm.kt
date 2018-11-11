package vitorscoelho.sw4k.sap14.enums

enum class ItemTypeElm(override val sapId: Int) : EnumWithSapIdInt {
    OBJECT_ELM(0),
    ELEMENT(1),
    GROUP_ELM(2),
    SELECTION_ELM(3);
}