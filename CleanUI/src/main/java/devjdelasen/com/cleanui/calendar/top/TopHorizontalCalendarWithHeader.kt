package devjdelasen.com.cleanui.calendar.top

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import devjdelasen.com.cleanui.*
import devjdelasen.com.cleanui.DividerType
import devjdelasen.com.cleanui.calendar.models.YearCalendar
import devjdelasen.com.cleanui.calendar.top.list.RvAdapterTopHorizontalCalendar
import kotlinx.android.synthetic.main.clean_ui_calendar_with_header_view.view.*


class TopHorizontalCalendarWithHeader : LinearLayout {

    /**
     * RULES
     *
     * - selectedMonth STARTS WITH 0
     * - selectedDay STARTS WITH 1
     *
     * - OUTPUT DAY STARTS WITH 1
     * - OUTPUT MONTHS STARTS WITH 1
     *
     */


    enum class Types(val value: Int) {
        HORIZONTAL(0),
        EXPANDED(1),
        BOTH(2)
    }

    private var llManager: LinearLayoutManager? = null
    private var isTaskline = true
    private var interactionListener: TopHorizontalCalendarInteractionListener? = null
    private var rvAdapter: RvAdapterTopHorizontalCalendar? = null
    private var selectedMonth = UtilsDate.getMonthOfYearNumber()-1
    private var selectedDay = UtilsDate.getDayOfMonthNumber()
    private var selectedYear = UtilsDate.getYearNumber()
    private val year: YearCalendar? = YearCalendar(selectedYear, selectedMonth)

