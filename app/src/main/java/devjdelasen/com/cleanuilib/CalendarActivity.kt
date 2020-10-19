package devjdelasen.com.cleanuilib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CalendarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)
    }
}