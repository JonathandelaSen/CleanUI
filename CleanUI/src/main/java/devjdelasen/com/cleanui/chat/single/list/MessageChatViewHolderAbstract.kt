package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.models.ChatMessageModel
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import devjdelasen.com.cleanui.utils.Utils
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.*
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.clean_ui_chat_tvMessage
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.clean_ui_chat_tvTime
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.clean_ui_chat_vBlackOverLayOverMessage


abstract class MessageChatViewHolderAbstract(itemView: View, val onItemClickListener: OnChatMessageItemClickListener) : RecyclerView.ViewHolder(itemView) {


    var message: ChatMessageModel? = null
    private val overlayColor: Int = itemView.resources.getColor(R.color.clean_ui_chat_overlay_shadow_bg, null)


    fun bind(message: ChatMessageModel) {
        this.message = message

        setFields()
    }

    open fun setFields() {
        itemView.clean_ui_chat_tvMessage.text = message?.message
        itemView.clean_ui_chat_tvTime.text = message?.getFormattedDate()
        setMenuOpenOverlayShadow()
    }


    private fun setMenuOpenOverlayShadow() {
        when(message?.menuState) {
            ChatMessageModelAbstract.MenuState.CLOSE -> {
                itemView.clean_ui_chat_tvMessage.elevation = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_message_elevation).toFloat()
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.GONE
                itemView.clean_ui_chat_clMessage.background = null
            }
            ChatMessageModelAbstract.MenuState.OPEN -> {
                itemView.clean_ui_chat_tvMessage.elevation = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_message_elevation).toFloat()
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.GONE
                itemView.clean_ui_chat_clMessage.setBackgroundColor(overlayColor)
            }
            ChatMessageModelAbstract.MenuState.OPEN_IN_OTHER_MESSAGE -> {
                itemView.clean_ui_chat_tvMessage.elevation = 0f
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.VISIBLE
                itemView.clean_ui_chat_clMessage.background = null
            }
        }
    }

    protected open fun setListeners() {
        itemView.clean_ui_chat_tvMessage.setOnLongClickListener {
            onItemClickListener.onItemLongClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_tvMessage)
            true
        }
        itemView.clean_ui_chat_tvMessage.setOnClickListener {
            onItemClickListener.onItemClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_tvMessage)
        }
        itemView.clean_ui_chat_ivOptions.setOnClickListener {
            onItemClickListener.onItemOptionsClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_tvMessage)
        }
    }

}
