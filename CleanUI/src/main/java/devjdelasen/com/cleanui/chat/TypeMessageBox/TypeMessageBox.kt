package devjdelasen.com.cleanui.chat.TypeMessageBox

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.text.Editable
import android.text.method.KeyListener
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.utils.ConstraintsManager
import io.roadstr.app.Utils.KeyboardEventListener
import io.roadstr.app.Utils.KeyboardUtils
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_file_left.view.*
import kotlinx.android.synthetic.main.clean_ui_type_message_box.view.*


class TypeMessageBox : LinearLayout {


    private var listener: OnInteractionListeners? = null



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




    fun set(listener: OnInteractionListeners) {
        this.listener = listener
        initColors()
    }

    private fun initColors() {
        val gd = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(ChatCleanUI.getAccent(), ChatCleanUI.getAccentDark()))
        gd.cornerRadii = floatArrayOf(999f, 999f, 999f, 999f, 999f, 999f, 999f, 999f)
        clean_ui_flSendMessage.background = gd
    }


    private fun setListeners() {
        clean_ui_etMessage.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                expandChatBox()
                return@OnFocusChangeListener
            }
            closeChatBox()
        }
        clean_ui_etMessage?.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action == MotionEvent.ACTION_UP) {
                    listener?.onClickEditText()
                    return false
                }
                return false
            }
        })
        clean_ui_flSendMessage?.setOnClickListener {
            val message = clean_ui_etMessage?.text?.toString()
            if (!message.isNullOrBlank()) listener?.onSend(message)
        }
    }


    private fun closeChatBox() {
        clean_ui_clRoot?.setBackgroundColor(resources.getColor(R.color.clean_ui_chat_bg, null))
        clean_ui_clBox?.background = ResourcesCompat.getDrawable(resources, R.drawable.clean_ui_type_message_box_bg, null)
        val consSetClBox = ConstraintsManager.constraintParent(clean_ui_clRoot, clean_ui_clBox.id,
            start = true, top = true, end = true, bottom = true,
            marginStart = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_side_space),
            marginTop = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space),
            marginEnd = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_side_space),
            marginBottom = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space)
        )
        ConstraintsManager.animate(clean_ui_clRoot, consSetClBox)
    }

    private fun expandChatBox() {
        clean_ui_clBox?.background = null
        clean_ui_clRoot?.setBackgroundColor(resources.getColor(R.color.clean_ui_white, null))
        val consSet = ConstraintsManager.constraintParent(clean_ui_clRoot, clean_ui_clBox.id,
            start = true, top = true, end = true, bottom = true,
                    marginTop = 0,
                    marginBottom = 0)
        val consSetEditText = ConstraintsManager.constraintParent(clean_ui_clBox, clean_ui_etMessage.id,
            start = true, top = true, end = false, bottom = true,
            marginStart = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_edit_text_side_space),
            marginTop = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space),
            marginBottom = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_top_bottom_space))
        ConstraintsManager.constraintTo(clean_ui_clBox,
            clean_ui_etMessage.id,
            endToId = clean_ui_flSendMessage.id,
            endToOfView = ConstraintSet.START,
            marginEnd = resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_box_edit_text_side_space),
            constraintSet = consSetEditText).applyTo(clean_ui_clBox)
        ConstraintsManager.animate(clean_ui_clRoot, consSet)
    }


    interface OnInteractionListeners {
        fun onClickEditText()
        fun onSend(message: String)
    }

}
