package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final static int START_POINT = 0;
    private final static int MIN_NUMBER = 0;
    private final static int MAX_NUMBER = 9;
    private final static int MOVE_FORWARD = 1;
    private final static int MIN_FORWARD_NUMBER = 4;
    private Name name;
    private int distance = START_POINT;
    private int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);


    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.toString();
    }

    public int move() {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            this.distance += MOVE_FORWARD;
        }
        return this.distance;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
