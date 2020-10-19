package devjdelasen.com.cleanui.tasks

import devjdelasen.com.cleanui.tasks.ListView.RvAdapterTimeline
import devjdelasen.com.cleanui.tasks.ListView.RvAdapterTimeline.TimelineItem.Companion.HOUR_TIME_ITEM


class HourItemTimeline(var time: Int) : RvAdapterTimeline.TimelineItem {

    override val type: Int
        get() = HOUR_TIME_ITEM

}