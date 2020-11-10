package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.utils.ChatDateUtils
import java.util.*


class ChatMessageModel(id: String,
                       message: String,
                       senderId: String,
                       var conversationId: String,
                       val receptorId: String,
                       createdAt: Date) : ChatMessageModelAbstract(id, senderId, message, createdAt) {



    private var createdAtFormatted: String = ""


    init {
        createdAtFormatted = ChatDateUtils.getTimeChatMessage(createdAt)
    }

    fun getFormattedDate(): String {
        return createdAtFormatted
    }


    override fun getType(): Int {
        return if (amISender()) {
            ChatMessageItemList.MESSAGE_RIGHT_ITEM
        } else {
            ChatMessageItemList.MESSAGE_LEFT_ITEM
        }
    }

}