package main.java.racingcar.domain;

import main.java.racingcar.message.ErrorMessage;

public class Position {

    private int amount;

    public Position(int amount){
        this.validate(amount);
        this.amount = amount;
    }

    public void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE);
        }
    }
}
