package vitorscoelho.sw4k.sap14.enums

internal interface EnumWithSapId<S> {
    val sapId: S
}

internal interface EnumWithSapIdInt : EnumWithSapId<Int>
internal interface EnumWithSapIdString : EnumWithSapId<String>
