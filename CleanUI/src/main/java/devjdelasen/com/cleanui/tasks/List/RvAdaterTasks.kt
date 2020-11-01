package devjdelasen.com.cleanui.tasks.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.utils.NoPostViewHolder
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.tasks.models.MinimalTask
import devjdelasen.com.cleanui.tasks.models.SimpleTask
import devjdelasen.com.cleanui.tasks.models.TaskAbstract


class RvAdapterTasks(list: List<TaskAbstract>, val listener: TaskInteractionListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {


    private val sortedList: ArrayList<TaskAbstract> = ArrayList()

    init {
        sortTasks(list)
    }


    fun updateTasks(list: List<TaskAbstract>) {
        sortTasks(list)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View
        if (viewType == TaskAbstract.TaskType.SIMPLE.value) {
            itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_simple_item_task_taskline, viewGroup, false)
            return SimpleTaskTimelineViewHolder(itemView, listener)
        }
        if (viewType == TaskAbstract.TaskType.MINIMAL.value) {
            itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_tasks_minimal_item_task_taskline, viewGroup, false)
            return MinimalTaskTimelineViewHolder(itemView, listener)
        }
        itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.clean_ui_item_no_task, viewGroup, false)
        return NoPostViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        if (viewHolder is SimpleTaskTimelineViewHolder) {
            viewHolder.bind(sortedList[pos] as SimpleTask)
            return
        }
        if (viewHolder is MinimalTaskTimelineViewHolder) {
            viewHolder.bind(sortedList[pos] as MinimalTask)
        }
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


    interface TaskInteractionListener {
        fun onItemClickListener()
        fun onTopRightIconListener()
        fun onCategoryListener()
        fun onActionButtonListener()
    }


}
