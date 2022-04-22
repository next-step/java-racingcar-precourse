package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int CAR_DISTANCE_INIT = 0;
    public static final int RANDOM_NUMBER_RANGE_FROM = 0;
    public static final int RANDOM_NUMBER_RANGE_TO = 9;
    public static final int MOVE_CONDITION = 4;
    public static final int MOVE_UNIT = 1;

    private final Name name;
    private final Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(CAR_DISTANCE_INIT);
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_FROM, RANDOM_NUMBER_RANGE_TO);

        if (MOVE_CONDITION <= randomNumber) {
            distance.add(MOVE_UNIT);
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
