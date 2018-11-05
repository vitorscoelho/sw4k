package vitorscoelho.sw4k.comutils

import com.jacob.com.SafeArray
import com.jacob.com.Variant

abstract class ByRefType internal constructor() {
    abstract val variant: Variant
}

abstract class ByRefArray<S> internal constructor() {
    abstract val safeArray: SafeArray
    /** Returns the array element at the given [index]. This method can be called using the index operator. */
    abstract operator fun get(index: Int): S

    /** Sets the element at the given [index] to the given [value]. This method can be called using the index operator. */
    abstract operator fun set(index: Int, value: S)

    /**
     * Returns the value of elements in the array.
     */
    val size: Int by lazy { safeArray.elemSize }
}

class IntByRef : ByRefType() {
    override val variant = Variant(0, true)
    val value: Int
        get() = variant.intRef

    companion object {
        val NONE: IntByRef by lazy { IntByRef() }
    }
}

class StringByRef : ByRefType() {
    override val variant = Variant("", true)
    val value: String
        get() = variant.stringRef

    companion object {
        val NONE: StringByRef by lazy { StringByRef() }
    }
}

class BooleanArrayByRef(size: Int) : ByRefArray<Boolean>() {
    override val safeArray = SafeArray(Variant.VariantBoolean.toInt(), size)
    override operator fun get(index: Int): Boolean = safeArray.getBoolean(index)
    override operator fun set(index: Int, value: Boolean) = safeArray.setBoolean(index, value)
}

fun BooleanArray.byRef() = BooleanArrayByRef(size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }

class DoubleArrayByRef(size: Int) : ByRefArray<Double>() {
    override val safeArray = SafeArray(Variant.VariantDouble.toInt(), size)
    override fun get(index: Int): Double = safeArray.getDouble(index)
    override fun set(index: Int, value: Double) = safeArray.setDouble(index, value)
}

fun DoubleArray.byRef() = DoubleArrayByRef(size).apply { this@byRef.forEachIndexed { index, value -> this[index] = value } }

/*class ArrayByRef<S>(size: Int) : ByRefArray<S>() {
    override val safeArray= SafeArray(Variant.Variant.toInt(),size)

    override fun get(index: Int): S =safeArray.get

    override fun set(index: Int, value: S) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}*/