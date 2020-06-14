package km.project.gsonproject.api.retofit.php


import io.reactivex.Observable
import km.project.gsonproject.api.retofit.php.APIConsts
import km.project.gsonproject.model.FCMResponse
import retrofit2.http.*

interface APIService {

    /**
     * FCM 토큰이 저장되었는지 확인 하기
     */
    @GET(APIConsts.FCM_URL)
    fun requestFCMTokenRegistration(@Query("registration_id") registrationId: String): Observable<FCMResponse>

}