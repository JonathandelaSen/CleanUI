package devjdelasen.com.cleanuilib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import devjdelasen.com.cleanui.calendar.top.TopHorizontalCalendarWithHeader
import devjdelasen.com.cleanui.extensions.addHours
import devjdelasen.com.cleanui.tasks.models.IconCleanUI
import devjdelasen.com.cleanui.tasks.models.SimpleTask
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

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
        taskline.set(getTasks())
    }

    private fun getTasks(): List<TaskAbstract> {
        val tasks: ArrayList<SimpleTask> = ArrayList<SimpleTask>()

        val dateStart1 = Date()
        dateStart1.addHours(10)
        val dateEnd1 = Date()
        dateEnd1.addHours(11)

        val dateStart2 = Date()
        dateStart2.addHours(1)
        val dateEnd2 = Date()
        dateEnd2.addHours(3)

        val dateStart3 = Date()
        dateStart3.addHours(5)
        val dateEnd3 = Date()
        dateEnd3.addHours(6)

        tasks.add(SimpleTask("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmo",
            dateStart1, dateEnd1,
            IconCleanUI(ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null), null, null)))
        tasks.add(SimpleTask("Excepteur sint occaecat cupidat", "proident, sunt in culpa qu", dateStart2, dateEnd2))
        tasks.add(SimpleTask("Da exercitation ullam", "mod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excep", dateStart3, dateEnd3))
        return tasks
    }

}