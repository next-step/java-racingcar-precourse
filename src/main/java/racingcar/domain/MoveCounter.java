package racingcar.domain;

public class MoveCounter {

    private final int moveCount;

    public MoveCounter(final int moveCount) {
        this.moveCount = moveCount;
    }

    public void forEach(final Runnable race) {
        for (int count = 0; count < moveCount; ++count) {
            race.run();
        }
    }
}
