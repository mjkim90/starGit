package km.project.localweather.api

import android.app.Activity
import com.google.gson.Gson
import io.reactivex.Observable
import km.project.localweather.R
import km.project.localweather.Util.AlertUtil
import km.project.localweather.api.bases.BaseErrorModel
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class RetrofitErrorHandler {
    /**
     * 공통 에러 처리
     */
    fun <T : BaseErrorModel> onHandleError(e: Throwable, entityClass: Class<T>): Observable<T> {
        val internalErrorResponseModel = when (e) {
            is HttpException -> {
                // Error Response
                e.response()?.let {
                    try {
                        val errorMessage = it.errorBody()?.string() ?: "{}"
                        return@let Gson().fromJson<T>(errorMessage, entityClass).apply {
                            isHttpException = true
                            statusCode = it.code()
                        }
                    } catch (parseError: Exception) {
                        return@let entityClass.newInstance().apply {
                            isParseError = true
                            message = e.message()
                            statusCode = 0
                        }
                    }
                } ?: entityClass.newInstance().apply {
                    isEmptyResponseBody = true
                    message = e.message()
                    statusCode = 0
                }
            }
            is SocketTimeoutException -> {
                entityClass.newInstance().apply {
                    isSocketTimeout = true
                    message = e.toString()
                    statusCode = 0
                }
            }
            is IOException -> {
                entityClass.newInstance().apply {
                    isNetworkError = true
                    message = e.toString()
                    statusCode = 0
                }
            }
            else -> {
                entityClass.newInstance().apply {
                    isUnknownError = true
                    message = e.toString()
                    statusCode = 0
                }
            }
        }

        return Observable.just(internalErrorResponseModel)
    }

    /**
     * 토큰 정보가 올바르지 않은 경우
     */
    private fun notAuthorized(activity: Activity) {
        AlertUtil.toast(activity, R.string.http_response_401)
    }

    /**
     * Status Code 에 따라서 오류 처리
     */
    fun handleStatusCode(activity: Activity, statusCode: Int, message: String?, notFoundErrorResId: Int = R.string.http_response_404) {
        when (statusCode) {
            400 -> when {
                message != null && message.isNotEmpty() -> AlertUtil.toast(activity, message)
                else -> AlertUtil.toast(activity, R.string.http_response_400)
            }
            401 -> notAuthorized(activity)
            404 -> {
                AlertUtil.toast(activity, notFoundErrorResId)
                activity.finish()
            }
            405 -> AlertUtil.toast(activity, R.string.http_response_405)
        }
    }

    private object Holder {
        val INSTANCE = RetrofitErrorHandler()
    }

    companion object {
        val instance: RetrofitErrorHandler by lazy { Holder.INSTANCE }
    }
}