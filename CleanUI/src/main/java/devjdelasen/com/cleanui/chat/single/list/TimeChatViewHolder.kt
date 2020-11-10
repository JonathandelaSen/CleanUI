package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.chat.models.DateChatMessageItem
import devjdelasen.com.cleanui.chat.models.TimeChatItemList
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_time.view.*

class TimeChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(dateItem: TimeChatItemList) {
        itemView.clean_ui_chat_tvTime.text = dateItem.formattedTime
    }

}
