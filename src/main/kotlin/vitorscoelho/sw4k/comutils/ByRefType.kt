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
     * Returns the last valid index for the array.
     */
    fun lastIndex(): Int = size() - 1

    /**
     * Returns the value of elements in the array.
     */
    fun size(): Int

    /**
     * Performs the given [action] on each element.
     */
    fun forEach(action: (T) -> Unit)

    /**
     * Performs the given [action] on each element, providing sequential index with the element.
     * @param [action] function that takes the index of an element and the element itself
     * and performs the desired action on the element.
     */
    fun forEachIndexed(action: (index: Int, T) -> Unit)

    /**
     * Returns `true` if the array is empty.
     */
    fun isEmpty(): Boolean

    /**
     * Returns `true` if the array is not empty.
     */
    fun isNotEmpty(): Boolean = !isEmpty()
}

class DoubleArrayByRef(vararg values: Double = doubleArrayOf()) : ByRefArray1D<DoubleArray, Double> {
    override var value: DoubleArray = values
    override fun get(index: Int): Double = value[index]
    override fun set(index: Int, value: Double) = this@DoubleArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    override fun forEach(action: (Double) -> Unit) = value.forEach(action)
    override fun forEachIndexed(action: (index: Int, Double) -> Unit) = value.forEachIndexed(action)
    override fun isEmpty(): Boolean = value.isEmpty()
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.toStringArray()
}

fun DoubleArray.byRef(): DoubleArrayByRef = DoubleArrayByRef(*this)

class IntArrayByRef(vararg values: Int = intArrayOf()) : ByRefArray1D<IntArray, Int> {
    override var value: IntArray = values
    override fun get(index: Int): Int = value[index]
    override fun set(index: Int, value: Int) = this@IntArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    override fun forEach(action: (Int) -> Unit) = value.forEach(action)
    override fun forEachIndexed(action: (index: Int, Int) -> Unit) = value.forEachIndexed(action)
    override fun isEmpty(): Boolean = value.isEmpty()
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.toStringArray()
}

fun IntArray.byRef(): IntArrayByRef = IntArrayByRef(*this)

class BooleanArrayByRef(vararg values: Boolean = booleanArrayOf()) : ByRefArray1D<BooleanArray, Boolean> {
    override var value: BooleanArray = values
    override fun get(index: Int): Boolean = value[index]
    override fun set(index: Int, value: Boolean) = this@BooleanArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    override fun forEach(action: (Boolean) -> Unit) = value.forEach(action)
    override fun forEachIndexed(action: (index: Int, Boolean) -> Unit) = value.forEachIndexed(action)
    override fun isEmpty(): Boolean = value.isEmpty()
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.toStringArray()
}

fun BooleanArray.byRef(): BooleanArrayByRef = BooleanArrayByRef(*this)

class StringArrayByRef(vararg values: String = emptyArray()) : ByRefArray1D<Array<String>, String> {
    override var value: Array<String> = arrayOf(*values)
    override fun get(index: Int): String = value[index]
    override fun set(index: Int, value: String) = this@StringArrayByRef.value.set(index, value)
    override fun size(): Int = this.value.size
    override fun forEach(action: (String) -> Unit) = value.forEach(action)
    override fun forEachIndexed(action: (index: Int, String) -> Unit) = value.forEachIndexed(action)
    override fun isEmpty(): Boolean = value.isEmpty()
    override fun equals(other: Any?): Boolean = this.value.equals(other)
    override fun hashCode(): Int = this.value.hashCode()
    override fun toString(): String = this.toStringArray()
}

fun Array<String>.byRef(): StringArrayByRef = StringArrayByRef(*this)


private fun ByRefArray1D<*, *>.toStringArray(): String {
    if (this.isEmpty()) return "[]"
    val sb = StringBuilder()
    sb.append('[')
    this.forEachIndexed { index, elm ->
        sb.append(elm)
        if (index == this.lastIndex()) {
            sb.append(']')
            return@forEachIndexed
        }
        sb.append(',').append(' ')
    }
    return sb.toString()
}