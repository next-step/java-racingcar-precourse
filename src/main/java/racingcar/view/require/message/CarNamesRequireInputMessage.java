package racingcar.view.require.message;

public class CarNamesRequireInputMessage extends RequireMessage {
    public CarNamesRequireInputMessage() {
        super("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public String getValue() {
        return value;
    }
}
