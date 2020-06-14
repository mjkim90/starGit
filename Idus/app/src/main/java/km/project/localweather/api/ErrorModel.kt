package km.project.localweather.api

import km.project.localweather.api.bases.BaseErrorModel

class ErrorModel : BaseErrorModel() {
    val error = ResponseErrorModel()
}