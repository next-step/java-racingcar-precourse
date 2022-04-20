package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> racingCarList = new ArrayList<>();

    public RacingCarGame(String carNameList) {
        this.createCar(carNameList.split(","));
    }

    private void createCar(String[] carNames){
        for(String carName : carNames){
            racingCarList.add(new Car(carName));
        }
    }
}
