package devjdelasen.com.cleanui.tasks

import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.tasks.ListView.RvAdapterTimeline
import devjdelasen.com.cleanui.tasks.ListView.RvAdapterTimeline.TimelineItem.Companion.TASK_TIME_ITEM


abstract class TaskAbstract : RvAdapterTimeline.TimelineItem {
    var day = 0
    var title: String = ""
    var description: String? = null
    var startTime: String = ""
    var endTime: String = ""
    var place: String? = null
    abstract val intenseColor: Int
    abstract val lightColor: Int
    abstract val backgroundLight: Int
    abstract val backgroundIntense: Int

    val timeInterval: String
        get() = "$startTime - $endTime"

    val duration: String
        get() = UtilsDate.getDifferenceTimes(startTime, endTime)

    override val type: Int
        get() = TASK_TIME_ITEM
}
