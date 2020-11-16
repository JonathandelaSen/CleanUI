package devjdelasen.com.cleanuilib

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import java.io.IOException
import kotlin.math.roundToInt

class Utils {

    companion object {

        fun tintStatusBar(color: Int, lightText: Boolean, activity: Activity) {
            if (!lightText) {
                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            activity.window.statusBarColor = color
        }

        fun getJsonFromAssets(context: Context, fileName: String): String {
            val jsonString: String
                    try {
                        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
                    } catch (ioException: IOException) {
                        ioException.printStackTrace()
                        return "{}"
                    }
            return jsonString
        }
    }
}