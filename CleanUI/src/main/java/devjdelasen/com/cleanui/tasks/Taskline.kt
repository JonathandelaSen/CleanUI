package devjdelasen.com.cleanui.tasks

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.tasks.List.RvAdapterTasks
import devjdelasen.com.cleanui.tasks.models.TaskAbstract
import kotlinx.android.synthetic.main.clean_ui_taskline.view.*

class Taskline : FrameLayout {


    private var rvAdapter: RvAdapterTasks? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.Taskline, 0, 0)
        try {
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_taskline, this)
        setView()
        setListeners()
    }



    fun set(list: List<TaskAbstract>) {
        setList(list)
    }


    private fun setView() {

    }

    private fun setList(list: List<TaskAbstract>) {
        if (rvAdapter == null) {
            rvAdapter = RvAdapterTasks(list)
            val llManager = LinearLayoutManager(context)
            clean_ui_rv_taskline.layoutManager = llManager
            clean_ui_rv_taskline.adapter = rvAdapter
            showHideList(list)
            return
        }
        rvAdapter?.notifyDataSetChanged()
    }

    private fun showHideList(list: List<TaskAbstract>) {
        if (list.isEmpty()) {
            hideList()
            return
        }
        showList()
    }

    private fun showList() {
        //tvNoTasks.setVisibility(View.GONE)
        clean_ui_rv_taskline.visibility = View.VISIBLE
    }

    private fun hideList() {
        //tvNoTasks.setVisibility(View.VISIBLE)
        clean_ui_rv_taskline.visibility = View.GONE
    }

    private fun setListeners() {

    }

}
