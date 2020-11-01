package devjdelasen.com.cleanuilib

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import devjdelasen.com.cleanui.utils.TextStyle
import devjdelasen.com.cleanui.dialogs.ActionDialog
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)


        toolbar.setLeftClickListener(View.OnClickListener {
            finish()
        })

        settingsTerms.setListener(View.OnClickListener {
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

        settingsPrivacyPolicy.setListener(View.OnClickListener {
            Toast.makeText(this@SettingsActivity, "Settings privacy policy clicked", Toast.LENGTH_SHORT).show()
        })

        settingsVersion.setListener(View.OnClickListener {
            Toast.makeText(this@SettingsActivity, "Settings version clicked", Toast.LENGTH_SHORT).show()
        })

        settingsBlocks.setListener(View.OnClickListener {
            Toast.makeText(this@SettingsActivity, "Settings blocks clicked", Toast.LENGTH_SHORT).show()
        })

        settingsSound.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { p0, checked ->
            Toast.makeText(this@SettingsActivity, "Settings sound $checked", Toast.LENGTH_SHORT).show()
        })

        settingsDisplayNotis.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { p0, checked ->
            Toast.makeText(this@SettingsActivity, "Settings display notis $checked", Toast.LENGTH_SHORT).show()
        })

        blocksTitleSection.getTitleTextView().text = "Access to the TextView"
        blocksTitleSection.setTitle("Programmatically long title to se its behaviour")

        settingsSubtextProgrammatically.setTitle(title = "From code")
        settingsSubtextProgrammatically.setSubtext(subtext = "Subtext", subtextColor = resources.getColor(R.color.app_colorPrimary, null))
        settingsActionProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null))
        settingsCheckboxProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null), titleTextSize = 14f, titleTextStyle = TextStyle.BOLD)
        //settingsCheckboxProgrammatically.getTitleTextView()


    }
}