package racingcar.domain;

import racingcar.exception.RoundInvalidRangeException;
import racingcar.exception.RoundNumberFormatException;

public class Round {
    private int round;

    public Round(String round) {
        try {
            setRound(Integer.parseInt(round));
        } catch (NumberFormatException e) {
            throw new RoundNumberFormatException();
        }
    }

    private void setRound(int round) {
        isMoreThanOne(round);
        this.round = round;
    }

    private void isMoreThanOne(int round) {
        if (round <= 0) {
            throw new RoundInvalidRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }
}
