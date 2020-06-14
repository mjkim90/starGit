package km.project.localweather.api.php

import km.project.localweather.api.php.bases.BaseAPIController
import retrofit2.http.Query

class APIController : BaseAPIController() {

    private object Holder {
        val INSTANCE = APIController()
    }

    companion object {
        val instance: APIController by lazy { Holder.INSTANCE }
    }
}