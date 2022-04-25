package racingcar.domain.result;

public enum GoOrStop {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }

    public boolean isStop() {
        return this != STOP;
    }
}
