package devjdelasen.com.cleanui.tasks.ListView

import android.app.Activity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.tasks.TaskAbstract
import kotlinx.android.synthetic.main.clean_ui_tasks_item_task_timeline.view.*

class TaskTimelineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(task: TaskAbstract) {

        itemView.clean_ui_tvTitle.text = task.title
        itemView.clean_ui_tvHours.text = task.timeInterval
        //itemView.clean_ui_tvDuration.text = task.duration

        itemView.clean_ui_llTaskBg.setBackgroundResource(task.backgroundLight)
        itemView.clean_ui_tvTitle.setTextColor(itemView.context.resources.getColor(task.intenseColor, null))
        itemView.clean_ui_tvHours.setTextColor(itemView.context.resources.getColor(task.intenseColor, null))
        //itemView.clean_ui_itDuration.setColor(activity.getResources().getColor(model.getIntenseColor()));
        itemView.clean_ui_durationBar.setDuration(task.startTime, task.endTime, task.backgroundIntense);
    }
}