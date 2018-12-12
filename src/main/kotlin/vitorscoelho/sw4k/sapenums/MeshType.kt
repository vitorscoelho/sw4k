package vitorscoelho.sw4k.sapenums

enum class MeshType(override val sapId: Int) : EnumWithSapIdInt {
    /**Mesh area into a specified number of objects*/
    SPECIFIED_NUMBER_OF_OBJECTS(1),

    /**Mesh area into objects of a specified maximum size*/
    SPECIFIED_NUMBER_OF_SIZE(2),

    /**Mesh area based on points on area edges*/
    BASED_ON_POINTS_ON_AREA_EDGES(3),

    /**Cookie cut mesh area based on lines intersecting edges*/
    COOKIE_CUT_BASED_ON_LINES_INTERSECTING_EDGES(4),

    /**Cookie cut mesh area based on points*/
    COOKIE_CUT_BASED_ON_POINTS(5),

    /**Mesh area using General Divide Tool*/
    GENERAL_DIVIDE_TOOL(6);

    companion object {
        private val map by lazy { values().associate { it.sapId to it } }
        fun get(sapId: Int) = map.getOrElse(key = sapId) { throw IllegalArgumentException("MeshType with sapId=$sapId nonexistent.") }
    }
}

fun Array<MeshType>.toSapId() = this.map { it.sapId }.toIntArray()
fun IntArray.toMeshType() = Array(size = this.size) { MeshType.get(sapId = this[it]) }
fun Int.toMeshType() = MeshType.get(sapId = this)