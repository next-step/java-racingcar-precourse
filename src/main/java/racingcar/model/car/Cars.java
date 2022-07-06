package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Config;
import racingcar.vo.CarName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private LongestDistance longestDistance;

    public Cars() {
        this.cars = new ArrayList<>();
        this.longestDistance = new LongestDistance();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void createCarList(List<CarName> carNames) {
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void race() {
        cars.forEach(car -> {
            car.setDistance(Randoms.pickNumberInRange(Config.RANDOM_MIN, Config.RANDOM_MAX));
            this.longestDistance.setDistance(car.getDistance());
        });
    }


    public List<Car> getWinnners() {
        List<Car> winner = new LinkedList<>();

        this.cars.forEach(car -> {
            if (car.getDistance() == this.longestDistance.getDistance()) {
                winner.add(car);
            }
        });

        return winner;
    }
}
