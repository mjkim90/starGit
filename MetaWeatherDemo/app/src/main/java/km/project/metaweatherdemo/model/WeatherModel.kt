package km.project.metaweatherdemo.model

import com.google.gson.annotations.SerializedName

class WeatherModel(
    @SerializedName("weather_state_name")
    val stateName: String,
    @SerializedName("weather_state_abbr")
    val stateAbbr: String,
    @SerializedName("the_temp")
    val temp: Float,
    @SerializedName("humidity")
    val humidity: Int
)