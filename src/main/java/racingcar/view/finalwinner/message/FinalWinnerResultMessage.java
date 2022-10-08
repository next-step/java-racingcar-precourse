package racingcar.view.finalwinner.message;

public class FinalWinnerResultMessage extends FinalWinnerMessage {
    public FinalWinnerResultMessage(String value) {
        super(value);
    }

    @Override
    public String getValue() {
        return value;
    }
}
