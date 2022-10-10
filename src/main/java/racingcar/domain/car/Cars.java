package racingcar.domain.car;

import racingcar.domain.playStrategy.PlayBehavior;
import racingcar.dto.CarNames;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(CarNames carNames) {
        this.carList = new ArrayList<>();
        initCarList(carNames.getValues());
    }

    private void initCarList(List<String> carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public void go(PlayBehavior playBehavior) {
        for (Car car : carList) {
            car.play(playBehavior.isGo());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
