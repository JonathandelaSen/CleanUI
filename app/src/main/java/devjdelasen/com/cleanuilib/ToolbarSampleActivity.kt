package devjdelasen.com.cleanuilib

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
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

        simpleToolbarProgrammatically.setIcons(null, null, null, null)
        simpleToolbarProgrammatically.setTitle("From the code", false)
        //simpleToolbarProgrammatically.getTitle() //Don't use it to set the text
        simpleToolbarProgrammatically.setLeftIcon(ContextCompat.getDrawable(this, R.drawable.ic_chat_gradient))
        simpleToolbarProgrammatically.setRight1Icon(ContextCompat.getDrawable(this, R.drawable.ic_options), R.color.app_colorPrimary)
    }


    private fun tintStatusBar(color: Int, lightText: Boolean, activity: Activity) {
        if (!lightText) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        activity.window.statusBarColor = color
    }
}