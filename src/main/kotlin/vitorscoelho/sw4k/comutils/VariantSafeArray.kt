package vitorscoelho.sw4k.comutils

import com.jacob.com.SafeArray
import com.jacob.com.Variant

internal class VariantSafeArray(val safeArray: SafeArray) : Variant() {
    init {
        this.putSafeArrayRef(safeArray)
    }
}