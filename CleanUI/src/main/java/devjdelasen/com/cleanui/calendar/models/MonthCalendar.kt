package devjdelasen.com.cleanui.calendar.models

import devjdelasen.com.cleanui.utils.UtilsDate
import devjdelasen.com.cleanui.calendar.top.list.DayCalendar
import devjdelasen.com.cleanui.extensions.getDayOfMonthNumber
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import kotlin.collections.ArrayList


internal class MonthCalendar(monthNumber: Int, yearNumber: Int) {

    var days: ArrayList<DayCalendar> = ArrayList()

    fun setTasks(tasks: List<TaskAbstract>?) {
        if (tasks.isNullOrEmpty()) return

        tasks.forEach { task ->
            task.date?.getDayOfMonthNumber()?.minus(1)?.let { dayNumber ->
                if (dayNumber < days.size) {
                    days[dayNumber].tasks.add(task)
                }
            }
        }
    }

    init {
        for (i in 0 until UtilsDate.getNDaysMonth(monthNumber, yearNumber)) {
            days.add(DayCalendar())
        }
    }
}