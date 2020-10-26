package devjdelasen.com.cleanui.tasks.models

import devjdelasen.com.cleanui.UtilsDate
import java.util.*


abstract class TaskAbstract(val title: String, val description: String? = null,
                            val startTime: Date? = null, private val endTime: Date? = null,
                            val topRightIcon: IconCleanUI? = null) {

    enum class TaskType(val value: Int) {
        SIMPLE(0)
    }


    fun getTimeInterval(): String {
        if (startTime != null && endTime != null) {
            return "${UtilsDate.getTime(startTime, UtilsDate.DEFAULT_TIME_FORMAT)} - ${UtilsDate.getTime(endTime, UtilsDate.DEFAULT_TIME_FORMAT)}"
        }
        if (startTime != null) {
            return UtilsDate.getTime(startTime, UtilsDate.DEFAULT_TIME_FORMAT)
        }
        return ""
    }


    abstract fun getType(): TaskType


}
