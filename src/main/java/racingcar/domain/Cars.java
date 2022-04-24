package racingcar.domain;

import java.util.ArrayList;

public class Cars extends ArrayList<Car> {
    @Override
    public boolean add(Car car) {
        if (this.contains(car))
            throw new IllegalArgumentException("중복된 이름을 가질 수 없음");
        return super.add(car);
    }

    public void driveAll() {
        for (Car car : this) {
            car.drive();
        }
    }
}
