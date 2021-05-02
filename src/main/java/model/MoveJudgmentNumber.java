package model;

public class MoveJudgmentNumber {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int CRITERIA = 4;

    private final int number;

    public MoveJudgmentNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("자동차가 이동할 거리는 0 ~ 9 범위만 가능합니다.");
        }
        this.number = number;
    }

    public boolean canMoving() {
        return this.number >= CRITERIA;
    }
}
