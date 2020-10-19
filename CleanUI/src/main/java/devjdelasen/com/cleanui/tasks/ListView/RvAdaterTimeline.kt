package devjdelasen.com.cleanui.tasks.ListView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.calendar.top.list.DayCalendar
import devjdelasen.com.cleanui.tasks.HourItemTimeline
import devjdelasen.com.cleanui.tasks.TaskAbstract
import java.util.*


class RvAdapterTimeline(list: List<TaskAbstract>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    private var timeline: ArrayList<TimelineItem>? = null



    init {
        setTimeline(list)
    }




    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View
        if (viewType == TimelineItem.HOUR_TIME_ITEM) {
            itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_item_hour_timeline, viewGroup, false)
            return HourTimelineViewHolder(itemView)
        }
        itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_item_task_timeline, viewGroup, false)
        return TaskTimelineViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        if (timeline!![pos].type == TimelineItem.HOUR_TIME_ITEM) {
            (viewHolder as HourTimelineViewHolder).bind((timeline!![pos] as HourItemTimeline).time)
            return
        }
        (viewHolder as TaskTimelineViewHolder).bind(timeline!![pos] as TaskAbstract)
    }

    override fun getItemCount(): Int {
        return timeline!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return timeline!![position].type
    }



    fun getPositionByHour(hour: Int): Int {
        var position = 0
        for (item in timeline!!) {
            if (item is HourItemTimeline) {
                if ((item as HourItemTimeline).time === hour) {
                    return position
                }
            }
            position++
        }
        return 0 //in case it could not find the hour
    }



    private fun setTimeline(tasks: List<TaskAbstract>) {
        timeline = ArrayList()
        for (i in 1..23) {
            timeline?.add(HourItemTimeline(i))
            DayCalendar.getByStartHour(tasks, i)?.let { timeline?.addAll(it) }
        }
    }



    interface TimelineItem {
        val type: Int

        companion object {
            const val HOUR_TIME_ITEM = 0
            const val TASK_TIME_ITEM = 1
        }
    }
}
