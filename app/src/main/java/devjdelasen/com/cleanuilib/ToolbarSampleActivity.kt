package devjdelasen.com.cleanuilib

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_toolbar_sample.*

class ToolbarSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_sample)
        tintStatusBar(resources.getColor(R.color.app_white, null), false, this)

        simpleToolbar.setLeftClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight1ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight2ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight3ClickListener(View.OnClickListener { TODO("Not yet implemented") })
    }


    private fun tintStatusBar(color: Int, lightText: Boolean, activity: Activity) {
        if (!lightText) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        activity.window.statusBarColor = color
    }
}