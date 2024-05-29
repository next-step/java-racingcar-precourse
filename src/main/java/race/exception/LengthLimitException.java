package race.exception;

public class LengthLimitException extends IllegalArgumentException {

    public LengthLimitException() {
        super("[ERROR] 입력한 자동차의 이름의 길이가 제한된 길이보다 깁니다");
    }
}
