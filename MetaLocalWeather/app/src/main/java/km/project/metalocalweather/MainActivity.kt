package km.project.metalocalweather;

import android.annotation.SuppressLint
import android.os.Bundle;
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import km.project.metalocalweather.databinding.ActivityMainBinding
import km.project.metalocalweather.model.data.view.MainViewModel
import km.project.metalocalweather.model.data.view.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResouceId: Int
        get() = R.layout.activity_main

    private val mainViewModelFactory: MainViewModelFactory by inject()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        // LiveData observe
        mainViewModel.networkError.observe(this, Observer {
            networkErrorToast(it)
        })
        mainViewModel.showProgress.observe(this, Observer {
            if (it) {
                progressBar.show()
            } else {
                progressBar.hide()
            }
        })
        mainViewModel.addDisposable(
                RxSwipeRefreshLayout.refreshes(swRefresh)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            mainViewModel.reqLocationSearch(false)
                        }
        )
        viewBinding.mainViewModel = mainViewModel
        viewBinding.lifecycleOwner = this
    }
}
