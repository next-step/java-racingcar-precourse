package racingcar.model;

import racingcar.exception.RacingIllegalArgumentException;

import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public Car getCarByIndex(int index) {
        if (index < 0 || this.carList.size() <= index) {
            throw new RacingIllegalArgumentException("가져오려는 차량 LIST의 인덱스가 잘못 되었습니다.");
        }

        return this.carList.get(index);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
