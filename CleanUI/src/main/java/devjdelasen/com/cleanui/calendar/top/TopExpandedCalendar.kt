package devjdelasen.com.cleanui.calendar.top

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.calendar.setSelectedTopCalendarDay
import devjdelasen.com.cleanui.calendar.top.list.DayCalendar
import kotlinx.android.synthetic.main.clean_ui_top_explanded_calendar.view.*
import kotlinx.android.synthetic.main.clean_ui_item_week_day_month_day_horizontal_calendar.view.*
import kotlin.collections.ArrayList


internal class TopExpandedCalendar : LinearLayout {


    private var interactionListener: InteractionListener? = null
    private var llList: ArrayList<LinearLayout> = ArrayList()
    private var selectedMonth = -1
    private var selectedYear = -1
    private var mainTextColor: Int = -1
    private var subtextColor: Int = -1
    private var accentColor: Int = -1



    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_top_explanded_calendar, this)
        setArrayDays()
        setListeners()
    }


    fun setCalendar(month: List<DayCalendar>, selectedDayNumber: Int, monthNumber: Int, yearNumber: Int,
                    interactionListener: InteractionListener?, mainTextColor: Int, subtextColor: Int, accentColor: Int) {
        this.interactionListener = interactionListener
        this.selectedMonth = monthNumber
        this.selectedYear = yearNumber
        this.mainTextColor = mainTextColor
        this.subtextColor = subtextColor
        this.accentColor = accentColor
        setColorDayNames()

        var firstWeekDayNumber: Int = UtilsDate.getFirstWeekDayNumber(monthNumber, yearNumber)
        val nDaysMonth: Int = UtilsDate.getNDaysMonth(monthNumber, yearNumber)
        firstWeekDayNumber-- // Al empezar lunes en 1 hay que restarle 1
        var dayNumber = 1
        for (i in llList.indices) {
            val tv = getTextView(llList[i])
            if (i >= firstWeekDayNumber && dayNumber <= nDaysMonth) {
                llList[i].visibility = View.VISIBLE
                tv.text = dayNumber.toString()
                setHasNotification(month[dayNumber - 1], getView(llList[i]))
                dayNumber++
            } else {
                llList[i].visibility = View.GONE
            }
            tv.setSelectedTopCalendarDay(dayNumber - 1 == selectedDayNumber, accentColor, mainTextColor)
        }
    }

    fun setDaySelected(daySelectedNumber: Int) {
        var daySelectedNumberAux = daySelectedNumber
        daySelectedNumberAux++
        for (ll in llList) {
            val tv = getTextView(ll)
            val text = tv.text.toString()
            if (text.isNotEmpty() && Integer.valueOf(text) == daySelectedNumberAux) {
                //UtilsApp.setTvDaySelected(tv, true) TODO
            } else {
                //UtilsApp.setTvDaySelected(tv, false) TODO
            }
        }
    }

    private fun setColorDayNames() {
        clean_ui_tvTitleMon.setTextColor(subtextColor)
        clean_ui_tvTitleTue.setTextColor(subtextColor)
        clean_ui_tvTitleWed.setTextColor(subtextColor)
        clean_ui_tvTitleThu.setTextColor(subtextColor)
        clean_ui_tvTitleFri.setTextColor(subtextColor)
        clean_ui_tvTitleSat.setTextColor(subtextColor)
        clean_ui_tvTitleSun.setTextColor(subtextColor)
    }




    private fun setHasNotification(day: DayCalendar, vNotification: View) {
        vNotification.visibility = if (day.tasks.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    private fun setListeners() {
        val listener: OnClickListener = object : OnClickListener {
                override fun onClick(v: View) {
                    val tv = getTextView(v as LinearLayout)
                    if (tv.text.toString().isNotEmpty()) {
                        interactionListener?.onDaySelected(tv.text.toString().toInt(), selectedMonth, selectedYear)
                        deselectedAll()
                        tv.setSelectedTopCalendarDay(true, accentColor, mainTextColor)
                    }
                }

                private fun deselectedAll() {
                    for (ll in llList) {
                        getTextView(ll).setSelectedTopCalendarDay(false, accentColor, mainTextColor)
                    }
                }
            }
        for (ll in llList) {
            ll.setOnClickListener(listener)
        }
    }

    private fun setArrayDays() {
        llList.add(clean_ui_llDay00)
        llList.add(clean_ui_llDay10)
        llList.add(clean_ui_llDay20)
        llList.add(clean_ui_llDay30)
        llList.add(clean_ui_llDay40)
        llList.add(clean_ui_llDay50)
        llList.add(clean_ui_llDay60)
        llList.add(clean_ui_llDay01)
        llList.add(clean_ui_llDay11)
        llList.add(clean_ui_llDay21)
        llList.add(clean_ui_llDay31)
        llList.add(clean_ui_llDay41)
        llList.add(clean_ui_llDay51)
        llList.add(clean_ui_llDay61)
        llList.add(clean_ui_llDay02)
        llList.add(clean_ui_llDay12)
        llList.add(clean_ui_llDay22)
        llList.add(clean_ui_llDay32)
        llList.add(clean_ui_llDay42)
        llList.add(clean_ui_llDay52)
        llList.add(clean_ui_llDay62)
        llList.add(clean_ui_llDay03)
        llList.add(clean_ui_llDay13)
        llList.add(clean_ui_llDay23)
        llList.add(clean_ui_llDay33)
        llList.add(clean_ui_llDay43)
        llList.add(clean_ui_llDay53)
        llList.add(clean_ui_llDay63)
        llList.add(clean_ui_llDay04)
        llList.add(clean_ui_llDay14)
        llList.add(clean_ui_llDay24)
        llList.add(clean_ui_llDay34)
        llList.add(clean_ui_llDay44)
        llList.add(clean_ui_llDay54)
        llList.add(clean_ui_llDay64)
        llList.add(clean_ui_llDay05)
        llList.add(clean_ui_llDay15)
        llList.add(clean_ui_llDay25)
        llList.add(clean_ui_llDay35)
        llList.add(clean_ui_llDay45)
        llList.add(clean_ui_llDay55)
        llList.add(clean_ui_llDay65)
    }

    private fun getTextView(linearLayout: LinearLayout): TextView {
        return linearLayout.getChildAt(0) as TextView
    }

    private fun getView(linearLayout: LinearLayout): View {
        return linearLayout.getChildAt(1)
    }


    interface InteractionListener {
        fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int)
    }
}
