package racinggame.domain;

public class AttemptNumber {
    private int number;

    public AttemptNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("1회 이상의 횟수를 입력해주세요.");
        }
        this.number = number;
    }

    public void decrement() {
        number--;
    }

    public boolean isOver() {
        return number < 1;
    }
}
