package km.project.localweather.api.php

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import km.project.localweather.model.WeatherModel

interface APIService {

    /**
     * 날씨 지역을 반환한다.
     */
//    @GET(APIConsts.BASE_URL)
//    fun requestWeahterLocationList(
//        @Query("query") query: String
//    ) : Observable<WeatherModel>
}