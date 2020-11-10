package devjdelasen.com.cleanui.chat

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import android.widget.RelativeLayout
import androidx.annotation.ColorRes
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatPopupMenu.models.PopupMenuModel
import devjdelasen.com.cleanui.chat.exceptions.MissingCleanUIChatInitialization
import devjdelasen.com.cleanui.chat.models.ChatMessageModel
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.popups.PopupMenu.CleanUIChatPopupMenu

object ChatCleanUI {

    val minDifferenceMinutesToShowTimeInChat = 5

    var userId: String? = null

    private var activity: Activity? = null
    private var rootView: View? = null
    private var accentColor: Int = -1
    private var accentDarkColor: Int = -1


    fun init(activity: Activity,
             //rootView: View,
             userId: String? = null,
             @ColorRes accentColor: Int = -1,
             @ColorRes accentDarkColor: Int = -1) {
        this.activity = activity
        //this.rootView = rootView
        this.userId = userId
        setAccent(accentColor, accentDarkColor)
        setAccentDark(accentColor, accentDarkColor)
        if (accentColor != -1) getActivity().resources.getColor(accentColor, null)
        if (accentDarkColor != -1) getActivity().resources.getColor(accentDarkColor, null)

    }


    fun displayMyMessageOptionsMenu(amISender: Boolean, anchorView: View, menu: Int,
                                    onClickListener: PopupMenuModel.OnClickListener? = null,
                                    onDismissListener: PopupWindow.OnDismissListener? = null) {
        val chatPopupMenuModel = CleanUIChatPopupMenu.ChatPopupMenuModel(anchorView, menu, amISender, onClickListener, onDismissListener)
        CleanUIChatPopupMenu.show(chatPopupMenuModel, getActivity())
    }

    private fun setAccent(@ColorRes accentColor: Int = -1, @ColorRes accentDarkColor: Int = -1) {
        if (accentColor != -1) {
            this.accentColor = getActivity().resources.getColor(accentColor, null)
            return
        }
        if (accentDarkColor != -1) {
            this.accentColor = getActivity().resources.getColor(accentDarkColor, null)
            return
        }
        this.accentColor = getActivity().resources.getColor(R.color.clean_ui_chat_bubble_left_bg, null)
    }

    private fun setAccentDark(@ColorRes accentColor: Int = -1, @ColorRes accentDarkColor: Int = -1) {
        if (accentDarkColor != -1) {
            this.accentDarkColor = getActivity().resources.getColor(accentDarkColor, null)
            return
        }
        if (accentColor != -1) {
            this.accentDarkColor = getActivity().resources.getColor(accentColor, null)
            return
        }
        this.accentDarkColor = getActivity().resources.getColor(R.color.clean_ui_chat_bubble_left_dark_bg, null)
    }


    internal fun getRootView(): View {
        rootView?.let {
            return it
        }
        throw MissingCleanUIChatInitialization()
    }

    internal fun getActivity(): Activity {
        activity?.let {
            return it
        }
        throw MissingCleanUIChatInitialization()
    }

    internal fun getUserId(): String {
        //TODO: Move to user preferences
        userId?.let {
            return it
        }
        throw MissingCleanUIChatInitialization("You must set the user id on ChatCleanUI")
    }

    internal fun getAccent(): Int {
        if (accentColor != -1) {
            return accentColor
        }
        throw MissingCleanUIChatInitialization()
    }

    internal fun getAccentDark(): Int {
        if (accentDarkColor != -1) {
            return accentDarkColor
        }
        throw MissingCleanUIChatInitialization()
    }

}