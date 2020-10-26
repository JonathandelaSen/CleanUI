package devjdelasen.com.cleanui.calendar

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import devjdelasen.com.cleanui.R


internal fun TextView.setSelectedTopCalendarDay(isSelected: Boolean, selectedDayColor: Int, nonSelectedDayColor: Int) {
    if (isSelected) {
        background = ResourcesCompat.getDrawable(context.resources, R.drawable.clean_ui_circle, null)
        background.setTint(selectedDayColor)
        background.alpha = 40
        setTextColor(selectedDayColor)
        return
    }
    background = null
    setTextColor(nonSelectedDayColor)
}