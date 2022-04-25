package racingcar.model;

public class RacingCar extends Car {
    private int position;

    public RacingCar(String name) {
        super(name);
    }

    public int getPosition() {
        return position;
    }

    public void frontMove() {
        this.position += 1;
    }
}
