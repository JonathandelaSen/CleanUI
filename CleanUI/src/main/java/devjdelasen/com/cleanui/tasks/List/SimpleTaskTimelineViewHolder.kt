package devjdelasen.com.cleanui.tasks.List

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.utils.Utils
import devjdelasen.com.cleanui.extensions.constraintParent
import devjdelasen.com.cleanui.extensions.constraintParentDontApply
import devjdelasen.com.cleanui.extensions.constraintTo
import devjdelasen.com.cleanui.extensions.removeConstraint
import devjdelasen.com.cleanui.tasks.models.SimpleTask
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.*
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.clean_ui_tvTitle

internal class SimpleTaskTimelineViewHolder(itemView: View, listener: RvAdapterTasks.TaskInteractionListener?) : TaskTimelineViewHolderAbstract(itemView, listener) {

    override var task: SimpleTask? = null


    init {
        setSimpleTaskListener()
    }

    fun bind(task: SimpleTask) {
        this.task = task

        setTitle()
        setDescription()
        setTime()
        setTopRightIcon()
        setCategory()
        setAccentButton()
        setMarkColor()
        reorganizeConstraints()
    }


    override fun reorganizeConstraints() {
        setTitleConstraints()
        setTimeConstraint()
        setDescriptionConstraints()
        setIconCategoryConstraints()
        setAccentButtonConstraints()
        setTopRightIconConstraints()
    }

    fun setSimpleTaskListener() {
        super.setListeners()
        setAccentButtonListener()
        setCategoryListener()
    }



