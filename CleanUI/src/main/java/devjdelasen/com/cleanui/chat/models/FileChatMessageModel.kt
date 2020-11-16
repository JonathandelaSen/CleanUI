package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.utils.ChatDateUtils
import devjdelasen.com.cleanui.utils.Utils
import java.util.*


class FileChatMessageModel(id: String,
                           senderId: String,
                           var fileUrl: String,
                           var conversationId: String,
                           val receptorId: String,
                           createdAt: Date) : ChatMessageModelAbstract(id, senderId, "", createdAt) {



    private var createdAtFormatted: String = ""


    init {
        createdAtFormatted = ChatDateUtils.getTimeChatMessage(createdAt)
    }

    fun getFormattedDate(): String {
        return createdAtFormatted
    }

    fun getFileName(): String {
        return Utils.getLastSegmentPath(fileUrl)
    }


    override fun getType(): Int {
        return if (amISender()) {
            ChatMessageItemList.FILE_MESSAGE_RIGHT_ITEM
        } else {
            ChatMessageItemList.FILE_MESSAGE_LEFT_ITEM
        }
    }

}