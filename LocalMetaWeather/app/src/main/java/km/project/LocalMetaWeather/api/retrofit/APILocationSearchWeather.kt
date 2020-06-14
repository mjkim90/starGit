package km.project.LocalMetaWeather.api.retrofit

import km.project.LocalMetaWeather.model.WeatherInfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APILocationSearchWeather {
    /**
     * 지역별 날씨정보를 반환한다.
     */
    @GET("api/location/{woeid}")
    fun requestLocationWeather(@Path("woeid") woeid: Int): Call<WeatherInfoModel>
}