package io.roadstr.app.Utils

import android.R
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import java.util.HashMap;
/**
 * Based on the following Stackoverflow answer:
 * http://stackoverflow.com/questions/2150078/how-to-check-visibility-of-software-keyboard-in-android
 */
class KeyboardEventListener private constructor(act: Activity, private var mCallback: SoftKeyboardToggleListener?) :
    ViewTreeObserver.OnGlobalLayoutListener {

    private val mRootView: View
    private var prevValue: Boolean? = null
    private val mScreenDensity: Float

    interface SoftKeyboardToggleListener {
        fun onToggleSoftKeyboard(isVisible: Boolean)
    }



    companion object {
        private const val MAGIC_NUMBER = 200
        private val sListenerMap: HashMap<SoftKeyboardToggleListener?, KeyboardEventListener> = HashMap()

        /**
         * Add a new keyboard listener
         * @param activity calling activity
         * @param listener callback
         */
        fun addKeyboardToggleListener(activity: Activity, listener: SoftKeyboardToggleListener?) {
            removeKeyboardToggleListener(listener)
            sListenerMap[listener] = KeyboardEventListener(activity, listener)
        }

        /**
         * Remove a registered listener
         * @param listener [SoftKeyboardToggleListener]
         */
        fun removeKeyboardToggleListener(listener: SoftKeyboardToggleListener?) {
            if (sListenerMap.containsKey(listener)) {
                val k = sListenerMap[listener]
                k?.removeListener()
                sListenerMap.remove(listener)
            }
        }

        /**
         * Remove all registered keyboard listeners
         */
        fun removeAllKeyboardToggleListeners() {
            for (l in sListenerMap.keys) {
                sListenerMap[l]?.removeListener()
                sListenerMap.clear()
            }
        }

        /**
         * Manually toggle soft keyboard visibility
         * @param context calling context
         */
        fun toggleKeyboardVisibility(context: Context) {
            (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        /**
         * Force closes the soft keyboard
         * @param activeView the view with the keyboard focus
         */
        fun forceCloseKeyboard(activeView: View) {
            (activeView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.
            hideSoftInputFromWindow(activeView.windowToken, 0)
        }
    }

    init {
        mRootView = (act.findViewById<View>(R.id.content) as ViewGroup).getChildAt(0)
        mRootView.viewTreeObserver.addOnGlobalLayoutListener(this)
        mScreenDensity = act.resources.displayMetrics.density
    }




    override fun onGlobalLayout() {
        val r = Rect()
        mRootView.getWindowVisibleDisplayFrame(r)
        val heightDiff: Int = mRootView.rootView.height - (r.bottom - r.top)
        val dp = heightDiff / mScreenDensity
        val isVisible = dp > MAGIC_NUMBER
        if (mCallback != null && (prevValue == null || isVisible != prevValue)) {
            prevValue = isVisible
            mCallback!!.onToggleSoftKeyboard(isVisible)
        }
    }

    private fun removeListener() {
        mCallback = null
        mRootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
    }

}