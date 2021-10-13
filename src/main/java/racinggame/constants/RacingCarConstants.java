package racinggame.constants;

import java.util.regex.Pattern;

public final class RacingCarConstants {
    public static final int CAR_NAME_DIGIT = 5;
    public static final int CAR_MOVE_FORWARD = 4;
    public static final int MOVE_MIN_NUM = 0;
    public static final int MOVE_MAX_NUM = 9;

    public static final String CAR_MOVE_UNIT = "-";
    public static final String CAR_NAME_INPUT_DELIMETER = ",";

    private static final String userInputCarNameValidRegEx = "^[a-zA-Z0-9,]*"; // 자동차이름은 영문대소문자,숫자,쉼표까지만 허용
    private static final String userInputMoveTryValidRegEx = "^[1-9][0-9]*$"; // 자동차 이동 횟수는 0이상의 숫자만 허용
    public static final Pattern carNameInputPattern = Pattern.compile(RacingCarConstants.userInputCarNameValidRegEx);
    public static final Pattern carMoveTryInputPattern = Pattern.compile(RacingCarConstants.userInputMoveTryValidRegEx);

    private RacingCarConstants() { // 인스턴스화 방지
    }
}