    private var hideToolbar = false
    private var accentColor: Int = -1
    private var dividerColor: Int = -1
    private var mainTextColor: Int = -1
    private var subtextColor: Int = -1
    private var titleColor: Int = -1
    private var type: Int = Types.BOTH.value
    private var dividerType: Int = DividerType.SHADOW.value



    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.TopHorizontalCalendarWithHeader, 0, 0)
        try {
            dividerColor = ta.getColor(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_divider_color, ContextCompat.getColor(context, R.color.clean_ui_divider))
            hideToolbar = ta.getBoolean(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_hide_toolbar, false)
            titleColor = ta.getColor(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_title_color, ContextCompat.getColor(context, R.color.clean_ui_title_default))
            mainTextColor = ta.getColor(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_main_text_color, ContextCompat.getColor(context, R.color.clean_ui_title_default))
            subtextColor = ta.getColor(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_subtext_color, ContextCompat.getColor(context, R.color.clean_ui_subtitle_dark))
            accentColor = ta.getColor(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_accent_color, ContextCompat.getColor(context, R.color.clean_ui_colorPrimary))
            type = ta.getInt(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_type, Types.BOTH.value)
            dividerType = ta.getInt(R.styleable.TopHorizontalCalendarWithHeader_top_calendar_divider_type, DividerType.SHADOW.value)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_calendar_with_header_view, this)
        setInitialState()
        setListeners()
    }




    fun setListeners(horizontalCalendarInteractListener: TopHorizontalCalendarInteractionListener?) {
        this.interactionListener = horizontalCalendarInteractListener
    }





    private fun setInitialState() {
        setStyles()
        showHideViews()
        setType()
        setDividerType(dividerType, clean_ui_calendar_vDivider, this,
            context.resources.getDimensionPixelOffset(R.dimen.clean_ui_dialog_button_radius),
            shadowColor = resources.getColor(R.color.clean_ui_divider_shadow, null), dividerColor = dividerColor)
        selectCurrentDayMonth()
        setDayListIfVisible()
        updateExpandedIfVisible()
    }

    private fun setType() {
        when (type) {
            Types.HORIZONTAL.value -> {
                clean_ui_ivIcCalendar.visibility = View.GONE
                return
            }
            Types.EXPANDED.value -> {
                clean_ui_ivIcCalendar.visibility = View.GONE
                showExpandedCalendar()
                return
            }
        }
    }

    private fun showHideViews() {
        ui_clean_toolbar.visibility = if (hideToolbar) View.GONE else View.VISIBLE
        clean_ui_ivIcTimelineTaskline.setColorFilter(subtextColor)
    }

    private fun setStyles() {
        if (titleColor != -1) ui_clean_toolbar.getTitle().setTextColor(titleColor)
        clean_ui_tvPreviousMonthName.setTextColor(subtextColor)
        clean_ui_tvMonthName.setTextColor(mainTextColor)
        clean_ui_tvPosteriorMonthName.setTextColor(subtextColor)
    }

    private fun selectCurrentDayMonth() {
        setMonthName(selectedMonth)
        seDayMonth(selectedDay, selectedMonth, selectedYear)
    }

    private fun seDayMonth(actualDay: Int, monthNumber: Int,  year: Int) {
        val yearToDisplay = if (year != UtilsDate.getYearNumber()) ", $year" else ""
        clean_ui_tvDayMonth.text = UtilsDate.getFormatDateDayMonthLong(actualDay, monthNumber) + yearToDisplay
        ui_clean_toolbar.setTitle(UtilsDate.getFormatDateDayMonthLong(actualDay, monthNumber) + yearToDisplay, true)
    }

    private fun setDayListIfVisible() {
        if (clean_ui_rv.visibility == View.GONE) return

        if (rvAdapter == null) {
            rvAdapter = RvAdapterTopHorizontalCalendar(year?.get(selectedYear)?.get(selectedMonth)?.days ?: ArrayList(),
                selectedYear, selectedMonth, object : RvAdapterTopHorizontalCalendar.SelectedDayListener {
                    override fun onSelected(daySelectedNumber: Int, monthNumber: Int) {
                        selectedDay = daySelectedNumber+1
                        selectedMonth = monthNumber
                        seDayMonth(selectedDay, selectedMonth, selectedYear)
                        rvAdapter?.setSelect(daySelectedNumber)
                        interactionListener?.onDaySelected(selectedDay, selectedMonth, selectedYear)
                    }
                }, mainTextColor, accentColor)
            llManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            clean_ui_rv.layoutManager = llManager
            clean_ui_rv.adapter = rvAdapter
            llManager?.scrollToPositionWithOffset(selectedDay - 1, 0)
            rvAdapter?.setSelect(selectedDay - 1) //menos uno porque la lista empieza por 0
            return
        }
        rvAdapter?.setMonth(year?.get(selectedYear)?.get(selectedMonth)?.days ?: ArrayList(), selectedYear, selectedMonth)
        rvAdapter?.setSelect(selectedDay - 1)
        (clean_ui_rv.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(selectedDay - 1, 0)
    }

    private fun setMonthName(monthNumber: Int) {
        var previousMontNumber = monthNumber - 1
        var posteriorMontNumber = monthNumber + 1
        if (previousMontNumber < 0) {
            previousMontNumber = 11
        }
        if (posteriorMontNumber > 11) {
            posteriorMontNumber = 0
        }
        clean_ui_tvPreviousMonthName.text = UtilsDate.getMonthOfYearName(previousMontNumber)
        clean_ui_tvMonthName.text = UtilsDate.getMonthOfYearName(monthNumber)
        clean_ui_tvPosteriorMonthName.text = UtilsDate.getMonthOfYearName(posteriorMontNumber)
    }

    private fun setListeners() {
        setMonthListeners()
        setExpandedCalendarListener()
    }

    private fun setExpandedCalendarListener() {
        clean_ui_ivIcCalendar.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View) {
                if (clean_ui_rv.visibility == View.VISIBLE) {
                    showExpandedCalendar()
                    return
                }
                hideExpandedCalendar()
            }

            private fun hideExpandedCalendar() {
                clean_ui_ivIcCalendar.setColorFilter(ContextCompat.getColor(context, R.color.clean_ui_subtitle_dark))
                clean_ui_rv.visibility = View.VISIBLE
                clean_ui_expandedCalendar.visibility = View.GONE
                setDayListIfVisible()
            }
        })
    }

    private fun showExpandedCalendar() {
        clean_ui_ivIcCalendar.setColorFilter(mainTextColor)
        clean_ui_rv.visibility = View.GONE
        clean_ui_expandedCalendar.visibility = View.VISIBLE
        updateExpandedIfVisible()
    }

    private fun setIconTimelineTaskline() {
        if (isTaskline) {
            clean_ui_ivIcTimelineTaskline.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.clean_ui__ic_list, null))
            return
        }
        clean_ui_ivIcTimelineTaskline.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.clean_ui__ic_calendar, null))
    }

    private fun setMonthListeners() {
        clean_ui_tvPreviousMonthName.setOnClickListener {
            selectPreviousMonth()
        }
        clean_ui_tvPosteriorMonthName.setOnClickListener {
            selectNextMonth()
        }
    }

    private fun selectNextMonth() {
        animateMonthTvs()
        incrementSelectedMonth()
        setMonthName(selectedMonth)
        selectCurrentDayMonth()
        setDayListIfVisible()
        updateExpandedIfVisible()
    }

    private fun selectPreviousMonth() {
        animateMonthTvs()
        decrementSelectedMonth()
        setMonthName(selectedMonth)
        selectCurrentDayMonth()
        setDayListIfVisible()
        updateExpandedIfVisible()
    }

    private fun updateExpandedIfVisible() {
        if (clean_ui_expandedCalendar.visibility == View.VISIBLE) {
            clean_ui_expandedCalendar.setCalendar(year?.get(selectedYear)?.get(selectedMonth)?.days ?: ArrayList(),
                selectedDay, selectedMonth, selectedYear, object: TopExpandedCalendar.InteractionListener {
                    override fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int) {
                        selectedDay = daySelected
                        selectedMonth = monthSelected
                        selectedYear = yearSelected
                        selectCurrentDayMonth()
                        interactionListener?.onDaySelected(daySelected, monthSelected, yearSelected)
                    }
                }, mainTextColor, subtextColor, accentColor)
        }
    }

    private fun incrementSelectedMonth() {
        if (selectedMonth == 11) {
            selectedMonth = 0
            selectedYear++
        }
        else {
            selectedMonth++
        }
        year?.add(selectedYear, selectedMonth)
        updateDayBySelectedMonth()
    }

    private fun decrementSelectedMonth() {
        if (selectedMonth == 0) {
            selectedMonth = 11
            selectedYear--
        }
        else {
            selectedMonth--
        }
        year?.add(selectedYear, selectedMonth)
        updateDayBySelectedMonth()
    }

    private fun updateDayBySelectedMonth() {
        selectedDay = if (selectedMonth == UtilsDate.getMonthOfYearNumber()-1 && selectedYear == UtilsDate.getYearNumber()) {
            UtilsDate.getDayOfMonthNumber()
        } else {
            1
        }
    }

    private fun animateMonthTvs() {
        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = LinearInterpolator() //add this
        fadeIn.duration = 1200

        //TODO MANAGER DE ANIMACIONES
        clean_ui_tvPreviousMonthName.startAnimation(fadeIn)
        clean_ui_tvMonthName.startAnimation(fadeIn)
        clean_ui_tvPosteriorMonthName.startAnimation(fadeIn)
    }


    interface TopHorizontalCalendarInteractionListener {
        fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int)
    }

}
