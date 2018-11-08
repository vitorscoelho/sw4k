package vitorscoelho.sw4k.comutils

import vitorscoelho.sw4k.sap14.enums.EnumWithSapId
import vitorscoelho.sw4k.sap14.enums.EnumWithSapIdInt
import vitorscoelho.sw4k.sap14.enums.EnumWithSapIdString
import vitorscoelho.sw4k.sap14.enums.MatType

internal interface ByRefType<S> {
    var value: S
}

internal interface SapEnumByteByRef<S : EnumWithSapIdInt> : ByRefType<S> {
    fun setValue(value: Int)
}

internal interface SapEnumStringByRef<S : EnumWithSapIdString> : ByRefType<S> {
    fun setValue(value: String)
}

class IntByRef(override var value: Int = 0) : ByRefType<Int>
class StringByRef(override var value: String = "") : ByRefType<String>
//class EnumWithSapIdByteByRef<S : EnumWithSapIdInt>(override var value: EnumWithSapIdInt) : ByRefType<EnumWithSapIdInt>()
//class EnumWithSapIdStringByRef<S : EnumWithSapIdString>(override var value: S) : ByRefType<S>()
class MatTypeByRef(override var value: MatType = MatType.NULL) : SapEnumByteByRef<MatType> {
    override fun setValue(value: Int) {
        this.value = map[value]!!
    }

    companion object {
        private val map by lazy { MatType.values().associate { it.sapId to it } }
    }
}

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

class EnumArrayByRef<S : EnumWithSapId<*>>(override val size: Int) : ByRefArray1D<S> {
    private val array = arrayListOf<S>()
    override fun get(index: Int): S? = array[index]

    override fun set(index: Int, value: S) {
        array[index] = value
    }
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

/*
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

/*class EnumArrayByRef<S>(size: Int) : ByRefArray<S>() {
    override val safeArray= SafeArray(Variant.Variant.toInt(),size)

    override fun get(index: Int): S =safeArray.get

    override fun set(index: Int, value: S) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}*/*/