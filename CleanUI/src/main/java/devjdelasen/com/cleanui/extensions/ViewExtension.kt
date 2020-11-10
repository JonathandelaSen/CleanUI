package devjdelasen.com.cleanui.extensions

import android.view.View
import androidx.annotation.IntegerRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import devjdelasen.com.cleanui.utils.ConstraintsManager



internal fun View.removeConstraint(start: Boolean = false, top: Boolean = false, end: Boolean = false, bottom: Boolean = false) {
    (this.parent as? ConstraintLayout)?.let {
        ConstraintsManager.removeConstraint(constraintLayout = it, viewToApplyId = id, start = start, top = top, end = end, bottom = bottom).applyTo(it)
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
        ConstraintsManager.constraintTo(
            constraintLayout = it,
            viewToApplyId = id,
            startToId = startToId,
            startToOfView = startToOfView,
            topToId = topToId,
            topToOfView = topToOfView,
            endToId = endToId,
            endToOfView = endToOfView,
            bottomToId = bottomToId,
            bottomToOfView = bottomToOfView,
            marginStart = marginStart,
            marginTop = marginTop,
            marginEnd = marginEnd,
            marginBottom = marginBottom,
            constraintSet = constraintSet).applyTo(it)
    }
}

internal fun View.constraintParentDontApply(start: Boolean, top: Boolean, end: Boolean, bottom: Boolean,
                                       marginStart: Int = 0,  marginTop: Int = 0,  marginEnd: Int = 0,  marginBottom: Int = 0): ConstraintSet? {
    (this.parent as? ConstraintLayout)?.let {
        return ConstraintsManager.constraintParent(constraintLayout = it, viewToApplyId = id, start = start, top = top, end = end, bottom = bottom,
            marginStart = marginStart,  marginTop = marginTop, marginEnd = marginEnd,  marginBottom = marginBottom)
    }
    return null
}