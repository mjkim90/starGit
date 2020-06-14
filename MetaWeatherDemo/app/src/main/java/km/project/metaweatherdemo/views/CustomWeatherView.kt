package km.project.metaweatherdemo.views

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import km.project.metaweatherdemo.R
import km.project.metaweatherdemo.model.WeatherModel
import kotlinx.android.synthetic.main.view_weather.view.*

class CustomWeatherView : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        LayoutInflater.from(context).inflate(R.layout.view_weather, this, true)
    }

    /**
     * 날씨 정보 set
     */
    fun setWeather(weather: WeatherModel?) {
        weather ?: return

        Glide.with(this).load(Uri.parse("https://www.metaweather.com/static/img/weather/png/${weather.stateAbbr}.png"))
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
            .into(img_weather)
        txt_weather.text = weather.stateName
        txt_temp.text = weather.temp.toInt().toString()
        txt_humidity.text = weather.humidity.toString()
    }
}