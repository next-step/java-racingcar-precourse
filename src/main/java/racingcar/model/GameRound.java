package racingcar.model;

public class GameRound {

    private int round;

    public GameRound(int round) {
        this.round = round;
    }

    public boolean isEnd() {
        if (this.round > 0) {
            return false;
        }

        return true;
    }

    public void reduceRound() {
        this.round--;
    }

}
