package devjdelasen.com.cleanui.calendar.top.list

import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.calendar.GenericHolderInterface
import devjdelasen.com.cleanui.tasks.TaskAbstract
import java.util.*

internal class DayCalendar: GenericHolderInterface {

    var tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

    private var isHolderSelected = false


    companion object {

        fun getByStartHour(tasks: List<TaskAbstract>, startHour: Int): List<TaskAbstract>? {
            val selectedTasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()
            for (task in tasks) {
                if (UtilsDate.getHour24Format(task.startTime) == startHour) {
                    selectedTasks.add(task)
                }
            }
            return selectedTasks
        }

    }

    override fun isSelected(): Boolean {
        return isHolderSelected
    }

    override fun setSelected(isSelected: Boolean) {
        isHolderSelected = isSelected
    }


}