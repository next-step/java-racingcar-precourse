package racingcar.view.error.message;

public class NumberOfRoundErrorMessage extends ErrorMessage {
    public NumberOfRoundErrorMessage() {
        super("[ERROR] 시도할 횟수를 다시 입력해주세요.");
    }

    @Override
    public String getValue() {
        return value;
    }
}
