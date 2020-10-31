package devjdelasen.com.cleanui.extensions

import android.view.View
import androidx.annotation.IntegerRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


internal fun View.constraintCenterHorizontal(constraintLayout: ConstraintLayout, view: View) {
    val set = ConstraintSet()
    set.clone(constraintLayout)
    set.connect(id, ConstraintSet.TOP, view.id, ConstraintSet.TOP, 0)
    set.connect(id, ConstraintSet.BOTTOM, view.id, ConstraintSet.BOTTOM, 0)
    set.applyTo(constraintLayout)
}

internal fun View.removeConstraint(start: Boolean = false, top: Boolean = false, end: Boolean = false, bottom: Boolean = false) {
    (this.parent as? ConstraintLayout)?.let {
        val consSet = ConstraintSet()
        consSet.clone(it)
        if (start) consSet.clear(id, ConstraintSet.START)
        if (top) consSet.clear(id, ConstraintSet.TOP)
        if (end) consSet.clear(id, ConstraintSet.END)
        if (bottom) consSet.clear(id, ConstraintSet.BOTTOM)
        consSet.applyTo(it)
    }
}

internal fun View.constraintParent(start: Boolean, top: Boolean, end: Boolean, bottom: Boolean,
                                       marginStart: Int = 0,  marginTop: Int = 0,  marginEnd: Int = 0,  marginBottom: Int = 0) {
    (this.parent as? ConstraintLayout)?.let {
        constraintParentDontApply(
            start,
            top,
            end,
            bottom,
            marginStart,
            marginTop,
            marginEnd,
            marginBottom
        )?.applyTo(it)
    }
}

internal fun View.constraintTo(@IntegerRes startToId: Int? = null,
                               @IntegerRes startToOfView: Int = ConstraintSet.START,
                               @IntegerRes topToId: Int? = null,
                               @IntegerRes topToOfView: Int = ConstraintSet.TOP,
                               @IntegerRes endToId: Int? = null,
                               @IntegerRes endToOfView: Int = ConstraintSet.END,
                               @IntegerRes bottomToId: Int? = null,
                               @IntegerRes bottomToOfView: Int = ConstraintSet.BOTTOM,
                               marginStart: Int = 0, marginTop: Int = 0, marginEnd: Int = 0, marginBottom: Int = 0,
                               constraintSet: ConstraintSet? = null) {
    (this.parent as? ConstraintLayout)?.let {

        var consSet = constraintSet
        if (constraintSet == null) {
            consSet = ConstraintSet()
            consSet.clone(it)
        }

        if (startToId != null) consSet?.connect(id, ConstraintSet.START, startToId, startToOfView, marginStart)
        if (topToId != null) consSet?.connect(id, ConstraintSet.TOP, topToId, topToOfView, marginTop)
        if (endToId != null) consSet?.connect(id, ConstraintSet.END, endToId, endToOfView, marginEnd)
        if (bottomToId != null) consSet?.connect(id, ConstraintSet.BOTTOM, bottomToId, bottomToOfView, marginBottom)

        consSet?.applyTo(it)
    }
}

internal fun View.constraintParentDontApply(start: Boolean, top: Boolean, end: Boolean, bottom: Boolean,
                                       marginStart: Int = 0,  marginTop: Int = 0,  marginEnd: Int = 0,  marginBottom: Int = 0): ConstraintSet? {
    (this.parent as? ConstraintLayout)?.let {
        val set = ConstraintSet()
        set.clone(it)
        if (start) set.connect(id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, marginStart)
        if (top) set.connect(id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, marginTop)
        if (end) set.connect(id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, marginEnd)
        if (bottom) set.connect(id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, marginBottom)
        return set
    }
    return null
}