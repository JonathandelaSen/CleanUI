package devjdelasen.com.cleanui.settingsRow


import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.CompoundButtonCompat
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.set
import kotlinx.android.synthetic.main.settings_row_action.view.*
import kotlinx.android.synthetic.main.settings_row_check.view.*


class SettingsRowCheckBox: SettingsRow {



    private var cbTintColor: Int = -1



    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SettingsRow, 0, 0)
        try {
            cbTintColor = ta.getColor(R.styleable.SettingsRow_settings_row_icon_action_tint_color, ContextCompat.getColor(context, R.color.colorPrimary))
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    override fun init() {
        setView()

        super.init()
    }



    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener) {
        cb.setOnCheckedChangeListener(listener)
    }

    private fun setView() {
        View.inflate(context, R.layout.settings_row_check, this)
        CompoundButtonCompat.setButtonTintList(cb, ColorStateList.valueOf(cbTintColor));
    }


}