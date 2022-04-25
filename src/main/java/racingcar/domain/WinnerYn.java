package racingcar.domain;

public class WinnerYn {
    boolean winner;

    public WinnerYn() {
        this.winner = false;
    }

    public void setWinner() {
        this.winner = true;
    }

    public boolean isWinner() {
        return winner;
    }
}
