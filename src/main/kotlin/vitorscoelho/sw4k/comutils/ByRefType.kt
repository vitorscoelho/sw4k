package vitorscoelho.sw4k.comutils

internal interface ByRefType<S> {
    var value: S
}

class IntByRef(override var value: Int = 0) : ByRefType<Int>
class StringByRef(override var value: String = "") : ByRefType<String>

internal interface ByRefArray1D<S> {
    /** Returns the array element at the given [index]. This method can be called using the index operator. */
    operator fun get(index: Int): S?

    /** Sets the element at the given [index] to the given [value]. This method can be called using the index operator. */
    operator fun set(index: Int, value: S)

    /**
     * Returns the value of elements in the array.
     */
    val size: Int
}

class DoubleArrayByRef(override val size: Int) : ByRefArray1D<Double> {
    private val array = DoubleArray(size = size)
    override fun get(index: Int) = array[index]

    override fun set(index: Int, value: Double) {
        array[index] = value
    }

    fun forEach(action: (Double) -> Unit) = array.forEach(action)
    fun forEachIndexed(action: (index: Int, Double) -> Unit) = array.forEachIndexed(action)
}

fun DoubleArray.byRef(): DoubleArrayByRef = DoubleArrayByRef(size = size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }

class IntArrayByRef(override val size: Int) : ByRefArray1D<Int> {
    private val array = IntArray(size = size)
    override fun get(index: Int) = array[index]

    override fun set(index: Int, value: Int) {
        array[index] = value
    }

    fun forEach(action: (Int) -> Unit) = array.forEach(action)
    fun forEachIndexed(action: (index: Int, Int) -> Unit) = array.forEachIndexed(action)
}

fun IntArray.byRef(): IntArrayByRef = IntArrayByRef(size = size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }

class BooleanArrayByRef(override val size: Int) : ByRefArray1D<Boolean> {
    private val array = BooleanArray(size = size)
    override fun get(index: Int) = array[index]

    override fun set(index: Int, value: Boolean) {
        array[index] = value
    }

    fun forEach(action: (Boolean) -> Unit) = array.forEach(action)
    fun forEachIndexed(action: (index: Int, Boolean) -> Unit) = array.forEachIndexed(action)
}

fun BooleanArray.byRef(): BooleanArrayByRef = BooleanArrayByRef(size = size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }

class StringArrayByRef(override val size: Int) : ByRefArray1D<String> {
    private val array = Array<String>(size = size) { "" }
    override fun get(index: Int) = array[index]

    override fun set(index: Int, value: String) {
        array[index] = value
    }

    fun forEach(action: (String) -> Unit) = array.forEach(action)
    fun forEachIndexed(action: (index: Int, String) -> Unit) = array.forEachIndexed(action)
}

fun Array<String>.byRef(): StringArrayByRef = StringArrayByRef(size = size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }