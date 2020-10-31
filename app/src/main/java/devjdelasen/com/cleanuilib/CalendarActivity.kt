package devjdelasen.com.cleanuilib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.calendar.top.TopHorizontalCalendarWithHeader
import devjdelasen.com.cleanui.extensions.addHours
import devjdelasen.com.cleanui.icons.SimpleIcon
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import devjdelasen.com.cleanui.tasks.List.RvAdapterTasks
import devjdelasen.com.cleanui.tasks.models.*
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*

class CalendarActivity : AppCompatActivity() {

    private var rvAdapter: RvAdapterTasks? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)

        setList(getSimpleTasks())
        topHorizontalCalendar?.init(object :
            TopHorizontalCalendarWithHeader.TopHorizontalCalendarInteractionListener {
            override fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int, tasks: List<TaskAbstract>) {
                Toast.makeText(
                    this@CalendarActivity,
                    "$daySelected - ${monthSelected + 1} - $yearSelected",
                    Toast.LENGTH_SHORT
                ).show()
                setList(tasks)
            }

            override fun getTasks(
                monthSelected: Int,
                yearSelected: Int
            ): List<TaskAbstract> {
                return getRandomTasks(monthSelected)
            }
        })
    }





    private fun setList(list: List<TaskAbstract>) {
        if (rvAdapter == null) {
            rvAdapter = RvAdapterTasks(list)
            val llManager = LinearLayoutManager(this)
            rv.layoutManager = llManager
            rv.adapter = rvAdapter
            return
        }
        rvAdapter?.updateTasks(list)
    }

    private fun getRandomTasks(monthSelected: Int): List<TaskAbstract> {
        if (monthSelected % 2 == 0) {
            return getSimpleTasks()
        }
        return getMinimalTasks()
    }

    private fun getSimpleTasks(): List<TaskAbstract> {
        val tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

        val dateStart1 = Date()
        dateStart1.addHours(90)
        val dateEnd1 = Date()
        dateEnd1.addHours(91)

        val dateStart2 = Date()
        dateStart2.addHours(91)
        val dateEnd2 = Date()
        dateEnd2.addHours(93)

        val dateStart3 = Date()
        dateStart3.addHours(215)
        val dateEnd3 = Date()
        dateEnd3.addHours(216)

        val dateStart4 = Date()
        dateStart4.addHours(255)
        val dateEnd4 = Date()
        dateEnd4.addHours(256)

        tasks.add(SimpleTask(
            title = "Lorem ipsum dolor",
            description = "Cum adiurator messis, omnes nixuses vitare noster.",
            date = dateStart1,
            startTime = dateStart1,
            endTime = dateEnd1,
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
            date = dateStart1,
            startTime = dateStart1,
            endTime = dateEnd1,
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
                date = dateStart1,
                startTime = dateStart2,
                endTime = dateEnd2,
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
                date = dateStart3,
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
            date = dateStart3,
            startTime = dateStart3,
            endTime = dateEnd3,
            topRightIcon = SimpleIconModel(
                ResourcesCompat.getDrawable(resources, R.drawable.ic_options, null),
                null
            ),
            accentButton = AccentButtonModel(text = "#SprintPlaning", textSize = 12f, textStyle = TextStyle.NORMAL, tintColor = R.color.app_colorAccent)))

        tasks.add(SimpleTask(
            title = "Apolloniates, rector, et sensorem.",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmo",
            date = dateStart2,
            startTime = dateStart2,
            endTime = dateEnd2,
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
            date = dateStart1,
            startTime = dateStart1,
            endTime = dateEnd1,
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
            date = dateStart3,
            startTime = dateStart3,
            endTime = dateEnd3))

        tasks.add(SimpleTask(
            title = "Sroom! With ground beef  drink whipped cream.",
            description = "Sed do eiusmo",
            date = dateStart4,
            startTime = dateStart4,
            endTime = dateStart4))

        tasks.add(SimpleTask(
            title = "All ales command undead, clear cannons.",
            description = "The girl walks stigma like an interstellar klingon.",
            date = dateStart4,
            startTime = dateStart4,
            endTime = dateStart4,
            category = CategoryTaskModel("1",
                CircleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_desktop,
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

        tasks.add(
            SimpleTask(
                title = "It is the only guarantee of life.",
                description = "Cum deus assimilant, omnes brabeutaes attrahendam talis, flavum adiuratores.",
                date = dateStart4,
                category = CategoryTaskModel(
                    "1",
                    CircleIconModel(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.streamline_interface_religion_cross_1,
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

        return tasks
    }

    private fun getMinimalTasks(): List<TaskAbstract> {
        val tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

        val dateStart1 = Date()
        dateStart1.addHours(240)
        val dateEnd1 = Date()
        dateEnd1.addHours(241)

        val dateStart2 = Date()
        dateStart2.addHours(241)
        val dateEnd2 = Date()
        dateEnd2.addHours(243)

        val dateStart3 = Date()
        dateStart3.addHours(15)
        val dateEnd3 = Date()
        dateEnd3.addHours(16)



        tasks.add(
            MinimalTask(
                title = "Everyone loves the pepperiness of onion curry rinsed with clammy thyme.",
                date = dateStart1,
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
                date = dateStart2,
                startTime = dateStart2,
                endTime = dateEnd2
            )
        )
        tasks.add(
            MinimalTask(
                title = "Lorem iamsd 22 psum dolor",
                date = dateStart3,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_entertainment_volume_high,
                        null
                    ), null
                )
            )
        )

        tasks.add(
            MinimalTask(
                title = "Engage, galaxy!",
                date = dateStart1,
                startTime = dateStart1,
                endTime = dateEnd1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_apple,
                        null
                    ), null
                )
            )
        )
        tasks.add(
            MinimalTask(
                title = "After drying the marshmellows, enamel lentils, okra and condensed milk with it in a bowl.",
                date = dateStart2,
                startTime = dateStart2,
                endTime = dateEnd2
            )
        )
        tasks.add(
            MinimalTask(
                title = "Carnivorous tribbles, to the space station.",
                date = dateStart3,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_google,
                        null
                    ), null
                )
            )
        )

        tasks.add(
            MinimalTask(
                title = "Sagas mori, tanquam fidelis cannabis.",
                date = dateStart1,
                startTime = dateStart1,
                endTime = dateEnd1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_facebook_1,
                        null
                    ), null
                )
            )
        )
        tasks.add(
            MinimalTask(
                title = "Est peritus zirbus, cesaris.",
                date = dateStart2,
                startTime = dateStart2,
                endTime = dateEnd2
            )
        )
        tasks.add(
            MinimalTask(
                title = "Confucius says: stop to forget and travel.",
                date = dateStart3,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_paypal,
                        null
                    ), null
                )
            )
        )

        tasks.add(
            MinimalTask(
                title = "SaGar, punishment!.",
                date = dateStart1,
                startTime = dateStart1,
                endTime = dateEnd1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_twitter,
                        null
                    ), null
                )
            )
        )
        tasks.add(
            MinimalTask(
                title = "Est peritus zisd kejnnrrr nee3m rbus, cesaris.",
                date = dateStart3,
                startTime = dateStart3,
                endTime = dateEnd3
            )
        )
        tasks.add(
            MinimalTask(
                title = " Fight, life, and punishment.Confucius says: stop to forget and travel.",
                date = dateStart1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_skype,
                        null
                    ), null
                )
            )
        )

        tasks.add(
            MinimalTask(
                title = "Sagas mori, tanquam ad02933 kasdm lk asdasda fidelis cannabis.",
                date = dateStart2,
                startTime = dateStart2,
                endTime = dateEnd2,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_youtube,
                        null
                    ), null
                )
            )
        )
        tasks.add(
            MinimalTask(
                title = "Instead of brushing large sweet chili sauce with quinoa, use two tablespoons anchovy essence and four pounds brown sugar grinder.",
                date = dateStart1,
                startTime = dateStart1,
                endTime = dateEnd1
            )
        )
        tasks.add(
            MinimalTask(
                title = "Confucius says: stop to forget and travel.",
                date = dateStart2,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_computer_logo_youtube,
                        null
                    ), null
                )
            )
        )


        return tasks
    }

}