package vitorscoelho.sw4k.sapenums

enum class LoadPatternType(override val sapId: Int) : EnumWithSapIdInt {
    DEAD(1),
    SUPERDEAD(2),
    LIVE(3),
    REDUCELIVE(4),
    QUAKE(5),
    WIND(6),
    SNOW(7),
    OTHER(8),
    MOVE(9),
    TEMPERATURE(10),
    ROOFLIVE(11),
    NOTIONAL(12),
    PATTERNLIVE(13),
    WAVE(14),
    BRAKING(15),
    CENTRIFUGAL(16),
    FRICTION(17),
    ICE(18),
    WINDONLIVELOAD(19),
    HORIZONTALEARTHPRESSURE(20),
    VERTICALEARTHPRESSURE(21),
    EARTHSURCHARGE(22),
    DOWNDRAG(23),
    VEHICLECOLLISION(24),
    VESSELCOLLISION(25),
    TEMPERATUREGRADIENT(26),
    SETTLEMENT(27),
    SHRINKAGE(28),
    CREEP(29),
    WATERLOADPRESSURE(30),
    LIVELOADSURCHARGE(31),
    LOCKEDINFORCES(32),
    PEDESTRIANLL(33),
    PRESTRESS(34),
    HYPERSTATIC(35),
    BOUYANCY(36),
    STREAMFLOW(37),
    IMPACT(38),
    CONSTRUCTION(39);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("LoadPatternType with sapId=$sapId nonexistent.") }
    }
}

fun Array<LoadPatternType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toLoadPatternType() = Array(size = this.size) { LoadPatternType.get(sapId = this[it]) }
fun Int.toLoadPatternType() = LoadPatternType.get(sapId = this)