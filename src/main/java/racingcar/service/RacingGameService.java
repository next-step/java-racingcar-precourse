package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private Cars cars;
    private int tryNo;

    public RacingGameService(String carNames, int tryNo) {
        this.cars = initCars(carNames);
        this.tryNo = tryNo;
    }

    public void play() {
        System.out.println("실행 결과");

        for (int i = 0; i < tryNo; i++) {
            cars.moveCars();

            System.out.println();
        }

        String winnerCarsName  = getWinnerCarsNames(cars.findWinnerCars());

        System.out.println(winnerCarsName + "가 최종 우승했습니다.");
    }

    private String getWinnerCarsNames(List<Car> winnerCars) {
        String names = "";

        for (Car car : winnerCars) {
            Name carName = car.getName();
            names += carName.getName() + ", ";
        }

        return names.substring(0, names.length() - 2);
    }

    private static Cars initCars(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 입력해야됩니다.");
        }

        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            name = name.trim();

            Car car = new Car(name);
            cars.add(car);
        }

        return new Cars(cars);
    }
}
