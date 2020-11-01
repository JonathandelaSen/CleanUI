package devjdelasen.com.cleanui.tasks.List

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import kotlinx.android.synthetic.main.clean_ui_tasks_minimal_item_task_taskline.view.*
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.*
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.clean_ui_taskTopRightIcon
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.clean_ui_tvHours
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.clean_ui_tvTitle
import kotlinx.android.synthetic.main.clean_ui_tasks_simple_item_task_taskline.view.clean_ui_vMarkColor

internal abstract class TaskTimelineViewHolderAbstract(itemView: View, protected val listener: RvAdapterTasks.TaskInteractionListener?) : RecyclerView.ViewHolder(itemView) {

    protected abstract val task: TaskAbstract?


    protected abstract fun reorganizeConstraints()

    open fun setListeners() {
        setItemListener()
        setTopRightIconListener()
    }

    fun setAccentButton() {
        if (task?.accentButton == null) {
            itemView.clean_ui_accentButton.visibility = View.GONE
            return
        }
        itemView.clean_ui_accentButton.visibility = View.VISIBLE
        itemView.clean_ui_accentButton.set(task!!.accentButton!!)
    }

    fun setCategory() {
        if (task?.category?.iconCategory == null) {
            itemView.clean_ui_iconCategory.visibility = View.GONE
            return
        }
        itemView.clean_ui_iconCategory.visibility = View.VISIBLE
        itemView.clean_ui_iconCategory.set(task?.category?.iconCategory)
    }

    fun setTitle() {
        if (task?.title.isNullOrBlank()) {
            itemView.clean_ui_tvTitle.visibility = View.GONE
            itemView.clean_ui_tvTitle.text = ""
            return
        }
        itemView.clean_ui_tvTitle.visibility = View.VISIBLE
        itemView.clean_ui_tvTitle.text = task?.title
    }

    fun setDescription() {
        if (task?.description.isNullOrBlank()) {
            itemView.clean_ui_tvDescription.visibility = View.GONE
            itemView.clean_ui_tvDescription.text = ""
            return
        }
        itemView.clean_ui_tvDescription.visibility = View.VISIBLE
        itemView.clean_ui_tvDescription.text = task?.description
    }

    fun setTime() {
        val interval = task?.getTimeInterval()
        if (interval.isNullOrBlank()) {
            itemView.clean_ui_tvHours.visibility = View.GONE
            itemView.clean_ui_tvHours.text = ""
            return
        }
        itemView.clean_ui_tvHours.visibility = View.VISIBLE
        itemView.clean_ui_tvHours.text = interval
    }

    fun setMarkColor() {
        if (task?.markColor != null) {
            itemView.clean_ui_vMarkColor.visibility = View.VISIBLE
            itemView.clean_ui_vMarkColor.background.setTint(itemView.context.getColor(task?.markColor!!))
            return
        }
        itemView.clean_ui_vMarkColor.visibility = View.GONE
    }

    fun setTopRightIcon() {
        if (task?.topRightIcon == null) {
            itemView.clean_ui_taskTopRightIcon.visibility = View.GONE
            return
        }
        itemView.clean_ui_taskTopRightIcon.visibility = View.VISIBLE
        itemView.clean_ui_taskTopRightIcon.set(task?.topRightIcon)
    }


    private fun setItemListener() {
        itemView.setOnClickListener {
            listener?.onItemClickListener()
        }
    }

    private fun setTopRightIconListener() {
        itemView.clean_ui_taskTopRightIcon.setOnClickListener {
            listener?.onTopRightIconListener()
        }
    }


}