package km.project.metaweatherdemo.util

import android.content.Context
import android.util.TypedValue

class Util {

    /**
     * DP를 pixel로 환산
     */
    fun dpToPixel(context: Context, dp: Float): Float {
        val r = context.resources
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.displayMetrics)
    }

    private object Holder {
        val INSTANCE = Util()
    }

    companion object {
        val instance: Util by lazy { Holder.INSTANCE }
    }

}