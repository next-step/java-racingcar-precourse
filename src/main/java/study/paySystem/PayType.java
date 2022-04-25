package study.paySystem;

public class PayType {
    static final String NAVER_PAY = "NAVER_PAY";
    static final String KAKAO_PAY = "KAKAO_PAY";
    static final String TOSS = "TOSS";

    public static boolean isNaverPay(String payType) {
        return payType == NAVER_PAY;
    }

    public static boolean isKakaoPay(String payType) {
        return payType == KAKAO_PAY;
    }
}
