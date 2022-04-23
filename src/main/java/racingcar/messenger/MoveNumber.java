package racingcar.messenger;

public enum MoveNumber {

    MIN(0),
    MAX(9);

    final int number;

    MoveNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
