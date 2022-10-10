package racingcar.domain;

import static racingcar.domain.constants.ErrorConst.DISTANCE_OUT_OF_RANGE;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move(int distance) {
        if(distance < 0 || distance >= 10)
            throw new IllegalArgumentException(DISTANCE_OUT_OF_RANGE);
        if(distance >= 4)
            this.position += distance;
    }
}
