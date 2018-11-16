package vitorscoelho.sw4k.comutils

internal interface ByRefType<S> {
    var value: S
}

class DoubleByRef(override var value: Double = 0.0) : ByRefType<Double> {
    override fun toString(): String = value.toString()
}

class IntByRef(override var value: Int = 0) : ByRefType<Int> {
    override fun toString(): String = value.toString()
}

class BooleanByRef(override var value: Boolean = true) : ByRefType<Boolean> {
    override fun toString(): String = value.toString()
}

class StringByRef(override var value: String = "") : ByRefType<String> {
    override fun toString(): String = value
}

fun Double.byRef() = DoubleByRef(this)
fun Int.byRef() = IntByRef(this)
fun Boolean.byRef() = BooleanByRef(this)
fun String.byRef() = StringByRef(this)

internal interface ByRefArray1D<S, T> : ByRefType<S> {
    /** Returns the array element at the given [index]. This method can be called using the index operator. */
    operator fun get(index: Int): T

    /** Sets the element at the given [index] to the given [value]. This method can be called using the index operator. */
    operator fun set(index: Int, value: T)

    /**
     * Returns the value of elements in the array.
     */
    fun size(): Int
}

class DoubleArrayByRef(override var value: DoubleArray = doubleArrayOf()) : ByRefArray1D<DoubleArray, Double> {
    override fun get(index: Int): Double = value[index]
    override fun set(index: Int, value: Double) = this@DoubleArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    fun forEach(action: (Double) -> Unit) = value.forEach(action)
    fun forEachIndexed(action: (index: Int, Double) -> Unit) = value.forEachIndexed(action)
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.value.toString()
}

fun DoubleArray.byRef(): DoubleArrayByRef = DoubleArrayByRef(this)

class IntArrayByRef(override var value: IntArray = intArrayOf()) : ByRefArray1D<IntArray, Int> {
    override fun get(index: Int): Int = value[index]
    override fun set(index: Int, value: Int) = this@IntArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    fun forEach(action: (Int) -> Unit) = value.forEach(action)
    fun forEachIndexed(action: (index: Int, Int) -> Unit) = value.forEachIndexed(action)
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.value.toString()
}

fun IntArray.byRef(): IntArrayByRef = IntArrayByRef(this)

class BooleanArrayByRef(override var value: BooleanArray = booleanArrayOf()) : ByRefArray1D<BooleanArray, Boolean> {
    override fun get(index: Int): Boolean = value[index]
    override fun set(index: Int, value: Boolean) = this@BooleanArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    fun forEach(action: (Boolean) -> Unit) = value.forEach(action)
    fun forEachIndexed(action: (index: Int, Boolean) -> Unit) = value.forEachIndexed(action)
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.value.toString()
}

fun BooleanArray.byRef(): BooleanArrayByRef = BooleanArrayByRef(this)

class StringArrayByRef(override var value: Array<String> = emptyArray()) : ByRefArray1D<Array<String>, String> {
    override fun get(index: Int): String = value[index]
    override fun set(index: Int, value: String) = this@StringArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    fun forEach(action: (String) -> Unit) = value.forEach(action)
    fun forEachIndexed(action: (index: Int, String) -> Unit) = value.forEachIndexed(action)
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.value.toString()
}

fun Array<String>.byRef(): StringArrayByRef = StringArrayByRef(this)