package devjdelasen.com.cleanui

import android.R
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import devjdelasen.com.cleanui.utils.Utils


class ShadowOverlay : View {


    private var rectToReplace: RectF? = null
    private var rectOverlay: RectF? = null
    private var paint: Paint? = null
    private var transparentPaint: Paint? = null

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }


    fun drawOverlay(view: View) {
        //rectToReplace = RectF(view.x, view.y, view.measuredWidth.toFloat(), view.measuredHeight.toFloat())
        val viewRect = Rect()
        view.getGlobalVisibleRect(viewRect)
        viewRect.top = viewRect.top - Utils.dpsToPxs(resources, 24f).toInt()
        viewRect.bottom = viewRect.bottom - Utils.dpsToPxs(resources, 24f).toInt()
        rectToReplace = RectF(viewRect)


        //rectToReplace = RectF(point[0].toFloat(), point[1].toFloat(), measuredWidth.toFloat(), measuredHeight.toFloat())
        rectOverlay = RectF(x, y, measuredWidth.toFloat(), measuredHeight.toFloat())
        paint = Paint()
        paint?.setARGB(128, 0, 0, 0)

        transparentPaint = Paint()
        transparentPaint?.color = resources.getColor(R.color.transparent)
        transparentPaint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (rectOverlay != null && paint != null) {
            canvas?.drawRect(rectToReplace!!, paint!!)
            //canvas?.clipRect(rectOverlay!!, Region.Op.DIFFERENCE)
        }
        /*
        canvas.draw


        if (null != mSelection) {
            if (null != mOverlay) {
                // If we have an overlay, paint it on top of the selected area.
                //  (This must be done BEFORE clipping the canvas or it won't show.)
                canvas.drawBitmap(mOverlay, null, mSelection, null);
            }
            // If we have a selection, darken its surroundings.
            canvas.clipRect(mSelection, Region.Op.DIFFERENCE);
            //noinspection ResourceAsColor
            canvas.drawColor(mColorRes);
        }*/

    }
}
