package racingcar;

public class Car {
    private int position;

    public boolean move(int num) {
        if (num <= 3) return false;

        position++;
        return true;
    }
}
