package devjdelasen.com.cleanui.chat.models

interface ChatMessageItemList {


    var id: String
    var isSelected: Boolean
    var menuState: ChatMessageModelAbstract.MenuState

    fun getType(): Int

    companion object {
        const val DATE_ITEM = 0
        const val TIME_ITEM = 1
        const val MESSAGE_LEFT_ITEM = 2
        const val MESSAGE_RIGHT_ITEM = 3
        const val IMAGE_MESSAGE_LEFT_ITEM = 4
        const val IMAGE_MESSAGE_RIGHT_ITEM = 5
    }
}