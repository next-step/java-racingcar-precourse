package racinggame.domain;

public class AttemptNumber {
    private int number;

    public AttemptNumber(int number) {
        this.number = number;
    }

    public void decrement() {
        number--;
    }

    public boolean isOver() {
        return number < 1;
    }
}
