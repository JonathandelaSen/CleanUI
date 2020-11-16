package devjdelasen.com.cleanui.chat.models

import android.view.View


interface OnChatMessageItemClickListener : View.OnClickListener {
    fun onItemLongClick(message: ChatMessageModelAbstract, messageView: View)
    fun onItemOptionsClick(message: ChatMessageModelAbstract, messageView: View)
    fun onItemClick(message: ChatMessageModelAbstract, messageView: View)
    fun onImageItemClick(message: ChatMessageModelAbstract, messageView: View)
    fun onAvatarClick(userId: String)
}
