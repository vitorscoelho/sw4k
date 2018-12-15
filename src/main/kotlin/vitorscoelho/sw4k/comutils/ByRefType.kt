package vitorscoelho.sw4k.comutils

import com.jacob.com.SafeArray
import com.jacob.com.Variant
import java.lang.RuntimeException

abstract class ByRefType<S> internal constructor() {
    abstract var value: S
    internal abstract fun attributeToCall(): Any
    internal abstract fun populate(variant: Any)
}

abstract class ADoubleByRef internal constructor() : ByRefType<Double>()
abstract class AIntByRef internal constructor() : ByRefType<Int>()
abstract class ABooleanByRef internal constructor() : ByRefType<Boolean>()
abstract class AStringByRef internal constructor() : ByRefType<String>()

internal class SetValueInUNNECESSARYByRefException internal constructor() : RuntimeException("UNNECESSARY ByRef objects were created exclusively for use when you do not want to retrieve data through an ByRef type object. You cannot set value in this type of object.")

class DoubleByRef(override var value: Double = 0.0) : ADoubleByRef() {
    override fun toString(): String = value.toString()
    override fun attributeToCall(): Variant = Variant(value, true)
    override fun populate(variant: Any) {
        value = (variant as Variant).doubleRef
    }

    companion object {
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: ADoubleByRef by lazy {
            object : ADoubleByRef() {
                override var value: Double
                    get() = 0.0
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): Double = value
                override fun populate(variant: Any) {}
            }
        }
    }
}

class IntByRef(override var value: Int = 0) : AIntByRef() {
    override fun toString(): String = value.toString()
    override fun attributeToCall(): Variant = Variant(value, true)
    override fun populate(variant: Any) {
        value = (variant as Variant).intRef
    }

    companion object {
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: AIntByRef by lazy {
            object : AIntByRef() {
                override var value: Int
                    get() = 0
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): Int = value
                override fun populate(variant: Any) {}
            }
        }
    }
}

class BooleanByRef(override var value: Boolean = true) : ABooleanByRef() {
    override fun toString(): String = value.toString()
    override fun attributeToCall(): Variant = Variant(value, true)
    override fun populate(variant: Any) {
        value = (variant as Variant).booleanRef
    }

    companion object {
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: ABooleanByRef by lazy {
            object : ABooleanByRef() {
                override var value: Boolean
                    get() = true
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): Boolean = value
                override fun populate(variant: Any) {}
            }
        }
    }
}

class StringByRef(override var value: String = "") : AStringByRef() {
    override fun toString(): String = value
    override fun attributeToCall(): Variant = Variant(value, true)
    override fun populate(variant: Any) {
        value = (variant as Variant).stringRef
    }

    companion object {
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: AStringByRef by lazy {
            object : AStringByRef() {
                override var value: String
                    get() = ""
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): String = value
                override fun populate(variant: Any) {}
            }
        }
    }
}

fun Double.byRef() = DoubleByRef(this)
fun Int.byRef() = IntByRef(this)
fun Boolean.byRef() = BooleanByRef(this)
fun String.byRef() = StringByRef(this)

abstract class ByRefArray1D<S, T> : ByRefType<S>() {
    /** Returns the array element at the given [index]. This method can be called using the index operator. */
    abstract operator fun get(index: Int): T

    /** Sets the element at the given [index] to the given [value]. This method can be called using the index operator. */
    abstract operator fun set(index: Int, value: T)

    /**
     * Returns the last valid index for the array.
     */
    fun lastIndex(): Int = size() - 1

    /**
     * Returns the value of elements in the array.
     */
    abstract fun size(): Int

    /**
     * Performs the given [action] on each element.
     */
    abstract fun forEach(action: (T) -> Unit)

    /**
     * Performs the given [action] on each element, providing sequential index with the element.
     * @param [action] function that takes the index of an element and the element itself
     * and performs the desired action on the element.
     */
    abstract fun forEachIndexed(action: (index: Int, T) -> Unit)

    /**
     * Returns `true` if the array is empty.
     */
    abstract fun isEmpty(): Boolean

    /**
     * Returns `true` if the array is not empty.
     */
    fun isNotEmpty(): Boolean = !isEmpty()
}

abstract class ADoubleArrayByRef internal constructor() : ByRefArray1D<DoubleArray, Double>()
abstract class AIntArrayByRef internal constructor() : ByRefArray1D<IntArray, Int>()
abstract class ABooleanArrayByRef internal constructor() : ByRefArray1D<BooleanArray, Boolean>()
abstract class AStringArrayByRef internal constructor() : ByRefArray1D<Array<String>, String>()

class DoubleArrayByRef(vararg values: Double = doubleArrayOf()) : ADoubleArrayByRef() {
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
    override fun attributeToCall(): Variant {
        val safeArray = SafeArray(VARIANT_DOUBLE_CODE, value.size).apply {
            value.forEachIndexed { index, indexedValue -> this.setDouble(index, indexedValue) }
        }
        return VariantSafeArray(safeArray = safeArray)
    }

    override fun populate(variant: Any) {
        value = (variant as VariantSafeArray).safeArray.toDoubleArray()
    }

