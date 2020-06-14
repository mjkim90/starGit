package km.project.localweather.Util

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import km.project.localweather.R
import km.project.localweather.view.LoadingDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object AlertUtil {
    private var progressDialog: LoadingDialog? = null

    fun toast(context: Context, body: String?) {
        Toast.makeText(context, body, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.CENTER, 0, 0)
        }.show()
    }

    fun toast(context: Context, stringId: Int) {
        Toast.makeText(context, stringId, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.CENTER, 0, 0)
        }.show()
    }

    fun alert(activity: Activity, body: String, onClickListener: DialogInterface.OnClickListener? = null) {
        if (activity.isDestroyed) return

        var title = body
        val messageBuilder = StringBuilder()
        val splitBody = body.split("\n").toTypedArray()
        if (1 < splitBody.size) {
            title = splitBody[0]
            for (i in 1 until splitBody.size) {
                if (messageBuilder.isNotEmpty()) {
                    messageBuilder.append("\n")
                }
                messageBuilder.append(splitBody[i])
            }
        }

        AlertDialog.Builder(activity).apply {
            setTitle(title)
            if (messageBuilder.isNotEmpty()) {
                setMessage(messageBuilder.toString())
            }
            setPositiveButton(R.string.confirm, onClickListener)
        }.create().show()
    }

    fun showProgress(fragment: Fragment) {
        fragment.activity?.let {
            showProgress(it)
        }
    }

    fun showProgress(activity: Activity) {
        if (progressDialog == null) progressDialog = LoadingDialog(activity)
        if (activity.isFinishing) {
            immediatelyHideProgress()
            return
        }

        progressDialog?.show()
    }

    fun hideProgress() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(500)

            immediatelyHideProgress()
        }
    }

    fun immediatelyHideProgress() {
        progressDialog?.run {
            if (isShowing) {
                try {
                    dismiss()
                } catch (e: IllegalArgumentException) {
                    e.printStackTrace()
                }
            }
        }

        progressDialog = null
    }
}