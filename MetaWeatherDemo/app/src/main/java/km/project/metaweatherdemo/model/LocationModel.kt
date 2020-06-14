package km.project.metaweatherdemo.model

import com.google.gson.annotations.SerializedName

class LocationModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("woeid")
    val woeid: Int
)