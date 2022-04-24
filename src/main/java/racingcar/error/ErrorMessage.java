package racingcar.error;

public enum ErrorMessage {
    CarNameBussinessError("이름은 5자 이하만 가능합니다."),
    RaceCountBussinessError("시도 횟수는 숫자여야합니다.");

    private final String errorMsg;

    ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return "[ERROR] " + errorMsg;
    }
}
