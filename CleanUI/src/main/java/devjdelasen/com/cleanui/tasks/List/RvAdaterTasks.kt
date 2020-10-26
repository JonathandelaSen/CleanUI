package devjdelasen.com.cleanui.tasks.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.NoPostViewHolder
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.tasks.models.SimpleTask
import devjdelasen.com.cleanui.tasks.models.TaskAbstract


internal class RvAdapterTasks(list: List<TaskAbstract>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {


    private val sortedList: ArrayList<TaskAbstract> = ArrayList()

    init {
        sortTasks(list)
    }




    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View
        if (viewType == TaskAbstract.TaskType.SIMPLE.value) {
            itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_simple_item_task_taskline, viewGroup, false)
            return SimpleTaskTimelineViewHolder(itemView)
        }
        itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_simple_item_task_taskline, viewGroup, false)
        return NoPostViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as SimpleTaskTimelineViewHolder).bind(sortedList[pos] as SimpleTask)
    }

    override fun getItemCount(): Int {
        return sortedList.size
    }

    override fun getItemViewType(position: Int): Int {
        return sortedList[position].getType().value
    }




    private fun sortTasks(list: List<TaskAbstract>) {
        sortedList.clear()
        sortedList.addAll(list.sortedBy {
            it.startTime
        })
    }



}
