package racinggame.common;

public class Constant {
    //View
    public static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String PLAY_RESULT = "실행결과";
    public static final String GO_STATUS = "-";

    //Random Range
    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 0;
    public static final int STANDARD = 4;
    //Name
    public static final int MAX_NAME_LEN = 5;
    public static final int MIN_CAR_NUM = 2;
    public static final String NAME_REGEX = ",";

    //ERROR
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERR_CAR_MIN_NUM = "자동차는 최소 " + MIN_CAR_NUM +"대 이상이어야 합니다.";
    public static final String ERR_TRY_NO = "시도 횟수는 0이상의 양수여야 합니다.";
    public static final String ERR_CAR_NAME_LEN= "자동차의 이름은 " + MAX_NAME_LEN + "자 이하여야 합니다.";

    //Result
    public static final String FINAL_WINNER = "최종 우승자는 %s 입니다.";
}
