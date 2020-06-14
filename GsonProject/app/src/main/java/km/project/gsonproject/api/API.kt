package km.project.gsonproject.api

import km.project.gsonproject.BaseAPIConsts

/**
 * Created by rave_trip_05 on 2016-01-29.
 */
object API {
    // Danal Base Url
    private const val DANAL_BASE_URL = "${BaseAPIConsts.PHP_BASE_URL}/danal/"

    // Payment
    const val PAYMENT_TELEDIT_URL = "${DANAL_BASE_URL}teleditmobile/ready.php"
    const val PAYMENT_UPLUS = "${BaseAPIConsts.PAYMENT_BASE_URL}/paymethod_m/payreq_crossplatform"
    const val PAYMENT_TOSS = "${BaseAPIConsts.PAYMENT_BASE_URL}/toss/payRequest"
    const val PAYMENT_NAVERPAY = "${BaseAPIConsts.PAYMENT_BASE_URL}/naverPay/payRequest"
    const val PAYMENT_ADYEN = "${BaseAPIConsts.PAYMENT_BASE_URL}/adyen/"
}