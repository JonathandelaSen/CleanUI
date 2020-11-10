package devjdelasen.com.cleanui.popups.PopupMenu

import android.content.Context
import android.graphics.Rect
import android.view.*
import android.view.LayoutInflater
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatPopupMenu.models.PopupMenuModel
import kotlinx.android.synthetic.main.clean_ui_popup_message_menu.view.*


class CleanUIPopupMenu {


    companion object {

        fun show(popupMenuModel: PopupMenuModel, context: Context): PopupWindow  {
            val inflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.clean_ui_popup_message_menu, null)
            val popupWindow = PopupWindow(popupView, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true)

            setListeners(popupWindow, popupMenuModel.onDismissListener)
            setOptions(popupWindow, popupMenuModel.menu, popupMenuModel.onClickListener, popupMenuModel.styles, context)
            setStyles(popupWindow, popupMenuModel.styles)
            placeInScreen(popupWindow, popupMenuModel.anchorView)

            return popupWindow
        }

        fun hide(popupWindow: PopupWindow) {
            popupWindow.dismiss()
        }



        private fun placeInScreen(popupWindow: PopupWindow, anchorView: View) {
            val viewRect = Rect()
            anchorView.getGlobalVisibleRect(viewRect)
            popupWindow.showAtLocation(anchorView.parent as View,
                Gravity.TOP or Gravity.START, viewRect.left, viewRect.bottom)
        }

        private fun setStyles(
            popupWindow: PopupWindow,
            styles: PopupMenuModel.PopupMenuModelStyles
        ) {
            styles.apply(popupWindow)
        }

        private fun setOptions(popupWindow: PopupWindow, menu: Int, onClick: PopupMenuModel.OnClickListener?, styles: PopupMenuModel.PopupMenuModelStyles, context: Context) {
            val popupM = PopupMenu(context, null)
            val menuPopupM: Menu = popupM.menu
            MenuInflater(context).inflate(menu, menuPopupM)

            for (i in 0 until menuPopupM.size()) {
                addOption(popupWindow, menuPopupM.getItem(i), onClick, styles, context)
            }
        }

        private fun addOption(popupWindow: PopupWindow, item: MenuItem, onClick: PopupMenuModel.OnClickListener?, styles: PopupMenuModel.PopupMenuModelStyles, context: Context) {
            val tv: TextView = LayoutInflater.from(context).inflate(R.layout.clean_ui_textview_option_popup_menu, null) as TextView
            tv.text = item.title
            tv.setTextColor(styles.textColor)
            onClick?.let {
                tv.setOnClickListener { _ ->
                    popupWindow.dismiss()
                    it.onClick(item.itemId)
                }
            }
            popupWindow.contentView.clean_ui_chat_popup_llMessageOptions.addView(tv)
        }

        private fun setListeners(popupWindow: PopupWindow, onDismissListener: PopupWindow.OnDismissListener?) {
            onDismissListener?.let {
                popupWindow.setOnDismissListener(it)
            }
        }
    }


}
