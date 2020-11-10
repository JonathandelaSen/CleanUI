package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.utils.ChatDateUtils
import java.util.*


class ImageChatMessageModel(id: String,
                            message: String,
                            senderId: String,
                            var imageUrl: String,
                            var conversationId: String,
                            val receptorId: String,
                            val createdAt: Date) : ChatMessageModelAbstract(id, senderId, message) {



    private var createdAtFormatted: String = ""


    init {
        createdAtFormatted = ChatDateUtils.getTimeChatMessage(createdAt)
    }

    fun getFormattedDate(): String {
        return createdAtFormatted
    }


    override fun getType(): Int {
        return if (amISender()) {
            ChatMessageItemList.IMAGE_MESSAGE_RIGHT_ITEM
        } else {
            ChatMessageItemList.IMAGE_MESSAGE_LEFT_ITEM
        }
    }

}