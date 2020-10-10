package devjdelasen.com.cleanuilib

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tintStatusBar(resources.getColor(R.color.white, null), false, this)


        settingsToolbars.setOnClickListener {
            startActivity(Intent(this, ToolbarSampleActivity::class.java))
        }

        settingsTerms.setListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "Settings terms clicked", Toast.LENGTH_SHORT).show()
        })

        settingsPrivacyPolicy.setListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "Settings privacy policy clicked", Toast.LENGTH_SHORT).show()
        })

        settingsVersion.setListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "Settings version clicked", Toast.LENGTH_SHORT).show()
        })

        settingsBlocks.setListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "Settings blocks clicked", Toast.LENGTH_SHORT).show()
        })

        settingsSound.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { p0, checked ->
            Toast.makeText(this@MainActivity, "Settings sound $checked", Toast.LENGTH_SHORT).show()
        })

        settingsDisplayNotis.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { p0, checked ->
            Toast.makeText(this@MainActivity, "Settings display notis $checked", Toast.LENGTH_SHORT).show()
        })


    }


    private fun tintStatusBar(color: Int, lightText: Boolean, activity: Activity) {
        if (!lightText) {
            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        activity.window.statusBarColor = color
    }
}