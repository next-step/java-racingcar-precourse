package racinggame.model;

import racinggame.util.StringValidator;

public class CarName {
    private final String carName;

    public String getCarName() {
        return carName;
    }

    public CarName(Builder builder) {
        this.carName = builder.carName;
    }

    public static class Builder {
        private String carName;

        public Builder name(String carName) {
            StringValidator.validateStringNull(carName);
            StringValidator.validateStringLength(carName);
            
            this.carName = carName;

            return this;
        }

        public CarName build() {
            return new CarName(this);
        }
    }
}
