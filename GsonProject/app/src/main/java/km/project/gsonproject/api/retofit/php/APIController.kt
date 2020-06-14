package km.project.gsonproject.api.retofit.php

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import km.project.gsonproject.api.retofit.php.bases.BaseAPIController
import kr.co.waug.waug.model.*
import kr.co.waug.waug.model.renew.CartModel
import kr.co.waug.waug.model.renew.EventModel
import kr.co.waug.waug.model.renew.OrderByCartModel
import kr.co.waug.waug.model.renew.auth.LoginSuccessModel
import kr.co.waug.waug.model.renew.auth.find.FindPasswordModel
import kr.co.waug.waug.model.renew.credits.CreditsModel
import kr.co.waug.waug.model.renew.main.WaugDayModel
import kr.co.waug.waug.model.renew.mypage.AccountModel
import kr.co.waug.waug.model.renew.orders.details.OrderDetailModel
import kr.co.waug.waug.model.renew.orders.forms.OrderFormDataModel
import kr.co.waug.waug.model.renew.reserve.ReserveOptionModel
import kr.co.waug.waug.model.renew.response.*
import kr.co.waug.waug.model.renew.tickets.TicketDetailModel
import kr.co.waug.waug.model.renew.voucher.NewVoucherModel
import kr.co.waug.waug.model.renew.voucher.WaugVoucherModel

class APIController : BaseAPIController() {

