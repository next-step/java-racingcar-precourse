package racingcar.view.require.message;

public class NumberOfRoundRequireInputMessage extends RequireMessage {
    public NumberOfRoundRequireInputMessage() {
        super("시도할 횟수는 몇회인가요?");
    }

    @Override
    public String getValue() {
        return value;
    }
}
