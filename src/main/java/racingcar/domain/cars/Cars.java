package racingcar.domain.cars;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    /**
     * 자동차 객체 생성
     *
     * @param carList cars
     * @return cars
     */
    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    /**
     * Cars 객체 생성 함수
     *
     * @param carNames 이름
     * @return Cars 차동차들
     */
    public static Cars of(String carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames.split(",")) {
            Car newCar = Car.of(CarName.of(name));
            if (!carList.contains(newCar)) carList.add(newCar);
        }
        return new Cars(carList);
    }

    /**
     * 자동차 목록 반환
     *
     * @return car List
     */
    public List<Car> getCars() {
        return this.carList;
    }

    /**
     * 우승자 뽑기
     *
     * @return 우승자
     */
    public List<Car> getWinner() {
        Collections.sort(carList);
        List<Car> winCarList = new ArrayList<>();
        for (Car car : carList) {
            if (carList.get(0).getPosition() == car.getPosition()) winCarList.add(car);
        }
        return winCarList;
    }

    /**
     * 자동차들 움직임
     */
    public void moveCars() {
        for (Car car : carList) {
            car.move();
        }
    }
}
