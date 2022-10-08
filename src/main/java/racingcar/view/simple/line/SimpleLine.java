package racingcar.view.simple.line;

import racingcar.view.Message;

public abstract class SimpleLine implements Message {
    protected String value;

    public SimpleLine(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
