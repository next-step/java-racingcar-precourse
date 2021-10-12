package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import racinggame.util.ArrayUtils;

public class CarList {
    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void forward() {
        for (Car car : this.carList) {
            car.forward();
        }
    }

    public CarList(Builder builder) {
        this.carList = builder.carList;
    }

    public static class Builder {
        private final List<Car> carList = new ArrayList<>();

        public Builder carList(List<String> inputCarList) {
            ArrayUtils.validateArraySize(inputCarList);
            for (String carName : inputCarList) {
                this.carList.add(new Car.Builder().name(carName).position().build());
            }

            return this;
        }

        public CarList build() {
            return new CarList(this);
        }
    }
}
