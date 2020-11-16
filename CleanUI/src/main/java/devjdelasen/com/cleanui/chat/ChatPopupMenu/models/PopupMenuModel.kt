package devjdelasen.com.cleanui.chat.ChatPopupMenu.models

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.PopupWindow
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.chat.ChatCleanUI
import kotlinx.android.synthetic.main.clean_ui_popup_message_menu.view.*


open class PopupMenuModel(val anchorView: View,
                          val gravity: Int,
                          val menu: Int,
                          val styles: PopupMenuModelStyles,
                          val onClickListener: OnClickListener? = null,
                          val onDismissListener: PopupWindow.OnDismissListener? = null) {


    class PopupMenuModelStyles(val textColor: Int, private val bgStyle: PopupMenuModelBgStyle) {
        fun apply(popupWindow: PopupWindow) {
            bgStyle.setStyle(popupWindow)
        }
    }



    interface OnClickListener {
        fun onClick(id: Int)
    }


    abstract class PopupMenuModelBgStyle(val radiusPx: Float) {
        abstract fun setStyle(popupWindow: PopupWindow)
    }

    class PopupMenuModelPlanBgStyle(
        private val color: Int,
        radiusPx: Float): PopupMenuModelBgStyle(radiusPx) {
        override fun setStyle(popupWindow: PopupWindow) {
            val bg = GradientDrawable()
            bg.setColor(color)
            bg.cornerRadii = floatArrayOf(radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx)
            popupWindow.contentView.clean_ui_chat_popup_llMessageOptions?.background = bg
        }

    }

    class PopupMenuModelGradientBgStyle(
        private val firstColor: Int,
        private val secondColor: Int,
        private val gradientOrientation: GradientDrawable.Orientation? = GradientDrawable.Orientation.LEFT_RIGHT,
        radiusPx: Float): PopupMenuModelBgStyle(radiusPx) {
        override fun setStyle(popupWindow: PopupWindow) {
            val gd = GradientDrawable(
                gradientOrientation,
                intArrayOf(firstColor, secondColor))
            gd.cornerRadii = floatArrayOf(radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx, radiusPx)
            popupWindow.contentView.clean_ui_chat_popup_llMessageOptions?.background = gd
        }
    }
}