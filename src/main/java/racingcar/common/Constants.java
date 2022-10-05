package racingcar.common;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String PROGRESS_PARTICLE = "-";
    public static final String FINAL_WINNER="최종 우승자 : ";

    public static final String COMMON_ERROR_HEADER = "[ERROR] ";
    public static final String ERROR_TRIAL_INPUT = "시도 횟수는 숫자여야 한다.";
    public static final String ERROR_TRIAL_RANGE_OVER = "시도 횟수는 양수여야 한다.";
    public static final String ERROR_CAR_NAME_SIZE_OVER = "은(는) 이름이 너무 깁니다.";
    public static final String ERROR_CAR_DUPLICATE = "은(는) 중복입니다.";
    public static final String ERROR_INITIALIZE_DUPLICATE = "세터를 통한 중복 초기화는 불가능합니다.";
}
