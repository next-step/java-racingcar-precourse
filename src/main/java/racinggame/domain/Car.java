package racinggame.domain;

import racinggame.common.Constant;

public class Car {

    private final String name;

    private String result;

    private int rank;

    public Car(final String name) {
        this.name = name;
        this.result = Constant.STR_EMPTY;
    }

    public void move(int number) {
        if (number >= 4) {
            this.result += "-";
        }
        if (number < 4) {
            this.result += "";
        }
    }

    public void initial() {
        this.rank = 1;
    }

    public void compare(Car car) {
        if (this.result.length() < car.result.length()) {
            this.rank += 1;
        }
    }

    public String firstRank() {
        if (this.rank == 1) {
            return this.name;
        }
        return Constant.STR_EMPTY;
    }

    public String status() {
        return this.name + " : " + this.result;
    }
}
