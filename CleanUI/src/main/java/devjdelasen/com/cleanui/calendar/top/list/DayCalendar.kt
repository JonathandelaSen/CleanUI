package devjdelasen.com.cleanui.calendar.top.list

import devjdelasen.com.cleanui.UtilsDate
import devjdelasen.com.cleanui.calendar.GenericHolderInterface
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import java.util.*

internal class DayCalendar: GenericHolderInterface {

    var tasks: ArrayList<TaskAbstract> = ArrayList<TaskAbstract>()

    private var isHolderSelected = false


    companion object {


    }

    override fun isSelected(): Boolean {
        return isHolderSelected
    }

    override fun setSelected(isSelected: Boolean) {
        isHolderSelected = isSelected
    }


}