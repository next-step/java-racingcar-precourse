package racingcar.domain;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.mileage() - car2.mileage();
    }
}
