package km.project.localweather

import android.app.Application
import km.project.localweather.api.php.APIController

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        APIController.instance.init(this)
    }
}