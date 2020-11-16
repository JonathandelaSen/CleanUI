package devjdelasen.com.cleanui.chat.single.list

import android.R.attr.shape
import android.graphics.drawable.GradientDrawable
import android.view.View
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import devjdelasen.com.cleanui.utils.Utils
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_file_left.view.*
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_file_left.view.clean_ui_chat_tvMessage
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.*


class FileMessageRightChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) :
    FileMessageChatViewHolderAbstract(itemView, onItemClickListener) {


    init {
        val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(ChatCleanUI.getAccent(), ChatCleanUI.getAccentDark()))
        gd.cornerRadii = floatArrayOf(999f, 999f, 999f, 999f, 999f, 999f, 999f, 999f)
        itemView.clean_ui_chat_ivFile.background = gd
        itemView.clean_ui_chat_subtextMessage.setTextColor(ChatCleanUI.getAccentDark())

        setListeners()
    }

}
