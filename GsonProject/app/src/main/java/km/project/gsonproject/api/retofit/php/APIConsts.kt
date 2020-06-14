package km.project.gsonproject.api.retofit.php

import km.project.gsonproject.BaseAPIConsts

object APIConsts {
    // Version 3
    private const val V3_BASE_URL = "/v3/"

    // V3 PHP Base Url
    private const val V3_PHP_BASE_URL = "${BaseAPIConsts.PHP_BASE_URL}/v3/"

    // Push
    const val FCM_URL = "${V3_BASE_URL}fcm/"                    // FCM 푸시 토큰 등록

    // App Version Check
    const val APP_VERSION_URL = "${V3_BASE_URL}app-version/"     // 서버 상태

    // Notice
    const val WAUGDAY_URL = "${V3_BASE_URL}notice/"

    const val TERMS_URL = "${V3_BASE_URL}terms/"
    const val PRIVACY_URL = "${V3_BASE_URL}privacy/"

    // Event
    const val EVENT_URL = "${V3_BASE_URL}event/"

    // Order
    private const val ORDER_URL = "${V3_BASE_URL}order/"
    const val ORDER_2_1_URL = "${ORDER_URL}2.1/"
    private const val ORDER_SUCCESS_URL = "${ORDER_URL}success/"
    const val ORDER_SUCCESS_NEW_URL = "${ORDER_SUCCESS_URL}new/"
    private const val ORDER_INFO_URL = "${ORDER_URL}info/"
    const val ORDER_INFO_2_URL = "${ORDER_INFO_URL}2.0/"

    //Coupon
    private const val ORDER_COUPON_URL = "${ORDER_URL}coupon/"
    const val ORDER_COUPON_2_URL = "${ORDER_COUPON_URL}2.0/"

    // Creadits
    const val CREDITS_URL = "${V3_BASE_URL}credits/"

    // My Page
    private const val MYPAGE_URL = "${V3_BASE_URL}mypage/"
    const val MYPAGE_INFO_URL = "${MYPAGE_URL}new/"
    private const val MYPAGE_ORDER_URL = "${MYPAGE_URL}order/"
    const val MYPAGE_ORDER_NEW_URL = "${MYPAGE_ORDER_URL}new/"
    private const val MYPAGE_COUPON_URL = "${MYPAGE_URL}coupon/"
    const val MYPAGE_COUPON_2_URL = "${MYPAGE_COUPON_URL}2.0/"
    private const val MYPAGE_CART_URL = "${MYPAGE_URL}cart/"
    const val MYPAGE_CART_NEW_URL = "${MYPAGE_CART_URL}new/"
    const val MYPAGE_CART_DELETE_URL = "${MYPAGE_CART_URL}delete/"
    const val MYPAGE_POINT_URL = "${MYPAGE_URL}point/"
    private const val MYPAGE_TICKET_URL = "${MYPAGE_URL}ticket/"
    const val MYPAGE_TICKET_VOUCHER_URL = "${MYPAGE_TICKET_URL}voucher/"
    const val MYPAGE_TICKET_2_URL = "${MYPAGE_TICKET_URL}2.0/"
    const val MYPAGE_TICKET_CANCEL_URL = "${MYPAGE_TICKET_URL}cancel/"
    const val MYPAGE_FAQ_URL = "${MYPAGE_URL}faq/"
    const val MYPAGE_FAQ_TYPE_URL = "${MYPAGE_FAQ_URL}type/"
    const val MYPAGE_FAQ_SEARCH_URL = "${MYPAGE_FAQ_URL}search/"

    // Voucher
    const val VOUCHER_URL = "${V3_BASE_URL}voucher/"

    // Cart
    private const val CART_URL = "${V3_BASE_URL}cart/"
    const val CART_NEW_URL = "${CART_URL}new/"

    // Reserve
    private const val RESERVE_URL = "${V3_BASE_URL}reserve/"
    const val RESERVE_NEW_URL = "${RESERVE_URL}new/"
    private const val RESERVE_OPTION_URL = "${RESERVE_URL}option/"
    const val RESERVE_OPTION_NEW_URL = "${RESERVE_OPTION_URL}new/"

    // Login Page
    const val LOGIN_URL = "${V3_BASE_URL}login/"
    const val LOGIN_EMAIL_INSERT_URL = "${LOGIN_URL}email/"

    // SNS Login
    private const val SNS_LOGIN_URL = "${V3_PHP_BASE_URL}login/"
    const val LOGIN_SNS_URL = "$SNS_LOGIN_URL{type}/"
    const val LOGIN_SNS_EMAIL_INSERT_URL = "${LOGIN_SNS_URL}email/"

    // Join
    const val JOIN_URL = "${V3_BASE_URL}join/"

    // Email Password Find
    const val FIND_PASSWORD_URL = "${V3_BASE_URL}find/"

    // Danal
    private const val DANAL_URL = "/danal/"

    // Payment
    const val PAYMENT_DIRECT_URL = "${DANAL_URL}direct/"
}