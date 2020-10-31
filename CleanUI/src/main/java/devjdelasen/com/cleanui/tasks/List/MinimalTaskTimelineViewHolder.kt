package devjdelasen.com.cleanui.tasks.List

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.Utils
import devjdelasen.com.cleanui.extensions.constraintParentDontApply
import devjdelasen.com.cleanui.extensions.constraintTo
import devjdelasen.com.cleanui.tasks.models.MinimalTask
import kotlinx.android.synthetic.main.clean_ui_tasks_minimal_item_task_taskline.view.*

class MinimalTaskTimelineViewHolder(itemView: View) : TaskTimelineViewHolderAbstract(itemView) {

    override var task: MinimalTask? = null

    fun bind(task: MinimalTask) {
        this.task = task

        setTitle()
        setTime()
        setMarkColor()
        setTopRightIcon()
        reorganizeConstraints()
    }




    override fun reorganizeConstraints() {
        setTitleConstraints()
        setColorMarkConstraints()
        setHoursConstraints()
    }

    private fun setHoursConstraints() {
        if (itemView.clean_ui_vMarkColor.visibility == View.VISIBLE) {
            setHoursWithMarkColorConstraints()
            return
        }
        setHoursWithoutMarkColorConstraints()
    }

    private fun setHoursWithoutMarkColorConstraints() {
        val constraintSet = itemView.clean_ui_tvHours.constraintParentDontApply(start = true, top = false, end = false, bottom = true,
            marginBottom = Utils.dpsToPxs(itemView.resources, 12f).toInt(),
            marginStart = getMarginStart()
        )

        itemView.clean_ui_tvHours.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 6f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setHoursWithMarkColorConstraints() {
        val constraintSet = itemView.clean_ui_tvHours.constraintParentDontApply(start = false, top = false, end = false, bottom = true,
            marginBottom = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )

        itemView.clean_ui_tvHours.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 6f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setTitleConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE) {
            if (itemView.clean_ui_taskTopRightIcon.visibility == View.VISIBLE) {
                setTitleAboveTimeWithTopRightConstraints()
                return
            }
            setTitleAboveTimeNoTopRightConstraints()
            return
        }
        if (itemView.clean_ui_taskTopRightIcon.visibility == View.VISIBLE) {
            setTitleNoTimeWithTopRightConstraints()
            return
        }
        setTitleNoTimeNoTopRightConstraints()
        return
    }

    private fun setColorMarkConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE) {
            setVColorMarkWithTimeConstraints()
            return
        }
        setVColorMarkWithoutTimeConstraints()
    }

    private fun setVColorMarkWithoutTimeConstraints() {
        val constraintSet = itemView.clean_ui_vMarkColor.constraintParentDontApply(start = true, top = false, end = false, bottom = false,
            marginStart = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )
        itemView.clean_ui_vMarkColor.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.TOP,
            bottomToId = itemView.clean_ui_tvTitle.id,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }

    private fun setVColorMarkWithTimeConstraints() {
        val constraintSet = itemView.clean_ui_vMarkColor.constraintParentDontApply(start = true, top = false, end = false, bottom = false,
            marginStart = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )
        itemView.clean_ui_vMarkColor.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.TOP,
            bottomToId = itemView.clean_ui_tvHours.id,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }


    private fun setTitleAboveTimeWithTopRightConstraints() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = false, top = true, end = false, bottom = false,
            marginTop = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )

        itemView.clean_ui_tvTitle.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            endToId = itemView.clean_ui_taskTopRightIcon.id,
            endToOfView = ConstraintSet.START,
            marginEnd = Utils.dpsToPxs(itemView.resources, 6f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setTitleAboveTimeNoTopRightConstraints() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = false, top = true, end = true, bottom = false,
            marginTop = Utils.dpsToPxs(itemView.resources, 12f).toInt(),
            marginEnd = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )
        itemView.clean_ui_tvTitle.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            constraintSet = constraintSet)
    }

    private fun setTitleNoTimeWithTopRightConstraints() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = false, top = true, end = false, bottom = true,
            marginTop = Utils.dpsToPxs(itemView.resources, 12f).toInt(),
            marginBottom = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )
        itemView.clean_ui_tvTitle.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            endToId = itemView.clean_ui_taskTopRightIcon.id,
            endToOfView = ConstraintSet.START,
            marginEnd = Utils.dpsToPxs(itemView.resources, 6f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setTitleNoTimeNoTopRightConstraints() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = false, top = true, end = true, bottom = true,
            marginTop = Utils.dpsToPxs(itemView.resources, 12f).toInt(),
            marginEnd = Utils.dpsToPxs(itemView.resources, 12f).toInt(),
            marginBottom = Utils.dpsToPxs(itemView.resources, 12f).toInt()
        )
        itemView.clean_ui_tvTitle.constraintTo(
            startToId = itemView.clean_ui_vMarkColor.id,
            startToOfView = ConstraintSet.END,
            marginStart = getMarginStart(),
            constraintSet = constraintSet)
    }

    private fun getMarginStart(): Int {
        return if (itemView.clean_ui_vMarkColor.visibility == View.GONE) {
            itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space)
        }
        else {
            Utils.dpsToPxs(itemView.resources, 10f).toInt()
        }
    }



}