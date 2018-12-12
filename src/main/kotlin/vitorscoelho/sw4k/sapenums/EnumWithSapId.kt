package vitorscoelho.sw4k.sapenums

internal interface EnumWithSapId<S> {
    val sapId: S
}

internal interface EnumWithSapIdInt : EnumWithSapId<Int>
internal interface EnumWithSapIdString : EnumWithSapId<String>