    companion object {
        private val VARIANT_DOUBLE_CODE: Int by lazy { Variant.VariantDouble.toInt() }
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: ADoubleArrayByRef by lazy {
            object : ADoubleArrayByRef() {
                override var value: DoubleArray = doubleArrayOf()
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): DoubleArray = value
                override fun populate(variant: Any) {}
                override fun get(index: Int): Double = value[index]
                override fun set(index: Int, value: Double) {
                    throw SetValueInUNNECESSARYByRefException()
                }

                override fun size(): Int = 0
                override fun forEach(action: (Double) -> Unit) = value.forEach(action)
                override fun forEachIndexed(action: (index: Int, Double) -> Unit) = value.forEachIndexed(action)
                override fun isEmpty(): Boolean = true
            }
        }
    }
}

fun DoubleArray.byRef(): DoubleArrayByRef = DoubleArrayByRef(*this)

class IntArrayByRef(vararg values: Int = intArrayOf()) : AIntArrayByRef() {
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
    override fun attributeToCall(): Variant {
        val safeArray = SafeArray(VARIANT_INT_CODE, value.size).apply {
            value.forEachIndexed { index, indexedValue -> this.setInt(index, indexedValue) }
        }
        return VariantSafeArray(safeArray = safeArray)
    }

    override fun populate(variant: Any) {
        value = (variant as VariantSafeArray).safeArray.toIntArray()
    }

    companion object {
        private val VARIANT_INT_CODE: Int by lazy { Variant.VariantInt.toInt() }
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: AIntArrayByRef by lazy {
            object : AIntArrayByRef() {
                override var value: IntArray = intArrayOf()
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): IntArray = value
                override fun populate(variant: Any) {}
                override fun get(index: Int): Int = value[index]
                override fun set(index: Int, value: Int) {
                    throw SetValueInUNNECESSARYByRefException()
                }

                override fun size(): Int = 0
                override fun forEach(action: (Int) -> Unit) = value.forEach(action)
                override fun forEachIndexed(action: (index: Int, Int) -> Unit) = value.forEachIndexed(action)
                override fun isEmpty(): Boolean = true
            }
        }
    }
}

fun IntArray.byRef(): IntArrayByRef = IntArrayByRef(*this)

class BooleanArrayByRef(vararg values: Boolean = booleanArrayOf()) : ABooleanArrayByRef() {
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
    override fun attributeToCall(): Variant {
        val safeArray = SafeArray(VARIANT_BOOLEAN_CODE, value.size).apply {
            value.forEachIndexed { index, indexedValue -> this.setBoolean(index, indexedValue) }
        }
        return VariantSafeArray(safeArray = safeArray)
    }

    override fun populate(variant: Any) {
        value = (variant as VariantSafeArray).safeArray.toBooleanArray()
    }

    companion object {
        private val VARIANT_BOOLEAN_CODE: Int by lazy { Variant.VariantBoolean.toInt() }
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: ABooleanArrayByRef by lazy {
            object : ABooleanArrayByRef() {
                override var value: BooleanArray = booleanArrayOf()
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): BooleanArray = value
                override fun populate(variant: Any) {}
                override fun get(index: Int): Boolean = value[index]
                override fun set(index: Int, value: Boolean) {
                    throw SetValueInUNNECESSARYByRefException()
                }

                override fun size(): Int = 0
                override fun forEach(action: (Boolean) -> Unit) = value.forEach(action)
                override fun forEachIndexed(action: (index: Int, Boolean) -> Unit) = value.forEachIndexed(action)
                override fun isEmpty(): Boolean = true
            }
        }
    }
}

fun BooleanArray.byRef(): BooleanArrayByRef = BooleanArrayByRef(*this)

class StringArrayByRef(vararg values: String = emptyArray()) : AStringArrayByRef() {
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
    override fun attributeToCall(): Variant {
        val safeArray = SafeArray(VARIANT_STRING_CODE, value.size).apply {
            value.forEachIndexed { index, indexedValue -> this.setString(index, indexedValue) }
        }
        return VariantSafeArray(safeArray = safeArray)
    }

    override fun populate(variant: Any) {
        value = (variant as VariantSafeArray).safeArray.toStringArray()
    }

    companion object {
        private val VARIANT_STRING_CODE: Int by lazy { Variant.VariantString.toInt() }
        @get:JvmName("UNNECESSARY")
        @JvmStatic
        val UNNECESSARY: AStringArrayByRef by lazy {
            object : AStringArrayByRef() {
                override var value: Array<String> = emptyArray()
                    set(_) {
                        throw SetValueInUNNECESSARYByRefException()
                    }

                override fun attributeToCall(): Variant = VariantSafeArray(safeArray = SafeArray(VARIANT_STRING_CODE, 0))
                override fun populate(variant: Any) {}
                override fun get(index: Int): String = value[index]
                override fun set(index: Int, value: String) {
                    throw SetValueInUNNECESSARYByRefException()
                }

                override fun size(): Int = 0
                override fun forEach(action: (String) -> Unit) = value.forEach(action)
                override fun forEachIndexed(action: (index: Int, String) -> Unit) = value.forEachIndexed(action)
                override fun isEmpty(): Boolean = true
            }
        }
    }
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