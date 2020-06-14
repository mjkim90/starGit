package km.project.metalocalweather

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import java.io.IOException

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(){
    protected lateinit var viewBinding : T
    protected abstract val layoutResouceId : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,layoutResouceId)
    }

    /**
     * 네트워크 에러발생 Toast 메세지
     */
    protected fun networkErrorToast(throwable: Throwable) {
        when (throwable) {
            is IOException -> Toast.makeText(this, getString(R.string.network_error_msg), Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
        }
    }
}