    /**
     * FCM 토큰이 저장되었는지 확인 하기
     */
    fun requestFCMTokenRegistration(registrationId: String): Observable<FCMResponse> {
        return getService().requestFCMTokenRegistration(registrationId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 서버에 FCM 토큰 등록하기
     */
    fun requestRegistFCMToken(registrationId: String, isAcceptedMarketingPush: Boolean? = null): Observable<FCMResponse> {
        return getService().requestRegistFCMToken(registrationId, isAcceptedMarketingPush)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 서버 상태 요청하기
     */
    fun requestAppVersion(): Observable<AppVersionModel> {
        return getService(false).requestAppVersion()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 전면 공지 사항 요청하기
     */
    fun requestWaugDay(): Observable<WaugDayModel> {
        return getService().requestWaugDay()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 이용약관 가져오기
     */
    fun requestTerms(): Observable<String> {
        return getService().requestTerms()
                .map { it.get("contents").asString }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 개인정보취급방침 가져오기
     */
    fun requestPrivacy(): Observable<String> {
        return getService().requestPrivacy()
                .map { it.get("contents").asString }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 이벤트 정보 가져오기
     */
    fun requestEvent(bannerIdx: Int): Observable<EventModel> {
        return getService().requestEvent(bannerIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 주문 입력 필드 정보 가져오기
     */
    fun requestOrderFormData(orderNum: String): Observable<ArrayList<OrderFormDataModel>> {
        return getService().requestOrderFormData(orderNum)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 주문 입력 필드 정보 보내기
     */
    fun postOrderFormData(map: HashMap<String, Any>): Observable<Any> {
        return getService().postOrderFormData(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 주문 상세 정보 가져오기
     */
    fun requestOrderDetail(orderNum: String): Observable<OrderDetailModel> {
        return getService().requestOrderDetail(orderNum)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 주문 성공 여부 체크하기
     */
    fun requestToCheckOrder(orderNum: String): Observable<OrderSuccessResponse> {
        return getService().requestToCheckOrder(orderNum)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 쿠폰 목록 가져오기
     */
    fun requestOrderCouponList(usable: Int, orderNum: String, isAvailable: Boolean): Observable<OrderCouponResponse> {
        return getService().requestOrderCouponList(usable, orderNum, isAvailable)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 쿠폰 적용하기
     */
    fun requestToAdaptCoupon(couponIdx: Int, couponCode: String, orderNum: String): Observable<AdaptCouponResponse> {
        return getService().requestToAdaptCoupon(couponIdx, couponCode, orderNum)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 바로 결제 하기
     */
    fun requestPaymentDirect(orderNum: String, usePoint: Double, couponCode: String?): Observable<Any> {
        return getService().requestPaymentDirect(orderNum, usePoint, couponCode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Credits 정보 가져오기
     */
    fun requestCredits(): Observable<CreditsModel> {
        return getService().requestCredits()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  바우처 리스트 가져오기
     */
    fun requestVoucherList(mode: String, page: Int): Observable<ArrayList<NewVoucherModel>> {
        return getService().requestVoucherList(mode, page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 내 정보 가져오기
     */
    fun requestAccountInfo(isShowLog: Boolean = true): Observable<AccountModel> {
        return getService(isShowLog).requestAccountInfo()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 장바구니 정보 요청하기
     */
    fun requestCart(page: Int): Observable<ArrayList<CartModel>> {
        return getService().requestCart(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 장바구니 상품 주문하기
     */
    fun requestOrderByCart(cartIdx: String): Observable<OrderByCartModel> {
        return getService().requestOrderByCart(cartIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 선택된 장바구니 아이템 지우기
     */
    fun deleteCheckedCartItem(cartIdx: String): Observable<Any> {
        return getService().deleteCheckedCartItem(cartIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 유저의 포인트 목록을 가져온다.
     */
    fun requestPointList(page: Int): Observable<ArrayList<PointModel>> {
        return getService().requestPointList(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 유저의 쿠폰 목록을 가져온다.
     */
    fun requestCouponList(usable: Boolean): Observable<CouponListResponse> {
        return getService().requestCouponList(if (usable) 1 else 0)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * Waug Voucher 정보를 가져온다.
     */
    fun requestWaugVoucher(ticketIdx: Int): Observable<ArrayList<WaugVoucherModel>> {
        return getService().requestWaugVoucher(ticketIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 티켓 정보를 가져온다.
     */
    fun requestTicketInfo(ticketIdx: Int): Observable<TicketDetailModel> {
        return getService().requestTicketInfo(ticketIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 티켓 취소하기
     */
    fun requestToCancelTicket(goodIdx: Int, orderNum: String, orderGoodIdx: Int): Observable<Any> {
        return getService().requestToCancelTicket(goodIdx, orderNum, orderGoodIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * FAQ 목록 요청하기
     */
    fun requestFAQ(faqTypeIdx: Int): Observable<ArrayList<FaqModel>> {
        return getService().requestFAQ(faqTypeIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * FAQ 타입 목록 요청하기
     */
    fun requestFAQType(): Observable<ArrayList<FaqTypeModel>> {
        return getService().requestFAQType()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * FAQ 검색하기
     */
    fun requestFAQSearch(keyword: String): Observable<ArrayList<FaqModel>> {
        return getService().requestFAQSearch(keyword)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 모바일 바우쳐 정보 가져오기
     */
    fun requestMobileVoucher(orderNum: String, goodIdx: Int, orderGoodIdx: Int): Observable<VoucherDetailResponse> {
        return getService().requestMobileVoucher(orderNum, goodIdx, orderGoodIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 상품 예약 정보 가져오기
     */
    fun requestReserveInfo(goodIdx: Int): Observable<ReserveModel> {
        return getService().requestReserveInfo(goodIdx)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 상품 옵션 정보 가져오기
     */
    fun requestReserveOptionInfo(goodIdx: Int, startDate: String, getOptPerDay: Int): Observable<ArrayList<ReserveOptionModel>> {
        return getService().requestReserveOptionInfo(goodIdx, startDate, getOptPerDay)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 장바구니에 추가하기
     */
    fun addToCart(map: HashMap<String, Any>): Observable<Any> {
        return getService().addToCart(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 주문 번호 요청하기
     */
    fun requestToReserve(map: HashMap<String, Any>): Observable<String> {
        return getService().requestToReserve(map)
                .map {
                    it.get("order_num").asString
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 로그인 요청하기
     */

    fun requestSelectLogin(memId: String, memPwd: String): Observable<LoginSuccessModel> {

        return getService().requestSelectLogin(memId, memPwd)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * SNS 로그인 요청하기
     */
    fun requestSignInBySNS(type: String, accessToken: String): Observable<LoginSuccessModel> {
        return getService().requestSignInBySNS(type, accessToken)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * 이메일을 통한 통한 이메일 정보동의 요청하기
     */
    fun requestEmailLoginInsert(memId: String, memPwd: String, memMail: String, Name: String, mailOk: String): Observable<Any> {
        return getService().requestEmailInsert(memId, memPwd, memMail, Name, mailOk)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * SNS용 이메일 입력을 통한 이메일 정보동의 요청하기
     */
    fun requestSNSEmailLoginInsert(type: String, socialToken: String, memMail: String, name: String, mailOk: String): Observable<Any> {
        return getService().requestSNSEmailInsert(type, socialToken, memMail, name, mailOk)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * SNS 이메일 입력후 최종 로그인 요청하기
     */
    fun requestSNSEmailInsertByWaug(type: String, accessToken: String): Observable<LoginSuccessModel> {
        return getService().requestSNSEmailInsertByWaug(type, accessToken)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }


///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 이메일을 통한 회원가입 요청하기
     */
    fun requestSignUp(memId: String, memPwd: String, Name: String, mailOk: String): Observable<LoginSuccessModel> {
        return getService().requestSignUp(memId, memPwd, Name, mailOk)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * SNS를통한 회원가입 요청하기
     */
    fun requestSignUpSNS(type: String, accessToken: String, memMail: String, name: String, mailOk: String): Observable<LoginSuccessModel> {
        return getService().requestSignUpSNS(type, accessToken, memMail, name, mailOk)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 이메일을 통한 비밀번호 재인증 하기
     */
    fun requestFindPassword(memId: String): Observable<FindPasswordModel> {

        return getService().requestFindPassword(memId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * SNS 휴면계정 재인증하기
     */
    fun requestDormantSnsWaug(type: String, accessToken: String): Observable<LoginSuccessModel> {
        return getService().requestDormantSnsWaug(type, accessToken,"N")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    private object Holder {
        val INSTANCE = APIController()
    }

    companion object {
        val instance: APIController by lazy { Holder.INSTANCE }
    }
}