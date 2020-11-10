package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.utils.ChatDateUtils
import java.util.*


data class DateChatMessageItem(var date: Date) : ChatMessageItemList {

    override var isSelected = false
    override var menuState = ChatMessageModelAbstract.MenuState.CLOSE
    override var id: String = ""

    var formattedDate: String = ""

    init {
        this.formattedDate = ChatDateUtils.getDateChatMessage(date, ChatCleanUI.getActivity())
    }


    override fun getType(): Int {
        return ChatMessageItemList.DATE_ITEM
    }
}