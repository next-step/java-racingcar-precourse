package racingcar.model;

public enum GameStatus {
    INIT, START, END;

    public boolean isInit(){
        return this == INIT;
    }

    public boolean isStart(){
        return this == START;
    }

    public boolean isEndGame() {
        return this == END;
    }
}
