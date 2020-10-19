package devjdelasen.com.cleanuilib

import android.app.Activity
import android.view.View

class Utils {

    companion object {

        fun tintStatusBar(color: Int, lightText: Boolean, activity: Activity) {
            if (!lightText) {
                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            activity.window.statusBarColor = color
        }
    }
}