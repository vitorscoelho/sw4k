package vitorscoelho.sw4k.sap14.enums

enum class LoadType(override val sapId: String) : EnumWithSapIdString {
    LOAD("Load"),
    ACCEL("Accel")
}