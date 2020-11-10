package devjdelasen.com.cleanui.chat.single.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.models.*
import devjdelasen.com.cleanui.utils.UtilsDate
import kotlin.collections.ArrayList
import kotlin.math.abs


class RvMessagesChatAdapter(messagesModel: List<ChatMessageModelAbstract>, onItemClickListener: OnChatMessageItemClickListener) :
    RecyclerView.Adapter<ViewHolder>() {


    var messages: ArrayList<ChatMessageItemList> = ArrayList()

    private val onItemClickListener: OnChatMessageItemClickListener



    init {
        setMessages(messagesModel)
        this.onItemClickListener = onItemClickListener
    }

    fun openMenu(messageToDisplayMenu: ChatMessageModelAbstract) {
        for (message in messages) {
            if (message.id == messageToDisplayMenu.id) {
                message.menuState = ChatMessageModelAbstract.MenuState.OPEN
            }
            else {
                message.menuState = ChatMessageModelAbstract.MenuState.OPEN_IN_OTHER_MESSAGE
            }
        }
        notifyDataSetChanged()
    }

    fun closeMenu() {
        for (message in messages) {
            message.menuState = ChatMessageModelAbstract.MenuState.CLOSE
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View
        return when (viewType) {
            ChatMessageItemList.MESSAGE_RIGHT_ITEM -> {
                itemView = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.clean_ui_chat_item_message_right, viewGroup, false)
                MessageRightChatViewHolder(itemView, onItemClickListener)
            }
            ChatMessageItemList.MESSAGE_LEFT_ITEM -> {
                itemView = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.clean_ui_chat_item_message_left, viewGroup, false)
                MessageLeftChatViewHolder(itemView, onItemClickListener)
            }
            ChatMessageItemList.DATE_ITEM -> {
                itemView = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.clean_ui_chat_item_message_date, viewGroup, false)
                DateChatViewHolder(itemView)
            }
            else -> {
                itemView = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.clean_ui_chat_item_message_time, viewGroup, false)
                TimeChatViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        when (messages[pos].getType()) {
            ChatMessageItemList.MESSAGE_RIGHT_ITEM,
            ChatMessageItemList.MESSAGE_LEFT_ITEM -> {
                (viewHolder as MessageChatViewHolderAbstract).bind(
                    messages[pos] as ChatMessageModel
                )
                return
            }
            ChatMessageItemList.IMAGE_MESSAGE_RIGHT_ITEM,
            ChatMessageItemList.IMAGE_MESSAGE_LEFT_ITEM -> {
                (viewHolder as ImageMessageChatViewHolderAbstract).bind(
                    messages[pos] as ImageChatMessageModel
                )
                return
            }
            ChatMessageItemList.DATE_ITEM -> {
                (viewHolder as DateChatViewHolder).bind(messages[pos] as DateChatMessageItem)
                return
            }
            ChatMessageItemList.TIME_ITEM -> {
                (viewHolder as TimeChatViewHolder).bind(messages[pos] as TimeChatItemList)
                return
            }
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        return messages[position].getType()
    }



    fun insertMessage(chatMessage: ChatMessageModel) {
        var lastMessage: ChatMessageModel? = null
        if (messages.isNotEmpty()) {
            lastMessage = messages[0] as ChatMessageModel
        }
        //TODO Contralar en caso de que saltara una excepción, pero por la lógica de la app no debería ya que el primer mensaje simpre tiene que ser texto
        var messagesInserted = 1
        if (hasToShowDate(chatMessage, lastMessage)) {
            messagesInserted++
            messages.add(0, createDateItem(chatMessage))
        }
        if (hasToShowTime(chatMessage, lastMessage)) {
            messagesInserted++
            messages.add(0, createTimeItem(chatMessage))
        }
        messages.add(0, chatMessage)
        notifyItemRangeInserted(0, messagesInserted)
    }



    private fun setMessages(messages: List<ChatMessageModelAbstract>) {
        val items: MutableList<ChatMessageItemList> =
            ArrayList()
        for (i in messages.indices) {
            items.add(messages[i])
            if (i + 1 >= messages.size) {
                //items.add(createTimeItem(messages[i]))
                items.add(createDateItem(messages[i]))
                continue
            }
            /*if (hasToShowTime(messages[i], messages[i + 1])) {
                items.add(createTimeItem(messages[i]))
            }*/
            if (hasToShowDate(i, messages)) {
                items.add(createDateItem(messages[i]))
            }
        }
        this.messages.addAll(items)
    }

    private fun hasToShowTime(
        chatMessage1: ChatMessageModel,
        chatMessage2: ChatMessageModel?
    ): Boolean {
        if (chatMessage2 == null) {
            return true
        }
        val difference: Int = abs(
            UtilsDate.getDifferenceInMinutes(
                chatMessage1.createdAt,
                chatMessage2.createdAt
            )
        )
        return difference > ChatCleanUI.minDifferenceMinutesToShowTimeInChat
    }

    private fun hasToShowDate(
        position: Int,
        messages: List<ChatMessageModelAbstract>
    ): Boolean {
        return !UtilsDate.isSameDay(
            messages[position].createdAt,
            messages[position + 1].createdAt
        )
    }

    private fun hasToShowDate(
        chatMessage1: ChatMessageModel,
        chatMessage2: ChatMessageModel?
    ): Boolean {
        return if (chatMessage2 == null) {
            true
        } else !UtilsDate.isSameDay(chatMessage1.createdAt, chatMessage2.createdAt)
    }

    private fun createDateItem(chatMessage: ChatMessageModelAbstract): ChatMessageItemList {
        return DateChatMessageItem(chatMessage.createdAt)
    }

    private fun createTimeItem(chatMessage: ChatMessageModel): ChatMessageItemList {
        return TimeChatItemList(chatMessage.createdAt)
    }
}
