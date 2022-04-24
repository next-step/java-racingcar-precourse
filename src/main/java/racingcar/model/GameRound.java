package racingcar.model;

public class GameRound {

    public int rounds;

    public GameRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException();
        }
        this.rounds = round;
    }

}
