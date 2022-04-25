package racingcar.constant;

public class MessageConst {
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇회인가요?";

    public static final String OUTPUT_RESULT = "실행 결과";
    public static final String OUTPUT_WINNERS = "최종 우승자: ";

    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String ERROR_DUPLICATE_NAME = "차 이름은 중복될 수 없습니다.";
    public static final String ERROR_NO_NUMERIC = "횟수는 숫자를 입력하세요.";
    public static final String ERROR_CAR_COUNT = NumberConst.MIN_CAR_COUNT + "대 이상의 차 이름을 입력하세요.";
    public static final String ERROR_CAR_NAME_LENGTH = "차 이름의 길이는 " + NumberConst.MAX_NAME_LENGTH + "자 이하로 입력하세요.";
}
