package km.project.gsonproject

open class BaseErrorModel {
    var message = ""
    var statusCode = 0

    var isHttpException = false
    var isParseError = false
    var isEmptyResponseBody = false
    var isSocketTimeout = false
    var isNetworkError = false
    var isUnknownError = false
}