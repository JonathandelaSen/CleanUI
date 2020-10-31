package devjdelasen.com.cleanui.tasks.models

import androidx.annotation.ColorRes
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import java.util.*

class SimpleTask(title: String,
                 description: String? = null,
                 date: Date? = null,
                 startTime: Date? = null,
                 endTime: Date? = null,
                 category: CategoryTaskModel? = null,
                 topRightIcon: SimpleIconModel? = null,
                 accentButton: AccentButtonModel? = null,
                 @ColorRes markColor: Int? = null):
    TaskAbstract(title, description, date, startTime, endTime, category, accentButton, topRightIcon, markColor) {

    override fun getType(): TaskType {
        return TaskType.SIMPLE
    }


}