    private fun setTopRightIconConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE) {
            setTopRightIconSameLineTimeConstraint()
            return
        }
        setTopRightIconSameLineTitleConstraint()
    }

    private fun setTimeConstraint() {
        if (itemView.clean_ui_taskTopRightIcon.visibility == View.VISIBLE) {
            setTimeSameLineTopRightIconConstraints()
            return
        }
        if (itemView.clean_ui_iconCategory.visibility == View.VISIBLE && itemView.clean_ui_accentButton.visibility == View.GONE) {
            setTimeSameLineCategoryConstraints()
            return
        }

        setTimeStartTopEndConstraint()
    }

    private fun setTitleConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE) {
            setTitleBelowTimeConstraints()
            return
        }
        if (itemView.clean_ui_taskTopRightIcon.visibility == View.VISIBLE) {
            setTitleSameLineTopRightIconConstraint()
            return
        }
        if (itemView.clean_ui_iconCategory.visibility == View.VISIBLE && itemView.clean_ui_accentButton.visibility == View.GONE) {
            setTitleSameLineCategoryConstraint()
            return
        }
        setTitleStartTopEndConstraints()
    }

    private fun setIconCategoryConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE && itemView.clean_ui_taskTopRightIcon.visibility == View.GONE
            && itemView.clean_ui_accentButton.visibility == View.GONE) {
            setIconCategorySameLineTimeConstraint()
            return
        }
        if (itemView.clean_ui_tvHours.visibility == View.GONE && itemView.clean_ui_taskTopRightIcon.visibility == View.GONE
            && itemView.clean_ui_accentButton.visibility == View.GONE) {
            setIconCategorySameLineTitleConstraint()
            return
        }
        if (itemView.clean_ui_tvDescription.visibility == View.VISIBLE) {
            setIconCategoryBelowDescriptionConstraint()
            return
        }
        setIconCategoryBelowTitleConstraint()

    }

    private fun setDescriptionConstraints() {
        if ((itemView.clean_ui_iconCategory.visibility == View.GONE && itemView.clean_ui_accentButton.visibility == View.GONE) ||
            (itemView.clean_ui_taskTopRightIcon.visibility == View.GONE && itemView.clean_ui_accentButton.visibility == View.GONE)) {
            setDescriptionToBottomConstraint()
            return
        }
        setDescriptionNotToBottomConstraint()
    }

    private fun setAccentButtonConstraints() {
        if (itemView.clean_ui_iconCategory.visibility == View.GONE) {
            if (itemView.clean_ui_tvDescription.visibility == View.VISIBLE) {
                setAccentButtonToStartBelowDescriptionConstraint()
                return
            }
            setAccentButtonToStartBelowTitleConstraint()
            return
        }
        setAccentButtonToCenterCategoryConstraint()
    }


    private fun setAccentButtonToCenterCategoryConstraint() {
        itemView.clean_ui_accentButton.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_accentButton.constraintParentDontApply(start = false, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0
        )
        itemView.clean_ui_accentButton.constraintTo(
            topToId = itemView.clean_ui_iconCategory.id,
            topToOfView = ConstraintSet.TOP,
            bottomToId = itemView.clean_ui_iconCategory.id,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }

    private fun setAccentButtonToStartBelowDescriptionConstraint() {
        itemView.clean_ui_accentButton.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_accentButton.constraintParentDontApply(start = true, top = false, end = false, bottom = true,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginBottom = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_bottom_inner_space) ?: 0
        )
        itemView.clean_ui_accentButton.constraintTo(
            topToId = itemView.clean_ui_tvDescription.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setAccentButtonToStartBelowTitleConstraint() {
        itemView.clean_ui_accentButton.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_accentButton.constraintParentDontApply(start = true, top = false, end = false, bottom = true,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginBottom = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_bottom_inner_space) ?: 0
        )
        itemView.clean_ui_accentButton.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }


    private fun setIconCategoryBelowDescriptionConstraint() {
        itemView.clean_ui_iconCategory.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_iconCategory.constraintParentDontApply(start = true, top = false, end = false, bottom = true,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginBottom = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_bottom_inner_space) ?: 0
        )
        itemView.clean_ui_iconCategory.constraintTo(
            topToId = itemView.clean_ui_tvDescription.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setIconCategoryBelowTitleConstraint() {
        itemView.clean_ui_iconCategory.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_iconCategory.constraintParentDontApply(start = true, top = false, end = false, bottom = true,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginBottom = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_bottom_inner_space) ?: 0
        )
        itemView.clean_ui_iconCategory.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)

    }

    private fun setIconCategorySameLineTitleConstraint() {
        itemView.clean_ui_iconCategory.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_iconCategory.constraintParentDontApply(start = false, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

        itemView.clean_ui_iconCategory.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            bottomToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.TOP,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }

    private fun setIconCategorySameLineTimeConstraint() {
        itemView.clean_ui_iconCategory.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_iconCategory.constraintParentDontApply(start = false, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

        itemView.clean_ui_iconCategory.constraintTo(
            topToId = itemView.clean_ui_tvHours.id,
            bottomToId = itemView.clean_ui_tvHours.id,
            topToOfView = ConstraintSet.TOP,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }


    private fun setTimeSameLineTopRightIconConstraints() {
        itemView.clean_ui_tvHours.removeConstraint(start = true, top = true, end = true, bottom = true)
        itemView.clean_ui_tvHours.constraintParent(start = true, top = true, end = false, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)
    }

    private fun setTimeSameLineCategoryConstraints() {
        itemView.clean_ui_tvHours.removeConstraint(start = true, top = true, end = true, bottom = true)
        itemView.clean_ui_tvHours.constraintParent(start = true, top = true, end = false, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)
    }

    private fun setTimeStartTopEndConstraint() {
        itemView.clean_ui_tvHours.removeConstraint(start = true, top = true, end = true, bottom = true)
        itemView.clean_ui_tvHours.constraintParent(start = true, top = true, end = false, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)
    }


    private fun setTitleStartTopEndConstraints() {
        itemView.clean_ui_tvTitle.constraintParent(start = true, top = true, end = true, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)
    }

    private fun setTitleBelowTimeConstraints() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = true, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)
        itemView.clean_ui_tvTitle.constraintTo(
            topToId = itemView.clean_ui_tvHours.id,
            topToOfView = ConstraintSet.BOTTOM,
            marginTop = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setTitleSameLineTopRightIconConstraint() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = true, top = true, end = false, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

        itemView.clean_ui_tvTitle.constraintTo(
            endToId = itemView.clean_ui_taskTopRightIcon.id,
            endToOfView = ConstraintSet.START,
            marginEnd = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }

    private fun setTitleSameLineCategoryConstraint() {
        val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = true, top = true, end = false, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

        itemView.clean_ui_tvTitle.constraintTo(
            endToId = itemView.clean_ui_iconCategory.id,
            endToOfView = ConstraintSet.START,
            marginEnd = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
            constraintSet = constraintSet)
    }


    private fun setDescriptionNotToBottomConstraint() {
        itemView.clean_ui_tvDescription.removeConstraint(start = false, top = false, end = false, bottom = true)
        itemView.clean_ui_tvDescription.constraintParent(start = true, top = false, end = true, bottom = false,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0
        )
    }

    private fun setDescriptionToBottomConstraint() {
        itemView.clean_ui_tvDescription.removeConstraint(start = false, top = false, end = false, bottom = true)
        itemView.clean_ui_tvDescription.constraintParent(start = true, top = false, end = true, bottom = true,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginBottom = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_bottom_inner_space) ?: 0
        )
    }


    private fun setTopRightIconSameLineTitleConstraint() {
        itemView.clean_ui_taskTopRightIcon.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_taskTopRightIcon.constraintParentDontApply(start = false, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0
        )
        itemView.clean_ui_taskTopRightIcon.constraintTo(
            topToId = itemView.clean_ui_tvTitle.id,
            topToOfView = ConstraintSet.TOP,
            bottomToId = itemView.clean_ui_tvTitle.id,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }

    private fun setTopRightIconSameLineTimeConstraint() {
        itemView.clean_ui_taskTopRightIcon.removeConstraint(start = true, top = true, end = true, bottom = true)

        val constraintSet = itemView.clean_ui_taskTopRightIcon.constraintParentDontApply(start = false, top = false, end = true, bottom = false,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0
        )
        itemView.clean_ui_taskTopRightIcon.constraintTo(
            topToId = itemView.clean_ui_tvHours.id,
            topToOfView = ConstraintSet.TOP,
            bottomToId = itemView.clean_ui_tvHours.id,
            bottomToOfView = ConstraintSet.BOTTOM,
            constraintSet = constraintSet)
    }

    private fun setAccentButtonListener() {
        itemView.clean_ui_accentButton.setOnClickListener {
            listener?.onActionButtonListener()
        }
    }

    private fun setCategoryListener() {
        itemView.clean_ui_iconCategory.setOnClickListener {
            listener?.onCategoryListener()
        }
    }


}