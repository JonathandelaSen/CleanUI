package devjdelasen.com.cleanui.chat.TypeMessageBox

import android.content.Context
import android.text.Editable
import android.text.method.KeyListener
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.utils.ConstraintsManager
import io.roadstr.app.Utils.KeyboardEventListener
import kotlinx.android.synthetic.main.clean_ui_type_message_box.view.*


class TypeMessageBox : LinearLayout {


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_type_message_box, this)

        setListeners()
    }

    private fun setListeners() {
        clean_ui_etMessage.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                expandChatBox()
                return@OnFocusChangeListener
            }
            closeChatBox()
        }
    }


    private fun closeChatBox() {
        clean_ui_clRoot?.setBackgroundColor(resources.getColor(R.color.clean_ui_chat_bg, null))
        clean_ui_clBox?.background = ResourcesCompat.getDrawable(resources, R.drawable.clean_ui_type_message_box_bg, null)
        val consSet = ConstraintsManager.constraintParent(clean_ui_clRoot, clean_ui_clBox.id,
            start = true, top = true, end = true, bottom = true,
            marginStart = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_side_space),
            marginTop = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space),
            marginEnd = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_side_space),
            marginBottom = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space)
        )
        ConstraintsManager.animate(clean_ui_clRoot, consSet)
    }

    private fun expandChatBox() {
        clean_ui_clBox?.background = null
        clean_ui_clRoot?.setBackgroundColor(resources.getColor(R.color.clean_ui_white, null))
        val consSet = ConstraintsManager.constraintParent(clean_ui_clRoot, clean_ui_clBox.id,
            start = true, top = true, end = true, bottom = true,
                    marginTop = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space),
                    marginBottom = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space))
        ConstraintsManager.animate(clean_ui_clRoot, consSet)
    }


}
