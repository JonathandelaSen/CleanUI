package devjdelasen.com.cleanui.settingsRow

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import kotlinx.android.synthetic.main.clean_ui_settings_row_action_clean_ui.view.*


class SettingsRowAction: SettingsRow {



    private var icTintColor: Int = -1



    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SettingsRow, 0, 0)
        try {
            icTintColor = ta.getColor(R.styleable.SettingsRow_settings_row_icon_action_tint_color, -1)
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

    fun getIcon(): ImageView {
        return clean_ui_ivIcAction
    }

    fun setListener(listener: OnClickListener) {
        clean_ui_ivIcAction.setOnClickListener(listener)
    }


    private fun setView() {
        View.inflate(context, R.layout.clean_ui_settings_row_action_clean_ui, this)
        if (icTintColor != -1) ImageViewCompat.setImageTintList(clean_ui_ivIcAction, ColorStateList.valueOf(icTintColor))
    }


}