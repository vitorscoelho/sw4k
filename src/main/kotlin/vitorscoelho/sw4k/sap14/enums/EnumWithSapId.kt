package vitorscoelho.sw4k.sap14.enums

interface EnumWithSapId<S> {
    val sapId: S
//    fun enumAssociated(sapId: S): EnumWithSapId<S>
}

interface EnumWithSapIdInt : EnumWithSapId<Int>
interface EnumWithSapIdString : EnumWithSapId<String>

/*
TODO testar maneira de fazer o sapID sempre ser uma string e fazer a conversão na função call da classe [SapComponent].
TODO isso simplifica na hora do retorno.
TODO também tenho que fazer uma maneira de retornar o enum a partir de um sapId dado
 */

/*
private enum class ParameterType(val sapText: String, val kotlinText: String) {
    STRING(sapText = "String", kotlinText = "String"),
    BOOLEAN(sapText = "Boolean", kotlinText = "Boolean"),
    DOUBLE(sapText = "Double", kotlinText = "Double"),
    INT(sapText = "Long", kotlinText = "Int"),
    ITEM_TYPE(sapText = "eItemType", kotlinText = "ItemType"),
    LOAD_CASE_TYPE(sapText = "eLoadCaseType",kotlinText = "LoadCaseType"),
    LOAD_PATTERN_TYPE(sapText = "eLoadPatternType",kotlinText = "LoadPatternType"),
    MAT_TYPE(sapText = "eMatType",kotlinText = "MatType");

    companion object {
        private val map = ParameterType.values().associate { it.sapText to it }

        fun get(text: String) = map.getOrElse(key = text) { throw IllegalArgumentException("ParameterType '$text' nonexistent.") }
    }
}
*/

fun a(ad: Enum<*>) {

}