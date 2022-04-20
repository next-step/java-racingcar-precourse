package racingcar;

public class Car {

    private int distance;

    public void go(int randomNumber) {
        if (randomNumber > 3) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }
}
