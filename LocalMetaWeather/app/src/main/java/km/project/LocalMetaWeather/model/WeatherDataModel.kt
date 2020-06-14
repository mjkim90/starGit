package km.project.LocalMetaWeather.model

data class WeatherDataModel(
    val location: LocationModel,
    var todayWeather: WeatherModel?,
    var tomorrowWeather: WeatherModel?
)