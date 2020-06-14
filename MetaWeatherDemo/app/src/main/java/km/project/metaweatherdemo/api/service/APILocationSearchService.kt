package km.project.metaweatherdemo.api.service

import km.project.metaweatherdemo.model.LocationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APILocationSearchService {
    /**
     * 지역목록을 반환한다.
     */
    @GET("api/location/search")
    fun requestLocationSearch(@Query("query") cityName: String): Call<List<LocationModel>>
}