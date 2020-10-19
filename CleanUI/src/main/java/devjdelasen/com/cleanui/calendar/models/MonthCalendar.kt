package devjdelasen.com.cleanui.calendar.models

import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.calendar.top.list.DayCalendar
import devjdelasen.com.cleanui.tasks.TaskAbstract
import kotlin.collections.ArrayList


internal class MonthCalendar(monthNumber: Int, yearNumber: Int) {

    var yearNumber = 0
    var days: ArrayList<DayCalendar> = ArrayList()


    fun addTask(task: TaskAbstract) {
        days[task.day].tasks.add(task)
    }

    init {
        for (i in 0 until UtilsDate.getNDaysMonth(monthNumber, yearNumber)) {
            days.add(DayCalendar())
        }
    }
}