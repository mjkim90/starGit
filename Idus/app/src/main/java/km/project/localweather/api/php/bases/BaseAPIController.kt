package km.project.localweather.api.php.bases

import android.app.Activity
import android.content.Context
import androidx.multidex.BuildConfig
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import km.project.localweather.R
import km.project.localweather.Util.AlertUtil
import km.project.localweather.Util.DateDeserializer
import km.project.localweather.api.WLog
import km.project.localweather.api.php.APIService
import km.project.localweather.model.retrofit.ResponseFailedModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.*
import java.util.concurrent.TimeUnit

abstract class BaseAPIController {
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    /**
     * APIService 가져오기
     *
     * @return APIService
     */
    fun getService(isShowLog: Boolean = true): APIService {
        return getRetrofitWithGsonConverter(okHttpClient(isShowLog)).create(APIService::class.java)
    }

    /**
     * 로그를 찍기 위한 HttpLoggingInterceptor 를 가져온다.
     */
    private val httpLoggingInterceptor: HttpLoggingInterceptor
        get() {
            return HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

    /**
     * OkHttpClient 를 가져온다.
     */
    private fun okHttpClient(isShowLog: Boolean = true): OkHttpClient {
        val okHttpBuilder = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor {
                it.proceed(it.request().newBuilder().apply {
                    header(HEADER_AUTHORIZATION, "")
                }.build())
            }

        // 디버깅 모드에서만 Http 로그를 찍는다.
        if (BuildConfig.DEBUG || !BuildConfig.DEBUG && isShowLog) {
            okHttpBuilder.addInterceptor(httpLoggingInterceptor)
        }

        return okHttpBuilder.build()
    }

    /**
     * Gson Converter 를 사용하는 Retrofit 2 를 가져온다.
     *
     * @return Retrofit
     */
    private fun getRetrofitWithGsonConverter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseAPIConsts.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().registerTypeAdapter(Date::class.java, DateDeserializer()).create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    /**
     * 공통 에러 처리
     * Exception 처리는 아직 보류,
     *
     * @param e e
     * @return ResponseFailedModel
     */
//    fun onCommonError(e: Throwable, isUsingCodeCheck: Boolean = true): Observable<ResponseFailedModel> {
//        var isTypeJson = false
//        val model = ResponseFailedModel()
//        when (e) {
//            is HttpException -> {
//                // Error Response
//                e.response()?.let {
//                    val statusCode = it.code()
//                    var errorMessage = ""
//                    try {
//                        JSONObject(it.errorBody()?.string() ?: "{}").run {
//                            errorMessage = when {
//                                has("msg") -> getString("msg")
//                                has("message") -> getString("message")
//                                else -> e.toString()
//                            }
//                            isTypeJson = true
//                        }
//                    } catch (e1: JSONException) {
//                        e1.printStackTrace()
//                    } catch (e1: IOException) {
//                        e1.printStackTrace()
//                    }
//
//                    model.apply {
//                        message = errorMessage
//                        this.statusCode = statusCode
//                    }
//                } ?: run {
//                    model.apply {
//                        message = e.toString()
//                        this.statusCode = 0
//                    }
//                }
//            }
//            is SocketTimeoutException -> {
//                model.apply {
//                    message = e.toString()
//                    this.statusCode = 0
//                }
//            }
//            is IOException -> {
//                model.apply {
//                    message = e.toString()
//                    this.statusCode = 0
//                }
//            }
//            else -> {
//                model.apply {
//                    message = e.toString()
//                    this.statusCode = 0
//                }
//            }
//        }
//
//        if (isUsingCodeCheck) {
//            codeCheck(context, model.statusCode, if (isTypeJson) model.message else null)
//            WLog.i("ERROR", model.statusCode.toString() + "," + model.message)
//        }
//
//        return Observable.just(model)
//    }
//
//    private fun codeCheck(context: Context?, statusCode: Int, message: String?) {
//        context?.let {
//            when (statusCode) {
//                400 -> when {
//                    message != null && message.isNotEmpty() -> AlertUtil.toast(it, message)
//                    else -> AlertUtil.toast(it, R.string.http_response_400)
//                }
//                401 -> {
//                    notAuthorized(it)
//                }
//                404 -> {
//                    AlertUtil.toast(it, R.string.http_response_404)
//                    if (it is Activity) it.finish()
//                }
//                405 -> AlertUtil.toast(it, R.string.http_response_405)
//            }
//        }
//
//        AlertUtil.hideProgress()
//    }

    private fun notAuthorized(context: Context) {
        AlertUtil.toast(context, R.string.http_response_401)
    }

    companion object {
        private const val HEADER_AUTHORIZATION = "Authorization"
    }
}