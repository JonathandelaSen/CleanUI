package devjdelasen.com.cleanuilib

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.ChatPopupMenu.models.PopupMenuModel
import devjdelasen.com.cleanui.chat.models.ChatMessageModel
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.chat.models.OnChatMessageItemClickListener
import devjdelasen.com.cleanui.chat.single.list.RvMessagesChatAdapter
import kotlinx.android.synthetic.main.activity_chat.*


class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        Utils.tintStatusBar(resources.getColor(R.color.clean_ui_white, null), false, this)

        setList(getMessages())


    }

    private fun setList(messages: ArrayList<ChatMessageModelAbstract>) {
        rv?.adapter = RvMessagesChatAdapter(messages, object: OnChatMessageItemClickListener {
            override fun onItemLongClick(message: ChatMessageModelAbstract, messageView: View) {
                ChatCleanUI.displayMyMessageOptionsMenu(
                    message.amISender(),
                    messageView,
                    if (message.amISender()) R.menu.my_message_menu else R.menu.my_message_menu,
                    object : PopupMenuModel.OnClickListener {
                        override fun onClick(id: Int) {
                            Toast.makeText(this@ChatActivity, "id $id", Toast.LENGTH_SHORT).show()
                        }
                    },
                    PopupWindow.OnDismissListener { (rv?.adapter as? RvMessagesChatAdapter)?.closeMenu() }
                )
                (rv?.adapter as? RvMessagesChatAdapter)?.openMenu(message)
            }

            override fun onItemOptionsClick(message: ChatMessageModelAbstract, messageView: View) {
                ChatCleanUI.displayMyMessageOptionsMenu(
                    message.amISender(),
                    messageView,
                    if (message.amISender()) R.menu.my_message_menu else R.menu.my_message_menu,
                    object : PopupMenuModel.OnClickListener {
                        override fun onClick(id: Int) {

                        }
                    },
                    PopupWindow.OnDismissListener { (rv?.adapter as? RvMessagesChatAdapter)?.closeMenu() }
                )
                (rv?.adapter as? RvMessagesChatAdapter)?.openMenu(message)
            }

            override fun onItemClick(message: ChatMessageModelAbstract, messageView: View) {
            }

            override fun onAvatarClick(userId: String) {
            }

            override fun onClick(p0: View?) {
            }

        })
        rv?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getMessages(): ArrayList<ChatMessageModelAbstract> {
        val json = Utils.getJsonFromAssets(this, "messages.json");
        return JsonMapping.getMessages(json)
    }


}