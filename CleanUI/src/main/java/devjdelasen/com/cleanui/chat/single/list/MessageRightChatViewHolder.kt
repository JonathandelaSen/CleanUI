package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener

class MessageRightChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) : MessageChatViewHolderAbstract(itemView, onItemClickListener) {

    init {
        setListeners()
    }
}
