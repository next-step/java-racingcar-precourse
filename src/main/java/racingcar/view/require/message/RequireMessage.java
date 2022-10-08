package racingcar.view.require.message;

import racingcar.view.Message;

public abstract class RequireMessage implements Message {
    protected String value;

    protected RequireMessage(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
