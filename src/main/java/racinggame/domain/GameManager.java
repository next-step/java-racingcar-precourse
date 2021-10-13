package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {

    private Cars cars;

    public GameManager(String[] carNameList) {
        makeRacingCar(carNameList);
    }

    public void startRacing() {
        cars.moveCars();
    }

    private void makeRacingCar(String[] carNameList) {
        List<Car> ragingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            ragingCarList.add(new Car(carName));
        }
        ragingCarList = Collections.unmodifiableList(ragingCarList);
        this.cars = new Cars(ragingCarList);
    }


    public List<Car> getCarList() {
        return cars.getValue();
    }

    public List<Car> getRacingWinners() {
        return cars.getWinner();
    }
}
