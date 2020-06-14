package km.project.gsonproject.model

import com.google.gson.annotations.SerializedName

class FCMResponse {

    @SerializedName("create_date")
    var createDate = ""
    @SerializedName("is_accepted_marketing_push")
    var isAcceptedMarketingPush = 0
    @SerializedName("accept_marketing_push_date")
    var acceptMarketingPushDate = ""

    var fcmToken = ""

    val isAcceptedPush: Boolean
        get() {
            return isAcceptedMarketingPush == 1
        }
}