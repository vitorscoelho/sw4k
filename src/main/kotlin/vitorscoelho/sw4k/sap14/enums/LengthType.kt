package vitorscoelho.sw4k.sap14.enums

enum class LengthType(override val sapId: Int) : EnumWithSapIdInt {
    /**Relative length*/
    VARIABLE(1),
    /**Absolute length*/
    ABSOLUTE(2)
}