package devjdelasen.com.cleanuilib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import devjdelasen.com.cleanui.calendar.top.TopHorizontalCalendarWithHeader
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)

        topHorizontalCalendar?.setListeners(object: TopHorizontalCalendarWithHeader.TopHorizontalCalendarInteractionListener {
            override fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int) {
                Toast.makeText(this@CalendarActivity, "$daySelected - ${monthSelected +1} - $yearSelected", Toast.LENGTH_SHORT).show()
            }
        })
    }
}