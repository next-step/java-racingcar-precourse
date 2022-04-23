package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final String DOT_RESULT = " : ";
    private static final String DASH = "-";
    private final CarName carName;
    private final Position position;

    public Car(final String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public void advance() {
        this.position.advance();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public String getSnapshot() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(this.carName.getName()).append(DOT_RESULT);
        for (int i = 0; i < this.position.getPosition(); i++) {
            stringBuffer.append(DASH);
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return getCarName().equals(car.getCarName()) && getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), getPosition());
    }
}
