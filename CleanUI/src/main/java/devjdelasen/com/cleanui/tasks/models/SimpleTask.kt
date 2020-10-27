package devjdelasen.com.cleanui.tasks.models

import java.util.*

class SimpleTask(title: String,
                 description: String? = null,
                 startTime: Date? = null,
                 endTime: Date? = null,
                 category: CategoryTaskModel? = null,
                 topRightIcon: IconModel? = null,
                 accentButton: AccentButtonModel? = null):
    TaskAbstract(title, description, startTime, endTime, category, topRightIcon, accentButton) {

    override fun getType(): TaskType {
        return TaskType.SIMPLE
    }


}