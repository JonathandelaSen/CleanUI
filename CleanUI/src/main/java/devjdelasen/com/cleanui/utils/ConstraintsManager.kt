package devjdelasen.com.cleanui.utils

import android.R
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnticipateInterpolator
import androidx.annotation.IntegerRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


internal class ConstraintsManager {


    companion object {


        fun constraintTo(constraintLayout: ConstraintLayout,
                        viewToApplyId: Int,
                        @IntegerRes startToId: Int? = null,
                         @IntegerRes startToOfView: Int = ConstraintSet.START,
                         @IntegerRes topToId: Int? = null,
                         @IntegerRes topToOfView: Int = ConstraintSet.TOP,
                         @IntegerRes endToId: Int? = null,
                         @IntegerRes endToOfView: Int = ConstraintSet.END,
                         @IntegerRes bottomToId: Int? = null,
                         @IntegerRes bottomToOfView: Int = ConstraintSet.BOTTOM,
                         marginStart: Int = 0, marginTop: Int = 0, marginEnd: Int = 0, marginBottom: Int = 0,
                         constraintSet: ConstraintSet? = null): ConstraintSet {

            var consSet = constraintSet
            if (constraintSet == null) {
                consSet = ConstraintSet()
                consSet.clone(constraintLayout)
            }

            if (startToId != null) consSet?.connect(viewToApplyId, ConstraintSet.START, startToId, startToOfView, marginStart)
            if (topToId != null) consSet?.connect(viewToApplyId, ConstraintSet.TOP, topToId, topToOfView, marginTop)
            if (endToId != null) consSet?.connect(viewToApplyId, ConstraintSet.END, endToId, endToOfView, marginEnd)
            if (bottomToId != null) consSet?.connect(viewToApplyId, ConstraintSet.BOTTOM, bottomToId, bottomToOfView, marginBottom)

            return consSet!!
        }


        fun removeConstraint(constraintLayout: ConstraintLayout,
                             viewToApplyId: Int,
                             start: Boolean = false, top: Boolean = false, end: Boolean = false, bottom: Boolean = false): ConstraintSet {
            val consSet = ConstraintSet()
            consSet.clone(constraintLayout)
            if (start) consSet.clear(viewToApplyId, ConstraintSet.START)
            if (top) consSet.clear(viewToApplyId, ConstraintSet.TOP)
            if (end) consSet.clear(viewToApplyId, ConstraintSet.END)
            if (bottom) consSet.clear(viewToApplyId, ConstraintSet.BOTTOM)
            return consSet
        }

        fun constraintParent(constraintLayout: ConstraintLayout,
                                           viewToApplyId: Int,
                                           start: Boolean, top: Boolean, end: Boolean, bottom: Boolean,
                                           marginStart: Int = 0,  marginTop: Int = 0,  marginEnd: Int = 0,
                                           marginBottom: Int = 0,
                                            constraintSet: ConstraintSet? = null): ConstraintSet {
                var consSet = constraintSet
                if (constraintSet == null) {
                    consSet = ConstraintSet()
                    consSet.clone(constraintLayout)
                }
                if (start) consSet!!.connect(viewToApplyId, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, marginStart)
                if (top) consSet!!.connect(viewToApplyId, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, marginTop)
                if (end) consSet!!.connect(viewToApplyId, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, marginEnd)
                if (bottom) consSet!!.connect(viewToApplyId, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, marginBottom)
                return consSet!!
        }

        fun animate(constraintLayout: ConstraintLayout, constraintSet: ConstraintSet) {
            val transition = ChangeBounds()
            transition.interpolator = AccelerateInterpolator(1.0f)
            transition.duration = 200
            TransitionManager.beginDelayedTransition(constraintLayout, transition)
            constraintSet.applyTo(constraintLayout)
        }

    }
}