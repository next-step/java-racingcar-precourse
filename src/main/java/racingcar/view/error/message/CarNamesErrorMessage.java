package racingcar.view.error.message;

public class CarNamesErrorMessage extends ErrorMessage {
    public CarNamesErrorMessage() {
        super("[ERROR] 자동차 이름을 다시 입력해주세요.");
    }

    @Override
    public String getValue() {
        return value;
    }
}
