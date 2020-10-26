package devjdelasen.com.cleanuilib

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import devjdelasen.com.cleanui.dialogs.ActionDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)


        settingsToolbars.setOnClickListener {
            startActivity(Intent(this, ToolbarSampleActivity::class.java))
        }

        settingsCalendar.setListener(View.OnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        })

        settingsSettings.setListener(View.OnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        })

        settingsActionDialog.setListener(View.OnClickListener {
            val dialog = ActionDialog(title = "Sed ut perspiciatis",
                subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.",
                buttonText = "Button",
                buttonColor = R.color.app_colorAccent,
                buttonSecondaryColor = R.color.app_colorSeconday,
                gradientOrientation = GradientDrawable.Orientation.TL_BR,
                cancelable = true,
                context = this)
            dialog.setListeners(onButtonClickListener = View.OnClickListener {
                dialog.dismiss()
            })
            dialog.showDialog()
        })



    }
}