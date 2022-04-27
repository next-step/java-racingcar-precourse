package racingcar.domain.car;

import racingcar.global.config.CarConfig;

public class Car {
    private Name name;
    private Driven driven;

    public Car(String name) {
        this.name = new Name(name);
        this.driven = new Driven();
    }

    public void addDriven(RandomNumber randomNumber) {
        int number = randomNumber.getNumber();
        if (number >= CarConfig.CAR_STOP_STANDARD) {
            driven.addDriven(1);
        }
    }

    public int getDriven() {
        return driven.getDriven();
    }

    public String getName() {
        return name.getName();
    }
}
