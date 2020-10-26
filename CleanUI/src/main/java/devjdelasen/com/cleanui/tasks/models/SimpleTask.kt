package devjdelasen.com.cleanui.tasks.models

import java.util.*

class SimpleTask(title: String, description: String? = null,
                 startTime: Date? = null, endTime: Date? = null,
                 topRightIcon: IconCleanUI? = null): TaskAbstract(title, description, startTime, endTime, topRightIcon) {

    override fun getType(): TaskType {
        return TaskType.SIMPLE
    }


}