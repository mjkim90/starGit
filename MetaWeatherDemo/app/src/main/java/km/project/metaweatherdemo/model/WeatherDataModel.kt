package km.project.metaweatherdemo.model

class WeatherDataModel(
    val location: LocationModel,
    var todayWeather: WeatherModel?,
    var tomorrowWeather: WeatherModel?
)