package km.project.metaweatherdemo.model

import com.google.gson.annotations.SerializedName

class WeatherInfoModel(
    @SerializedName("consolidated_weather")
    val weatherList: List<WeatherModel>,
    @SerializedName("woeid")
    val woeid: Int
)