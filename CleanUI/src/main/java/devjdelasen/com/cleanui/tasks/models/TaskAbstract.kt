package devjdelasen.com.cleanui.tasks.models

import androidx.annotation.ColorRes
import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import java.util.*


abstract class TaskAbstract(val title: String,
                            val description: String? = null,
                            val date: Date? = null,
                            val startTime: Date? = null,
                            private val endTime: Date? = null,
                            val category: CategoryTaskModel? = null,
                            val accentButton: AccentButtonModel? = null,
                            val topRightIcon: SimpleIconModel? = null,
                            @ColorRes val markColor: Int? = null) {

    enum class TaskType(val value: Int) {
        SIMPLE(0),
        MINIMAL(1)
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
