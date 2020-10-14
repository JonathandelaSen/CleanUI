package devjdelasen.com.cleanui.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import devjdelasen.com.cleanui.R
import kotlinx.android.synthetic.main.action_dialog.*


class ActionDialog(title: String? = null, subtitle: String?, buttonText: String? = null, dismissText: String? = null,
                   @ColorRes buttonColor: Int, @ColorRes buttonSecondaryColor: Int? = null,
                   gradientOrientation: GradientDrawable.Orientation = GradientDrawable.Orientation.TL_BR,
                   cancelable: Boolean = true,
                   context: Context) {

    private var dialog: Dialog? = null
    private var onButtonClickListener: View.OnClickListener? = null
    private var onDismissListener: View.OnClickListener? = null

    init {
        dialog = Dialog(context)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(R.layout.action_dialog)
        dialog?.setCancelable(cancelable)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        setData(title, subtitle, buttonText, dismissText, buttonColor, buttonSecondaryColor, gradientOrientation)
    }



    fun showDialog() {
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }

    fun setListeners(onButtonClickListener: View.OnClickListener, onDismissListener: View.OnClickListener? = null) {
        this.onButtonClickListener = onButtonClickListener
        this.onDismissListener = onDismissListener
        setClickListeners()
    }

    fun getTitle(): TextView {
        return dialog!!.clean_ui_tvTitle
    }

    fun getSubtitle(): TextView {
        return dialog!!.clean_ui_tvSubtitlet
    }

    fun getButton(): TextView {
        return dialog!!.clean_ui_tvButton
    }

    fun getDismissButton(): TextView {
        return dialog!!.clean_ui_tvDismiss
    }

    fun getRootLayout(): LinearLayout {
        return dialog!!.clean_ui_llRoot
    }



    private fun setData(title: String?, subtitle: String?, buttonText: String?, dismissText: String?,
                        @ColorRes buttonColor: Int, @ColorRes buttonSecondaryColor: Int?, gradientOrientation: GradientDrawable.Orientation) {
        setTitle(title)
        setDismiss(dismissText)
        setSubtitle(subtitle)
        setButton(buttonText, buttonColor, buttonSecondaryColor, gradientOrientation)
    }

    private fun setButton(buttonText: String?, @ColorRes buttonColor: Int, @ColorRes buttonSecondaryColor: Int?, gradientOrientation: GradientDrawable.Orientation) {
        if (!buttonText.isNullOrBlank()) {
            dialog?.clean_ui_tvButton?.visibility = View.VISIBLE
            dialog?.clean_ui_tvButton?.text = buttonText
            setButtonColor(buttonColor, buttonSecondaryColor, gradientOrientation)
        }
        else {
            dialog?.clean_ui_tvButton?.visibility = View.GONE
        }
    }

    private fun setSubtitle(subtitle: String?) {
        if (!subtitle.isNullOrBlank()) {
            dialog?.clean_ui_tvSubtitlet?.visibility = View.VISIBLE
            dialog?.clean_ui_tvSubtitlet?.text = subtitle
        }
        else {
            dialog?.clean_ui_tvSubtitlet?.visibility = View.GONE
        }
    }

    private fun setTitle(title: String?) {
        if (!title.isNullOrBlank()) {
            dialog?.clean_ui_tvTitle?.visibility = View.VISIBLE
            dialog?.clean_ui_tvTitle?.text = title
        }
        else {
            dialog?.clean_ui_tvTitle?.visibility = View.GONE
        }
    }

    private fun setDismiss(dismissText: String?) {
        if (!dismissText.isNullOrBlank()) {
            dialog?.clean_ui_tvDismiss?.visibility = View.VISIBLE
            dialog?.clean_ui_tvDismiss?.text = dismissText
        }
        else {
            dialog?.clean_ui_tvDismiss?.visibility = View.GONE
        }
    }

    private fun setButtonColor(@ColorRes buttonColor: Int, @ColorRes buttonSecondaryColor: Int?, gradientOrientation: GradientDrawable.Orientation) {
        dialog?.let {
            val firstColor = it.context.getColor(buttonColor)
            var secondColor = it.context.getColor(buttonColor)
            if (buttonSecondaryColor != null) {
                secondColor = it.context.getColor(buttonSecondaryColor)
            }
            val gd = GradientDrawable(gradientOrientation, intArrayOf(firstColor, secondColor))
            gd.cornerRadius = dialog?.context?.resources?.getDimensionPixelOffset(R.dimen.clean_ui_dialog_button_radius)?.let { radius ->
                radius.toFloat()
            } ?: run {
                16f
            }
            dialog?.clean_ui_tvButton?.background = gd
        }
    }


    private fun setClickListeners() {
        dialog?.clean_ui_tvButton?.setOnClickListener(onButtonClickListener)
        dialog?.clean_ui_tvDismiss?.setOnClickListener(onDismissListener)
    }



}