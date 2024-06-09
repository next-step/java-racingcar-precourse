package main.java.racingcar.domain;

import main.java.racingcar.message.ErrorMessage;

public record TrialCount(int count) {
    public TrialCount {
        this.validate(count);
    }
    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE);
        }
    }

    public boolean isMoreThan(int count) {
        return this.count > count;
    }
}
