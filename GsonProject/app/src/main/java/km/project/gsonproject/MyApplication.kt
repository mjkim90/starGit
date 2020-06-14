package km.project.gsonproject

import android.app.Application
import android.os.Build
import android.webkit.WebView
import km.project.gsonproject.api.retofit.php.APIController
import km.project.gsonproject.architectures.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // API 컨트롤러에 사용할 Context 초기화
        APIController.instance.init(applicationContext)

        // 디버깅일떄 웹뷰 디버깅 할 수 있도록
        if (BuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(
                    module { viewModel { MainViewModel() } }
            ))
        }
    }
}