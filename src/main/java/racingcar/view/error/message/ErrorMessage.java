package racingcar.view.error.message;

import racingcar.view.Message;

public abstract class ErrorMessage implements Message {
    protected String value;

    protected ErrorMessage(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
