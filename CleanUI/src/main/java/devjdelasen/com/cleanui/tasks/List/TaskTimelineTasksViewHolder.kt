package devjdelasen.com.cleanui.tasks.List

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.Utils
import devjdelasen.com.cleanui.extensions.constraintCenterHorizontal
import devjdelasen.com.cleanui.extensions.constraintParent
import devjdelasen.com.cleanui.extensions.constraintParentDontApply
import devjdelasen.com.cleanui.extensions.constraintTo
import devjdelasen.com.cleanui.tasks.models.SimpleTask
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.*

class SimpleTaskTimelineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var task: SimpleTask? = null

    fun bind(task: SimpleTask) {
        this.task = task

        setTitle()
        setDescription()
        setTime()
        setTopRightIcon()
        setCategory()
        setAccentButton()
        reorganizeConstraints()
    }

    private fun reorganizeConstraints() {
        setTitleConstraints()
    }

    private fun setTitleConstraints() {
        if (itemView.clean_ui_tvHours.visibility == View.VISIBLE) return
        if (itemView.clean_ui_taskTopRightIcon.visibility == View.VISIBLE) {

            val constraintSet = itemView.clean_ui_tvTitle.constraintParentDontApply(start = true, top = true, end = false, bottom = false,
                marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
                marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

            itemView.clean_ui_tvTitle.constraintTo(
                endToId = itemView.clean_ui_taskTopRightIcon.id,
                endToOfView = ConstraintSet.START,
                marginEnd = Utils.dpsToPxs(itemView.resources, 16f).toInt(),
                constraintSet = constraintSet)
            return
        }

        itemView.clean_ui_tvTitle.constraintParent(start = true, top = true, end = true, bottom = false,
            marginTop = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_top_inner_space) ?: 0,
            marginStart = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0,
            marginEnd = itemView.resources?.getDimensionPixelOffset(R.dimen.clean_ui_simple_task_side_inner_space) ?: 0)

    }


    private fun setAccentButton() {
        if (task?.accentButton == null) {
            itemView.clean_ui_accentButton.visibility = View.GONE
            return
        }
        itemView.clean_ui_accentButton.visibility = View.VISIBLE
        itemView.clean_ui_accentButton.set(task!!.accentButton!!)
    }

    private fun setCategory() {
        if (task?.category?.iconCategory == null) {
            itemView.clean_ui_iconCategory.visibility = View.GONE
            return
        }
        itemView.clean_ui_iconCategory.visibility = View.VISIBLE
        itemView.clean_ui_iconCategory.set(task?.category?.iconCategory)
    }

    private fun setTitle() {
        if (task?.title.isNullOrBlank()) {
            itemView.clean_ui_tvTitle.visibility = View.GONE
            itemView.clean_ui_tvTitle.text = ""
            return
        }
        itemView.clean_ui_tvTitle.visibility = View.VISIBLE
        itemView.clean_ui_tvTitle.text = task?.title
    }

    private fun setDescription() {
        if (task?.description.isNullOrBlank()) {
            itemView.clean_ui_tvDescription.visibility = View.GONE
            itemView.clean_ui_tvDescription.text = ""
            return
        }
        itemView.clean_ui_tvDescription.visibility = View.VISIBLE
        itemView.clean_ui_tvDescription.text = task?.description
    }

    private fun setTime() {
        val interval = task?.getTimeInterval()
        if (interval.isNullOrBlank()) {
            itemView.clean_ui_tvHours.visibility = View.GONE
            itemView.clean_ui_tvHours.text = ""
            return
        }
        itemView.clean_ui_tvHours.visibility = View.VISIBLE
        itemView.clean_ui_tvHours.text = interval
    }

    private fun setTopRightIcon() {
        if (task?.topRightIcon == null) {
            itemView.clean_ui_taskTopRightIcon.visibility = View.GONE
            return
        }
        itemView.clean_ui_taskTopRightIcon.visibility = View.VISIBLE
        itemView.clean_ui_taskTopRightIcon.set(task?.topRightIcon)
    }
}