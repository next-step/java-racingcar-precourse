package racinggame.model;

import racinggame.code.CarConfig;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public void judgeForward(int randomNumber) {
        if (checkNumber(randomNumber))
            this.carPosition.forward();
    }

    public boolean checkNumber(int randomNumber) {
        return randomNumber > CarConfig.ForwardCondition.getValue();
    }

    public CarName getCarName() {
        return carName;
    }

    public String getCarNameStr() {
        return this.carName.getCarName();
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public Integer getCarPositionInt() {
        return this.carPosition.getPosition();
    }

    public Car(Builder builder) {
        this.carName = builder.carName;
        this.carPosition = builder.carPosition;
    }

    public static class Builder {
        private CarName carName;
        private CarPosition carPosition;

        public Builder name(String carName) {
            this.carName = new CarName.Builder()
                    .name(carName)
                    .build();

            return this;
        }

        public Builder position() {
            this.carPosition = new CarPosition();

            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
