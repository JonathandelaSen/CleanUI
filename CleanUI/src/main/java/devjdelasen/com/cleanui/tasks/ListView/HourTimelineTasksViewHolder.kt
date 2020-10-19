package devjdelasen.com.cleanui.tasks.ListView

import android.app.Activity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.clean_ui_tasks_item_hour_timeline.view.*

class HourTimelineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(time: Int) {
        itemView.clean_ui_tvTime.text = time.toString()
    }
}