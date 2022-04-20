package racingcar.domain;

import racingcar.error.Error;

public class Name {
    private String text;

    public Name(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
