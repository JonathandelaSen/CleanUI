package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.utils.ChatDateUtils
import java.util.*


data class TimeChatItemList(var date: Date) : ChatMessageItemList {

    override var isSelected = false
    override var menuState = ChatMessageModelAbstract.MenuState.CLOSE
    override var id: String = ""

    var formattedTime: String = ""

    init {
        this.formattedTime = ChatDateUtils.getTimeChatMessage(date)
    }


    override fun getType(): Int {
        return ChatMessageItemList.TIME_ITEM
    }
}