package devjdelasen.com.cleanui.calendar.top.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R


internal class RvAdapterTopHorizontalCalendar(list: ArrayList<DayCalendar>,
                                     private var year: Int,
                                     private var monthNumber: Int,
                                     private val listener: SelectedDayListener, private val mainTextColor: Int, private val accentColor: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val list: ArrayList<DayCalendar> = ArrayList()


    init {
        this.list.addAll(list)
    }


    fun setSelect(dayNumber: Int) {
        for (i in list.indices) {
            list[i].setSelected(i == dayNumber)
        }
        notifyDataSetChanged()
    }

    fun setMonth(days: List<DayCalendar>, year: Int, monthNumber: Int) {
        this.year = year
        this.monthNumber = monthNumber
        this.list.clear()
        this.list.addAll(days)
        notifyDataSetChanged()
    }





    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_week_day_month_day_horizontal_calendar, viewGroup, false)
        return DayHorizontalTopHorizontalCalendarViewHolder(itemView, listener, mainTextColor, accentColor)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as DayHorizontalTopHorizontalCalendarViewHolder).bind(list[pos], year, monthNumber, pos)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface SelectedDayListener {
        fun onSelected(daySelectedNumber: Int, monthNumber: Int)
    }
}
