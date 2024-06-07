package model;

public class Round {

    private int round;

    public Round(int round) {
        validateNaturalNumber(round);
        this.round = round;
    }

    private void validateNaturalNumber(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1 이상이어야 합니다.");
        }
    }
}
