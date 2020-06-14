package km.project.metaweatherdemo.api.service

import km.project.metaweatherdemo.model.WeatherInfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APILocationSearchWeatherService {
    /**
     * 지역별 날씨정보를 반환한다.
     */
    @GET("api/location/{woeid}")
    fun requestLocationWeather(@Path("woeid") woeid: Int): Call<WeatherInfoModel>
}