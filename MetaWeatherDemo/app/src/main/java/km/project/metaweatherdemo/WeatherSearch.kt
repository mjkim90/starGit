package km.project.metaweatherdemo

import km.project.metaweatherdemo.api.service.APILocationSearchService
import km.project.metaweatherdemo.api.service.APILocationSearchWeatherService
import km.project.metaweatherdemo.model.LocationModel
import km.project.metaweatherdemo.model.WeatherDataModel
import km.project.metaweatherdemo.model.WeatherInfoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherSearch {

    interface WeatherSearchListener {
        fun onSuccess(weatherDataList: List<WeatherDataModel>)
        fun onFailure(message: String?)
    }


    private var weatherDataList: ArrayList<WeatherDataModel>? = null
    private var listener: WeatherSearchListener? = null
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.metaweather.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun setResultListener(listener: WeatherSearchListener?) {
        this.listener = listener
    }

    fun searchWeatherInfo(keyword: String) {
        requestSearchLocation(keyword)
    }

    private fun requestSearchLocation(keyword: String) {
        val service = retrofit.create(APILocationSearchService::class.java)

        val serviceCall = service.requestLocationSearch(keyword)
        serviceCall.enqueue(object : Callback<List<LocationModel>> {
            override fun onFailure(call: Call<List<LocationModel>>, t: Throwable) {
                listener?.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<LocationModel>>,
                response: Response<List<LocationModel>>
            ) {
                if (!response.isSuccessful) {
                    listener?.onFailure("(" + response.code() + ") " + response.message())
                    return
                }

                response.body()?.let {
                    weatherDataList = ArrayList(it.size)

                    for (location in it) {
                        weatherDataList?.add(WeatherDataModel(location, null, null))

                        requestSearchWeather(retrofit, location)
                    }
                }
            }
        })
    }

    private fun requestSearchWeather(retrofit: Retrofit, location: LocationModel) {
        val service = retrofit.create(APILocationSearchWeatherService::class.java)

        val serviceCall = service.requestLocationWeather(location.woeid)
        serviceCall.enqueue(object : Callback<WeatherInfoModel> {
            override fun onFailure(call: Call<WeatherInfoModel>, t: Throwable) {
                listener?.onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<WeatherInfoModel>,
                response: Response<WeatherInfoModel>
            ) {
                if (!response.isSuccessful) {
                    listener?.onFailure("(" + response.code() + ") " + response.message())
                    return
                }

                response.body()?.let {
                    setWeatherInfo(it)

                    if (isAllSearched()) {
                        listener?.onSuccess(weatherDataList!!)
                    }
                }
            }
        })
    }

    private fun setWeatherInfo(weatherInfo: WeatherInfoModel) {
        weatherDataList ?: return

        for (weatherData in weatherDataList!!) {
            if (weatherData.location.woeid == weatherInfo.woeid) {
                weatherData.todayWeather = weatherInfo.weatherList[0]
                weatherData.tomorrowWeather = weatherInfo.weatherList[1]
            }
        }
    }

    private fun isAllSearched(): Boolean {
        weatherDataList ?: return false

        for (weatherData in weatherDataList!!) {
            if (weatherData.todayWeather == null) {
                return false
            }
        }

        return true
    }
}