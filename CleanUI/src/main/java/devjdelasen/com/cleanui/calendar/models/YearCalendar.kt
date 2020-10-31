package devjdelasen.com.cleanui.calendar.models

import devjdelasen.com.cleanui.tasks.models.TaskAbstract

internal class YearCalendar(year: Int, month: Int) {

    private val months = HashMap<Int, Array<MonthCalendar?>>()

    init {
        add(year, month)
    }

    fun add(year: Int, month: Int) {
        if (isValidMonth(month) && get(year)?.get(month) == null) {
            val months = arrayOfNulls<MonthCalendar>(12)
            months[month] = MonthCalendar(month, year)
            this.months[year] = months
        }
    }

    private fun isValidMonth(month: Int): Boolean {
        return month in 0..11
    }

    fun get(year: Int): Array<MonthCalendar?>? {

        return months[year]
    }
}