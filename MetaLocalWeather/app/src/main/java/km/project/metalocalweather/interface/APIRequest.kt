package km.project.metalocalweather.`interface`

import io.reactivex.Single
import km.project.metalocalweather.model.data.view.LocationResponse
import km.project.metalocalweather.model.data.view.LocationSearchResponse
import km.project.metalocalweather.util.LOCATION_API
import km.project.metalocalweather.util.LOCATION_SEARCH_API
import km.project.metalocalweather.util.QUERY
import km.project.metalocalweather.util.WOE_ID
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIRequest {

    @GET(LOCATION_SEARCH_API)
    fun getLocationSearch(@Query(QUERY) searchText: String): Single<List<LocationSearchResponse>>

    @GET(LOCATION_API)
    fun getLocation(@Path(WOE_ID) woeId: Int): Single<LocationResponse>
}