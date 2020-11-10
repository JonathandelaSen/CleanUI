package devjdelasen.com.cleanui.popups.PopupMenu

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.PopupWindow
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import devjdelasen.com.cleanui.chat.ChatPopupMenu.models.PopupMenuModel

class CleanUIChatPopupMenu {


    companion object {

        fun show(chatPopupMenuModel: ChatPopupMenuModel, context: Context)  {
            CleanUIPopupMenu.show(chatPopupMenuModel, context)
        }
    }

    class ChatPopupMenuModel(anchorView: View, menu: Int, isMyMessage: Boolean, onClickListener: OnClickListener? = null, onDismissListener: PopupWindow.OnDismissListener? = null):
        PopupMenuModel(
            anchorView,
            menu,
            if (isMyMessage)
                PopupMenuModelStyles(
                    ChatCleanUI.getActivity().resources.getColor(R.color.clean_ui_chat_text_message, null),
                    PopupMenuModelPlanBgStyle(
                        ChatCleanUI.getActivity().resources.getColor(R.color.clean_ui_white, null),
                        ChatCleanUI.getActivity().resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_popup_menu_radius).toFloat()))
            else
                PopupMenuModelStyles(
                    ChatCleanUI.getActivity().resources.getColor(R.color.clean_ui_white, null),
                    PopupMenuModelGradientBgStyle(
                        ChatCleanUI.getAccent(),
                        ChatCleanUI.getAccentDark(),
                        GradientDrawable.Orientation.LEFT_RIGHT,
                        ChatCleanUI.getActivity().resources.getDimensionPixelOffset(R.dimen.clean_ui_chat_popup_menu_radius).toFloat())),
            onClickListener,
            onDismissListener)

}
