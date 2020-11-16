package devjdelasen.com.cleanui.chat.single.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.models.ImageChatMessageModel
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_image_left.view.*

class ImageMessageRightChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) : ImageMessageChatViewHolderAbstract(itemView, onItemClickListener) {

    init {
        setListeners()
    }

    override fun bind(message: ImageChatMessageModel) {
        super.bind(message)
        setImage()
    }

    private fun setImage() {
        Glide
            .with(itemView.context)
            .load(message?.imageUrl)
            .centerCrop()
            .transform(
                CenterCrop(),
                GranularRoundedCorners(
                    itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat(),
                    itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat(),
                    0f,
                    if (message?.message.isNullOrBlank()) itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat() else 0f
                )
            )
            //.placeholder(R.drawable.loading_spinner)
            .into(itemView.clean_ui_chat_ivImage);
    }
}
