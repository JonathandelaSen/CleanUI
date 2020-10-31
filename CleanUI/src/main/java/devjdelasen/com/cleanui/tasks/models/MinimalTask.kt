package devjdelasen.com.cleanui.tasks.models

import androidx.annotation.ColorRes
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import java.util.*

class MinimalTask(title: String,
                  startTime: Date? = null,
                  endTime: Date? = null,
                  topRightIcon: SimpleIconModel? = null,
                  @ColorRes markColor: Int? = null):
    TaskAbstract(title = title, description = null, startTime = startTime,
        endTime = endTime, markColor = markColor, topRightIcon = topRightIcon) {

    override fun getType(): TaskType {
        return TaskType.MINIMAL
    }


}