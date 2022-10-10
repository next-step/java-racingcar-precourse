package racingcar.domain;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public CarNames(CarName ...carNames) {
        this(Lists.newArrayList(carNames));
    }

    public static CarNames createEmpty() {
        return new CarNames(new ArrayList<>());
    }

    public void add(CarName carName) {
        carNames.add(carName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarNames carNames1 = (CarNames) o;

        return carNames.equals(carNames1.carNames);
    }

    public List<CarName> getList() {
        return carNames;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames);
    }

    @Override
    public String toString() {
        if (carNames.isEmpty()) {
            return "";
        }
        List<String> carNameString = new ArrayList<>();

        for (CarName carName : this.carNames) {
            carNameString.add(carName.toString());
        }

        return String.join(",", carNameString);
    }
}
