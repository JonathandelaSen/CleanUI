package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.chat.models.DateChatMessageItem
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_date.view.*
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_date.view.clean_ui_chat_vBlackOverLay

class DateChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(dateItem: DateChatMessageItem) {
        itemView.clean_ui_chat_tvDate.text = dateItem.formattedDate

       setMenuOpenOverlayShadow(dateItem)
    }

    private fun setMenuOpenOverlayShadow(dateItem: DateChatMessageItem) {
        when(dateItem.menuState) {
            ChatMessageModelAbstract.MenuState.CLOSE -> {
                itemView.clean_ui_chat_vBlackOverLay.visibility = View.GONE
            }
            ChatMessageModelAbstract.MenuState.OPEN -> {
                itemView.clean_ui_chat_vBlackOverLay.visibility = View.VISIBLE
            }
            ChatMessageModelAbstract.MenuState.OPEN_IN_OTHER_MESSAGE -> {
                itemView.clean_ui_chat_vBlackOverLay.visibility = View.VISIBLE
            }
        }
    }

}
