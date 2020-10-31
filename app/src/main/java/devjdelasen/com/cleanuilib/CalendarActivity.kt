package devjdelasen.com.cleanuilib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.calendar.top.TopHorizontalCalendarWithHeader
import devjdelasen.com.cleanui.extensions.addHours
import devjdelasen.com.cleanui.icons.SimpleIcon
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import devjdelasen.com.cleanui.tasks.models.*
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)

        topHorizontalCalendar?.setListeners(object :
            TopHorizontalCalendarWithHeader.TopHorizontalCalendarInteractionListener {
            override fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int) {
                Toast.makeText(
                    this@CalendarActivity,
                    "$daySelected - ${monthSelected + 1} - $yearSelected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        taskline.set(getSimpleTasks())
        //taskline.set(getMinimalTasks())
    }

    private fun getSimpleTasks(): List<TaskAbstract> {
        val tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

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

        tasks.add(SimpleTask(
            title = "Lorem ipsum dolor",
            description = "Cum adiurator messis, omnes nixuses vitare noster.",
            startTime = dateStart1, endTime = dateEnd1,
            category = CategoryTaskModel("1",
                CircleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_application_framework_meteor,
                        null
                    ),
                    null,
                    null
                )
            )
            //topRightIcon = IconModel(ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null), null, null),
            //accentButton = AccentButtonModel(text = "#Daily", textSize = 12f, textStyle = TextStyle.NORMAL, tintColor = R.color.app_colorAccent)
        ))
        tasks.add(SimpleTask(
            title = "Lorem ipsum dolor",
            description = "Cum adiurator messis, omnes nixuses vitare noster, altus mineralises. Compater moris, tanquam ferox verpa.",
            startTime = dateStart1, endTime = dateEnd1,
            category = CategoryTaskModel("1",
                CircleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_application_framework_intellij_idea,
                        null
                    ),
                    null,
                    null
                )
            ),
            topRightIcon = SimpleIconModel(
                ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null),
                null
            ),
            accentButton = AccentButtonModel(text = "#Demo", textSize = 12f, textStyle = TextStyle.NORMAL, tintColor = R.color.app_colorAccent)
        ))



        tasks.add(
            SimpleTask(
                title = "Chaos is the only moonlight",
                startTime = dateStart1,
                endTime = dateEnd1,
                category = CategoryTaskModel(
                    "1",
                    CircleIconModel(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.streamline_application_framework_bootstrap,
                            null
                        ), null, null
                    )
                ),
                accentButton = AccentButtonModel(
                    text = "#Retro",
                    textSize = 12f,
                    textStyle = TextStyle.NORMAL,
                    tintColor = R.color.app_colorAccent
                )
            )
        )
        tasks.add(
            SimpleTask(
                title = "It is the only guarantee of life.",
                description = "Cum deus assimilant, omnes brabeutaes attrahendam talis, flavum adiuratores.",
                category = CategoryTaskModel(
                    "1",
                    CircleIconModel(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.streamline_application_framework_vue,
                            null
                        ), null, null
                    )
                ),
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_options,
                        null
                    ), null
                ),
                accentButton = AccentButtonModel(
                    text = "#Daily",
                    textSize = 12f,
                    textStyle = TextStyle.NORMAL,
                    tintColor = R.color.app_colorAccent
                )
            )
        )


        tasks.add(SimpleTask(
            title = "Lorem ipsum dolor sit amet",
            description = "Cum adiurator messis, omnes nixuses vitare noster, altus mineralises. Compater moris, tanquam ferox verpa.",
            startTime = dateStart1, endTime = dateEnd1,
            topRightIcon = SimpleIconModel(
                ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null),
                null
            ),
            accentButton = AccentButtonModel(text = "#SprintPlaning", textSize = 12f, textStyle = TextStyle.NORMAL, tintColor = R.color.app_colorAccent)))

        tasks.add(SimpleTask(
            title = "Apolloniates, rector, et sensorem.",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmo",
            startTime = dateStart1, endTime = dateEnd1,
            category = CategoryTaskModel("1",
                CircleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_application_framework_firebase,
                        null
                    ),
                    null,
                    null
                )
            ),
            topRightIcon = SimpleIconModel(
                ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null),
                null
            )
        ))

        tasks.add(SimpleTask(
            title = "Space suits wobble with .",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmo",
            startTime = dateStart1, endTime = dateEnd1,
            category = CategoryTaskModel("1",
                CircleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_application_framework_wordpress,
                        null
                    ),
                    null,
                    null
                )
            ),
            topRightIcon = SimpleIconModel(
                ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null),
                null
            ),
            accentButton = AccentButtonModel(text = "#MMG", textSize = 12f, textStyle = TextStyle.NORMAL, tintColor = R.color.app_colorAccent)))

        tasks.add(SimpleTask(
            title = "Sroom! Imbers mori, tanquam grandis pes.",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmo",
            startTime = dateStart1, endTime = dateEnd1))

        return tasks
    }

    private fun getMinimalTasks(): List<TaskAbstract> {
        val tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

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



        tasks.add(
            MinimalTask(
                title = "Everyone loves the pepperiness of onion curry rinsed with clammy thyme.",
                startTime = dateStart1,
                endTime = dateEnd1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_interface_setting_menu_horizontal,
                        null
                    ), null
                )
            )
        )
        tasks.add(
            MinimalTask(
                title = "Blow me bucaneer, ye big plunder!",
                startTime = dateStart2,
                endTime = dateEnd3
            )
        )
        tasks.add(
            MinimalTask(
                title = "Lorem iamsd 22 psum dolor",
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_entertainment_volume_high,
                        null
                    ), null
                )
            )
        )


        return tasks
    }

}