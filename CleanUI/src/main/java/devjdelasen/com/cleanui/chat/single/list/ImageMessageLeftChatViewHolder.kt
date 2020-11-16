package devjdelasen.com.cleanui.chat.single.list

import android.R.attr.shape
import android.graphics.drawable.GradientDrawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.models.ImageChatMessageModel
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_image_left.view.*
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.*
import kotlinx.android.synthetic.main.clean_ui_chat_item_message_left.view.clean_ui_chat_tvMessage


class ImageMessageLeftChatViewHolder(itemView: View, onItemClickListener: OnChatMessageItemClickListener) :
    ImageMessageChatViewHolderAbstract(itemView, onItemClickListener) {


    init {
        val gd = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(ChatCleanUI.getAccent(), ChatCleanUI.getAccentDark()))
        val radius = itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat()
        gd.cornerRadii = floatArrayOf(0f, 0f, radius, radius, radius, radius, radius, radius)
        itemView.clean_ui_chat_clImage?.background = gd

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
                    0f,
                    itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat(),
                    if (message?.message.isNullOrBlank()) itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat() else 0f,
                    if (message?.message.isNullOrBlank()) itemView.resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_message_radius).toFloat() else 0f
                )
            )
            //.placeholder(R.drawable.loading_spinner)
            .into(itemView.clean_ui_chat_ivImage);
    }

}
