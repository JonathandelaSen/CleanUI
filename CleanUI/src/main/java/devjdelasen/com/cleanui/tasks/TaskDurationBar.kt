package devjdelasen.com.cleanui.tasks

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.UtilsDate
import kotlinx.android.synthetic.main.clean_ui_tasks_task_duration_bar.view.*


class TaskDurationBar : LinearLayout {


    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_tasks_task_duration_bar, this)
    }

    fun setDuration(
        startTime: String,
        endTime: String,
        background: Int
    ) {
        clean_ui_vDuration!!.setBackgroundResource(background)
        post(object : Runnable {
            override fun run() {
                val weightVBefore = getWeightBefore(startTime)
                val weightVBar = getWeightBar(weightVBefore, startTime, endTime)
                val weightVAfter = getWeightAfter(weightVBefore, weightVBar)
                var params: LayoutParams = clean_ui_vBefore!!.layoutParams as LayoutParams
                params.weight = weightVBefore.toFloat()
                clean_ui_vBefore!!.layoutParams = params
                params = clean_ui_vDuration!!.layoutParams as LayoutParams
                params.weight = weightVBar.toFloat()
                clean_ui_vDuration!!.layoutParams = params
                params = clean_ui_vAfter!!.layoutParams as LayoutParams
                params.weight = weightVAfter.toFloat()
                clean_ui_vAfter!!.layoutParams = params
            }

            private fun getWeightAfter(weightVBefore: Int, weightVBar: Int): Int {
                var weight = 60 - (weightVBar + weightVBefore)
                if (weight < 0) weight = 0
                return weight
            }

            private fun getWeightBar(
                weightVBefore: Int,
                startTime: String,
                endTime: String
            ): Int {
                val differenceMinutes: Int =
                    UtilsDate.getDifferenceInMinutesTimes(startTime, endTime)
                return if (weightVBefore + differenceMinutes > 60) {
                    60 - weightVBefore
                } else differenceMinutes
            }

            private fun getWeightBefore(startTime: String): Int {
                return UtilsDate.getMinutes(startTime)
            }
        })
    }
}
