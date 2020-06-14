package km.project.localweather.model

import com.google.gson.annotations.SerializedName

class WeatherModel {
    var title = ""
    @SerializedName("location_type")
    var locationType = ""
    var woeid = 0.toLong()
    @SerializedName("latt_long")
    var lattLong = ""
}