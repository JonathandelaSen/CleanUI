package devjdelasen.com.cleanui.calendar.top.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.calendar.setSelectedTopCalendarDay
import kotlinx.android.synthetic.main.item_week_day_month_day_horizontal_calendar.view.*


internal class DayHorizontalTopHorizontalCalendarViewHolder(itemView: View,
                                                   private var listener: RvAdapterTopHorizontalCalendar.SelectedDayListener, mainTextColor: Int, accentColor: Int) : RecyclerView.ViewHolder(itemView) {

    private var monthNumber = 0
    private var dayNumber = 0
    private var mainTextColor: Int = -1
    private var accentColor: Int = -1


    init {
        setListeners()

        this.mainTextColor = if (mainTextColor == -1) itemView.context.getColor(mainTextColor) else mainTextColor
        this.accentColor = if (accentColor == -1) itemView.context.getColor(accentColor) else accentColor
    }

    fun bind(day: DayCalendar, year: Int, monthNumber: Int, dayNumber: Int) {
        this.monthNumber = monthNumber
        this.dayNumber = dayNumber
        itemView.clean_ui_tvDayNumber.text = (dayNumber + 1).toString()
        itemView.clean_ui_tvDayName.text = UtilsDate.getDayNameInitialLetrer(year, monthNumber, dayNumber + 1, itemView.context)
        itemView.clean_ui_tvDayName.setTextColor(mainTextColor)
        setHasTasks(day)
        setSelected(day)
    }

    private fun setListeners() {
        itemView.setOnClickListener {
            listener.onSelected(
                dayNumber,
                monthNumber
            )
        }
    }

    private fun setHasTasks(day: DayCalendar) {
        itemView.clean_ui_vNotificationCircle.visibility = if (day.tasks.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    private fun setSelected(day: DayCalendar) {
        itemView.clean_ui_tvDayNumber.setSelectedTopCalendarDay(day.isSelected(), accentColor, mainTextColor)
    }

}
