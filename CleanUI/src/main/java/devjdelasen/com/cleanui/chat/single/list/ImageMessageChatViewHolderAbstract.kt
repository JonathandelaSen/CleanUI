package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.chat.models.ImageChatMessageModel
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_image_left.view.*


abstract class ImageMessageChatViewHolderAbstract(itemView: View, val onItemClickListener: OnChatMessageItemClickListener) : RecyclerView.ViewHolder(itemView) {


    var message: ImageChatMessageModel? = null
    private val overlayColor: Int = itemView.resources.getColor(R.color.clean_ui_chat_overlay_shadow_bg, null)


    open fun bind(message: ImageChatMessageModel) {
        this.message = message

        setFields()
    }

    open fun setFields() {
        if (message?.message.isNullOrBlank()) {
            itemView.clean_ui_chat_tvMessage.visibility = View.GONE
            itemView.clean_ui_chat_tvMessage.text = ""
        }
        else {
            itemView.clean_ui_chat_tvMessage.visibility = View.VISIBLE
            itemView.clean_ui_chat_tvMessage.text = message?.message
        }
        itemView.clean_ui_chat_tvMessage.text = message?.message
        itemView.clean_ui_chat_tvTime.text = message?.getFormattedDate()
        setMenuOpenOverlayShadow()
    }


    private fun setMenuOpenOverlayShadow() {
        when(message?.menuState) {
            ChatMessageModelAbstract.MenuState.CLOSE -> {
                itemView.clean_ui_chat_clImage.elevation = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_message_elevation).toFloat()
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.GONE
                itemView.clean_ui_chat_clMessage.background = null
            }
            ChatMessageModelAbstract.MenuState.OPEN -> {
                itemView.clean_ui_chat_clImage.elevation = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_chat_message_elevation).toFloat()
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.GONE
                itemView.clean_ui_chat_clMessage.setBackgroundColor(overlayColor)
            }
            ChatMessageModelAbstract.MenuState.OPEN_IN_OTHER_MESSAGE -> {
                itemView.clean_ui_chat_clImage.elevation = 0f
                itemView.clean_ui_chat_vBlackOverLayOverMessage.visibility = View.VISIBLE
                itemView.clean_ui_chat_clMessage.background = null
            }
        }
    }

    protected open fun setListeners() {
        itemView.clean_ui_chat_tvMessage.setOnLongClickListener {
            onItemClickListener.onItemLongClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_clImage)
            true
        }
        itemView.clean_ui_chat_tvMessage.setOnClickListener {
            onItemClickListener.onItemClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_clImage)
        }
        itemView.clean_ui_chat_ivImage.setOnClickListener {
            onItemClickListener.onImageItemClick(message as ImageChatMessageModel, itemView.clean_ui_chat_clImage)
        }
        itemView.clean_ui_chat_ivImage.setOnLongClickListener {
            onItemClickListener.onItemLongClick(message as ImageChatMessageModel, itemView.clean_ui_chat_clImage)
            true
        }
        itemView.clean_ui_chat_ivOptions.setOnClickListener {
            onItemClickListener.onItemOptionsClick(message as ChatMessageModelAbstract, itemView.clean_ui_chat_clImage)
        }
    }

}
