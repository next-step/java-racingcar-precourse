package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car>{
    public static final int MIN_COUNT_MOVABLE = 4;
    private CarName carName;
    private int position;

    public Car() {
        this.carName = new CarName();
        this.position = 0;
    }

    public Car(String name) throws IllegalArgumentException{
        this.carName = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return this.carName.getName();
    }

    public void move(int moveCount) {
        if(isMovable(moveCount))
            this.position += 1;
    }

    private boolean isMovable(int moveCount) {
        return moveCount >= MIN_COUNT_MOVABLE;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car other) {

        if(this.position > other.getPosition())
            return 1;
        if(this.position < other.getPosition())
            return -1;

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Car))
            return false;
        Car otherCar = (Car)obj;
        return this.getName().equals(otherCar.getName()) && this.getPosition() == otherCar.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
