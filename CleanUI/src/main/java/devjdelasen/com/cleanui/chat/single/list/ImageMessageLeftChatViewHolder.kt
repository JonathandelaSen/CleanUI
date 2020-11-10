package devjdelasen.com.cleanui.chat.single.list

import android.R.attr.shape
import android.graphics.drawable.GradientDrawable
import android.view.View
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.*


class ImageMessageLeftChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) :
    ImageMessageChatViewHolderAbstract(itemView, onItemClickListener) {


    init {
        val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(ChatCleanUI.getAccent(), ChatCleanUI.getAccentDark()))
        val radius = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat()
        gd.cornerRadii = floatArrayOf(0f, 0f, radius, radius, radius, radius, radius, radius)
        itemView.clean_ui_chat_tvMessage?.background = gd

        setListeners()
    }

}
