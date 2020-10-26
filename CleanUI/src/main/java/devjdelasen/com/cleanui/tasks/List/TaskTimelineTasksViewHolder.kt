package devjdelasen.com.cleanui.tasks.List

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
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

        //itemView.clean_ui_tvDuration.text = task.duration

        //itemView.clean_ui_llTaskBg.setBackgroundResource(task.backgroundLight)
        //itemView.clean_ui_tvTitle.setTextColor(itemView.context.resources.getColor(task.intenseColor, null))
        //itemView.clean_ui_tvHours.setTextColor(itemView.context.resources.getColor(task.intenseColor, null))
        //itemView.clean_ui_itDuration.setColor(activity.getResources().getColor(model.getIntenseColor()));
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