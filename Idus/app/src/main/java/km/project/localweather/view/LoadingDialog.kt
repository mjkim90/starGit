package km.project.localweather.view

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import km.project.localweather.R
import kotlinx.android.synthetic.main.dialog_loading.*

class LoadingDialog(context: Context) : AlertDialog(context) {
    init {
        window?.run {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        setCancelable(false)
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)

        progress_loading.indeterminateDrawable?.run {
            val color = ContextCompat.getColor(context, R.color.pink_red)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
            } else {
                setColorFilter(color, PorterDuff.Mode.SRC_IN)
            }
        }
    }
}