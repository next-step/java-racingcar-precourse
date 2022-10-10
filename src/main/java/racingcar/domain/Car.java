package racingcar.domain;

import static racingcar.util.Constans.CAR_DEFAILT_POSITION;

public class Car {
    private final String name;
    private int position = CAR_DEFAILT_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = this.position + position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
