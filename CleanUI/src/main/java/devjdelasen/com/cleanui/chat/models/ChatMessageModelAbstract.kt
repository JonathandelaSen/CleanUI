package devjdelasen.com.cleanui.chat.models

import devjdelasen.com.cleanui.chat.ChatCleanUI
import java.util.*

abstract class ChatMessageModelAbstract(id: String, private val senderId: String, val message: String, val createdAt: Date): ChatMessageItemList {



    final override var id: String = ""
    override var isSelected = false
    override var menuState = MenuState.CLOSE


    init {
        this.id = id
    }


    fun amISender(): Boolean {
        return senderId == ChatCleanUI.getUserId()
    }



    enum class MenuState {
        OPEN, OPEN_IN_OTHER_MESSAGE, CLOSE
    }
}