package io.roadstr.app.Utils

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class KeyboardUtils {


    companion object {


        fun showKeyboard(view: View, context: Context) {
            val keyboard: InputMethodManager? = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            keyboard?.showSoftInput(view, 0)
        }

        fun hideKeyboard(activity: Activity) {
            activity.window.currentFocus?.let {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }

        fun hideKeyboard(activity: FragmentActivity) {
            activity.window.currentFocus?.let {
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }

        fun hideKeyboard(fragment: Fragment) {
            fragment.activity?.let {
                hideKeyboard(it)
            }
        }

        fun hideKeyboard(view: View, context: Context) {
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0);
        }


        fun isKeyboardOpen(rootView: View): Boolean {
            val visibleBounds = Rect()
            rootView.getWindowVisibleDisplayFrame(visibleBounds)
            val heightDiff = rootView.rootView.height - (visibleBounds.bottom - visibleBounds.top)
            return heightDiff > rootView.rootView.height * 0.15
        }

        fun isKeyboardClosed(rootView: View): Boolean {
            return isKeyboardOpen(rootView)
        }
    }
}