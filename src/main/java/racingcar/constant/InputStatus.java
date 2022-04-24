package racingcar.constant;

public enum InputStatus {

    INPUT_IN_PROGRESS(0, "입력 중"),
    INPUT_END(1, "입력 종료");

    private final int code;
    private final String description;

    InputStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean isContinue() {
        return code == 0;
    }

}
