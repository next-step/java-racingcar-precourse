package racingcar.view.finalwinner.message;

import racingcar.view.Message;

public abstract class FinalWinnerMessage implements Message {
    protected final String value;

    protected FinalWinnerMessage(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
