package racingcar.domain;

import racingcar.exception.RoundException;

public class Round {
    private int round;

    public Round(String round) {
        try {
            setRound(Integer.parseInt(round));
        } catch (NumberFormatException e) {
            throw new RoundException.NumberFormatException();
        }
    }

    private void setRound(int round) {
        isMoreThanOne(round);
        this.round = round;
    }

    private void isMoreThanOne(int round) {
        if (round <= 0) {
            throw new RoundException.InvalidRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    public void execute() {
        if (executable()) {
            round--;
            return;
        }
        throw new RoundException.ExceedExecutableNumberException();
    }

    public boolean executable() {
        return round > 0;
    }
}
