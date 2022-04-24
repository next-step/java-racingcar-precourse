package racingcar.model;

public enum GameStatus {
    INIT, START, END;

    public boolean isEndGame() {
        return this == END;
    }
}
