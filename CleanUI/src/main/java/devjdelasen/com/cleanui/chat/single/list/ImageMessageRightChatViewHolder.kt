package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener

class ImageMessageRightChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) : ImageMessageChatViewHolderAbstract(itemView, onItemClickListener) {

    init {
        setListeners()
    }
}
